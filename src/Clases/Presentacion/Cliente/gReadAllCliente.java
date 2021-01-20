/**
 * 
 */
package Clases.Presentación.Cliente;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Clases.Negocio.Cliente.TCliente;
import Clases.Negocio.Cliente.TClienteEmpresa;
import Clases.Negocio.Cliente.TClienteParticulares;
import Clases.Presentación.Contexto;
import Clases.Presentación.Command.Events;
import Clases.Presentación.Controller.Controller;

public class gReadAllCliente extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPanel;
	private JPanel panel_1;

	public gReadAllCliente() {
	}

	public void init() {
		setVisible(true);
		setResizable(false);
		contentPanel = new JPanel();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1200, 600);

		contentPanel.setBackground(new Color(32, 178, 170));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(new BorderLayout(0, 20));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(32, 178, 170));
		contentPanel.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(1, 2, 50, 100));

		JButton btnSalir = new JButton("SALIR");
		btnSalir.setFont(new Font("Consolas", Font.PLAIN, 32));
		panel.add(btnSalir);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		JLabel lblNewLabel = new JLabel("Mostrar todos los clientes");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Consolas", Font.PLAIN, 32));
		contentPanel.add(lblNewLabel, BorderLayout.NORTH);

		panel_1 = new JPanel();
		panel_1.setBackground(new Color(32, 178, 170));
		contentPanel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(1, 2, 10, 30));

		Controller.getInstance().action(new Contexto(Events.LISTAR_TODOSCLIENTES, null));

	}

	public void update(Contexto context) {
		String[] columnasParticular = { "Identificador", "Nombre", "Apellido", "DNI", "Teléfono", "Correo", "Direccion",
				"Nº Cuenta", "Activo" };
		String[] columnasEmpresa = { "Identificador", "Nombre", "CIF", "Teléfono", "Correo", "Direccion", "Nº Cuenta",
				"Activo" };
		DefaultTableModel tablaParticulares = new DefaultTableModel(columnasParticular, 0);
		DefaultTableModel tablaEmpresas = new DefaultTableModel(columnasEmpresa, 0);

		int id;
		String nombre, apellido, dni, cif, correo, direccion, activo;
		Long numCuenta, telefono;

		@SuppressWarnings("unchecked")
		List<TCliente> listaClientes = (List<TCliente>) context.getData();

		for (int i = 0; i < listaClientes.size(); i++) {
			if (listaClientes.get(i).getClass().equals(TClienteParticulares.class)) {
				id = listaClientes.get(i).getId();
				nombre = ((TClienteParticulares) listaClientes.get(i)).getNombre();
				apellido = ((TClienteParticulares) listaClientes.get(i)).getApellido();
				dni = ((TClienteParticulares) listaClientes.get(i)).getDNI();
				telefono = listaClientes.get(i).getTelefono();
				correo = listaClientes.get(i).getCorreo();
				direccion = listaClientes.get(i).getDireccion();
				numCuenta = listaClientes.get(i).getNcuenta();
				activo = listaClientes.get(i).getActivo() ? "ACTIVO" : "NO ACTIVO";
				Object[] objsParticular = { id, nombre, apellido, dni, telefono, correo, direccion, numCuenta, activo };
				tablaParticulares.addRow(objsParticular);
			} else {
				id = listaClientes.get(i).getId();
				nombre = ((TClienteEmpresa) listaClientes.get(i)).getNombre();
				cif = ((TClienteEmpresa) listaClientes.get(i)).getCif();
				telefono = listaClientes.get(i).getTelefono();
				correo = listaClientes.get(i).getCorreo();
				direccion = listaClientes.get(i).getDireccion();
				numCuenta = listaClientes.get(i).getNcuenta();
				activo = listaClientes.get(i).getActivo() ? "ACTIVO" : "NO ACTIVO";
				Object[] objsEmpresa = { id, nombre, cif, telefono, correo, direccion, numCuenta, activo };
				tablaEmpresas.addRow(objsEmpresa);
			}
		}

		JTable TablaParticular = new JTable(tablaParticulares);
		TablaParticular.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		TablaParticular.setEnabled(false);
		JScrollPane scroll = new JScrollPane(TablaParticular);
		panel_1.add(scroll, BorderLayout.LINE_START);

		JTable TableEmpresa = new JTable(tablaEmpresas);
		TableEmpresa.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		TableEmpresa.setEnabled(false);
		JScrollPane scroll2 = new JScrollPane(TableEmpresa);
		panel_1.add(scroll2, BorderLayout.LINE_END);

	}
}