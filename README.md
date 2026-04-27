# PizzaRecipes – LAB 6

Application Android permettant de consulter une liste de pizzas et d’afficher les détails complets de chaque recette avec une interface moderne et interactive.

## Objectif:
Le but de ce laboratoire est de :
- Comprendre l’architecture d’une application Android (classes, dao, service, adapter, ui)
- Manipuler une ListView avec un Adapter personnalisé
- Implémenter un modèle de données orienté objet
- Gérer la navigation entre activités avec Intent
- Créer un Splash Screen animé
- Personnaliser l’interface avec des drawables (gradient, cards, badges)

## Description de l’application:
L’application contient :
- Un écran de démarrage (Splash Screen)
- Une liste de pizzas
- Un écran de détail pour chaque pizza

- Dans la liste :
  - Image de la pizza
  - Nom
  - Durée de préparation
  - Prix

- Dans le détail :
  - Image
  - Nom
  - Durée
  - Prix
  - Ingrédients
  - Description
  - Étapes

- Boutons interactifs :
  - Bouton retour personnalisé
  - Bouton de partage de recette

## Fonctionnalités:
- Affichage dynamique des pizzas via un Adapter
- Navigation entre les activités (liste → détail)
- Passage de données via Intent (ID de la pizza)
- Affichage complet des informations d’une recette
- Partage d’une pizza via applications externes (WhatsApp, etc.)
- Interface moderne avec :
  - Dégradé de fond
  - Cartes arrondies
  - Badges (prix / durée)
  - Boutons flottants

## Technologies utilisées:
- Android Studio
- Java
- XML
- API minimum : 24 (Android 7.0)

## Aperçu de l’application:

⚠️ Une démonstration vidéo complète de l’application est disponible dans le dossier **Demo** du repository.

## Structure du projet:

### Layouts (res/layout):

#### activity_splash.xml
- Écran de démarrage avec :
  - Image centrale
  - Titre de l’application
  - ProgressBar
- Fond en dégradé (gradient)

#### activity_recipes.xml
- Contient :
  - Titre de l’écran
  - ListView
- Fond avec dégradé doux

#### item_recipe.xml
- Représente une pizza dans la liste
- Contient :
  - Image
  - Nom
  - Badge durée
  - Badge prix
- Utilise une carte arrondie (design moderne)

#### activity_recipe_details.xml
- Écran détaillé d’une pizza
- Contient :
  - Image en haut
  - Boutons (Retour + Share)
  - Titre et informations
  - Carte avec :
    - Ingrédients
    - Description
    - Étapes
   
    
### classes/PizzaRecipe.java
- Représente une pizza
- Contient les attributs (id, title, price, image, durée, etc.)
- Fournit les getters et setters

### dao/RecipeRepository.java
- Interface générique
- Définit les opérations CRUD

### service/PizzaCatalog.java
- Gère les données en mémoire
- Implémente RecipeRepository
- Utilise le pattern Singleton
- Initialise les pizzas (seed)

### adapter/RecipeListAdapter.java
- Adapter personnalisé
- Relie les données aux vues
- Gère l’affichage de chaque ligne

### ui/SplashActivity.java
- Écran de démarrage
- Attente de 2 secondes
- Redirection vers la liste

### ui/RecipesActivity.java
- Affiche la liste des pizzas
- Initialise l’Adapter
- Gère le clic → ouverture du détail

### ui/RecipeDetailsActivity.java
- Affiche les détails d’une pizza
- Récupère les données via Intent
- Boutons :
  - Retour (finish)
  - Partage (Intent.ACTION_SEND)

### Design (res/drawable):
- bg_splash_gradient → fond du splash screen
- bg_screen_soft → fond global
- bg_recipe_card → cartes des pizzas
- bg_badge_price / bg_badge_time → badges
- bg_icon_button → boutons flottants

## Conclusion:
Ce laboratoire permet de développer une application Android complète en combinant :
- Architecture en couches
- Navigation entre activités
- Adapter personnalisé
- Gestion des données
- Personnalisation avancée de l’interface

Il constitue une base solide pour créer des applications mobiles modernes et professionnelles.
