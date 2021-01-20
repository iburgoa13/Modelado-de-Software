package Clases.Presentación.Command.cmEmpresa;


import java.util.List;

import Clases.Negocio.FactoriaSA;
import Clases.Negocio.Empresa.TEmpresa;
import Clases.Presentación.Contexto;
import Clases.Presentación.Command.Command;
import Clases.Presentación.Command.Events;

public class cmMostrarEmpresas implements Command{
	public cmMostrarEmpresas() {}

	@Override
	public Contexto execute(Object data) {
		List<TEmpresa> ret = FactoriaSA.getInstance().generateSAEmpresa().listarEmpresas();
		
		if(ret !=null) {
			return new Contexto(Events.MOSTRAR_EMPRESAS_OK,ret);
		}
		else return new Contexto(Events.MOSTRAR_EMPRESAS_KO,ret);
	}
}
