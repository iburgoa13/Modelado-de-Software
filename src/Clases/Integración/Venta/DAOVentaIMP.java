/**
 * 
 */
package Clases.Integración.Venta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import Clases.Integración.Transaction.Transaction;
import Clases.Integración.Transaction.TransactionManager;
import Clases.Negocio.Venta.TDevolucion;
import Clases.Negocio.Venta.TOAVenta;
import Clases.Negocio.Venta.TVenta;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author Mario, Javier, Yule, David, Alberto, Iker, Fernando, Francisco
 * @generated "UML a Java
 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class DAOVentaIMP implements DAOVenta {


	/**
	 * (non-Javadoc)
	 * 
	 * @see DAOVenta#realiza(Class tVenta)
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Integer realizar(TVenta venta) {
		
		int id = -9999;
		Transaction transaction = TransactionManager.getInstance().getTransaction();
		if (transaction != null) {
			Connection conexion = (Connection)transaction.getResource();
			if(conexion!=null) {
				String sql = "INSERT INTO Venta (precio,fecha,idCliente,direccion,estado,activo) VALUES(";
				LocalDate date = LocalDate.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				date.format(formatter);
				
				sql+= venta.getImporte() +",'" + date + "'," + venta.getIdCliente()+",'"+
						venta.getDireccion()+"',"+venta.getEstado()+",1)";
				
				try {
					PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
					ps.execute();
					ResultSet rs= ps.getGeneratedKeys();
					if (rs.next()) { //se ha podido insertar la venta, procedo a insertar los productos
						id= rs.getInt(1);
						HashMap<Integer,TOAVenta> carrito = venta.getCarrito();
						Collection<TOAVenta> collectionLineasDeVenta = carrito.values();
						Iterator<TOAVenta> it = collectionLineasDeVenta.iterator();
						TOAVenta linea;
						
					    while (it.hasNext()) {//recorro los productos de la venta, veo si existen y les quito stock
					    	linea = it.next();
					    	Statement s = conexion.createStatement();
					    	String sql2 ="INSERT INTO Ventas(idproducto,idventa,precio,cantidad) VALUES("+linea.getIdProducto()+
					    			","+id+","+linea.getPrecio()+","+linea.getCantidad()+")";
					    	s.executeUpdate(sql2);
					    }
						
					}
				} catch (SQLException e) {
					id=-50;
					e.printStackTrace();
				}
			}
			
		}
		return id;
	}


	/**
	 * (non-Javadoc)
	 * 
	 * @see DAOVenta#read(Integer ID)
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TVenta read(Integer vIdentificador) {
		
		TVenta tVent = null;
		Connection cn = null;
		TransactionManager tm = TransactionManager.getInstance();
		Transaction t = tm.getTransaction();
		if (t != null) {
			cn = (Connection)t.getResource();
			if (cn != null) {
				
				try {
					Statement ps = cn.createStatement();
					String sql = "SELECT * FROM Venta WHERE ID ="+vIdentificador+" FOR UPDATE;";
					
					
				
					ResultSet rs= ps.executeQuery(sql);
					if (rs.next()) {
						 tVent = new TVenta(vIdentificador,
								rs.getFloat("precio"),
								rs.getDate("fecha"),
								rs.getInt("idCliente"),
								rs.getString("direccion"),
								rs.getBoolean("estado"),
								rs.getBoolean("activo"));
						 HashMap<Integer, TOAVenta> carrito = new HashMap<Integer, TOAVenta>();
						 sql = "SELECT * FROM Ventas WHERE idventa ="+vIdentificador+" FOR UPDATE;";
						 
						 rs= ps.executeQuery(sql);
						 
						 while(rs.next()) {
							 carrito.put(rs.getInt("idproducto"), new TOAVenta(rs.getInt("cantidad") , rs.getInt("idproducto") , rs.getFloat("precio")));
						 }
						 
						 tVent.setCarrito(carrito);
					}
					
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		}

		return tVent;
		// end-user-code
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see DAOVenta#readAll()
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public List<TVenta> readAll() {
		TVenta tVent = null;
		List<TVenta> ventas = new ArrayList<TVenta>();
		Connection cn = null;
		TransactionManager tm = TransactionManager.getInstance();
		Transaction t = tm.getTransaction();
		if (t != null) {
			cn = (Connection) t.getResource();
			if (cn != null) {
				
				try {

					Statement ps = cn.createStatement();
					String sql = "SELECT * FROM Venta ";

					ResultSet rs = ps.executeQuery(sql);
					while (rs.next()) {
						tVent = new TVenta(rs.getInt("id"),
								rs.getFloat("precio"),
								rs.getDate("fecha"),
								rs.getInt("idCliente"),
								rs.getString("direccion"),
								rs.getBoolean("estado"),
								rs.getBoolean("activo"));
						ventas.add(tVent);

					}

				} catch (SQLException e1) {
					e1.printStackTrace();

				}

			}
		}
		return ventas;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see DAOVenta#update()
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Integer update(TVenta venta) {
		int id = -1;
		Connection cn = null;
		TransactionManager tm = TransactionManager.getInstance();
		Transaction t = tm.getTransaction();
		if (t != null) {
			cn = (Connection) t.getResource();
			PreparedStatement ps;
			if (cn != null) {
				try {
					String sql = "UPDATE Venta "
					+ "SET direccion = '" + venta.getDireccion() +"',"
					+ "estado = " + (venta.getEstado() ? 1 : 0)+","
					+ "activo = " + (venta.getActivo() ? 1 : 0)
					+ " WHERE id = " + venta.getId() + ";";
					ps = cn.prepareStatement(sql);
					ps.executeUpdate();
					id = 1;
				} catch (SQLException e1) {
					e1.printStackTrace();
					id=-50;
				}

			}
			else {
				id=-40;
			}
		}
		else {
			id = -60;
		}
		return id;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see DAOVenta#delete(Integer ID)
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Integer delete(Integer vIdentificador) {
		int id = -1;
		Connection cn = null;
		TransactionManager tm = TransactionManager.getInstance();
		Transaction t = tm.getTransaction();
		if (t != null) {
			cn = (Connection)t.getResource();
			if (cn != null) {
				Statement statement;
				try {
					statement = cn.createStatement();
					String sql = "UPDATE Venta SET activo = 0 WHERE id = " + vIdentificador + ";";
					statement.executeUpdate(sql);
					
					id = vIdentificador;
					
				} catch (SQLException e1) {
					e1.printStackTrace();
					id = -50;
				}

			}
		}else {
			id = -60;
		}

		return id;
	}


	@Override
	public TVenta devolucion(TDevolucion devolucion) {
		TVenta tVent = null;
		HashMap<Integer, TOAVenta> carrito = new HashMap<Integer, TOAVenta>();
		
		Connection cn = null;
		TransactionManager tm = TransactionManager.getInstance();
		Transaction t = tm.getTransaction();
		if (t != null) {
			cn = (Connection)t.getResource();
			if (cn != null) {
				
				try {
					Statement ps = cn.createStatement();
					
					//LEEMOS LA VENTA PRIMERO PARA COMPROBAR QUE LA VENTA EXISTE
					String sql = "SELECT * FROM Venta WHERE ID ="+devolucion.getIdVenta()+" FOR UPDATE;";
					
					ResultSet rs= ps.executeQuery(sql);
					if (rs.next()) {
						 tVent = new TVenta(devolucion.getIdVenta(),
								rs.getFloat("precio"),
								rs.getDate("fecha"),
								rs.getInt("idCliente"),
								rs.getString("direccion"),
								rs.getBoolean("estado"),
								rs.getBoolean("activo"));
						 
						 sql = "SELECT * FROM Ventas WHERE idventa ="+devolucion.getIdVenta()+" FOR UPDATE;";
						 
						 rs= ps.executeQuery(sql);
						 
						 while(rs.next()) {
							 carrito.put(rs.getInt("idproducto"), new TOAVenta(rs.getInt("cantidad") , rs.getInt("idproducto") , rs.getFloat("precio")));
						 }
						 
						 tVent.setCarrito(carrito);
					}
					
					//LA VENTA EXISTE, ENTONCES VAMOS A PROBAR LA CANTIDAD ESTA CORRECTA
					
					TOAVenta toa = tVent.getCarrito().get(devolucion.getIdProd());
					int cantidad = toa.getCantidad();
					
					/*if(cantidad - devolucion.getCantProd() < 0)
						throw new Exception("No puedes devolver más productos que lo compraste");*/
					
					toa.setCantidad(cantidad - devolucion.getCantProd());
					
					carrito.remove(devolucion.getIdProd());
					carrito.put(devolucion.getIdProd(), toa);
					tVent.setCarrito(carrito);
					
					float importe = tVent.getImporte();
					
					tVent.setImporte(importe - devolucion.getCantProd()*toa.getPrecio());
					
					String sql2 = "UPDATE Venta set precio = " + tVent.getImporte() + ", fecha = '"
							+ tVent.getFecha() + "', idCliente = " + tVent.getIdCliente() + ", direccion = '"
							+ tVent.getDireccion() + "', estado = " + tVent.getEstado() + ", activo = "
							+ (tVent.getActivo() ? 1 : 0) + " WHERE id = " + tVent.getId() + ";";
					ps = cn.prepareStatement(sql2);
					ps.executeUpdate(sql2);
					
					String sql3 = "UPDATE Ventas set precio = " + 
							toa.getPrecio() + ", cantidad = " + toa.getCantidad() + " WHERE idventa = "
									+ tVent.getId() +" AND idproducto = " + toa.getIdProducto() + ";";
					ps = cn.prepareStatement(sql3);
					ps.executeUpdate(sql3);
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		}

		return tVent;
	}

	@Override
	public List<TVenta> readAllOneCliente(int cIdentificador) {
		TVenta tVent = null;
		List<TVenta> vents = new ArrayList<TVenta>();
		Connection cn = null;
		TransactionManager tm = TransactionManager.getInstance();
		Transaction t = tm.getTransaction();
		if (t != null) {
			cn = (Connection)t.getResource();
			if (cn != null) {
				try {
					Statement ps = cn.createStatement();
					String sql = "SELECT * FROM Venta WHERE idCliente = "+cIdentificador+" FOR UPDATE;";
					
					ResultSet rs= ps.executeQuery(sql);
					while (rs.next())
					{
						
						 tVent = new TVenta(
								rs.getInt("id"),
								rs.getFloat("precio"),
								rs.getDate("fecha"),
								cIdentificador,
								rs.getString("direccion"),
								rs.getBoolean("estado"),
								rs.getBoolean("activo"));
						 vents.add(tVent);
								
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					
				}

			}
		}
		return vents;
	}
}