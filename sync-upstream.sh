#!/bin/bash
# ============================================================
# Synchronise le dépôt local avec le repo enseignant d'origine.
#
# Détecte automatiquement le nom du TP depuis pom.xml et tire
# les dernières modifications depuis IUTInfoAix-R202/<tp>.
#
# Usage : ./sync-upstream.sh
# ============================================================

set -e

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
cd "$SCRIPT_DIR"

# Détection du nom de TP depuis l'artifactId du pom.xml
TP_NAME=$(grep '<artifactId>' pom.xml | head -1 | sed 's/.*<artifactId>//' | sed 's/<.*//' | tr -d ' ')

if [ -z "$TP_NAME" ]; then
    echo "ERREUR: impossible de détecter l'artifactId dans pom.xml" >&2
    exit 1
fi

UPSTREAM="https://github.com/IUTInfoAix-R202/${TP_NAME}.git"

# Stash automatique si le working tree est dirty
STASHED=false
if ! git diff --quiet 2>/dev/null || ! git diff --cached --quiet 2>/dev/null; then
    echo "Modifications locales détectées — stash automatique..."
    git stash push -m "sync-upstream: sauvegarde avant mise à jour"
    STASHED=true
fi

echo "Synchronisation depuis ${UPSTREAM} (branche main)..."
git pull "$UPSTREAM" main --no-rebase --allow-unrelated-histories

# Restauration du stash
if $STASHED; then
    echo "Restauration de tes modifications locales..."
    if git stash pop; then
        echo "✅ Tes modifications ont été ré-appliquées sans conflit."
    else
        echo "⚠️  Conflit lors du stash pop. Tes modifications sont dans le stash."
        echo "   Lance 'git stash show' pour les voir et 'git stash pop' pour réessayer."
    fi
fi

echo ""
echo "=== Synchronisation terminée ==="
