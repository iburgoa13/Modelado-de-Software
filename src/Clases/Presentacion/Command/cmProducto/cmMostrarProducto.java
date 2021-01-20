package Clases.Presentación.Command.cmProducto;

import Clases.Negocio.FactoriaSA;
import Clases.Negocio.Producto.TProducto;
import Clases.Presentación.Contexto;
import Clases.Presentación.Command.Command;
import Clases.Presentación.Command.Events;

public class cmMostrarProducto implements Command {

	public cmMostrarProducto() {

	}

	@Override
	public Contexto execute(Object data) {
		TProducto ret = FactoriaSA.getInstance().generateSAProducto().read((int)data);
		
		if(ret !=null) {
			return new Contexto(Events.MOSTRAR_UN_PRODUCTO_OK,ret);
		}
		else return new Contexto(Events.MOSTRAR_UN_PRODUCTO_KO,ret);
	}

}
