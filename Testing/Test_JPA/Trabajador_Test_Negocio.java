package Test_JPA;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

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

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

@TestMethodOrder(OrderAnnotation.class)
public class Trabajador_Test_Negocio {

	static int _id_TrabajadorTemporal; 
	static int _id_TrabajadorIndefinido;
	static TIndefinido trabajadorIndefinido;
	
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
	void test_crearTrabajador() {
		/*
		 * 
		 * 1 - creamos 1 departamento
		 * 2 - creamos 1 trabajador indefinido y otro temporal
		 * 2.1 fallos: 
		 * 		
		 * 		- DNI mal
		 * 		- correo mal
		 * 		- Departamento mal
		 * 		- Una vez insertamos un trabajador comprobamos que el otro --> DNI repetido
		 * */
		TDepartamento departamento = new TDepartamento("Departamento_PruebaTrabajador_Test",true,"pruebas_trbajador_dpto@ucm.es","Madrid",987654321L);
		int id_Departamento = FactoriaSA.getInstance().generateSADepartamento().altaDepartamento(departamento);
		
		TTemporal trabajadorTemporal  = new TTemporal("98492521N","Trabajador_Temporal_Test",123456789L,"Calle JUNIT", new Date(Calendar.getInstance().getTimeInMillis()),"temporal",true,id_Departamento,new Date(Calendar.getInstance().getTimeInMillis()),(float) 8.25,35);
		int id_TrabajadorTemporal = FactoriaSA.getInstance().generateSATrabajador().altaTrabajador(trabajadorTemporal);
		//el correo mal
		assertEquals(id_TrabajadorTemporal,-98);
		
		//correo actualizado
		trabajadorTemporal.setCorreo("trabajador_test_Temp@ucm.es");
		//departamento mal
		trabajadorTemporal.setIdDepartamento(9999);
		id_TrabajadorTemporal = FactoriaSA.getInstance().generateSATrabajador().altaTrabajador(trabajadorTemporal);
		assertEquals(id_TrabajadorTemporal,-81);
		
		trabajadorTemporal.setIdDepartamento(id_Departamento);
		
		//dni mal
		trabajadorTemporal.setDNI("98492521J");
		id_TrabajadorTemporal = FactoriaSA.getInstance().generateSATrabajador().altaTrabajador(trabajadorTemporal);
		assertEquals(id_TrabajadorTemporal,-97);
		
		
		trabajadorTemporal.setDNI("98492521N");
		
		id_TrabajadorTemporal = FactoriaSA.getInstance().generateSATrabajador().altaTrabajador(trabajadorTemporal);
		assertTrue(id_TrabajadorTemporal > 0);
		trabajadorIndefinido  = new TIndefinido("98492521N","Trabajador_Indefinido_Test",123456789L,"Calle JUNIT", new Date(Calendar.getInstance().getTimeInMillis()),"indefinido@test.com",true,id_Departamento,(float) 1850.75,(float)125.25);
		
		int id_TrabajadorIndefinido = FactoriaSA.getInstance().generateSATrabajador().altaTrabajador(trabajadorIndefinido);
		
		assertEquals(id_TrabajadorIndefinido,-90);
		
		trabajadorIndefinido.setDNI("76815995C");
		id_TrabajadorIndefinido = FactoriaSA.getInstance().generateSATrabajador().altaTrabajador(trabajadorIndefinido);
		assertTrue(id_TrabajadorIndefinido > 0);
		
		_id_TrabajadorIndefinido = id_TrabajadorIndefinido;
		_id_TrabajadorTemporal = id_TrabajadorTemporal;
	}
	@Test
	@Order(2)
	public void test_bajaTrabajador() {
		//no existe
		int id_baja = FactoriaSA.getInstance().generateSATrabajador().bajaTrabajador(999);
		assertEquals(id_baja,-91);
		id_baja = FactoriaSA.getInstance().generateSATrabajador().bajaTrabajador(_id_TrabajadorIndefinido);
		assertEquals(id_baja,_id_TrabajadorIndefinido);
		
		id_baja = FactoriaSA.getInstance().generateSATrabajador().bajaTrabajador(_id_TrabajadorIndefinido);
		assertEquals(id_baja,-92);
		
	}
	@Test
	@Order(3)
	public void test_MostrarTrabajador() {
		TTrabajador indefinido = FactoriaSA.getInstance().generateSATrabajador().mostrarTrabajador(_id_TrabajadorIndefinido);
		assertEquals(indefinido.isActivo(),false);
		assertTrue(indefinido.getId() > 0 );
		
		TTrabajador indefinido1 = FactoriaSA.getInstance().generateSATrabajador().mostrarTrabajador(999);
		assertEquals(indefinido1,null);
	}
	@Test
	@Order(4)
	public void test_MostrarTrabajadores() {
		List<TTrabajador> trabajadores = FactoriaSA.getInstance().generateSATrabajador().listarTrabajadores();
		
		for(int i = 0; i < trabajadores.size();i++) {
			assertTrue(trabajadores.get(i).getId()>0);
		}
	}
	@Test
	@Order(5)
	public void test_UpdateTrabajadores() {
		//vamos a dar de alta al trabajador indefinido
		TTrabajador indefinido = FactoriaSA.getInstance().generateSATrabajador().mostrarTrabajador(_id_TrabajadorIndefinido);
		
		//correo malo
		indefinido.setCorreo("correoMalo");
		int id_Update_TrabajadorIndefinido = FactoriaSA.getInstance().generateSATrabajador().actualizarTrabajador(indefinido);
		assertEquals(id_Update_TrabajadorIndefinido,-98);
		
		indefinido.setCorreo("tIndefinido@testUpdate.com");
		
		int dptoBueno = indefinido.getIdDepartamento();
		//departamento malo
		indefinido.setIdDepartamento(9999);
		id_Update_TrabajadorIndefinido = FactoriaSA.getInstance().generateSATrabajador().actualizarTrabajador(indefinido);
		assertEquals(id_Update_TrabajadorIndefinido,-81);
		indefinido.setIdDepartamento(dptoBueno);
		
		//dni mal
		String DNI = indefinido.getDNI();
		indefinido.setDNI("98492521J");
		id_Update_TrabajadorIndefinido = FactoriaSA.getInstance().generateSATrabajador().altaTrabajador(indefinido);
		assertEquals(id_Update_TrabajadorIndefinido,-97);


		//dni repetido
		indefinido.setDNI("98492521N");
		id_Update_TrabajadorIndefinido = FactoriaSA.getInstance().generateSATrabajador().actualizarTrabajador(indefinido);
		assertEquals(id_Update_TrabajadorIndefinido,-90);
		
		indefinido.setDNI(DNI);
		//modificacion buena le ponemos activo
		indefinido.setActivo(true);
		id_Update_TrabajadorIndefinido = FactoriaSA.getInstance().generateSATrabajador().altaTrabajador(indefinido);
		assertTrue(id_Update_TrabajadorIndefinido > 0);
	}
	@Test
	@Order(6)
	//hacemos el test de asignar y desvincular curso a un trabajador juntos
	public void test_Asignar_Desvinular_CursoTrabajador() {
		//curso==null && trabajador!=null
		int id_trabajador_curso_null = FactoriaSA.getInstance().generateSATrabajador().asignarCurso(999,_id_TrabajadorIndefinido,new Date(Calendar.getInstance().getTimeInMillis()),new Date(Calendar.getInstance().getTimeInMillis()));
		assertEquals(id_trabajador_curso_null,-95);
		
		//trabajador==null && curso!=null
		TEmpresa empresa = new TEmpresa("sector_prueba",true,"66610824H","preuba_empresa_1","prueba_empresa_1_direccion",123456789L,"pruebas_empresa_1@ucm.es");
		int id_Empresa = FactoriaSA.getInstance().generateSAEmpresa().altaEmpresa(empresa);
		TCurso curso = new TCurso("Curso_prueba_Test",true,"tipo_prueba","pruebas_curso",30,2,id_Empresa);
		int id_curso = FactoriaSA.getInstance().generateSACurso().altaCurso(curso);
		int id_trabajador_trabjador_null = FactoriaSA.getInstance().generateSATrabajador().asignarCurso(id_curso,999,new Date(Calendar.getInstance().getTimeInMillis()),new Date(Calendar.getInstance().getTimeInMillis()));
		assertEquals(id_trabajador_trabjador_null,-95);
		
		//curso no está activo
		id_curso = FactoriaSA.getInstance().generateSACurso().bajaCurso(id_curso);
		int id_trabajador_no_activo_curso = FactoriaSA.getInstance().generateSATrabajador().asignarCurso(id_curso,_id_TrabajadorIndefinido,new Date(Calendar.getInstance().getTimeInMillis()),new Date(Calendar.getInstance().getTimeInMillis()));
		assertEquals(id_trabajador_no_activo_curso,-94);
		id_curso = FactoriaSA.getInstance().generateSACurso().altaCurso(curso);
		
		//trabajador no está activo
		_id_TrabajadorIndefinido = FactoriaSA.getInstance().generateSATrabajador().bajaTrabajador(_id_TrabajadorIndefinido);
		int id_trabajador_no_activo_trabajador = FactoriaSA.getInstance().generateSATrabajador().asignarCurso(id_curso,_id_TrabajadorIndefinido,new Date(Calendar.getInstance().getTimeInMillis()),new Date(Calendar.getInstance().getTimeInMillis()));
		assertEquals(id_trabajador_no_activo_trabajador,-94);
		_id_TrabajadorIndefinido = FactoriaSA.getInstance().generateSATrabajador().altaTrabajador(trabajadorIndefinido);
		
		//hacemos uno bueno
		int id_trabajador_bueno = FactoriaSA.getInstance().generateSATrabajador().asignarCurso(id_curso,_id_TrabajadorIndefinido,new Date(Calendar.getInstance().getTimeInMillis()),new Date(Calendar.getInstance().getTimeInMillis()));
		assertTrue(id_trabajador_bueno>0);
		
		//el trabajador ya tiene el curso asignado
		int id_trabajador_repetido = FactoriaSA.getInstance().generateSATrabajador().asignarCurso(id_curso,_id_TrabajadorIndefinido,new Date(Calendar.getInstance().getTimeInMillis()),new Date(Calendar.getInstance().getTimeInMillis()));
		assertEquals(id_trabajador_repetido,-93);
		
		//desvinculamos el curso del trabajador correctamente
		int id_trabajador_desvinculado = FactoriaSA.getInstance().generateSATrabajador().desvincularCurso(id_curso,_id_TrabajadorIndefinido);
		assertTrue(id_trabajador_desvinculado>0);
		
		//desvinculamos el mismo curso de nuevo
		int id_trabajador_desvinculado_repetido = FactoriaSA.getInstance().generateSATrabajador().desvincularCurso(id_curso,_id_TrabajadorIndefinido);
		assertEquals(id_trabajador_desvinculado_repetido,-96);
		
	}
	@Test
	@Order(7)
	public void test_MostrarCursosTrabajador() {
		List<TCurso> cursos = FactoriaSA.getInstance().generateSATrabajador().mostrarCursosTrabajador(_id_TrabajadorIndefinido);
		//cursos si es null no existe el trabajador
		assertNotNull(cursos);
		for(int i = 0; i < cursos.size();i++) {
			assertTrue(cursos.get(i).getId()>0);
		}
	}
	
}
