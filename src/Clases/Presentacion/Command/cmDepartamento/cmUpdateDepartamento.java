package Clases.Presentaci�n.Command.cmDepartamento;

import Clases.Negocio.FactoriaSA;
import Clases.Negocio.Departamento.TDepartamento;
import Clases.Presentaci�n.Contexto;
import Clases.Presentaci�n.Command.Command;
import Clases.Presentaci�n.Command.Events;

public class cmUpdateDepartamento implements Command {

	@Override
	public Contexto execute(Object data) {
		if(data.getClass().equals(Integer.class))
		{
			TDepartamento ret = FactoriaSA.getInstance().generateSADepartamento().mostrarDepartamento((int)data);
			if(ret != null) {
				return new Contexto(Events.MODIFICA_DEPARTAMENTO_READ_OK,ret);
			}
			else return new Contexto(Events.MODIFICA_DEPARTAMENTO_READ_KO,ret);
		}
		else {
			int ret = FactoriaSA.getInstance().generateSADepartamento().actualizarDepartamento((TDepartamento)data);
			if(ret > 0) {
				return new Contexto(Events.MODIFICA_DEPARTAMENTO_OK,ret);
			}
			else return new Contexto(Events.MODIFICA_DEPARTAMENTO_KO,ret);
		}
		
	}
}
