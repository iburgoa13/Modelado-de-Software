package Clases.Presentación.Cliente;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.StringUtils;

import Clases.Negocio.Cliente.TCliente;
import Clases.Negocio.Cliente.TClienteEmpresa;
import Clases.Negocio.Cliente.TClienteParticulares;
import Clases.Presentación.Contexto;
import Clases.Presentación.Command.Events;
import Clases.Presentación.Controller.Controller;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author Mario, Javier, Yule, David, Alberto, Iker, Fernando, Francisco
 * @generated "UML a Java
 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class gEntreXY extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPanel;
	private JPanel panel_1;
	private JLabel lblMin;
	private JTextField tfMin;
	private JLabel lblMax;
	private JTextField tfMax;
	private JButton btnBuscar;

	public gEntreXY() {
	}

	public void init() {
		setVisible(true);
		setResizable(false);
		contentPanel = new JPanel();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1200, 600);

		float[] minMax = new float[2];

		contentPanel.setBackground(new Color(32, 178, 170));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(new BorderLayout(0, 20));

		panel_1 = new JPanel();
		panel_1.setBackground(new Color(32, 178, 170));
		contentPanel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new FlowLayout(1, 10, 10));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(32, 178, 170));
		contentPanel.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(1, 2, 50, 100));

		JLabel lblNewLabel = new JLabel("Mostrar clientes en un rango de gasto");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Consolas", Font.PLAIN, 32));
		contentPanel.add(lblNewLabel, BorderLayout.NORTH);

		lblMin = new JLabel("Introduce mínimo gasto:");
		lblMin.setHorizontalAlignment(SwingConstants.CENTER);
		lblMin.setFont(new Font("Consolas", Font.PLAIN, 16));
		panel_1.add(lblMin);

		tfMin = new JTextField();
		tfMin.setFont(new Font("Consolas", Font.PLAIN, 16));
		tfMin.setHorizontalAlignment(SwingConstants.CENTER);
		tfMin.setColumns(25);
		panel_1.add(tfMin);

		lblMax = new JLabel("Introduce máximo gasto:");
		lblMax.setHorizontalAlignment(SwingConstants.CENTER);
		lblMax.setFont(new Font("Consolas", Font.PLAIN, 14));
		panel_1.add(lblMax);

		tfMax = new JTextField();
		tfMax.setFont(new Font("Consolas", Font.PLAIN, 16));
		tfMax.setHorizontalAlignment(SwingConstants.CENTER);
		tfMax.setColumns(25);
		panel_1.add(tfMax);

		//////////////////////////

		btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Consolas", Font.PLAIN, 16));
		panel_1.add(btnBuscar);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!StringUtils.isEmptyOrWhitespaceOnly(tfMin.getText())) {
					try {
						minMax[0] = Float.parseFloat(tfMin.getText());
						if (!StringUtils.isEmptyOrWhitespaceOnly(tfMax.getText())) {
							minMax[1] = Float.parseFloat(tfMax.getText());
							if(minMax[1] >= minMax[0])
								Controller.getInstance().action(new Contexto(Events.ENTRXYCliente, minMax));
							else
								JOptionPane.showMessageDialog(null, "El mínimo tiene que ser menor o igual que el máximo", "ERROR",
										JOptionPane.WARNING_MESSAGE);
								
						}
						else {
							minMax[1] = Float.MAX_VALUE;
							Controller.getInstance().action(new Contexto(Events.ENTRXYCliente, minMax));
						}
						

						
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "El mínimo y máximo deben ser valores numéricos " + e.getMessage(), "ERROR",
								JOptionPane.WARNING_MESSAGE);
					}
				} else
					JOptionPane.showMessageDialog(null, "Introduzca gasto mínimo para buscar ", "ERROR",
							JOptionPane.WARNING_MESSAGE);

			}
		});

		JButton btnSalir = new JButton("SALIR");
		btnSalir.setFont(new Font("Consolas", Font.PLAIN, 32));
		panel.add(btnSalir);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});

	}

	public void update(Contexto context) {
		String[] columnasParticular = { "Identificador", "Nombre", "Apellido","Gasto", "DNI", "Teléfono", "Correo", "Direccion",
				"Nº Cuenta", "Activo" };
		String[] columnasEmpresa = { "Identificador", "Nombre", "Gasto","CIF", "Teléfono", "Correo", "Direccion", "Nº Cuenta",
				"Activo" };
		DefaultTableModel tablaParticulares = new DefaultTableModel(columnasParticular, 0);
		DefaultTableModel tablaEmpresas = new DefaultTableModel(columnasEmpresa, 0);

		lblMin.setVisible(false);
		tfMin.setVisible(false);
		lblMax.setVisible(false);
		tfMax.setVisible(false);
		btnBuscar.setVisible(false);

		int id;
		String nombre, apellido, dni, cif, correo, direccion, activo;
		Long numCuenta, telefono;
		Float gasto;

		@SuppressWarnings("unchecked")
		HashMap<TCliente,Float> listaClientes = (HashMap<TCliente,Float>) context.getData();
		
		Iterator<TCliente> it = listaClientes.keySet().iterator();
		
		
		while(it.hasNext()) {
			TCliente cliente = it.next();
			if (cliente.getClass().equals(TClienteParticulares.class)) { //es particular
				id = cliente.getId();
				nombre = ((TClienteParticulares) cliente).getNombre();
				apellido = ((TClienteParticulares) cliente).getApellido();
				dni = ((TClienteParticulares) cliente).getDNI();
				telefono = cliente.getTelefono();
				correo = cliente.getCorreo();
				direccion = cliente.getDireccion();
				numCuenta = cliente.getNcuenta();
				activo = cliente.getActivo() ? "ACTIVO" : "NO ACTIVO";
				gasto= listaClientes.get(cliente);
				Object[] objsParticular = { id, nombre, apellido,gasto, dni, telefono, correo, direccion, numCuenta, activo };
				tablaParticulares.addRow(objsParticular);
			} else {
				id = cliente.getId();
				nombre = ((TClienteEmpresa) cliente).getNombre();
				cif = ((TClienteEmpresa) cliente).getCif();
				telefono = cliente.getTelefono();
				correo = cliente.getCorreo();
				direccion = cliente.getDireccion();
				numCuenta =cliente.getNcuenta();
				activo = cliente.getActivo() ? "ACTIVO" : "NO ACTIVO";
				gasto= listaClientes.get(cliente);
				Object[] objsEmpresa = { id, nombre, gasto,cif, telefono, correo, direccion, numCuenta, activo };
				tablaEmpresas.addRow(objsEmpresa);
			}
		}


		JTable TablaParticular = new JTable(tablaParticulares);
		//TablaParticular.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		TablaParticular.setEnabled(false);
		JScrollPane scroll = new JScrollPane(TablaParticular);

		JTable TableEmpresa = new JTable(tablaEmpresas);
		//TableEmpresa.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		TableEmpresa.setEnabled(false);
		JScrollPane scroll2 = new JScrollPane(TableEmpresa);

		if (tablaParticulares.getRowCount() > 0 && tablaEmpresas.getRowCount() > 0) {
			panel_1.add(scroll, BorderLayout.LINE_START);
			panel_1.add(scroll2, BorderLayout.LINE_END);
		} else if (tablaParticulares.getRowCount() > 0) {
			panel_1.add(scroll, BorderLayout.CENTER);
		} else if (tablaEmpresas.getRowCount() > 0) {
			panel_1.add(scroll2, BorderLayout.CENTER);
		}

	}
}