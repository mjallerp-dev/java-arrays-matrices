package com.mjallerp;

import com.mjallerp.service.Arreglos;

public class Main {
    public static void main(String[] args) {
        Arreglos arreglos = new Arreglos();
        arreglos.crearArreglo();

        System.out.println("Arreglo original:");
        arreglos.mostrarConForClasico();
        arreglos.mostrarConForEach();

        arreglos.cambiarImparesPorCero();
        System.out.println("Impares cambiados por cero:");
        arreglos.mostrarConForClasico();

        arreglos.multiplicarPorIndice();
        System.out.println("Valores multiplicados por su índice:");
        arreglos.mostrarConForClasico();
    }
}
