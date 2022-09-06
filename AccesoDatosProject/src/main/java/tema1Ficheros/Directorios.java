package tema1Ficheros;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class Directorios {

	public static void main(String[] args) {
		File d = new File("./");
		//Lista de string
		if (d.isDirectory()){
			List<String> listaDirectorios = Arrays.asList(d.list());
			for (String l : listaDirectorios) {
				System.out.println(l);
			}
		}else {
			System.out.println("No es un directorio");
		}
		//Lista de ficheros
		if (d.isDirectory()){
			List<File> listaFicheros = Arrays.asList(d.listFiles());
			for (File l : listaFicheros) {
				System.out.println(l.getName());
			}
		}else {
			System.out.println("No es un directorio");
		}

	}

}
