package Clases.Presentaci�n.Command.cmDepartamento;

import Clases.Negocio.FactoriaSA;
import Clases.Negocio.Departamento.TDepartamento;
import Clases.Presentaci�n.Contexto;
import Clases.Presentaci�n.Command.Command;
import Clases.Presentaci�n.Command.Events;

public class cmAltaDepartamento implements Command {

	public cmAltaDepartamento() {

	}

	@Override
	public Contexto execute(Object data) {
		
		int ret = FactoriaSA.getInstance().generateSADepartamento().altaDepartamento((TDepartamento)data);
		if(ret > 0) {
			return new Contexto(Events.ALTA_DEPARTAMENTO_OK,ret);
		}
		else return new Contexto(Events.ALTA_DEPARTAMENTO_KO,ret);
	}

}
