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
}
