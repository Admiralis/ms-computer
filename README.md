# MS-COURSE

Micro service pour gérer les ordinateurs et leurs commentaires.

## Dépendances

- Spring Boot
- Spring Data MongoDB
- Spring Web
- Lombak
- Actuator
- Docker

## Installation

- Cloner le projet
- Démarrez la base de données MongoDB avec Docker `docker-compose up -d`
- Lancer le projet avec la commande `mvn spring-boot:run`

## Schema de la base de données

```plantuml
@startuml
package MS-Computers {
  
  class Computer {
    serial: String
    processor: String
    ram: int
    condition: String
    ==
    CRUD simple
  }
  
  
  
  class Comment {
    content: String
    ==
    Nested into Computer
  }
}

Computer "1" o-- "*" Comment

@enduml
```

## API

### Documentation

#### StandAlone :

- Swagger : `http://localhost:8081/api/computers/docs`
- Health : `http://localhost:8081/api/computers/status/health`


##### Avec Gateway :

Si vous utilisez la gateway, que ce soit en mode [dev](https://github.com/Admiralis/dev_stack) ou en mode [prod](https://github.com/Admiralis/admiralis), l'API sera accessible sur le port 80.
Si l'API se trouve sur un serveur distant, il faudra remplacer `localhost` par l'adresse du serveur.

- Swagger : `http://localhost/api/computers/docs`
- Health : `http://localhost/api/computers/status/health`