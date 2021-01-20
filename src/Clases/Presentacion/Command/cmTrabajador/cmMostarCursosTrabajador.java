package Clases.Presentaci�n.Command.cmTrabajador;

import java.util.List;

import Clases.Negocio.FactoriaSA;
import Clases.Negocio.Curso.TCurso;
import Clases.Presentaci�n.Contexto;
import Clases.Presentaci�n.Command.Command;
import Clases.Presentaci�n.Command.Events;

public class cmMostarCursosTrabajador implements Command{
	public cmMostarCursosTrabajador() {

	}
	
	@Override
	public Contexto execute(Object data) {
		List<TCurso> cursos = FactoriaSA.getInstance().generateSATrabajador().mostrarCursosTrabajador((int)data);
		
		if(cursos != null) {
			return new Contexto(Events.MOSTRAR_CURSOS_TRABAJADOR_OK, cursos);
		}
		else return new Contexto(Events.MOSTRAR_CURSOS_TRABAJADOR_KO, cursos);
	}
}
