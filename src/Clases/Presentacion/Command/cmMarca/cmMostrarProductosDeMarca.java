package Clases.Presentación.Command.cmMarca;

import java.util.List;

import Clases.Negocio.FactoriaSA;
import Clases.Negocio.Producto.TProducto;
import Clases.Presentación.Contexto;
import Clases.Presentación.Command.Command;
import Clases.Presentación.Command.Events;

public class cmMostrarProductosDeMarca implements Command {

	public cmMostrarProductosDeMarca() {
		
	}
	
	@Override
	public Contexto execute(Object data) {
		List<TProducto> Prod = FactoriaSA.getInstance().generateSAProducto().readMarca((int)data);
		if(Prod != null) {
			return new Contexto(Events.MOSTRAR_PRODUCTOSDEMARCA_OK, Prod);
		}
		else return new Contexto(Events.MOSTRAR_PRODUCTOSDEMARCA_KO, Prod);
	}
}
