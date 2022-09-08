/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema3JavaXML;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
 * En este programa vamos a procesar el archivo XML de ejemplo.xml corresponiente
 * a la selva.
 * El archivo XML debe estar en la carpeta raiz del proyecto
 */
public class ProcesarXMLEjemplo {
    
    public static void main(String[] args){
        
        try {
            //Creamos la instancia de dbf
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            //Creamos un nuevo documento vacío a partir de dicha instancia
            DocumentBuilder db = dbf.newDocumentBuilder();
            //Creamos un objeto File con nuestro fichero XML
            File fichXML = new File("ejemplo.xml");
            //Creamos el arbol DOM a partir del fichero
            Document doc = db.parse(fichXML);
            
            //-------- Procesamos el arbol DOM ---------//
            //Nodo animal
            NodeList listaAnimales = doc.getElementsByTagName("animal");
            
            //Recorremos los nodos animal (se puede usar foreach
            for (int i= 0; i < listaAnimales.getLength(); i++){
                //Cada item de la lista es un nodo
                Node nodo = listaAnimales.item(i);
                //Hacemos un casting a Element ya que cada nodo es un Element 
                Element elem = (Element) nodo;
               //Mostramos el valor del atributo de la etiqueta animal
                System.out.println("El valor de id es: "+elem.getAttribute("id"));
                
                //animal tiene nodos hijos: nombre, tipo, color y edad
                NodeList nodoHijos = elem.getChildNodes();
                //Recorremos los hijos de nodos de equipo: nombre, tipo, color y edad
                //Ver arbol DOM
                for (int j = 0; j < nodoHijos.getLength(); j++){
                       Node nodoHijo = nodoHijos.item(j);
                       //Comprobamos tipos de los nodos hijos. Si son element mostramos el valor
                       if (nodoHijo.getNodeType() == Node.ELEMENT_NODE && "nombre".equals(nodoHijo.getNodeName())){
                           System.out.println("Etiqueta: "+ nodoHijo.getNodeName()+" Valor:"+nodoHijo.getTextContent());
                        }
                       if (nodoHijo.getNodeType() == Node.ELEMENT_NODE && "tipo".equals(nodoHijo.getNodeName())){
                           System.out.println("Etiqueta: "+ nodoHijo.getNodeName()+" Valor:"+nodoHijo.getTextContent());
                        }
                       
                       if (nodoHijo.getNodeType() == Node.ELEMENT_NODE && "color".equals(nodoHijo.getNodeName())){
                           System.out.println("Etiqueta: "+ nodoHijo.getNodeName()+" Valor:"+nodoHijo.getTextContent());
                        }
                       if (nodoHijo.getNodeType() == Node.ELEMENT_NODE && "edad".equals(nodoHijo.getNodeName())){
                           System.out.println("Etiqueta: "+ nodoHijo.getNodeName()+" Valor:"+nodoHijo.getTextContent());
                        }
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(ProcesarXMLEjemplo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
