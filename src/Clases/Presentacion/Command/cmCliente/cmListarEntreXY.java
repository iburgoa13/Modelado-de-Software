/**
 * 
 */
package Clases.Presentación.Command.cmCliente;

import Clases.Presentación.Command.Command;
import Clases.Presentación.Command.Events;

import java.util.HashMap;


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
public class cmListarEntreXY implements Command {
	public cmListarEntreXY() {
	}

	public Contexto execute(Object data) {
		float [] minMax = new float[2];
		minMax = (float[]) data;
		HashMap<TCliente,Float> clientes = FactoriaSA.getInstance().generateSACliente().clienteXY(minMax[0], minMax[1]);
		Contexto contexto = null;
		if (clientes != null) {
			contexto = new Contexto(Events.ENTRXYCliente_OK, clientes);
		} else
			contexto = new Contexto(Events.ENTRXYCliente_KO, clientes);

		return contexto;
	}
}