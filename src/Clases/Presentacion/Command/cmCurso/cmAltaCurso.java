package Clases.Presentación.Command.cmCurso;
import Clases.Negocio.FactoriaSA;
import Clases.Negocio.Curso.TCurso;
import Clases.Presentación.Contexto;
import Clases.Presentación.Command.Command;
import Clases.Presentación.Command.Events;

public class cmAltaCurso implements Command {

	public cmAltaCurso() {

	}

	@Override
	public Contexto execute(Object data) {
		
		int ret = FactoriaSA.getInstance().generateSACurso().altaCurso((TCurso)data);
		if(ret > 0) {
			return new Contexto(Events.ALTA_CURSO_OK,ret);
		}
		else return new Contexto(Events.ALTA_CURSO_KO,ret);
	}

}
