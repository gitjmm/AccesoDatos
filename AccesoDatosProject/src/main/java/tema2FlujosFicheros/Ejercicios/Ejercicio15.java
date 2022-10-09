/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema2FlujosFicheros.Ejercicios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;

/**
 *
 * @author Usuario
 */
public class Ejercicio15 {
    public static void main(String args[]){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("copia.txt"));
            LineNumberReader lineNumberReader = new LineNumberReader(new FileReader("texto.txt"));
            String linea = lineNumberReader.readLine();
            while (linea != null){
                System.out.println("Numero linea: "+lineNumberReader.getLineNumber()+ " "+ linea);
                bw.write(linea+" ");
                linea = lineNumberReader.readLine();
            }
            bw.close();
            lineNumberReader.close();
            
            //Leer archivo copia.txt y mostrar por pantalla
            BufferedReader br = new BufferedReader(new FileReader("copia.txt"));
            String milinea;
            while ((milinea = br.readLine()) != null){
                System.out.println(milinea+"\n");
            }
            br.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
             ex.printStackTrace();
        }
    }
}
