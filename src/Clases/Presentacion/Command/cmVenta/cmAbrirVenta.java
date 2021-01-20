/**
 * 
 */
package Clases.Presentación.Command.cmVenta;

import Clases.Negocio.FactoriaSA;
import Clases.Presentación.Contexto;
import Clases.Presentación.Command.Command;
import Clases.Presentación.Command.Events;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author Mario, Javier, Yule, David, Alberto, Iker, Fernando, Francisco
 * @generated "UML a Java
 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class cmAbrirVenta implements Command {
	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public cmAbrirVenta() {
		
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see Command#execute(Object data)
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Contexto execute(Object data) {
		int ret = FactoriaSA.getInstance().generateSAVenta().abrirVenta((Integer) data);
		if(ret > 0) {
			return new Contexto(Events.ABRIR_VENTA_OK,ret);
		}
		else return new Contexto(Events.ABRIR_VENTA_KO,ret);
	}
}