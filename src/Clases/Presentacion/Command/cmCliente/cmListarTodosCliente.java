/**
 * 
 */
package Clases.Presentación.Command.cmCliente;

import java.util.List;

import Clases.Negocio.FactoriaSA;
import Clases.Negocio.Cliente.TCliente;
import Clases.Presentación.Contexto;
import Clases.Presentación.Command.Command;
import Clases.Presentación.Command.Events;

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