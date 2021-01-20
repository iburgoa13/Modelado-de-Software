/**
 * 
 */
package Clases.Negocio.Curso;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import Clases.Negocio.Empresa.Empresa;
import javax.persistence.ManyToOne;
import java.util.List;
import java.util.ArrayList;
import Clases.Negocio.Trabajador.Trabajador;
import javax.persistence.ManyToMany;
import Clases.Negocio.CursoTrabajador.CursoTrabajador;
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
		@NamedQuery(name = "Clases.Negocio.Cursos.Curso.findByid", query = "select obj from Curso obj where :id = obj.id "),
		@NamedQuery(name = "Clases.Negocio.Cursos.Curso.findBynombre", query = "select obj from Curso obj where :nombre = obj.nombre "),
		@NamedQuery(name = "Clases.Negocio.Cursos.Curso.findBydescripcion", query = "select obj from Curso obj where :descripcion = obj.descripcion "),
		@NamedQuery(name = "Clases.Negocio.Cursos.Curso.findBynivel", query = "select obj from Curso obj where :nivel = obj.nivel "),
		@NamedQuery(name = "Clases.Negocio.Cursos.Curso.findBytipo", query = "select obj from Curso obj where :tipo = obj.tipo "),
		@NamedQuery(name = "Clases.Negocio.Cursos.Curso.findByhoras", query = "select obj from Curso obj where :horas = obj.horas "),
		@NamedQuery(name = "Clases.Negocio.Cursos.Curso.findByempresa", query = "select obj from Curso obj where :empresa = obj.empresa "),
		@NamedQuery(name = "Clases.Negocio.Cursos.Curso.findBycursoTrabajador", query = "select obj from Curso obj where :cursoTrabajador MEMBER OF obj.cursoTrabajador "),
		@NamedQuery(name = "Clases.Negocio.Cursos.Curso.findByversion", query = "select obj from Curso obj where :version = obj.version "),
		@NamedQuery(name = "Clases.Negocio.Cursos.Curso.findByactivo", query = "select obj from Curso obj where :activo = obj.activo ")})
public class Curso implements Serializable {
	
	 public Curso(TCurso curso, Empresa e) {
      super();
      this.nombre = curso.getNombre();
      this.tipo = curso.getTipo();
      this.horas = curso.getHoras();
      this.descripcion = curso.getDescripcion();
      this.nivel = curso.getNivel();
      this.empresa = e;
      this.activo = true;
    }
	private static final long serialVersionUID = 0;

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public Curso() {
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
	private String descripcion;

	/** 
	* @return the descripcion
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public String getDescripcion() {
		// begin-user-code
		return descripcion;
		// end-user-code
	}

	/** 
	* @param descripcion the descripcion to set
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void setDescripcion(String descripcion) {
		// begin-user-code
		this.descripcion = descripcion;
		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	private Integer nivel;

	/** 
	* @return the nivel
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public Integer getNivel() {
		// begin-user-code
		return nivel;
		// end-user-code
	}

	/** 
	* @param nivel the nivel to set
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void setNivel(Integer nivel) {
		// begin-user-code
		this.nivel = nivel;
		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	private String tipo;

	/** 
	* @return the tipo
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public String getTipo() {
		// begin-user-code
		return tipo;
		// end-user-code
	}

	/** 
	* @param tipo the tipo to set
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void setTipo(String tipo) {
		// begin-user-code
		this.tipo = tipo;
		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	private Integer horas;

	/** 
	* @return the horas
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public Integer getHoras() {
		// begin-user-code
		return horas;
		// end-user-code
	}

	/** 
	* @param horas the horas to set
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void setHoras(Integer horas) {
		// begin-user-code
		this.horas = horas;
		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	@ManyToOne
	private Empresa empresa;

	/** 
	* @return the empresa
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public Empresa getEmpresa() {
		// begin-user-code
		return empresa;
		// end-user-code
	}

	/** 
	* @param empresa the empresa to set
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void setEmpresa(Empresa empresa) {
		// begin-user-code
		this.empresa = empresa;
		// end-user-code
	}


	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	@OneToMany(mappedBy = "curso")
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
}