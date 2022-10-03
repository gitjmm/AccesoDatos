/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema1Ficheros.Ejercicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 *
 * @author Usuario
 */
public class Ejercicio5 {
    
    public static void mostrarFichero() {
        FileReader fr = null;
        try {
            File fichero = new File("nuevonumeros.txt");
            fr = new FileReader(fichero);
            BufferedReader br = new BufferedReader(fr);
            leerFichero(br);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
 
    public static void leerFichero(BufferedReader br) throws Exception {
        String linea;
        int suma = 0;
        int num;
 
        linea = br.readLine();
 
        while (linea != null) {
 
            num = Integer.parseInt(linea);
            suma = suma + num;
            linea = br.readLine();
        }
        System.out.println("La suma de los numeros es: " + suma);
    }
 
    public static void main(String[] args) {
        mostrarFichero();
    }
 
}

