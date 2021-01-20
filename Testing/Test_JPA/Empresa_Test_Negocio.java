package Test_JPA;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import Clases.Negocio.FactoriaSA;
import Clases.Negocio.Curso.TCurso;
import Clases.Negocio.Empresa.TEmpresa;


@TestMethodOrder(OrderAnnotation.class)
public class Empresa_Test_Negocio {
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
	void test_createEmpresa() {	
		// supungo que partimos de bbdd vacia:
		TEmpresa empresa1 = new TEmpresa("Mercantil", true, "46111028F", "Sause SA", "c/ rosario", (long) 922234451, "sausesacom");
		int id_1=FactoriaSA.getInstance().generateSAEmpresa().altaEmpresa(empresa1);
		assertTrue(id_1 == -71); // correo mal 
		TEmpresa empresa2 = new TEmpresa("Mercantil", true, "11028F", "Sause SA", "c/ rosario", (long) 922234451, "sausesa@gmail.com");
		int id_2=FactoriaSA.getInstance().generateSAEmpresa().altaEmpresa(empresa2);
		assertTrue(id_2 == -72); // cif mal
		TEmpresa empresa3 = new TEmpresa("Mercantil", true, "46111028F", "Sause SA", "c/ rosario", (long) 922, "sausesa@gmail.com");
		int id_3=FactoriaSA.getInstance().generateSAEmpresa().altaEmpresa(empresa3);
		assertTrue(id_3 == -73); // telf mal
		TEmpresa empresa4 = new TEmpresa("Mercantil", true, "46111028F", "Sause SA", "c/ rosario", (long) 922234451, "sausesa@gmail.com");
		int id_4=FactoriaSA.getInstance().generateSAEmpresa().altaEmpresa(empresa4);
		assertTrue(id_4 == 1); // idcorrecta
		int id_5=FactoriaSA.getInstance().generateSAEmpresa().altaEmpresa(empresa4);
		assertTrue(id_5 == -75); // cif repetido y activo;
		TEmpresa empresa4_desactivada = new TEmpresa("Mercantil", false,1, "46111028F", "Sause SA", "c/ rosario", (long) 922234451, "sausesa@gmail.com");
		int id_desactivada=FactoriaSA.getInstance().generateSAEmpresa().actualizarEmpresa(empresa4_desactivada);
		assertTrue(id_desactivada == 1); // Asumo que modificar está bien.
		int id_reactivacion=FactoriaSA.getInstance().generateSAEmpresa().altaEmpresa(empresa4); // empresa 4 está activada
		assertTrue(id_reactivacion==1);
		TEmpresa empresa6 = new TEmpresa("Textil", true, "98492521N", "Juancarlos SA", "c/ benito", (long) 922242451, "sausesa@gmail.com");
		int id_6=FactoriaSA.getInstance().generateSAEmpresa().altaEmpresa(empresa6); // empresa desactivada
		assertTrue(id_6 == 2); //idcorrecta
		TEmpresa empresa7 = new TEmpresa("Alimentacion", true, "12490427R", "LAVIN PUENTE SA", "c/ complu", (long) 922244451, "sausesa@gmail.com");
		int id_7=FactoriaSA.getInstance().generateSAEmpresa().altaEmpresa(empresa7); // empresa activada
		assertTrue(id_7 == 3); //idcorrecta
	}
	@Test
	@Order(2) 
	void test_deleteEmpresa() {	
		TCurso curso = new TCurso("prevension accidentes", true, "riesgos laborales", "curso que forma a los empleados para que no se maten", 160, 2, 3);
		FactoriaSA.getInstance().generateSACurso().altaCurso(curso); // La empresa 3 tiene un curso.
		int id_bajanoexiste=FactoriaSA.getInstance().generateSAEmpresa().bajaEmpresa(9999);
		assertTrue(id_bajanoexiste==-74);
		int id_bajanormal=FactoriaSA.getInstance().generateSAEmpresa().bajaEmpresa(1);
		assertTrue(id_bajanormal==1);
		int id_baja=FactoriaSA.getInstance().generateSAEmpresa().bajaEmpresa(1);
		assertTrue(id_baja==-76); // empresa already bajada
		int id_bajaconcurso=FactoriaSA.getInstance().generateSAEmpresa().bajaEmpresa(3);
		assertTrue(id_bajaconcurso==-77); // empresa con curso asociado
		
	}
	@Test
	@Order(3) 
	void test_mostrarEmpresa() {	
		TEmpresa empresa1 = new TEmpresa("Mercantil", false, 1, "46111028F", "Sause SA", "c/ rosario", (long) 922234451, "sausesa@gmail.com");
		TEmpresa empresa_nula =FactoriaSA.getInstance().generateSAEmpresa().mostrarEmpresa(999);
		assertEquals(empresa_nula,null);
		TEmpresa recibida= FactoriaSA.getInstance().generateSAEmpresa().mostrarEmpresa(1);
		assertEquals(empresa1.getCif(),recibida.getCif());
		assertEquals(empresa1.getCorreo(),recibida.getCorreo());
		assertEquals(empresa1.getDireccion(),recibida.getDireccion());
		assertEquals(empresa1.getTelefono(),recibida.getTelefono());
		assertEquals(empresa1.getNombre(),recibida.getNombre());
		assertEquals(empresa1.getId(),recibida.getId());
		assertEquals(empresa1.isActivo(),recibida.isActivo());
	}
	@Test
	@Order(4) 
	void test_mostrarCursosEmpresa() {	
		List<TCurso> cursos = FactoriaSA.getInstance().generateSAEmpresa().mostrarCursosEmpresa(2);
		assertTrue(cursos.isEmpty()); // la empresa 2 no tiene cursos
		TCurso curso = new TCurso("prevencion accidentes", true, "riesgos laborales", "curso que forma a los empleados para que no se maten", 160, 2, 2);
		FactoriaSA.getInstance().generateSACurso().altaCurso(curso); // La empresa 2 tiene un curso.
		TCurso curso2 = new TCurso("manipulador de alimentos", true, "lavate las manos", "curso que forma a los empleados para que no se intoxiquen", 160, 2, 2);
		FactoriaSA.getInstance().generateSACurso().altaCurso(curso2); // La empresa 2 tiene otro curso.
		List<TCurso> cursos2 = FactoriaSA.getInstance().generateSAEmpresa().mostrarCursosEmpresa(2);
		assertTrue(cursos2.size()==2); // La empresa 2 tiene dos cursos.
	
	}
	@Test
	@Order(5) 
	void test_listarEmpresas() {
		List <TEmpresa> listaEmpresas = FactoriaSA.getInstance().generateSAEmpresa().listarEmpresas();
		assertTrue(listaEmpresas.size() > 0);
	}
	
	@Test
	@Order(6) 
	void test_actualizarEmpresa() {
		TEmpresa empresa1 = new TEmpresa("Mercantil", true, 1, "46111028F", "Sause SA", "c/ rosario", (long) 922234451, "sausesa@gmail.com");
		int id_1 = FactoriaSA.getInstance().generateSAEmpresa().actualizarEmpresa(empresa1);
		assertTrue(id_1 == 1); // actualizar correcto
		TEmpresa empresa2 = new TEmpresa("Mercantil", true, 1, "46111028F", "Sause SA", "c/ rosario", (long) 922234451, "sausesasdom");
		int id_2 = FactoriaSA.getInstance().generateSAEmpresa().actualizarEmpresa(empresa2);
		assertTrue(id_2 == -71); // correo no valido
		TEmpresa empresa3 = new TEmpresa("Mercantil", true, 1, "46111028L", "Sause SA", "c/ rosario", (long) 922234451, "sausesa@gmail.com");
		int id_3 = FactoriaSA.getInstance().generateSAEmpresa().actualizarEmpresa(empresa3);
		assertTrue(id_3 == -72); // cif no valido
		TEmpresa empresa4 = new TEmpresa("Mercantil", true, 1, "46111028F", "Sause SA", "c/ rosario", (long) 234451, "sausesa@gmail.com");
		int id_4 = FactoriaSA.getInstance().generateSAEmpresa().actualizarEmpresa(empresa4);
		assertTrue(id_4 == -73); // telefono no valido
		TEmpresa empresa5 = new TEmpresa("Mercantil", true, 999, "46111028F", "Sause SA", "c/ rosario", (long) 922234451, "sausesa@gmail.com");
		int id_5 = FactoriaSA.getInstance().generateSAEmpresa().actualizarEmpresa(empresa5);
		assertTrue(id_5 == -74); // id no existe
		TEmpresa empresa6 = new TEmpresa("Mercantil", true, 2, "46111028F", "Sause SA", "c/ rosario", (long) 922234451, "sausesa@gmail.com");
		int id_6 = FactoriaSA.getInstance().generateSAEmpresa().actualizarEmpresa(empresa6);
		assertTrue(id_6 == -75); // cif repetido
		TEmpresa empresa7 = new TEmpresa("Textil", false, 2, "98492521N", "Juancarlos SA", "c/ benito", (long) 922242451, "sausesa@gmail.com");
		int id_7 = FactoriaSA.getInstance().generateSAEmpresa().actualizarEmpresa(empresa7);
		assertTrue(id_7 == -77); // la empresa no se puede dar de baja con curso asociado
	}
}
