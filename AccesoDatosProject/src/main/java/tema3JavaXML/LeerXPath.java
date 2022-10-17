/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema3JavaXML;

/**
 *
 * @author Usuario
 */
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;


public class LeerXPath {
	public static void main(String[] args) throws Exception {
                // La expresion xpath de busqueda. Muestra cualquier animal
		String xPathExpression = "//animal";
		
                // Carga del documento xml
 		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
 		DocumentBuilder builder = factory.newDocumentBuilder();
 		Document documento = builder.parse(new File("ejemplo.xml"));

		// Preparación de xpath
 		XPath xpath = XPathFactory.newInstance().newXPath();

 		// Consultas
 		NodeList nodos = (NodeList) xpath.evaluate(xPathExpression, documento, XPathConstants.NODESET);

		for (int i=0;i<nodos.getLength();i++){
			System.out.println(nodos.item(i).getNodeName()+" : " 
                            + nodos.item(i).getTextContent());
		}
	}
}
