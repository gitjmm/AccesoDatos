/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema3JavaXML.Ejercicios;

/**
 *
 * @author Usuario
 */
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Jorge Martínez
 *
 */
public class ProcesarEquipo2{

    public static void main(String[] args) {

        try {
            //Creamos la instancia de dbf
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            //Creamos un nuevo documento vacío a partir de dicha instancia
            DocumentBuilder db = dbf.newDocumentBuilder();
            //Creamos un objeto File con nuestro fichero XML
            File fichXML = new File("equipo_futbol.xml");
            //Creamos el arbol DOM a partir del fichero
            Document doc = db.parse(fichXML);
            //normalize. Elimina nodos vacíos y combina nodos adyacentes en caso de que los hubiera
            doc.getDocumentElement().normalize();
            //-------- Procesamos el arbol DOM ---------//
            //Elemento raíz
            System.out.println("Elemento raiz: " + doc.getDocumentElement().getNodeName());
            //Nodo equipo
            NodeList listaEquipos = doc.getElementsByTagName("equipo");

            //Recorremos los nodos equipos
            for (int i = 0; i < listaEquipos.getLength(); i++) {
                //Cada item de la lista es un nodo
                Node nodo = listaEquipos.item(i);
                //Hacemos un casting a Element ya que cada nodo es un Element 
                Element elem = (Element) nodo;
                NodeList nodoHijos = elem.getChildNodes();
                //Recorremos los hijos de nodos de equipo: nombre, ciudad, entrenador y jugadores
                //Ver arbol DOM
                for (int j = 0; j < nodoHijos.getLength(); j++) {
                    Node nodoHijo = nodoHijos.item(j);
                    //Comprobamos tipos de los nodos hijos. Si son element mostramos el valor
                    if (nodoHijo.getNodeType() == Node.ELEMENT_NODE && "nombre".equals(nodoHijo.getNodeName())) {
                        System.out.println("Etiqueta: " + nodoHijo.getNodeName() + " Valor: " + nodoHijo.getTextContent());
                    }
                    if (nodoHijo.getNodeType() == Node.ELEMENT_NODE && "ciudad".equals(nodoHijo.getNodeName())) {
                        System.out.println("Etiqueta: " + nodoHijo.getNodeName() + " Valor: " + nodoHijo.getTextContent());
                    }
                    if (nodoHijo.getNodeType() == Node.ELEMENT_NODE && "entrenador".equals(nodoHijo.getNodeName())&& nodoHijo.getTextContent() != "") {
                        System.out.println("Etiqueta: " + nodoHijo.getNodeName() + " Valor: " + nodoHijo.getTextContent());
                    }
                    if (nodoHijo.getNodeType() == Node.ELEMENT_NODE && "jugadores".equals(nodoHijo.getNodeName())) {
                        Element nodoJugadoresEle = (Element) nodoHijo;
                        NodeList nodoJugadoresList = nodoJugadoresEle.getChildNodes();
                        //Recorremos todos los nodos hijos de jugadores
                        for (int k = 0; k < nodoJugadoresList.getLength(); k++) {
                            Node nodoJugadores = nodoJugadoresList.item(k);
                            if (nodoJugadores.hasChildNodes()) {
                                //Mostramos el nonbre de etiqueta y atributos de cada jugador
                                System.out.println("Etiqueta: " + nodoJugadores.getNodeName());
                                Element nodoJugadorEle = (Element) nodoJugadores;
                                System.out.println("La posición es: " + nodoJugadorEle.getAttribute("posicion"));
                                NodeList nodoJugadorList = nodoJugadorEle.getChildNodes();
                                //Recorremos cada nodo de cada jugador (nombre y nacionalidad)
                                for (int l = 0; l < nodoJugadorList.getLength(); l++) {
                                    Node nodoJugador = nodoJugadorList.item(l);
                                    if (nodoJugador.getNodeType() == Node.ELEMENT_NODE && "nombre".equals(nodoJugador.getNodeName())) {
                                        System.out.println("Etiqueta: " + nodoJugador.getNodeName() + " Valor: " + nodoJugador.getTextContent());
                                    }
                                    if (nodoJugador.getNodeType() == Node.ELEMENT_NODE && "nacionalidad".equals(nodoJugador.getNodeName())) {
                                        System.out.println("Etiqueta: " + nodoJugador.getNodeName() + " Valor: " + nodoJugador.getTextContent());
                                    }
                                }
                            }
                        }

                    }
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            ex.printStackTrace();
        }

    }

}

