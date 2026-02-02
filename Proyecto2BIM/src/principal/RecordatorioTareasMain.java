/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package principal;

import obtenerDatos.Funciones;
import imprimirReporte.Reporte;
import almacenarTareas.ArchivoTareas;
import java.util.Scanner;

/**
 *
 * @author AsusRog
 */
public class RecordatorioTareasMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner entrada = new Scanner(System.in);

        boolean bandera = true;
        int opcion;

        while (bandera) {

            System.out.println("\n----- MENU -----");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Ver reporte");
            System.out.println("3. Salir");
            opcion = entrada.nextInt();

            if (opcion == 1) {

                int contador = 0;
                String[] tareas = new String[100];
                int[] dias = new int[100];
                int[] meses = new int[100];
                int[] anios = new int[100];
                int[] estados = new int[100];
                String[] tiposPrioridad = new String[100];

                boolean continuar = true;
                String rta;

                while (continuar) {

                    tareas[contador] = Funciones.obtenerTarea();
                    dias[contador] = Funciones.obtenerDia();
                    meses[contador] = Funciones.obtenerMes();
                    anios[contador] = Funciones.obtenerAnio();

                    int prioridad = Funciones.obtenerPrioridad();
                    tiposPrioridad[contador] = Funciones.clasificarPrioridad(prioridad);

                    estados[contador] = Funciones.obtenerEstado();

                    // se separan los datos para guardarse en el archivo
                    String registro = tareas[contador] + ";"
                            + dias[contador] + ";"
                            + meses[contador] + ";"
                            + anios[contador] + ";"
                            + tiposPrioridad[contador] + ";"
                            + estados[contador];

                    ArchivoTareas.guardarTarea(registro);

                    contador++;

                    rta = Funciones.preguntarContinuar();
                    if (!rta.equalsIgnoreCase("s")) {
                        continuar = false;
                    }
                }
            }

            // opcion 2 = lee archivo e imprime reporte, si no se ingresa nada aun
            // aparecerá un msj junto al menú
            if (opcion == 2) {

                String[] tareas = new String[100];
                int[] dias = new int[100];
                int[] meses = new int[100];
                int[] anios = new int[100];
                int[] estados = new int[100];
                String[] tiposPrioridad = new String[100];

                int contador = ArchivoTareas.cargarTareas(
                        tareas, dias, meses, anios, tiposPrioridad, estados);

                Reporte.generarReporte(
                        tareas, dias, meses, anios,
                        tiposPrioridad, estados, contador);
            }

            // opcion 3 = sale del programa
            if (opcion == 3) {
                bandera = false;
            }
        }
    }
}
