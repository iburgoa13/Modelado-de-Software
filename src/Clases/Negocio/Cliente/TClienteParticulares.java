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
public class TClienteParticulares extends TCliente {
	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private String dni;
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
	private String apellido;

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	
	
	public TClienteParticulares(int id, Long telefono, Boolean activo, String correo, String direccion,
			Long ncuenta, String dni, String nombre, String apellido) {
		super(telefono, activo, correo, direccion,  id,ncuenta);
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
	}
	public TClienteParticulares(Long telefono, Boolean activo, String correo, String direccion,
			Long ncuenta, String dni, String nombre, String apellido) {
		super(telefono, activo, correo, direccion,  ncuenta);
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public String getDNI() {
		return dni;
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public String getNombre() {
		return nombre;
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}
	public String getApellido() {
		return apellido;
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}
}