# Hex Microservice
This repo contains a template for a project to expose a REST micro-service built using a hexagonal pattern.

The primary advantage of using hex pattern is to separate out the core logic of the application from how the app is deployed.
This greatly improve the testability of the application.

## Capabilities built in

* Spring boot app
* Basic logging
* REST API pattern with injected services
* Dockerizing

#Using this repo

TODO: Add documentation on all the places things need to change

* Logging
* Module Names
* Application properties/profiles
* Dockerizing

## Using Maven to build
Before you can use maven to build the docker image, you need to make sure you have the maven wrapper.
Check if your current project directory has `.mvn` folder, if it does not use the following command to install 
the maven wrapper.
```
mvn -N io.takari:maven:wrapper
```


To build the whole project:
```bash
./mvnw clean package
```
The above command should clean and build the entire project.


To run the REST App JAR directly use this command:
```bash
./mvnw spring-boot:run -pl restapp
```


### Dockerizing

Warning: The dockerfile in the docker folder is NOT used. Use maven spring plugin to create the docker image.


To build the REST App docker using maven:
```bash
./mvnw spring-boot:build-image -Dspring-boot.build-image.imageName=resttemplate/restapp -pl restapp

```

To run the app in docker locally, run this command:
```bash
docker run -p 8080:8080 resttemplate/restapp:latest
``` 

The first port no is the port on the host machine and the second one is the port mapped on the container.
When the app starts up this way, the app is now available on `localhost:8080`

This docker image just runs and lives locally for now. I'll add changes to push it to a docker registry later.