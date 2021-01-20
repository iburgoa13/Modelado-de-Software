
package Clases.Presentación.Command.cmCurso;
import Clases.Negocio.FactoriaSA;
import Clases.Negocio.Curso.TCurso;
import Clases.Presentación.Contexto;
import Clases.Presentación.Command.Command;
import Clases.Presentación.Command.Events;

	public class cmBajaCurso implements Command {

		public cmBajaCurso() {

		}

		@Override
		public Contexto execute(Object data) {
			
			int ret = FactoriaSA.getInstance().generateSACurso().bajaCurso((int)data);
			if(ret > 0) {
				return new Contexto(Events.BAJA_CURSO_OK,ret);
			}
			else return new Contexto(Events.BAJA_CURSO_KO,ret);
		}

	}


