/**
 * 
 */
package Clases.Presentaci�n.Command.cmVenta;

import Clases.Negocio.FactoriaSA;
import Clases.Negocio.Venta.TVenta;
import Clases.Presentaci�n.Contexto;
import Clases.Presentaci�n.Command.Command;
import Clases.Presentaci�n.Command.Events;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author Mario, Javier, Yule, David, Alberto, Iker, Fernando, Francisco
 * @generated "UML a Java
 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class cmMostrarVenta implements Command {
	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */

	public Contexto execute(Object data) {
		int id = (Integer)data;
		if(id==0) {
			return new Contexto(Events.MOSTRAR_VENTA_ACTUAL,0);
		}
		else {
			TVenta ret = FactoriaSA.getInstance().generateSAVenta().read((Integer) data);
			if(ret != null) {
				return new Contexto(Events.MOSTRAR_VENTA_OK,ret);
			}
			else return new Contexto(Events.MOSTRAR_VENTA_KO,ret);
		}
		
	}
}