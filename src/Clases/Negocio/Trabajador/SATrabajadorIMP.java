/**
 * 
 */
package Clases.Negocio.Trabajador;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import Clases.Negocio.FormatoSA;
import Clases.Negocio.Curso.Curso;
import Clases.Negocio.Curso.TCurso;
import Clases.Negocio.CursoTrabajador.CursoTrabajador;
import Clases.Negocio.CursoTrabajador.CursoTrabajadorID;
import Clases.Negocio.CursoTrabajador.TCursoTrabajador;
import Clases.Negocio.Departamento.Departamento;
import Clases.Negocio.Departamento.TDepartamento;
import Clases.Negocio.EntityManagerFactory.EMFactory;


/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Mario, Javier, Yule, David, Alberto, Iker, Fernando, Francisco
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class SATrabajadorIMP implements SATrabajador {

	/** 
	* (non-Javadoc)
	* @see SATrabajador#altaTrabajador(TTrabajador trabajador)
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	
	public int comprobaciones(TTrabajador t) {
		FormatoSA fsa = new FormatoSA();
		int d = fsa.formatoTTrabajadorCorrecto(t);
		return d;
	}
	public Integer altaTrabajador(TTrabajador trabajador) {
		// begin-user-code
		// TODO Auto-generated method stub
		int id = -1;
		id = comprobaciones(trabajador);
		if(id==1) {
			try {
				EntityManagerFactory emf =  EMFactory.getInstance().getFactory();
				EntityManager em = emf.createEntityManager();
				em.getTransaction().begin();
				Departamento d = em.find(Departamento.class,trabajador.getIdDepartamento());
				if (d!=null && d.isActivo()) {
					em.lock(d, LockModeType.OPTIMISTIC_FORCE_INCREMENT); //voy a insertar un trabajador en el departamento por lo que bloqueo con incremento forzado
					TypedQuery<Trabajador> query = em.createNamedQuery("Clases.Negocio.Trabajador.Trabajador.findByDNI", Trabajador.class).setParameter("DNI",trabajador.getDNI());
					List<Trabajador> result = query.getResultList();
					if(result.isEmpty()) {
						Trabajador t;
						if(trabajador.getClass().equals(TIndefinido.class)) { //es indefinido
							t = new TrabajadorIndefinido((TIndefinido)trabajador, d);
							em.persist(t);
						}
						else { //es temporal
							t = new TrabajadorTemporal((TTemporal)trabajador, d);
							em.persist(t);
						}
						em.getTransaction().commit();
						id = t.getId();
					}
					else{ //existe un trabajador con ese dni
							
						Trabajador t= result.get(0);
						if(t.isActivo()){
							id= -90; //dni repetido y no reactivo
							em.getTransaction().rollback();
						}
						else{ //reactivo
							t.setActivo(true);
							em.getTransaction().commit();
						}
					}
				}
				
				else { //departamento no existe o no esta activo
					id = -81;
					em.getTransaction().rollback();
				}
				em.close();
			}
			catch(PersistenceException ex){
				return -999; // error desconocido
			}
		}
		return id;
		// end-user-code
	}

	/** 
	* (non-Javadoc)
	* @see SATrabajador#asignarCurso(Integer idCurso, Integer idTrabajador, Date inicio, java.sql.Date fin)
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public Integer asignarCurso(Integer idCurso, Integer idTrabajador, Date inicio, Date fin) {
		// begin-user-code
		// TODO Auto-generated method stub
		int id = -1;
		try {
			
			EntityManagerFactory emf =  EMFactory.getInstance().getFactory();
			EntityManager em = emf.createEntityManager();
				
			em.getTransaction().begin();
			Trabajador trabajador = em.find(Trabajador.class, idTrabajador);
			Curso curso = em.find(Curso.class, idCurso);
			
			if(trabajador != null && curso != null){
				if(trabajador.isActivo() && curso.isActivo()) {
					
					CursoTrabajador ct = new CursoTrabajador(trabajador, curso, inicio, fin);	
					CursoTrabajadorID cti = new CursoTrabajadorID(idTrabajador, idCurso);
					
					CursoTrabajador cursoTrabajador = em.find(CursoTrabajador.class, cti);
					
					if(cursoTrabajador != null) {
						id = -93; //el trabajador ya tiene el curso asignado
						em.getTransaction().rollback();
					}
					else {			
						em.lock(trabajador, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
						em.lock(curso, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
						em.persist(ct);
						em.getTransaction().commit();
						id = idTrabajador;
					}
				}
				else {
					id = -94;
					em.getTransaction().rollback();
				}
			}
			else {
				id = -95;
				em.getTransaction().rollback();
			}
			em.close();
		}
		catch(PersistenceException ex) {
			id = -999;
		}
	
		return id;
		// end-user-code
	}

	/** 
	* (non-Javadoc)
	* @see SATrabajador#desvincularCurso(Integer idCurso, Integer idTrabajador)
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public Integer desvincularCurso(Integer idCurso, Integer idTrabajador) {
		// begin-user-code
		// TODO Auto-generated method stub
		int id = -1;
		try {
			
			EntityManagerFactory emf =  EMFactory.getInstance().getFactory();
			EntityManager em = emf.createEntityManager();
				
			em.getTransaction().begin();
			Trabajador trabajador = em.find(Trabajador.class, idTrabajador);
			Curso curso = em.find(Curso.class, idCurso);
			
			if(trabajador != null && curso != null){
				if(trabajador.isActivo() && curso.isActivo()) {
					CursoTrabajadorID cti = new CursoTrabajadorID(idTrabajador, idCurso);
					CursoTrabajador cursoTrabajador = em.find(CursoTrabajador.class, cti);
					
					if(cursoTrabajador == null) {
						id = -96; //el trabajador no tiene el curso asignado
						em.getTransaction().rollback();
					}
					else {			
						em.lock(trabajador, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
						em.lock(curso, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
						em.remove(cursoTrabajador);
						em.getTransaction().commit();
						id = idTrabajador;
					}
				}
				else {
					id = -94;
					em.getTransaction().rollback();
				}
			}
			else {
				id = -95;
				em.getTransaction().rollback();
			}
			em.close();
		}
		catch(PersistenceException ex) {
			id = -999;
		}
	
		return id;
		// end-user-code
	}

	/** 
	* (non-Javadoc)
	* @see SATrabajador#bajaTrabajador(Integer idTrabajador, Integer id)
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public int bajaTrabajador(Integer idTrabajador) {
		int id = -1;
		try {
			
			EntityManagerFactory emf =  EMFactory.getInstance().getFactory();
			EntityManager em = emf.createEntityManager();
				
			em.getTransaction().begin();
			
			Trabajador trabajador = em.find(Trabajador.class, idTrabajador);
			if(trabajador != null)
			{
				if(trabajador.isActivo()) {
					/*busco si este trabajador esta asociado a un curso*/
					TypedQuery<CursoTrabajador> queryCursoTrabajador = em.createNamedQuery("Clases.Negocio.CursoTrabajador.CursoTrabajador.findBytrabajador", CursoTrabajador.class).setParameter("trabajador", trabajador);
					List<CursoTrabajador> listTrabajador = queryCursoTrabajador.getResultList();
					if(listTrabajador.size()>0) {
						for(int i = 0; i < listTrabajador.size();i++) {
							//esto hay serias dudas (???)
							em.remove(listTrabajador.get(i));
						}
					}
					Departamento dp = trabajador.getDepartamento();
					//habría aqui forzado con departamento (?)
					em.lock(dp, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
					trabajador.setActivo(false);
					id = trabajador.getId();
					em.persist(trabajador);
					em.getTransaction().commit();
					
				}
				else {
					id = -92;
					em.getTransaction().rollback();
					
				}
			}
			else {
				id = -91;
				em.getTransaction().rollback();
			}
			em.close();
		}
		catch(PersistenceException ex) {
			id = -999;
		}
		
		
		return id;
	}

	/** 
	* (non-Javadoc)
	* @see SATrabajador#mostrarTrabajador(Integer id)
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public TTrabajador mostrarTrabajador(Integer idTrabajador) {
		// begin-user-code
		// TODO Auto-generated method stub
		TTrabajador trabajador = null;
		try {
			EntityManagerFactory emf = EMFactory.getInstance().getFactory();
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Trabajador traobtenido=em.find(Trabajador.class,idTrabajador);
			
			if(traobtenido!=null) {	
				int id = traobtenido.getId();
				boolean activo = traobtenido.isActivo();
				String correo = traobtenido.getCorreo();
				String direccion = traobtenido.getDireccion();
				String dni = traobtenido.getDNI();
				Date fechaini = traobtenido.getFechainicio();
				String nombre = traobtenido.getNombre();
				Long telefono = traobtenido.getTelefono();
				Departamento departamento = traobtenido.getDepartamento();
				int idDepartamento = departamento.getId();
				
				if(traobtenido.getClass().equals(TrabajadorIndefinido.class)){
					Float complemento = ((TrabajadorIndefinido)traobtenido).getComplemento();
					Float nomina = ((TrabajadorIndefinido)traobtenido).getNomina();
					trabajador = new TIndefinido(dni, id, nombre, telefono, direccion, fechaini, correo, activo, 
							idDepartamento, nomina, complemento);
				}else {
					Float sueldoPH = ((TrabajadorTemporal) traobtenido).getSueldoPH();
					Date fechaFin = ((TrabajadorTemporal) traobtenido).getFechaFin();
					int horasM = ((TrabajadorTemporal) traobtenido).getHorasMensuales();
					trabajador = new TTemporal(dni, id, nombre, telefono, direccion, fechaini, correo, activo, idDepartamento, 
							fechaFin, sueldoPH, horasM);
				}
				em.getTransaction().commit();
			}
			else {
				em.getTransaction().rollback();
			}
			em.close();
		}
		catch(PersistenceException ex){
			System.out.println(ex);// error desconocido
		}
		
		return trabajador;
		// end-user-code
	}

	/** 
	* (non-Javadoc)
	* @see SATrabajador#actualizarTrabajador(TTrabajador trabajador)
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public Integer actualizarTrabajador(TTrabajador trabajador) {
		int id = -1;
		if(trabajador!=null) {
			id=comprobaciones(trabajador);
			if(id==1) {
				try {
					EntityManagerFactory emf = EMFactory.getInstance().getFactory();
					EntityManager em = emf.createEntityManager();
					em.getTransaction().begin();
					//System.out.print(trabajador.getId());
					Departamento d = em.find(Departamento.class,trabajador.getIdDepartamento(),LockModeType.OPTIMISTIC_FORCE_INCREMENT);
					if (d!=null && d.isActivo()) {
						
						Trabajador trabajadorObtenido = em.find(Trabajador.class, trabajador.getId());
						if(trabajadorObtenido != null) {
							TypedQuery<Trabajador> query = em.createNamedQuery("Clases.Negocio.Trabajador.Trabajador.findByDNI", Trabajador.class).setParameter("DNI", trabajador.getDNI());
							List<Trabajador> lista = query.getResultList();
							//si la lista está vacia es que el dni nuevo que le paso no está repetido.
							// si la lista no está vacia y entra por que está en la query, no he cambiado el dni y no está repe
							if(lista.isEmpty() || (lista.get(0).getId() == trabajador.getId() && lista.size()==1)) {
								trabajadorObtenido.setDNI(trabajador.getDNI());
								//porque da igual el dni que le haya pasado:
								//pq ya habré comprobado antes si el dni es valido (linea 94) TODO
								//pq ya me aseguro o que el dni es nuevo (lista vacia) o que no le voy a cambiar pq he buscado
								//por dni y me ha devuelto 1 elemento en la query.
								trabajadorObtenido.setFechainicio(trabajador.getFechainicio());
								trabajadorObtenido.setActivo(trabajador.isActivo());
								trabajadorObtenido.setCorreo(trabajador.getCorreo());
								trabajadorObtenido.setDireccion(trabajador.getDireccion());
								trabajadorObtenido.setNombre(trabajador.getNombre());
								trabajadorObtenido.setDepartamento(d);
								trabajadorObtenido.setTelefono(trabajador.getTelefono());
								if(trabajador.getClass().equals(TrabajadorIndefinido.class)){
									((TrabajadorIndefinido) trabajadorObtenido).setComplemento(((TIndefinido) trabajador).getComplemento());
									((TrabajadorIndefinido) trabajadorObtenido).setNomina(((TIndefinido) trabajador).getNomina());
								}else {
									((TrabajadorTemporal) trabajadorObtenido).setSueldoPH(((TTemporal) trabajador).getSueldoPH());
									((TrabajadorTemporal) trabajadorObtenido).setFechaFin(((TTemporal) trabajador).getFechaFin());
									((TrabajadorTemporal) trabajadorObtenido).setHorasMensuales(((TTemporal) trabajador).getHorasMensuales());
								}
								id= trabajadorObtenido.getId();
								em.getTransaction().commit();
							}
							else {
								id = -90;
								em.getTransaction().rollback();
							}
							
						}
						else {
							id = -91;
							em.getTransaction().rollback();
						}
						
					}
					
					else { //departamento no existe o no esta activo
						id = -81;
						em.getTransaction().rollback();
					}
					
					em.close();
					
				}
				catch(PersistenceException ex) {
					id = -999;
				}
			}
		}
		return id;
	}

	/** 
	* (non-Javadoc)
	* @see SATrabajador#listarTrabajadores()
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public List<TTrabajador> listarTrabajadores() {
		// begin-user-code
		// TODO Auto-generated method stub
		List<TTrabajador> trabajadores = new ArrayList<TTrabajador>();
		try {
			EntityManagerFactory emf = EMFactory.getInstance().getFactory();
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<Trabajador> query = em.createQuery("SELECT t FROM Trabajador t", Trabajador.class);			
			for(Trabajador t :query.getResultList()) {
				//for(Trabajador t : depobtenida.getTrabajadores()) {
					TTrabajador trabajador = null;
					int id = t.getId();
					boolean activo = t.isActivo();
					String correo = t.getCorreo();
					String direccion = t.getDireccion();
					String dni = t.getDNI();
					Date fechaini = t.getFechainicio();
					String nombre = t.getNombre();
					Long telefono = t.getTelefono();
					Departamento departamento = t.getDepartamento();
					//int id = depobtenida.getId();
					
					if(t.getClass().equals(TrabajadorIndefinido.class)){
						Float complemento = ((TrabajadorIndefinido)t).getComplemento();
						Float nomina = ((TrabajadorIndefinido)t).getNomina();
						trabajador = new TIndefinido(dni, id, nombre, telefono, direccion, fechaini, correo, activo, departamento.getId(), nomina, complemento);
						trabajadores.add(trabajador);
					}else {
						Float sueldoPH = ((TrabajadorTemporal) t).getSueldoPH();
						Date fechaFin = ((TrabajadorTemporal) t).getFechaFin();
						int horasM = ((TrabajadorTemporal) t).getHorasMensuales();
						trabajador = new TTemporal(dni, id, nombre, telefono, direccion, fechaini, correo, activo, departamento.getId(), 
								fechaFin, sueldoPH, horasM);
						trabajadores.add(trabajador);
					}
			}
			em.getTransaction().commit();
			em.close();
		}
		catch(PersistenceException ex){
			System.out.println(ex);// error desconocido
		}
		return trabajadores;
		// end-user-code
		// end-user-code
	}

	@Override
	public List<TCurso> mostrarCursosTrabajador(Integer idTrabajador) {
		
		List<TCurso> cursos = null;
		try {
			EntityManagerFactory emf = EMFactory.getInstance().getFactory();
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Trabajador traobtenida=em.find(Trabajador.class, idTrabajador);
			
			if(traobtenida != null) {	
				cursos = new ArrayList<TCurso>();
				TypedQuery<CursoTrabajador> query = em.createNamedQuery("Clases.Negocio.CursoTrabajador.CursoTrabajador.findBytrabajador", CursoTrabajador.class).setParameter("trabajador", traobtenida);              
				for(CursoTrabajador ct :query.getResultList()) {
					TCurso curso = null;
					Curso c = ct.getCurso();
					String nombre = c.getNombre();
					boolean activo = c.isActivo();
					int id = c.getId();
					String tipo = c.getTipo();
					String descripcion = c.getDescripcion();
					int horas = c.getHoras();
					int nivel = c.getNivel();
					int idEmpresa = c.getEmpresa().getId();
					
					curso = new TCurso(nombre, activo, id, tipo, descripcion, horas, nivel, idEmpresa);
					cursos.add(curso);
					
				}
				em.getTransaction().commit();
			}
			else {
				em.getTransaction().rollback();
			}
			em.close();
		}
		catch(PersistenceException ex){
			System.out.println(ex);// error desconocido
		}
		
		return cursos;
	}

}