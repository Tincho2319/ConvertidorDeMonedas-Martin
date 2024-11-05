package com.martin.modelo.request;

import com.google.gson.JsonObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

public class CreandoArchivo {

    public void guardarJsonEnArchivo(JsonObject jsonObject, Set<String> clavesEspecificas, String nombreArchivo) {
        try (FileWriter file = new FileWriter(nombreArchivo)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(jsonObject, file);
            System.out.println("Archivo JSON guardado como " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al guardar JSON en archivo: " + e.getMessage());
        }
    }
}
