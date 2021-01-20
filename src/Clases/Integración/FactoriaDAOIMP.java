/**
 * 
 */
package Clases.Integraci�n;

import Clases.Integraci�n.Cliente.DAOCliente;
import Clases.Integraci�n.Cliente.DAOClienteIMP;
import Clases.Integraci�n.Marca.DAOMarca;
import Clases.Integraci�n.Marca.DAOMarcaIMP;
import Clases.Integraci�n.Producto.DAOProducto;
import Clases.Integraci�n.Producto.DAOProductoIMP;
import Clases.Integraci�n.Venta.DAOVenta;
import Clases.Integraci�n.Venta.DAOVentaIMP;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author Mario, Javier, Yule, David, Alberto, Iker, Fernando, Francisco
 * @generated "UML a Java
 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class FactoriaDAOIMP extends FactoriaDAO {
	/**
	 * (non-Javadoc)
	 * 
	 * @return
	 * @see FactoriaDAO#getDAOMarca()
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public DAOMarca getDAOMarca() {
		return new DAOMarcaIMP();
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @return
	 * @see FactoriaDAO#getDAOProducto()
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public DAOProducto getDAOProducto() {
		return new DAOProductoIMP();
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @return
	 * @see FactoriaDAO#getDAOVenta()
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public DAOVenta getDAOVenta() {
		return new DAOVentaIMP();
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @return
	 * @see FactoriaDAO#getDAOCliente()
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public DAOCliente getDAOCliente() {
		return new DAOClienteIMP();
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}
}