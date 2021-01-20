package Clases.Presentaci�n.Command.cmTrabajador;

import Clases.Negocio.FactoriaSA;
import Clases.Negocio.Producto.TProducto;
import Clases.Negocio.Trabajador.TTrabajador;
import Clases.Presentaci�n.Contexto;
import Clases.Presentaci�n.Command.Command;
import Clases.Presentaci�n.Command.Events;

public class cmMostrarTrabajador implements Command {

	public cmMostrarTrabajador() {

	}

	@Override
	public Contexto execute(Object data) {
		TTrabajador ret = FactoriaSA.getInstance().generateSATrabajador().mostrarTrabajador((int)data);
		
		if(ret !=null) {
			return new Contexto(Events.MOSTRAR_TRABAJADOR_OK,ret);
		}
		else return new Contexto(Events.MOSTRAR_TRABAJADOR_KO,ret);
	}

}
