package Clases.Presentaci�n.Command.cmTrabajador;

import Clases.Negocio.FactoriaSA;
import Clases.Negocio.CursoTrabajador.TCursoTrabajador;
import Clases.Presentaci�n.Contexto;
import Clases.Presentaci�n.Command.Command;
import Clases.Presentaci�n.Command.Events;

public class cmDesvincularCurso implements Command {

	public cmDesvincularCurso() {

	}

	@Override
	public Contexto execute(Object data) {
		TCursoTrabajador tc = (TCursoTrabajador)data;
		int ret = FactoriaSA.getInstance().generateSATrabajador().desvincularCurso(tc.getIdTrabajador(), tc.getIdCurso());
		if(ret > 0) {
			return new Contexto(Events.DESVINCULAR_CURSO_OK,ret);
		}
		else return new Contexto(Events.DESVINCULAR_CURSO_KO,ret);
	}

}
