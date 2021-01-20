/**
 * 
 */
package Clases.Integración.Marca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Clases.Integración.Transaction.Transaction;
import Clases.Integración.Transaction.TransactionManager;
import Clases.Negocio.Marca.TMarca;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author Mario, Javier, Yule, David, Alberto, Iker, Fernando, Francisco
 * @generated "UML a Java
 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class DAOMarcaIMP implements DAOMarca {
	/**
	 * (non-Javadoc)
	 * 
	 * @see DAOMarca#create()
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int create(TMarca marca) {
		// TODO Auto-generated method stub

		
		int id = -1;
		Connection cn = null;
		TransactionManager tm = TransactionManager.getInstance();
		Transaction t = tm.getTransaction();
		if (t != null) {
			cn = (Connection) t.getResource();
			PreparedStatement ps;
			if (cn != null) {

				try {
					String sql = "INSERT into Marca (correo,direccion,nombre,sector,teléfono,activo) values ('"
							+ marca.getCorreo() + "', '" + marca.getDireccion() + "', '" + marca.getNombre() + "', '"
							+ marca.getSector() + "', '" + marca.getTelefono() + "', '" + (marca.getActivo() ? 1 : 0)
							+ "');";
					ps = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
					ps.execute();

					ResultSet rs = ps.getGeneratedKeys();
					if (rs.next()) {
						id = rs.getInt(1);
					}
					/*
					 * statement = cn.createStatement(); String sql =
					 * "INSERT into Marca (correo,direccion,nombre,sector,teléfono) values ('" +
					 * marca.getCorreo() + "', '" + marca.getDireccion() + "', '" +
					 * marca.getNombre() + "', '" + marca.getSector() + "', '" + marca.getTelefono()
					 * + "');"; statement.executeUpdate(sql); ResultSet rs =
					 * statement.executeQuery("select last_insert_id() as id from Marca"); if
					 * (rs.next()) { id = rs.getInt("id"); }
					 */
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		}

		return id;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see DAOMarca#read()
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TMarca read(int mIdentificador) {
		
		TMarca tMar = null;
		Connection cn = null;
		TransactionManager tm = TransactionManager.getInstance();
		Transaction t = tm.getTransaction();
		if (t != null) {
			cn = (Connection) t.getResource();
			if (cn != null) {

				try {
					Statement ps = cn.createStatement();
					String sql = "SELECT * FROM Marca WHERE ID =" + mIdentificador + " FOR UPDATE;";

					ResultSet rs = ps.executeQuery(sql);
					if (rs.next()) {

						tMar = new TMarca(mIdentificador, 
								rs.getString("correo"),
								rs.getString("direccion"),
								rs.getString("nombre"), 
								rs.getString("sector"), 
								rs.getLong("teléfono"), 
								rs.getBoolean("activo"));
					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();

				}

			}
		}

		return tMar;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see DAOMarca#readAll()
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public List<TMarca> readAll() {
		TMarca tMar = null;
		List<TMarca> marcas = new ArrayList<TMarca>();
		Connection cn = null;
		TransactionManager tm = TransactionManager.getInstance();
		Transaction t = tm.getTransaction();
		if (t != null) {
			cn = (Connection) t.getResource();
			if (cn != null) {

				try {

					Statement ps = cn.createStatement();
					String sql = "SELECT * FROM Marca ";

					ResultSet rs = ps.executeQuery(sql);
					while (rs.next()) {

						tMar = new TMarca(rs.getInt("id"), 
								rs.getString("correo"),
								rs.getString("direccion"),
								rs.getString("nombre"), 
								rs.getString("sector"), 
								rs.getLong("teléfono"), 
								rs.getBoolean("activo"));
						marcas.add(tMar);

					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();

				}

			}
		}
		return marcas;
	}

	public int update(TMarca marca) {
		
		int id = -1;
		Connection cn = null;
		TransactionManager tm = TransactionManager.getInstance();
		Transaction t = tm.getTransaction();
		if (t != null) {
			cn = (Connection) t.getResource();
			PreparedStatement ps;
			if (cn != null) {

				try {
					String sql = "UPDATE  Marca set correo = '" + marca.getCorreo() + "', direccion = '"
							+ marca.getDireccion() + "', nombre = '" + marca.getNombre() + "', sector = '"
							+ marca.getSector() + "', teléfono = " + marca.getTelefono() + ", activo = "
							+ (marca.getActivo() ? 1 : 0) + " WHERE id = " + marca.getId() + ";";
					ps = cn.prepareStatement(sql);
					ps.executeUpdate();
					id = marca.getId();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}

		}
		return id;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see DAOMarca#delete()
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int delete(int mId) {
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
					String sql = "UPDATE Marca SET activo = 0 WHERE id = " + mId + ";";
					statement.executeUpdate(sql);

					id = mId;

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					id = -50;
				}

			}
		} else {
			id = -60;
		}

		return id;
	}
	
	public int readByName(String nombre) {
		Connection cn = null;
		TransactionManager tm = TransactionManager.getInstance();
		Transaction t = tm.getTransaction();
		if (t != null) {
			cn = (Connection) t.getResource();
			if (cn != null) {

				try {
					Statement ps = cn.createStatement();
					String sql = "SELECT * FROM Marca WHERE nombre ='"+ nombre+ "' FOR UPDATE;";

					ResultSet rs = ps.executeQuery(sql);
					if (rs.next()) {
						return rs.getInt("id");
					}
					else {
						return -1;
					}
					}

				   catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		return -60;
	}

}