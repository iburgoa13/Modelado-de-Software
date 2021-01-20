/**
 * 
 */
package Clases.Negocio.Trabajador;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.NamedQuery;

import Clases.Negocio.Departamento.Departamento;

import javax.persistence.NamedQueries;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Mario, Javier, Yule, David, Alberto, Iker, Fernando, Francisco
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
@Entity
@NamedQueries({
		@NamedQuery(name = "Clases.Negocio.Trabajador.TrabajadorIndefinido.findBynomina", query = "select obj from TrabajadorIndefinido obj where :nomina = obj.nomina "),
		@NamedQuery(name = "Clases.Negocio.Trabajador.TrabajadorIndefinido.findBycomplemento", query = "select obj from TrabajadorIndefinido obj where :complemento = obj.complemento ") })
public class TrabajadorIndefinido extends Trabajador implements Serializable {
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
	public TrabajadorIndefinido() {
	}

	public TrabajadorIndefinido(TIndefinido trabajador, Departamento d) {
		// TODO Auto-generated constructor stub
		super(trabajador,d);
		this.complemento= trabajador.getComplemento();
		this.nomina = trabajador.getNomina();
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	private Float nomina;

	/** 
	* @return the nomina
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public Float getNomina() {
		// begin-user-code
		return nomina;
		// end-user-code
	}

	/** 
	* @param nomina the nomina to set
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void setNomina(Float nomina) {
		// begin-user-code
		this.nomina = nomina;
		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	private Float complemento;

	/** 
	* @return the complemento
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public Float getComplemento() {
		// begin-user-code
		return complemento;
		// end-user-code
	}

	/** 
	* @param complemento the complemento to set
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void setComplemento(Float complemento) {
		// begin-user-code
		this.complemento = complemento;
		// end-user-code
	}

	@Override
	public Float calcularNomina() {
		// TODO Auto-generated method stub
		return this.complemento + this.nomina;
	}
}