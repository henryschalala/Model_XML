/**
 */
package xml_model.model_xml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link xml_model.model_xml.Node#getChildren <em>Children</em>}</li>
 *   <li>{@link xml_model.model_xml.Node#getCrossref <em>Crossref</em>}</li>
 *   <li>{@link xml_model.model_xml.Node#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link xml_model.model_xml.Node#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see xml_model.model_xml.Model_xmlPackage#getNode()
 * @model
 * @generated
 */
public interface Node extends Element {
	/**
	 * Returns the value of the '<em><b>Children</b></em>' containment reference list.
	 * The list contents are of type {@link xml_model.model_xml.Node}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' containment reference list.
	 * @see xml_model.model_xml.Model_xmlPackage#getNode_Children()
	 * @model containment="true"
	 * @generated
	 */
	EList<Node> getChildren();

	/**
	 * Returns the value of the '<em><b>Crossref</b></em>' reference list.
	 * The list contents are of type {@link xml_model.model_xml.Node}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Crossref</em>' reference list.
	 * @see xml_model.model_xml.Model_xmlPackage#getNode_Crossref()
	 * @model
	 * @generated
	 */
	EList<Node> getCrossref();

	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link xml_model.model_xml.Attribute}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' containment reference list.
	 * @see xml_model.model_xml.Model_xmlPackage#getNode_Attributes()
	 * @model containment="true"
	 * @generated
	 */
	EList<Attribute> getAttributes();

	/**
	 * Returns the value of the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' reference.
	 * @see #setValue(Value)
	 * @see xml_model.model_xml.Model_xmlPackage#getNode_Value()
	 * @model
	 * @generated
	 */
	Value getValue();

	/**
	 * Sets the value of the '{@link xml_model.model_xml.Node#getValue <em>Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(Value value);

} // Node
