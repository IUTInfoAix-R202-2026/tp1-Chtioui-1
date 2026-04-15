#!/bin/bash
# ============================================================
# Régénère la section AUTOGRADING de .github/workflows/classroom.yml
# en scannant les paquets d'exercices dans src/test/java/fr/univ_amu/iut/
#
# Utilise les actions GitHub Classroom modernes :
#   - classroom-resources/autograding-command-grader@v1
#   - classroom-resources/autograding-grading-reporter@v1
#
# Convention : un sous-paquet `exerciceN` = un exercice.
# Répartition : 10 pts compilation + 90 pts équirépartis entre
# les exercices détectés (le dernier absorbe le reste).
# Si aucun exercice n'est détecté, la compilation prend 100 pts.
#
# L'action command-grader considère exit code 0 = test réussi, donc
# pas besoin d'expected-output : `./mvnw test` (ou compile) suffit.
#
# Usage: ./update-autograding.sh
# ============================================================

set -e

TEST_ROOT="src/test/java/fr/univ_amu/iut"
CLASSROOM_YML=".github/workflows/classroom.yml"
COMPILE_POINTS=10
TOTAL_EXERCISE_POINTS=90
TIMEOUT_MINUTES=5
TEST_PACKAGE_PREFIX="fr.univ_amu.iut"

START_MARKER="#@@@AUTOGRADING-BEGIN@@@"
END_MARKER="#@@@AUTOGRADING-END@@@"

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
cd "$SCRIPT_DIR"

if [ ! -f "$CLASSROOM_YML" ]; then
    echo "ERREUR: $CLASSROOM_YML introuvable." >&2
    exit 1
fi

# --- Découverte des exercices ---
exercises=()
if [ -d "$TEST_ROOT" ]; then
    while IFS= read -r dir; do
        exercises+=("$(basename "$dir")")
    done < <(find "$TEST_ROOT" -mindepth 1 -maxdepth 1 -type d -name 'exercice*' | sort -V)
fi

num=${#exercises[@]}
echo "Exercices détectés : $num"
for e in "${exercises[@]}"; do echo "  - $e"; done

# --- Calcul des points ---
if [ "$num" -eq 0 ]; then
    compile_points=100
else
    compile_points=$COMPILE_POINTS
    base=$(( TOTAL_EXERCISE_POINTS / num ))
    remainder=$(( TOTAL_EXERCISE_POINTS - base * num ))
fi

# --- Génération du bloc YAML ---
block=$(mktemp)
trap 'rm -f "$block"' EXIT

{
    echo "      ${START_MARKER} (généré par update-autograding.sh, ne pas éditer à la main)"
    echo "      - name: Compilation"
    echo "        id: compilation"
    echo "        uses: classroom-resources/autograding-command-grader@v1"
    echo "        with:"
    echo "          test-name: Compilation"
    echo "          setup-command: \"\""
    echo "          command: ./mvnw -B -q compile"
    echo "          timeout: ${TIMEOUT_MINUTES}"
    echo "          max-score: ${compile_points}"

    runners="compilation"
    env_block="          COMPILATION_RESULTS: \"\${{ steps.compilation.outputs.result }}\""

    for i in "${!exercises[@]}"; do
        name="${exercises[$i]}"
        pts=$base
        [ "$i" -eq $(( num - 1 )) ] && pts=$(( base + remainder ))
        # Sanitize step id : alphanumériques + underscore + tiret seulement
        id_name=$(echo "$name" | tr -c 'a-zA-Z0-9_-' '_' | sed 's/_*$//')
        env_var_name=$(echo "$id_name" | tr '[:lower:]-' '[:upper:]_')

        cmd="xvfb-run --auto-servernum ./mvnw -B test -Dtest='${TEST_PACKAGE_PREFIX}.${name}.*' -Dsurefire.failIfNoSpecifiedTests=false"

        echo ""
        echo "      - name: \"Exercice : ${name}\""
        echo "        id: ${id_name}"
        echo "        uses: classroom-resources/autograding-command-grader@v1"
        echo "        with:"
        echo "          test-name: \"Exercice : ${name}\""
        echo "          setup-command: \"\""
        echo "          command: ${cmd}"
        echo "          timeout: ${TIMEOUT_MINUTES}"
        echo "          max-score: ${pts}"

        runners="${runners},${id_name}"
        env_block="${env_block}"$'\n'"          ${env_var_name}_RESULTS: \"\${{ steps.${id_name}.outputs.result }}\""
    done

    echo ""
    echo "      - name: Autograding Reporter"
    echo "        uses: classroom-resources/autograding-grading-reporter@v1"
    echo "        env:"
    echo "${env_block}"
    echo "        with:"
    echo "          runners: ${runners}"
    echo "      ${END_MARKER}"
} > "$block"

# --- Splice dans classroom.yml entre les marqueurs ---
start_line=$(grep -n "$START_MARKER" "$CLASSROOM_YML" | head -1 | cut -d: -f1)
end_line=$(grep -n "$END_MARKER" "$CLASSROOM_YML" | head -1 | cut -d: -f1)

if [ -z "$start_line" ] || [ -z "$end_line" ]; then
    echo "ERREUR: marqueurs AUTOGRADING absents de ${CLASSROOM_YML}" >&2
    exit 1
fi

{
    head -n "$((start_line - 1))" "$CLASSROOM_YML"
    cat "$block"
    tail -n +"$((end_line + 1))" "$CLASSROOM_YML"
} > "${CLASSROOM_YML}.new"
mv "${CLASSROOM_YML}.new" "$CLASSROOM_YML"

echo ""
echo "=> ${CLASSROOM_YML} mis à jour."
