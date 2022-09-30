/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema1Ficheros.Ejercicios;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 * 
 * Escribir un programa  que cree un array de bytes con 
 * los digitos de 0 a 9 y definir un flujo de entrada (ByteArrayInputStream) 
 * para leer sus valores de forma que lea uno y salte el siguiente.
 * Mostrarlos por pantalla.
 */
public class Ejercicio6 {
    
    public static void main(String args[]){
        //Creamos el array de bytes
        byte[] byteArr = {0,1,2,3,4,5,6,7,8,9};
        ByteArrayInputStream flujo = new ByteArrayInputStream(byteArr);
        while (flujo.available() != 0){
            //Leemos cada byte saltando uno y lo imprimimos
            byte leido = (byte) flujo.read();
            flujo.skip(1);
            System.out.println(leido);
        }
        try {
            flujo.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
