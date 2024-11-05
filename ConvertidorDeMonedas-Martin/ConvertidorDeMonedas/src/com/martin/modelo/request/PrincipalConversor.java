package com.martin.modelo.request;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PrincipalConversor {
    private Scanner teclado = new Scanner(System.in);
    private Map<String, Double> rates; // Mapa de tasas de cambio

    public PrincipalConversor(String nombreArchivo) {
        try (FileReader reader = new FileReader(nombreArchivo)) {
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);

            rates = jsonObject.entrySet().stream()
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            entry -> entry.getValue().getAsDouble()
                    ));
        } catch (IOException e) {
            System.err.println("Error al leer el archivo JSON: " + e.getMessage());
        }
    }
    
    public int convertirMoneda(int opcion, int cantidadMoneda) {
        double resultadoConversion;

        switch (opcion) {
            case 1 -> resultadoConversion = (cantidadMoneda * rates.get("ARS"));
            case 2 -> resultadoConversion = (cantidadMoneda / rates.get("ARS"));
            case 3 -> resultadoConversion = (cantidadMoneda * rates.get("COP"));
            case 4 -> resultadoConversion = (cantidadMoneda / rates.get("COP"));
            case 5 -> resultadoConversion = (cantidadMoneda * rates.get("BRL"));
            case 6 -> resultadoConversion = (cantidadMoneda / rates.get("BRL"));
            default -> throw new IllegalArgumentException("Opción no válida: " + opcion);
        }
        return (int) resultadoConversion;
    }

    public void iniciarConversor(int opcion) {
            System.out.print("Ingrese la cantidad de moneda a convertir: ");
            int cantidadMoneda = teclado.nextInt();

            try {
                int resultado = convertirMoneda(opcion, cantidadMoneda);
                if (opcion == 1 | opcion == 3 | opcion ==5) {
                    switch (opcion) {
                       case 1 ->  System.out.println("Resultado de la conversión: $" + resultado+ " ARS");
                       case 3 ->  System.out.println("Resultado de la conversión: $" + resultado+ " COP");
                       case 5 ->  System.out.println("Resultado de la conversión: $" + resultado+ " BRL");
                    }
                }else{
                        System.out.println("Resultado de la conversión: $" + resultado+ " USD");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


