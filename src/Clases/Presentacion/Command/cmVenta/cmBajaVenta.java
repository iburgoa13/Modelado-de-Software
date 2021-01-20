package Clases.Presentaci�n.Command.cmVenta;

import Clases.Negocio.FactoriaSA;
import Clases.Presentaci�n.Contexto;
import Clases.Presentaci�n.Command.Command;
import Clases.Presentaci�n.Command.Events;

public class cmBajaVenta implements Command{

	@Override
	public Contexto execute(Object data) {
		int ret = FactoriaSA.getInstance().generateSAVenta().delete((Integer) data);
		if(ret > 0) {
			return new Contexto(Events.BAJA_VENTA_OK,ret);
		}
		else return new Contexto(Events.BAJA_VENTA_KO,ret);
	}

}
