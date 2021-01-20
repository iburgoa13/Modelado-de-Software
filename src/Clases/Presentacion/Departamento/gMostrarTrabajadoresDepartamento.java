package Clases.Presentación.Departamento;

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

import Clases.Negocio.Trabajador.TIndefinido;
import Clases.Negocio.Trabajador.TTemporal;
import Clases.Negocio.Trabajador.TTrabajador;
import Clases.Presentación.Contexto;
import Clases.Presentación.Command.Events;
import Clases.Presentación.Controller.Controller;

public class gMostrarTrabajadoresDepartamento extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel contentPanel;
	private JPanel panel;
	private Integer idDep;
	public gMostrarTrabajadoresDepartamento() {
		//update();
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

		panel = new JPanel();
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
		JLabel lblNewLabel = new JLabel("Mostrar Trabajadores del Departamento");
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
					idDep = Integer.parseInt(formattedTextField.getText());
					Controller.getInstance().action(new Contexto(Events.MOSTRAR_TRABAJADORES_DEPARTAMENTO,idDep));
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.WARNING_MESSAGE);

				}
				}
		});
		
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
		JLabel lblNewLabel = new JLabel("Mostrar los trabajadores del departamento "+idDep);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Consolas", Font.PLAIN, 32));
		contentPanel.add(lblNewLabel, BorderLayout.NORTH);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(32, 178, 170));
		contentPanel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(4, 1, 10, 30));	
	
		String[] colsTemporal = { "Identificador", "Nombre", "Departamento", "DNI", "Teléfono", "Correo", "Direccion",
				"FechaIni","FechaFin","H/M","SPH","Activo" };
		String[] colsIndefinido = { "Identificador", "Nombre", "Departamento", "DNI", "Teléfono", "Correo", "Direccion",
				"Nomina", "Complemento" ,"Activo"};
		DefaultTableModel tablaTemporales = new DefaultTableModel(colsTemporal, 0);
		DefaultTableModel tablaIndefinidos = new DefaultTableModel(colsIndefinido, 0);

		int id;
		String nombre,dni,dep,nomina,sph,hm,complemento,correo, direccion, activo,dt,di;
		Long telefono;
		Date fechainiT,fechainiI,fechafinT;

		@SuppressWarnings("unchecked")
		List<TTrabajador> listaTrabajadores = (List<TTrabajador>) contexto.getData();
		
		for (int i = 0; i < listaTrabajadores.size(); i++) {
			if (listaTrabajadores.get(i).getClass().equals(TTemporal.class)) {
				id = listaTrabajadores.get(i).getId();
				nombre = ((TTemporal) listaTrabajadores.get(i)).getNombre();
				telefono = listaTrabajadores.get(i).getTelefono();
				dni=listaTrabajadores.get(i).getDNI();
				dt=Integer.toString(listaTrabajadores.get(i).getIdDepartamento());
				correo = listaTrabajadores.get(i).getCorreo();
				direccion = listaTrabajadores.get(i).getDireccion();
				sph = Float.toString(((TTemporal) listaTrabajadores.get(i)).getSueldoPH());
				activo = listaTrabajadores.get(i).isActivo() ? "ACTIVO" : "NO ACTIVO";
				fechainiT= (((TTemporal)listaTrabajadores.get(i)).getFechainicio());
				fechafinT= (((TTemporal)listaTrabajadores.get(i)).getFechaFin());
				hm=(Integer.toString(((TTemporal)listaTrabajadores.get(i)).getHorasMensuales()));
				
				Object[] objsParticular = { id, nombre,dt,dni,telefono, correo, direccion,fechainiT,fechafinT,hm,sph,activo};
				tablaTemporales.addRow(objsParticular);
			} else {
				id = listaTrabajadores.get(i).getId();
				nombre = ((TIndefinido) listaTrabajadores.get(i)).getNombre();
				telefono = listaTrabajadores.get(i).getTelefono();
				dni=listaTrabajadores.get(i).getDNI();
				di=Integer.toString(listaTrabajadores.get(i).getIdDepartamento());
				correo = listaTrabajadores.get(i).getCorreo();
				direccion = listaTrabajadores.get(i).getDireccion();
				complemento = Float.toString(((TIndefinido) listaTrabajadores.get(i)).getComplemento());
				nomina = Float.toString(((TIndefinido) listaTrabajadores.get(i)).getNomina());
				fechainiT= (((TIndefinido)listaTrabajadores.get(i)).getFechainicio());
				
				activo = listaTrabajadores.get(i).isActivo() ? "ACTIVO" : "NO ACTIVO";
				
				Object[] objsEmpresa = { id, nombre,di,dni,telefono, correo, direccion,nomina,complemento, activo };
				tablaIndefinidos.addRow(objsEmpresa);
			}
		}
		
		JLabel lblTemp = new JLabel("Trabajadores temporales");
		lblTemp.setHorizontalAlignment(SwingConstants.CENTER);
		lblTemp.setForeground(new Color(255, 255, 255));
		lblTemp.setFont(new Font("Consolas", Font.PLAIN, 32));
		panel_1.add(lblTemp, BorderLayout.NORTH);
		
		JTable TablaT = new JTable(tablaTemporales);
		TablaT.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		TablaT.setEnabled(false);
		JScrollPane scroll = new JScrollPane(TablaT);
		panel_1.add(scroll, BorderLayout.LINE_START);

		JLabel lblInd = new JLabel("Trabajadores indefinidos");
		lblInd.setHorizontalAlignment(SwingConstants.CENTER);
		lblInd.setForeground(new Color(255, 255, 255));
		lblInd.setFont(new Font("Consolas", Font.PLAIN, 32));
		panel_1.add(lblInd, BorderLayout.NORTH);
		
		JTable TableI = new JTable(tablaIndefinidos);
		TableI.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		TableI.setEnabled(false);
		JScrollPane scroll2 = new JScrollPane(TableI);
		panel_1.add(scroll2, BorderLayout.LINE_END);
		
		this.pack();
	 	this.setBounds(100, 100, 900, 600);
	}

}
