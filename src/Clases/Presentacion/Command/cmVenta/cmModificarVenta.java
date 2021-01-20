package Clases.Presentaci�n.Command.cmVenta;

import Clases.Negocio.FactoriaSA;
import Clases.Negocio.Venta.TVenta;
import Clases.Presentaci�n.Contexto;
import Clases.Presentaci�n.Command.Command;
import Clases.Presentaci�n.Command.Events;

public class cmModificarVenta implements Command {

	public cmModificarVenta() {

	}

	@Override
	public Contexto execute(Object data) {
		if(data.getClass().equals(Integer.class))
		{
			TVenta ret = FactoriaSA.getInstance().generateSAVenta().read((int)data);
			if(ret != null) {
				return new Contexto(Events.MODIFICA_VENTA_READ_OK,ret);
			}
			else return new Contexto(Events.MODIFICA_VENTA_READ_KO,ret);
		}
		else {
			int ret = FactoriaSA.getInstance().generateSAVenta().update((TVenta)data);
			if(ret > 0) {
				return new Contexto(Events.MODIFICA_VENTA_OK,ret);
			}
			else return new Contexto(Events.MODIFICA_VENTA_KO,ret);
		}
		
	}

}