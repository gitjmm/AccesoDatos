/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema1Ficheros.Ejercicios;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 * Escribir un programa 
 */
public class Ejercicio7 {
    public static void main(String args[]){
        FileOutputStream archivo = null;
        try {
            archivo = new FileOutputStream("numeros");
            for (int i=0; i<100; i++){
                archivo.write(i);
            }   archivo.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                archivo.close();
            } catch (IOException ex) {
               ex.printStackTrace();
            }
        }
    }
}
