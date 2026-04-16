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

echo "Synchronisation depuis ${UPSTREAM} (branche main)..."
git pull "$UPSTREAM" main --allow-unrelated-histories

echo ""
echo "=== Synchronisation terminée ==="
