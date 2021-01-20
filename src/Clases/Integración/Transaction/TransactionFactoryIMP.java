/**
 * 
 */
package Clases.Integración.Transaction;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author Mario, Javier, Yule, David, Alberto, Iker, Fernando, Francisco
 * @generated "UML a Java
 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class TransactionFactoryIMP extends TransactionFactory {

	@Override
	public Transaction createTransaction() {
		// TODO Auto-generated method stub
		return new TransactionMYSQL();
	}
}