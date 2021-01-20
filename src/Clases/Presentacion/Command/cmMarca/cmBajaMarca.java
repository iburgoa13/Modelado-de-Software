package Clases.Presentaci�n.Command.cmMarca;

import Clases.Negocio.FactoriaSA;
import Clases.Presentaci�n.Contexto;
import Clases.Presentaci�n.Command.Command;
import Clases.Presentaci�n.Command.Events;

public class cmBajaMarca implements Command {

	public cmBajaMarca() {

	}

	@Override
	public Contexto execute(Object data) {
		int ret = FactoriaSA.getInstance().generateSAMarca().delete((int) data);
		if(ret > 0) {
			return new Contexto(Events.BAJA_MARCA_OK,ret);
		}
		else return new Contexto(Events.BAJA_MARCA_KO,ret);
	}

}
