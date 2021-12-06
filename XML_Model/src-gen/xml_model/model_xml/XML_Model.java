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
 *   <li>{@link xml_model.model_xml.XML_Model#getRoot <em>Root</em>}</li>
 *   <li>{@link xml_model.model_xml.XML_Model#getHeader <em>Header</em>}</li>
 * </ul>
 *
 * @see xml_model.model_xml.Model_xmlPackage#getXML_Model()
 * @model
 * @generated
 */
public interface XML_Model extends EObject {
	/**
	 * Returns the value of the '<em><b>Root</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root</em>' containment reference.
	 * @see #setRoot(Node)
	 * @see xml_model.model_xml.Model_xmlPackage#getXML_Model_Root()
	 * @model containment="true"
	 * @generated
	 */
	Node getRoot();

	/**
	 * Sets the value of the '{@link xml_model.model_xml.XML_Model#getRoot <em>Root</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Root</em>' containment reference.
	 * @see #getRoot()
	 * @generated
	 */
	void setRoot(Node value);

	/**
	 * Returns the value of the '<em><b>Header</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Header</em>' attribute.
	 * @see #setHeader(String)
	 * @see xml_model.model_xml.Model_xmlPackage#getXML_Model_Header()
	 * @model
	 * @generated
	 */
	String getHeader();

	/**
	 * Sets the value of the '{@link xml_model.model_xml.XML_Model#getHeader <em>Header</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Header</em>' attribute.
	 * @see #getHeader()
	 * @generated
	 */
	void setHeader(String value);

} // XML_Model
