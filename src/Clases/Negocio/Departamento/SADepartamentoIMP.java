/**
 * 
 */
package Clases.Negocio.Departamento;

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
import Clases.Negocio.Empresa.Empresa;
import Clases.Negocio.Empresa.TEmpresa;
import Clases.Negocio.EntityManagerFactory.EMFactory;
import Clases.Negocio.Trabajador.TIndefinido;
import Clases.Negocio.Trabajador.TTemporal;
import Clases.Negocio.Trabajador.TTrabajador;
import Clases.Negocio.Trabajador.Trabajador;
import Clases.Negocio.Trabajador.TrabajadorIndefinido;
import Clases.Negocio.Trabajador.TrabajadorTemporal;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Mario, Javier, Yule, David, Alberto, Iker, Fernando, Francisco
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class SADepartamentoIMP implements SADepartamento {

	public int comprobaciones(TDepartamento dep) {
		FormatoSA fsa = new FormatoSA();
		int d = fsa.formatoTDepartamentoCorrecto(dep);
		return d;
	}
	/** 
	* (non-Javadoc)
	* @see SADepartamento#altaDepartamento(TDepartamento departamento)
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public Integer altaDepartamento(TDepartamento departamento) {
		// begin-user-code
		// TODO Auto-generated method stub
		int id = 0;
		id = comprobaciones(departamento);
		
		if(id==1) {
			//EMFactory _emf = new EMFactory();
			EntityManagerFactory emf =  EMFactory.getInstance().getFactory();
			/*Persistence.createEntityManagerFactory("mod");*/
			EntityManager em = emf.createEntityManager();
				
			em.getTransaction().begin();
				
			TypedQuery<Departamento> query = em.createNamedQuery("Clases.Negocio.Departamento.Departamento.findBynombre", Departamento.class).setParameter("nombre", departamento.getNombre());
				
			List<Departamento> result = query.getResultList();
			
			if(result.isEmpty()){
				Departamento d = new Departamento(departamento);
				em.persist(d);
				em.getTransaction().commit();
				id = d.getId();
					
			}
				
			else{ //existe un departamento con ese nombre
					
				Departamento d= result.get(0);
				if(d.isActivo()){
					id= -80; //codigo departamento con nombre repetido
					em.getTransaction().rollback();
				}
				else{ //no estaba activo
					d.setActivo(true);
					//em.persist(e);
					em.getTransaction().commit();
				}
			}
			em.close();
		}

		return id;
		// end-user-code
	}

	/** 
	* (non-Javadoc)
	* @see SADepartamento#bajaDepartamento(Integer idDepartamento, Integer id)
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public Integer bajaDepartamento(Integer idDepartamento) {
		// begin-user-code
		// TODO Auto-generated method stub
		int id=-1;
		try {
			EntityManagerFactory emf = EMFactory.getInstance().getFactory();
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Departamento dep=em.find(Departamento.class,idDepartamento);
			if(dep!=null) {
				if(dep.isActivo()) {
					TypedQuery<Trabajador> query = em.createNamedQuery("Clases.Negocio.Trabajador.Trabajador.findBydepartamento", Trabajador.class).setParameter("departamento", dep);
					for(Trabajador t :query.getResultList()) {
						if(t.isActivo()) id = -86;
					}
					if(id!=-86) {
						dep.setActivo(false);
						id=dep.getId();
					}
				
				}
				else  
					id=-82; // temporal, id ya dado de baja
			}
			else {			
				id= -81; // estas intentando borrar un departamento que no existe
			}
			
			if(id<0) {
				em.getTransaction().rollback();
			}
			else 
				em.getTransaction().commit();
			em.close();
		}
		catch(PersistenceException ex){
			return -999; // error desconocido
		}
		
		return id;
		// end-user-code
	}

	/** 
	* (non-Javadoc)
	* @see SADepartamento#mostrarDepartamento(Integer id)
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public TDepartamento mostrarDepartamento(Integer idDepartamento) {
		// begin-user-code
		// TODO Auto-generated method stub
		TDepartamento departamento = null;
		try {
			EntityManagerFactory emf = EMFactory.getInstance().getFactory();
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Departamento depobtenida=em.find(Departamento.class,idDepartamento);
			if(depobtenida!=null) {	
				boolean activo = depobtenida.isActivo();
				String correo = depobtenida.getCorreo();
				String nombre = depobtenida.getNombre();
				String ubicacion = depobtenida.getUbicacion();
				Long telefono = depobtenida.getTelefono();
				departamento = new TDepartamento(nombre, activo, idDepartamento, correo, ubicacion, telefono);
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
		
		return departamento;
		// end-user-code
	}

	/** 
	* (non-Javadoc)
	* @see SADepartamento#actualizarDepartamento(TDepartamento departamento)
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	
	
	public Integer actualizarDepartamento(TDepartamento departamento) {
		// begin-user-code
		// TODO Auto-generated method stub
		int id = -1;
		if(departamento != null) {
			/*
			 * 1 comprobaciones de los valores del departamento
			 * */
			id = comprobaciones(departamento);
			if(id==1) {
				
				try {
					EntityManagerFactory emf = EMFactory.getInstance().getFactory();;
					EntityManager em = emf.createEntityManager();
					em.getTransaction().begin();
					Departamento depObtenida = em.find(Departamento.class, departamento.getId());
					if(depObtenida != null) {
						TypedQuery<Departamento> query = em.createNamedQuery("Clases.Negocio.Departamento.Departamento.findBynombre", Departamento.class).setParameter("nombre", departamento.getNombre());
						List<Departamento> lista = query.getResultList();
						
						if(lista.isEmpty() || (lista.get(0).getId() == departamento.getId() && lista.size()==1)) {
							
							if(depObtenida.isActivo() && !departamento.isActivo()) {
								TypedQuery<Trabajador> queryTrabajador = em.createNamedQuery("Clases.Negocio.Trabajador.Trabajador.findBydepartamento", Trabajador.class).setParameter("departamento", depObtenida);
								for(Trabajador c :queryTrabajador.getResultList()) {
									if(c.isActivo()) id = -86;
								}
								
								if(id==-86) em.getTransaction().rollback();
							}
							if(id!=-86) {
								depObtenida.setActivo(departamento.isActivo());
								depObtenida.setCorreo(departamento.getCorreo());
								depObtenida.setUbicacion(departamento.getUbicacion());
								depObtenida.setNombre(departamento.getNombre());
								depObtenida.setTelefono(departamento.getTelefono());
								id= depObtenida.getId();
								em.getTransaction().commit();
							}
						}
						else {
							id = -80;
							em.getTransaction().rollback();
						}
						
					}
					else {
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
		else id = -85;
		
		return id;
		// end-user-code
	}

	/** 
	* (non-Javadoc)
	* @see SADepartamento#listarDepartamentos()
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public List<TDepartamento> listarDepartamentos() {
		// begin-user-code
		// TODO Auto-generated method stub
		List<TDepartamento> deps = new ArrayList<TDepartamento>();
		try {
			EntityManagerFactory emf = EMFactory.getInstance().getFactory();
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<Departamento> query = em.createQuery("SELECT d FROM Departamento d", Departamento.class);			
			for(Departamento dep: query.getResultList()) {
				boolean activo = dep.isActivo();
				String nombre = dep.getNombre();
				String correo = dep.getCorreo();
				String ubicacion = dep.getUbicacion();
				int id = dep.getId();
				Long telefono = dep.getTelefono();
				deps.add(new TDepartamento(nombre,activo,id,correo,ubicacion,telefono));
			}
			em.getTransaction().commit();
			em.close();
		}
		catch(PersistenceException ex){
			System.out.println(ex);// error desconocido
		}
		return deps;
		// end-user-code
	}

	/** 
	* (non-Javadoc)
	* @see SADepartamento#listarTrabajadoresDepartamento(Integer idDepartamento)
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public List<TTrabajador> listarTrabajadoresDepartamento(Integer idDepartamento) {
		// begin-user-code
		// TODO Auto-generated method stub
		List<TTrabajador> listado = null;
		try {
			EntityManagerFactory emf = EMFactory.getInstance().getFactory();
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Departamento depobtenida=em.find(Departamento.class,idDepartamento);
			
			//em.lock(depobtenida,LockModeType.OPTIMISTIC );
			if(depobtenida!=null) {	
				listado = new ArrayList<TTrabajador>();
				TypedQuery<Trabajador> query = em.createNamedQuery("Clases.Negocio.Trabajador.Trabajador.findBydepartamento", Trabajador.class).setParameter("departamento", depobtenida);              
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
					Departamento departamento = depobtenida;
					//int id = depobtenida.getId();
					
					if(t.getClass().equals(TrabajadorIndefinido.class)){
						Float complemento = ((TrabajadorIndefinido)t).getComplemento();
						Float nomina = ((TrabajadorIndefinido)t).getNomina();
						trabajador = new TIndefinido(dni, id, nombre, telefono, direccion, fechaini, correo, activo, idDepartamento, nomina, complemento);
						listado.add(trabajador);
					}else {
						Float sueldoPH = ((TrabajadorTemporal) t).getSueldoPH();
						Date fechaFin = ((TrabajadorTemporal) t).getFechaFin();
						int horasM = ((TrabajadorTemporal) t).getHorasMensuales();
						trabajador = new TTemporal(dni, id, nombre, telefono, direccion, fechaini, correo, activo, idDepartamento, 
								fechaFin, sueldoPH, horasM);
						listado.add(trabajador);
					}
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
		
		return listado;
		// end-user-code
	}
	@Override
	public Float calcularNomina(Integer idDepartamento) {
		// TODO Auto-generated method stub
		Float nominaTotal= (float) 0.0;
		
		try {
			EntityManagerFactory emf = EMFactory.getInstance().getFactory();
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Departamento depobtenida=em.find(Departamento.class,idDepartamento, LockModeType.OPTIMISTIC);
			if(depobtenida!=null) {	
				TypedQuery<Trabajador> query = em.createNamedQuery("Clases.Negocio.Trabajador.Trabajador.findBydepartamento", Trabajador.class).setParameter("departamento", depobtenida);
				for(Trabajador t :query.getResultList()) {
					if(t.isActivo()) {
						em.lock(t,LockModeType.OPTIMISTIC);
						nominaTotal+= t.calcularNomina();
					}
				}
				em.getTransaction().commit();
			}
			else {
				nominaTotal = (float) -81; //el departamento no existe
				em.getTransaction().rollback();
			}
			em.close();
		}
		catch(PersistenceException ex){
			System.out.println(ex);// error desconocido
			nominaTotal = (float) -999;
		}
		
		
		return nominaTotal;
	}
}