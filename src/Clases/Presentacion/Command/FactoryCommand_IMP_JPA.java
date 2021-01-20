package Clases.Presentación.Command;

import Clases.Presentación.Command.cmCurso.cmAltaCurso;
import Clases.Presentación.Command.cmCurso.cmBajaCurso;
import Clases.Presentación.Command.cmCurso.cmMostrarCurso;
import Clases.Presentación.Command.cmCurso.cmMostrarCursos;
import Clases.Presentación.Command.cmCurso.cmMostrarTrabajadoresCurso;
import Clases.Presentación.Command.cmCurso.cmUpdateCurso;
import Clases.Presentación.Command.cmDepartamento.cmAltaDepartamento;
import Clases.Presentación.Command.cmDepartamento.cmBajaDepartamento;
import Clases.Presentación.Command.cmDepartamento.cmMostrarDepartamento;
import Clases.Presentación.Command.cmDepartamento.cmMostrarDepartamentos;
import Clases.Presentación.Command.cmDepartamento.cmMostrarTrabajadoresDepartamento;
import Clases.Presentación.Command.cmDepartamento.cmNominaDepartamento;
import Clases.Presentación.Command.cmDepartamento.cmUpdateDepartamento;
import Clases.Presentación.Command.cmEmpresa.cmAltaEmpresa;
import Clases.Presentación.Command.cmEmpresa.cmBajaEmpresa;
import Clases.Presentación.Command.cmEmpresa.cmMostrarCursosEmpresa;
import Clases.Presentación.Command.cmEmpresa.cmMostrarEmpresa;
import Clases.Presentación.Command.cmEmpresa.cmMostrarEmpresas;
import Clases.Presentación.Command.cmEmpresa.cmUpdateEmpresa;
import Clases.Presentación.Command.cmTrabajador.cmAltaTrabajador;
import Clases.Presentación.Command.cmTrabajador.cmAsignarCurso;
import Clases.Presentación.Command.cmTrabajador.cmBajaTrabajador;
import Clases.Presentación.Command.cmTrabajador.cmDesvincularCurso;
import Clases.Presentación.Command.cmTrabajador.cmModificarTrabajador;
import Clases.Presentación.Command.cmTrabajador.cmMostarCursosTrabajador;
import Clases.Presentación.Command.cmTrabajador.cmMostrarTrabajador;
import Clases.Presentación.Command.cmTrabajador.cmMostrarTrabajadores;

public class FactoryCommand_IMP_JPA extends FactoryCommandIMP{

	@Override
	public Command generateCommand(int event) {
		switch (event) {
		//EMPRESA
		case Events.MODIFICA_EMPRESA:
			return new cmUpdateEmpresa();
		case Events.ALTA_EMPRESA:
			return new cmAltaEmpresa();
		case Events.BAJA_EMPRESA:
			return new cmBajaEmpresa();
		case Events.MOSTRAR_EMPRESA:
			return new cmMostrarEmpresa();
		case Events.MOSTRAR_EMPRESAS:
			return new cmMostrarEmpresas();
		case Events.MOSTRAR_CURSOS_EMPRESA:
			return new cmMostrarCursosEmpresa();
		
		//DEPARTAMENTO
		case Events.ALTA_DEPARTAMENTO:
			return new cmAltaDepartamento();
		case Events.MOSTRAR_DEPARTAMENTO:
			return new cmMostrarDepartamento();
		case Events.MOSTRAR_DEPARTAMENTOS:
			return new cmMostrarDepartamentos();
		case Events.BAJA_DEPARTAMENTO:
			return new cmBajaDepartamento();
		case Events.MODIFICA_DEPARTAMENTO:
			return new cmUpdateDepartamento();
		case Events.MOSTRAR_TRABAJADORES_DEPARTAMENTO:
			return new cmMostrarTrabajadoresDepartamento();
		case Events.MOSTRAR_SUELDO_DEPARTAMENTO:
			return new cmNominaDepartamento();
			
		//CURSO	
		case Events.ALTA_CURSO:
			return new cmAltaCurso();
		case Events.MOSTRAR_CURSO:
			return new cmMostrarCurso();
		case Events.MOSTRAR_CURSOS:
			return new cmMostrarCursos();
		case Events.BAJA_CURSO:
			return new cmBajaCurso();
		case Events.MODIFICA_CURSO:
			return new cmUpdateCurso();
		case Events.MOSTRAR_TRABAJADORES_CURSO:
			return new cmMostrarTrabajadoresCurso();
			
		//TRABAJADOR
		case Events.ALTA_TRABAJADOR:
			return new cmAltaTrabajador();
		case Events.BAJA_TRABAJADOR:
			return new cmBajaTrabajador();
		case Events.MOSTRAR_TRABAJADOR:
			return new cmMostrarTrabajador();
		case Events.MODIFICA_TRABAJADOR:
			return new cmModificarTrabajador();
		case Events.MODIFICA_TRABAJADOR_I:
			return new cmModificarTrabajador(); 
		case Events.MODIFICA_TRABAJADOR_T:
			return new cmModificarTrabajador(); 
		case Events.ASIGNAR_CURSO:
			return new cmAsignarCurso();
		case Events.DESVINCULAR_CURSO:
			return new cmDesvincularCurso();
		case Events.MOSTRAR_TRABAJADORES:
			return new cmMostrarTrabajadores();
		case Events.MOSTRAR_CURSOS_TRABAJADOR:
			return new cmMostarCursosTrabajador();
			
		
		}
		//en caso de no ser JPA llamo a super 
		return super.generateCommand(event);
	}
	
	
}
