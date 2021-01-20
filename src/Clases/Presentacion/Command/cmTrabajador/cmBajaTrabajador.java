package Clases.Presentaci�n.Command.cmTrabajador;

import Clases.Negocio.FactoriaSA;
import Clases.Presentaci�n.Contexto;
import Clases.Presentaci�n.Command.Command;
import Clases.Presentaci�n.Command.Events;

public class cmBajaTrabajador implements Command {

	public cmBajaTrabajador() {

	}

	@Override
	public Contexto execute(Object data) {
		int ret = FactoriaSA.getInstance().generateSATrabajador().bajaTrabajador((int)data);
		if(ret > 0) {
			return new Contexto(Events.BAJA_TRABAJADOR_OK,ret);
		}
		else return new Contexto(Events.BAJA_TRABAJADOR_KO,ret);
	}

}
