/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema1Ficheros.Ejercicios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Usuario
 */
public class Ejercicio2 {
    public static void main(String[] args){
    try {
      BufferedReader br = new BufferedReader(new FileReader("pares"));
      
      String linea = "";
      while (linea != null) {
        System.out.print(linea + " ");
        linea = br.readLine();
      } 
      System.out.println();
      br.close();
      
    } catch (IOException e) {
      System.out.println("Error de lectura");
    }
    }
}
