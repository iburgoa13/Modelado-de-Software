/**
 * 
 */
package Clases.Negocio.Empresa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import Clases.Negocio.FormatoSA;
import Clases.Negocio.Curso.Curso;
import Clases.Negocio.Curso.TCurso;
import Clases.Negocio.EntityManagerFactory.EMFactory;
import Clases.Negocio.EntityManagerFactory.EMFactoryIMP;
import Clases.Negocio.Trabajador.Trabajador;
import Clases.Presentación.Command.Events;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Mario, Javier, Yule, David, Alberto, Iker, Fernando, Francisco
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class SAEmpresaIMP implements SAEmpresa {

	
	/** 
	* (non-Javadoc)
	* @see SAEmpresa#altaEmpresa(TEmpresa empresa)
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public Integer altaEmpresa(TEmpresa empresa) {
		// begin-user-code
		// TODO Auto-generated method stub
		int id = 0;
		
		id = comprobaciones(empresa);
		if(id<0) return id;
		EntityManagerFactory emf = EMFactory.getInstance().getFactory();
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		TypedQuery<Empresa> query = em.createNamedQuery("Clases.Negocio.Empresa.Empresa.findBycif", Empresa.class).setParameter("cif", empresa.getCif());
		
		List<Empresa> result = query.getResultList();
	
		if(result.isEmpty()){
			Empresa e = new Empresa(empresa);
			em.persist(e);
			em.getTransaction().commit();
			id = e.getId();
			
		}
		else{ //existe una empresa con ese cif
			
			Empresa e= result.get(0);
			if(e.isActivo()){
				id= -75; //codigo empresa con cif repetido
				em.getTransaction().rollback();
			}
			else{ //no estaba activa, se reactiva
				e.setActivo(true);
				// em.persist(e);
				em.getTransaction().commit();
			}
		}
		
		
		em.close();
		
		return id;
		// end-user-code
	}

	/** 
	* (non-Javadoc)
	* @see SAEmpresa#bajaEmpresa(Integer idEmpresa, Integer id)
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public Integer bajaEmpresa(Integer idEmpresa) {
		// begin-user-code
		// TODO Auto-generated method stub
		int id=-1;
		try {
			EntityManagerFactory emf = EMFactory.getInstance().getFactory();
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Empresa empobtenida=em.find(Empresa.class,idEmpresa);
			if(empobtenida!=null) {
				TypedQuery<Curso> query = em.createNamedQuery("Clases.Negocio.Cursos.Curso.findByempresa", Curso.class).setParameter("empresa", empobtenida);
				for(Curso c :query.getResultList()) {
					if(c.isActivo()) id = -77;
				}
				if(id!=-77) {
					if(empobtenida.isActivo()) { 
						empobtenida.setActivo(false);
						id=empobtenida.getId();
					}
					else id=-76; //empresa ya esta de baja
				}
				
			}else {
				
				id= -74; // estas intentando borrar una empresa que no existe
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
	* @see SAEmpresa#mostrarEmpresa(Integer id)
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public TEmpresa mostrarEmpresa(Integer idEmpresa) {
		// begin-user-code
		// TODO Auto-generated method stub
		TEmpresa empresa = null;
		try {
			EntityManagerFactory emf = EMFactory.getInstance().getFactory();
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Empresa empobtenida=em.find(Empresa.class,idEmpresa);
			
			if(empobtenida!=null) {	
				boolean activo = empobtenida.isActivo();
				String cif = empobtenida.getCif();
				String correo = empobtenida.getCorreo();
				String direccion = empobtenida.getDireccion();
				String nombre = empobtenida.getNombre();
				String sector = empobtenida.getSector();
				Long telefono = empobtenida.getTelefono();
				empresa = new TEmpresa(sector, activo, idEmpresa, cif, nombre, direccion, telefono, correo);
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
		
		return empresa;
		// end-user-code
	}

	/** 
	* (non-Javadoc)
	* @see SAEmpresa#actualizarEmpresa(TEmpresa empresa)
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public int comprobaciones(TEmpresa empresa) {
		FormatoSA fsa = new FormatoSA();
		int d = fsa.formatoTEmpresaCorrecto(empresa);
		return d;
	}
	
	public Integer actualizarEmpresa(TEmpresa empresa) {
		// begin-user-code
		// TODO Auto-generated method stub
		
		int id = -1;
		if(empresa != null) {
			/*
			 * 1 comprobaciones de los valores de la empresa
			 * */
			id = comprobaciones(empresa);
			if(id==1) {
				
				try {
					EntityManagerFactory emf = EMFactory.getInstance().getFactory();
					EntityManager em = emf.createEntityManager();
					em.getTransaction().begin();
					Empresa empresaObtenida = em.find(Empresa.class, empresa.getId());
					if(empresaObtenida != null) {
						TypedQuery<Empresa> query = em.createNamedQuery("Clases.Negocio.Empresa.Empresa.findBycif", Empresa.class).setParameter("cif", empresa.getCif());
						List<Empresa> lista = query.getResultList();
						if(lista.isEmpty() || (lista.get(0).getId() == empresa.getId() && lista.size()==1)) {
							
							if(empresaObtenida.isActivo() && !empresa.isActivo()) {
								TypedQuery<Curso> queryCursos = em.createNamedQuery("Clases.Negocio.Cursos.Curso.findByempresa", Curso.class).setParameter("empresa", empresaObtenida);
								for(Curso c :queryCursos.getResultList()) {
									if(c.isActivo()) id = -77;
								}
								
								if(id==-77) em.getTransaction().rollback();
							}
							if(id!=-77) {
								empresaObtenida.setActivo(empresa.isActivo());
								empresaObtenida.setCif(empresa.getCif());
								empresaObtenida.setCorreo(empresa.getCorreo());
								empresaObtenida.setDireccion(empresa.getDireccion());
								empresaObtenida.setNombre(empresa.getNombre());
								empresaObtenida.setSector(empresa.getSector());
								empresaObtenida.setTelefono(empresa.getTelefono());
								id= empresaObtenida.getId();
								em.getTransaction().commit();
							}
						}
						else {
							id = -75;
							em.getTransaction().rollback();
						}
						
					}
					else {
						id = -74;
						em.getTransaction().rollback();
					}
					em.close();
					
				}
				catch(PersistenceException ex) {
					id = -999;
				}
				
				
			}
			
		}
		else id = -70;
		
		return id;
		// end-user-code
	}

	/** 
	* (non-Javadoc)
	* @see SAEmpresa#listarEmpresas()
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public List<TEmpresa> listarEmpresas() {
		// begin-user-code
		// TODO Auto-generated method stub
		List<TEmpresa> empresas = new ArrayList<TEmpresa>();
		try {
			EntityManagerFactory emf = EMFactory.getInstance().getFactory();
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<Empresa> query = em.createQuery("SELECT e FROM Empresa e", Empresa.class);		
			for( Empresa empobtenida: query.getResultList()) {
				boolean activo = empobtenida.isActivo();
				String cif = empobtenida.getCif();
				String correo = empobtenida.getCorreo();
				String direccion = empobtenida.getDireccion();
				String nombre = empobtenida.getNombre();
				String sector = empobtenida.getSector();
				int id = empobtenida.getId();
				Long telefono = empobtenida.getTelefono();
				empresas.add(new TEmpresa(sector, activo, id, cif, nombre, direccion, telefono, correo));
			}
			em.getTransaction().commit();
			em.close();
		}
		catch(PersistenceException ex){
			System.out.println(ex);// error desconocido
		}
		
		return empresas;
		// end-user-code
	}

	@Override
	public List<TCurso> mostrarCursosEmpresa(Integer idEmpresa) {
		List<TCurso> cursos = null;
		try {
			EntityManagerFactory emf = EMFactory.getInstance().getFactory();
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Empresa empobtenida=em.find(Empresa.class, idEmpresa);
			
			if(empobtenida != null) {	
				cursos = new ArrayList<TCurso>();
				TypedQuery<Curso> query = em.createNamedQuery("Clases.Negocio.Cursos.Curso.findByempresa", Curso.class).setParameter("empresa", empobtenida);              
				for(Curso c :query.getResultList()) {
					TCurso curso = null;
					String nombre = c.getNombre();
					boolean activo = c.isActivo();
					int id = c.getId();
					String tipo = c.getTipo();
					String descripcion = c.getDescripcion();
					int horas = c.getHoras();
					int nivel = c.getNivel();
					
					curso = new TCurso(nombre, activo, id, tipo, descripcion, horas, nivel);
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