/**
 * 
 */
package Clases.Presentación.Command;

import Clases.Presentación.Command.cmCliente.cmActualizarDatosCliente;
import Clases.Presentación.Command.cmCliente.cmAltaClienteEmpresa;
import Clases.Presentación.Command.cmCliente.cmAltaClienteParticular;
import Clases.Presentación.Command.cmCliente.cmBajaCliente;
import Clases.Presentación.Command.cmCliente.cmListarEntreXY;
import Clases.Presentación.Command.cmCliente.cmListarTodosCliente;
import Clases.Presentación.Command.cmCliente.cmMostrarDatosCliente;
import Clases.Presentación.Command.cmCliente.cmMostrarVentasCliente;
import Clases.Presentación.Command.cmMarca.cmAltaMarca;
import Clases.Presentación.Command.cmMarca.cmBajaMarca;
import Clases.Presentación.Command.cmMarca.cmModificarMarca;
import Clases.Presentación.Command.cmMarca.cmMostrarMarca;
import Clases.Presentación.Command.cmMarca.cmMostrarMarcaModifica;
import Clases.Presentación.Command.cmMarca.cmMostrarMarcas;
import Clases.Presentación.Command.cmMarca.cmMostrarProductosDeMarca;
import Clases.Presentación.Command.cmProducto.cmAltaProducto;
import Clases.Presentación.Command.cmProducto.cmBajaProducto;
import Clases.Presentación.Command.cmProducto.cmModificarProducto;
import Clases.Presentación.Command.cmProducto.cmMostrarProducto;
import Clases.Presentación.Command.cmProducto.cmMostrarProductos;
import Clases.Presentación.Command.cmVenta.cmAbrirVenta;
import Clases.Presentación.Command.cmVenta.cmBajaVenta;
import Clases.Presentación.Command.cmVenta.cmDevolverVenta;
import Clases.Presentación.Command.cmVenta.cmModificarVenta;
import Clases.Presentación.Command.cmVenta.cmMostrarVenta;
import Clases.Presentación.Command.cmVenta.cmMostrarVentas;
import Clases.Presentación.Command.cmVenta.cmRealizarVenta;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author Mario, Javier, Yule, David, Alberto, Iker, Fernando, Francisco
 * @generated "UML a Java
 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class FactoryCommandIMP extends FactoryCommand {
	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @return
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	
	public Command generateCommand(int event) {
		// begin-user-code
		
		switch (event) {
		//CLIENTE
		case Events.ALTA_CLIENTEE:
			return new cmAltaClienteEmpresa();
		case Events.ALTA_CLIENTEP:
			return new cmAltaClienteParticular();
		case Events.BAJA_CLIENTE:
			return new cmBajaCliente();
		case Events.LISTAR_TODOSCLIENTES:
			return new cmListarTodosCliente();
		case Events.ENTRXYCliente:
			return new cmListarEntreXY();
		case Events.MOSTRAR_CLIENTE:
			return new cmMostrarDatosCliente();
		case Events.MOD_CLIENTE:
			return new cmActualizarDatosCliente();
		case Events.MOD_CLIENTE_E:
			return new cmActualizarDatosCliente();
		case Events.MOD_CLIENTE_P:
			return new cmActualizarDatosCliente();
		case Events.MOSTRAR_VENTAS_CLIENTE:
			return new cmMostrarVentasCliente();
			
		//PRODUCTO
		case Events.ALTA_PRODUCTO:
			return new cmAltaProducto();
		case Events.BAJA_PRODUCTO:
			return new cmBajaProducto();
		case Events.MODIFICA_PRODUCTO:
			return new cmModificarProducto();
		case Events.MOSTRAR_UN_PRODUCTO:
			return new cmMostrarProducto();
		case Events.MOSTRAR_PRODUCTOS:
			return new cmMostrarProductos();
		
			
		//MARCA
		case Events.ALTA_MARCA:
			return new cmAltaMarca();
		case Events.BAJA_MARCA:
			return new cmBajaMarca();
		case Events.MOSTRAR_UNA_MARCA:
			return new cmMostrarMarca();
		case Events.MOSTRAR_MARCAS:
			return new cmMostrarMarcas();
		case Events.MOSTRAR_MARCA_MODIFICA:
			return new cmMostrarMarcaModifica();
		case Events.MODIFICA_MARCA:
			return new cmModificarMarca();
		case Events.MOSTRAR_PRODUCTOSDEMARCA:
			return new cmMostrarProductosDeMarca();
			
		//Venta ...
			
		case Events.ABRIR_VENTA:
			return new cmAbrirVenta();
		case Events.REALIZAR_VENTA:
			return new cmRealizarVenta();
		case Events.BAJA_VENTA:
			return new cmBajaVenta();
		case Events.MODIFICA_VENTA:
			return new cmModificarVenta();
		case Events.MOSTRAR_VENTA:
			return new cmMostrarVenta();
		case Events.MOSTRAR_VENTAS:
			return new cmMostrarVentas();
		case Events.DEVOLUCION_VENTA:
			return new cmDevolverVenta();
		}
		
		return null;
	}

}