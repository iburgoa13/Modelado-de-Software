/**
 * 
 */
package Clases.Negocio.Producto;

import java.util.List;

import Clases.Integración.FactoriaDAO;
import Clases.Integración.Transaction.Transaction;
import Clases.Integración.Transaction.TransactionManager;
import Clases.Negocio.Marca.TMarca;


/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author Mario, Javier, Yule, David, Alberto, Iker, Fernando, Francisco
 * @generated "UML a Java
 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class SAProductoIMP implements SAProducto {
	
	
	/**
	 * (non-Javadoc)
	 * 
	 * @see SAProducto#create()
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int create(TProducto producto) {
		Transaction transaction = TransactionManager.getInstance().newTransaction();
		int id = 0;
		if (transaction != null) {
			transaction.start();
			//aqui hacer las comprobaciones correspondientes
			//AQUI USAR EL READ DE MARCA PARA COMPROBAR QUE EXISTE EL ID MARCA 
			TMarca idMarca = FactoriaDAO.getInstance().getDAOMarca().read(producto.getMarca());
			if(idMarca != null) {
				if(idMarca.getActivo()) {
					int _nombreRepetido = FactoriaDAO.getInstance().getDAOProducto().readByName(producto.getNombre());
					if(_nombreRepetido==-1) {
						id = FactoriaDAO.getInstance().getDAOProducto().create(producto);
						if(id == -50) {
							transaction.rollback();
						}
						else transaction.commit();
					}
					else {
						id = -39;
						transaction.rollback();
					}
					
				}
				else {
					id=-13;
					transaction.rollback();
				}
			}
			else {
				id = -7;
				transaction.rollback();
			}
		}

		else
			id = -60;
		TransactionManager.getInstance().deleteTransaction();
		
		return id;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see SAProducto#delete()
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int delete(int pIdentificador) {
		Transaction transaction = TransactionManager.getInstance().newTransaction();
		int id = 0;
		if (transaction != null) {
			transaction.start();
			TProducto pProducto = FactoriaDAO.getInstance().getDAOProducto().read(pIdentificador);
			if(pProducto != null) {
				if(pProducto.getActivo()) {
					id = FactoriaDAO.getInstance().getDAOProducto().delete(pIdentificador);
					if(id == -50) {
						transaction.rollback();
					}
					else transaction.commit();
				}
				else {
					id = -20;
					transaction.rollback();
				}
			}
			else {
				id = -5;
				transaction.rollback();
			}

		}

		else
			id = -60;
		TransactionManager.getInstance().deleteTransaction();
		
		return id;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see SAProducto#update()
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int update(TProducto producto) {
		Transaction transaction = TransactionManager.getInstance().newTransaction();
		int id = 0;
		if (transaction != null) {
			transaction.start();

			TMarca marca = FactoriaDAO.getInstance().getDAOMarca().read(producto.getMarca());
			if(marca != null) {
				if(marca.getActivo()) {
					TProducto producto_modificado = FactoriaDAO.getInstance().getDAOProducto().read(producto.getId());
					if(producto_modificado != null) {
						int _nombreRepetido = FactoriaDAO.getInstance().getDAOProducto().readByName(producto.getNombre());
						if(_nombreRepetido==-1 || _nombreRepetido == producto.getId()) {
							id = FactoriaDAO.getInstance().getDAOProducto().update(producto);
							if(id == -50) {
								transaction.rollback();
							}
							else transaction.commit();
						}
						else if(_nombreRepetido != -60 && _nombreRepetido != producto.getId()){
							id = -39;
							transaction.rollback();
						}
						else {
							id = -60;
							transaction.rollback();
						}
					}
					else {
						id = -5;
						transaction.rollback();
					}
				}
				else {
					id = -13;
					transaction.rollback();
				}
			}
			else {
				id = -7;
				transaction.rollback();
			}
			
			
		}

		else
			id = -60;
		TransactionManager.getInstance().deleteTransaction();
		
		return id;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see SAProducto#read()
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TProducto read(int pIdentificador) {
		Transaction transaction = TransactionManager.getInstance().newTransaction();
		TProducto id = null;
		if (transaction != null) {
			transaction.start();
			id = FactoriaDAO.getInstance().getDAOProducto().read(pIdentificador);
			transaction.commit();
		}

		else
			id = null;
		TransactionManager.getInstance().deleteTransaction();
		
		return id;
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see SAProducto#readAll()
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public List<TProducto> readAll() {
		Transaction transaction = TransactionManager.getInstance().newTransaction();
		List<TProducto>productos  = null;
		if (transaction != null) {
			transaction.start();
			
			productos = FactoriaDAO.getInstance().getDAOProducto().readAll();
			if(productos != null) {
				transaction.commit();
				}
			else {
				transaction.rollback();
			}
			
		}


		TransactionManager.getInstance().deleteTransaction();
		
		return productos;
	}

	@Override
	public List<TProducto> readMarca(int mIdentificador) {
		Transaction transaction = TransactionManager.getInstance().newTransaction();
		List<TProducto> productos  = null;
		
		if (transaction != null) {
			transaction.start();
			
			TMarca marca = FactoriaDAO.getInstance().getDAOMarca().read(mIdentificador);
			if(marca != null) {
				productos = FactoriaDAO.getInstance().getDAOProducto().readMarca(mIdentificador);
				if(productos != null) {
					transaction.commit();
				}
				else {
					transaction.rollback();
				}
			}
			else {
				transaction.rollback();
			}
			
		}

		TransactionManager.getInstance().deleteTransaction();
		
		return productos;
	}

}