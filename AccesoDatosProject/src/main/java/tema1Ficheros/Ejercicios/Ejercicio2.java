/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema1Ficheros.Ejercicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Usuario
 */
public class Ejercicio2 {
    public static void muestraFichero() {
        FileReader fr = null;
 
        try {
            File fichero = new File("frase.txt");
            fr = new FileReader(fichero);
            int letra;
            char caracter;
            letra = fr.read();
            while (letra != -1) {
                caracter=(char)letra;
                if (caracter != ' ')
                    System.out.print(caracter);
                letra = fr.read();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            if (fr != null) {
                try {
                    fr.close();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
//    public static void leerFichero(FileReader fr) throws Exception{
//        int letra;
//        char caracter;
//        letra = fr.read();
//        while (letra != -1) {
//            caracter=(char)letra;
//            System.out.print(caracter);
//            letra = fr.read();
//        }
//    }
    public static void main(String[] args) {
        muestraFichero();
    }
 
}


