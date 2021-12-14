package Parser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import xml_model.model_xml.Model_xmlFactory;


public class Parser {

	public static void main(String[] args) {

		SAXBuilder saxBuilder = new SAXBuilder();

		Document document = null;
//		try {
//			document = saxBuilder.build(System.in);
//		} catch (JDOMException | IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		File myObj = new File("map.xml");

		try {
			document = saxBuilder.build(myObj);
		} catch (JDOMException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		final Element rootElement = document.getRootElement();
//--------------------------------------------------------------------!!!!!!!!!!!!!!!!!!!!!!!!!-------------------------------------------------------------------------        
		ResourceSet rs = new ResourceSetImpl();
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		Resource r = rs.createResource(URI.createURI("mode.xmi"));

		// ---- parse xml

		xml_model.model_xml.Element root = Model_xmlFactory.eINSTANCE.createElement();
		root.setRoot(true);
		root.setName(rootElement.getName());
		parseAttributes(rootElement, root);
		parseChildren(rootElement, root);

		xml_model.model_xml.Element e = Model_xmlFactory.eINSTANCE.createElement();
		root.getChildren().add(e);

		r.getContents().add(root);
		try {
			r.save(null);
		} catch (IOException er) {
			// TODO Auto-generated catch block
			er.printStackTrace();

		}
		FileWriter file = null;
		try {
			file = new FileWriter("test.xml");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		BufferedWriter buffer = new BufferedWriter(file);
		String str = printModel(root, 0);
		System.out.print(str);
	}

	private static String printModel(xml_model.model_xml.Element element, int count) {

		if (element.getName() == null)
			return "";
		// StartTag
		StringBuilder content = new StringBuilder();
		String spaces = "";
		for (int i = 0; i < count; i++)
			spaces += " ";
		content.append(String.format(spaces + "<%s", element.getName()));
		for (var attr : element.getAttributes()) {
			content.append(String.format(" %s=\"%s\"", attr.getName(), attr.getValue()));
		}

		if (element.getChildren().isEmpty()) {
			if (element.getValue().isEmpty()) {
				content.append("/>\n");
			} else {
				content.append(">\n" + spaces+ " " + element.getValue() + "\n");
				content.append(String.format(spaces + "</%s>\n", element.getName()));
			}

		} else {
			content.append(">\n");
			// Children
			for (var child : element.getChildren()) {
				if (child instanceof xml_model.model_xml.Element) {
					content.append(printModel((xml_model.model_xml.Element) child, count + 1));
				}
			}

			// CloseTag
			content.append(String.format(spaces + "</%s>\n", element.getName()));
		}
		return content.toString();
	}

	/**
	 * This Method parses the Attributes into the XML Meta model.
	 * 
	 * @param rootElement
	 * @param node
	 */
	private static void parseAttributes(final Element rootElement, xml_model.model_xml.Element node) {
		var attributes = rootElement.getAttributes();
		for (var att : attributes) {
			var a = Model_xmlFactory.eINSTANCE.createAttribute();
//			System.out.print(att.getName() + " ");
			a.setName(att.getName());

			a.setValue(att.getValue());
			node.getAttributes().add(a);
		}
//		System.out.println();
	}

	/**
	 * This recursive Method parses the children into the XML Metamodel
	 * 
	 * @param input
	 * @param node
	 */
	private static void parseChildren(final Element input, xml_model.model_xml.Element element) {
		var children = input.getChildren();
		for (var child : children) {
			var e = Model_xmlFactory.eINSTANCE.createElement();
//			System.out.println(child.getName());
			e.setName(child.getName());
			e.setValue(child.getValue());
			parseAttributes(child, e);
			parseTxt(child, e);
			parseChildren(child, e);
			element.getChildren().add(e);
		}
	}

	private static void parseTxt(final Element input, xml_model.model_xml.Element element) {
		if (input.getText().isEmpty())
			element.setValue(input.getText());
	}
}