/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema1Ficheros.Ejercicios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Ejercicio3 {
    public static void main(String args[]){
    
    try {
      BufferedReader br = new BufferedReader(new FileReader("fichero1.txt"));
      Scanner sc = new Scanner(System.in);
      String palabra = sc.nextLine();
      String linea = "";
      int i = 0;
      int repeticiones = 0;
      
      while ((linea = br.readLine()) != null) {
        
        while ((i = linea.indexOf(palabra)) != -1) {
          linea = linea.substring(i + palabra.length(), linea.length());
          repeticiones++;
        }
      }
      
      br.close();
      
      System.out.println("La palabra " + palabra + " sale " + repeticiones + " veces");

    } catch (IOException ex) {
      ex.printStackTrace();
    }
    }
}
