import java.io.File;
import java.io.IOException;

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
import xml_model.model_xml.Root;


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

		Root root = Model_xmlFactory.eINSTANCE.createRoot();
		
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
		
	}
	/**
	 * This Method parses the Attributes into the XML Meta model.
	 * @param rootElement
	 * @param node
	 */
	private static void parseAttributes(final Element rootElement, xml_model.model_xml.Element node) {
		var attributes = rootElement.getAttributes();
		for(var att : attributes) {
			var a = Model_xmlFactory.eINSTANCE.createAttribute();
			System.out.print(att.getName() + " ");
			a.setName(att.getName());
			
			a.setValue(att.getValue());
			node.getAttributes().add(a);
		}
		System.out.println();
	}

	/**
	 * This recursive Method parses the children into the XML Metamodel
	 * @param rootElement
	 * @param node
	 */
	private static void parseChildren(final Element rootElement, xml_model.model_xml.Element element) {
		var children = rootElement.getChildren();
		for (var child : children) {
			var e = Model_xmlFactory.eINSTANCE.createElement();
			System.out.println(child.getName());
			e.setName(child.getName());
			e.setValue(child.getValue());
			parseAttributes(child, e);
			parseChildren(child, e);
			element.getChildren().add(e);
		}
	}
}