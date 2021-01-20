package Clases.Presentación.Command.cmMarca;

import Clases.Negocio.FactoriaSA;
import Clases.Presentación.Contexto;
import Clases.Presentación.Command.Command;
import Clases.Presentación.Command.Events;

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
