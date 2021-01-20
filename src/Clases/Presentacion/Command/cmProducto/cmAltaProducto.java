package Clases.Presentación.Command.cmProducto;

import Clases.Negocio.FactoriaSA;
import Clases.Negocio.Producto.TProducto;
import Clases.Presentación.Contexto;
import Clases.Presentación.Command.Command;
import Clases.Presentación.Command.Events;

public class cmAltaProducto implements Command {

	public cmAltaProducto() {

	}

	@Override
	public Contexto execute(Object data) {
		int ret = FactoriaSA.getInstance().generateSAProducto().create((TProducto) data);
		if(ret > 0) {
			return new Contexto(Events.ALTA_PRODUCTO_OK,ret);
		}
		else return new Contexto(Events.ALTA_PRODUCTO_KO,ret);
	}

}
