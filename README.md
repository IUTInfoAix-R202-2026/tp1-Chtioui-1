[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-2972f46106e565e64193e422d61a12cf1da4916b45550586e14ef0a7c637dd04.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=23674253)
# <img src="https://raw.githubusercontent.com/IUTInfoAix-R510/Syllabus/main/assets/logo.png" alt="class logo" class="logo"/> R2.02 - Développement d'applications avec IHM

### IUT d’Aix-Marseille – Département Informatique Aix-en-Provence

* **Ressource:** [R2.02](https://cache.media.enseignementsup-recherche.gouv.fr/file/SPE4-MESRI-17-6-2021/35/5/Annexe_17_INFO_BUT_annee_1_1411355.pdf)

* **Responsables:**

  * [Sébastien Nedjar](mailto:sebastien.nedjar@univ-amu.fr)

* **Enseignants :**

  * [Frédéric Flouvat](mailto:frederic.flouvat@univ-amu.fr)
  * [Sophie Nabitz](mailto:sophie.nabitz@univ-avignon.fr)
  * [Samir Chtioui](mailto:samir.chtioui@gmail.com)


* **Besoin d'aide ?**
    * Consulter et/ou créer des [issues](https://github.com/IUTInfoAix-R202/tp1/issues)
    * [Email](mailto:sebastien.nedjar@univ-amu.fr) pour toute question


## TP1 - Bases JavaFX

## Objectifs de la séance

### Ce que vous saurez faire à la fin de cette séance

Les exercices de ce TP sont organisés en progression : chaque exercice vous fait monter d'un cran dans la maîtrise de JavaFX. Cette progression suit la **taxonomie de Bloom**, un modèle pédagogique qui décrit les niveaux de maîtrise d'un savoir-faire - du plus simple (comprendre un concept) au plus complexe (créer une application complète).

| Niveau Bloom | Exercices | Vous serez capable de… | Compétence BUT |
|---|---|---|---|
| **Comprendre** | 1–2 | Expliquer le rôle de `Application`, `Stage` et du cycle de lancement JavaFX. Personnaliser une fenêtre (titre, dimensions, style). | C1 AC2 |
| **Appliquer** | 3–4 | Construire une interface graphique en combinant conteneurs (`BorderPane`, `GridPane`, `HBox`) et composants (`Label`, `TextField`, `MenuBar`). | C1 AC4 |
| **Analyser / Créer** | 5–6 | Concevoir une application interactive complète avec écouteurs d'événements, compteurs indépendants et feedback visuel. | C1 AC4, C5 AC1 |

**Tout au long du TP**, vous développerez également votre maîtrise de l'écosystème de développement (**C6 AC1**) : GitHub Classroom, Codespace, Maven, et le workflow professionnel branche → Pull Request → review.

### Pourquoi cette démarche ?

Ce TP utilise le **TDD (Test-Driven Development) en baby steps** : les tests sont livrés désactivés (`@Disabled`) et vous les activez un par un, comme un cahier des charges dont on implémente les exigences une à une. Ce n'est pas un artifice pédagogique : c'est une **méthode de développement professionnel** (formalisée par Kent Beck dans l'Extreme Programming) utilisée dans l'industrie logicielle.

Le workflow Git que vous pratiquerez - créer une branche par exercice, pousser, ouvrir une Pull Request, recevoir une review automatique de Copilot, puis merger - reproduit le **cycle de travail en entreprise**. L'objectif est d'apprendre à collaborer avec des outils, pas seulement à écrire du code.

Copilot Chat est configuré dans ce projet comme un **tuteur** : il ne donnera pas la solution d'emblée. Il commence par expliquer le concept, puis oriente vers la documentation, et ne propose du code qu'en dernier recours. L'objectif est que vous compreniez chaque ligne de code que vous écrivez.

### Lien avec la SAE 2.01

La SAE 2.01 vous demandera de **créer une interface d'extraction et manipulation de données** pour des capteurs permettant de **détecter et identifier les chauve-souris** à partir de leurs émissions ultrasonores.

Pour construire cette interface, vous aurez besoin de compétences acquises progressivement dans les TP du module R2.02 :

- **TP1** (celui-ci) : fenêtres, scènes, composants de base et événements, les **fondations**
- **TP2** : properties et bindings, la **liaison de données** entre l'interface et le modèle
- **TP3** : FXML, la **conception déclarative** d'interfaces complexes
- **TP4** : architecture MVVM, la **séparation des responsabilités** entre vue et logique
- **TP5** : persistance, la **lecture et écriture de données** (fichiers, bases de données)

Ce TP1 pose les premières briques : créer une fenêtre, organiser des composants dans un layout, et réagir aux actions de l'utilisateur. Ces compétences seront vos outils quotidiens jusqu'à la SAE.

### Prérequis

#### Connaissances attendues

- **Bases de la programmation** : variables, types, structures de contrôle, tableaux (acquis en C++ dans la ressource R1.01)
- **Programmation orientée objet en Java** : classes, objets, héritage, interfaces, polymorphisme (acquis dans la ressource R2.01)
- **Git** : les concepts (dépôt, commit, branche) ont été vus en cours, mais pas encore réellement pratiqués. Un TP dédié en R2.03 est prévu en parallèle. Ce TP servira de première mise en pratique réelle du workflow Git, guidée par Copilot Chat

#### Environnement technique

L'ensemble du TP se fait sur **GitHub Codespaces** : aucune installation locale n'est nécessaire. L'environnement (Java 25, JavaFX 25, Maven, Git, Copilot Chat) est pré-configuré et prêt à l'emploi dès l'ouverture du Codespace.

> [!NOTE]
> Pour une installation locale (facultative), voir la section [Dépannage](#dépannage) en fin de document.

### Documentation de référence

- [JavaFX 25 API Documentation](https://openjfx.io/javadoc/25/)
- [Java 25 API Documentation](https://docs.oracle.com/en/java/javase/25/docs/api/)

---

## Mise en place

La mise en place se fait en deux étapes : accepter le devoir sur GitHub Classroom (qui crée votre dépôt personnel), puis ouvrir ce dépôt dans un Codespace (votre environnement de développement dans le navigateur).

### Étape 1 - Accepter le devoir sur GitHub Classroom

1. Cliquez sur le lien suivant :

   👉 **https://classroom.github.com/a/9gAbmj0v**

2. Si c'est votre première utilisation de GitHub Classroom, autorisez l'accès à votre compte GitHub.
3. Sélectionnez votre nom dans la liste des étudiants (si elle apparaît) pour associer votre compte GitHub à votre identité dans le cours.
4. Cliquez sur **"Accept this assignment"**.
5. Attendez quelques secondes - GitHub crée automatiquement un dépôt à votre nom : `IUTInfoAix-R202-2026/tp1-votreLogin`.
6. Cliquez sur le lien du dépôt créé pour y accéder.

### Étape 2 - Ouvrir le projet dans GitHub Codespaces

Une fois sur la page de votre dépôt :

1. Cliquez sur le bouton vert **"Code"** (en haut à droite du listing de fichiers).
2. Sélectionnez l'onglet **"Codespaces"**.
3. Cliquez sur **"Create codespace on main"**.

<img src="src/main/resources/assets/create_codespace_on_main.png" alt="Bouton Code → Codespaces → Create codespace on main" width="400"/>
4. Attendez que l'environnement se construise (de 1 à 5 minutes la première fois).
5. VS Code s'ouvre **dans votre navigateur** avec tout l'environnement pré-configuré :
  - Java 25 + JavaFX 25
  - Maven (via le wrapper `./mvnw`)
  - Git
  - Copilot Chat (votre assistant IA pédagogique)
  - Toutes les extensions nécessaires

![VS Code dans le navigateur après ouverture du Codespace](src/main/resources/assets/codespace_vscode.png)

> [!IMPORTANT]
> Le Codespace est **personnel et persistant**. Quand vous fermez l'onglet, votre travail est sauvegardé. Pour reprendre, retournez sur votre dépôt GitHub → **"Code"** → **"Codespaces"** → cliquez sur le Codespace existant (ne créez pas un nouveau à chaque fois).

### Vérification rapide

Une fois le Codespace ouvert, ouvrez un terminal via le menu **Terminal → New Terminal** :

![Menu Terminal → New Terminal](src/main/resources/assets/codespace_vscode_nouveau_terminal.png)

Puis lancez :

```bash
./mvnw test
```

Vous devriez voir un résultat du type :
```
Tests run: 41, Failures: 0, Errors: 0, Skipped: 40
BUILD SUCCESS
```

Si c'est le cas, tout est prêt. Le seul test actif (`AppTest`) passe, et les 40 tests d'exercices sont en attente (`Skipped`) - c'est normal, ils seront activés au fil de votre progression.

---

## Rendu du travail et évaluation

### Comment vous êtes évalués

L'évaluation de ce TP est **entièrement automatique** : à chaque fois que vous poussez (`push`) votre code sur GitHub, un système d'autograding exécute tous vos tests et calcule une note sur 100 points.

- **10 points** sont attribués si le projet **compile** correctement
- **90 points** sont répartis entre les différents **tests des exercices** (chaque test vaut un certain nombre de points)
- Un test `@Disabled` (non encore activé) rapporte **0 point** - c'est normal
- Un test activé et **qui passe** rapporte ses points
- Un test activé et **qui échoue** rapporte 0 point

Votre note augmente progressivement au fil de votre avancement. Il n'y a pas de date limite brutale : chaque push met à jour votre score.

### Consulter votre note actuelle

Après chaque `push`, rendez-vous sur la page de votre dépôt GitHub → onglet **"Actions"** → dernier run du workflow **"GitHub Classroom Workflow"**. Le score apparaît dans le résumé :

```
Points 25/100
```

Vous pouvez aussi voir le détail test par test pour savoir exactement quels exercices sont validés et lesquels restent à faire.

### Commandes essentielles

**Maven** est un outil de construction de projets Java utilisé dans la majorité des projets professionnels. Il gère automatiquement la compilation du code, le téléchargement des bibliothèques nécessaires (JavaFX, JUnit, TestFX…), l'exécution des tests et le packaging de l'application. Plutôt que de lancer `javac` et `java` à la main avec des dizaines d'options, une seule commande Maven suffit.

Dans ce projet, Maven est embarqué via un **Maven Wrapper** (`./mvnw`) : un script qui télécharge et utilise automatiquement la bonne version de Maven. Aucune installation n'est nécessaire : la première exécution prend quelques secondes de plus (téléchargement), puis tout est instantané.

| Commande | Effet |
|----------|-------|
| `./mvnw javafx:run` | Lance l'application JavaFX |
| `./mvnw test` | Exécute les tests unitaires |
| `./mvnw verify` | Compile, teste et valide tout le projet |
| `./mvnw clean` | Supprime les artefacts (`target/`) |
| `./mvnw spotless:apply` | Formate le code Java (Google Java Style) |

> [!NOTE]
> Le code est aussi formaté **automatiquement** avant chaque commit via un hook pre-commit invisible. Il n'est pas nécessaire de lancer `spotless:apply` à la main, sauf pour vérifier visuellement le formatage avant un commit.

### Workflow de développement - un cycle par exercice

Chaque exercice suit le même cycle. Cette démarche structurée vous aide à travailler de manière **méthodique et professionnelle** : c'est exactement le workflow que vous utiliserez en entreprise.

**1. Créer une branche pour l'exercice**

```bash
git checkout -b exerciceN
```

**2. Activer le premier test** - ouvrez le fichier de test correspondant et retirez l'annotation `@Disabled` du premier test.

**3. Vérifier que le test est rouge**

```bash
./mvnw test
```

Le test doit échouer - c'est normal et attendu. Le message d'erreur vous indique ce que le test attend.

**4. Implémenter le minimum** pour faire passer ce test au vert. Pas plus que nécessaire.

**5. Vérifier que le test passe**

```bash
./mvnw verify
```

**6. Lancer l'application** pour voir le résultat visuellement :

```bash
./mvnw javafx:run
```

Ou via `Ctrl+Shift+B` dans VS Code.

**7. Recommencer** - activez le test suivant (étapes 2 à 6) jusqu'à ce que tous les tests de l'exercice soient verts.

**8. Finaliser l'exercice** - quand tous les tests passent :

```bash
git add .
git commit -m "Exercice N terminé"
git push -u origin exerciceN
```

**9. Créer une Pull Request** pour voir votre travail et recevoir une review automatique :

```bash
gh pr create --title "Exercice N terminé" --body "Tous les tests passent."
```

Ouvrez la PR dans le navigateur (`gh pr view --web`) pour consulter le diff, les checks CI, le score autograding et les commentaires de la review Copilot.

**10. Merger et passer à la suite** :

```bash
gh pr merge --rebase --delete-branch
git checkout main
git pull
```

Votre score sur GitHub Actions augmente à chaque exercice terminé. Vous pouvez maintenant passer à l'exercice suivant en reprenant à l'étape 1.

> [!TIP]
> **Copilot Chat** est là pour vous accompagner à chaque étape. N'hésitez pas à lui poser des questions - il vous guidera sans donner la solution directement.

---

## Assistance IA

Vous avez le droit d'utiliser **Copilot Chat** (panneau latéral dans VS Code) quand vous bloquez sur un exercice. Il est configuré spécifiquement pour ce TP : il ne donnera pas la solution directement, mais vous guidera par étapes : d'abord une explication du concept, puis un pointeur vers la documentation, et seulement en dernier recours un minimum de code.

**Copilot Chat n'est pas un raccourci, c'est un tuteur.** Il vous aide à comprendre, pas à copier-coller. L'objectif est que vous soyez capable d'écrire ce code **seul(e)** à la fin de la séance.

**Pourquoi c'est important** : l'évaluation de ce module se fera **sur papier, sans aucun outil d'assistance**. Il est donc essentiel que vous construisiez vos automatismes en écrivant le code vous-même. Copilot Chat est un filet de sécurité pour débloquer, pas un substitut à la réflexion.

**Conseil pratique** : sur les premiers exercices (1–3), n'hésitez pas à demander de l'aide pour vous familiariser avec JavaFX et le workflow. Sur les exercices avancés (4–6), essayez d'aller le plus loin possible par vous-même avant de solliciter l'assistant. C'est cette progression vers l'autonomie qui vous préparera le mieux aux évaluations.

Le TP est découpé en **6 exercices** à faire dans l'ordre. Chaque exercice vit dans son propre sous-paquet `fr.univ_amu.iut.exerciceN/` (code et tests en miroir). L'exercice 1 est très guidé pas à pas pour vous familiariser avec l'environnement. À partir de l'exercice 2, une boucle de travail systématique est introduite que vous appliquerez pour tous les exercices suivants.

---

## Exercice 1 - Première fenêtre

**Objectif** : créer l'application JavaFX la plus simple possible, une fenêtre vide qui apparaît à l'écran.

**Ce que vous allez découvrir** :
- La classe [`Application`](https://openjfx.io/javadoc/25/javafx.graphics/javafx/application/Application.html) : le point d'entrée de toute application JavaFX
- Le [`Stage`](https://openjfx.io/javadoc/25/javafx.graphics/javafx/stage/Stage.html) : l'objet qui représente la fenêtre
- La méthode `start(Stage)` : appelée automatiquement par JavaFX au lancement

### Découverte du code

1. Dans l'explorateur de fichiers (panneau gauche de VS Code), naviguez vers :
   ```
   src/main/java/fr/univ_amu/iut/exercice1/PremiereFenetre.java
   ```

2. Ouvrez ce fichier. Vous voyez une classe qui **étend `Application`** avec une méthode `start(Stage primaryStage)` qui contient un commentaire TODO :
   ```java
   public class PremiereFenetre extends Application {
       @Override
       public void start(Stage primaryStage) {
           // TODO exercice 1 : rendre la fenêtre visible.
       }
   }
   ```

3. Ouvrez maintenant le fichier de test correspondant :
   ```
   src/test/java/fr/univ_amu/iut/exercice1/PremiereFenetreTest.java
   ```

4. Vous voyez un test `laFenetreEstVisible` avec l'annotation `@Disabled`. Ce test vérifie que `stage.isShowing()` retourne `true`, autrement dit que la fenêtre est bien affichée à l'écran.

### Travail à faire

#### Étape 1 - Créer une branche Git pour cet exercice

Ouvrez un terminal dans VS Code (menu **Terminal → New Terminal**) et exécutez :

```bash
git checkout -b exercice1
```

Vérifiez que vous êtes bien sur la branche :

```bash
git branch --show-current
```

Le résultat doit afficher `exercice1`.

#### Étape 2 - Activer le test

Dans le fichier `PremiereFenetreTest.java`, supprimez (ou commentez) la ligne :

```java
@Disabled("Retire cette annotation pour activer le test")
```

Sauvegardez le fichier (`Ctrl+S`).

#### Étape 3 - Vérifier que le test est rouge

Dans le terminal, lancez :

```bash
./mvnw test
```

Vous devriez voir un message d'erreur indiquant que le test `laFenetreEstVisible` a **échoué**. C'est normal et attendu : le test vérifie que la fenêtre est visible, mais votre méthode `start()` ne fait rien pour l'instant.

#### Étape 4 - Implémenter la solution

Retournez dans `PremiereFenetre.java`. Le `Stage` reçu en paramètre de `start()` représente la fenêtre principale. Pour l'afficher, il suffit d'appeler une seule méthode.

**Indice** : consultez la [Javadoc de Stage](https://openjfx.io/javadoc/25/javafx.graphics/javafx/stage/Stage.html) et cherchez une méthode héritée qui rend la fenêtre visible.

#### Étape 5 - Vérifier que le test passe

```bash
./mvnw test
```

Le test `laFenetreEstVisible` doit maintenant être **vert**. Si c'est le cas, félicitations : vous venez d'écrire votre première application JavaFX !

#### Étape 6 - Pousser, créer une Pull Request et merger

Votre premier exercice est terminé. Il est temps de sauvegarder votre travail et de pratiquer le workflow Git que vous utiliserez pour chaque exercice.

Commencez par commiter vos modifications :

```bash
git add .
git commit -m "Exercice 1 terminé"
```

Poussez votre branche sur GitHub :

```bash
git push -u origin exercice1
```

Créez une Pull Request pour que votre travail soit visible sur GitHub :

```bash
gh pr create --title "Exercice 1 terminé" --body "Le test laFenetreEstVisible passe."
```

Ouvrez la Pull Request dans votre navigateur pour voir le résultat :

```bash
gh pr view --web
```

Sur la page de la PR, prenez le temps d'observer :
- Le **diff** : le code que vous avez ajouté (en vert) par rapport au code d'origine
- Les **checks CI** : la compilation et les tests s'exécutent automatiquement
- La **review Copilot** : si elle est activée, Copilot analyse votre code et laisse des commentaires. Lisez-les, c'est un retour gratuit sur la qualité de votre code.

Quand vous avez consulté la PR, mergez-la et revenez sur `main` :

```bash
gh pr merge --rebase --delete-branch
git checkout main
git pull
```

Votre exercice 1 est maintenant intégré dans `main`.

Vérifiez que votre note a augmenté : rendez-vous sur votre dépôt GitHub → onglet **"Actions"** → dernier run du workflow **"GitHub Classroom Workflow"**. Votre score devrait être passé de 10/100 à 25/100 (10 points de compilation + 15 points pour l'exercice 1).

### Voir votre fenêtre avec VNC

Les tests vérifient le comportement de votre code automatiquement, mais il est aussi possible de **voir votre application s'afficher** dans un navigateur.

Le Codespace embarque un affichage graphique virtuel accessible via **VNC**. Pour y accéder :

1. Dans VS Code, cliquez sur l'onglet **"Ports"** (en bas, à côté du terminal).
2. Repérez le port **6080** (labellé "desktop" ou "VNC").
3. Cliquez sur l'icône 🌐 (globe) à droite du port 6080 pour l'ouvrir dans un nouvel onglet du navigateur.
4. Dans le nouvel onglet, cliquez sur le bouton "🔗 Connecter"
5. Un bureau virtuel s'affiche. Laissez cet onglet ouvert.

![Onglet Ports dans VS Code - cliquez sur l'icône globe du port 6080](src/main/resources/assets/codespace_onglet_port.png)

Maintenant, lancez votre application :

```bash
./mvnw javafx:run
```

Dans l'onglet VNC, vous verrez apparaître la fenêtre du **lanceur** (`App.java`).

### Le lanceur `App.java`

Le fichier `App.java` (dans `src/main/java/fr/univ_amu/iut/`) est un **menu principal** qui liste tous les exercices du TP. Il affiche une fenêtre avec un bouton par exercice :

![Le lanceur App.java dans le VNC - un bouton par exercice](src/main/resources/assets/vnc_lanceur_app.png)

- Cliquez sur **"Exercice 1 - Première fenêtre"** : votre fenêtre vide s'ouvre (si vous avez bien implémenté `show()`).
- Si vous cliquez sur un exercice que vous n'avez pas encore implémenté, une popup vous indiquera "rien à afficher", c'est normal.

Le lanceur est un outil pratique pour **tester visuellement** chaque exercice au fil de votre progression. Vous pouvez aussi lancer directement un exercice en faisant clic droit sur sa classe → **Run** dans VS Code.

Pour fermer l'application, fermez la fenêtre JavaFX ou appuyez sur `Ctrl+C` dans le terminal.

### Essayer Copilot Chat

C'est le bon moment pour découvrir votre assistant IA. Ouvrez le panneau **Copilot Chat** (icône dans la barre latérale gauche) et essayez quelques questions simples pour vous familiariser :

- `Qu'est-ce qu'un Stage dans JavaFX ?`
- `Explique-moi la différence entre Stage et Scene`
- `À quoi sert la méthode launch() dans une Application JavaFX ?`
- `Pourquoi mon test laFenetreEstVisible vérifie isShowing() ?`

Observez comment Copilot répond : il explique le concept sans donner directement du code. Si vous insistez, il vous orientera vers la Javadoc, puis seulement en dernier recours proposera un minimum de code.

Pour les exercices suivants, vous pouvez utiliser Copilot Chat dès que vous bloquez. C'est un outil d'apprentissage, pas de triche.

---

## Exercice 2 - Stage personnalisé

**Objectif** : personnaliser l'apparence de la fenêtre (titre, dimensions, style de décoration).

**Ce que vous allez découvrir** :
- Les propriétés du [`Stage`](https://openjfx.io/javadoc/25/javafx.graphics/javafx/stage/Stage.html) : `setTitle`, `setWidth`, `setHeight`, `setResizable`
- L'énumération [`StageStyle`](https://openjfx.io/javadoc/25/javafx.graphics/javafx/stage/StageStyle.html) pour modifier la décoration de la fenêtre

### Découverte du code

1. Ouvrez le fichier de l'exercice :
   ```
   src/main/java/fr/univ_amu/iut/exercice2/StagePersonnalise.java
   ```

2. Comme dans l'exercice 1, la classe étend `Application` et possède une méthode `start(Stage primaryStage)` avec un TODO. Cette fois, au lieu de simplement afficher la fenêtre, vous allez la **configurer** avant de l'afficher.

3. Ouvrez le fichier de test correspondant :
   ```
   src/test/java/fr/univ_amu/iut/exercice2/StagePersonnaliseTest.java
   ```

4. Vous remarquerez que cet exercice contient **5 tests** (tous `@Disabled`), chacun vérifiant un aspect différent de la personnalisation du `Stage`. L'ordre proposé ci-dessous est conseillé (progression pédagogique du plus simple au plus technique) ; la plupart des assertions sont indépendantes les unes des autres.

5. Notez que le premier test (`laFenetreEstVisible`) vérifie à nouveau que `show()` est appelé. C'est un rappel : **chaque exercice doit afficher sa fenêtre**.

### Boucle de travail pour chaque test

À partir de cet exercice, vous appliquerez la **même boucle de travail** pour chaque test - c'est la méthode TDD (Test-Driven Development) que vous utiliserez tout au long du module :

1. **Activez** le prochain test en retirant son `@Disabled` dans le fichier de test.
2. **Lancez** les tests :
   ```bash
   ./mvnw test
   ```
3. **Constatez** que le test est rouge - lisez le message d'erreur, il vous dit ce que le test attend.
4. **Implémentez** le minimum de code pour faire passer le test au vert.
5. **Relancez** les tests pour vérifier :
   ```bash
   ./mvnw verify
   ```
6. **Passez** au test suivant (retour à l'étape 1).

Quand **tous les tests de l'exercice** sont verts, finalisez l'exercice (commit, push, PR, merge - voir les étapes 8 à 10 du [Workflow de développement](#workflow-de-développement--un-cycle-par-exercice)).

> [!TIP]
> Pour voir votre fenêtre dans le navigateur, utilisez le VNC comme expliqué dans l'[exercice 1](#voir-votre-fenêtre-avec-vnc).

### Travail à faire

**Fichier** : [`src/main/java/fr/univ_amu/iut/exercice2/StagePersonnalise.java`](src/main/java/fr/univ_amu/iut/exercice2/StagePersonnalise.java)

Commencez par créer votre branche :

```bash
git checkout main
git checkout -b exercice2
```

Puis activez et implémentez les tests **un par un**, dans l'ordre :

1. **`laFenetreEstVisible`** - le Stage doit être affiché (pensez à `show()`, comme dans l'exercice 1).
2. **`leTitreEstDefini`** - le titre de la fenêtre doit être exactement `"Ma fenêtre personnalisée"`. Consultez la méthode `setTitle()` de `Stage`.
3. **`lesDimensionsSontDefinies`** - la fenêtre doit faire 500 pixels de large et 300 pixels de haut. Consultez `setWidth()` et `setHeight()`.
4. **`laFenetreNestPasRedimensionnable`** - la fenêtre ne doit pas pouvoir être redimensionnée. Consultez `setResizable()`.
5. **`leStyleEstUndecorated`** - la fenêtre doit avoir le style `StageStyle.UNDECORATED` (sans barre de titre ni bordures). Consultez `initStyle()`.

> [!WARNING]
> `initStyle()` doit être appelé **avant** `show()`, sinon JavaFX lève une exception. L'ordre des instructions dans `start()` compte.

### Finaliser l'exercice

Quand les 5 tests sont verts, finalisez votre travail :

```bash
git add .
git commit -m "Exercice 2 terminé"
git push -u origin exercice2
gh pr create --title "Exercice 2 terminé" --body "Les 5 tests passent."
gh pr view --web
```

Consultez la PR (diff, CI, review Copilot), puis mergez et revenez sur `main` :

```bash
gh pr merge --rebase --delete-branch
git checkout main
git pull
```

Vérifiez votre score sur l'onglet **Actions** de votre dépôt GitHub. Il devrait avoir augmenté.

> [!TIP]
> Si vous ne savez plus où vous en êtes, demandez à Copilot Chat : `Quelle est la prochaine étape ?` Il analysera l'état de vos tests et de votre branche Git pour vous guider.

---

## Exercice 3 - Première Scene avec un Label

**Objectif** : sortir de la fenêtre vide et afficher du contenu. Cet exercice introduit les trois briques fondamentales de toute interface JavaFX : la `Scene`, le conteneur de layout, et les composants graphiques.

**Ce que vous allez découvrir** :
- [`Scene`](https://openjfx.io/javadoc/25/javafx.graphics/javafx/scene/Scene.html) : le conteneur principal qui regroupe tout ce qui est affiché dans la fenêtre
- [`BorderPane`](https://openjfx.io/javadoc/25/javafx.graphics/javafx/scene/layout/BorderPane.html) : un conteneur de mise en page à 5 zones (top, bottom, left, right, center)
- [`Label`](https://openjfx.io/javadoc/25/javafx.controls/javafx/scene/control/Label.html) : un composant qui affiche du texte statique

### Comment JavaFX organise l'affichage

Dans JavaFX, l'affichage suit une hiérarchie d'objets imbriqués. On appelle cela le **graphe de scène** (scene graph) :

```mermaid
graph BT
    D["🏷️ <b>Label</b><br/>composant texte"] -- "placé dans" --> C["📦 <b>BorderPane</b><br/>conteneur racine"]
    C -- "passé à" --> B["🎬 <b>Scene</b><br/>contenu de la fenêtre"]
    B -- "attachée au" --> A["🖼️ <b>Stage</b><br/>la fenêtre"]
    
    style A fill:#4a90d9,color:white
    style B fill:#7bb563,color:white
    style C fill:#e8a838,color:white
    style D fill:#d35f5f,color:white
```

On construit de l'intérieur vers l'extérieur :
1. On crée un **Label** (le composant à afficher)
2. On le place dans un **BorderPane** (le conteneur qui organise la mise en page)
3. On crée une **Scene** à partir du BorderPane (la Scene regroupe tout le contenu)
4. On attache la Scene au **Stage** (la fenêtre) et on l'affiche

Le `BorderPane` organise ses enfants dans 5 zones :

![Les 5 zones du BorderPane](src/main/resources/assets/borderpane_zones.svg)

Dans cet exercice, seule la zone **center** sera utilisée (pour le Label). Les autres zones resteront vides pour l'instant. Vous les utiliserez dans l'exercice 4.

### Découverte du code

1. Ouvrez le fichier de l'exercice :
   ```
   src/main/java/fr/univ_amu/iut/exercice3/PremiereScene.java
   ```

2. La méthode `start(Stage)` contient un TODO qui détaille les 6 étapes à suivre : créer un `BorderPane`, créer un `Label`, placer le label au centre, construire une `Scene`, l'attacher au `Stage`, et afficher.

3. Ouvrez le fichier de test :
   ```
   src/test/java/fr/univ_amu/iut/exercice3/PremiereSceneTest.java
   ```

4. Cet exercice contient **6 tests**, chacun correspondant à une étape de construction :
   - `laFenetreEstVisible` : le Stage doit être affiché
   - `laSceneExiste` : le Stage doit avoir une Scene attachée via `setScene()`
   - `leRootEstUnBorderPane` : la racine de la Scene doit être un `BorderPane`
   - `unLabelEstPresent` : la scène doit contenir au moins un Label
   - `leLabelAfficheLeBonTexte` : un Label avec le texte exact `"Bonjour, JavaFX !"` doit être visible
   - `leLabelEstAuCentreDuBorderPane` : le Label doit être placé au centre du BorderPane via `setCenter()`

### Travail à faire

Créez votre branche :

```bash
git checkout main
git checkout -b exercice3
```

Appliquez la [boucle de travail](#boucle-de-travail-pour-chaque-test) : activez et implémentez les tests **un par un**, dans l'ordre :

1. **`laFenetreEstVisible`** : appelez `show()` sur le Stage (même principe que les exercices précédents).
2. **`laSceneExiste`** : créez un `BorderPane`, créez une `Scene` à partir de ce BorderPane, et attachez-la au Stage avec `setScene()`. Consultez la [Javadoc de Scene](https://openjfx.io/javadoc/25/javafx.graphics/javafx/scene/Scene.html).
3. **`leRootEstUnBorderPane`** : ce test vérifie que la racine de la Scene est bien un `BorderPane`. Si vous avez passé le BorderPane au constructeur de `Scene` à l'étape précédente, ce test devrait déjà passer.
4. **`unLabelEstPresent`** : créez un `Label` et ajoutez-le au BorderPane (par exemple avec `setCenter()`). Consultez la [Javadoc de Label](https://openjfx.io/javadoc/25/javafx.controls/javafx/scene/control/Label.html).
5. **`leLabelAfficheLeBonTexte`** : donnez au Label le texte exact `"Bonjour, JavaFX !"` via son constructeur ou la méthode `setText()`.
6. **`leLabelEstAuCentreDuBorderPane`** : ce test vérifie que le Label est bien dans la zone center du BorderPane. Si vous avez utilisé `setCenter()` à l'étape 4, il devrait déjà passer. Consultez la [Javadoc de BorderPane](https://openjfx.io/javadoc/25/javafx.graphics/javafx/scene/layout/BorderPane.html).

> [!TIP]
> Pour voir votre fenêtre dans le navigateur, utilisez le VNC comme expliqué dans l'[exercice 1](#voir-votre-fenêtre-avec-vnc).

### Finaliser l'exercice

Quand les 6 tests sont verts :

```bash
git add .
git commit -m "Exercice 3 terminé"
git push -u origin exercice3
gh pr create --title "Exercice 3 terminé" --body "Les 6 tests passent."
gh pr view --web
```

Consultez la PR, puis mergez :

```bash
gh pr merge --rebase --delete-branch
git checkout main
git pull
```

Vérifiez votre score sur l'onglet **Actions**. Il devrait avoir augmenté.

> [!TIP]
> Si vous ne savez plus où vous en êtes, demandez à Copilot Chat : `Quelle est la prochaine étape ?`

---

## Exercice 4 - Mise en page d'un formulaire

**Objectif** : combiner plusieurs conteneurs pour reproduire une maquette réaliste. Cet exercice vous apprend à **décomposer une interface** en zones, chacune gérée par un conteneur adapté.

**Ce que vous allez découvrir** :
- [`GridPane`](https://openjfx.io/javadoc/25/javafx.graphics/javafx/scene/layout/GridPane.html) : un conteneur en grille (lignes × colonnes) pour aligner des champs de formulaire
- [`HBox`](https://openjfx.io/javadoc/25/javafx.graphics/javafx/scene/layout/HBox.html) : un conteneur qui aligne ses enfants horizontalement
- [`MenuBar`](https://openjfx.io/javadoc/25/javafx.controls/javafx/scene/control/MenuBar.html) et [`Menu`](https://openjfx.io/javadoc/25/javafx.controls/javafx/scene/control/Menu.html) : la barre de menus d'une application
- [`TextField`](https://openjfx.io/javadoc/25/javafx.controls/javafx/scene/control/TextField.html) : un champ de saisie de texte
- [`Button`](https://openjfx.io/javadoc/25/javafx.controls/javafx/scene/control/Button.html) : un bouton cliquable

### Comment décomposer une interface en conteneurs

Quand on construit une interface, la première étape est de se demander : **quel conteneur utiliser pour chaque zone ?** Voici un guide :

| Conteneur | Quand l'utiliser |
|---|---|
| [`BorderPane`](https://openjfx.io/javadoc/25/javafx.graphics/javafx/scene/layout/BorderPane.html) | L'interface a des zones distinctes (barre en haut, contenu au centre, barre en bas) |
| [`VBox`](https://openjfx.io/javadoc/25/javafx.graphics/javafx/scene/layout/VBox.html) | Les composants sont empilés **verticalement** |
| [`HBox`](https://openjfx.io/javadoc/25/javafx.graphics/javafx/scene/layout/HBox.html) | Les composants sont alignés **horizontalement** |
| [`GridPane`](https://openjfx.io/javadoc/25/javafx.graphics/javafx/scene/layout/GridPane.html) | Les composants forment une **grille** avec des lignes et colonnes alignées |

### Maquette à reproduire

Voici l'interface que vous devez construire :

![Maquette du formulaire à reproduire](src/main/resources/assets/maquette_formulaire.svg)

L'interface est décomposée en **trois zones** dans un `BorderPane` :

```mermaid
graph BT
    M["📁 <b>MenuBar</b><br/>Fichier, Aide"] -- "setTop()" --> BP["📦 <b>BorderPane</b><br/>racine"]
    G["📋 <b>GridPane</b><br/>Nom + Email"] -- "setCenter()" --> BP
    H["➡️ <b>HBox</b><br/>Valider, Annuler"] -- "setBottom()" --> BP
    BP -- "passé à" --> S["🎬 <b>Scene</b>"]
    S -- "attachée au" --> ST["🖼️ <b>Stage</b>"]

    style ST fill:#4a90d9,color:white
    style S fill:#7bb563,color:white
    style BP fill:#e8a838,color:white
    style M fill:#b0bec5,color:#333
    style G fill:#b0bec5,color:#333
    style H fill:#b0bec5,color:#333
```

### Découverte du code

1. Ouvrez le fichier de l'exercice :
   ```
   src/main/java/fr/univ_amu/iut/exercice4/MiseEnPage.java
   ```

2. La méthode `start(Stage)` contient un TODO qui décrit la stratégie de construction : BorderPane comme racine, MenuBar en top, GridPane au center, HBox en bottom.

3. Ouvrez le fichier de test :
   ```
   src/test/java/fr/univ_amu/iut/exercice4/MiseEnPageTest.java
   ```

4. Cet exercice contient **11 tests** découpés en petits pas. Chaque test vous fait ajouter un seul élément à l'interface. Les commentaires dans le fichier de test indiquent l'étape correspondante.

### Travail à faire

Créez votre branche :

```bash
git checkout main
git checkout -b exercice4
```

Appliquez la [boucle de travail](#boucle-de-travail-pour-chaque-test) : activez et implémentez les tests **un par un**, dans l'ordre :

1. **`laFenetreEstVisible`** : appelez `show()`.
2. **`leRootEstUnBorderPane`** : créez un `BorderPane`, une `Scene`, et attachez-la au Stage avec `setScene()`.
3. **`leMenuBarEstEnHaut`** : créez un `MenuBar` et placez-le dans `borderPane.setTop()`.
4. **`leMenuBarContientDeuxMenus`** : ajoutez deux `Menu` au MenuBar avec `menuBar.getMenus().addAll(...)`.
5. **`lesMenusOntLesBonsNoms`** : les menus doivent s'appeler exactement `"Fichier"` et `"Aide"`.
6. **`leGridPaneEstAuCentre`** : créez un `GridPane` et placez-le dans `borderPane.setCenter()`.
7. **`lesLabelsNomEtEmailExistent`** : ajoutez deux `Label` ("Nom :" et "Email :") dans le GridPane avec `gridPane.add(label, colonne, ligne)`.
8. **`lesDeuxChampsDeSaisieExistent`** : ajoutez deux `TextField` dans le GridPane (colonne 1, lignes 0 et 1).
9. **`leHBoxEstEnBas`** : créez un `HBox` et placez-le dans `borderPane.setBottom()`.
10. **`leBoutonValiderExiste`** : ajoutez un `Button` "Valider" dans le HBox.
11. **`leBoutonAnnulerExiste`** : ajoutez un `Button` "Annuler" dans le HBox.

> [!TIP]
> Pour voir votre fenêtre dans le navigateur, utilisez le VNC comme expliqué dans l'[exercice 1](#voir-votre-fenêtre-avec-vnc).

### Finaliser l'exercice

Quand les 11 tests sont verts :

```bash
git add .
git commit -m "Exercice 4 terminé"
git push -u origin exercice4
gh pr create --title "Exercice 4 terminé" --body "Les 11 tests passent."
gh pr view --web
```

Consultez la PR, puis mergez :

```bash
gh pr merge --rebase --delete-branch
git checkout main
git pull
```

Vérifiez votre score sur l'onglet **Actions**.

> [!TIP]
> Si vous ne savez plus où vous en êtes, demandez à Copilot Chat : `Quelle est la prochaine étape ?`

---

## Exercice 5 - Réagir à un clic

**Objectif** : découvrir comment un composant JavaFX **réagit** à une action utilisateur. Vous allez brancher un écouteur sur un [`Button`](https://openjfx.io/javadoc/25/javafx.controls/javafx/scene/control/Button.html) et constater qu'un clic peut modifier l'état de l'application (ici, un compteur).

**Ce que vous allez découvrir** :
- [`EventHandler`](https://openjfx.io/javadoc/25/javafx.base/javafx/event/EventHandler.html) : l'interface fonctionnelle qui définit la réaction à un événement
- [`Button.setOnAction()`](https://openjfx.io/javadoc/25/javafx.controls/javafx/scene/control/ButtonBase.html#setOnAction(javafx.event.EventHandler)) : la méthode qui branche un écouteur sur un bouton
- Trois styles d'écriture pour un même écouteur : classe nommée, classe anonyme, lambda

### Maquette de l'IHM attendue

![Maquette de l'exercice 5 — bouton et compteur](src/main/resources/assets/maquette_evenements_bouton.svg)

L'interface est simple : un bouton "Clique-moi" et un label qui affiche le nombre de clics. Le tout est empilé verticalement dans un `VBox`.

### Le graphe de scène

```mermaid
graph BT
    B["🔘 <b>Button</b><br/>&quot;Clique-moi&quot;"] -- "enfant" --> V["📦 <b>VBox</b><br/>conteneur racine"]
    L["🏷️ <b>Label</b><br/>&quot;0 clics&quot;"] -- "enfant" --> V
    V -- "passé à" --> S["🎬 <b>Scene</b>"]
    S -- "attachée au" --> ST["🖼️ <b>Stage</b>"]

    style ST fill:#4a90d9,color:white
    style S fill:#7bb563,color:white
    style V fill:#e8a838,color:white
    style B fill:#d35f5f,color:white
    style L fill:#d35f5f,color:white
```

### Comment fonctionne un événement

Quand l'utilisateur clique sur le bouton, JavaFX déclenche une chaîne d'appels :

```mermaid
sequenceDiagram
    participant U as 👤 Utilisateur
    participant B as Button
    participant H as EventHandler
    participant C as Compteur
    participant L as Label

    U->>B: clic
    B->>H: handle(ActionEvent)
    H->>C: incrementer()
    C-->>H: valeur = N
    H->>L: setText("N clics")
```

La méthode `setOnAction()` du bouton enregistre un `EventHandler` : c'est l'objet qui sera appelé à chaque clic. À l'intérieur de `handle()`, on incrémente le compteur puis on met à jour le texte du label.

### Structure de l'exercice

Cet exercice contient **trois fichiers Java** :

```
exercice5/
├── Compteur.java              ← fourni, ne pas modifier
├── EcouteurClasseNommee.java  ← vous implémentez handle()
└── EvenementsBouton.java      ← vous construisez l'IHM et branchez l'écouteur
```

La classe `Compteur` est un simple compteur avec `getValeur()` et `incrementer()`. Elle est entièrement fournie.

### Trois styles d'écouteur, tous équivalents

En Java, quand on veut réagir à un événement (un clic, une frappe clavier…), on passe un objet qui implémente l'interface [`EventHandler<ActionEvent>`](https://openjfx.io/javadoc/25/javafx.base/javafx/event/EventHandler.html). JavaFX accepte **trois écritures différentes** pour définir cet objet. Elles produisent le même résultat, mais n'ont pas la même verbosité.

Le starter code de [`EvenementsBouton.java`](src/main/java/fr/univ_amu/iut/exercice5/EvenementsBouton.java) montre les trois styles en commentaires. Vous en activez un, vous vérifiez que ça marche, puis vous pouvez essayer les autres pour les comparer.

**Style 1 - classe nommée** (style historique, avant Java 8) :
```java
bouton.setOnAction(new EcouteurClasseNommee(compteur));
```
L'écouteur est dans son propre fichier `.java`. Le plus verbeux, mais aussi le plus explicite : on voit clairement que le comportement est encapsulé dans une classe dédiée.

**Style 2 - classe anonyme** (intermédiaire) :
```java
bouton.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent e) {
        compteur.incrementer();
        labelCompteur.setText(compteur.getValeur() + " clics");
    }
});
```
On définit la classe directement sur place, sans lui donner de nom. Plus compact que le style 1, mais la syntaxe reste lourde.

**Style 3 - lambda** (moderne, recommandé depuis Java 8) :
```java
bouton.setOnAction(e -> {
    compteur.incrementer();
    labelCompteur.setText(compteur.getValeur() + " clics");
});
```
La syntaxe la plus compacte, celle que l'on rencontre le plus souvent dans du code JavaFX moderne. `EventHandler` étant une **interface fonctionnelle** (une seule méthode abstraite), le compilateur déduit automatiquement le type.

> [!NOTE]
> Les trois styles sont strictement équivalents pour les tests. Le test d'intégration vérifie le résultat (le label affiche le bon texte), pas la manière dont l'écouteur est écrit.

### Découverte du code

1. Ouvrez le fichier de la classe nommée :
   ```
   src/main/java/fr/univ_amu/iut/exercice5/EcouteurClasseNommee.java
   ```

2. Cette classe implémente `EventHandler<ActionEvent>` et reçoit un `Compteur` dans son constructeur. La méthode `handle()` contient un TODO : il suffit d'appeler `compteur.incrementer()`.

3. Ouvrez le fichier principal de l'exercice :
   ```
   src/main/java/fr/univ_amu/iut/exercice5/EvenementsBouton.java
   ```

4. La méthode `start(Stage)` contient un TODO avec les trois styles en commentaire. L'IHM attendue : un `Button` "Clique-moi" (id `bouton-clique-moi`), un `Label` "0 clics" (id `compteur`), le tout dans un `VBox`.

5. Ouvrez les fichiers de test :
   ```
   src/test/java/fr/univ_amu/iut/exercice5/EcouteurClasseNommeeTest.java
   src/test/java/fr/univ_amu/iut/exercice5/EvenementsBoutonTest.java
   ```

6. Cet exercice contient **7 tests** dans deux fichiers séparés :

   **`EcouteurClasseNommeeTest`** (1 test unitaire, pas de TestFX) :
   - `handleIncrementeLeCompteur` : vérifie que `handle()` appelle bien `compteur.incrementer()` à chaque invocation

   **`EvenementsBoutonTest`** (6 tests d'intégration, TestFX) :
   - `laFenetreEstVisible` : le Stage doit être affiché
   - `laSceneExiste` : le Stage doit avoir une Scene attachée
   - `leBoutonExiste` : un Button avec l'id `bouton-clique-moi` doit être présent
   - `leBoutonAfficheLeBonTexte` : le bouton doit afficher "Clique-moi"
   - `leLabelCompteurExiste` : un Label avec l'id `compteur` doit être présent
   - `troisClicsAffichent3Clics` : 3 clics sur le bouton → le label affiche "3 clics"

### Travail à faire

Créez votre branche :

```bash
git checkout main
git checkout -b exercice5
```

Appliquez la [boucle de travail](#boucle-de-travail-pour-chaque-test) : activez et implémentez les tests **un par un**, dans l'ordre :

1. **`handleIncrementeLeCompteur`** (dans `EcouteurClasseNommeeTest`) : ouvrez `EcouteurClasseNommee.java` et implémentez le TODO dans `handle()`. Une seule ligne suffit : appelez `compteur.incrementer()`.
2. **`laFenetreEstVisible`** (dans `EvenementsBoutonTest`) : ouvrez `EvenementsBouton.java`. Pour l'instant, ajoutez simplement `primaryStage.show()` à la fin de `start()`.
3. **`laSceneExiste`** : créez un conteneur (par exemple un [`VBox`](https://openjfx.io/javadoc/25/javafx.graphics/javafx/scene/layout/VBox.html)), une `Scene`, et attachez-la au Stage avec `setScene()`.
4. **`leBoutonExiste`** : créez un `Button` et ajoutez-le au `VBox`. Donnez-lui l'id `bouton-clique-moi` avec `bouton.setId("bouton-clique-moi")`.
5. **`leBoutonAfficheLeBonTexte`** : passez le texte `"Clique-moi"` au constructeur du Button, ou utilisez `setText()`.
6. **`leLabelCompteurExiste`** : créez un `Label` avec l'id `compteur` et ajoutez-le au VBox.
7. **`troisClicsAffichent3Clics`** : c'est ici que vous branchez l'écouteur. Créez un `Compteur`, puis utilisez `bouton.setOnAction(...)` pour incrémenter le compteur et mettre à jour le texte du label à chaque clic. Choisissez le style d'écouteur de votre choix (voir les 3 styles ci-dessus).

> [!TIP]
> Commencez par le style lambda (style 3) : c'est le plus rapide à écrire. Quand le test passe, essayez de remplacer par le style 1 ou 2 pour voir la différence de syntaxe - le test doit toujours passer.

> [!TIP]
> Pour voir votre fenêtre dans le navigateur, utilisez le VNC comme expliqué dans l'[exercice 1](#voir-votre-fenêtre-avec-vnc).

### Finaliser l'exercice

Quand les 7 tests sont verts :

```bash
git add .
git commit -m "Exercice 5 terminé"
git push -u origin exercice5
gh pr create --title "Exercice 5 terminé" --body "Les 7 tests passent."
gh pr view --web
```

Consultez la PR, puis mergez :

```bash
gh pr merge --rebase --delete-branch
git checkout main
git pull
```

Vérifiez votre score sur l'onglet **Actions**. Il devrait avoir augmenté.

> [!TIP]
> Si vous ne savez plus où vous en êtes, demandez à Copilot Chat : `Quelle est la prochaine étape ?`

---

## Exercice 6 - Palette de couleurs (capstone)

**Objectif** : **synthèse** - cet exercice mobilise l'ensemble des concepts vus jusqu'ici (layouts, composants, événements, mise à jour de labels) dans une petite application autonome. C'est le dernier exercice du TP.

**Ce que vous allez mobiliser** :
- [`BorderPane`](https://openjfx.io/javadoc/25/javafx.graphics/javafx/scene/layout/BorderPane.html) et [`HBox`](https://openjfx.io/javadoc/25/javafx.graphics/javafx/scene/layout/HBox.html) pour la mise en page
- [`Button`](https://openjfx.io/javadoc/25/javafx.controls/javafx/scene/control/Button.html) et [`Pane`](https://openjfx.io/javadoc/25/javafx.graphics/javafx/scene/layout/Pane.html) pour l'interaction
- `setOnAction()` et `setStyle()` pour le comportement dynamique

### Maquette de l'IHM attendue

![Maquette de la palette de couleurs](src/main/resources/assets/maquette_palette.svg)

- Cliquer **Rouge** → le fond du `Pane` central devient rouge, et le compteur Rouge du label augmente de 1
- Même principe pour Vert et Bleu
- Les 3 compteurs sont **indépendants** : cliquer Rouge n'affecte pas les compteurs Vert et Bleu

### Le graphe de scène

L'interface est décomposée en **trois zones** dans un `BorderPane`, comme dans l'exercice 4 :

```mermaid
graph TD
    ST["🖼️ <b>Stage</b>"] -->|"setScene()"| S["🎬 <b>Scene</b>"]
    S -->|"racine"| BP["📦 <b>BorderPane</b>"]
    BP -->|"setTop()"| H["➡️ <b>HBox</b>"]
    BP -->|"setCenter()"| Z["🎨 <b>Pane</b><br/>zone de couleur"]
    BP -->|"setBottom()"| L["🏷️ <b>Label</b><br/>&quot;Rouge: 0 …&quot;"]
    H --- BR["🔴 <b>Button</b><br/>&quot;Rouge&quot;"]
    H --- BV["🟢 <b>Button</b><br/>&quot;Vert&quot;"]
    H --- BB["🔵 <b>Button</b><br/>&quot;Bleu&quot;"]

    style ST fill:#4a90d9,color:white
    style S fill:#7bb563,color:white
    style BP fill:#e8a838,color:white
    style H fill:#b0bec5,color:#333
    style Z fill:#b0bec5,color:#333
    style L fill:#b0bec5,color:#333
    style BR fill:#e74c3c,color:white
    style BV fill:#27ae60,color:white
    style BB fill:#2980b9,color:white
```

### Découverte du code

1. Ouvrez le fichier de l'exercice :
   ```
   src/main/java/fr/univ_amu/iut/exercice6/Palette.java
   ```

2. La méthode `start(Stage)` contient un TODO qui décrit la stratégie de construction en 6 points : BorderPane, HBox avec 3 boutons, Pane central, Label compteurs, 3 compteurs entiers, écouteurs pour chaque bouton.

3. Ouvrez le fichier de test :
   ```
   src/test/java/fr/univ_amu/iut/exercice6/PaletteTest.java
   ```

4. Cet exercice contient **10 tests** découpés en étapes progressives :
   - `laFenetreEstVisible` : le Stage doit être affiché
   - `laSceneExiste` : le Stage doit avoir une Scene attachée
   - `lesTroisBoutonsExistent` : 3 boutons avec les ids `btn-rouge`, `btn-vert`, `btn-bleu`
   - `laZoneDeCouleurExiste` : un Pane avec l'id `zone`
   - `leLabelCompteursExiste` : un Label avec l'id `compteurs`
   - `cliquerRougeMetLaZoneEnRouge` : le style du Pane contient `red` après un clic
   - `cliquerVertMetLaZoneEnVert` : le style du Pane contient `green` après un clic
   - `cliquerBleuMetLaZoneEnBleu` : le style du Pane contient `blue` après un clic
   - `cliquerIncrementeLeCompteurCorrespondant` : 2 clics sur Vert → label contient `Vert: 2`
   - `lesCompteursSontIndependants` : 2×Rouge + 1×Bleu → `Rouge: 2`, `Vert: 0`, `Bleu: 1`

### Ids attendus

| Composant | Id |
|---|---|
| Bouton rouge | `btn-rouge` |
| Bouton vert | `btn-vert` |
| Bouton bleu | `btn-bleu` |
| Zone de couleur (Pane) | `zone` |
| Label des compteurs | `compteurs` |

Attribuez les ids avec `setId("...")` sur chaque composant. Les tests les retrouvent via `robot.lookup("#btn-rouge")`, etc.

### Travail à faire

Créez votre branche :

```bash
git checkout main
git checkout -b exercice6
```

Appliquez la [boucle de travail](#boucle-de-travail-pour-chaque-test) : activez et implémentez les tests **un par un**, dans l'ordre :

1. **`laFenetreEstVisible`** : appelez `show()` sur le Stage.
2. **`laSceneExiste`** : créez un `BorderPane`, une `Scene`, et attachez-la au Stage.
3. **`lesTroisBoutonsExistent`** : créez 3 `Button` ("Rouge", "Vert", "Bleu") avec les ids `btn-rouge`, `btn-vert`, `btn-bleu`. Placez-les dans un `HBox` et assignez le HBox à `borderPane.setTop()`.
4. **`laZoneDeCouleurExiste`** : créez un `Pane` avec l'id `zone` et placez-le au centre du BorderPane avec `setCenter()`. Donnez-lui une taille minimale avec `zone.setMinSize(300, 200)`.
5. **`leLabelCompteursExiste`** : créez un `Label` avec l'id `compteurs` et le texte initial `"Rouge: 0  Vert: 0  Bleu: 0"`. Placez-le dans `borderPane.setBottom()`.
6. **`cliquerRougeMetLaZoneEnRouge`** : branchez un écouteur sur le bouton Rouge qui change le style de la zone avec `zone.setStyle("-fx-background-color: red;")`.
7. **`cliquerVertMetLaZoneEnVert`** : même principe pour le bouton Vert avec `green`.
8. **`cliquerBleuMetLaZoneEnBleu`** : même principe pour le bouton Bleu avec `blue`.
9. **`cliquerIncrementeLeCompteurCorrespondant`** : ajoutez 3 variables entières (`compteurRouge`, `compteurVert`, `compteurBleu`). Dans chaque écouteur, incrémentez le bon compteur et mettez à jour le texte du label avec le format `"Rouge: N  Vert: N  Bleu: N"`.
10. **`lesCompteursSontIndependants`** : si vos compteurs sont bien séparés, ce test devrait passer sans modification supplémentaire.

> [!NOTE]
> Le format du texte du label est libre tant qu'il contient les sous-chaînes `Rouge: N`, `Vert: N` et `Bleu: N` (avec un espace après les deux-points). Le séparateur entre les trois est à votre choix (espaces, tirets, virgules...).

> [!TIP]
> Pour voir votre fenêtre dans le navigateur, utilisez le VNC comme expliqué dans l'[exercice 1](#voir-votre-fenêtre-avec-vnc).

### Finaliser l'exercice

Quand les 10 tests sont verts :

```bash
git add .
git commit -m "Exercice 6 terminé"
git push -u origin exercice6
gh pr create --title "Exercice 6 terminé" --body "Les 10 tests passent. TP1 terminé !"
gh pr view --web
```

Consultez la PR, puis mergez :

```bash
gh pr merge --rebase --delete-branch
git checkout main
git pull
```

Vérifiez votre score sur l'onglet **Actions**. Si tous les exercices sont terminés, votre score devrait être de **100/100**. Bravo, le TP1 est terminé !

---

## Ressources complémentaires

- [OpenJFX - Getting Started](https://openjfx.io/openjfx-docs/)
- [JavaFX Tutorial](https://code.makery.ch/library/javafx-tutorial/)
- [TestFX Documentation](https://github.com/TestFX/TestFX)

---

## Dépannage

**Le premier `./mvnw` prend plusieurs minutes** - c'est normal. Le wrapper télécharge Maven 3.9.14 puis toutes les dépendances JavaFX / JUnit / TestFX (~50 Mo au total). Les exécutions suivantes utilisent le cache local et sont quasi instantanées.

**`./mvnw: Permission denied`** - après certains clones, le bit exécutable peut être perdu. Corrigez avec :
```bash
chmod +x mvnw
```

**`java: command not found` ou version < 25** - ce problème ne devrait pas se produire dans un Codespace. En cas d'installation locale, voir ci-dessous.

**Tests TestFX qui plantent avec `No X11 DISPLAY`** (Linux sans serveur X actif) - lancez les tests via `xvfb-run` :
```bash
xvfb-run --auto-servernum ./mvnw test
```
Dans un Codespace, le display virtuel est déjà configuré et ce problème ne se produit pas.

**Sous Windows, `./mvnw ...` ne fonctionne pas** - utilisez `mvnw.cmd` à la place :
```powershell
.\mvnw.cmd javafx:run
```

---

<details>
<summary>📦 Installation locale (facultative) - pour travailler en dehors du Codespace</summary>

**Sur les machines de l'IUT** (Linux, SDKMAN pré-installé) :

```bash
sdk install java 25.fx-zulu
```

**Chez vous sous Linux / macOS** - installez d'abord SDKMAN depuis [sdkman.io](https://sdkman.io), puis la commande ci-dessus.

**Windows** - via [Scoop](https://scoop.sh) :

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

---

*IUT d'Aix-Marseille - Département Informatique - 2026*
