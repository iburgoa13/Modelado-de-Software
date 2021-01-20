/**
 * 
 */
package Clases.Negocio.CursoTrabajador;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

import Clases.Negocio.Curso.Curso;
import Clases.Negocio.Trabajador.Trabajador;

import java.util.Date;
import java.util.UUID;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Mario, Javier, Yule, David, Alberto, Iker, Fernando, Francisco
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
@Embeddable
public class CursoTrabajadorID implements Serializable {
	
	public CursoTrabajadorID(int idTrabajador, int idCurso) {
		this.trabajador = idTrabajador;
		this.curso = idCurso;
	}
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	private static final long serialVersionUID = 0;

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public CursoTrabajadorID() {
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	private Integer curso;

	/** 
	* @return the curso
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public Integer getCurso() {
		// begin-user-code
		return curso;
		// end-user-code
	}

	/** 
	* @param curso the curso to set
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void setCurso(Integer curso) {
		// begin-user-code
		this.curso = curso;
		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	private Integer trabajador;

	/** 
	* @return the trabajador
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public Integer getTrabajador() {
		// begin-user-code
		return trabajador;
		// end-user-code
	}

	/** 
	* @param trabajador the trabajador to set
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void setTrabajador(Integer trabajador) {
		// begin-user-code
		this.trabajador = trabajador;
		// end-user-code
	}



	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof CursoTrabajadorID))
			return false;
		CursoTrabajadorID pk = (CursoTrabajadorID) obj;
		if ((curso == null && pk.curso != null) || (curso != null && !curso.equals(pk.curso)))
			return false;
		if ((trabajador == null && pk.trabajador != null) || (trabajador != null && !trabajador.equals(pk.trabajador)))
			return false;
		return true;
	}
	@Transient
	private UUID uuid;

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		if (curso != null) {
			hash = hash * prime + curso.hashCode();
		}
		if (trabajador != null) {
			hash = hash * prime + trabajador.hashCode();
		}
		if (hash == 17) {
			if (uuid == null) {
				uuid = UUID.randomUUID();
			}
			hash = uuid.hashCode();
		}
		return hash;
	}
}