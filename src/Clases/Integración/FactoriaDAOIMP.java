/**
 * 
 */
package Clases.Integración;

import Clases.Integración.Cliente.DAOCliente;
import Clases.Integración.Cliente.DAOClienteIMP;
import Clases.Integración.Marca.DAOMarca;
import Clases.Integración.Marca.DAOMarcaIMP;
import Clases.Integración.Producto.DAOProducto;
import Clases.Integración.Producto.DAOProductoIMP;
import Clases.Integración.Venta.DAOVenta;
import Clases.Integración.Venta.DAOVentaIMP;

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