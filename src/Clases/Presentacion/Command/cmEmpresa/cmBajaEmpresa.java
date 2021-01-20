package Clases.Presentación.Command.cmEmpresa;

import Clases.Negocio.FactoriaSA;
import Clases.Negocio.Empresa.Empresa;
import Clases.Presentación.Contexto;
import Clases.Presentación.Command.Command;
import Clases.Presentación.Command.Events;

public class cmBajaEmpresa implements Command {
	public cmBajaEmpresa() {

	}

	@Override
	public Contexto execute(Object data) {
		int ret = FactoriaSA.getInstance().generateSAEmpresa().bajaEmpresa((int) data);
		if(ret > 0) {
			return new Contexto(Events.BAJA_EMPRESA_OK,ret);
		}
		else return new Contexto(Events.BAJA_EMPRESA_KO,ret);
	}
}
