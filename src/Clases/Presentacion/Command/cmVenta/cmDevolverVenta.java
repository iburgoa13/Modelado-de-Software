package Clases.Presentaci�n.Command.cmVenta;

import Clases.Negocio.FactoriaSA;
import Clases.Negocio.Venta.TDevolucion;
import Clases.Negocio.Venta.TVenta;
import Clases.Presentaci�n.Contexto;
import Clases.Presentaci�n.Command.Command;
import Clases.Presentaci�n.Command.Events;

public class cmDevolverVenta implements Command {

	@Override
	public Contexto execute(Object data) {
		
		TVenta ret = FactoriaSA.getInstance().generateSAVenta().devolver((TDevolucion) data);
		if(ret != null) {
			return new Contexto(Events.DEVOLUCION_VENTA_OK,ret);
		}
		else return new Contexto(Events.DEVOLUCION_VENTA_KO,ret);
	}

}
