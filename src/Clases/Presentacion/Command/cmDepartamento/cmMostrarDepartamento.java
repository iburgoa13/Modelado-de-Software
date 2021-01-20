package Clases.Presentaci�n.Command.cmDepartamento;

import Clases.Negocio.FactoriaSA;
import Clases.Negocio.Departamento.TDepartamento;
import Clases.Presentaci�n.Contexto;
import Clases.Presentaci�n.Command.Command;
import Clases.Presentaci�n.Command.Events;

public class cmMostrarDepartamento implements Command{
	public cmMostrarDepartamento() {}

	@Override
	public Contexto execute(Object data) {
		TDepartamento ret = FactoriaSA.getInstance().generateSADepartamento().mostrarDepartamento((int)data);
		
		if(ret !=null) {
			return new Contexto(Events.MOSTRAR_DEPARTAMENTO_OK,ret);
		}
		else return new Contexto(Events.MOSTRAR_DEPARTAMENTO_KO,ret);
	}
}
