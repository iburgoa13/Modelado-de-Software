package Clases.Presentaci�n.Command.cmCurso;

import Clases.Negocio.FactoriaSA;
import Clases.Negocio.Curso.TCurso;
import Clases.Presentaci�n.Contexto;
import Clases.Presentaci�n.Command.Command;
import Clases.Presentaci�n.Command.Events;

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


