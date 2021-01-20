package Clases.Presentación.Command.cmCurso;

import Clases.Negocio.FactoriaSA;
import Clases.Negocio.Curso.TCurso;
import Clases.Presentación.Contexto;
import Clases.Presentación.Command.Command;
import Clases.Presentación.Command.Events;

	public class cmMostrarCurso implements Command{
		public cmMostrarCurso() {}

		@Override
		public Contexto execute(Object data) {
			TCurso ret = FactoriaSA.getInstance().generateSACurso().mostrarCurso((int)data);
			
			if(ret !=null) {
				return new Contexto(Events.MOSTRAR_CURSO_OK,ret);
			}
			else return new Contexto(Events.MOSTRAR_CURSO_KO,ret);
		}
	}


