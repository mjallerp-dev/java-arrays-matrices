package com.mjallerp.service;

import java.util.Random;

public class Arreglos {

    private int[] numeros = new int[10];

    public int[] crearArreglo() {
        Random random = new Random();
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = random.nextInt(100);
        }
        return numeros;
    }

    public void mostrarConForClasico() {
        System.out.println("Recorrido con for clásico:");
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("[" + i + "] = " + numeros[i]);
        }
    }

    public void mostrarConForEach() {
        System.out.println("Recorrido con for-each:");
        for (int numero : numeros) {
            System.out.println(numero);
        }
    }

    public void cambiarImparesPorCero() {
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] % 2 != 0) {
                numeros[i] = 0;
            }
        }
    }

    public void multiplicarPorIndice() {
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = numeros[i] * i;
        }
    }
}
