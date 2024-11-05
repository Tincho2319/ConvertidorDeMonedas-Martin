package com.martin.modelo.principal;

import com.google.gson.JsonObject;
import com.martin.modelo.request.PrincipalRequest;
import com.martin.modelo.request.CreandoArchivo;
import com.martin.modelo.request.PrincipalConversor;

import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);


        PrincipalRequest apiRequest = new PrincipalRequest();
        JsonObject conversionRates = apiRequest.recibiendoDatos();

        if (conversionRates != null) {

            Set<String> clavesEspecificas = Set.of("ARS", "COP", "BRL");


            CreandoArchivo archivo = new CreandoArchivo();
            archivo.guardarJsonEnArchivo(conversionRates, clavesEspecificas, "conversion_rates.json");


            PrincipalConversor conversor = new PrincipalConversor("conversion_rates.json");


            while (true) {
                System.out.println("***********************************************************");
                System.out.println("Bienvenido/a al Exchange MRTN-Alura");
                System.out.println("1) Dolar >>> Peso Argentino");
                System.out.println("2) Peso Argentino >>> Dolar");
                System.out.println("3) Dolar >>> Peso Colombiano");
                System.out.println("4) Peso Colombiano >>> Dolar");
                System.out.println("5) Dolar >>> Real Brasileño");
                System.out.println("6) Real Brasileño >>> Dolar");
                System.out.println("7) Salir");
                System.out.println("Elija una opción válida para realizar las conversiones");
                System.out.println("***********************************************************");
                int opcion = teclado.nextInt();

                if (opcion == 7) {
                    System.out.println("Saliendo del programa.");
                    break;
                }

                conversor.iniciarConversor(opcion);
            }
        } else {
            System.err.println("Error al recuperar las tasas de cambio. El programa se cerrará.");
        }
    }
}
