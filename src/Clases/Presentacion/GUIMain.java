/**
 * 
 */
package Clases.Presentación;

import javax.swing.JFrame;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author Mario, Javier, Yule, David, Alberto, Iker, Fernando, Francisco
 * @generated "UML a Java
 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public abstract class GUIMain extends JFrame {
	private static final long serialVersionUID = 1L;

	public GUIMain() {

	}

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private static GUIMain instancia;

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @return
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static synchronized GUIMain getInstance() {
		// begin-user-code
		// TODO Auto-generated method stub
		if (instancia == null)
			instancia = new GUIMainIMP();
		return instancia;
		// end-user-code
	}

	public abstract void initialize();
}