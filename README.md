Project created using Spring Initializr (https://start.spring.io/).

- `GET` request: `curl http://localhost:8080/api/get`
- `POST` request: `curl -X POST -d "sample body" http://localhost:8080/api/post`
- `PUT` request: `curl -X PUT -d "sample body" http://localhost:8080/api/put`
- `DELETE` request: `curl -X DELETE http://localhost:8080/api/delete`

To run the backend:
```shell
mvn spring-boot:run
```

To run the JavaFX client:
```shell
cd client
mvn clean javafx:run
```