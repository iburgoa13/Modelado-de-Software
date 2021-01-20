/**
 * 
 */
package Clases.Negocio.Cliente;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author Mario, Javier, Yule, David, Alberto, Iker, Fernando, Francisco
 * @generated "UML a Java
 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class TClienteEmpresa extends TCliente {
	


	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private String nombre;
	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private String cif;
	
	public TClienteEmpresa(int id , Long telefono, Boolean activo, String correo, String direccion, Long ncuenta, String nombre, String cif) {
		super(telefono, activo, correo, direccion, id,ncuenta);
		this.setNombre(nombre);
		this.setCif(cif);
	}
	
	public TClienteEmpresa(Long telefono, Boolean activo, String correo, String direccion, Long ncuenta, String nombre, String cif) {
		super(telefono, activo, correo, direccion, ncuenta);
		this.setNombre(nombre);
		this.setCif(cif);
	}
	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}