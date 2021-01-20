/**
 * 
 */
package Clases.Negocio.CursoTrabajador;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;

import Clases.Negocio.Trabajador.TTemporal;
import Clases.Negocio.Trabajador.Trabajador;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import Clases.Negocio.Curso.Curso;
import Clases.Negocio.Departamento.Departamento;

import javax.persistence.EmbeddedId;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Mario, Javier, Yule, David, Alberto, Iker, Fernando, Francisco
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
@Entity
@NamedQueries({
		@NamedQuery(name = "Clases.Negocio.CursoTrabajador.CursoTrabajador.findByinicio", query = "select obj from CursoTrabajador obj where :inicio = obj.inicio "),
		@NamedQuery(name = "Clases.Negocio.CursoTrabajador.CursoTrabajador.findByfin", query = "select obj from CursoTrabajador obj where :fin = obj.fin "),
		@NamedQuery(name = "Clases.Negocio.CursoTrabajador.CursoTrabajador.findBytrabajador", query = "select obj from CursoTrabajador obj where :trabajador = obj.trabajador "),
		@NamedQuery(name = "Clases.Negocio.CursoTrabajador.CursoTrabajador.findBycurso", query = "select obj from CursoTrabajador obj where :curso = obj.curso "),
		@NamedQuery(name = "Clases.Negocio.CursoTrabajador.CursoTrabajador.findByid", query = "select obj from CursoTrabajador obj where :id = obj.id "),
		@NamedQuery(name = "Clases.Negocio.CursoTrabajador.CursoTrabajador.findByCursoTrabajador", query = "select obj from CursoTrabajador obj where :trabajador = obj.trabajador and :curso = obj.curso ") })
public class CursoTrabajador implements Serializable {
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	private static final long serialVersionUID = 0;

	public CursoTrabajador(Trabajador trabajador, Curso curso, Date fechaIni, Date fechaFin) {
		this.trabajador = trabajador;
		this.curso = curso;
		this.inicio = fechaIni;
		this.fin = fechaFin;
	}
	
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public CursoTrabajador() {
	}
	
	
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date inicio;

	/** 
	* @return the inicio
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public Date getInicio() {
		// begin-user-code
		return inicio;
		// end-user-code
	}

	/** 
	* @param inicio the inicio to set
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void setInicio(Date inicio) {
		// begin-user-code
		this.inicio = inicio;
		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date fin;

	/** 
	* @return the fin
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public Date getFin() {
		// begin-user-code
		return fin;
		// end-user-code
	}

	/** 
	* @param fin the fin to set
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void setFin(Date fin) {
		// begin-user-code
		this.fin = fin;
		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	@ManyToOne
	@MapsId private Trabajador trabajador;

	/** 
	* @return the trabajador
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public Trabajador getTrabajador() {
		// begin-user-code
		return trabajador;
		// end-user-code
	}

	/** 
	* @param trabajador the trabajador to set
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void setTrabajador(Trabajador trabajador) {
		// begin-user-code
		this.trabajador = trabajador;
		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	@ManyToOne
	@MapsId private Curso curso;

	/** 
	* @return the curso
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public Curso getCurso() {
		// begin-user-code
		return curso;
		// end-user-code
	}

	/** 
	* @param curso the curso to set
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void setCurso(Curso curso) {
		// begin-user-code
		this.curso = curso;
		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	@EmbeddedId
	private CursoTrabajadorID id;

	/** 
	* @return the id
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public CursoTrabajadorID getId() {
		return id;
	}

	/** 
	* @param id the id to set
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void setId(CursoTrabajadorID id) {
		this.id = id;
	}
}