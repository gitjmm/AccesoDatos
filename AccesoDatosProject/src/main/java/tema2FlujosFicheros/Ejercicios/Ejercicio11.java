/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema2FlujosFicheros.Ejercicios;
import java.io.*;
import java.io.IOException;
/**
 *
 * @author Usuario
 */
public class Ejercicio11 {
    
    public static void main(String[] args) {
         
          // Propiedades
          String nombre_archivo = "personas.txt";
          String[] personas = {"Juan", "Pepe", "Ana", "Luis", "Patricia"};
          double[] alturas = {1.83, 2.00, 1.99, 1.65, 1.74};
          
         
          // Código
          try{
                mostrarPersonas(personas, alturas, nombre_archivo);
                System.out.println("Fichero de personas generado correctamente");
          }
          catch(IOException e){
                e.printStackTrace();
          }
         
     }


     // Métodos
     public static void mostrarPersonas(String[] personas, double[] alturas, String nombre_archivo) throws IOException{
          FileWriter fW = new FileWriter(nombre_archivo);
          BufferedWriter bW = new BufferedWriter(fW);
         
          for(int i = 0; i < personas.length; i++){
                bW.write(String.valueOf(personas[i]) + " - " + String.valueOf(alturas[i]) + "m");
                bW.newLine();
          }
         
          bW.close();
          fW.close();
     }
}


