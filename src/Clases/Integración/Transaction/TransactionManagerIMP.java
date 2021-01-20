/**
 * 
 */
package Clases.Integración.Transaction;

import java.util.concurrent.ConcurrentHashMap;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author Mario, Javier, Yule, David, Alberto, Iker, Fernando, Francisco
 * @generated "UML a Java
 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class TransactionManagerIMP extends TransactionManager {
	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private ConcurrentHashMap<Thread, Transaction> transMap;

	public TransactionManagerIMP() {
		transMap = new ConcurrentHashMap<Thread, Transaction>();
	}

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */

	@Override
	public Transaction newTransaction() {
		// TODO Auto-generated method stub
		Transaction t = TransactionFactory.getInstance().createTransaction();
		transMap.put(Thread.currentThread(), t);
		return t;
	}

	@Override
	public Transaction getTransaction() {
		// TODO Auto-generated method stub
		return transMap.get(Thread.currentThread());
	}

	@Override
	public void deleteTransaction() {
		transMap.remove(Thread.currentThread());

	}

}