/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema2FlujosFicheros.Ejercicios;
import java.util.StringTokenizer;
import java.util.Scanner;
 
/**
 *
 * @author Usuario
 */
public class Ejercicio13 {
  
 public static void main(String[] args) {
 
    //Leer por teclado la frase correspondiente
    Scanner miScanner = new Scanner(System.in);
    System.out.println("Introduce una frase: ");
    //Se almacena la frase en una variable
    String frase = miScanner.nextLine().toLowerCase();
    //Se crea el objeto token de la clase StringTokenizer
    StringTokenizer token = new StringTokenizer(frase);
    //Variable que almacenará la palabra que queramos buscar
    String palabraBuscar;
    //Variable que almacena el número de veces que aparece la palabra
    int contador = 0;
    System.out.print("Introduce la palabra a contar: ");
    //Se introduce la palabra a buscar
    palabraBuscar = miScanner.nextLine().toLowerCase();
    //Bucle que incrementa mientras haya tokens
    while(token.hasMoreTokens()) {
        if(token.nextElement().equals(palabraBuscar)) {
            contador++;
        }
      }
    System.out.println("La frase '" + frase + "'\ncontiene " + contador + " veces la palabra '" + palabraBuscar + "'");
    }
}
 


