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
public class TTemporal extends TTrabajador {
	
	
	

	public TTemporal(String dNI, Integer id, String nombre, Long teléfono, String direccion, Date fechainicio,
			String correo, Boolean activo, Integer idDepartamento, Date fechaFin, Float sueldoPH,
			Integer horasMensuales) {
		super(dNI, id, nombre, teléfono, direccion, fechainicio, correo, activo, idDepartamento);
		this.fechaFin = fechaFin;
		this.sueldoPH = sueldoPH;
		this.horasMensuales = horasMensuales;
	}
	
	public TTemporal(String dNI,  String nombre, Long teléfono, String direccion, Date fechainicio,
			String correo, Boolean activo, Integer idDepartamento, Date fechaFin, Float sueldoPH,
			Integer horasMensuales) {
		super(dNI, nombre, teléfono, direccion, fechainicio, correo, activo, idDepartamento);
		this.fechaFin = fechaFin;
		this.sueldoPH = sueldoPH;
		this.horasMensuales = horasMensuales;
	}
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	private Date fechaFin;

	/** 
	* @return the fechaFin
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public Date getFechaFin() {
		// begin-user-code
		return fechaFin;
		// end-user-code
	}

	/** 
	* @param fechaFin the fechaFin to set
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void setFechaFin(Date fechaFin) {
		// begin-user-code
		this.fechaFin = fechaFin;
		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	private Float sueldoPH;

	/** 
	* @return the sueldoPH
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public Float getSueldoPH() {
		// begin-user-code
		return sueldoPH;
		// end-user-code
	}

	/** 
	* @param sueldoPH the sueldoPH to set
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void setSueldoPH(Float sueldoPH) {
		// begin-user-code
		this.sueldoPH = sueldoPH;
		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	private Integer horasMensuales;

	/** 
	* @return the horasMensuales
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public Integer getHorasMensuales() {
		// begin-user-code
		return horasMensuales;
		// end-user-code
	}

	/** 
	* @param horasMensuales the horasMensuales to set
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void setHorasMensuales(Integer horasMensuales) {
		// begin-user-code
		this.horasMensuales = horasMensuales;
		// end-user-code
	}
}