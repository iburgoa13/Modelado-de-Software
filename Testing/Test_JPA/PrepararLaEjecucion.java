package Test_JPA;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;




class PrepararLaEjecucion {

	
	final static private String normalUsr = "root", normalPass = "oxpJk8ncEcwufmfG";
	private static String usr = normalUsr;
	private static String pass = normalPass;
	private static Connection con;
	private static Logger LOGGER = LoggerFactory.getLogger(PrepararLaEjecucion.class);
	
	public static void start() {
		// begin-user-code
		// TODO Auto-generated method stub
		// Class.forName("com.mysql.jdbc.Driver");
		try {
			con = DriverManager.getConnection(
			"jdbc:mysql://34.105.244.238/dbJPA?user=" + usr + "?autoReconnect=true&useSSL=false", usr,
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
	@BeforeAll
	public static void setUp() throws Exception {
		start();
		Statement st = con.createStatement();
		String s0="SET FOREIGN_KEY_CHECKS=0;";
		String s1="SET FOREIGN_KEY_CHECKS=1;";
		
		String a[]= new String[] {"CURSO","CURSOTRABAJADOR","DEPARTAMENTO","EMPRESA","TRABAJADOR","TRABAJADORINDEFINIDO","TRABAJADORTEMPORAL"};
		try{
			System.out.println("===========================================");
			System.out.println("Iniciando borrado y preparación de la BBDD");
			System.out.println("===========================================");
			System.out.println("Desactivando restricciones de claves...");
			st.execute(s0);
			for(String b : a) {
				System.out.println("Borrando tabla: "+b+" ");
				st.execute("Truncate "+b+";");
			}
			System.out.println("Tablas truncadas");
			System.out.println("Activando restricciones de claves...");
			st.execute(s1);
			System.out.println("===========================================");
			System.out.println("Preparada");
			System.out.println("===========================================");
			con.close();
		}
		catch(SQLException E){
			E.printStackTrace();
		}
		
		
	}

	@AfterAll
	static void tearDown() throws Exception {
	}

	@Test
	void test() {
	
	}

}
