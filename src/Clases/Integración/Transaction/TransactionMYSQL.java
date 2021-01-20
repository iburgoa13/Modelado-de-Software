/**
 * 
 */
package Clases.Integración.Transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * usuario: user; pass : ZhUCRYarTZLGpAp6
 * 
 * @author Mario, Javier, Yule, David, Alberto, Iker, Fernando, Francisco
 * @generated "UML a Java
 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class TransactionMYSQL implements Transaction {

	final static private String normalUsr = "user", normalPass = "ZhUCRYarTZLGpAp6";
	private static String usr = normalUsr;
	private static String pass = normalPass;
	private static Connection con;

	/**
	 * (non-Javadoc)
	 * 
	 * @see Transaction#start()
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void start() {
		// begin-user-code
		// TODO Auto-generated method stub
		// Class.forName("com.mysql.jdbc.Driver");
		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://173.255.112.225:3306/mydb?user=" + usr + "?autoReconnect=true&useSSL=false", usr,
					pass);
					
			/*con = DriverManager.getConnection(
					"jdbc:mysql://35.238.244.44:3306/mydb?user=" + usr + "?autoReconnect=true&useSSL=false", usr,
					pass);*/
			con.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// end-user-code
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see Transaction#commit()
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void commit() {
		try {
			con.commit();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see Transaction#rollback()
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void rollback() {
		// begin-user-code
		// TODO Auto-generated method stub
		try {
			con.rollback();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// end-user-code
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see Transaction#getResource()
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Connection getResource() {
		// begin-user-code
		// TODO Auto-generated method stub
		return con;
		// end-user-code
	}
}