/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.grupo_3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author DAVID
 */
public class Grupo_3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            // Mostrar el menú
            System.out.println("===== MENÚ DE HERRAMIENTAS =====");
            System.out.println("1. Calcular MCM de dos números");
            System.out.println("2. Sumar los dígitos de un número");
            System.out.println("3. Juego: Adivinar un número");
            System.out.println("4. Simular cajero automático");
            System.out.println("5. Ordenar lista de números");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            System.out.println();

            switch (opcion) {
                case 1:
                    calcularMCM(scanner);
                    break;
                case 2:
                    sumarDigitos(scanner);
                    break;
                case 3:
                    juegoAdivinarNumero(scanner);
                    break;
                case 4:
                    simuladorCajero(scanner);
                    break;
                case 5:
                    ordenarLista(scanner);
                    break;
                case 0:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }

            System.out.println(); // línea en blanco antes de repetir
        } while (opcion != 0);

        scanner.close();
    }

    // Caso 1: Calcular MCM de dos números
    public static void calcularMCM(Scanner scanner) {
        System.out.print("Ingrese el primer número: ");
        int a = scanner.nextInt();
        System.out.print("Ingrese el segundo número: ");
        int b = scanner.nextInt();
        int mcm = (a * b) / calcularMCD(a, b);
        System.out.printf("El MCM de %d y %d es: %d%n", a, b, mcm);
    }

    // Algoritmo de Euclides para calcular el MCD
    private static int calcularMCD(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }

    // Caso 2: Sumar los dígitos de un número
    public static void sumarDigitos(Scanner scanner) {
        System.out.print("Ingresa un número entero: ");
        int num = scanner.nextInt();
        num = Math.abs(num);
        int suma = 0;
        while (num > 0) {
            suma += num % 10;
            num /= 10;
        }
        System.out.println("La suma de los dígitos es: " + suma);
    }

    // Caso 3: Juego de adivinar el número
    public static void juegoAdivinarNumero(Scanner scanner) {
        Random rnd = new Random();
        int secreto = rnd.nextInt(100) + 1;
        int intento, cont = 0;
        System.out.println("¡Bienvenido al juego de adivinar el número!");
        System.out.println("Estoy pensando en un número entre 1 y 100.");

        do {
            System.out.print("Introduce tu intento: ");
            intento = scanner.nextInt();
            cont++;
            if (intento < secreto) {
                System.out.println("Demasiado bajo.");
            } else if (intento > secreto) {
                System.out.println("Demasiado alto.");
            } else {
                System.out.printf("¡Correcto! Adivinaste en %d intentos.%n", cont);
            }
        } while (intento != secreto);
    }

    // Caso 4: Simulador de cajero automático
    public static void simuladorCajero(Scanner scanner) {
        double saldo = 500.00;
        int op;
        do {
            System.out.println("===== Cajero Automático =====");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Retirar dinero");
            System.out.println("3. Volver al menú principal");
            System.out.print("Elige una opción: ");
            op = scanner.nextInt();

            switch (op) {
                case 1:
                    System.out.printf("Tu saldo actual es: $%.2f%n", saldo);
                    break;
                case 2:
                    System.out.print("¿Cuánto deseas retirar? $");
                    double retiro = scanner.nextDouble();
                    if (retiro > 0 && retiro <= saldo) {
                        saldo -= retiro;
                        System.out.printf("Has retirado $%.2f. Nuevo saldo: $%.2f%n", retiro, saldo);
                    } else {
                        System.out.println("Cantidad inválida o saldo insuficiente.");
                    }
                    break;
                case 3:
                    System.out.println("Regresando al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
            System.out.println();
        } while (op != 3);
    }

    // Caso 5: Ordenar una lista de números
    public static void ordenarLista(Scanner scanner) {
        System.out.print("¿Cuántos números deseas ingresar? ");
        int n = scanner.nextInt();
        int[] nums = new int[n];

        System.out.println("Ingresa los números:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        // Ordenamiento burbuja
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
        }

        System.out.println("Números ordenados: " + Arrays.toString(nums));
    }
}

