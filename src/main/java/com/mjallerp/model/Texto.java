package com.mjallerp.model;

public class Texto {
    private String contenido;
    private String[] palabras;
    private String[] palabrasUnicas;
    private int[] frecuencias;

    public Texto(String contenido) {
        this.contenido = contenido;
        this.palabras = new String[0];
        this.palabrasUnicas = new String[0];
        this.frecuencias = new int[0];
    }

    public String getContenido() {
        return contenido;
    }

    public String[] getPalabras() {
        return palabras;
    }

    public void setPalabras(String[] palabras) {
        this.palabras = palabras;
    }

    public String[] getPalabrasUnicas() {
        return palabrasUnicas;
    }

    public void setPalabrasUnicas(String[] palabrasUnicas) {
        this.palabrasUnicas = palabrasUnicas;
    }

    public int[] getFrecuencias() {
        return frecuencias;
    }

    public void setFrecuencias(int[] frecuencias) {
        this.frecuencias = frecuencias;
    }
}
