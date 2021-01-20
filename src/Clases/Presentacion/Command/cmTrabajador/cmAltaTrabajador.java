package Clases.Presentación.Command.cmTrabajador;

import Clases.Negocio.FactoriaSA;
import Clases.Negocio.Producto.TProducto;
import Clases.Negocio.Trabajador.TTrabajador;
import Clases.Presentación.Contexto;
import Clases.Presentación.Command.Command;
import Clases.Presentación.Command.Events;

public class cmAltaTrabajador implements Command {

	public cmAltaTrabajador() {

	}

	@Override
	public Contexto execute(Object data) {
		int ret = FactoriaSA.getInstance().generateSATrabajador().altaTrabajador((TTrabajador)data);
		if(ret > 0) {
			return new Contexto(Events.ALTA_TRABAJADOR_OK,ret);
		}
		else return new Contexto(Events.ALTA_TRABAJADOR_KO,ret);
	}

}
