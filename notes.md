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
