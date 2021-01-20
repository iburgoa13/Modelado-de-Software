/**
 * 
 */
package Clases.Negocio.Curso;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Mario, Javier, Yule, David, Alberto, Iker, Fernando, Francisco
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class TCurso {
	
	public TCurso(String nombre, Boolean activo, String tipo, String descripcion, Integer horas, Integer nivel, Integer idEmpresa) {
	    
	    this.nombre = nombre;
	    this.activo = activo;
	    this.tipo = tipo;
	    this.descripcion = descripcion;
	    this.horas = horas;
	    this.nivel = nivel;
	    this.idEmpresa = idEmpresa;
	  }

	  public TCurso(String nombre, Boolean activo, Integer id, String tipo, String descripcion, Integer horas, Integer nivel, Integer idEmpresa) {
	 
	    this.nombre = nombre;
	    this.activo = activo;
	    this.id = id;
	    this.tipo = tipo;
	    this.descripcion = descripcion;
	    this.horas = horas;
	    this.nivel = nivel;
	    this.idEmpresa=idEmpresa;
	  }
	  
	  public TCurso(String nombre, Boolean activo, Integer id, String tipo, String descripcion, Integer horas, Integer nivel) {
			 
		    this.nombre = nombre;
		    this.activo = activo;
		    this.id = id;
		    this.tipo = tipo;
		    this.descripcion = descripcion;
		    this.horas = horas;
		    this.nivel = nivel;
		  }
	  
	private Integer idEmpresa; 
	
	public Integer getIdEmpresa() {
		return idEmpresa;
	}
	  
	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa=idEmpresa;
	}
	
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
	private Integer id;

	/** 
	* @return the id
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public Integer getId() {
		// begin-user-code
		return id;
		// end-user-code
	}

	/** 
	* @param id the id to set
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void setId(Integer id) {
		// begin-user-code
		this.id = id;
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
}