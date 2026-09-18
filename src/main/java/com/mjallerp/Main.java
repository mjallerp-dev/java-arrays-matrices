package com.mjallerp;

import com.mjallerp.service.Arreglos;
import com.mjallerp.service.Matrices;

import java.util.Scanner;

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

        Scanner scanner = new Scanner(System.in);
        System.out.print("Valor a buscar: ");
        int valor = scanner.nextInt();
        int indice = arreglos.buscarLineal(valor);
        if (indice >= 0) {
            System.out.println("Encontrado en el índice " + indice);
        } else {
            System.out.println("No se encontró el valor");
        }
        scanner.close();

        Matrices matrices = new Matrices();
        matrices.crearMatriz();
        matrices.mostrarComoTabla();
        matrices.recorrerPorColumnas();

        System.out.println("Suma de elementos: " + matrices.sumarElementos());
        matrices.intercambiarPrimeraYUltimaFila();
        System.out.println("Primera y última fila intercambiadas:");
        matrices.mostrarComoTabla();
    }
}
