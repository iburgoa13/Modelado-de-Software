/**
 * 
 */
package Clases.Negocio.Trabajador;

import java.util.Date;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Mario, Javier, Yule, David, Alberto, Iker, Fernando, Francisco
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class TIndefinido extends TTrabajador {
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	
	
	private Float nomina;

	

	public TIndefinido(String dNI, Integer id, String nombre, Long teléfono, String direccion, Date fechainicio,
			String correo, Boolean activo, Integer idDepartamento, Float nomina, Float complemento) {
		super(dNI, id, nombre, teléfono, direccion, fechainicio, correo, activo, idDepartamento);
		this.nomina = nomina;
		this.complemento = complemento;
	}
	
	public TIndefinido(String dNI, String nombre, Long teléfono, String direccion, Date fechainicio,
			String correo, Boolean activo, Integer idDepartamento, Float nomina, Float complemento) {
		super(dNI, nombre, teléfono, direccion, fechainicio, correo, activo, idDepartamento);
		this.nomina = nomina;
		this.complemento = complemento;
	}

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
}