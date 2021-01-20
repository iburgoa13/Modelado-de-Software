package Clases.Presentaci�n.Command.cmCurso;
import Clases.Negocio.FactoriaSA;
import Clases.Negocio.Curso.TCurso;
import Clases.Presentaci�n.Contexto;
import Clases.Presentaci�n.Command.Command;
import Clases.Presentaci�n.Command.Events;

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
