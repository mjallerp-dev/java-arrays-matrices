package com.mjallerp;

import com.mjallerp.model.Texto;
import com.mjallerp.service.AnalizadorTexto;
import com.mjallerp.service.Arreglos;
import com.mjallerp.service.Matrices;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Arreglos arreglos = new Arreglos();
        Matrices matrices = new Matrices();
        AnalizadorTexto analizador = new AnalizadorTexto();
        boolean arregloCreado = false;
        boolean matrizCreada = false;
        Texto texto = null;
        boolean salir = false;

        while (!salir) {
            System.out.println();
            System.out.println("1. Gestión de Arreglos");
            System.out.println("2. Gestión de Matrices");
            System.out.println("3. Analizar Texto");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            String opcion = scanner.nextLine().trim();

            if ("1".equals(opcion)) {
                arregloCreado = menuArreglos(scanner, arreglos, arregloCreado);
            } else if ("2".equals(opcion)) {
                matrizCreada = menuMatrices(matrices, matrizCreada, scanner);
            } else if ("3".equals(opcion)) {
                texto = menuTexto(scanner, analizador, texto);
            } else if ("0".equals(opcion)) {
                salir = true;
            } else {
                System.out.println("Opción no válida.");
            }
        }

        scanner.close();
    }

    private static boolean menuArreglos(Scanner scanner, Arreglos arreglos, boolean creado) {
        boolean volver = false;
        while (!volver) {
            System.out.println();
            System.out.println("Gestión de Arreglos");
            System.out.println("1. Crear arreglo (10 enteros aleatorios)");
            System.out.println("2. Mostrar con for clásico");
            System.out.println("3. Mostrar con for-each");
            System.out.println("4. Cambiar impares por cero");
            System.out.println("5. Multiplicar por índice");
            System.out.println("6. Búsqueda lineal");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            String opcion = scanner.nextLine().trim();

            if ("1".equals(opcion)) {
                arreglos.crearArreglo();
                creado = true;
                System.out.println("Arreglo creado.");
            } else if ("0".equals(opcion)) {
                volver = true;
            } else if (!creado) {
                System.out.println("Primero debe crear el arreglo.");
            } else if ("2".equals(opcion)) {
                arreglos.mostrarConForClasico();
            } else if ("3".equals(opcion)) {
                arreglos.mostrarConForEach();
            } else if ("4".equals(opcion)) {
                arreglos.cambiarImparesPorCero();
                System.out.println("Impares cambiados por cero.");
            } else if ("5".equals(opcion)) {
                arreglos.multiplicarPorIndice();
                System.out.println("Valores multiplicados por su índice.");
            } else if ("6".equals(opcion)) {
                System.out.print("Valor a buscar: ");
                String entrada = scanner.nextLine().trim();
                try {
                    int valor = Integer.parseInt(entrada);
                    int indice = arreglos.buscarLineal(valor);
                    if (indice >= 0) {
                        System.out.println("Encontrado en el índice " + indice);
                    } else {
                        System.out.println("No se encontró el valor");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Debe ingresar un número entero.");
                }
            } else {
                System.out.println("Opción no válida.");
            }
        }
        return creado;
    }

    private static boolean menuMatrices(Matrices matrices, boolean creada, Scanner scanner) {
        boolean volver = false;
        while (!volver) {
            System.out.println();
            System.out.println("Gestión de Matrices");
            System.out.println("1. Crear matriz 3x3 (1 a 9)");
            System.out.println("2. Sumar elementos");
            System.out.println("3. Intercambiar primera y última fila");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            String opcion = scanner.nextLine().trim();

            if ("1".equals(opcion)) {
                matrices.crearMatriz();
                creada = true;
                System.out.println("Matriz creada.");
                matrices.mostrarComoTabla();
                matrices.recorrerPorColumnas();
            } else if ("2".equals(opcion)) {
                if (!creada) {
                    System.out.println("Primero debe crear la matriz.");
                } else {
                    System.out.println("Suma de elementos: " + matrices.sumarElementos());
                }
            } else if ("3".equals(opcion)) {
                if (!creada) {
                    System.out.println("Primero debe crear la matriz.");
                } else {
                    matrices.intercambiarPrimeraYUltimaFila();
                    System.out.println("Primera y última fila intercambiadas.");
                    matrices.mostrarComoTabla();
                }
            } else if ("0".equals(opcion)) {
                volver = true;
            } else {
                System.out.println("Opción no válida.");
            }
        }
        return creada;
    }

    private static Texto menuTexto(Scanner scanner, AnalizadorTexto analizador, Texto texto) {
        boolean volver = false;
        while (!volver) {
            System.out.println();
            System.out.println("Analizar Texto");
            System.out.println("1. Leer párrafo");
            System.out.println("2. Mostrar Top 5 de palabras frecuentes");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            String opcion = scanner.nextLine().trim();

            if ("1".equals(opcion)) {
                System.out.println("Ingrese un párrafo:");
                String parrafo = scanner.nextLine();
                texto = new Texto(parrafo);
                analizador.guardarPalabras(texto);
                System.out.println("Párrafo leído y palabras guardadas en el arreglo.");
            } else if ("2".equals(opcion)) {
                if (texto == null) {
                    System.out.println("Primero debe leer un párrafo.");
                } else {
                    analizador.contarRepeticiones(texto);
                    int top = analizador.obtenerTop5(texto);
                    System.out.println("Top 5 palabras más frecuentes:");
                    if (top == 0) {
                        System.out.println("(no hay palabras para ranking)");
                    } else {
                        for (int i = 0; i < top; i++) {
                            System.out.println((i + 1) + ". " + texto.getPalabrasUnicas()[i]
                                    + " -> " + texto.getFrecuencias()[i]);
                        }
                    }
                }
            } else if ("0".equals(opcion)) {
                volver = true;
            } else {
                System.out.println("Opción no válida.");
            }
        }
        return texto;
    }
}
