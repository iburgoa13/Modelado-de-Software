/**
 * 
 */
package Clases.Presentación.Dispatcher;

import Clases.Presentación.Contexto;
import Clases.Presentación.Cliente.GUICliente;
import Clases.Presentación.Command.Events;
import Clases.Presentación.Curso.GUICurso;
import Clases.Presentación.Departamento.GUIDepartamento;
import Clases.Presentación.Empresa.GUIEmpresa;
import Clases.Presentación.Marca.GUIMarca;
import Clases.Presentación.ParteDAO.GUI_DAO;
import Clases.Presentación.ParteJPA.GUI_JPA;
import Clases.Presentación.Producto.GUIProducto;
import Clases.Presentación.Trabajador.GUITrabajador;
import Clases.Presentación.Venta.GUIVenta;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author Mario, Javier, Yule, David, Alberto, Iker, Fernando, Francisco
 * @generated "UML a Java
 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class DispatcherIMP extends Dispatcher {
	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */

	@Override
	public void getView(Contexto ctx) {
		// TODO Auto-generated method stub
		int event = ctx.getEvent();
		switch (event) {
		case Events.GUI_DAO:
			GUI_DAO.getInstance().initialize();
			break;
		case Events.GUI_JPA:
			GUI_JPA.getInstance().initialize();
			break;
		case Events.GUI_Cliente:
            GUICliente.getInstance().initialize();
            break;
		case Events.ALTA_CLIENTEE_OK:
			GUICliente.getInstance().update(ctx);
			break;
		case Events.ALTA_CLIENTEE_KO:
			GUICliente.getInstance().update(ctx);
			break;
		case Events.ALTA_CLIENTEP_OK:
			GUICliente.getInstance().update(ctx);
			break;
		case Events.ALTA_CLIENTEP_KO:
			GUICliente.getInstance().update(ctx);
			break;
		case Events.MOSTRAR_CLIENTE_OK:
			GUICliente.getInstance().update(ctx);
			break;
		case Events.MOSTRAR_CLIENTE_KO:
			GUICliente.getInstance().update(ctx);
			break;
		case Events.MOD_CLIENTE_OKBusqueda:
			GUICliente.getInstance().update(ctx);
			break;
		case Events.MOD_CLIENTE_KOBusqueda:
			GUICliente.getInstance().update(ctx);
			break;
		case Events.MOD_CLIENTE_OKUpdate:
			GUICliente.getInstance().update(ctx);
			break;
		case Events.MOD_CLIENTE_KOUpdate:
			GUICliente.getInstance().update(ctx);
			break;
		case Events.BAJA_CLIENTE_OK:
		    GUICliente.getInstance().update(ctx);
		    break;
		case Events.BAJA_CLIENTE_KO:
			GUICliente.getInstance().update(ctx);
			break;
		case Events.LISTAR_TODOSCLIENTES_OK:
			GUICliente.getInstance().update(ctx);
			break;
		case Events.LISTAR_TODOSCLIENTES_KO:
			GUICliente.getInstance().update(ctx);
			break;
		case Events.ENTRXYCliente_OK:
			GUICliente.getInstance().update(ctx);
			break;
		case Events.ENTRXYCliente_KO:
			GUICliente.getInstance().update(ctx);
			break;
		case Events.MOSTRAR_VENTAS_CLIENTE_OK:
			GUICliente.getInstance().update(ctx);
			break;
		case Events.MOSTRAR_VENTAS_CLIENTE_KO:
			GUICliente.getInstance().update(ctx);
			break;
			
            
            //PRODUCTO
        case Events.GUI_Producto:
            GUIProducto.getInstance().initialize();
            break;
        case Events.ALTA_PRODUCTO_OK:
            GUIProducto.getInstance().update(ctx);
            break;
        case Events.ALTA_PRODUCTO_KO:
            GUIProducto.getInstance().update(ctx);
            break;
        case Events.BAJA_PRODUCTO_OK:
            GUIProducto.getInstance().update(ctx);
            break;
        case Events.BAJA_PRODUCTO_KO:
            GUIProducto.getInstance().update(ctx);
            break;
        case Events.MODIFICA_PRODUCTO_READ_OK:
        	GUIProducto.getInstance().update(ctx);
        	break;
        case Events.MODIFICA_PRODUCTO_READ_KO:
        	GUIProducto.getInstance().update(ctx);
        	break;
        case Events.MODIFICAR_PRODUCTO_OK:
            GUIProducto.getInstance().update(ctx);
            break;
        case Events.MODIFICAR_PRODUCTO_KO:
            GUIProducto.getInstance().update(ctx);
            break;
        case Events.MOSTRAR_UN_PRODUCTO_OK:
            GUIProducto.getInstance().update(ctx);
            break;
        case Events.MOSTRAR_UN_PRODUCTO_KO:
            GUIProducto.getInstance().update(ctx);
            break;
        case Events.MOSTRAR_PRODUCTOS_OK:
			GUIProducto.getInstance().update(ctx);
			break;
		case Events.MOSTRAR_PRODUCTOS_KO:
			GUIProducto.getInstance().update(ctx);
			break;
			
			//MARCA
   		case Events.GUI_Marca:
   			GUIMarca.getInstance().initialize();
   			break;
        case Events.ALTA_MARCA_OK:
            GUIMarca.getInstance().update(ctx);
            break;
        case Events.ALTA_MARCA_KO:
            GUIMarca.getInstance().update(ctx);
            break;
        case Events.BAJA_MARCA_OK:
            GUIMarca.getInstance().update(ctx);
            break;
        case Events.BAJA_MARCA_KO:
            GUIMarca.getInstance().update(ctx);
            break;
   		case Events.MOSTRAR_UNA_MARCA_OK:
            GUIMarca.getInstance().update(ctx);
            break;
        case Events.MOSTRAR_UNA_MARCA_KO:
            GUIMarca.getInstance().update(ctx);
            break;
        case Events.MOSTRAR_MARCAS_OK:
 			GUIMarca.getInstance().update(ctx);
 			break;
 		case Events.MOSTRAR_MARCAS_KO:
 			GUIMarca.getInstance().update(ctx);
 			break;
 		case Events.MOSTRAR_MARCA_MODIFICA_OK:
 			GUIMarca.getInstance().update(ctx);
 			break;
 		case Events.MOSTRAR_MARCA_MODIFICA_KO:
 			GUIMarca.getInstance().update(ctx);
 			break;
 		case Events.MODIFICA_MARCA_OK:
 			GUIMarca.getInstance().update(ctx);
 			break;
 		case Events.MODIFICA_MARCA_KO:
 			GUIMarca.getInstance().update(ctx);
 			break;
 		case Events.MOSTRAR_PRODUCTOSDEMARCA_OK:
 			GUIMarca.getInstance().update(ctx);
 			break;
 		case Events.MOSTRAR_PRODUCTOSDEMARCA_KO:
 			GUIMarca.getInstance().update(ctx);
 			break;
		//...
		
		//Venta
   		case Events.GUI_Ventas:
   			GUIVenta.getInstance().initialize();
   			break;
   		case Events.ABRIR_VENTA_OK:
   			GUIVenta.getInstance().update(ctx);
   			break;
   		case Events.ABRIR_VENTA_KO:
   			GUIVenta.getInstance().update(ctx);
   			break;
   		case Events.REALIZAR_VENTA_OK:
   			GUIVenta.getInstance().update(ctx);
   			break;
   		case Events.REALIZAR_VENTA_KO:
   			GUIVenta.getInstance().update(ctx);
   			break;
   		case Events.BAJA_VENTA_OK:
   			GUIVenta.getInstance().update(ctx);
   			break;
   		case Events.BAJA_VENTA_KO:
   			GUIVenta.getInstance().update(ctx);
   			break;
   		case Events.MODIFICA_VENTA_READ_OK:
        	GUIVenta.getInstance().update(ctx);
        	break;
        case Events.MODIFICA_VENTA_READ_KO:
        	GUIVenta.getInstance().update(ctx);
        	break;
        case Events.MODIFICA_VENTA_OK:
            GUIVenta.getInstance().update(ctx);
            break;
        case Events.MODIFICA_VENTA_KO:
            GUIVenta.getInstance().update(ctx);
            break;
   		case Events.MOSTRAR_VENTA_ACTUAL:
   			GUIVenta.getInstance().update(ctx);
   			break;
   		case Events.MOSTRAR_VENTA_OK:
   			GUIVenta.getInstance().update(ctx);
   			break;
   		case Events.MOSTRAR_VENTA_KO:
   			GUIVenta.getInstance().update(ctx);
   			break;
   		case Events.MOSTRAR_VENTAS_OK:
   			GUIVenta.getInstance().update(ctx);
   			break;
   		case Events.MOSTRAR_VENTAS_KO:
   			GUIVenta.getInstance().update(ctx);
   			break;	
   		case Events.DEVOLUCION_VENTA_OK:
   			GUIVenta.getInstance().update(ctx);
   			break;
   		case Events.DEVOLUCION_VENTA_KO:
   			GUIVenta.getInstance().update(ctx);
   			break;
   			
   		case Events.GUI_Empresa:
   			GUIEmpresa.getInstance().initialize();
   			break;
   		case Events.ALTA_EMPRESA_OK:
   			GUIEmpresa.getInstance().update(ctx);
   			break;
   		case Events.ALTA_EMPRESA_KO:
   			GUIEmpresa.getInstance().update(ctx);
   			break;
		case Events.BAJA_EMPRESA_OK:
			GUIEmpresa.getInstance().update(ctx);
			break;
		case Events.BAJA_EMPRESA_KO:
			GUIEmpresa.getInstance().update(ctx);
			break;
		case Events.MODIFICA_EMPRESA_READ_OK:
			GUIEmpresa.getInstance().update(ctx);
        	break;
		case Events.MODIFICA_EMPRESA_READ_KO:
			GUIEmpresa.getInstance().update(ctx);
    	    break;
		case Events.MODIFICA_EMPRESA_OK:
			GUIEmpresa.getInstance().update(ctx);
            break;
		case Events.MODIFICA_EMPRESA_KO:
			GUIEmpresa.getInstance().update(ctx);
            break;
		case Events.MOSTRAR_EMPRESA_OK:
			GUIEmpresa.getInstance().update(ctx);
			break;
		case Events.MOSTRAR_EMPRESA_KO:
			GUIEmpresa.getInstance().update(ctx);
			break;
		case Events.MOSTRAR_EMPRESAS_OK:
			GUIEmpresa.getInstance().update(ctx);
			break;
		case Events.MOSTRAR_EMPRESAS_KO:
			GUIEmpresa.getInstance().update(ctx);
			break;
		case Events.MOSTRAR_CURSOS_EMPRESA_OK:
			GUIEmpresa.getInstance().update(ctx);
			break;
		case Events.MOSTRAR_CURSOS_EMPRESA_KO:
			GUIEmpresa.getInstance().update(ctx);
			break;
    	  
		
		//DEPARTAMENTO
	      case Events.GUI_Departamento:
	    	  GUIDepartamento.getInstance().initialize();
	    	  break;
	      case Events.ALTA_DEPARTAMENTO_OK:
	    	  GUIDepartamento.getInstance().update(ctx);
	    	  break;
	      case Events.ALTA_DEPARTAMENTO_KO:
	    	  GUIDepartamento.getInstance().update(ctx);
	    	  break;
	      case Events.BAJA_DEPARTAMENTO_OK:
	    	  GUIDepartamento.getInstance().update(ctx);
	    	  break;
	      case Events.BAJA_DEPARTAMENTO_KO:
	    	  GUIDepartamento.getInstance().update(ctx);
	    	  break;
	      case Events.MOSTRAR_DEPARTAMENTO_OK:
	    	  GUIDepartamento.getInstance().update(ctx);
	    	  break;
	      case Events.MOSTRAR_DEPARTAMENTO_KO:
	    	  GUIDepartamento.getInstance().update(ctx);
	    	  break;
	      case Events.MOSTRAR_DEPARTAMENTOS_OK:
	    	  GUIDepartamento.getInstance().update(ctx);
	    	  break;
	      case Events.MOSTRAR_DEPARTAMENTOS_KO:
	    	  GUIDepartamento.getInstance().update(ctx);
	    	  break;
	      case Events.MODIFICA_DEPARTAMENTO_OK:
	    	  GUIDepartamento.getInstance().update(ctx);
	    	  break;
	      case Events.MODIFICA_DEPARTAMENTO_KO:
	    	  GUIDepartamento.getInstance().update(ctx);
	    	  break;
	      case Events.MODIFICA_DEPARTAMENTO_READ_OK:
	    	  GUIDepartamento.getInstance().update(ctx);
	          break;
		  case Events.MODIFICA_DEPARTAMENTO_READ_KO:
			  GUIDepartamento.getInstance().update(ctx);
	    	  break;
		 case Events.MOSTRAR_TRABAJADORES_DEPARTAMENTO_OK:
	    	  GUIDepartamento.getInstance().update(ctx);
	    	  break;
	      case Events.MOSTRAR_TRABAJADORES_DEPARTAMENTO_KO:
	    	  GUIDepartamento.getInstance().update(ctx);
	    	  break;
	      case Events.MOSTRAR_SUELDO_DEPARTAMENTO_OK:
	    	  GUIDepartamento.getInstance().update(ctx);
	    	  break;
	      case Events.MOSTRAR_SUELDO_DEPARTAMENTO_KO:
	    	  GUIDepartamento.getInstance().update(ctx);
	    	  break;
	    //TRABAJADOR
	      case Events.GUI_Trabajador:
	    	  GUITrabajador.getInstance().initialize();
	    	  break;
	      case Events.ALTA_TRABAJADOR_OK:
	    	  GUITrabajador.getInstance().update(ctx);
	    	  break;
	      case Events.ALTA_TRABAJADOR_KO:
	    	  GUITrabajador.getInstance().update(ctx);
	    	  break;
	      case Events.BAJA_TRABAJADOR_OK:
	    	  GUITrabajador.getInstance().update(ctx);
	    	  break;
	      case Events.BAJA_TRABAJADOR_KO:
	    	  GUITrabajador.getInstance().update(ctx);
	    	  break;
	      case Events.MOSTRAR_TRABAJADOR_OK:
	    	  GUITrabajador.getInstance().update(ctx);
	    	  break;
	      case Events.MOSTRAR_TRABAJADOR_KO:
	    	  GUITrabajador.getInstance().update(ctx);
	    	  break;
	      case Events.MODIFICA_TRABAJADOR:
	    	  GUITrabajador.getInstance().update(ctx);
	    	  break;
	      case Events.MODIFICA_TRABAJADOR_OK:
	    	  GUITrabajador.getInstance().update(ctx);
	    	  break;
	      case Events.MODIFICA_TRABAJADOR_KO:
	    	  GUITrabajador.getInstance().update(ctx);
	    	  break;
	      case Events.MODIFICA_TRABAJADOR_READ_OK:
	    	  GUITrabajador.getInstance().update(ctx);
	    	  break;
	      case Events.MODIFICA_TRABAJADOR_READ_KO:
	    	  GUITrabajador.getInstance().update(ctx);
	    	  break;
	      case Events.ASIGNAR_CURSO_OK:
	    	  GUITrabajador.getInstance().update(ctx);
	    	  break;
	      case Events.ASIGNAR_CURSO_KO:
	    	  GUITrabajador.getInstance().update(ctx);
	    	  break;
	      case Events.DESVINCULAR_CURSO_OK:
	    	  GUITrabajador.getInstance().update(ctx);
	    	  break;
	      case Events.DESVINCULAR_CURSO_KO:
	    	  GUITrabajador.getInstance().update(ctx);
	    	  break;
	      case Events.MOSTRAR_CURSOS_TRABAJADOR_OK:
	    	  GUITrabajador.getInstance().update(ctx);
	    	  break;
	      case Events.MOSTRAR_CURSOS_TRABAJADOR_KO:
	    	  GUITrabajador.getInstance().update(ctx);
	    	  break;
	      case Events.MOSTRAR_TRABAJADORES_OK:
	    	  GUITrabajador.getInstance().update(ctx);
	    	  break;
	      case Events.MOSTRAR_TRABAJADORES_KO:
	    	  GUITrabajador.getInstance().update(ctx);
	    	  break;
	    	 
	    	//CURSO
	      case Events.GUI_Curso:
	    	  GUICurso.getInstance().initialize();
	    	  break;
	      case Events.ALTA_CURSO_OK:
	    	  GUICurso.getInstance().update(ctx);
	    	  break;
	      case Events.ALTA_CURSO_KO:
	    	  GUICurso.getInstance().update(ctx);
	    	  break;
	      case Events.BAJA_CURSO_OK:
	    	  GUICurso.getInstance().update(ctx);
	    	  break;
	      case Events.BAJA_CURSO_KO:
	    	  GUICurso.getInstance().update(ctx);
	    	  break;
	      case Events.MOSTRAR_CURSO_OK:
	    	  GUICurso.getInstance().update(ctx);
	    	  break;
	      case Events.MOSTRAR_CURSO_KO:
	    	  GUICurso.getInstance().update(ctx);
	    	  break;
	      case Events.MOSTRAR_CURSOS_OK:
	    	  GUICurso.getInstance().update(ctx);
	    	  break;
	      case Events.MOSTRAR_CURSOS_KO:
	    	  GUICurso.getInstance().update(ctx);
	    	  break;
	      case Events.MODIFICA_CURSO_READ_OK:
	    	  GUICurso.getInstance().update(ctx);
	          break;
	      case Events.MODIFICA_CURSO_READ_KO:
	    	  GUICurso.getInstance().update(ctx);
	          break;
	      case Events.MODIFICA_CURSO_OK:
	    	  GUICurso.getInstance().update(ctx);
	          break;
	      case Events.MODIFICA_CURSO_KO:
	    	  GUICurso.getInstance().update(ctx);
	          break;
	      case Events.MOSTRAR_TRABAJADORES_CURSO_OK:
	    	  GUICurso.getInstance().update(ctx);
	      case Events.MOSTRAR_TRABAJADORES_CURSO_KO:
	    	  GUICurso.getInstance().update(ctx);
	          break;
	    	  
		}
	}
}