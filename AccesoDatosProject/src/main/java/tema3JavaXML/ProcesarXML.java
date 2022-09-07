/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema3JavaXML;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Usuario
 * Vamos a leer el XML de equipos de futbol desde la etiqueta jugador.
 */
public class ProcesarXML {
    

    public static void main(String[] args){
        
        String nombre = "";
        String nacionalidad = "";
        try {
            //Permite procesar el archivo XML y crear un archivo XML vacío
            DocumentBuilderFactory dbFactory =
            DocumentBuilderFactory.newInstance();
            //Creamos un fichero xml vacío
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            File fileXML = new File("equipo_futbol.xml");            
            //Realiza el parse o procesamiento del documento XML. Desde doc ya podemos acceder a los
            //elementos y propiedades del XML
            Document doc = dBuilder.parse(fileXML);
            
            NodeList listaJugadores = doc.getElementsByTagName("jugador");
            
            for (int i= 0; i < listaJugadores.getLength(); i++){
                Node nodo = listaJugadores.item(i);
                Element elem = (Element) nodo;
                
                nombre = elem.getElementsByTagName("nombre").item(0).getTextContent();
                nacionalidad = elem.getElementsByTagName("nacionalidad").item(0).getTextContent();
                
                System.out.println("Nombre Jugador: "+nombre+" "+"Nacionalidad: "+nacionalidad);  
                
            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(ProcesarXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(ProcesarXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ProcesarXML.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
