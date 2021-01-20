package Clases.Presentaci�n.Command.cmProducto;

import java.util.List;

import Clases.Negocio.FactoriaSA;
import Clases.Negocio.Producto.TProducto;
import Clases.Presentaci�n.Contexto;
import Clases.Presentaci�n.Command.Command;
import Clases.Presentaci�n.Command.Events;

public class cmMostrarProductos implements Command {

	public cmMostrarProductos() {

	}

	@Override
	public Contexto execute(Object data) {
		List<TProducto> Productos = FactoriaSA.getInstance().generateSAProducto().readAll();
		if(Productos != null) {
			return new Contexto(Events.MOSTRAR_PRODUCTOS_OK,Productos);
		}
		else return new Contexto(Events.MOSTRAR_PRODUCTOS_KO,Productos);
	}

}
