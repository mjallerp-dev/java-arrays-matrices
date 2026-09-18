package com.mjallerp.service;

import com.mjallerp.model.Texto;

import java.util.Locale;

public class AnalizadorTexto {

    public String normalizar(String contenido) {
        if (contenido == null || contenido.isBlank()) {
            return "";
        }
        String enMinusculas = contenido.toLowerCase(Locale.forLanguageTag("es-ES"));
        return enMinusculas.replaceAll("[^\\p{L}\\p{N}]+", " ").trim();
    }

    public void guardarPalabras(Texto texto) {
        String normalizado = normalizar(texto.getContenido());
        if (normalizado.isEmpty()) {
            texto.setPalabras(new String[0]);
            return;
        }
        texto.setPalabras(normalizado.split("\\s+"));
    }

    public void contarRepeticiones(Texto texto) {
        String[] palabras = texto.getPalabras();
        String[] unicas = new String[palabras.length];
        int[] conteos = new int[palabras.length];
        int cantidad = 0;

        for (int i = 0; i < palabras.length; i++) {
            int indice = buscar(unicas, cantidad, palabras[i]);
            if (indice == -1) {
                unicas[cantidad] = palabras[i];
                conteos[cantidad] = 1;
                cantidad++;
            } else {
                conteos[indice]++;
            }
        }

        String[] unicasFinal = new String[cantidad];
        int[] conteosFinal = new int[cantidad];
        for (int i = 0; i < cantidad; i++) {
            unicasFinal[i] = unicas[i];
            conteosFinal[i] = conteos[i];
        }
        texto.setPalabrasUnicas(unicasFinal);
        texto.setFrecuencias(conteosFinal);
    }

    public int obtenerTop5(Texto texto) {
        String[] unicas = texto.getPalabrasUnicas();
        int[] frecuencias = texto.getFrecuencias();
        int n = unicas.length;

        for (int i = 0; i < n - 1; i++) {
            int mejor = i;
            for (int j = i + 1; j < n; j++) {
                if (vaAntes(unicas, frecuencias, j, mejor)) {
                    mejor = j;
                }
            }
            if (mejor != i) {
                String palabraTmp = unicas[i];
                unicas[i] = unicas[mejor];
                unicas[mejor] = palabraTmp;

                int frecuenciaTmp = frecuencias[i];
                frecuencias[i] = frecuencias[mejor];
                frecuencias[mejor] = frecuenciaTmp;
            }
        }

        return Math.min(5, n);
    }

    private boolean vaAntes(String[] unicas, int[] frecuencias, int origen, int destino) {
        if (frecuencias[origen] != frecuencias[destino]) {
            return frecuencias[origen] > frecuencias[destino];
        }
        return unicas[origen].compareTo(unicas[destino]) < 0;
    }

    private int buscar(String[] unicas, int cantidad, String palabra) {
        for (int i = 0; i < cantidad; i++) {
            if (unicas[i].equals(palabra)) {
                return i;
            }
        }
        return -1;
    }
}
