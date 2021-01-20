package Clases.Presentación.Command.cmTrabajador;

import Clases.Negocio.FactoriaSA;
import Clases.Negocio.Producto.TProducto;
import Clases.Negocio.Trabajador.TTrabajador;
import Clases.Presentación.Contexto;
import Clases.Presentación.Command.Command;
import Clases.Presentación.Command.Events;

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
