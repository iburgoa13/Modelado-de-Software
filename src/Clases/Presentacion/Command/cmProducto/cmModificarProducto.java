package Clases.Presentaci�n.Command.cmProducto;

import Clases.Negocio.FactoriaSA;
import Clases.Negocio.Producto.TProducto;
import Clases.Presentaci�n.Contexto;
import Clases.Presentaci�n.Command.Command;
import Clases.Presentaci�n.Command.Events;

public class cmModificarProducto implements Command {

	public cmModificarProducto() {

	}

	@Override
	public Contexto execute(Object data) {
		if(data.getClass().equals(Integer.class))
		{
			TProducto ret = FactoriaSA.getInstance().generateSAProducto().read((int)data);
			if(ret != null) {
				return new Contexto(Events.MODIFICA_PRODUCTO_READ_OK,ret);
			}
			else return new Contexto(Events.MODIFICA_PRODUCTO_READ_KO,ret);
		}
		else {
			int ret = FactoriaSA.getInstance().generateSAProducto().update((TProducto)data);
			if(ret > 0) {
				return new Contexto(Events.MODIFICAR_PRODUCTO_OK,ret);
			}
			else return new Contexto(Events.MODIFICAR_PRODUCTO_KO,ret);
		}
		
	}

}
