/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema3JavaXML.Ejercicios;

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
 * 
 */
public class ProcesarXMLEquipo {
    

    public static void main(String[] args){
        /*
        String nombreCiudad = "";
        String nombreJugador = "";
        String nacionalidad = "";
        String ciudad = "";
        */
        try {
            //Permite procesar el archivo XML y crear un archivo XML vacío
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            //Creamos un fichero xml vacío
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            File fileXML = new File("equipo_futbol.xml");            
            //Realiza el parse o procesamiento del documento XML. Desde doc ya podemos acceder a los
            //elementos y propiedades del XML
            Document doc = dBuilder.parse(fileXML);
            doc.getDocumentElement().normalize();
            //Nodo equipo
            NodeList listaEquipos = doc.getElementsByTagName("equipo");
            //Nodo jugador
            
            //Recorremos los nodos equipo
            for (int i= 0; i < listaEquipos.getLength(); i++){
                Node nodo = listaEquipos.item(i);
                Element elem = (Element) nodo;
                //equipo tiene nodos hijos: nombre, ciudad, entrenador 
                NodeList nodoHijos = elem.getChildNodes();
                //Recorremos los hijos de nodos equipo: nombre, ciudad, entrenador
                for (int j = 0; j < nodoHijos.getLength(); j++){
                       Node nodoHijo = nodoHijos.item(j);
                       //Comprobamos tipos de los nodos hijos. Si son element mostramos el valor
                       if (nodoHijo.getNodeType() == Node.ELEMENT_NODE && "nombre".equals(nodoHijo.getNodeName())){
                           System.out.println(nodoHijo.getTextContent());
                        }
                       if (nodoHijo.getNodeType() == Node.ELEMENT_NODE && "ciudad".equals(nodoHijo.getNodeName())){
                           System.out.println(nodoHijo.getTextContent());
                        }
                       //Procesamos la etiqueta jugadores
                       if (nodoHijo.getNodeType() == Node.ELEMENT_NODE && "jugadores".equals(nodoHijo.getNodeName())){
                           Element elem2 = (Element) nodoHijo;
                           //Si jugadores tiene nodos hijo obtenemos los nodos hijos y los recorremos 
                           if(elem2.hasChildNodes()) {
                                NodeList nl = nodoHijo.getChildNodes();
                                for(int k=0; k<nl.getLength(); k++) {
                                  Node nd = nl.item(k);
                                  System.out.println(nd.getTextContent());
                                }
                            }
                        }
                    }
                }
            
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            System.out.println(ex);
        }

    }
}
