/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package obtenerDatos;

/**
 *
 * @author AsusRog
 */
import java.util.Scanner;

public class Funciones {

    static Scanner sc = new Scanner(System.in);

    public static String obtenerTarea() {
        System.out.print("Ingrese el nombre de la tarea: ");
        return sc.nextLine();
    }

    public static int obtenerDia() {
        System.out.print("Ingrese el día: ");
        return sc.nextInt();
    }

    public static int obtenerMes() {
        System.out.print("Ingrese el mes: ");
        return sc.nextInt();
    }

    public static int obtenerAnio() {
        System.out.print("Ingrese el año: ");
        return sc.nextInt();
    }

    public static int obtenerPrioridad() {
        System.out.print("Ingrese la prioridad (1 Alta, 2 Media, 3 Baja): ");
        return sc.nextInt();
    }

    public static int obtenerEstado() {
        System.out.print("Ingrese el estado (0 Pendiente, 1 Completada): ");
        return sc.nextInt();
    }

    public static String clasificarPrioridad(int prioridad) {
        if (prioridad == 1) {
            return "Alta";
        }
        if (prioridad == 2) {
            return "Media";
        }
        if (prioridad == 3) {
            return "Baja";
        }
        return "No especificada";
    }

    public static String preguntarContinuar() {
        sc.nextLine(); // limpiar buffer
        System.out.print("¿Desea ingresar otra tarea? (s/n): ");
        return sc.nextLine();
    }
}
