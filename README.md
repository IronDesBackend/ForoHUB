# ForoHUB
Este programa en un __Foro__ en el cual distintos estudiantes de Alura deben de poder publicar contenido,
esto por medio del uso de distintas funciones CRUD (Create, Read, Update, Delete) y el uso de una API REST.

## Funcionalidades

Para emepezar debes autenticarte, envia una solicitud POST a /login con tu usuario y contraseña. Luego de esto
el programa te devolvera un TOKEN que debes incluirlo en el header "Authorization" como un Bearer Token para 
realizar proximas consultas y obtener información de las mismas.

### EndPoints CRUD
+   POST   =     /topicos       --> Con esta solicitud creas un nuevo topico
+   GET    =     /topicos       --> Con esta solicitud obtienes una lista de topicos
+   PUT    =     /topicos/{id}   --> Con esta consulta actualizas un topico creado anteriormente. Requieres el "id" de dicho topico
+ DELETE   =     /topicos/{id}   --> Con esta consulta eliminas un codigo de la base de datos. Requieres el "id" de dicho topico


## Requisitos

- Java JDK: version 11 en adelante
- Maven version 4 en adelante
- Postgres version 16 en adelante
- IDE (IntelliJ IDEA o similares)
- Postman version 11 enn adelante

# Iniciar programa

Primero debes de crear la DataBase en postgres con el siguiente nombre "challenge-foro_hub". Para poder usar el programa debes de
ejecutar el archivo `Main.java`, para ello debes de seguir la siguiente ruta:

### src>com>aluracursos>Challenge>foroHub>Challenge_ForoHub>Main.java

Diviertete!

# Dependencias

+ Spring Boot Starter Web
+ Spring Boot Devtools
+ Postgresql
+ Spring Boot Starter Test
+ Spring Boot Starter Data JPA
+ Swagger
+ Lombok
+ Flyway migration
+ Validation
+ Spring Security

## Autor

Juan Sebastian Bocanegra Barrera
