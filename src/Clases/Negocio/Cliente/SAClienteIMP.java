/**
 * 
 */
package Clases.Negocio.Cliente;

import java.util.HashMap;
import java.util.List;

import Clases.Integración.FactoriaDAO;
import Clases.Integración.Cliente.DAOCliente;
import Clases.Integración.Transaction.Transaction;
import Clases.Integración.Transaction.TransactionManager;
import Clases.Integración.query.query;
import Clases.Integración.query.queryFactory;

import Clases.Negocio.FormatoSA;
import Clases.Negocio.Venta.TVenta;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author Mario, Javier, Yule, David, Alberto, Iker, Fernando, Francisco
 * @generated "UML a Java
 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class SAClienteIMP implements SACliente {

	/**
	 * (non-Javadoc)
	 * 
	 * @see SACliente#create(TCliente TCliente)
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Integer create(TCliente tc) {
		Transaction transaction = TransactionManager.getInstance().newTransaction();
		int id = 0;
		FormatoSA format = new FormatoSA();

		if (format.formatoTClienteCorrecto(tc) == 1) {
			if (transaction != null) {
				transaction.start();

				DAOCliente dc = FactoriaDAO.getInstance().getDAOCliente();

				if (tc.getClass().equals(TClienteEmpresa.class)) {
					id = dc.readByCIF((TClienteEmpresa) tc); 
					if(id!=0) id=-31;

				} else if (tc.getClass().equals(TClienteParticulares.class)) {
					id = dc.readByDNI((TClienteParticulares) tc);
					if(id!=0) id=-32;
				}
				
				if (id ==0) {
					id = dc.create(tc);
					if (id > 0)
						transaction.commit();

				}
				if (id < 0)
					transaction.rollback();
			}

			else
				id = -60;
		} else
			id = format.formatoTClienteCorrecto(tc);
		TransactionManager.getInstance().deleteTransaction();

		return id;
	}
	
	public int update(TCliente tc) {
		Transaction transaction = TransactionManager.getInstance().newTransaction();
		int id = 0;
		
		FormatoSA format = new FormatoSA();
		
		if (format.formatoTClienteCorrecto(tc) == 1) {
			if (transaction != null) {
				transaction.start();
				if (tc != null) {
					DAOCliente dc = FactoriaDAO.getInstance().getDAOCliente();
					
					if (tc.getClass().equals(TClienteEmpresa.class)) {
						id = dc.readByCIF((TClienteEmpresa) tc); 
						if(id!=0 && id!=tc.getId()) id=-31; //esta repetido (no se cuenta a si mismo)

					} else if (tc.getClass().equals(TClienteParticulares.class)) {
						id = dc.readByDNI((TClienteParticulares) tc);
						if(id!=0 && id!=tc.getId()) id=-32; //esta repetido (no se cuenta a si mismo)
					}
					if(id==0 || id == tc.getId()) {
						id = dc.update(tc);
					}
				} 
				else
					id = -33;
				
				if (id < 0)
					transaction.rollback();
				else
					transaction.commit();
			}
			
			else
				id = -60;
		} else
			id = format.formatoTClienteCorrecto(tc);
		
		TransactionManager.getInstance().deleteTransaction();
		
		return id;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see SACliente#delete(Integer ID)
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Integer delete(Integer ID) {
		Transaction transaction = TransactionManager.getInstance().newTransaction();
		int id = 0;
		if (transaction != null) {
			transaction.start();
			DAOCliente DaoCliente = FactoriaDAO.getInstance().getDAOCliente();
			TCliente cliente = DaoCliente.read(ID);
			if (cliente != null) {
				if(cliente.getActivo()) {
					List<TVenta> vents = FactoriaDAO.getInstance().getDAOVenta().readAllOneCliente(cliente.getId());
					
					if(vents.size() == 0) {
						id = DaoCliente.delete(ID);
						if (id == -50) {
							transaction.rollback();
						} 
						else
							transaction.commit();
					}
					else {
						id = -42;
						transaction.rollback();
					}
				}
				else {
					id = -41;
					transaction.rollback();
				}
			} else {
				id = -3;
				transaction.rollback();
			}

		} else
			id = -60;
		TransactionManager.getInstance().deleteTransaction();
		return id;
	}

	

	/**
	 * (non-Javadoc)
	 * 
	 * @see SACliente#read(Integer ID)
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TCliente read(Integer ID) {
		// begin-user-code
		// TODO Auto-generated method stub

		Transaction transaction = TransactionManager.getInstance().newTransaction();
		TCliente cliente = null;
		if (transaction != null) {
			transaction.start();
			cliente = FactoriaDAO.getInstance().getDAOCliente().read(ID);
			if (cliente == null)
				transaction.rollback();
			else
				transaction.commit();
		}
		TransactionManager.getInstance().deleteTransaction();

		return cliente;
		// end-user-code
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see SACliente#readAll()
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public List<TCliente> readAll() {
		Transaction transaction = TransactionManager.getInstance().newTransaction();
		List<TCliente> listaClientes = null;
		if (transaction != null) {
			transaction.start();

			listaClientes = FactoriaDAO.getInstance().getDAOCliente().readAll();
			if (listaClientes != null) {
				transaction.commit();
			} else {
				transaction.rollback();
			}

		}

		TransactionManager.getInstance().deleteTransaction();
		return listaClientes;
	}


	
	/**
	 * (non-Javadoc)
	 * 
	 * @see SACliente#clienteXY(Integer Parameter2, Integer Parameter3)
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@SuppressWarnings("unchecked")
	public HashMap<TCliente,Float> clienteXY(float x, float y) {
		Transaction transaction = TransactionManager.getInstance().newTransaction();
		HashMap<TCliente,Float> listaClientes = null;
		if (transaction != null) {
			transaction.start();
			float [] parametrosXY = {x,y};
			query client = queryFactory.getInstance().newQuery("entre_x_e_y");
			listaClientes = (HashMap<TCliente,Float>) client.execute(parametrosXY);
			if (listaClientes != null) {
				transaction.commit();
			} else {
				transaction.rollback();
			}

		}

		TransactionManager.getInstance().deleteTransaction();
		return listaClientes;
	}

	public static boolean isNumeric(String str) {
		try {
			Double.parseDouble(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

}