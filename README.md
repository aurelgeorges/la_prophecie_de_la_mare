# La Prophétie de la Mare

Projet scolaire de jeu textuel en Java, basé sur une architecture UML stricte.

## Description
"La Prophétie de la Mare" est un jeu d'aventure en console où le joueur doit traverser une série de salles (Exploration, Combat, Énigme, Trésor) pour accomplir sa quête.

## Prérequis
*   **Java 17** ou supérieur
*   **Maven 3.6** ou supérieur

## Installation et Compilation

1.  Cloner le projet ou télécharger les sources.
2.  Ouvrir un terminal à la racine du projet.
3.  Compiler le projet avec Maven :

```bash
mvn clean package
```

Cette commande va :
*   Nettoyer les anciens builds (`clean`).
*   Compiler les sources Java.
*   Exécuter les tests unitaires.
*   Générer un fichier JAR exécutable dans le dossier `target/`.

## Lancer le Jeu

Une fois la compilation terminée, lancez le jeu avec la commande suivante :

```bash
java -jar target/prophetie-mare-1.0-SNAPSHOT.jar
```

## Structure du Projet

Le projet respecte l'architecture Maven standard :

*   `src/main/java/fr/troisil/prophetie/` : Code source
    *   `modele/` : Entités du jeu (Joueur, Ennemi, Salles...)
    *   `ui/` : Gestion de l'affichage console
    *   `core/` : Moteur de jeu (boucle principale)
    *   `Main.java` : Point d'entrée
*   `src/test/java/` : Tests unitaires (JUnit 5)
*   `pom.xml` : Configuration Maven

## Règles du Jeu
*   Suivez les instructions à l'écran.
*   Choisissez vos actions (ATTAQUER, SOIGNER) lors des combats.
*   Résolvez les énigmes pour avancer sans dégâts.
*   Le jeu est linéaire, mais vous donne l'illusion du choix de direction.

## Conception et Architecture

Le projet a été conçu en respectant strictement les diagrammes UML suivants (/docs/images) :

### Diagramme de Cas d'Utilisation
Illustre les interactions du joueur avec le système.
![Diagramme de Cas d'Utilisation](docs/images/diagramme_cas_utilisation.jpg)

### Diagramme de Classes
Définit la structure statique du jeu, les entités et leurs relations.
![Diagramme de Classes](docs/images/diagramme_classes.png)

### Diagramme d'État-Transition
Décrit le cycle de vie du jeu et les transitions entre les différentes phases (Exploration, Combat, Énigme, Trésor).
![Diagramme d'État-Transition](docs/images/diagramme_etats.png)

### Diagramme d'Activité
Montre le flux détaillé des actions du joueur et du système.
![Diagramme d'Activité](docs/images/diagramme_activite.jpg)

## Auteur
Aurel GEORGES
Ilies MOUSSAOUI-PEREZ
