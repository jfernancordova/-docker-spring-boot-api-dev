# Spring Boot API Boilerplate Dockerized

* Spring Boot
* Java 11
* MongoDB
* Docker
* Traefik

### Prerequisites

* [Docker](https://docs.docker.com/install/)
* [Docker Compose](https://docs.docker.com/compose/install/)

## Deployment

### Docker Environments

Clone this repository and run the following commands based on your orchestrator;

### Swarm Mode
Clone this repository and run the following commands:
```bash
cd docker-spring-boot-api-dev/
docker stack deploy -c docker-compose.yml docker-spring-boot-api-dev
# wait for the HEALTHCHECK in healthy mode
```

### Docker Compose
Clone this repository and run the following commands:
```bash
cd docker-spring-boot-api-dev/
docker-compose up --build -d 
or to see the logs 
docker-compose -f docker-compose-dev.yml up 
```

## Traefik - Proxy Reverse

Locally add in your etc/hosts the following domains to access for the browser:
```bash
127.0.0.1   spring-boot-api.local.com
127.0.0.1   mongo-express.local.com
```

## Observations

This repo is useful to starting any app in spring boot with docker, the design of objects or structures inside the api,
it is only an example, however, it has been added the postman collection in case you like this architecture and 
the product example. 