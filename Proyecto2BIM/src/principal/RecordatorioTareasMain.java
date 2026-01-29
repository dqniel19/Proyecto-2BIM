/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package principal;
        import obtenerDatos.Funciones;
        import imprimirReporte.Reporte;
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

            String[] tareas = new String[100];
            int[] dias = new int[100];
            int[] meses = new int[100];
            int[] anios = new int[100];
            int[] estados = new int[100];
            String[] tiposPrioridad = new String[100];

            int contador = 0;
            boolean bandera = true;
            String rta;

            while (bandera) {

                tareas[contador] = Funciones.obtenerTarea();
                dias[contador] = Funciones.obtenerDia();
                meses[contador] = Funciones.obtenerMes();
                anios[contador] = Funciones.obtenerAnio();

                int prioridad = Funciones.obtenerPrioridad();
                tiposPrioridad[contador] = Funciones.clasificarPrioridad(prioridad);

                estados[contador] = Funciones.obtenerEstado();

                contador++;

                rta = Funciones.preguntarContinuar();
                if (!rta.equalsIgnoreCase("s")) {
                    bandera = false;
                }
            }

            Reporte.generarReporte(
                    tareas, dias, meses, anios,
                    tiposPrioridad, estados, contador
            );
        }
    }



