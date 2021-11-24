/**
 */
package xml_model.model_xml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XML Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link xml_model.model_xml.XML_Model#getNode <em>Node</em>}</li>
 *   <li>{@link xml_model.model_xml.XML_Model#getVersion <em>Version</em>}</li>
 * </ul>
 *
 * @see xml_model.model_xml.Model_xmlPackage#getXML_Model()
 * @model
 * @generated
 */
public interface XML_Model extends EObject {
	/**
	 * Returns the value of the '<em><b>Node</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node</em>' containment reference.
	 * @see #setNode(Node)
	 * @see xml_model.model_xml.Model_xmlPackage#getXML_Model_Node()
	 * @model containment="true"
	 * @generated
	 */
	Node getNode();

	/**
	 * Sets the value of the '{@link xml_model.model_xml.XML_Model#getNode <em>Node</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node</em>' containment reference.
	 * @see #getNode()
	 * @generated
	 */
	void setNode(Node value);

	/**
	 * Returns the value of the '<em><b>Version</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' reference.
	 * @see #setVersion(Version)
	 * @see xml_model.model_xml.Model_xmlPackage#getXML_Model_Version()
	 * @model
	 * @generated
	 */
	Version getVersion();

	/**
	 * Sets the value of the '{@link xml_model.model_xml.XML_Model#getVersion <em>Version</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' reference.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(Version value);

} // XML_Model
