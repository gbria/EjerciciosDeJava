package Objetivo12;

import java.io.*;

public class O12_Ej3 {
    public static void main(String[] args) {
        String ruta = "nuevo.txt";
        String linea = null;
        File fichero = new File(ruta);
        if (fichero.exists()) {
            System.out.println("ERROR: el fichero " + ruta + " ya existe");
        } else {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(ruta));
                //Bucle que escribe el número de la fila de 0 a 9
                for (int i = 0; i < 10; i++) {
                    writer.write("Fila números " + i + "\n");
                }
                //Cierra el fichero
                writer.close();
                //Chivato
                System.out.println("Fichero creado y escritura completada");

                //Inicio de la lectura del fichero
                System.out.println("-- Lectura del fichero --");
                BufferedReader reader = null;
                reader = new BufferedReader(new FileReader(ruta));
                //Lee la primera fila
                linea = reader.readLine();
                //Bucle que lee todas las líneas
                while (linea!=null){
                    System.out.println(linea);
                    linea = reader.readLine();
                }
                reader.close();
            } catch (IOException e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        }
    }
}
