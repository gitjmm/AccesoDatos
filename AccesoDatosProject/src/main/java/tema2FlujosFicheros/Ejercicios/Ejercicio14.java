/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema2FlujosFicheros.Ejercicios;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;

/**
 *
 * @author Usuario
 */
public class Ejercicio14 {
    public static void main(String[] args) {
        StreamTokenizer st = new StreamTokenizer(new StringReader("Modulo Acceso a Datos 2"));
        int numPalabras = 0;
        int numNumeros = 0;
        //Mientras el token que leemos no sea final de fichero TT_EOF
        try {
                while(st.nextToken() != StreamTokenizer.TT_EOF) {
                        //Si es una palabra (caracteres)
                        if (st.ttype == StreamTokenizer.TT_WORD) {
                                System.out.println("Palabra: "+st.sval);
                                numPalabras++;
                        //Si son números
                        }else if (st.ttype == StreamTokenizer.TT_NUMBER) {
                                System.out.println("Número: "+st.nval);
                                numNumeros++;
                        //Si finaliza el fichero
                        }else if (st.ttype == StreamTokenizer.TT_EOL) {
                                System.out.println();
                        }
                }
                System.out.println("Palabras: "+numPalabras+" "+"Numeros: "+numNumeros);
        } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }

	}
}
