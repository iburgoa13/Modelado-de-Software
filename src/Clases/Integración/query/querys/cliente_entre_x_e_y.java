/**
 * 
 */
package Clases.Integración.query.querys;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import Clases.Integración.Transaction.Transaction;
import Clases.Integración.Transaction.TransactionManager;
import Clases.Integración.query.query;
import Clases.Negocio.Cliente.TCliente;
import Clases.Negocio.Cliente.TClienteEmpresa;
import Clases.Negocio.Cliente.TClienteParticulares;


public class cliente_entre_x_e_y implements query {
	public Object execute(Object param) {
		float [] parametrosXY = new float[2];
		parametrosXY = (float[]) param;
		float x = parametrosXY[0];
		float y = parametrosXY[1];
		
		TClienteParticulares clienteParticular;
		TClienteEmpresa clienteEmpresa;
		HashMap<TCliente,Float> listaClientes = new HashMap<TCliente,Float>();
		Connection cn = null;
		TransactionManager tm = TransactionManager.getInstance();
		Transaction t = tm.getTransaction();
		
		
		if (t != null) {
			cn = (Connection) t.getResource();
			if (cn != null) {

				try {
					Statement ps = cn.createStatement();
					String sql = "SELECT c.ncuenta, c.correo, c.telefono, c.direccion, c.activo, SUM(v.precio) as total, e.id, e.cif, e.nombre  FROM Cliente AS c INNER JOIN Venta AS v ON c.id = v.idCliente INNER JOIN Empresas AS e ON e.id = c.id GROUP BY v.idCliente HAVING total BETWEEN "
							+ x + " AND " + y + " FOR UPDATE;";
					ResultSet rs = ps.executeQuery(sql);

					while (rs.next()) {
						clienteEmpresa = new TClienteEmpresa(rs.getInt("id"), rs.getLong("telefono"),
								rs.getBoolean("activo"), rs.getString("correo"), rs.getString("direccion"),
								rs.getLong("ncuenta"), rs.getString("nombre"), rs.getString("cif"));
						listaClientes.put(clienteEmpresa,rs.getFloat("total"));
					}

					Statement ps2 = cn.createStatement();
					String sql2 = "SELECT c.ncuenta, c.correo, c.telefono, c.direccion, c.activo, SUM(v.precio) as total, p.id, p.DNI, p.nombre, p.apellidos FROM Cliente AS c INNER JOIN Venta AS v ON c.id = v.idCliente INNER JOIN Particulares AS p ON p.id = c.id GROUP BY v.idCliente HAVING total BETWEEN "
							+ x + " AND " + y + " FOR UPDATE;";
					ResultSet rs2 = ps2.executeQuery(sql2);

					while (rs2.next()) {
						clienteParticular = new TClienteParticulares(rs2.getInt("id"), rs2.getLong("telefono"),
								rs2.getBoolean("activo"), rs2.getString("correo"), rs2.getString("direccion"),
								rs2.getLong("ncuenta"), rs2.getString("dni"), rs2.getString("nombre"),
								rs2.getString("apellidos"));
						listaClientes.put(clienteParticular,rs2.getFloat("total"));
					}
				} catch (SQLException e1) {
					e1.printStackTrace();

				}

			}
		}
		return listaClientes;
	}
}