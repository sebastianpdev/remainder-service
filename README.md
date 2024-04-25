# Remainder Service

Tecnologías usadas: Spring boot + Angular 17 + Bootstrap \
Unit test: Jupiter + Mockito, Jasmine + Karma

## Architecture

En backend, adaptación de clean arquitecture teniendo en cuenta los conceptos la misma y enfoques de negocio.\
En frontend, custom folder structure teniendo en cuenta puntos claves de cualquier aplicación angular y negocio. 

## Run

Para ejecutar la aplicación en modo development

### Linux
```
mvnw spring-boot:run
```
### Windows
```
.\mvnw spring-boot:run
```

## Tests
Los test unitarios se pueden ejecutar con los siguientes comandos según sea el framework requerido:

```
ng test
```
```
mvn test
```

## Build

La aplicación puede ser empaquetada con el siguiente comando:

```
mvnw clean package
```

Inicializar aplicación con el comando:

```
java -jar ./target/remainderservice-0.0.1-SNAPSHOT.jar
```

## AWS

La aplicación se encuentra alojada sobre una instancia EC2, el jar se aloja en un bucket S3.

```
http://18.219.23.88:8080/
```



