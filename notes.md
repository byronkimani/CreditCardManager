This is a small SpringBoot service to manage users accounts and cards. The assumption is that a user can have multiple accounts an account can have more than one card but an account can only have one user.
To run the service locally you need to have JDK 17 and Postgres installed locally.
To install JDK 17, follow these steps:
Visit the [Java SE Downloads page](https://www.oracle.com/java/technologies/downloads/) and download the appropriate JDK 17 installer for your operating system.
Run the installer and follow the prompts to complete the installation.
To install PostgreSQL, follow these steps:
Visit the [PostgreSQL Downloads page](https://www.postgresql.org/download/) and download the appropriate installer for your operating system.
Run the installer and follow the prompts to complete the installation.
Create a new database called creditcardmanager in PostgreSQL.
Replace the values in application-dev.yml with your database credentials.
You can now run the application from IntelliJ or your IDE of choice.


Third party libraries used include the following:
1. Lombok: Lombok is a third-party library used to reduce boilerplate code in Java. It provides annotations to generate common code such as getters, setters, constructors, and more.

2. springdoc-openapi-starter-webmvc-ui: is a third-party library in the context of a Spring Boot application. It's an extension of the Spring Boot ecosystem that integrates with the SpringDoc OpenAPI library

3. H2 Database: H2 Database is an in-memory and persistent database that can be used as a development or testing database. It's not a part of the core Spring Boot dependencies.

4. PostgreSQL: PostgreSQL is a powerful, open-source relational database system. While Spring Boot itself supports various databases, PostgreSQL is a third-party database system that you can use with Spring Boot.