package Clases.Presentaci�n.Command.cmCliente;

import Clases.Negocio.FactoriaSA;
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
public class cmBajaCliente implements Command {
	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public cmBajaCliente() {
		// begin-user-code
		// TODO Auto-generated constructor stub
		// end-user-code
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see Command#execute(Object data)
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Contexto execute(Object data) {
			int ret = FactoriaSA.getInstance().generateSACliente().delete((int) data);
			if(ret > 0) {
				return new Contexto(Events.BAJA_CLIENTE_OK,ret);
			}
			else return new Contexto(Events.BAJA_CLIENTE_KO,ret);
		}
}