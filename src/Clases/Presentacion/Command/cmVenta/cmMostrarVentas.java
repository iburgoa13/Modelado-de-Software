package Clases.Presentación.Command.cmVenta;

import java.util.List;

import Clases.Negocio.FactoriaSA;
import Clases.Negocio.Venta.TVenta;
import Clases.Presentación.Contexto;
import Clases.Presentación.Command.Command;
import Clases.Presentación.Command.Events;

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
