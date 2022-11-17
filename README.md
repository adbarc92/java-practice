Requires a file `application.properties` located at `src/main/resources/application.properties` with the following lines:

```
spring.datasource.url=jdbc:postgresql://localhost:5432/student
spring.datasource.username=<YOUR_USERNAME>
spring.datasource.password=<YOUR_PASSWORD>
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.properties.hibernate.format-sql=true
```
