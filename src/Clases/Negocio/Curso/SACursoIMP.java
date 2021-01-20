/**
 * 
 */
package Clases.Negocio.Curso;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import Clases.Negocio.FormatoSA;
import Clases.Negocio.CursoTrabajador.CursoTrabajador;
import Clases.Negocio.Empresa.Empresa;
import Clases.Negocio.EntityManagerFactory.EMFactory;
import Clases.Negocio.Trabajador.TTrabajador;
import Clases.Negocio.Trabajador.Trabajador;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author Mario, Javier, Yule, David, Alberto, Iker, Fernando, Francisco
 * @generated "UML a JPA
 *            (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class SACursoIMP implements SACurso {

	public Integer comprobaciones(TCurso curso) {
		FormatoSA fsa = new FormatoSA();
		int c = fsa.formatoTCursoCorrecto(curso);
		return c;

	}

	public Integer altaCurso(TCurso curso) {
		// begin-user-code
		// TODO Auto-generated method stub
		int id = 0;

		id = comprobaciones(curso);
		if (id < 0)
			return id;
		EntityManagerFactory emf = EMFactory.getInstance().getFactory();
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		Empresa e = em.find(Empresa.class, curso.getIdEmpresa());
		if (e != null && e.isActivo()) {
			em.lock(e, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
			TypedQuery<Curso> query = em.createNamedQuery("Clases.Negocio.Cursos.Curso.findBynombre", Curso.class)
					.setParameter("nombre", curso.getNombre());

			List<Curso> result = query.getResultList();

			if (result.isEmpty()) {
				Curso c = new Curso(curso, e);
				em.persist(c);
				em.getTransaction().commit();
				id = c.getId();
			} else { // existe un curso con ese nombre
				Curso c = result.get(0);
				if (c.isActivo()) {
					id = -101; // codigo curso con nombre repetido
					em.getTransaction().rollback();
				} else { // no estaba activo, se reactiva
					c.setActivo(true);
					// em.persist(e);
					em.getTransaction().commit();
				}
			}
		}
		else {
			id = -74 ;
			em.getTransaction().rollback();
		}
		em.close();

		return id;

		// end-user-code
	}

	public Integer bajaCurso(Integer idCurso) {
		// begin-user-code
		// TODO Auto-generated method stub
		int id = -1;
		try {
			EntityManagerFactory emf = EMFactory.getInstance().getFactory();
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Curso cursobtenido = em.find(Curso.class, idCurso);
			if (cursobtenido != null) {
				Empresa e = cursobtenido.getEmpresa();
				em.lock(e, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
				if (cursobtenido.isActivo()) {
					TypedQuery<CursoTrabajador> queryCursoTrabajador = em.createNamedQuery("Clases.Negocio.CursoTrabajador.CursoTrabajador.findBycurso", CursoTrabajador.class).setParameter("curso", cursobtenido);
					List<CursoTrabajador> listTrabajador = queryCursoTrabajador.getResultList();
					if(listTrabajador.size()>0) {
						for(int i = 0; i < listTrabajador.size();i++) {
							//esto hay serias dudas (???)
							em.remove(listTrabajador.get(i));
						}
					}
					cursobtenido.setActivo(false);
					id = cursobtenido.getId();
				} else
					id = -102; // temporal, id ya dado de baja
			} else {
				id = -100; // estas intentando borrar un curso que no existe
			}
			if (id < 0) {
				em.getTransaction().rollback();
			} else
				em.getTransaction().commit();
			em.close();
		} catch (PersistenceException ex) {
			return -999; // error desconocido
		}
		
		return id;
		// end-user-code
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see SACurso#mostrarCurso(Integer id)
	 * @generated "UML a JPA
	 *            (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public TCurso mostrarCurso(Integer idCurso) {
		// begin-user-code
		// TODO Auto-generated method stub
		TCurso curso = null;
		try {
			EntityManagerFactory emf = EMFactory.getInstance().getFactory();
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Curso cursobtenido = em.find(Curso.class, idCurso);
			if (cursobtenido != null) {
				Empresa e = cursobtenido.getEmpresa();
				Integer idEmpresa = e.getId();
				em.lock(e, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
				boolean activo = cursobtenido.isActivo();
				String tipo = cursobtenido.getTipo();
				String nombre = cursobtenido.getNombre();
				String descripcion = cursobtenido.getDescripcion();
				Integer horas = cursobtenido.getHoras();
				Integer nivel = cursobtenido.getNivel();
				curso = new TCurso(nombre, activo, idCurso, tipo, descripcion, horas, nivel, idEmpresa);
				em.getTransaction().commit();
			} else {
				em.getTransaction().rollback();
			}
			em.close();
		} catch (PersistenceException ex) {
			System.out.println(ex);// error desconocido
		}

		return curso;
		// end-user-code
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see SACurso#actualizarCurso(TCurso curso)
	 * @generated "UML a JPA
	 *            (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public Integer actualizarCurso(TCurso curso) {
		// begin-user-code
		// TODO Auto-generated method stub

		int id = -1;
		if (curso != null) {
			/*
			 * 1 comprobaciones de los valores de el curso
			 */
			id = comprobaciones(curso);
			if (id == 1) {
				try {
					EntityManagerFactory emf = EMFactory.getInstance().getFactory();
					EntityManager em = emf.createEntityManager();
					em.getTransaction().begin();
					Curso cursoObtenido = em.find(Curso.class, curso.getId());
					if (cursoObtenido != null) {
						Empresa e = em.find(Empresa.class, curso.getIdEmpresa());
						if (e != null && e.isActivo()) {
							TypedQuery<Curso> query = em
									.createNamedQuery("Clases.Negocio.Cursos.Curso.findBynombre", Curso.class)
									.setParameter("nombre", curso.getNombre());
							List<Curso> lista = query.getResultList();
							if (lista.isEmpty() || (lista.get(0).getId() == curso.getId() && lista.size() == 1)) {
								em.lock(e, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
								cursoObtenido.setActivo(curso.isActivo());
								cursoObtenido.setNivel(curso.getNivel());
								cursoObtenido.setTipo(curso.getTipo());
								cursoObtenido.setDescripcion(curso.getDescripcion());
								cursoObtenido.setNombre(curso.getNombre());
								cursoObtenido.setHoras(curso.getHoras());
								cursoObtenido.setEmpresa(e);
								em.getTransaction().commit();
								id = cursoObtenido.getId();
							} else {
								id = -101; // nombre repetido
								em.getTransaction().rollback();
							}
						} else {
							id = -74 ;
							em.getTransaction().rollback();
						}
					} else {
						id = -100;
						em.getTransaction().rollback();
					}
					em.close();

				} catch (PersistenceException ex) {
					id = -999;
				}

			}

		} else
			id = -109;

		return id;
		// end-user-code
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see SACurso#listarCursos()
	 * @generated "UML a JPA
	 *            (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public List<TCurso> listarCursos() {
		// begin-user-code
		// TODO Auto-generated method stub
		List<TCurso> cursos = new ArrayList<TCurso>();
		try {
			EntityManagerFactory emf = EMFactory.getInstance().getFactory();
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();

			TypedQuery<Curso> query = em.createQuery("SELECT e FROM Curso e", Curso.class);
			for (Curso cursobtenida : query.getResultList()) {
				/*
				 * Empresa e = cursobtenida.getEmpresa(); em.lock(e,
				 * LockModeType.OPTIMISTIC_FORCE_INCREMENT);
				 */
				boolean activo = cursobtenida.isActivo();
				Integer idEmpresa = cursobtenida.getEmpresa().getId();
				String tipo = cursobtenida.getTipo();
				String descripcion = cursobtenida.getDescripcion();
				String nombre = cursobtenida.getNombre();
				Integer horas = cursobtenida.getHoras();
				Integer nivel = cursobtenida.getNivel();
				int id = cursobtenida.getId();
				cursos.add(new TCurso(nombre, activo, id, tipo, descripcion, horas, nivel, idEmpresa));
			}
			em.getTransaction().commit();
			em.close();
		} catch (PersistenceException ex) {
			System.out.println(ex);// error desconocido
		}

		return cursos;
		// end-user-code
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see SACurso#listarTrabajadoresCurso(Integer idCurso)
	 * @generated "UML a JPA
	 *            (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public List<TTrabajador> listarTrabajadoresCurso(Integer idCurso) {
		// begin-user-code
		// TODO Auto-generated method stub

		List<TTrabajador> trabajadores = null;

		try {
			EntityManagerFactory emf = EMFactory.getInstance().getFactory();
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();

			Curso cursoObtenido = em.find(Curso.class, idCurso);

			if (cursoObtenido != null) {
				trabajadores = new ArrayList<TTrabajador>();
				TypedQuery<CursoTrabajador> query = em.createNamedQuery("Clases.Negocio.CursoTrabajador.CursoTrabajador.findBycurso", CursoTrabajador.class).setParameter("curso", cursoObtenido);              
				List<CursoTrabajador> listaCursoTrabajador = new ArrayList<CursoTrabajador>();
				listaCursoTrabajador = query.getResultList();

				for (int i = 0; i < listaCursoTrabajador.size(); i++) {
					Trabajador t = listaCursoTrabajador.get(i).getTrabajador();
					trabajadores.add(
							new TTrabajador(t.getDNI(), t.getId(), t.getNombre(), t.getTelefono(), t.getDireccion(),
									t.getFechainicio(), t.getCorreo(), t.isActivo(), t.getDepartamento().getId()));
				}
				em.getTransaction().commit();
			} else
				em.getTransaction().rollback();
			em.close();
		} catch (PersistenceException ex) {
			System.out.println(ex);// error desconocido
		}

		return trabajadores;
		// end-user-code
	}
}