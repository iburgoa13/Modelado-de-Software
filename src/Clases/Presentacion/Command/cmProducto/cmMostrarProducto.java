package Clases.Presentaci�n.Command.cmProducto;

import Clases.Negocio.FactoriaSA;
import Clases.Negocio.Producto.TProducto;
import Clases.Presentaci�n.Contexto;
import Clases.Presentaci�n.Command.Command;
import Clases.Presentaci�n.Command.Events;

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
