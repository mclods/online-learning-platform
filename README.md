# Online Learning Platform

An Online Learning Platform made with Spring.

## ER Diagram:

![ER Diagram](diagrams/Online%20Learning%20Platform%20DB%20ER%20Diagram.png)

## Steps to Setup:

1. Setup a PostgreSQL DB.
2. Add data source in [application.yaml](src/main/resources/application.yaml) or create a **.env** file.
3. Add db url, user and password in [flyway.conf](flyway.conf).
4. Use flyway maven plugin and run below commands to setup the tables.
5. Start the application.
6. Hit below endpoints to create and delete dummy data.
7. Run test [QueriesTest.java](src/test/java/com/mclods/online_learning_platform/queries/QueriesTests.java) to execute and test the queries.

### Flyway Commands

```cmd
.\mvnw flyway:clean
```

```cmd
.\mvnw flyway:migrate
```

### Endpoints

* **PUT** `/data/create-dummy` - Create Dummy Data
* **DELETE** `/data/delete-dummy` - Delete Dummy Data

