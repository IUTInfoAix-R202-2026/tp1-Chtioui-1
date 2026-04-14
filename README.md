# TP1 - Bases JavaFX

## R2.02 - Développement d'applications avec IHM

* **Auteur:** [Sébastien NEDJAR](mailto:sebastien.nedjar@univ-amu.fr)
* **Besoin d'aide ?**
    * Consulter et/ou créer des [issues](https://github.com/IUTInfoAix-R202/tp1/issues)
    * [Email](mailto:sebastien.nedjar@univ-amu.fr) pour toute question

## Aperçu et objectifs d'apprentissage

Premiers pas avec JavaFX : Application, Stage, Scene, composants simples, événements et layouts

### Prérequis

- Java 25 (JDK avec JavaFX inclus, ex: Zulu JDK FX)
- Maven : non requis, le projet embarque un Maven Wrapper (`./mvnw`) qui télécharge automatiquement la bonne version
- Un IDE (IntelliJ IDEA, VS Code avec Extension Pack for Java, Eclipse)

<details>
<summary>📦 Installer Java 25 localement — cliquer pour déplier</summary>

**Le plus simple : pas d'installation du tout.** Utilise [GitHub Codespaces](#github-codespaces-recommandé) ou le devcontainer local : tout est déjà prêt.

**Sur les machines de l'IUT** (Linux, SDKMAN pré-installé) :

```bash
sdk install java 25.fx-zulu
```

**Chez toi sous Linux / macOS** — installer d'abord SDKMAN depuis [sdkman.io](https://sdkman.io), puis la commande ci-dessus.

**Windows** — via [Scoop](https://scoop.sh) :

```powershell
scoop bucket add java
scoop install java/zulu-jdk-fx25
```

Alternative Windows : installateur GUI sur [azul.com/downloads](https://www.azul.com/downloads/?package=jdk-fx&version=25).

**Vérifier l'installation** :

```bash
java -version
# doit afficher "openjdk version \"25.0.x\"" ou similaire
```

</details>

### Documentation de référence

- [JavaFX 25 API Documentation](https://openjfx.io/javadoc/25/)
- [Java 25 API Documentation](https://docs.oracle.com/en/java/javase/25/docs/api/)

---

## Mise en place

### Fork du dépôt

Créez votre fork via GitHub Classroom :

👉 **https://classroom.github.com/a/XXXXXX**

GitHub créera automatiquement un dépôt `IUTInfoAix-R202/tp1-votreUsername`.

### Import dans votre IDE

#### IntelliJ IDEA
1. File → New → Project from Version Control
2. Collez l'URL de votre fork
3. Attendez l'indexation Maven
4. **Lancer l'application** : panneau Maven (barre latérale droite) → `Plugins → javafx → javafx:run` (double-clic). Une configuration "Lancer l'application" est aussi pré-câblée dans le menu Run/Debug.
5. **Lancer les tests** : clic droit sur `src/test/java` → `Run 'All Tests'`

#### VS Code
1. Clonez le dépôt : `git clone <url-de-votre-fork>`
2. Ouvrez le dossier dans VS Code
3. Acceptez l'installation des extensions recommandées (bandeau qui apparaît)
4. **Lancer l'application** : `F5` (configuration "JavaFX : lancer l'application" pré-câblée)
5. **Compiler / build** : `Ctrl+Shift+B` (tâche "Build complet" par défaut)
6. **Lancer les tests** : panneau Testing dans la barre latérale, ou `Ctrl+Shift+P → Tasks: Run Test Task`

#### GitHub Codespaces (recommandé)
1. Sur votre fork GitHub, cliquez sur "Code" → "Codespaces"
2. Créez un nouveau Codespace
3. L'environnement est prêt avec Java 25 + JavaFX

> **Note** : le Codespace embarque un display virtuel via le feature `desktop-lite` (VNC sur le port 6080), donc `./mvnw test` et `./mvnw javafx:run` fonctionnent directement. Si vous désactivez `desktop-lite` pour un container plus léger, lancez plutôt `xvfb-run ./mvnw test`.

---

## Commandes essentielles

| Commande | Effet |
|----------|-------|
| `./mvnw javafx:run` | Lance l'application JavaFX |
| `./mvnw test` | Exécute les tests unitaires |
| `./mvnw verify` | Compile, teste et valide tout le projet |
| `./mvnw clean` | Supprime les artefacts (`target/`) |
| `./mvnw spotless:apply` | Formate le code Java (Google Java Style) |

> Sous Windows, remplacez `./mvnw` par `mvnw.cmd`.
>
> Le code est aussi formaté **automatiquement** avant chaque commit via un hook pre-commit invisible. Pas besoin de lancer `spotless:apply` à la main, sauf si tu veux vérifier visuellement avant de commit.

---

## Workflow de développement

Pour chaque exercice, suivez ce cycle :

1. **Lire** l'énoncé de l'exercice
2. **Activer** les tests correspondants (supprimer `@Disabled`)
3. **Implémenter** le code pour faire passer les tests
4. **Vérifier** localement : `./mvnw verify`
5. **Lancer l'application** : `./mvnw javafx:run`
6. **Commit** : `git add . && git commit -m "Exercice N terminé"`
7. **Push** : `git push`

Vérifiez que les tests passent sur GitHub Actions (badge vert).

---

## Exercices

### Exercice 1

À compléter...

---

## Ressources complémentaires

- [OpenJFX - Getting Started](https://openjfx.io/openjfx-docs/)
- [JavaFX Tutorial](https://code.makery.ch/library/javafx-tutorial/)
- [TestFX Documentation](https://github.com/TestFX/TestFX)

---

## Dépannage

**Le premier `./mvnw` prend plusieurs minutes** — normal. Le wrapper télécharge Maven 3.9.14 puis toutes les dépendances JavaFX / JUnit / TestFX (~50 Mo au total). Les runs suivants utilisent le cache local et sont quasi instantanés.

**`./mvnw: Permission denied`** — après certains clones, le bit exécutable est perdu. Corrige avec :
```bash
chmod +x mvnw
```

**`java: command not found` ou version < 25** — voir la section [Prérequis](#prérequis) ci-dessus pour installer Java 25. Vérifie ensuite avec `java -version`.

**Tests TestFX qui plantent avec `No X11 DISPLAY`** (Linux sans serveur X actif) — lance les tests via `xvfb-run` :
```bash
xvfb-run --auto-servernum ./mvnw test
```
Ou plus simple : travaille dans le Codespace / devcontainer, qui embarque déjà un display virtuel.

**Sous Windows, `./mvnw ...` ne marche pas** — utilise `mvnw.cmd` à la place :
```powershell
.\mvnw.cmd javafx:run
```

---

*IUT d'Aix-Marseille - Département Informatique - 2026*
