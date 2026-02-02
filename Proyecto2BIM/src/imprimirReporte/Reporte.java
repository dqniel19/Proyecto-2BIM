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
        String reporte = "";
        String[] nombresMeses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo",
            "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre",
            "Diciembre"};

        int[][] resumen = new int[12][3];

        reporte = reporte + "\n----- REPORTE FINAL -----\n\n";

        for (int i = 0; i < contador; i++) {

            reporte = reporte + "Tarea " + (i + 1) + "\n";
            reporte = reporte + "Nombre: " + tareas[i] + "\n";
            reporte = reporte + "Fecha: " + dias[i] + "/" + meses[i] + "/" + anios[i] + "\n";
            reporte = reporte + "Prioridad: " + tiposPrioridad[i] + "\n";

            if (estados[i] == 1) {
                reporte = reporte + "Estado: Completada\n";
                completadas = completadas + 1;
            } else {
                reporte = reporte + "Estado: Pendiente\n";
                pendientes = pendientes + 1;
            }

            reporte = reporte + "\n";

            // llenar arreglo bidimensional
            int mesP = meses[i] - 1; // se utiliza - 1 para que coincida con el mes que ingresó el usuario
            int prioridadP;          // con la finalidad de que coincida en la posición de los arreglos

            if (tiposPrioridad[i].equals("Alta")) { // Se almacena en el arreglo prioridadP el valor correspondiente
                prioridadP = 0;                     // al tipo de prioridad clasificado
            } else if (tiposPrioridad[i].equals("Media")) {
                prioridadP = 1;
            } else {
                prioridadP = 2;
            }

            resumen[mesP][prioridadP] = resumen[mesP][prioridadP] + 1; // 0 (de la posición por defecto) + 1 
            // arreglo bidimensional: mes * prioridad
            // Se utilizará este arreglo para dar un reporte de las tareas POR MES
            //   alta0 media1 baja2
            // m   0     0      0...
            // e
            // s
            // e
            // s

        }

        if (contador > 0) {
            porcentaje = (double) completadas * 100 / contador;
        } else {
            porcentaje = 00.00;
        }

        reporte = reporte + "Total de tareas: " + contador + "\n";
        reporte = reporte + "Completadas: " + completadas + "\n";
        reporte = reporte + "Pendientes: " + pendientes + "\n";
        reporte = reporte + "Porcentaje completadas: " + porcentaje + "%\n";

        reporte = reporte + "\nResumen por mes y prioridad:\n";
        for (int i = 0; i < 12; i++) {

            if (resumen[i][0] > 0 || resumen[i][1] > 0 || resumen[i][2] > 0) {

                reporte = reporte + nombresMeses[i] + ": ";

                if (resumen[i][0] > 0) {
                    reporte = reporte + "Alta: " + resumen[i][0] + "\t";
                }
                if (resumen[i][1] > 0) {
                    reporte = reporte + "Media: " + resumen[i][1] + "\t";
                }
                if (resumen[i][2] > 0) {
                    reporte = reporte + "Baja: " + resumen[i][2] + "\t";
                }

                reporte = reporte + "\n";
            }
        }
        
        System.out.println(reporte);

    }
}
