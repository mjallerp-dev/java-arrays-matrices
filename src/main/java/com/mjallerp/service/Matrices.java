package com.mjallerp.service;

public class Matrices {

    private int[][] matriz = new int[3][3];

    public void crearMatriz() {
        int valor = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matriz[i][j] = valor;
                valor++;
            }
        }
    }
}
