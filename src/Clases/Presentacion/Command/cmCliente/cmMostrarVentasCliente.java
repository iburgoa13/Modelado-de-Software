package Clases.Presentaci�n.Command.cmCliente;

import java.util.List;

import Clases.Negocio.FactoriaSA;
import Clases.Negocio.Venta.TVenta;
import Clases.Presentaci�n.Contexto;
import Clases.Presentaci�n.Command.Command;
import Clases.Presentaci�n.Command.Events;

public class cmMostrarVentasCliente implements Command{
	
	public cmMostrarVentasCliente() {
		
	}
	
	public Contexto execute(Object data) {
	
	List<TVenta>vents = FactoriaSA.getInstance().generateSAVenta().readAllOneCliente((int)data);
	if (vents != null) {
		return new Contexto(Events.MOSTRAR_VENTAS_CLIENTE_OK, vents);
	} else
		return new Contexto(Events.MOSTRAR_VENTAS_CLIENTE_KO, vents);
	}
}
