package Test_JPA;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import Clases.Negocio.FactoriaSA;
import Clases.Negocio.Empresa.Empresa;
import Clases.Negocio.Empresa.TEmpresa;
import Clases.Negocio.Trabajador.TTrabajador;
import Clases.Negocio.Curso.TCurso;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

@TestMethodOrder(OrderAnnotation.class)
public class Curso_Test_Negocio {	
	static int _id_curso;
	static int _id_empresa;
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
	void test_crearCurso() {
		TEmpresa empresa = new TEmpresa("sector1",true,"38522042D","Empresa_PruebaCURSO_Test","Madrid",(long) 917724576,"pruebas_trbajador_dpto@ucm.es");
		int id_empresa = FactoriaSA.getInstance().generateSAEmpresa().altaEmpresa(empresa);
		TCurso curso  = new TCurso("Curso_Test1",true,"tipo1","Descripcion1",10, 2,id_empresa); // bien
		int id_curso = FactoriaSA.getInstance().generateSACurso().altaCurso(curso);
		TCurso curso2  = new TCurso("Curso_Test1",true,"tipo1","Descripcion1",10, 2,id_empresa); // mal
		int id_curso2 = FactoriaSA.getInstance().generateSACurso().altaCurso(curso2);
		
	
		
		//nombre repetido para el segundo -101
		assertEquals(id_curso2,-101);

		//horas mal 104 
		curso.setHoras(-99999);
		id_curso = FactoriaSA.getInstance().generateSACurso().altaCurso(curso);
		assertEquals(id_curso,-104);
		curso.setHoras(20);
		
		//nivel mal -105
		curso.setNivel(-99999);
		id_curso = FactoriaSA.getInstance().generateSACurso().altaCurso(curso);
		assertEquals(id_curso,-105);
		curso.setNivel(3);
		
		//empresa no existe -74
		curso.setIdEmpresa(99999);
		id_curso = FactoriaSA.getInstance().generateSACurso().altaCurso(curso);
		assertEquals(id_curso,-74);
		curso.setIdEmpresa(id_empresa);
		
		// se crea bien el primer curso
		curso.setNombre("Curso_test_final");
		id_curso = FactoriaSA.getInstance().generateSACurso().altaCurso(curso);
		assertTrue(id_curso > 0);
		_id_curso=id_curso;
		_id_empresa=id_empresa;
	}
	@Test
	@Order(2)
	public void test_bajaCurso() {
		//no existe el curso
		int id_baja = FactoriaSA.getInstance().generateSACurso().bajaCurso(999);
		assertEquals(id_baja,-100);
		id_baja = FactoriaSA.getInstance().generateSACurso().bajaCurso(_id_curso);
		assertEquals(id_baja,_id_curso);
		
		// curso ya dado de baja
		id_baja = FactoriaSA.getInstance().generateSACurso().bajaCurso(_id_curso);
		assertEquals(id_baja,-102);
		
	}
	@Test
	@Order(3)
	public void test_MostrarCurso() {
		TCurso indefinido = FactoriaSA.getInstance().generateSACurso().mostrarCurso(_id_curso);
		assertEquals(indefinido.isActivo(),false);
		assertTrue(indefinido.getId() > 0 );
	}
	@Test
	@Order(4)
	public void test_MostrarCursos() {
		List<TCurso> cursos = FactoriaSA.getInstance().generateSACurso().listarCursos();
		
		for(int i = 0; i < cursos.size();i++) {
			assertTrue(cursos.get(i).getId()>0);
		}
	}
	@Test
	@Order(5)
	public void test_MostrarTrabajadores() {
		List<TTrabajador> trabajadores = FactoriaSA.getInstance().generateSACurso().listarTrabajadoresCurso(_id_curso);
		for(int i = 0; i < trabajadores.size();i++) {
			assertTrue(trabajadores.get(i).getId()>0);
		}
	}
	@Test
	@Order(6)
	public void test_UpdateCurso() {
	    

	    //vamos a dar de alta el curso indefinido
	    TCurso indefinido = FactoriaSA.getInstance().generateSACurso().mostrarCurso(_id_curso);
	    
	    //empresa no existe 100
	    indefinido.setIdEmpresa(-99);
	    int id_Update_CursoIndefinido = FactoriaSA.getInstance().generateSACurso().actualizarCurso(indefinido);
	    assertEquals(id_Update_CursoIndefinido,-74);
	    indefinido.setIdEmpresa(_id_empresa);
	    
	    //horas mal
	    int horas = indefinido.getHoras();
	    indefinido.setHoras(-99);
	    id_Update_CursoIndefinido = FactoriaSA.getInstance().generateSACurso().actualizarCurso(indefinido);
	    assertEquals(id_Update_CursoIndefinido,-104);
	    indefinido.setHoras(horas);
	    
	    // nivel mal
	    int nivel = indefinido.getNivel();
	    indefinido.setNivel(-6);
	    id_Update_CursoIndefinido = FactoriaSA.getInstance().generateSACurso().actualizarCurso(indefinido);
	    assertEquals(id_Update_CursoIndefinido,-105);
	    indefinido.setNivel(6);


	    //nombre repetido
	    TCurso curso2  = new TCurso("Curso_Test2",true,"tipo2","Descripcion2",10, 2,_id_empresa); // bien
	    int id_curso2 = FactoriaSA.getInstance().generateSACurso().altaCurso(curso2);
	    indefinido.setNombre("Curso_Test2");
	    id_Update_CursoIndefinido = FactoriaSA.getInstance().generateSACurso().actualizarCurso(indefinido);
	    assertEquals(id_Update_CursoIndefinido,-101);
	    indefinido.setNombre("Curso_Test");
	    
	    //actualizamos bien 
	    indefinido.setDescripcion("NuevaDescripcion");
	    id_Update_CursoIndefinido = FactoriaSA.getInstance().generateSACurso().actualizarCurso(indefinido);
	    System.out.println(id_Update_CursoIndefinido ); 
	    assertTrue( id_Update_CursoIndefinido> 0);

	  }
}
