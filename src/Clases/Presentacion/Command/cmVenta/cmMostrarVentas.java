package Clases.Presentaci�n.Command.cmVenta;

import java.util.List;

import Clases.Negocio.FactoriaSA;
import Clases.Negocio.Venta.TVenta;
import Clases.Presentaci�n.Contexto;
import Clases.Presentaci�n.Command.Command;
import Clases.Presentaci�n.Command.Events;

public class cmMostrarVentas implements Command {

	public cmMostrarVentas() {

	}

	@Override
	public Contexto execute(Object data) {
		List<TVenta> ret = FactoriaSA.getInstance().generateSAVenta().readAll();
		if(ret !=null) {
			return new Contexto(Events.MOSTRAR_VENTAS_OK,ret);
		}
		else return new Contexto(Events.MOSTRAR_VENTAS_KO,ret);
	}

}
