/**
 * 
 */
package Clases.Negocio.Trabajador;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import Clases.Negocio.Departamento.Departamento;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Mario, Javier, Yule, David, Alberto, Iker, Fernando, Francisco
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
@Entity
@NamedQueries({
		@NamedQuery(name = "Clases.Negocio.Trabajador.TrabajadorTemporal.findByfechaFin", query = "select obj from TrabajadorTemporal obj where :fechaFin = obj.fechaFin "),
		@NamedQuery(name = "Clases.Negocio.Trabajador.TrabajadorTemporal.findBysueldoPH", query = "select obj from TrabajadorTemporal obj where :sueldoPH = obj.sueldoPH "),
		@NamedQuery(name = "Clases.Negocio.Trabajador.TrabajadorTemporal.findByhorasMensuales", query = "select obj from TrabajadorTemporal obj where :horasMensuales = obj.horasMensuales ") })
public class TrabajadorTemporal extends Trabajador implements Serializable {
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
	public TrabajadorTemporal() {
	}

	public TrabajadorTemporal(TTemporal trabajador, Departamento d) {
		// TODO Auto-generated constructor stub
		super(trabajador,d);
		this.fechaFin= trabajador.getFechaFin();
		this.horasMensuales= trabajador.getHorasMensuales();
		this.sueldoPH = trabajador.getSueldoPH();
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	@Temporal(value = TemporalType.TIMESTAMP)
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

	@Override
	public Float calcularNomina() {
		// TODO Auto-generated method stub
		return this.sueldoPH * this.horasMensuales;
	}
}