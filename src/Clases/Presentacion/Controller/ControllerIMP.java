/**
 * 
 */
package Clases.Presentaci�n.Controller;

import Clases.Presentaci�n.Contexto;
import Clases.Presentaci�n.Command.Command;
import Clases.Presentaci�n.Command.FactoryCommand;
import Clases.Presentaci�n.Dispatcher.Dispatcher;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author Mario, Javier, Yule, David, Alberto, Iker, Fernando, Francisco
 * @generated "UML a Java
 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ControllerIMP extends Controller {

	@Override
	public void action(Contexto ctx) {

		FactoryCommand fc = FactoryCommand.getInstance();
		Command cmd = fc.generateCommand(ctx.getEvent());
		Contexto respuesta = null;
		if (cmd != null) {
			respuesta = cmd.execute(ctx.getData());
			Dispatcher.getInstance().getView(respuesta);
		} else {
			Dispatcher.getInstance().getView(ctx);
		}

	}

}