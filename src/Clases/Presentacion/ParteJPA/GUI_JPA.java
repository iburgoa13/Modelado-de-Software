package Clases.Presentación.ParteJPA;

import javax.swing.JFrame;

import Clases.Presentación.ParteDAO.GUI_DAO;
import Clases.Presentación.ParteDAO.GUI_DAOIMP;

public abstract class GUI_JPA extends JFrame{
	private static final long serialVersionUID = 1L;
	private static GUI_JPA instance;

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @return
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static synchronized GUI_JPA getInstance() {
		// begin-user-code
		// TODO Auto-generated method stub
		if (instance == null) {
			instance = new GUI_JPAIMP();
		}
		return instance;
		// end-user-code
	}

	public abstract void initialize();
}
