/**
 * 
 */
package Clases.Negocio.Venta;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author Mario, Javier, Yule, David, Alberto, Iker, Fernando, Francisco
 * @generated "UML a Java
 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class TVenta {
	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	
	public TVenta() {
		carrito = new HashMap<Integer,TOAVenta>();
		importe =0;
		fecha = new Date(Calendar.getInstance().getTimeInMillis());
		estado=false;
	}
	
	/*leer*/
	public TVenta(int id, float precio, Date fecha, int idCliente, String direccion, boolean estado, boolean activo) {
		this.id = id;
		this.importe = precio;
		this.fecha = fecha;
		this.idCliente = idCliente;
		this.direccion = direccion;
		this.estado = estado;
		this.activo = activo;
	}
	
	private HashMap<Integer,TOAVenta> carrito;
	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Integer id;
	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Integer idCliente;
	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private float importe;
	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Boolean estado;
	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Date fecha;
	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private String direccion;
	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Boolean activo;
	
	public HashMap<Integer, TOAVenta> getCarrito() {
		return carrito;
	}
	
	
	public void setCarrito(HashMap<Integer, TOAVenta> carrito) {
		this.carrito = carrito;
	}
	
	
	public Integer getId() {
		return id;
	}
	
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	public Integer getIdCliente() {
		return idCliente;
	}
	
	
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	
	
	
	public float getImporte() {
		return importe;
	}
	
	
	public void setImporte(float importe) {
		this.importe = importe;
	}
	
	
	public Boolean getEstado() {
		return estado;
	}
	
	
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	
	public Date getFecha() {
		return fecha;
	}
	
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
	public String getDireccion() {
		return direccion;
	}
	
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	public Boolean getActivo() {
		return activo;
	}
	
	
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	
	
}