package Clases.Presentaci�n.Command.cmMarca;

import Clases.Negocio.FactoriaSA;
import Clases.Negocio.Marca.TMarca;
import Clases.Presentaci�n.Contexto;
import Clases.Presentaci�n.Command.Command;
import Clases.Presentaci�n.Command.Events;

public class cmMostrarMarcaModifica implements Command {
	
	public cmMostrarMarcaModifica() {

	}

	@Override
	public Contexto execute(Object data) {
		TMarca ret = FactoriaSA.getInstance().generateSAMarca().read((int)data);
		if(ret !=null) {
			return new Contexto(Events.MOSTRAR_MARCA_MODIFICA_OK,ret);
		}
		else return new Contexto(Events.MOSTRAR_MARCA_MODIFICA_KO,ret);
	}

}
