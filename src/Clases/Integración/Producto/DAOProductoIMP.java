/**
 * 
 */
package Clases.Integración.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Clases.Integración.Transaction.Transaction;
import Clases.Integración.Transaction.TransactionManager;
import Clases.Negocio.Producto.TProducto;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author Mario, Javier, Yule, David, Alberto, Iker, Fernando, Francisco
 * @generated "UML a Java
 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class DAOProductoIMP implements DAOProducto {
	/**
	 * (non-Javadoc)
	 * 
	 * @see DAOProducto#create()
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int create(TProducto producto) {
		
		int id = -1;
		Connection cn = null;
		TransactionManager tm = TransactionManager.getInstance();
		Transaction t = tm.getTransaction();
		if (t != null) {
			cn = (Connection)t.getResource();
			if (cn != null) {
				PreparedStatement ps;
				try {
				
					String sql = "INSERT into Producto (nombre,descrip,precio,talla,stock,marca,activo) values ('"
							+ producto.getNombre() + "', '"+ producto.getDescripcion() + "', '" + producto.getPrecio() +"', '"+
							producto.getTalla() +"', '"+ producto.getStock() + "', '" + producto.getMarca() + "', '" +
							(producto.getActivo() ? 1 : 0)+ "');";
					ps = cn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS );
					ps.execute();

					ResultSet rs= ps.getGeneratedKeys();
					if (rs.next())
					{
					id= rs.getInt(1);
					}
					/*statement = cn.createStatement();					
					String sql = "INSERT into Producto (nombre,descrip,precio,talla,stock,marca,activo) values ('"
							+ producto.getNombre() + "', '"+ producto.getDescripcion() + "', '" + producto.getPrecio() +"', '"+
							producto.getTalla() +"', '"+ producto.getStock() + "', '" + producto.getMarca() + "', '" +
							(producto.getActivo() ? 1 : 0)+ "');";
					statement.executeUpdate(sql);
					ResultSet rs = statement.executeQuery("select last_insert_id() as id from Producto");
					if (rs.next()) {
						id = rs.getInt("id");
					}*/
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		}

		return id;
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see DAOProducto#comprobarProducto(Integer ID)
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Boolean comprobarProducto(Integer ID) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see DAOProducto#read()
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TProducto read(int pIdentificador) {
		
		TProducto tProd = null;
		Connection cn = null;
		TransactionManager tm = TransactionManager.getInstance();
		Transaction t = tm.getTransaction();
		if (t != null) {
			cn = (Connection)t.getResource();
			if (cn != null) {
				
				try {
					Statement ps = cn.createStatement();
					String sql = "SELECT * FROM Producto WHERE ID ="+pIdentificador+" FOR UPDATE;";
					
					
				
					ResultSet rs= ps.executeQuery(sql);
					if (rs.next())
					{
						
						
						 tProd = new TProducto(pIdentificador,
								rs.getString("nombre"),
								rs.getString("descrip"),
								rs.getFloat("precio"),
								rs.getString("talla"),
								rs.getInt("stock"),
								rs.getInt("marca"),
								rs.getBoolean("activo"));
								
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					
				}

			}
		}

		return tProd;
		// begin-user-code
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see DAOProducto#readAll()
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public List <TProducto> readAll(){
		TProducto tProd = null;
		List<TProducto> Productos = new ArrayList<TProducto>();
		Connection cn = null;
		TransactionManager tm = TransactionManager.getInstance();
		Transaction t = tm.getTransaction();
		if (t != null) {
			cn = (Connection)t.getResource();
			if (cn != null) {
				
				try {
				
					Statement ps = cn.createStatement();
					String sql = "SELECT * FROM Producto ";
					
					
				
					ResultSet rs= ps.executeQuery(sql);
					while (rs.next())
					{
						
						
						 tProd = new TProducto(
								rs.getInt("id"),
								rs.getString("nombre"),
								rs.getString("descrip"),
								rs.getFloat("precio"),
								rs.getString("talla"),
								rs.getInt("stock"),
								rs.getInt("marca"),
								rs.getBoolean("activo"));
						 Productos.add(tProd);
								
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					
				}

			}
		}
	   return Productos;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see DAOProducto#update()
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int update(TProducto producto) {
		int id = -1;
		Connection cn = null;
		TransactionManager tm = TransactionManager.getInstance();
		Transaction t = tm.getTransaction();
		if (t != null) {
			cn = (Connection)t.getResource();
			if (cn != null) {
				Statement ps ;
				try {
					ps = cn.createStatement();
					String sql = "UPDATE Producto "
							+ "SET nombre = '" + producto.getNombre()+"',"
							+ "descrip = '"+ producto.getDescripcion()+"',"
							+ "precio = " + producto.getPrecio()+","
							+"talla = '"+producto.getTalla()+"',"
							+"stock="+producto.getStock()+","
							+"marca = "+producto.getMarca()+","
							+"activo="+ producto.getActivo()+" where id ="+producto.getId()+";";
							
					
					ps.executeUpdate(sql);

					
					
					id= producto.getId();
					
					/*statement = cn.createStatement();					
					String sql = "INSERT into Producto (nombre,descrip,precio,talla,stock,marca,activo) values ('"
							+ producto.getNombre() + "', '"+ producto.getDescripcion() + "', '" + producto.getPrecio() +"', '"+
							producto.getTalla() +"', '"+ producto.getStock() + "', '" + producto.getMarca() + "', '" +
							(producto.getActivo() ? 1 : 0)+ "');";
					statement.executeUpdate(sql);
					ResultSet rs = statement.executeQuery("select last_insert_id() as id from Producto");
					if (rs.next()) {
						id = rs.getInt("id");
					}*/
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					id = -50;
					e1.printStackTrace();
				}

			}
		}

		return id;
		// begin-user-code
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see DAOProducto#delete()
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int delete(int pIdentificador) {
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
					String sql = "UPDATE Producto SET `activo` = 0 WHERE `id` ="+ pIdentificador+  ";";
					statement.executeUpdate(sql);
					
					id = pIdentificador;
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					id = -50;
				}

			}
		}

		return id;
	}

	@Override
	public List<TProducto> readMarca(int mIdentificador) {
		TProducto tProd = null;
		List<TProducto> Productos = new ArrayList<TProducto>();
		Connection cn = null;
		TransactionManager tm = TransactionManager.getInstance();
		Transaction t = tm.getTransaction();
		if (t != null) {
			cn = (Connection)t.getResource();
			if (cn != null) {
				
				try {
				
					Statement ps = cn.createStatement();
					String sql = "SELECT * FROM Producto WHERE MARCA ="+mIdentificador+" FOR UPDATE;";
					
					
				
					ResultSet rs= ps.executeQuery(sql);
					while (rs.next())
					{
						
						 tProd = new TProducto(
								rs.getInt("id"),
								rs.getString("nombre"),
								rs.getString("descrip"),
								rs.getFloat("precio"),
								rs.getString("talla"),
								rs.getInt("stock"),
								mIdentificador,
								rs.getBoolean("activo"));
						 Productos.add(tProd);
								
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					
				}

			}
		}
	   return Productos;
	}
	public int readByName(String nombre) {
		int id = -1;
		Connection cn = null;
		TransactionManager tm = TransactionManager.getInstance();
		Transaction t = tm.getTransaction();
		if(t != null) {
			cn = (Connection)t.getResource();
			if(cn!=null) {
				try {
					Statement ps = cn.createStatement();
					String sql = "SELECT * FROM Producto WHERE nombre ='"+ nombre + "' FOR UPDATE;";

					ResultSet rs = ps.executeQuery(sql);
					if (rs.next()) {
						return rs.getInt("id");
					}
					else {
						return -1;
					}
					
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		}
		return id;
	}
}