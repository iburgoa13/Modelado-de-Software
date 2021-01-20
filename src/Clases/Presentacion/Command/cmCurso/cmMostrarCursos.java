package Clases.Presentación.Command.cmCurso;
import java.util.List;
import Clases.Negocio.FactoriaSA;
import Clases.Negocio.Curso.TCurso;
import Clases.Negocio.Marca.TMarca;
import Clases.Presentación.Contexto;
import Clases.Presentación.Command.Command;
import Clases.Presentación.Command.Events;

public class cmMostrarCursos implements Command {

	public cmMostrarCursos() {

	}

	@Override
	public Contexto execute(Object data) {
		List<TCurso> dps = FactoriaSA.getInstance().generateSACurso().listarCursos();
		if(dps != null) {
			return new Contexto(Events.MOSTRAR_CURSOS_OK,dps);
		}
		else return new Contexto(Events.MOSTRAR_CURSOS_KO,dps);
	}

}
