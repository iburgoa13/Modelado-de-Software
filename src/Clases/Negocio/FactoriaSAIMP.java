/**
 * 
 */
package Clases.Negocio;

import Clases.Negocio.Cliente.SACliente;
import Clases.Negocio.Cliente.SAClienteIMP;
import Clases.Negocio.Curso.SACurso;
import Clases.Negocio.Curso.SACursoIMP;
import Clases.Negocio.Departamento.SADepartamento;
import Clases.Negocio.Departamento.SADepartamentoIMP;
import Clases.Negocio.Empresa.SAEmpresa;
import Clases.Negocio.Empresa.SAEmpresaIMP;
import Clases.Negocio.Marca.SAMarca;
import Clases.Negocio.Marca.SAMarcaIMP;
import Clases.Negocio.Producto.SAProducto;
import Clases.Negocio.Producto.SAProductoIMP;
import Clases.Negocio.Trabajador.SATrabajador;
import Clases.Negocio.Trabajador.SATrabajadorIMP;
import Clases.Negocio.Venta.SAVenta;
import Clases.Negocio.Venta.SAVentaIMP;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author Mario, Javier, Yule, David, Alberto, Iker, Fernando, Francisco
 * @generated "UML a Java
 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class FactoriaSAIMP extends FactoriaSA {
	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @return
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public SACliente generateSACliente() {
		// begin-user-code
		// TODO Auto-generated method stub
		return new SAClienteIMP();
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @return
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public SAVenta generateSAVenta() {
		// begin-user-code
		// TODO Auto-generated method stub
		return new SAVentaIMP();
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @return
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public SACurso generateSACurso() {
		// begin-user-code
		// TODO Auto-generated method stub
		return new SACursoIMP();
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public SAMarca generateSAMarca() {
		// begin-user-code
		// TODO Auto-generated method stub
		return new SAMarcaIMP();
		// end-user-code
	}

	@Override
	public SATrabajador generateSATrabajador() {
		return new SATrabajadorIMP();
	}
	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public SAProducto generateSAProducto() {
		// begin-user-code
		// TODO Auto-generated method stub
		return new SAProductoIMP();
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public SAEmpresa generateSAEmpresa() {
		// begin-user-code
		// TODO Auto-generated method stub
		return new SAEmpresaIMP();
		// end-user-code
	}

	@Override
	public SADepartamento generateSADepartamento() {
		// TODO Auto-generated method stub
		return new SADepartamentoIMP();
	}

	
	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	
}