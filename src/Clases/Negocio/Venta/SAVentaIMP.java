/**
 * 
 */
package Clases.Negocio.Venta;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import Clases.Integración.FactoriaDAO;
import Clases.Integración.Producto.DAOProducto;
import Clases.Integración.Transaction.Transaction;
import Clases.Integración.Transaction.TransactionManager;
import Clases.Negocio.Cliente.TCliente;
import Clases.Negocio.Producto.TProducto;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author Mario, Javier, Yule, David, Alberto, Iker, Fernando, Francisco
 * @generated "UML a Java
 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class SAVentaIMP implements SAVenta {
	/**
	 * (non-Javadoc)
	 * 
	 * @see SAVenta#create(Integer IDCliente)
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Integer abrirVenta(Integer IDCliente) {
		Transaction transaction = TransactionManager.getInstance().newTransaction();
		int id = 0;
		if (transaction != null) {
			transaction.start();
			TCliente cliente = FactoriaDAO.getInstance().getDAOCliente().read(IDCliente);
			if(cliente != null && cliente.getActivo()) {
				id = cliente.getId();
				transaction.commit();
				
			}
			else {
				transaction.rollback();
				id = -3;
			}
			
		}
		else {
			id = -60;
		}	
		
		TransactionManager.getInstance().deleteTransaction();
		return id;
	}

	

	/**
	 * (non-Javadoc)
	 * 
	 * @see SAVenta#realiza(Class tVenta)
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Integer realizar(TVenta venta) {
		
		int id =-9999;
		if(venta!=null) {
			Transaction transaction = TransactionManager.getInstance().newTransaction();
			if(transaction!=null) {
				transaction.start();
				
				TCliente cliente = FactoriaDAO.getInstance().getDAOCliente().read(venta.getIdCliente());
				
				if(cliente != null && cliente.getActivo()) {
					DAOProducto dProd = FactoriaDAO.getInstance().getDAOProducto();
					HashMap<Integer,TOAVenta> carrito = venta.getCarrito();

					Collection<TOAVenta> collectionLineasDeVenta = carrito.values();
					Iterator<TOAVenta> it = collectionLineasDeVenta.iterator();
					TOAVenta linea;
					Boolean existen = true;
					
				    while (existen && it.hasNext()) {//recorro los productos de la venta, veo si existen y les quito stock
				    	linea = it.next();
				    	TProducto prod = dProd.read(linea.getIdProducto());
				    	if(prod==null || !prod.getActivo()) existen=false;
				    	else {
				    		if(prod.getStock()<linea.getCantidad()) {//si no hay stock no se lo compro
				    			carrito.remove(linea.getIdProducto());
				    		}
				    		else {//si hay stock, actualizo el stock
				    			linea.setPrecio(prod.getPrecio());
				    			
				    			venta.setImporte(venta.getImporte() + linea.getPrecio()*linea.getCantidad());
				    			prod.setStock(prod.getStock() -linea.getCantidad());
				    			if (dProd.update(prod)<0) existen=false;//error al actualizar su stock, cancelo
				    		}
				    	}
				    }
				    
				    if(!existen) id = -5; //no existe un producto
				    else {
				    	if(carrito.size()==0) id = -11; //el carrito no tiene productos
				    	else { //se inserta la venta
				    		id = FactoriaDAO.getInstance().getDAOVenta().realizar(venta);
				    	}
				    }
				}
				else id = -3; //no existe el cliente
				
				if(id>0)transaction.commit();
				else transaction.rollback();
				
			}
			else id = -60;
			TransactionManager.getInstance().deleteTransaction();
		}
		return id;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see SAVenta#delete(Integer ID)
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Integer delete(Integer vIdentificador) {
		Transaction transaction = TransactionManager.getInstance().newTransaction();
		int id = 0;
		
		if (transaction != null) {
			transaction.start();
			TVenta venta = FactoriaDAO.getInstance().getDAOVenta().read(vIdentificador);
			if(venta != null) {
				if(venta.getActivo()) {
					id = FactoriaDAO.getInstance().getDAOVenta().delete(vIdentificador);
					if(id == -50) {
						transaction.rollback();
					}
					else transaction.commit();
				}
				else {
					id = -12;
					transaction.rollback();
				}
			}
			else {
				id = -1;
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
	 * @see SAVenta#update()
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Integer update(TVenta venta) {
		Transaction transaction = TransactionManager.getInstance().newTransaction();
		int id = 0;
		if (transaction != null) {
			transaction.start();
			
			TVenta venta_modificada = FactoriaDAO.getInstance().getDAOVenta().read(venta.getId());
			if(venta_modificada != null) {
				id = FactoriaDAO.getInstance().getDAOVenta().update(venta);
					
				if(id < 0) {
					transaction.rollback();
				}
				else transaction.commit();
			}
			else {
				id = -1;
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
	 * @see SAVenta#read(Integer id)
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TVenta read(Integer vIdentificador) {
		
		Transaction transaction = TransactionManager.getInstance().newTransaction();
		TVenta venta = null;
		if (transaction != null) {
			transaction.start();
			venta = FactoriaDAO.getInstance().getDAOVenta().read(vIdentificador);
			
			if(venta != null)
				transaction.commit();
			else 
				transaction.rollback();
		}

		TransactionManager.getInstance().deleteTransaction();
		
		return venta;
		
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see SAVenta#readAll()
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public List<TVenta> readAll() {
		Transaction transaction = TransactionManager.getInstance().newTransaction();
		List<TVenta>ventas  = null;
		if (transaction != null) {
			transaction.start();
			ventas = FactoriaDAO.getInstance().getDAOVenta().readAll();
			if(ventas != null) {
				transaction.commit();
				}
			else {
				transaction.rollback();
			}
			
		}
		TransactionManager.getInstance().deleteTransaction();
		
		return ventas;
	}

	@Override
	public TVenta devolver(TDevolucion devolucion) {
		Transaction transaction = TransactionManager.getInstance().newTransaction();
		TVenta venta = null;
		if (transaction != null) {
			transaction.start();
			venta = FactoriaDAO.getInstance().getDAOVenta().read(devolucion.getIdVenta());
			
			if(venta!=null && venta.getActivo()) {
				
				if(venta.getCarrito().containsKey(devolucion.getIdProd())) {
					boolean precioOk= venta.getCarrito().get(devolucion.getIdProd()).getCantidad() - devolucion.getCantProd()>=0;
					if(precioOk) {
						venta = FactoriaDAO.getInstance().getDAOVenta().devolucion(devolucion);
						if (venta!=null) {
							TProducto prod =  FactoriaDAO.getInstance().getDAOProducto().read(devolucion.getIdProd());
							if(prod!=null) {
								prod.setStock(prod.getStock() + devolucion.getCantProd());
								int id =  FactoriaDAO.getInstance().getDAOProducto().update(prod);
								if (id!= devolucion.getIdProd()) venta=null;
							}
							else venta=null;
						}
						
					}
					else venta=null;
				}
				else venta =null;
			}
			
			if(venta!=null) transaction.commit();
			else transaction.rollback();
		}

		TransactionManager.getInstance().deleteTransaction();
		
		return venta;
	}

	@Override
	public List<TVenta> readAllOneCliente(int cIdentificador) {
		Transaction transaction = TransactionManager.getInstance().newTransaction();
		List<TVenta> vents  = null;
		
		if (transaction != null) {
			transaction.start();
			
			TCliente cliente = FactoriaDAO.getInstance().getDAOCliente().read(cIdentificador);
			if(cliente != null) {
				vents = FactoriaDAO.getInstance().getDAOVenta().readAllOneCliente(cIdentificador);
				if(vents != null) {
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
		
		return vents;
	}
	
	
	
}