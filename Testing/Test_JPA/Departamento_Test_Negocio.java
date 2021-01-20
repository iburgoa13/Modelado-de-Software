package Test_JPA;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import Clases.Negocio.FactoriaSA;
import Clases.Negocio.Curso.TCurso;
import Clases.Negocio.Departamento.TDepartamento;
import Clases.Negocio.Empresa.TEmpresa;
import Clases.Negocio.Trabajador.TIndefinido;
import Clases.Negocio.Trabajador.TTemporal;
import Clases.Negocio.Trabajador.TTrabajador;

@TestMethodOrder(OrderAnnotation.class)
public class Departamento_Test_Negocio {
	
	@BeforeAll
    static void setUp() {
		try {
            PrepararLaEjecucion.setUp();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }

	@Test
	@Order(1) 
	void test_createNegocio() {	
		// supungo que partimos de bbdd vacia:
		TDepartamento departamento1 = new TDepartamento("Mer", true, "aa@aa.es", "c/ rosario", (long) 922234451);
		int id_1=FactoriaSA.getInstance().generateSADepartamento().altaDepartamento(departamento1);
		assertEquals(id_1, 1); // inserccion correcta
		TDepartamento departamento2 = new TDepartamento("Merc", true, "aaaaaes", "c/ rosario", (long) 922234451);
		int id_2=FactoriaSA.getInstance().generateSADepartamento().altaDepartamento(departamento2);
		assertEquals(id_2, -83); // correo mal
		TDepartamento departamento3 = new TDepartamento("Merca", true, "aa@aa.es", "c/ rosario", (long) 92233445);
		int id_3=FactoriaSA.getInstance().generateSADepartamento().altaDepartamento(departamento3);
		assertEquals(id_3, -84); // telf mal
		TDepartamento departamento4 = new TDepartamento("Mer", true, "aa@aa.es", "c/ rosario", (long) 922234451);
		int id_4=FactoriaSA.getInstance().generateSADepartamento().altaDepartamento(departamento4);
		assertEquals(id_4, -80); // nombre repetido
		TDepartamento departamento5 = new TDepartamento("Mercc", true, "aa@aa.es", "c/ rosario", (long) 922234451);
		int id_5=FactoriaSA.getInstance().generateSADepartamento().altaDepartamento(departamento5);
		assertEquals(id_5, 2); //comprobar que el id es incremental
	}
	
	@Test
	@Order(2) 
	void test_deleteNegocio() {	
		int id_1 = FactoriaSA.getInstance().generateSADepartamento().bajaDepartamento(2);
		assertEquals(id_1, 2);// borrar departamento correcto
		int id_2 = FactoriaSA.getInstance().generateSADepartamento().bajaDepartamento(2);
		assertEquals(id_2, -82);// departamento ya borrado
		int id_3 = FactoriaSA.getInstance().generateSADepartamento().bajaDepartamento(9999);
		assertEquals(id_3, -81);//departamento no existe
		TTemporal trabajadorTemporal  = new TTemporal("98492521N","Trabajador_Temporal_Test",123456789L,"Calle JUNIT", new Date(Calendar.getInstance().getTimeInMillis()),"temporal@aa.es",true,1,new Date(Calendar.getInstance().getTimeInMillis()),(float) 8.25,35);
		int id_TrabajadorTemporal = FactoriaSA.getInstance().generateSATrabajador().altaTrabajador(trabajadorTemporal);
		int id_4 = FactoriaSA.getInstance().generateSADepartamento().bajaDepartamento(1);
		assertEquals(id_4, -86);//tiene trabajadores
	}
	@Test
	@Order(3) 
	void test_mostrarNegocio() {	
		//aquí va el metodo que me vacia la  tabla.
		//supungo que partimos de bbdd vacia:
		TDepartamento departamento1 = new TDepartamento("Mer", true, "aa@aa.es", "c/ rosario", (long) 922234451);
		TDepartamento departamentoRead = FactoriaSA.getInstance().generateSADepartamento().mostrarDepartamento(1);
		assertEquals(departamentoRead.getCorreo(), departamento1.getCorreo());
		assertEquals(departamentoRead.getNombre(), departamento1.getNombre());
		assertEquals(departamentoRead.getTelefono(), departamento1.getTelefono());
		assertEquals(departamentoRead.getUbicacion(), departamento1.getUbicacion());
		assertNull(FactoriaSA.getInstance().generateSADepartamento().mostrarDepartamento(9999));//comprobar no existe
		
	}
	
	@Test
	@Order(4)
	void test_actualizarNegocio() {
		TDepartamento departamento1 = new TDepartamento("Meraaaaa", true,1, "aa@aa.com", "c/ rosarioaaaaa", (long) 922234452);
		int id_1 = FactoriaSA.getInstance().generateSADepartamento().actualizarDepartamento(departamento1);
		assertEquals(id_1, 1);//actualizar correcto
		TDepartamento departamento2 = new TDepartamento("Meraaaaa", true,9999, "aa@aa.com", "c/ rosarioaaaaa", (long) 922234452);
		int id_2 = FactoriaSA.getInstance().generateSADepartamento().actualizarDepartamento(departamento2);
		assertEquals(id_2, -81);//no existe departamento con ese id
		TDepartamento departamento3 = new TDepartamento("Mercc", true,1, "aa@aa.com", "c/ rosarioaaaaa", (long) 922234452);
		int id_3 = FactoriaSA.getInstance().generateSADepartamento().actualizarDepartamento(departamento3);
		assertEquals(id_3, -80);//nombre ya existe
		TDepartamento departamento4 = new TDepartamento("Mer", true,1, "aaaac", "c/ rosarioaaaaa", (long) 922234452);
		int id_4 = FactoriaSA.getInstance().generateSADepartamento().actualizarDepartamento(departamento4);
		assertEquals(id_4, -83);//correo invalido
		TDepartamento departamento5 = new TDepartamento("Mer", true,1, "aa@aa.com", "c/ rosarioaaaaa", (long) 92223445);
		int id_5 = FactoriaSA.getInstance().generateSADepartamento().actualizarDepartamento(departamento5);
		assertEquals(id_5, -84);//nombre ya existe
		TDepartamento departamento6 = new TDepartamento("Meraaaaa", false,1, "aa@aa.com", "c/ rosarioaaaaa", (long) 922234452);
		int id_6 = FactoriaSA.getInstance().generateSADepartamento().actualizarDepartamento(departamento6);
		assertEquals(id_6, -86);//tiene trabajadores
		TDepartamento departamento7 = new TDepartamento("Mercc", true,2, "aa@aa.es", "c/ rosario", (long) 922234451);
		int id_7 = FactoriaSA.getInstance().generateSADepartamento().actualizarDepartamento(departamento7);
		assertEquals(id_7, 2);//reactivar funciona
		
	}
	
	@Test
	@Order(5)
	void test_listarNegocio() {
		List<TDepartamento> id_1 = FactoriaSA.getInstance().generateSADepartamento().listarDepartamentos();
		assertEquals(id_1.size(),2);//Hay dos departamentos
		
	}
	
	@Test
	@Order(6)
	void listarTrabajadoresDepartamentoNegocio() {
		TTemporal trabajadorTemporal  = new TTemporal("28080985D","Trabajador_Temporal_Test",123456789L,"Calle JUNIT", new Date(Calendar.getInstance().getTimeInMillis()),"temporal@aa.es",true,1,new Date(Calendar.getInstance().getTimeInMillis()),(float) 10,120);
		FactoriaSA.getInstance().generateSATrabajador().altaTrabajador(trabajadorTemporal);
		TIndefinido trabajadorIndefinido  = new TIndefinido("84375312L","Trabajador_Indefinido_Test",123456789L,"Calle JUNIT", new Date(Calendar.getInstance().getTimeInMillis()),"indefinido@test.com",true,1,(float) 1500,(float)25);
		FactoriaSA.getInstance().generateSATrabajador().altaTrabajador(trabajadorIndefinido);
		TIndefinido trabajadorIndefinido2  = new TIndefinido("14851916B","Trabajador_Indefinido_Test",123456789L,"Calle JUNIT", new Date(Calendar.getInstance().getTimeInMillis()),"indefinido@test.com",true,1,(float) 2500,(float)0);
		FactoriaSA.getInstance().generateSATrabajador().altaTrabajador(trabajadorIndefinido2);
		List<TTrabajador> id_1 = FactoriaSA.getInstance().generateSADepartamento().listarTrabajadoresDepartamento(1);
		assertEquals(id_1.size(),4);//Hay 4 trabajadores
		List<TTrabajador> id_2 = FactoriaSA.getInstance().generateSADepartamento().listarTrabajadoresDepartamento(2);
		assertEquals(id_2.size(),0);//No hay trabajadores
		List<TTrabajador> id_3 = FactoriaSA.getInstance().generateSADepartamento().listarTrabajadoresDepartamento(9999);
		assertNull(id_3);//No hay trabajadores
	}
	@Test
	@Order(7)
	void calcularNominaNegocio() {
		Float id_1 = FactoriaSA.getInstance().generateSADepartamento().calcularNomina(1);
		Float num = (float) 5513.75;
		assertEquals(id_1, num);
		Float id_2 = FactoriaSA.getInstance().generateSADepartamento().calcularNomina(2);
		Float num2 = (float)0;
		assertEquals(id_2, num2);
		Float id_3 = FactoriaSA.getInstance().generateSADepartamento().calcularNomina(9999);
		Float num3 = (float)-81;
		assertEquals(id_3, num3);
	}
	
}
