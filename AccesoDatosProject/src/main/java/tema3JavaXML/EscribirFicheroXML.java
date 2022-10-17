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
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class EscribirFicheroXML {

	public static void main(String argv[]) {

	  try {

		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

		// elemento root
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("empresa");
		doc.appendChild(rootElement);

		// elementos trabajador
		Element trabajador = doc.createElement("trabajador");
		rootElement.appendChild(trabajador);

		// asignamos atributo a elemento trabajador
		Attr attr = doc.createAttribute("id");
		attr.setValue("1");
		trabajador.setAttributeNode(attr);

		// otra forma
		// trabajador.setAttribute("id", "1");

		// elemento nombre
		Element firstname = doc.createElement("nombre");
		firstname.appendChild(doc.createTextNode("Juan"));
		trabajador.appendChild(firstname);

		// elemento apellido
		Element lastname = doc.createElement("lastname");
		lastname.appendChild(doc.createTextNode("Perez"));
		trabajador.appendChild(lastname);

		// elemento nickname
		Element nickname = doc.createElement("nickname");
		nickname.appendChild(doc.createTextNode("jperez"));
		trabajador.appendChild(nickname);

		// elemento salary
		Element salary = doc.createElement("salario");
		salary.appendChild(doc.createTextNode("100000"));
		trabajador.appendChild(salary);

		// escribir contenido en fichero xml
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
                //añade salto de linea
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File("trabajadores.xml"));


		transformer.transform(source, result);

		System.out.println("Fichero guardado");

	  } catch (ParserConfigurationException pce) {
		pce.printStackTrace();
	  } catch (TransformerException tfe) {
		tfe.printStackTrace();
	  }
	}
}