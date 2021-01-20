package Clases.Presentaci�n.Command;

import Clases.Presentaci�n.Command.cmCurso.cmAltaCurso;
import Clases.Presentaci�n.Command.cmCurso.cmBajaCurso;
import Clases.Presentaci�n.Command.cmCurso.cmMostrarCurso;
import Clases.Presentaci�n.Command.cmCurso.cmMostrarCursos;
import Clases.Presentaci�n.Command.cmCurso.cmMostrarTrabajadoresCurso;
import Clases.Presentaci�n.Command.cmCurso.cmUpdateCurso;
import Clases.Presentaci�n.Command.cmDepartamento.cmAltaDepartamento;
import Clases.Presentaci�n.Command.cmDepartamento.cmBajaDepartamento;
import Clases.Presentaci�n.Command.cmDepartamento.cmMostrarDepartamento;
import Clases.Presentaci�n.Command.cmDepartamento.cmMostrarDepartamentos;
import Clases.Presentaci�n.Command.cmDepartamento.cmMostrarTrabajadoresDepartamento;
import Clases.Presentaci�n.Command.cmDepartamento.cmNominaDepartamento;
import Clases.Presentaci�n.Command.cmDepartamento.cmUpdateDepartamento;
import Clases.Presentaci�n.Command.cmEmpresa.cmAltaEmpresa;
import Clases.Presentaci�n.Command.cmEmpresa.cmBajaEmpresa;
import Clases.Presentaci�n.Command.cmEmpresa.cmMostrarCursosEmpresa;
import Clases.Presentaci�n.Command.cmEmpresa.cmMostrarEmpresa;
import Clases.Presentaci�n.Command.cmEmpresa.cmMostrarEmpresas;
import Clases.Presentaci�n.Command.cmEmpresa.cmUpdateEmpresa;
import Clases.Presentaci�n.Command.cmTrabajador.cmAltaTrabajador;
import Clases.Presentaci�n.Command.cmTrabajador.cmAsignarCurso;
import Clases.Presentaci�n.Command.cmTrabajador.cmBajaTrabajador;
import Clases.Presentaci�n.Command.cmTrabajador.cmDesvincularCurso;
import Clases.Presentaci�n.Command.cmTrabajador.cmModificarTrabajador;
import Clases.Presentaci�n.Command.cmTrabajador.cmMostarCursosTrabajador;
import Clases.Presentaci�n.Command.cmTrabajador.cmMostrarTrabajador;
import Clases.Presentaci�n.Command.cmTrabajador.cmMostrarTrabajadores;

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
