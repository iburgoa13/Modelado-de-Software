/**
 * 
 */
package Clases.Negocio.Departamento;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import java.util.List;
import java.util.ArrayList;

import Clases.Negocio.Empresa.TEmpresa;
import Clases.Negocio.Trabajador.Trabajador;
import javax.persistence.OneToMany;
import javax.persistence.Version;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Mario, Javier, Yule, David, Alberto, Iker, Fernando, Francisco
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
@Entity
@NamedQueries({
		@NamedQuery(name = "Clases.Negocio.Departamento.Departamento.findByid", query = "select obj from Departamento obj where :id = obj.id "),
		@NamedQuery(name = "Clases.Negocio.Departamento.Departamento.findBynombre", query = "select obj from Departamento obj where :nombre = obj.nombre "),
		@NamedQuery(name = "Clases.Negocio.Departamento.Departamento.findBycorreo", query = "select obj from Departamento obj where :correo = obj.correo "),
		@NamedQuery(name = "Clases.Negocio.Departamento.Departamento.findByubicacion", query = "select obj from Departamento obj where :ubicacion = obj.ubicacion "),
		@NamedQuery(name = "Clases.Negocio.Departamento.Departamento.findBytelefono", query = "select obj from Departamento obj where :telefono = obj.telefono "),
		@NamedQuery(name = "Clases.Negocio.Departamento.Departamento.findBytrabajadores", query = "select obj from Departamento obj where :trabajadores MEMBER OF obj.trabajadores "),
		@NamedQuery(name = "Clases.Negocio.Departamento.Departamento.findByversion", query = "select obj from Departamento obj where :version = obj.version "),
		@NamedQuery(name = "Clases.Negocio.Departamento.Departamento.findByactivo", query = "select obj from Departamento obj where :activo = obj.activo ") })
public class Departamento implements Serializable {
	
	public Departamento(TDepartamento d) {
		super();
		this.nombre = d.getNombre();
		this.correo = d.getCorreo();
		this.ubicacion = d.getUbicacion();
		this.telefono = d.getTelefono();
		this.activo = true;
		//this.version = version;
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
	public Departamento() {
	}
	
	

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private Integer id;

	/** 
	* @return the id
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public Integer getId() {
		return id;
	}

	/** 
	* @param id the id to set
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void setId(Integer id) {
		this.id = id;
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	private String nombre;

	/** 
	* @return the nombre
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public String getNombre() {
		// begin-user-code
		return nombre;
		// end-user-code
	}

	/** 
	* @param nombre the nombre to set
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void setNombre(String nombre) {
		// begin-user-code
		this.nombre = nombre;
		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	private String correo;

	/** 
	* @return the correo
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public String getCorreo() {
		// begin-user-code
		return correo;
		// end-user-code
	}

	/** 
	* @param correo the correo to set
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void setCorreo(String correo) {
		// begin-user-code
		this.correo = correo;
		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	private String ubicacion;

	/** 
	* @return the ubicación
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public String getUbicacion() {
		// begin-user-code
		return ubicacion;
		// end-user-code
	}

	/** 
	* @param ubicación the ubicación to set
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void setUbicacion(String ubicacion) {
		// begin-user-code
		this.ubicacion = ubicacion;
		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	private Long telefono;

	/** 
	* @return the telefono
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public Long getTelefono() {
		// begin-user-code
		return telefono;
		// end-user-code
	}

	/** 
	* @param telefono the telefono to set
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void setTelefono(Long telefono) {
		// begin-user-code
		this.telefono = telefono;
		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	@OneToMany(mappedBy = "departamento")
	private List<Trabajador> trabajadores;

	/** 
	* @return the trabajadores
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public List<Trabajador> getTrabajadores() {
		// begin-user-code
		return trabajadores;
		// end-user-code
	}

	/** 
	* @param trabajadores the trabajadores to set
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void setTrabajadores(List<Trabajador> trabajadores) {
		// begin-user-code
		this.trabajadores = trabajadores;
		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	private Boolean activo;

	/** 
	* @return the activo
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public Boolean isActivo() {
		// begin-user-code
		return activo;
		// end-user-code
	}

	/** 
	* @param activo the activo to set
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void setActivo(Boolean activo) {
		// begin-user-code
		this.activo = activo;
		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	@Version
	private Integer version;

}