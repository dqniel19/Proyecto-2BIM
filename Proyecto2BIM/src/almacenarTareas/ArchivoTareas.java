/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package almacenarTareas;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Formatter;
import java.io.File;
import java.util.Scanner;

public class ArchivoTareas {

    public static void guardarTarea(String registro) {
        // método para guardar tareas en el .txt
        try {
            FileOutputStream fos = new FileOutputStream("data/tareas.txt", true);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            Formatter salida = new Formatter(osw);

            salida.format("%s\n", registro);  // cada tarea en una línea
            salida.close();

        } catch (Exception e) {
            System.err.println("Error al guardar la tarea.");
        }
    }

    
    public static int cargarTareas(
            // método que lee el .txt y llena los arreglos para 
            String[] tareas,
            int[] dias,
            int[] meses,
            int[] anios,
            String[] prioridades,
            int[] estados) {

        int contador = 0;

        try {
            File archivo = new File("data/tareas.txt");
            Scanner lector = new Scanner(archivo);

            while (lector.hasNextLine()) {

                String linea = lector.nextLine();

                // 🔹 Se separa por ;
                String[] partes = linea.split(";");

                tareas[contador] = partes[0];
                dias[contador] = Integer.parseInt(partes[1]);
                meses[contador] = Integer.parseInt(partes[2]);
                anios[contador] = Integer.parseInt(partes[3]);
                prioridades[contador] = partes[4];
                estados[contador] = Integer.parseInt(partes[5]);

                contador = contador + 1;
            }

            lector.close();

        } catch (Exception e) {
            System.err.println("No existe el archivo todavía.");
        }

        return contador;  
    }
}

