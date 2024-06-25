package org.openjfx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import org.apache.hc.client5.http.classic.methods.HttpDelete;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.classic.methods.HttpPut;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.io.entity.StringEntity;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;


/**
 * JavaFX App
 */
public class App extends Application {

    private static final String BASE_URL = "http://localhost:8080/api";

    @Override
    public void start(Stage primaryStage) {
        Label responseLabel = new Label("Response:");
        TextArea responseArea = new TextArea();
        responseArea.setEditable(false);

        Button getButton = new Button("GET");
        getButton.setOnAction(e -> {
            String response = sendRequest(new HttpGet(BASE_URL + "/get"));
            responseArea.setText(response);
        });

        Button postButton = new Button("POST");
        postButton.setOnAction(e -> {
            String response = sendRequest(new HttpPost(BASE_URL + "/post"), "Sample POST body");
            responseArea.setText(response);
        });

        Button putButton = new Button("PUT");
        putButton.setOnAction(e -> {
            String response = sendRequest(new HttpPut(BASE_URL + "/put"), "Sample PUT body");
            responseArea.setText(response);
        });

        Button deleteButton = new Button("DELETE");
        deleteButton.setOnAction(e -> {
            String response = sendRequest(new HttpDelete(BASE_URL + "/delete"));
            responseArea.setText(response);
        });

        VBox vbox = new VBox(10, getButton, postButton, putButton, deleteButton, responseLabel, responseArea);
        Scene scene = new Scene(vbox, 400, 300);

        primaryStage.setTitle("JavaFX REST Client");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private String sendRequest(HttpGet request) {
        try (CloseableHttpClient client = HttpClients.createDefault();
             CloseableHttpResponse response = client.execute(request)) {
            return new BufferedReader(new InputStreamReader(response.getEntity().getContent()))
                    .lines()
                    .collect(Collectors.joining("\n"));
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    private String sendRequest(HttpDelete request) {
        try (CloseableHttpClient client = HttpClients.createDefault();
             CloseableHttpResponse response = client.execute(request)) {
            return new BufferedReader(new InputStreamReader(response.getEntity().getContent()))
                    .lines()
                    .collect(Collectors.joining("\n"));
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    private String sendRequest(HttpPost request, String body) {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            request.setEntity(new StringEntity(body));
            try (CloseableHttpResponse response = client.execute(request)) {
                return new BufferedReader(new InputStreamReader(response.getEntity().getContent()))
                        .lines()
                        .collect(Collectors.joining("\n"));
            }
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    private String sendRequest(HttpPut request, String body) {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            request.setEntity(new StringEntity(body));
            try (CloseableHttpResponse response = client.execute(request)) {
                return new BufferedReader(new InputStreamReader(response.getEntity().getContent()))
                        .lines()
                        .collect(Collectors.joining("\n"));
            }
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
