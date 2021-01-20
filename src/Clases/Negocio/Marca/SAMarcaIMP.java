/**
 * 
 */
package Clases.Negocio.Marca;

import java.util.List;

import Clases.Integración.FactoriaDAO;
import Clases.Integración.Marca.DAOMarca;
import Clases.Integración.Transaction.Transaction;
import Clases.Integración.Transaction.TransactionManager;
import Clases.Negocio.FormatoSA;
import Clases.Negocio.Producto.TProducto;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author Mario, Javier, Yule, David, Alberto, Iker, Fernando, Francisco
 * @generated "UML a Java
 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class SAMarcaIMP implements SAMarca {
	/**
	 * (non-Javadoc)
	 * 
	 * @see SAMarca#create()
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int create(TMarca marca) {

        // begin-user-code
        // TODO Auto-generated method stub

        Transaction transaction = TransactionManager.getInstance().newTransaction();
        int id = 0;
        FormatoSA format = new FormatoSA();

        if (format.formatoTMarcaCorrecto(marca) == 1) {
            if (transaction != null) {
                transaction.start();

            	int _comprobarMarca = FactoriaDAO.getInstance().getDAOMarca().readByName(marca.getNombre());
            	if(_comprobarMarca==-1) {
            		 id = FactoriaDAO.getInstance().getDAOMarca().create(marca);
                     if (id > 0) {
                         transaction.commit();
                     } else {
                         transaction.rollback();
                     }

                     TransactionManager.getInstance().deleteTransaction();
            	}
            	else {
            		id=-37;
            		transaction.rollback();
            	}
                   
                
            } else {
                id = -60;
            }
        } 
        else  id = format.formatoTMarcaCorrecto(marca);
        
        return id;
        // end-user-code

    }

	/**
	 * (non-Javadoc)
	 * 
	 * @return
	 * @see SAMarca#delete()
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int delete(int mId) {
		Transaction transaction = TransactionManager.getInstance().newTransaction();
		int id = 0;
		if (transaction != null) {
			transaction.start();
			DAOMarca daoMarca = FactoriaDAO.getInstance().getDAOMarca();
			TMarca mMarca = daoMarca.read(mId);
			if (mMarca != null) {
				if (mMarca.getActivo()) {
					if (!enProducto(mId)) {
						id = daoMarca.delete(mId);
						if (id == -50) {
							transaction.rollback();
						} else
							transaction.commit();
					} else {
						id = -21;
						transaction.rollback();
					}
				} else {
					id = -13;
					transaction.rollback();
				}

			} else {
				id = -7;
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
	 * @return
	 * @see SAMarca#update()
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int update(TMarca marca) {
		Transaction transaction = TransactionManager.getInstance().newTransaction();
		int id = 0;

		FormatoSA format = new FormatoSA();

		if (format.formatoTMarcaCorrecto(marca) == 1) {
			if (transaction != null) {
				transaction.start();
				
				int _comprobarMarca = FactoriaDAO.getInstance().getDAOMarca().readByName(marca.getNombre());
            	if(_comprobarMarca==-1 || marca.getId() == _comprobarMarca) {
            		 id = FactoriaDAO.getInstance().getDAOMarca().update(marca);
                     if (id > 0) {
                         transaction.commit();
                     } else {
                         transaction.rollback();
                     }

                     TransactionManager.getInstance().deleteTransaction();
            	}
            	else if(marca.getId() != _comprobarMarca && _comprobarMarca != -60) {
            		id=-37;
            		transaction.rollback();
            	}
            	else {
            		id= -60;
            		transaction.rollback();
            	}
			} else {
				id = -60;
			}
		} 
		else id = format.formatoTMarcaCorrecto(marca);
		return id;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @return
	 * @see SAMarca#read()
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TMarca read(int mIdentificador) {
		Transaction transaction = TransactionManager.getInstance().newTransaction();
		TMarca id = null;
		if (transaction != null) {
			transaction.start();
			id = FactoriaDAO.getInstance().getDAOMarca().read(mIdentificador);
			transaction.commit();
		}

		else
			id = null;
		TransactionManager.getInstance().deleteTransaction();

		return id;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @return
	 * @see SAMarca#readAll()
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public List<TMarca> readAll() {
		Transaction transaction = TransactionManager.getInstance().newTransaction();
		List<TMarca> marcas = null;
		if (transaction != null) {
			transaction.start();

			marcas = FactoriaDAO.getInstance().getDAOMarca().readAll();
			if (marcas != null) {
				transaction.commit();
			} else {
				transaction.rollback();
			}

		}

		TransactionManager.getInstance().deleteTransaction();

		return marcas;
	}

	@Override
	public boolean enProducto(int id) {
		List<TProducto> p = FactoriaDAO.getInstance().getDAOProducto().readMarca(id);
		for (TProducto i : p)
			if (i.getActivo())
				return true;
		return false;
	}
}