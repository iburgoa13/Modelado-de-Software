package Clases.Presentación.Command.cmDepartamento;

import Clases.Negocio.FactoriaSA;
import Clases.Negocio.Empresa.Empresa;
import Clases.Presentación.Contexto;
import Clases.Presentación.Command.Command;
import Clases.Presentación.Command.Events;

public class cmBajaDepartamento implements Command {
	public cmBajaDepartamento() {

	}

	@Override
	public Contexto execute(Object data) {
		int ret = FactoriaSA.getInstance().generateSADepartamento().bajaDepartamento((int) data);
		if(ret > 0) {
			return new Contexto(Events.BAJA_DEPARTAMENTO_OK,ret);
		}
		else return new Contexto(Events.BAJA_DEPARTAMENTO_KO,ret);
	}
}
