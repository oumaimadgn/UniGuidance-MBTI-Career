# Projet Career Map 

Notre projet porte sur le MBTI, permettant aux étudiants d'explorer différents types de MBTI, de mieux comprendre leur personnalité et de découvrir les carrières qui leur correspondent grâce à un test.

Cet article présente notre plateforme conviviale dédiée à l'exploration des types de MBTI et à la réalisation de tests de personnalité. Notre objectif est de simplifier l'accès et l'organisation des informations sur le MBTI, de créer des expériences personnalisées, et d'accroître l'engagement des étudiants et des enseignants. Cette plateforme permet aux étudiants de passer des tests de personnalité et de découvrir leurs résultats, modifiant ainsi notre approche de l'orientation professionnelle.

En utilisant la technologie pour personnaliser l'apprentissage et l'orientation, notre but n'est pas seulement de rendre l'apprentissage plus efficace, mais aussi de répondre aux exigences uniques de chaque étudiant.

# Aperçu

Le projet vise à créer une plateforme conviviale dédiée à l'exploration des types de MBTI et à la réalisation de tests de personnalité, permettant aux étudiants de mieux comprendre leur personnalité et de découvrir les carrières qui leur correspondent. Cette plateforme priorise une planification et une organisation efficaces. Elle cherche à autonomiser à la fois les enseignants et les étudiants en tenant compte de leurs contraintes et préférences. 

Cette plateforme optimisera non seulement l'allocation des ressources, mais améliorera également l'engagement des étudiants grâce à des horaires d'apprentissage adaptables. Elle aspire à fournir aux éducateurs des outils pour saisir leurs contraintes et leurs modes d'enseignement, tout en offrant des mises à jour en temps réel et des analyses basées sur les données pour les administrateurs. 

En fin de compte, l'objectif du projet est d'améliorer les résultats d'apprentissage en rendant l'apprentissage personnalisé plus organisé, accessible et efficace.

# Frontend

## Technologies Utilisées

- React
- Tailwind CSS

## Dépendances

Liste des principales dépendances pour le frontend avec leurs versions :

```json
{
  "dependencies": {
    "react": "^17.0.2",
    "axios": "^0.24.0",
    "tailwindcss": "^3.0.10",
  },
  "devDependencies": {
    "react-scripts": "5.0.0",
  }
}
```

# Backend

## Technologies Utilisées

- Spring Boot
- MySQL

## Dépendances

1. Spring Boot Starter Data JPA :
   - Objectif : Simplifie l'accès aux données en utilisant JPA dans Spring Boot.

2. Spring Boot Starter Security :
   - Objectif : Fournit des fonctionnalités de sécurité pour les applications Spring Boot.

3. Spring Boot Starter Web :
   - Objectif : Fournit les dépendances nécessaires pour développer des applications web Spring Boot.

4. MySQL Connector/J :
   - Objectif : Pilote JDBC pour se connecter à une base de données MySQL.

5. Spring Boot Starter Test :
   - Objectif : Fournit les dépendances nécessaires pour les tests unitaires dans les applications Spring Boot.

6. Spring Security Test :
   - Objectif : Fournit des fonctionnalités de test pour les applications utilisant Spring Security.

```xml
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-security</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.27</version>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>org.springframework.security</groupId>
        <artifactId>spring-security-test</artifactId>
        <scope>test</scope>
    </dependency>
```

# Pour Commencer

Bien sûr ! Voici des instructions étape par étape pour configurer et exécuter votre projet localement :

## Prérequis :

1. Git :
   - Assurez-vous d'avoir Git installé. Sinon, téléchargez-le et installez-le depuis [git-scm.com](https://git-scm.com/).

## Configuration du Backend :

1. Cloner le Projet :
   bash
   git clone <repository_url>
   cd <project_folder>
   

2. Installer les Dépendances Backend :
   - Ouvrez un terminal dans le dossier du projet backend.
   - Exécutez les commandes suivantes :
     bash
     mvn clean install
     

3. Exécuter le Backend :
   - Démarrez vos serveurs MySQL.
   - Lancez l'application Spring Boot. La base de données et les entités seront créées automatiquement.
   - Vérifiez que le backend fonctionne en visitant [http://localhost:8080](http://localhost:8080) dans votre navigateur.

## Configuration du Frontend :

1. Installer les Dépendances Frontend :
   - Exécutez les commandes suivantes dans le dossier du projet frontend :
     bash
     npm install
     

   - Si vous rencontrez des erreurs pendant l'installation, utilisez la commande suivante :
     bash
     npm install --save --legacy-peer-deps
     

2. Exécuter le Frontend :
   - Après avoir installé les dépendances, démarrez le serveur de développement React :
     bash
     npm start
     

   - Accédez au frontend à l'adresse [http://localhost:3000](http://localhost:3000) dans votre navigateur.

Maintenant, votre projet full-stack devrait être configuré et fonctionner localement. Si vous rencontrez des problèmes lors de la configuration, vérifiez les logs de la console pour les messages d'erreur et assurez-vous que toutes les dépendances et prérequis sont correctement installés.

# Démonstration vidéo

Cliquez sur la vidéo ci-dessous pour regarder la démonstration :

https://github.com/Leilaemsi/CareerMap/assets/121642941/9fc55bbb-45c8-45be-8db3-a932cf48b9f0

# Contribution

Nous accueillons les contributions de tous et nous apprécions votre aide pour améliorer encore ce projet ! 
Si vous souhaitez contribuer, veuillez suivre ces directives :

## Contributeurs
- Oumaima Dagoun ([GitHub](https://github.com/oumaimadgn))
- Ali Ghannam ([GitHub](https://github.com/reyji24))
- Aya Nor Elyakine ([GitHub](https://github.com/norelyakine))
- Leila Mekiani ([GitHub](https://github.com/Leilaemsi))
- Amal Ourajim ([GitHub](https://github.com/AmalOur))
- Mohamed Lachgar ([Researchgate](https://www.researchgate.net/profile/Mohamed-Lachgar))
