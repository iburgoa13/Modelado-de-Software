package Clases.Presentación.Command.cmTrabajador;

import Clases.Negocio.FactoriaSA;
import Clases.Negocio.CursoTrabajador.TCursoTrabajador;
import Clases.Negocio.Producto.TProducto;
import Clases.Negocio.Trabajador.TTrabajador;
import Clases.Presentación.Contexto;
import Clases.Presentación.Command.Command;
import Clases.Presentación.Command.Events;

public class cmAsignarCurso implements Command {

	public cmAsignarCurso() {

	}

	@Override
	public Contexto execute(Object data) {
		TCursoTrabajador tc = (TCursoTrabajador)data;
		int ret = FactoriaSA.getInstance().generateSATrabajador().asignarCurso(tc.getIdTrabajador(), tc.getIdCurso(), tc.getFechaIni(), tc.getFechaFin());
		if(ret > 0) {
			return new Contexto(Events.ASIGNAR_CURSO_OK,ret);
		}
		else return new Contexto(Events.ASIGNAR_CURSO_KO,ret);
	}

}
