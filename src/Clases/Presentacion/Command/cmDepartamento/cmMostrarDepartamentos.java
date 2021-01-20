package Clases.Presentaci�n.Command.cmDepartamento;

import java.util.List;

import Clases.Negocio.FactoriaSA;
import Clases.Negocio.Departamento.TDepartamento;
import Clases.Negocio.Marca.TMarca;
import Clases.Presentaci�n.Contexto;
import Clases.Presentaci�n.Command.Command;
import Clases.Presentaci�n.Command.Events;

public class cmMostrarDepartamentos implements Command {

	public cmMostrarDepartamentos() {

	}

	@Override
	public Contexto execute(Object data) {
		List<TDepartamento> dps = FactoriaSA.getInstance().generateSADepartamento().listarDepartamentos();
		if(dps != null) {
			return new Contexto(Events.MOSTRAR_DEPARTAMENTOS_OK,dps);
		}
		else return new Contexto(Events.MOSTRAR_DEPARTAMENTOS_KO,dps);
	}

}
