/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema1Ficheros.Ejercicios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Usuario
 * 
 */
public class Ejercicio10 {
    
    public static void main(String[] args) {
    //Escribimos 4 lineas en los dos ficheros
      try {
        FileWriter fw1 = new FileWriter("fichero1");
        FileWriter fw2 = new FileWriter("fichero2");
      for (int i = 1; i < 5; i++) {
          fw1.write("linea" + i +"\n");
          fw2.write("linea" + i +"\n");
      }
      //Leemos los dos ficheros. Usamos BufferedReader
      FileReader fr1 = new FileReader("fichero1");
      FileReader fr2 = new FileReader("fichero2");
      
    
      BufferedReader bf1 = new BufferedReader(fr1);
      BufferedReader bf2 = new BufferedReader(fr2);
      BufferedWriter bw = new BufferedWriter(new FileWriter("mezcla"));
    
      String linea1 = "";
      String linea2 = "";
      
      while ( (linea1 != null) || (linea2 != null) ) {
        linea1 = bf1.readLine();
        linea2 = bf2.readLine();
        
        if (linea1 != null) {
          bw.write(linea1 + "\n");
        }
        
        if (linea2 != null) {
          bw.write(linea2 + "\n");
        }
      } 
    
      bf1.close();
      bf2.close();
      bw.close();
    
    } catch (IOException ioe) {
      System.out.println("Se ha producido un error de lectura/escritura");
      System.err.println(ioe.getMessage());
    }
  }
}
