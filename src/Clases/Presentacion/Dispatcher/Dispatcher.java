/**
 * 
 */
package Clases.Presentación.Dispatcher;

import Clases.Presentación.Contexto;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author Mario, Javier, Yule, David, Alberto, Iker, Fernando, Francisco
 * @generated "UML a Java
 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public abstract class Dispatcher {
	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private static Dispatcher instance;

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static synchronized Dispatcher getInstance() {

		if (instance == null)
			instance = new DispatcherIMP();
		return instance;

	}

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @param ctx
	 * @return
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract void getView(Contexto ctx);
}