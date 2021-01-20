package Clases.Presentación.Curso;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Clases.Negocio.Trabajador.TTemporal;
import Clases.Negocio.Trabajador.TTrabajador;
import Clases.Presentación.Contexto;
import Clases.Presentación.Command.Events;
import Clases.Presentación.Controller.Controller;

public class gMostrarTrabajadoresCurso extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPanel;

	public gMostrarTrabajadoresCurso() {
	}

	public void update(Contexto contexto) {
		this.setVisible(true);
		contentPanel = new JPanel();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 900, 600);

		contentPanel.setBackground(new Color(32, 178, 170));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(new BorderLayout(0, 20));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(32, 178, 170));
		contentPanel.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(1, 4, 50, 100));

		JButton btnSalir = new JButton("SALIR");
		btnSalir.setFont(new Font("Consolas", Font.PLAIN, 32));
		panel.add(btnSalir);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		JLabel lblNewLabel = new JLabel("Mostrar los trabajadores del curso");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Consolas", Font.PLAIN, 32));
		contentPanel.add(lblNewLabel, BorderLayout.NORTH);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(32, 178, 170));
		contentPanel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(4, 1, 10, 30));

		String[] colsTemporal = { "Identificador", "Nombre", "Departamento", "DNI", "Teléfono", "Correo", "Direccion",
				"FechaIni", "Contrato", "Activo" };
		DefaultTableModel tabla = new DefaultTableModel(colsTemporal, 0);

		int id;
		String nombre, dni, contrato, correo, direccion, activo, idDep;
		Long telefono;
		Date fechaIni;

		@SuppressWarnings("unchecked")
		List<TTrabajador> listaTrabajadores = (List<TTrabajador>) contexto.getData();
		for (int i = 0; i < listaTrabajadores.size(); i++) {
			id = listaTrabajadores.get(i).getId();
			nombre = listaTrabajadores.get(i).getNombre();
			telefono = listaTrabajadores.get(i).getTelefono();
			dni = listaTrabajadores.get(i).getDNI();
			idDep = Integer.toString(listaTrabajadores.get(i).getIdDepartamento());
			correo = listaTrabajadores.get(i).getCorreo();
			direccion = listaTrabajadores.get(i).getDireccion();
			contrato = listaTrabajadores.get(i).getClass().equals(TTemporal.class) ? "Temporal" : "Indefinido";
			activo = listaTrabajadores.get(i).isActivo() ? "ACTIVO" : "NO ACTIVO";
			fechaIni = listaTrabajadores.get(i).getFechainicio();

			Object[] objsParticular = { id, nombre, idDep, dni, telefono, correo, direccion, fechaIni, contrato,
					activo };
			tabla.addRow(objsParticular);
		}

		JTable Tabla = new JTable(tabla);
		Tabla.setEnabled(false);
		JScrollPane scroll = new JScrollPane(Tabla);
		panel_1.add(scroll, BorderLayout.LINE_START);

		this.pack();
		this.setBounds(100, 100, 900, 600);
	}

	public void init() {
		this.setVisible(true);
		contentPanel = new JPanel();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 900, 600);

		contentPanel.setBackground(new Color(32, 178, 170));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(new BorderLayout(0, 20));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(32, 178, 170));
		contentPanel.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(1, 2, 50, 100));

		JButton btnAceptar = new JButton("ACEPTAR");
		btnAceptar.setForeground(new Color(0, 0, 0));
		btnAceptar.setFont(new Font("Consolas", Font.PLAIN, 32));
		panel.add(btnAceptar);

		JButton btnSalir = new JButton("SALIR");
		btnSalir.setFont(new Font("Consolas", Font.PLAIN, 32));
		panel.add(btnSalir);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		JLabel lblNewLabel = new JLabel("Mostrar los trabajadores del curso");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Consolas", Font.PLAIN, 32));
		contentPanel.add(lblNewLabel, BorderLayout.NORTH);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(32, 178, 170));
		contentPanel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(6, 4, 10, 30));

		JLabel lblNewLabel_1 = new JLabel("Identificador");
		lblNewLabel_1.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_1);

		JFormattedTextField formattedTextField = new JFormattedTextField();

		formattedTextField.setFont(new Font("Consolas", Font.PLAIN, 20));
		formattedTextField.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField.setColumns(25);
		panel_1.add(formattedTextField);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int id = Integer.parseInt(formattedTextField.getText());

					Controller.getInstance().action(new Contexto(Events.MOSTRAR_TRABAJADORES_CURSO, id));
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Inserte un número por favor", "ERROR",
							JOptionPane.WARNING_MESSAGE);

				}
			}
		});
	}

}
