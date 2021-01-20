package Clases.Presentaci�n.Command.cmDepartamento;

import java.util.List;

import Clases.Negocio.FactoriaSA;
import Clases.Negocio.Departamento.TDepartamento;
import Clases.Negocio.Trabajador.TTrabajador;
import Clases.Presentaci�n.Contexto;
import Clases.Presentaci�n.Command.Command;
import Clases.Presentaci�n.Command.Events;

public class cmMostrarTrabajadoresDepartamento implements Command {

	public cmMostrarTrabajadoresDepartamento() {

	}
	
	@Override
	public Contexto execute(Object data) {
		List<TTrabajador> trabajadores = FactoriaSA.getInstance().generateSADepartamento().listarTrabajadoresDepartamento((int)data);
		if(trabajadores != null) {
			
			return new Contexto(Events.MOSTRAR_TRABAJADORES_DEPARTAMENTO_OK,trabajadores);
		}
		else return new Contexto(Events.MOSTRAR_TRABAJADORES_DEPARTAMENTO_KO,trabajadores);
	}

}
