/**
 * 
 */
package Clases.Presentaci�n.Command.cmCliente;

import java.util.List;

import Clases.Negocio.FactoriaSA;
import Clases.Negocio.Cliente.TCliente;
import Clases.Presentaci�n.Contexto;
import Clases.Presentaci�n.Command.Command;
import Clases.Presentaci�n.Command.Events;

public class cmListarTodosCliente implements Command {
	public cmListarTodosCliente() {
		
	}
	public Contexto execute(Object data) {
		List<TCliente> clientes = FactoriaSA.getInstance().generateSACliente().readAll();
		Contexto contexto = null;
		if(clientes != null) {
			contexto = new Contexto(Events.LISTAR_TODOSCLIENTES_OK,clientes);
		}
		else contexto = new Contexto(Events.LISTAR_TODOSCLIENTES_KO,clientes);
		
		return contexto;
	}
}