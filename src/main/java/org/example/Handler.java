package org.example;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class Handler implements RequestHandler<Map<String,String>, String> {
    @Override
    public String handleRequest(Map<String, String> input, Context context) {

        // Check java version.
        System.out.println("Java version" + System.getProperty("java.version"));

        // Simply send http request to GitHub.
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://github.com/localstack/localstack"))
                .build();

        HttpClient client = HttpClient.newHttpClient();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response);
            return response.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return e.toString();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return e.toString();
        }
    }
}
