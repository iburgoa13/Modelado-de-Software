package Clases.Presentación.Command.cmTrabajador;

import Clases.Negocio.FactoriaSA;
import Clases.Presentación.Contexto;
import Clases.Presentación.Command.Command;
import Clases.Presentación.Command.Events;

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
