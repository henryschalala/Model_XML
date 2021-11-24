/**
 */
package xml_model.model_xml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link xml_model.model_xml.Element#getValue <em>Value</em>}</li>
 *   <li>{@link xml_model.model_xml.Element#getChildren <em>Children</em>}</li>
 *   <li>{@link xml_model.model_xml.Element#getAttribute <em>Attribute</em>}</li>
 * </ul>
 *
 * @see xml_model.model_xml.Model_xmlPackage#getElement()
 * @model
 * @generated
 */
public interface Element extends Node {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see xml_model.model_xml.Model_xmlPackage#getElement_Value()
	 * @model
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link xml_model.model_xml.Element#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * Returns the value of the '<em><b>Children</b></em>' containment reference list.
	 * The list contents are of type {@link xml_model.model_xml.Node}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' containment reference list.
	 * @see xml_model.model_xml.Model_xmlPackage#getElement_Children()
	 * @model containment="true"
	 * @generated
	 */
	EList<Node> getChildren();

	/**
	 * Returns the value of the '<em><b>Attribute</b></em>' reference list.
	 * The list contents are of type {@link xml_model.model_xml.Attribute}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute</em>' reference list.
	 * @see xml_model.model_xml.Model_xmlPackage#getElement_Attribute()
	 * @model
	 * @generated
	 */
	EList<Attribute> getAttribute();

} // Element
