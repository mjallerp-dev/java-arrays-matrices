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

    public void mostrarComoTabla() {
        System.out.println("Matriz 3x3 (tabla):");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public void recorrerPorColumnas() {
        System.out.println("Recorrido por columnas:");
        for (int j = 0; j < matriz[0].length; j++) {
            System.out.print("Columna " + j + ": ");
            for (int i = 0; i < matriz.length; i++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}
