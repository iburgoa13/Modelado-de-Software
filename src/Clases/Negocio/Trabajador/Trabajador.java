/**
 * 
 */
package Clases.Negocio.Trabajador;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import java.util.Date;
import java.util.ArrayList;

import javax.persistence.ManyToMany;
import Clases.Negocio.Departamento.Departamento;
import javax.persistence.ManyToOne;

import Clases.Negocio.Curso.Curso;
import Clases.Negocio.CursoTrabajador.CursoTrabajador;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import java.util.List;
import javax.persistence.InheritanceType;
import javax.persistence.Inheritance;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Mario, Javier, Yule, David, Alberto, Iker, Fernando, Francisco
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@NamedQueries({
		@NamedQuery(name = "Clases.Negocio.Trabajador.Trabajador.findByid", query = "select obj from Trabajador obj where :id = obj.id "),
		@NamedQuery(name = "Clases.Negocio.Trabajador.Trabajador.findByDNI", query = "select obj from Trabajador obj where :DNI = obj.DNI "),
		@NamedQuery(name = "Clases.Negocio.Trabajador.Trabajador.findBynombre", query = "select obj from Trabajador obj where :nombre = obj.nombre "),
		@NamedQuery(name = "Clases.Negocio.Trabajador.Trabajador.findBytelefono", query = "select obj from Trabajador obj where :telefono = obj.telefono "),
		@NamedQuery(name = "Clases.Negocio.Trabajador.Trabajador.findBydireccion", query = "select obj from Trabajador obj where :direccion = obj.direccion "),
		@NamedQuery(name = "Clases.Negocio.Trabajador.Trabajador.findByfechainicio", query = "select obj from Trabajador obj where :fechainicio = obj.fechainicio "),
		@NamedQuery(name = "Clases.Negocio.Trabajador.Trabajador.findBycorreo", query = "select obj from Trabajador obj where :correo = obj.correo "),
		@NamedQuery(name = "Clases.Negocio.Trabajador.Trabajador.findBydepartamento", query = "select obj from Trabajador obj where :departamento = obj.departamento "),
		@NamedQuery(name = "Clases.Negocio.Trabajador.Trabajador.findBycursoTrabajador", query = "select obj from Trabajador obj where :cursoTrabajador MEMBER OF obj.cursoTrabajador "),
		@NamedQuery(name = "Clases.Negocio.Trabajador.Trabajador.findByversion", query = "select obj from Trabajador obj where :version = obj.version "),
		@NamedQuery(name = "Clases.Negocio.Trabajador.Trabajador.findByactivo", query = "select obj from Trabajador obj where :activo = obj.activo ") })
public abstract class Trabajador implements Serializable {
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
	public Trabajador() {
	}
	
	public Trabajador(TTrabajador trabajador, Departamento d) {
		// TODO Auto-generated constructor stub
		this.activo=trabajador.isActivo();
		this.correo = trabajador.getCorreo();
		this.direccion = trabajador.getDireccion();
		this.DNI=trabajador.getDNI();
		this.fechainicio=trabajador.getFechainicio();
		this.id = trabajador.getId();
		this.nombre = trabajador.getNombre();
		this.telefono = trabajador.getTelefono();
		this.departamento = d;
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
	private String DNI;

	/** 
	* @return the DNI
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public String getDNI() {
		// begin-user-code
		return DNI;
		// end-user-code
	}

	/** 
	* @param DNI the DNI to set
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void setDNI(String DNI) {
		// begin-user-code
		this.DNI = DNI;
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
	private Long telefono;

	/** 
	* @return the teléfono
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public Long getTelefono() {
		// begin-user-code
		return telefono;
		// end-user-code
	}

	/** 
	* @param teléfono the teléfono to set
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
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date fechainicio;

	/** 
	* @return the fechainicio
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public Date getFechainicio() {
		// begin-user-code
		return fechainicio;
		// end-user-code
	}

	/** 
	* @param fechainicio the fechainicio to set
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void setFechainicio(Date fechainicio) {
		// begin-user-code
		this.fechainicio = fechainicio;
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
	@ManyToOne
	private Departamento departamento;

	/** 
	* @return the departamento
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public Departamento getDepartamento() {
		// begin-user-code
		return departamento;
		// end-user-code
	}

	/** 
	* @param departamento the departamento to set
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void setDepartamento(Departamento departamento) {
		// begin-user-code
		this.departamento = departamento;
		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	@OneToMany(mappedBy = "trabajador")
	private List<CursoTrabajador> cursoTrabajador;

	/** 
	* @return the cursoTrabajador
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public List<CursoTrabajador> getCursoTrabajador() {
		// begin-user-code
		return cursoTrabajador;
		// end-user-code
	}

	/** 
	* @param cursoTrabajador the cursoTrabajador to set
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void setCursoTrabajador(List<CursoTrabajador> cursoTrabajador) {
		// begin-user-code
		this.cursoTrabajador = cursoTrabajador;
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


	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @return
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public abstract Float calcularNomina();
}