/**
 * 
 */
package Clases.Presentación.Cliente;

import javax.swing.JFrame;

import Clases.Presentación.Contexto;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author Mario, Javier, Yule, David, Alberto, Iker, Fernando, Francisco
 * @generated "UML a Java
 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public abstract class GUICliente extends JFrame {
	private static final long serialVersionUID = 1L;
	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @param context
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private static GUICliente instance;

	public abstract void update(Contexto context);

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static GUICliente getInstance() {
		// begin-user-code
		// TODO Auto-generated method stub
		if (instance == null)
			instance = new GUIClienteIMP();
		return instance;
		// end-user-code
	}

	public abstract void initialize();
}