# Application de Gestion de Réservations et de Ressources

## Description
Cette application est basée sur une architecture microservices et permet de gérer des réservations pour différentes ressources. Chaque réservation concerne une seule ressource. L'application propose trois microservices fonctionnels principaux, un frontend web Angular et plusieurs microservices techniques.

### Fonctionnalités principales :
1. Gérer les ressources :
    - Identifier les ressources par ID, nom, et type (MATERIEL_INFO, MATERIEL_AUDIO_VISUEL).
2. Gérer les réservations :
    - Suivi des réservations effectuées par des personnes.
    - Identifier chaque réservation par ID, nom, contexte, date, et durée.
3. Intégration d'une authentification et autorisation basées sur Keycloak (OAuth2 et OIDC).
4. Documentation des API avec OpenAPI (Swagger).
5. Tolerance aux fautes grâce à Resilience4J (circuit breakers).
6. Déploiement via Docker et Docker Compose.

---

## Architecture Technique
L'architecture repose sur les composants suivants :

### Microservices fonctionnels :
1. **Resources-Service** : Gérer les ressources.
2. **Reservation-Service** : Gérer les réservations effectuées par des personnes.

### Microservices techniques :
1. **Gateway-Service** : Proxy API basé sur Spring Cloud Gateway pour la gestion des requêtes.
2. **Discovery-Service** : Service de découverte basé sur Eureka Server .
3. **Config-Service** : Gestion centralisée des configurations via Spring Cloud Config .

### Frontend :
- **Angular-Front-App** : Interface utilisateur pour l'application.

---

## Installation et Déploiement

### Prérequis
1. **Outils de développement :**
    - Java 17+
    - Maven 3.8+
    - Node.js et Angular CLI
    - Docker et Docker Compose

2. **Outils de sécurité et de configuration :**
    - Keycloak
    - Eureka Server 
    - Spring Cloud Config   

### Étapes de déploiement
1. Clonez le dépôt du projet :
   ```bash
   git clone https://github.com/TahaManna07/Reservation_Management_System
   ```

2. Construisez les microservices backend avec Maven :
   ```bash
   mvn clean install
   ```

3. Construisez l'application frontend Angular :
   ```bash
   cd angular-front-app
   npm install
   ng build --prod
   ```

4. Lancez les services avec Docker Compose :
   ```bash
   docker-compose up --build
   ```

---

## Microservices Fonctionnels

### Resources-Service
- **Description :**
    - Permet de gérer les ressources.
- **Principales technologies :** Spring Boot, JPA, H2/MySQL.
- **Points d'API principaux :**
    - `GET /resources` : Liste des ressources.
    - `POST /resources` : Créer une nouvelle ressource.
    - `PUT /resources/{id}` : Mettre à jour une ressource.
    - `DELETE /resources/{id}` : Supprimer une ressource.

### Reservation-Service
- **Description :**
    - Gérer les réservations associées à des personnes et des ressources.
- **Principales technologies :** Spring Boot, JPA, Feign Client.
- **Points d'API principaux :**
    - `GET /reservations` : Liste des réservations.
    - `POST /reservations` : Créer une nouvelle réservation.
    - `PUT /reservations/{id}` : Mettre à jour une réservation.
    - `DELETE /reservations/{id}` : Supprimer une réservation.

---

## Frontend Angular
- **Technologies :** Angular, Bootstrap, FontAwesome.
- **Fonctionnalités principales :**
    - Gestion des ressources et des réservations via une interface utilisateur intuitive.
    - Authentification utilisateur avec Keycloak.

---

## Sécurité
- **Keycloak** :
    - OAuth2 et OIDC pour l'authentification et l'autorisation.
    - Configuration des clients et des utilisateurs dans Keycloak.

---

## Documentation des API
- Swagger UI est accessible sur :
    - `http://<gateway-url>/swagger-ui.html`
    - **Note** : Assurez-vous que les services sont déployés.

---

## Tolérance aux fautes
- **Resilience4J** :
    - Implémentation de circuit breakers pour assurer la résilience des services.

---

## Déploiement avec Docker Compose
- Le fichier `docker-compose.yml` inclut :
    - Services backend (resources-service, reservation-service, gateway-service, discovery-service, config-service).
    - Frontend Angular.
    - Keycloak.

### Commandes principales
- Lancer l'application :
  ```bash
  docker-compose up --build
  ```
- Arrêter l'application :
  ```bash
  docker-compose down
  ```

---

## Tests
- **Tests Unitaires :**
    - Couverture des entités, services et contrôleurs REST.
- **Tests d'intégration :**
    - Validation des interactions entre les microservices via Feign Client et Eureka.

---

## Contribution
1. Forkez le dépôt.
2. Créez une branche pour vos modifications :
   ```bash
   git checkout -b feature/nom-feature
   ```
3. Faites un commit :
   ```bash
   git commit -m "Description de la modification"
   ```
4. Poussez vos modifications :
   ```bash
   git push origin feature/nom-feature
   ```
5. Créez une Pull Request.

---

## Auteurs
- **Manna Taha Souhail**
    - Développeur Java et Angular
    - Expertise en microservices et développement full-stack.

---

## Licence
Ce projet est sous licence MIT. Consultez le fichier `LICENSE` pour plus de détails.

