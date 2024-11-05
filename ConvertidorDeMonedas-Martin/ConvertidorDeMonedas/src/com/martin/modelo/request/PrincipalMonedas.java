package com.martin.modelo.request;

import java.util.Map;

public record PrincipalMonedas(String base, Map<String, Double> rates, String date) {

    public double ARS() {
        return rates.getOrDefault("ARS", 0.0);
    }

    public double COP() {
        return rates.getOrDefault("COP", 0.0);
    }

    public double BRL() {
        return rates.getOrDefault("BRL", 0.0);
    }
}
