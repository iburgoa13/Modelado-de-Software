package Clases.Presentación.Command.cmEmpresa;

import Clases.Negocio.FactoriaSA;
import Clases.Negocio.Empresa.TEmpresa;
import Clases.Negocio.Producto.TProducto;
import Clases.Presentación.Contexto;
import Clases.Presentación.Command.Command;
import Clases.Presentación.Command.Events;

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
