package Parser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.apache.commons.io.FileUtils;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import modelXML.ModelXMLFactory;
import modelXML.Value;
import modelXML.XMLModel;

public class Parser {

	public static XMLModel parseXMLFile() {

		SAXBuilder saxBuilder = new SAXBuilder();

		Document document = null;

		File file = new File("misc/xample.xml");

		try {
			document = saxBuilder.build(file);
		} catch (JDOMException | IOException e1) {
			e1.printStackTrace();
		}

		final Element rootFile = document.getRootElement();

		// Setup RessourceSet
		ResourceSet rs = new ResourceSetImpl();
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		Resource r = rs.createResource(URI.createURI("modelTest.xmi"));

//		Generate XML Model
		modelXML.XMLModel container = ModelXMLFactory.eINSTANCE.createXMLModel();
		parseHeader(file, container);

		parseContent(rootFile, container);
		r.getContents().add(container);
		try {
			r.save(null);
		} catch (IOException er) {
			er.printStackTrace();
		}
		return container;
	}

	private static void parseHeader(File file, modelXML.XMLModel container) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String header = br.readLine();
			if (header.charAt(1) != '?')
				return ;
			container.setHeader(header);
			br.close();
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	private static void parseContent(final Element element, modelXML.XMLModel container) {
		modelXML.Node root = ModelXMLFactory.eINSTANCE.createNode();
		container.setRoot(root);
		root.setName(element.getName());
		parseAttributes(element, root);

		parseChildren(element, root);
	}

	private static void parseChildren(final Element element, modelXML.Node node) {
		var children = element.getChildren();
		for (var child : children) {
			var childNode = modelXML.ModelXMLFactory.eINSTANCE.createNode();
//			System.out.println(child.getName());
			childNode.setName(child.getName());
//			System.out.println(child.getValue());
			Value val = ModelXMLFactory.eINSTANCE.createValue();
			val.setText(child.getValue());
			childNode.setValue(val);
			parseAttributes(child, childNode);
			parseChildren(child, childNode);
			node.getChildren().add(childNode);
		}
	}

	private static void parseAttributes(final Element rootFile, modelXML.Node root) {
		var attributesFile = rootFile.getAttributes();
		for (var attr : attributesFile) {
			var a = modelXML.ModelXMLFactory.eINSTANCE.createAttribute();
			a.setName(attr.getName());
			a.setValue(attr.getValue());
			root.getAttributes().add(a);
		}
	}
}
