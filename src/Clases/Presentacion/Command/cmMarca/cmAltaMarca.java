package Clases.Presentaci�n.Command.cmMarca;

import Clases.Negocio.FactoriaSA;
import Clases.Negocio.Marca.TMarca;
import Clases.Presentaci�n.Contexto;
import Clases.Presentaci�n.Command.Command;
import Clases.Presentaci�n.Command.Events;

public class cmAltaMarca implements Command {

	public cmAltaMarca() {

	}

	@Override
	public Contexto execute(Object data) {
		int ret = FactoriaSA.getInstance().generateSAMarca().create((TMarca) data);
		if(ret > 0) {
			return new Contexto(Events.ALTA_MARCA_OK,ret);
		}
		else return new Contexto(Events.ALTA_MARCA_KO,ret);
	}

}
