/**
 * 
 */
package Clases.Presentaci�n.Command;

import Clases.Presentaci�n.Command.cmCliente.cmActualizarDatosCliente;
import Clases.Presentaci�n.Command.cmCliente.cmAltaClienteEmpresa;
import Clases.Presentaci�n.Command.cmCliente.cmAltaClienteParticular;
import Clases.Presentaci�n.Command.cmCliente.cmBajaCliente;
import Clases.Presentaci�n.Command.cmCliente.cmListarEntreXY;
import Clases.Presentaci�n.Command.cmCliente.cmListarTodosCliente;
import Clases.Presentaci�n.Command.cmCliente.cmMostrarDatosCliente;
import Clases.Presentaci�n.Command.cmCliente.cmMostrarVentasCliente;
import Clases.Presentaci�n.Command.cmMarca.cmAltaMarca;
import Clases.Presentaci�n.Command.cmMarca.cmBajaMarca;
import Clases.Presentaci�n.Command.cmMarca.cmModificarMarca;
import Clases.Presentaci�n.Command.cmMarca.cmMostrarMarca;
import Clases.Presentaci�n.Command.cmMarca.cmMostrarMarcaModifica;
import Clases.Presentaci�n.Command.cmMarca.cmMostrarMarcas;
import Clases.Presentaci�n.Command.cmMarca.cmMostrarProductosDeMarca;
import Clases.Presentaci�n.Command.cmProducto.cmAltaProducto;
import Clases.Presentaci�n.Command.cmProducto.cmBajaProducto;
import Clases.Presentaci�n.Command.cmProducto.cmModificarProducto;
import Clases.Presentaci�n.Command.cmProducto.cmMostrarProducto;
import Clases.Presentaci�n.Command.cmProducto.cmMostrarProductos;
import Clases.Presentaci�n.Command.cmVenta.cmAbrirVenta;
import Clases.Presentaci�n.Command.cmVenta.cmBajaVenta;
import Clases.Presentaci�n.Command.cmVenta.cmDevolverVenta;
import Clases.Presentaci�n.Command.cmVenta.cmModificarVenta;
import Clases.Presentaci�n.Command.cmVenta.cmMostrarVenta;
import Clases.Presentaci�n.Command.cmVenta.cmMostrarVentas;
import Clases.Presentaci�n.Command.cmVenta.cmRealizarVenta;

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