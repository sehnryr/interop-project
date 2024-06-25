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

To call Mule flow endpoints that saves Spring API's responses to files:
- `GET` request: `curl http://localhost:8081/get`
- `POST` request: `curl http://localhost:8081/post`
- `PUT` request: `curl http://localhost:8081/put`
- `DELETE` request: `curl http://localhost:8081/delete`

The Mule flow will save each response content to a file named `output-<method>.txt`
for each method inside the Mule project root.
