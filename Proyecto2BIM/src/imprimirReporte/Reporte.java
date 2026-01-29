/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package imprimirReporte;

/**
 *
 * @author AsusRog
 */
public class Reporte {

    public static void generarReporte(
            String[] tareas,
            int[] dias,
            int[] meses,
            int[] anios,
            String[] tiposPrioridad,
            int[] estados,
            int contador
    ) {
        int completadas = 0;
        int pendientes = 0;
        double porcentaje;
        String[] nombresMeses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo",
            "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre",
            "Diciembre"};

        // arreglo bidimensional: mes * prioridad
        // Se utilizará este arreglo para dar un reporte de las tareas POR MES
        //   alta media baja
        // m  0     0   1...
        // e
        // s
        // e
        // s
        int[][] resumen = new int[12][3];

        System.out.println("\n----- REPORTE FINAL -----\n");

        for (int i = 0; i < contador; i++) {

            System.out.println("Tarea " + (i + 1));
            System.out.println("Nombre: " + tareas[i]);
            System.out.println("Fecha: " + dias[i] + "/" + meses[i] + "/" + anios[i]);
            System.out.println("Prioridad: " + tiposPrioridad[i]);

            if (estados[i] == 1) {
                System.out.println("Estado: Completada");
                completadas = completadas + 1;
            } else {
                System.out.println("Estado: Pendiente");
                pendientes = pendientes + 1;
            }

            // llenar arreglo bidimensional
            int mesP = meses[i] - 1; // se utiliza - 1 para que coincida con el mes que ingresó el usuario
            int prioridadP;

            if (tiposPrioridad[i].equals("Alta")) {
                prioridadP = 0;
            } else if (tiposPrioridad[i].equals("Media")) {
                prioridadP = 1;
            } else {
                prioridadP = 2;
            }

            resumen[mesP][prioridadP] = resumen[mesP][prioridadP] + 1;

            System.out.println();
        }

        if (contador > 0) {
            porcentaje = (double) completadas * 100 / contador;
        } else {
            porcentaje = 00.00;
        }

        System.out.println("Total de tareas: " + contador);
        System.out.println("Completadas: " + completadas);
        System.out.println("Pendientes: " + pendientes);
        System.out.println("Porcentaje completadas: " + porcentaje + "%");

        System.out.println("\nResumen por mes y prioridad:");
        for (int i = 0; i < 12; i++) {
            if (resumen[i][0] > 0) {
                System.out.printf("%s: ", nombresMeses[i]);
            }
            if (resumen[i][0] > 0) {
                System.out.printf("Alta: %d |", resumen[i][0]);
            }
            if (resumen[i][1] > 0) {
                System.out.printf("Media: %d |", resumen[i][1]);
            }
            if (resumen[i][2] > 0) {
                System.out.printf("Baja: %d |", resumen[i][2]);
            }
        }
    }
}
