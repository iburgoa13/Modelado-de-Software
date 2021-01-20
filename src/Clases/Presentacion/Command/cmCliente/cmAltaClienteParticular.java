/**
 * 
 */
package Clases.Presentación.Command.cmCliente;

import Clases.Presentación.Command.Command;
import Clases.Presentación.Command.Events;
import Clases.Negocio.FactoriaSA;
import Clases.Negocio.Cliente.TCliente;

import Clases.Presentación.Contexto;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author Mario, Javier, Yule, David, Alberto, Iker, Fernando, Francisco
 * @generated "UML a Java
 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class cmAltaClienteParticular implements Command {
	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public cmAltaClienteParticular() {
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
		int ret = FactoriaSA.getInstance().generateSACliente().create((TCliente) data);
		if(ret > 0) {
			return new Contexto(Events.ALTA_CLIENTEP_OK,ret);
		}
		else return new Contexto(Events.ALTA_CLIENTEP_KO,ret);
	}
}