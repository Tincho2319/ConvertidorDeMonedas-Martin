package com.martin.modelo.request;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PrincipalRequest {

    public JsonObject recibiendoDatos() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/6378d91e68f1e365e680d0f1/latest/USD"))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();

            JsonObject jsonObject = JsonParser.parseString(responseBody).getAsJsonObject();
            JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");

            return conversionRates;

        } catch (IOException | InterruptedException e) {
            System.err.println("Error al recibir datos de la API: " + e.getMessage());
            return null;
        }
    }
}
