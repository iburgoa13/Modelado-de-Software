package Clases.Presentación.Command.cmCurso;
import Clases.Negocio.FactoriaSA;
import Clases.Negocio.Curso.TCurso;
import Clases.Presentación.Contexto;
import Clases.Presentación.Command.Command;
import Clases.Presentación.Command.Events;

public class cmUpdateCurso implements Command {

	@Override
	public Contexto execute(Object data) {
		if(data.getClass().equals(Integer.class))
		{
			TCurso ret = FactoriaSA.getInstance().generateSACurso().mostrarCurso((int)data);
			if(ret != null) {
				return new Contexto(Events.MODIFICA_CURSO_READ_OK,ret);
			}
			else return new Contexto(Events.MODIFICA_CURSO_READ_KO,ret);
		}
		else {
			int ret = FactoriaSA.getInstance().generateSACurso().actualizarCurso((TCurso)data);
			if(ret > 0) {
				return new Contexto(Events.MODIFICA_CURSO_OK,ret);
			}
			else return new Contexto(Events.MODIFICA_CURSO_KO,ret);
		}
		
	}
}
