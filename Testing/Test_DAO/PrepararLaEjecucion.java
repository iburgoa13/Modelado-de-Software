package Test_DAO;



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
	
		// end-user-code
	}
	@BeforeAll
	public static void setUp() throws Exception {
		start();
		Statement st = con.createStatement();
		String s0="SET FOREIGN_KEY_CHECKS=0;";
		String s1="SET FOREIGN_KEY_CHECKS=1;";
		
		String a[]= new String[] {"Cliente","Empresas","Particulares","Marca",
				"Producto","Venta","Ventas"};
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
