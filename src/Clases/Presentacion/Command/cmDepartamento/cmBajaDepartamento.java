package Clases.Presentaci�n.Command.cmDepartamento;

import Clases.Negocio.FactoriaSA;
import Clases.Negocio.Empresa.Empresa;
import Clases.Presentaci�n.Contexto;
import Clases.Presentaci�n.Command.Command;
import Clases.Presentaci�n.Command.Events;

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
