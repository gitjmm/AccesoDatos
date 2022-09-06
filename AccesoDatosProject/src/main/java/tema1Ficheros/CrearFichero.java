package tema1Ficheros;

import java.io.File;
import java.io.IOException;

public class CrearFichero {

	public static void main(String[] args) {
		try {
			File f = new File("./","nuevofichero"); //Directorio,nombre_fichero
			f.createNewFile();
			
			//Ficheros temporales
			File temporal = File.createTempFile("temporal", ".txt");
			System.out.println(temporal.getAbsolutePath());
			
			File d = new File("./");
			
			//Comprobamos si es un  fichero
			if (f.isFile()) {
				System.out.println("Es un fichero");
			}else {
				System.out.println("No es un fichero");
			}
			
			if (d.isDirectory()) {
				System.out.println("Es un directorio");
			}
		}catch(IOException e) {
			System.out.println(e);
		}

	}

}
