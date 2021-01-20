package Clases.Presentaci�n.Command.cmEmpresa;

import Clases.Negocio.FactoriaSA;
import Clases.Negocio.Empresa.TEmpresa;
import Clases.Presentaci�n.Contexto;
import Clases.Presentaci�n.Command.Command;
import Clases.Presentaci�n.Command.Events;

public class cmAltaEmpresa implements Command {

	public cmAltaEmpresa() {

	}

	@Override
	public Contexto execute(Object data) {
		int ret = FactoriaSA.getInstance().generateSAEmpresa().altaEmpresa((TEmpresa) data);
		if(ret > 0) {
			return new Contexto(Events.ALTA_EMPRESA_OK,ret);
		}
		else return new Contexto(Events.ALTA_EMPRESA_KO,ret);
	}

}
