/**
 * 
 */
package Clases.Negocio.EntityManagerFactory;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Mario, Javier, Yule, David, Alberto, Iker, Fernando, Francisco
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class EMFactoryIMP extends EMFactory {

	private EntityManagerFactory instance;
	/** 
	* (non-Javadoc)
	* @see EntityManagerFactory#getFactory()
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public EntityManagerFactory getFactory() {
		//return this.getInstance()c
		
		if(instance == null) instance = Persistence.createEntityManagerFactory("mod");
		return instance;
		// begin-user-code
		// TODO Auto-generated method stub
		

		// end-user-code
	}
	@Override
	protected void finalize() throws Throwable{
		try {
			if(instance.isOpen()) {
				instance.close();
			}		
		}
		finally {
			super.finalize();
		}	
	}
	
	
	
}