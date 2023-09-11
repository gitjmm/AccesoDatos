/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema2FlujosFicheros;
import java.io.*;
/**
 *
 * @author Jorge Martínez
 */
public class MiDataStream2 {
    public static void main(String[] args) {
 
        try(DataOutputStream dos=new DataOutputStream(new FileOutputStream("fich_binario.dat"));){
 
            //Escribimos un numero
            dos.writeInt(40);
 
            //Escribimos una cadena
            dos.writeUTF("Alumno");
 
            //Escribimos un numero
            dos.writeInt(200);
        }catch(IOException e){
            System.out.println("Error Otuput E/S");
        }  
        
        try(DataInputStream dis=new DataInputStream(new FileInputStream("fich_binario.dat"));){
 
            //Leemos un numero y lo mostramos
            System.out.println(dis.readInt());
 
            //Leemos una cadena y lo mostramos
            System.out.println(dis.readUTF());
 
            //Leemos un numero y lo mostramos
            System.out.println(dis.readInt());
 
        }catch(IOException e){
            System.out.println("Error Input E/S");
        }
        
    }
}

