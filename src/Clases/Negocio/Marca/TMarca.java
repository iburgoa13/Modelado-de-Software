/**
 * 
 */
package Clases.Negocio.Marca;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author Mario, Javier, Yule, David, Alberto, Iker, Fernando, Francisco
 * @generated "UML a Java
 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class TMarca {

	/* leer */
	public TMarca(int id, String correo, String direccion, String nombre, String sector, Long telefono,
			boolean activo) {
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.sector = sector;
		this.correo = correo;
		this.activo = activo;
	}

	/* insertar */
	public TMarca(String correo, String direccion, String nombre, String sector, Long telefono) {
		this.nombre = nombre;
		this.correo = correo;
		this.direccion = direccion;
		this.sector = sector;
		this.telefono = telefono;
		this.activo = true;
	}

	private String correo;
	private String direccion;
	private int id;
	private String nombre;
	private String sector;
	private Long telefono;
	private boolean activo;

	public String getCorreo() {
		return correo;
	}

	public boolean getActivo() {
		return activo;
	}

	public void setActivo(boolean act) {
		activo = act;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public Long getTelefono() {
		return telefono;
	}

	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}

}