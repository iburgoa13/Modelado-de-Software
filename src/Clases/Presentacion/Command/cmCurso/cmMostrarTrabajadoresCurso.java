package Clases.Presentaci�n.Command.cmCurso;

import java.util.List;

import Clases.Negocio.FactoriaSA;
import Clases.Negocio.Trabajador.TTrabajador;
import Clases.Presentaci�n.Contexto;
import Clases.Presentaci�n.Command.Command;
import Clases.Presentaci�n.Command.Events;

public class cmMostrarTrabajadoresCurso implements Command {
	public cmMostrarTrabajadoresCurso() {
	}

	@Override
	public Contexto execute(Object data) {
		List<TTrabajador> ret = FactoriaSA.getInstance().generateSACurso().listarTrabajadoresCurso((int) data);
		if (ret != null) {
			return new Contexto(Events.MOSTRAR_TRABAJADORES_CURSO_OK, ret);
		} else
			return new Contexto(Events.MOSTRAR_TRABAJADORES_CURSO_KO, ret);

	}
}