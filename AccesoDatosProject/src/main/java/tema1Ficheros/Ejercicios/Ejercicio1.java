/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema1Ficheros.Ejercicios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Usuario
 * Escribe un programa que guarde en un fichero de nombre pares,
 * los números pares que hay entre 1 y 200.
 */
public class Ejercicio1 {
    
    public static void main(String[] args) {
    try {
      FileWriter fw = new FileWriter("pares");
      for (int i = 1; i < 301; i++) {
        if (i % 2 == 0) {
          fw.write(String.valueOf(i) + "\n");
        }
      }
      fw.close();

    } catch (IOException ioe) {
        System.out.println("Error");
    }
  }

}

