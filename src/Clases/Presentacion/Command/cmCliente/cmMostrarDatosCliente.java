/**
 * 
 */
package Clases.Presentación.Command.cmCliente;

import Clases.Negocio.FactoriaSA;
import Clases.Negocio.Cliente.TCliente;
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
public class cmMostrarDatosCliente implements Command {
	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public cmMostrarDatosCliente() {
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
		TCliente ret = FactoriaSA.getInstance().generateSACliente().read((int) data);
		if (ret != null) {

			return new Contexto(Events.MOSTRAR_CLIENTE_OK, ret);

		} else
			return new Contexto(Events.MOSTRAR_CLIENTE_KO, ret);
	}
}