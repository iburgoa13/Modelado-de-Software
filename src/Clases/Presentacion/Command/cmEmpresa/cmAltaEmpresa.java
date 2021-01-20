package Clases.Presentación.Command.cmEmpresa;

import Clases.Negocio.FactoriaSA;
import Clases.Negocio.Empresa.TEmpresa;
import Clases.Presentación.Contexto;
import Clases.Presentación.Command.Command;
import Clases.Presentación.Command.Events;

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
