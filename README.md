This project is the sample MongoDB Spring app from https://www.mongodb.com/compatibility/spring-boot converted to use and ID and a JSONB column in Yugabyte YSQL.  Feel free to compare to the MongoDB version.

# Setup

Deploy a YB cluster and execute the following SQL to create the DB and tables:

```
CREATE database grocery;

\c grocery


CREATE TABLE IF NOT EXISTS mygrocerylist (
    id text not null,
    name text,
    quantity int,
    category text,
    PRIMARY KEY (id));

CREATE TABLE IF NOT EXISTS mygrocerylistjson (
    id text not null,
    details jsonb,
    PRIMARY KEY (id));
```


# Build and Run

Build the sample app (written using Spring code) as follows:

```
$ mvn -DskipTests package
```

Run the application:

```
$ java -jar yugabyte-spring-0.0.1-SNAPSHOT.jar (in ./target folder of project)
```

**NOTE:** If you need to clean and rebuild the project, run the folowing command before rebuilding.

```
$ mvn clean
```


# Customizing

There are a number of options that can be customized in the properties file located here:
[`src/main/resources/application.properties`](src/main/resources/application.properties)

| Properties    | Description   | Default |
| ------------- | ------------- | ------- |
| `spring.datasource.platform` | The DB Platform | Leave as `postgres` |
| `spring.datasource.url`  | The connection string. | For the `grocery` DB, use `jdbc:postgresql://localhost:5433/grocery`  |
| `spring.datasource.username` | The username to connect to the database. | `yugabyte` |
| `spring.datasource.password` | The password to connect to the database. Leave blank for no password. | - |

