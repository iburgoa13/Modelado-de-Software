/**
 * 
 */
package Clases.Negocio.Empresa;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.OneToMany;
import javax.persistence.Version;

import Clases.Negocio.Curso.Curso;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Mario, Javier, Yule, David, Alberto, Iker, Fernando, Francisco
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
@Entity
@NamedQueries({
		@NamedQuery(name = "Clases.Negocio.Empresa.Empresa.findByid", query = "select obj from Empresa obj where :id = obj.id "),
		@NamedQuery(name = "Clases.Negocio.Empresa.Empresa.findBysector", query = "select obj from Empresa obj where :sector = obj.sector "),
		@NamedQuery(name = "Clases.Negocio.Empresa.Empresa.findBycif", query = "select obj from Empresa obj where :cif = obj.cif "),
		@NamedQuery(name = "Clases.Negocio.Empresa.Empresa.findBycursos", query = "select obj from Empresa obj where :cursos MEMBER OF obj.cursos "),
		@NamedQuery(name = "Clases.Negocio.Empresa.Empresa.findBynombre", query = "select obj from Empresa obj where :nombre = obj.nombre "),
		@NamedQuery(name = "Clases.Negocio.Empresa.Empresa.findBydireccion", query = "select obj from Empresa obj where :direccion = obj.direccion "),
		@NamedQuery(name = "Clases.Negocio.Empresa.Empresa.findBytelefono", query = "select obj from Empresa obj where :telefono = obj.telefono "),
		@NamedQuery(name = "Clases.Negocio.Empresa.Empresa.findBycorreo", query = "select obj from Empresa obj where :correo = obj.correo "),
		@NamedQuery(name = "Clases.Negocio.Empresa.Empresa.findByactivo", query = "select obj from Empresa obj where :activo = obj.activo "),
		@NamedQuery(name = "Clases.Negocio.Empresa.Empresa.findByversion", query = "select obj from Empresa obj where :version = obj.version ") })
public class Empresa implements Serializable {
	
	
	public Empresa(TEmpresa e) {
		super();
		this.sector = e.getSector();
		this.cif = e.getCif();
		this.nombre = e.getNombre();
		this.direccion = e.getDireccion();
		this.telefono = e.getTelefono();
		this.correo = e.getCorreo();
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
	public Empresa() {
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
	private String sector;

	/** 
	* @return the sector
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public String getSector() {
		// begin-user-code
		return sector;
		// end-user-code
	}

	/** 
	* @param sector the sector to set
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void setSector(String sector) {
		// begin-user-code
		this.sector = sector;
		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	private String cif;

	/** 
	* @return the cif
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public String getCif() {
		// begin-user-code
		return cif;
		// end-user-code
	}

	/** 
	* @param cif the cif to set
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void setCif(String cif) {
		// begin-user-code
		this.cif = cif;
		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	@OneToMany(mappedBy = "empresa")
	private List<Curso> cursos;

	/** 
	* @return the cursos
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public List<Curso> getCursos() {
		// begin-user-code
		return cursos;
		// end-user-code
	}

	/** 
	* @param cursos the cursos to set
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void setCursos(List<Curso> cursos) {
		// begin-user-code
		this.cursos = cursos;
		// end-user-code
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
	private String direccion;

	/** 
	* @return the direccion
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public String getDireccion() {
		// begin-user-code
		return direccion;
		// end-user-code
	}

	/** 
	* @param direccion the direccion to set
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void setDireccion(String direccion) {
		// begin-user-code
		this.direccion = direccion;
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