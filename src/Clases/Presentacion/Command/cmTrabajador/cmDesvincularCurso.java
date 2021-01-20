package Clases.Presentación.Command.cmTrabajador;

import Clases.Negocio.FactoriaSA;
import Clases.Negocio.CursoTrabajador.TCursoTrabajador;
import Clases.Presentación.Contexto;
import Clases.Presentación.Command.Command;
import Clases.Presentación.Command.Events;

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
