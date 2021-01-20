package Clases.Presentaci�n.Command.cmEmpresa;

import java.util.List;

import Clases.Negocio.FactoriaSA;
import Clases.Negocio.Curso.TCurso;
import Clases.Presentaci�n.Contexto;
import Clases.Presentaci�n.Command.Command;
import Clases.Presentaci�n.Command.Events;

public class cmMostrarCursosEmpresa implements Command{
	public cmMostrarCursosEmpresa() {}

	@Override
	public Contexto execute(Object data) {
		List<TCurso> ret = FactoriaSA.getInstance().generateSAEmpresa().mostrarCursosEmpresa((int)data);
		
		if(ret !=null) {
			return new Contexto(Events.MOSTRAR_CURSOS_EMPRESA_OK,ret);
		}
		else return new Contexto(Events.MOSTRAR_CURSOS_EMPRESA_KO,ret);
	}
}
