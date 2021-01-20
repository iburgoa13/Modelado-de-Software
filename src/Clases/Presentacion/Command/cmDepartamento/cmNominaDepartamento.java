package Clases.Presentaci�n.Command.cmDepartamento;

import Clases.Negocio.FactoriaSA;
import Clases.Negocio.Departamento.TDepartamento;
import Clases.Presentaci�n.Contexto;
import Clases.Presentaci�n.Command.Command;
import Clases.Presentaci�n.Command.Events;

public class cmNominaDepartamento implements Command {

	public cmNominaDepartamento() {

	}

	@Override
	public Contexto execute(Object data) {
		
		Float ret = FactoriaSA.getInstance().generateSADepartamento().calcularNomina((Integer)data);
		if(ret >= 0) {
			return new Contexto(Events.MOSTRAR_SUELDO_DEPARTAMENTO_OK,ret);
		}
		else return new Contexto(Events.MOSTRAR_SUELDO_DEPARTAMENTO_KO,ret);
	}

}
