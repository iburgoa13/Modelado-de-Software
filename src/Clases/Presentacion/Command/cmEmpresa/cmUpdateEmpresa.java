package Clases.Presentaci�n.Command.cmEmpresa;

import Clases.Negocio.FactoriaSA;
import Clases.Negocio.Empresa.TEmpresa;
import Clases.Presentaci�n.Contexto;
import Clases.Presentaci�n.Command.Command;
import Clases.Presentaci�n.Command.Events;

public class cmUpdateEmpresa implements Command {

	@Override
	public Contexto execute(Object data) {
		if(data.getClass().equals(Integer.class))
		{
			TEmpresa ret = FactoriaSA.getInstance().generateSAEmpresa().mostrarEmpresa((int)data);
			if(ret != null) {
				return new Contexto(Events.MODIFICA_EMPRESA_READ_OK,ret);
			}
			else return new Contexto(Events.MODIFICA_EMPRESA_READ_KO,ret);
		}
		else {
			int ret = FactoriaSA.getInstance().generateSAEmpresa().actualizarEmpresa((TEmpresa)data);
			if(ret > 0) {
				return new Contexto(Events.MODIFICA_EMPRESA_OK,ret);
			}
			else return new Contexto(Events.MODIFICA_EMPRESA_KO,ret);
		}
		
	}
}
