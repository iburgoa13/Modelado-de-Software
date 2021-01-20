/**
 * 
 */
package Clases.Integración.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Clases.Integración.Transaction.Transaction;
import Clases.Integración.Transaction.TransactionManager;
import Clases.Negocio.Cliente.TCliente;
import Clases.Negocio.Cliente.TClienteEmpresa;
import Clases.Negocio.Cliente.TClienteParticulares;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author Mario, Javier, Yule, David, Alberto, Iker, Fernando, Francisco
 * @generated "UML a Java
 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class DAOClienteIMP implements DAOCliente {
	/**
	 * (non-Javadoc)
	 * 
	 * @see DAOCliente#create(TCliente tCliente)
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Integer create(TCliente tC) {
		int id = -1;
		Connection cn = null;
		TransactionManager tm = TransactionManager.getInstance();
		Transaction t = tm.getTransaction();
		if (t != null) {
			cn = (Connection) t.getResource();
			if (cn != null) {
				if (tC.getClass().equals(TClienteEmpresa.class)) {
					TClienteEmpresa tce = (TClienteEmpresa) tC;
					PreparedStatement ps;
					try {

						String sql = "INSERT into Cliente  (ncuenta,correo,telefono,direccion,activo) values ('"
								+ tC.getNcuenta() + "', '" + tC.getCorreo() + "', '" + tC.getTelefono() + "', '"
								+ tC.getDireccion() + "', '" + (1) + "');";
						ps = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
						ps.execute();
						ResultSet rs = ps.getGeneratedKeys();
						if (rs.next()) {
							id = rs.getInt(1);
						}
						String sql1 = "Insert into Empresas (id,cif,nombre) values('" + id + "', '" + tce.getCif()
								+ "', '" + tce.getNombre() + "');";
						PreparedStatement s1;
						s1 = cn.prepareStatement(sql1);
						s1.execute();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					TClienteParticulares tcp = (TClienteParticulares) tC;
					PreparedStatement ps;
					try {

						String sql = "INSERT into Cliente  (ncuenta,correo,telefono,direccion,activo) values ('"
								+ tC.getNcuenta() + "', '" + tC.getCorreo() + "', '" + tC.getTelefono() + "', '"
								+ tC.getDireccion() + "', '" + (1) + "');";
						ps = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
						ps.execute();
						ResultSet rs = ps.getGeneratedKeys();
						if (rs.next()) {
							id = rs.getInt(1);
						}
						String sql1 = "Insert into Particulares (id,dni,nombre,apellidos) values('" + id + "', '"
								+ tcp.getDNI() + "', '" + tcp.getNombre() + "', '" + tcp.getApellido() + "');";
						PreparedStatement s1;
						s1 = cn.prepareStatement(sql1);
						s1.execute();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}

			}

		}
		return id;
	}

	public TCliente read(Integer ID) {
		TCliente cliente = null;
		Connection cn = null;
		TransactionManager tm = TransactionManager.getInstance();
		Transaction t = tm.getTransaction();
		if (t != null) {
			cn = (Connection) t.getResource();
			if (cn != null) {

				try {
					Statement ps = cn.createStatement();
					String sql = "SELECT * FROM Empresas WHERE ID =" + ID + " FOR UPDATE;";

					ResultSet rs = ps.executeQuery(sql);
					if (rs.next()) // es cliente empresa
					{
						Statement psGeneral = cn.createStatement();
						String sqlGeneral = "SELECT * FROM Cliente WHERE ID =" + ID + " FOR UPDATE;";

						ResultSet rsGeneral = psGeneral.executeQuery(sqlGeneral);

						if (rsGeneral.next()) {
							cliente = new TClienteEmpresa(ID, rsGeneral.getLong("telefono"),
									rsGeneral.getBoolean("activo"), rsGeneral.getString("correo"),
									rsGeneral.getString("direccion"), rsGeneral.getLong("ncuenta"),
									rs.getString("nombre"), rs.getString("cif"));
						}

					}

					else {
						ps = cn.createStatement();
						sql = "SELECT * FROM Particulares WHERE ID =" + ID + " FOR UPDATE;";

						rs = ps.executeQuery(sql);
						if (rs.next()) { // es cliente particular
							Statement psGeneral = cn.createStatement();
							String sqlGeneral = "SELECT * FROM Cliente WHERE ID =" + ID + " FOR UPDATE;";

							ResultSet rsGeneral = psGeneral.executeQuery(sqlGeneral);

							if (rsGeneral.next()) {
								cliente = new TClienteParticulares(ID, rsGeneral.getLong("telefono"),
										rsGeneral.getBoolean("activo"), rsGeneral.getString("correo"),
										rsGeneral.getString("direccion"), rsGeneral.getLong("ncuenta"),
										rs.getString("dni"), rs.getString("nombre"), rs.getString("apellidos"));
							}
						}

					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();

				}

			}
		}
		return cliente;
		// end-user-code
	}

	public List<TCliente> readAll() {
		TClienteParticulares clienteParticular;
		TClienteEmpresa clienteEmpresa;
		List<TCliente> listaClientes = new ArrayList<TCliente>();
		Connection cn = null;
		TransactionManager tm = TransactionManager.getInstance();
		Transaction t = tm.getTransaction();
		if (t != null) {
			cn = (Connection) t.getResource();
			if (cn != null) {

				try {
					Statement ps = cn.createStatement();
					String sql = "SELECT e.id,e.cif,e.nombre,c.activo,c.correo,c.direccion,c.ncuenta,c.telefono FROM Cliente as c INNER JOIN Empresas AS e ON e.id = c.id;";
					ResultSet rs = ps.executeQuery(sql);

					while (rs.next()) {
						clienteEmpresa = new TClienteEmpresa(rs.getInt("id"), rs.getLong("telefono"),
								rs.getBoolean("activo"), rs.getString("correo"), rs.getString("direccion"),
								rs.getLong("ncuenta"), rs.getString("nombre"), rs.getString("cif"));
						listaClientes.add(clienteEmpresa);
					}

					Statement ps2 = cn.createStatement();
					String sql2 = "SELECT p.id,p.dni,p.nombre,p.apellidos,c.activo,c.correo,c.direccion,c.ncuenta,c.telefono FROM Cliente as c INNER JOIN Particulares AS p ON p.id = c.id;";
					ResultSet rs2 = ps2.executeQuery(sql2);

					while (rs2.next()) {
						clienteParticular = new TClienteParticulares(rs2.getInt("id"), rs2.getLong("telefono"),
								rs2.getBoolean("activo"), rs2.getString("correo"), rs2.getString("direccion"),
								rs2.getLong("ncuenta"), rs2.getString("dni"), rs2.getString("nombre"),
								rs2.getString("apellidos"));
						listaClientes.add(clienteParticular);
					}

				} catch (SQLException e1) {
					e1.printStackTrace();

				}

			}
		}
		return listaClientes;
	}

	public int update(TCliente tC) {
		int id = tC.getId();
		Connection cn = null;
		TransactionManager tm = TransactionManager.getInstance();
		Transaction t = tm.getTransaction();
		if (t != null) {
			cn = (Connection) t.getResource();
			if (cn != null) {
				if (tC.getClass().equals(TClienteEmpresa.class)) {
					TClienteEmpresa tce = (TClienteEmpresa) tC;
					Statement ps;
					try {

						String sql = "Update Cliente " + "SET correo='" + tC.getCorreo() + "'," + "direccion='"
								+ tC.getDireccion() + "'," + "ncuenta=" + tC.getNcuenta() + "," + "telefono="
								+ tC.getTelefono() + "," + "activo=" + tC.getActivo() + " " + "where id=" + tC.getId()
								+ ";";

						ps = cn.createStatement();
						ps.executeUpdate(sql);
						String sql1 = "Update Empresas " + "SET nombre='" + tce.getNombre() + "'," + "cif='"
								+ tce.getCif() + "' " + "where id=" + tC.getId() + ";";
						Statement ps1;
						ps1 = cn.createStatement();
						ps1.executeUpdate(sql1);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					TClienteParticulares tcp = (TClienteParticulares) tC;
					Statement ps;
					try {

						String sql = "Update Cliente " + "SET correo='" + tC.getCorreo() + "'," + "direccion='"
								+ tC.getDireccion() + "'," + "ncuenta=" + tC.getNcuenta() + "," + "telefono="
								+ tC.getTelefono() + "," + "activo=" + tC.getActivo() + " " + "where id=" + tC.getId()
								+ ";";

						ps = cn.createStatement();
						ps.executeUpdate(sql);
						String sql1 = "Update Particulares " + "SET nombre='" + tcp.getNombre() + "'," + "dni='"
								+ tcp.getDNI() + "'," + "apellidos='" + tcp.getApellido() + "' " + "where id="
								+ tC.getId() + ";";
						Statement ps1;
						ps1 = cn.createStatement();
						ps1.executeUpdate(sql1);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}

			}

		}
		return id;
	}

	public Integer delete(Integer ID) {
		int id = -1;
		Connection cn = null;
		TransactionManager tm = TransactionManager.getInstance();
		Transaction t = tm.getTransaction();
		if (t != null) {
			cn = (Connection) t.getResource();
			if (cn != null) {
				Statement statement;
				try {
					statement = cn.createStatement();
					String sql = "UPDATE Cliente SET `activo` = 0 WHERE `id` =" + ID + ";";
					statement.executeUpdate(sql);

					id = ID;

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

	@Override
	public int readByDNI(TClienteParticulares tc) {
		Connection cn = null;
		TransactionManager tm = TransactionManager.getInstance();
		Transaction t = tm.getTransaction();
		if (t != null) {
			cn = (Connection) t.getResource();
			if (cn != null) {

				try {
					Statement ps = cn.createStatement();
					String sql = "SELECT * FROM Particulares WHERE dni ='" + tc.getDNI() + "' FOR UPDATE;";
					ResultSet rs = ps.executeQuery(sql);
					if (rs.next()) {
						return rs.getInt("id");
					}
					else return 0;

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();

				}

			}
		}
		return -60;
	}

	@Override
	public int readByCIF(TClienteEmpresa tc) {
		Connection cn = null;
		TransactionManager tm = TransactionManager.getInstance();
		Transaction t = tm.getTransaction();
		if (t != null) {
			cn = (Connection) t.getResource();
			if (cn != null) {

				try {
					Statement ps = cn.createStatement();
					String sql = "SELECT * FROM Empresas WHERE cif ='" + tc.getCif() + "' FOR UPDATE;";
					ResultSet rs = ps.executeQuery(sql);
					if (rs.next()) {
						return rs.getInt("id");
					}
					else return 0;
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();

				}

			}
		}
		return -60;
	}
}
