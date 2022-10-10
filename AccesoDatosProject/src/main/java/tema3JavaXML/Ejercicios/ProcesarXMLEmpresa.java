/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema3JavaXML.Ejercicios;

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
 * @author Usuario
 */
public class ProcesarXMLEmpresa {
    public static void main(String args[]){
        
        try {
            File file = new File("empresa.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            
            doc.getDocumentElement().normalize();
            
            NodeList nList = doc.getElementsByTagName("trabajador");
            
            for (int i = 0; i < nList.getLength(); i++) {
                Node node = nList.item(i);
                
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;
                    
                    if(eElement.hasChildNodes()) {
                        NodeList nl = node.getChildNodes();
                        for(int j=0; j<nl.getLength(); j++) {
                            Node nd = nl.item(j);
                            System.out.println(nd.getTextContent());
                        }
                    }
                }
            }} catch (ParserConfigurationException ex) {
                ex.printStackTrace();
        } catch (SAXException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
    
