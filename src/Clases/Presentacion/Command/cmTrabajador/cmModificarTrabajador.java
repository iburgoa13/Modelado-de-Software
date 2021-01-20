package Clases.Presentación.Command.cmTrabajador;

import Clases.Negocio.FactoriaSA;
import Clases.Negocio.Producto.TProducto;
import Clases.Negocio.Trabajador.TTrabajador;
import Clases.Presentación.Contexto;
import Clases.Presentación.Command.Command;
import Clases.Presentación.Command.Events;

public class cmModificarTrabajador implements Command {

	public cmModificarTrabajador() {

	}

	@Override
	public Contexto execute(Object data) {
		if(data.getClass().equals(Integer.class))
		{
			TTrabajador ret = FactoriaSA.getInstance().generateSATrabajador().mostrarTrabajador((Integer) data);
			if(ret != null) {
				return new Contexto(Events.MODIFICA_TRABAJADOR_READ_OK,ret);
			}
			else return new Contexto(Events.MODIFICA_TRABAJADOR_READ_KO,ret);
		}
		else {
			int ret = FactoriaSA.getInstance().generateSATrabajador().actualizarTrabajador((TTrabajador)data);
			if(ret > 0) {
				return new Contexto(Events.MODIFICA_TRABAJADOR_OK,ret);
			}
			else return new Contexto(Events.MODIFICA_TRABAJADOR_KO,ret);
		}
		
	}

}
