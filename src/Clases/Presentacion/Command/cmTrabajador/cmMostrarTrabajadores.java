package Clases.Presentaci�n.Command.cmTrabajador;

import java.util.List;

import Clases.Negocio.FactoriaSA;
import Clases.Negocio.Producto.TProducto;
import Clases.Negocio.Trabajador.TTrabajador;
import Clases.Presentaci�n.Contexto;
import Clases.Presentaci�n.Command.Command;
import Clases.Presentaci�n.Command.Events;

public class cmMostrarTrabajadores implements Command {

	public cmMostrarTrabajadores() {

	}

	@Override
	public Contexto execute(Object data) {
		List<TTrabajador> tbjs = FactoriaSA.getInstance().generateSATrabajador().listarTrabajadores();
		if(tbjs != null) {
			return new Contexto(Events.MOSTRAR_TRABAJADORES_OK,tbjs);
		}
		else return new Contexto(Events.MOSTRAR_TRABAJADORES_KO,tbjs);
	}

}
