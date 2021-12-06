/**
 */
package modelXML;

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
 *   <li>{@link modelXML.Node#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link modelXML.Node#getChildren <em>Children</em>}</li>
 *   <li>{@link modelXML.Node#getCrossref <em>Crossref</em>}</li>
 *   <li>{@link modelXML.Node#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see modelXML.ModelXMLPackage#getNode()
 * @model
 * @generated
 */
public interface Node extends Element {
	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link modelXML.Attribute}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' containment reference list.
	 * @see modelXML.ModelXMLPackage#getNode_Attributes()
	 * @model containment="true"
	 * @generated
	 */
	EList<Attribute> getAttributes();

	/**
	 * Returns the value of the '<em><b>Children</b></em>' containment reference list.
	 * The list contents are of type {@link modelXML.Node}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' containment reference list.
	 * @see modelXML.ModelXMLPackage#getNode_Children()
	 * @model containment="true"
	 * @generated
	 */
	EList<Node> getChildren();

	/**
	 * Returns the value of the '<em><b>Crossref</b></em>' reference list.
	 * The list contents are of type {@link modelXML.Node}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Crossref</em>' reference list.
	 * @see modelXML.ModelXMLPackage#getNode_Crossref()
	 * @model
	 * @generated
	 */
	EList<Node> getCrossref();

	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(Value)
	 * @see modelXML.ModelXMLPackage#getNode_Value()
	 * @model containment="true"
	 * @generated
	 */
	Value getValue();

	/**
	 * Sets the value of the '{@link modelXML.Node#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(Value value);

} // Node
