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
            
            //Nodo equipo
            NodeList listaEquipos = doc.getElementsByTagName("equipo");
            //Nodo jugador
            NodeList listaJugadores = doc.getElementsByTagName("jugador");
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
                       if (nodoHijo.getNodeType() == Node.ELEMENT_NODE && "jugador".equals(nodoHijo.getNodeName())){
                            //Recorremos los nodos jugador
                            Node nodoJugador = listaJugadores.item(j);
                            Element elemJugador = (Element) nodoJugador;
                            NodeList nodoHijosJugador = elemJugador.getChildNodes();
                             //Recorremos los hijos de nodos jugador: nombre, nacionalidad
                             for (int k = 0; j < listaJugadores.getLength(); k++){

                                     Node nodoHijoJugador = nodoHijosJugador.item(k);
                                    //Comprobamos tipos de los nodos hijos. Si son element mostramos el valor
                                    if (nodoHijoJugador.getNodeType() == Node.ELEMENT_NODE && "nombre".equals(nodoHijo.getNodeName())){
                                        System.out.println(nodoHijo.getTextContent());
                                     }
                                    if (nodoHijoJugador.getNodeType() == Node.ELEMENT_NODE && "nacionalidad".equals(nodoHijo.getNodeName())){
                                        System.out.println(nodoHijo.getTextContent());
                                     }
                             }
                       }
                }       
            }
            
             /*
            //Nodo equipo
            NodeList listaEquipos = doc.getElementsByTagName("equipo");
            
            for (int i= 0; i < listaEquipos.getLength(); i++){
                Node nodo = listaEquipos.item(i);
                Element elem = (Element) nodo;
                
                nombreCiudad = elem.getElementsByTagName("nombre").item(0).getTextContent();
                ciudad = elem.getElementsByTagName("ciudad").item(0).getTextContent();
                
                 System.out.println("Nombre equipo: "+nombreCiudad+" "+"ciudad: "+ciudad);
                
                //Nodo jugadores
                NodeList listaJugadores = doc.getElementsByTagName("jugador");
                
                for (int j= 0; j < listaJugadores.getLength(); j++){
                    Node nodoHijo = listaJugadores.item(j);
                    Element elemHijo = (Element) nodoHijo;
                
                    nombreJugador = elem.getElementsByTagName("nombre").item(0).getTextContent();
                    nacionalidad = elemHijo.getElementsByTagName("nacionalidad").item(0).getTextContent();
   
                    System.out.println("Nombre Jugador: "+nombreJugador+" "+"Nacionalidad: "+nacionalidad);    
                }
            }*/
            
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            System.out.println(ex);
        }

    }
}
