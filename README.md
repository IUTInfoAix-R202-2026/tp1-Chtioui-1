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

Le TP est découpé en **6 exercices** à faire dans l'ordre. Chaque exercice vit dans son propre sous-paquet `fr.univ_amu.iut.exerciceN/` (code et tests en miroir). Tous les tests sont livrés avec `@Disabled` : tu les actives **un à un** au fil de ta progression (pattern TDD baby steps).

**Boucle de travail pour chaque test** :

1. Lis le TODO dans le fichier Java concerné.
2. Retire l'annotation `@Disabled` du premier test du fichier de test.
3. Lance `./mvnw test` — le test doit échouer (rouge).
4. Écris le **minimum** de code pour faire passer ce test (vert).
5. Commit, puis active le test suivant.

> Un lanceur commun est disponible dans `fr.univ_amu.iut.App`. `./mvnw javafx:run` ouvre une fenêtre avec un bouton par exercice.

---

### Exercice 1 — Première fenêtre

**Objectif** : créer l'application JavaFX la plus simple possible — une fenêtre vide qui s'affiche et se ferme quand tu cliques sur la croix.

**Concepts** :
- `Application` (tu étends cette classe)
- `Stage` (la fenêtre, reçue en paramètre de `start()`)
- `launch()` (appelé depuis `main()` pour démarrer le framework JavaFX)

**Fichier** : [`src/main/java/fr/univ_amu/iut/exercice1/PremiereFenetre.java`](src/main/java/fr/univ_amu/iut/exercice1/PremiereFenetre.java)

**Test** : `laFenetreEstVisible` — vérifie que le `Stage` est bien affiché. **Indice** : il suffit d'appeler une seule méthode de `Stage` dans `start()`. Regarde la Javadoc de `Stage` à la recherche d'une méthode qui "affiche".

---

### Exercice 2 — Stage personnalisé

**Objectif** : personnaliser l'apparence de la fenêtre — titre, dimensions, décoration.

**Concepts** :
- Propriétés de `Stage` : `setTitle`, `setWidth`, `setHeight`, `setResizable`
- Énumération `StageStyle` pour `initStyle`

**Fichier** : [`src/main/java/fr/univ_amu/iut/exercice2/StagePersonnalise.java`](src/main/java/fr/univ_amu/iut/exercice2/StagePersonnalise.java)

**Tests (4, à activer dans l'ordre)** :
1. `leTitreEstDefini` — titre exact `"Ma fenêtre personnalisée"`
2. `lesDimensionsSontDefinies` — largeur 500, hauteur 300
3. `laFenetreNestPasRedimensionnable` — `setResizable(false)`
4. `leStyleEstUndecorated` — `initStyle(StageStyle.UNDECORATED)` (à activer en dernier, c'est le plus subtil)

**Attention** : `initStyle` doit être appelé **avant** `show()`, sinon il lance une exception.

---

### Exercice 3 — Première Scene avec un Label

**Objectif** : sortir de la fenêtre vide. Construire une `Scene` qui contient un `BorderPane` dans lequel un `Label` affiche un message.

**Concepts** :
- `Scene` : le graphe de scène attaché au `Stage`
- `BorderPane` : un conteneur à 5 zones (`setTop`, `setBottom`, `setLeft`, `setRight`, `setCenter`)
- `Label` : un composant qui affiche du texte statique

**Fichier** : [`src/main/java/fr/univ_amu/iut/exercice3/PremiereScene.java`](src/main/java/fr/univ_amu/iut/exercice3/PremiereScene.java)

**Message exact attendu** : `Bonjour, JavaFX !`

**Tests (3)** :
1. `laSceneExiste` — la `Scene` est bien attachée au `Stage`
2. `leLabelEstAffiche` — un `Label` avec le bon texte est visible
3. `leLabelEstAuCentreDuBorderPane` — la racine est bien un `BorderPane` et le label est au centre

**Schéma** :

```
Stage
 └── Scene
      └── BorderPane (root)
           └── center : Label("Bonjour, JavaFX !")
```

---

### Exercice 4 — Mise en page d'un formulaire

**Objectif** : apprendre à combiner plusieurs conteneurs pour reproduire une maquette réaliste. C'est l'exercice qui te force à réfléchir à la **décomposition** d'une IHM en zones.

**Maquette à reproduire** :

```
┌───────────────────────────────┐
│ [Fichier] [Aide]              │  ← MenuBar
├───────────────────────────────┤
│ Nom :     [__________]        │  ┐
│ Email :   [__________]        │  │ GridPane (2 × 2)
│                               │  ┘
│ [  Valider  ]  [ Annuler ]    │  ← HBox
└───────────────────────────────┘
```

**Concepts** :
- `BorderPane` comme **squelette** de l'application
- `MenuBar` + `Menu` (menus déroulants — ici vides, pas d'action)
- `GridPane` pour la grille de saisie (2 colonnes, 2 lignes)
- `HBox` pour aligner les boutons horizontalement

**Pourquoi ces conteneurs et pas d'autres ?**

| Conteneur | Quand l'utiliser |
|---|---|
| `BorderPane` | Tu as 5 zones distinctes (top/left/right/bottom/center) |
| `VBox` | Empiler des composants verticalement à la suite |
| `HBox` | Aligner des composants horizontalement à la suite |
| `GridPane` | Tu as une **grille** (lignes × colonnes) avec alignement strict |
| `StackPane` | Superposer des composants |
| `Pane` | Positionnement absolu (rarement utilisé pour une IHM réelle) |

**Fichier** : [`src/main/java/fr/univ_amu/iut/exercice4/MiseEnPage.java`](src/main/java/fr/univ_amu/iut/exercice4/MiseEnPage.java)

**Tests (4)** :
1. `leRootEstUnBorderPane` — la racine est bien un `BorderPane`
2. `leMenuBarEstEnHaut` — `borderPane.getTop()` est un `MenuBar`
3. `lesDeuxChampsDeSaisieExistent` — au moins 2 `TextField` dans la scène
4. `lesBoutonsValiderEtAnnulerExistent` — deux boutons avec les textes exacts `Valider` et `Annuler`

---

### Exercice 5 — Réagir à un clic

**Objectif** : découvrir comment un composant JavaFX **réagit** à une action utilisateur. Tu vas brancher un écouteur sur un `Button` et voir qu'un clic peut modifier l'état de l'application (ici, un compteur).

**Structure de l'exercice** :

```
exercice5/
├── Compteur.java              ← fourni (tu n'y touches pas)
├── EcouteurClasseNommee.java  ← tu implémentes handle()
└── EvenementsBouton.java      ← tu construis l'IHM + branches l'écouteur
```

**Trois styles d'écouteur, tous équivalents** :

JavaFX accepte trois écritures différentes pour définir ce qui se passe quand un bouton est cliqué. Elles produisent le même résultat, mais n'ont pas la même verbosité. La classe [`EvenementsBouton`](src/main/java/fr/univ_amu/iut/exercice5/EvenementsBouton.java) les montre toutes les trois en commentaires — tu en actives une, tu vérifies que ça marche, tu peux essayer les autres.

**Style 1 — classe nommée** (style historique, avant Java 8) :
```java
bouton.setOnAction(new EcouteurClasseNommee(compteur));
```
C'est l'écouteur qui est dans son propre fichier. Le plus verbeux mais aussi le plus explicite.

**Style 2 — classe anonyme** (intermédiaire) :
```java
bouton.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent e) {
        compteur.incrementer();
        labelCompteur.setText(compteur.getValeur() + " clics");
    }
});
```
Tu définis la classe sur place, sans lui donner de nom.

**Style 3 — lambda** (moderne, recommandé depuis Java 8) :
```java
bouton.setOnAction(e -> {
    compteur.incrementer();
    labelCompteur.setText(compteur.getValeur() + " clics");
});
```
La syntaxe la plus compacte. C'est celle que tu verras le plus souvent dans du code JavaFX moderne.

**Tests (2)** :
1. `EcouteurClasseNommeeTest.handleIncrementeLeCompteur` — **test unitaire** (pas de TestFX). Vérifie que la méthode `handle()` de ta classe nommée incrémente bien le `Compteur`. Active-le et implémente le TODO dans `EcouteurClasseNommee.java`.
2. `EvenementsBoutonTest.troisClicsAffichent3Clics` — **test d'intégration**. Clique 3 fois sur le bouton et vérifie que le label affiche `"3 clics"`. Active-le, implémente le TODO dans `EvenementsBouton.java` avec le style de ton choix.

**Ids attendus** : `bouton-clique-moi` pour le bouton, `compteur` pour le label.

---

### Exercice 6 — Palette de couleurs (capstone)

**Objectif** : **synthèse** — tu mobilises tout ce que tu as vu jusqu'ici (layouts, composants, événements, mise à jour de label) sur une petite application autonome.

**Comportement attendu** :

```
┌──────────────────────────────┐
│ [Rouge] [Vert] [Bleu]        │  ← HBox de 3 boutons
├──────────────────────────────┤
│                              │
│     (zone de couleur)        │  ← Pane dont le fond change
│                              │
├──────────────────────────────┤
│ Rouge: 0  Vert: 0  Bleu: 0   │  ← Label récapitulatif
└──────────────────────────────┘
```

- Cliquer **Rouge** → le fond du `Pane` central devient rouge, et le compteur Rouge du label augmente de 1
- Même principe pour Vert et Bleu
- Les 3 compteurs sont **indépendants** : cliquer Rouge n'affecte pas les compteurs Vert et Bleu

**Ids attendus** :
- `btn-rouge`, `btn-vert`, `btn-bleu` pour les 3 boutons
- `zone` pour le `Pane` central
- `compteurs` pour le label du bas

**Format du label** : le test vérifie la présence des sous-chaînes `Rouge: N`, `Vert: N`, `Bleu: N`. Tu peux choisir le séparateur que tu veux (espaces, tirets, virgules…).

**Changer la couleur de fond d'un `Pane`** : utilise `setStyle("-fx-background-color: red;")` (ou `green`, `blue`).

**Fichier** : [`src/main/java/fr/univ_amu/iut/exercice6/Palette.java`](src/main/java/fr/univ_amu/iut/exercice6/Palette.java)

**Tests (4, à activer dans l'ordre)** :
1. `lesTroisBoutonsExistent` — les 3 boutons avec les bons ids sont présents
2. `cliquerRougeMetLaZoneEnRouge` — le style du `Pane` contient `red` après un clic sur Rouge
3. `cliquerIncremenceLeCompteurCorrespondant` — deux clics sur Vert → label contient `Vert: 2`
4. `lesCompteursSontIndependants` — séquence 2×Rouge + 1×Bleu → label contient `Rouge: 2`, `Vert: 0`, `Bleu: 1`

Quand tu as les 4 tests verts, tu as terminé le TP1. Bravo 🎉

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
