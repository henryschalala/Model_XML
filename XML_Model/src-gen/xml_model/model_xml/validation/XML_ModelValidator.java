/**
 *
 * $Id$
 */
package xml_model.model_xml.validation;

import xml_model.model_xml.Header;
import xml_model.model_xml.Node;

/**
 * A sample validator interface for {@link xml_model.model_xml.XML_Model}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface XML_ModelValidator {
	boolean validate();

	boolean validateNode(Node value);

	boolean validateVersion(Header value);

	boolean validateHeader(String value);

}
