/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema1Ficheros.Ejercicios;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Ejercicio4 {
    public static void main(String[] args){
    // Propiedades
          String directorio;
          File actual = null;
          Scanner sc = new Scanner(System.in);
          
          directorio = sc.nextLine();
         
          try{
                actual = new File(directorio);
                if(actual.isDirectory()){
                     String[] contenido = actual.list();
                     for(int i = 0; i < contenido.length; i++){
                          System.out.println(contenido[i]);
                     }
                } 
                else
                     System.out.println("El directorio no es válido");
          }
          catch(Exception e){
                e.printStackTrace();
          }
     }
    }

