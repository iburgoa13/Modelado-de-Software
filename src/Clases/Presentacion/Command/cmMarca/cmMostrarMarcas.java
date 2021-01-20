package Clases.Presentación.Command.cmMarca;

import java.util.List;

import Clases.Negocio.FactoriaSA;
import Clases.Negocio.Marca.TMarca;
import Clases.Presentación.Contexto;
import Clases.Presentación.Command.Command;
import Clases.Presentación.Command.Events;

public class cmMostrarMarcas implements Command {

	public cmMostrarMarcas() {

	}

	@Override
	public Contexto execute(Object data) {
		List<TMarca> Marcas = FactoriaSA.getInstance().generateSAMarca().readAll();
		if(Marcas != null) {
			return new Contexto(Events.MOSTRAR_MARCAS_OK,Marcas);
		}
		else return new Contexto(Events.MOSTRAR_MARCAS_KO,Marcas);
	}

}
