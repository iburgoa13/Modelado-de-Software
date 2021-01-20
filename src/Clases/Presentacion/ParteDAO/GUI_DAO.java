package Clases.Presentación.ParteDAO;

import javax.swing.JFrame;

public abstract class GUI_DAO extends JFrame {
	private static final long serialVersionUID = 1L;
	private static GUI_DAO instance;

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @return
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static synchronized GUI_DAO getInstance() {
		// begin-user-code
		// TODO Auto-generated method stub
		if (instance == null) {
			instance = new GUI_DAOIMP();
		}
		return instance;
		// end-user-code
	}

	public abstract void initialize();
}
