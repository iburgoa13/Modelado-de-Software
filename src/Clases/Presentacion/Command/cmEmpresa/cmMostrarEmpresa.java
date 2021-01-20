package Clases.Presentaci�n.Command.cmEmpresa;

import Clases.Negocio.FactoriaSA;
import Clases.Negocio.Empresa.TEmpresa;
import Clases.Negocio.Producto.TProducto;
import Clases.Presentaci�n.Contexto;
import Clases.Presentaci�n.Command.Command;
import Clases.Presentaci�n.Command.Events;

public class cmMostrarEmpresa implements Command{
	public cmMostrarEmpresa() {}

	@Override
	public Contexto execute(Object data) {
		TEmpresa ret = FactoriaSA.getInstance().generateSAEmpresa().mostrarEmpresa((int)data);
		
		if(ret !=null) {
			return new Contexto(Events.MOSTRAR_EMPRESA_OK,ret);
		}
		else return new Contexto(Events.MOSTRAR_EMPRESA_KO,ret);
	}
}
