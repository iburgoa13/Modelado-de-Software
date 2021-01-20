package Clases.Presentación.Trabajador;

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

import Clases.Negocio.Curso.TCurso;
import Clases.Negocio.CursoTrabajador.CursoTrabajador;
import Clases.Negocio.Trabajador.TIndefinido;
import Clases.Negocio.Trabajador.TTemporal;
import Clases.Negocio.Trabajador.TTrabajador;
import Clases.Presentación.Contexto;
import Clases.Presentación.Command.Events;
import Clases.Presentación.Controller.Controller;

public class gMostrarCursosTrabajador extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel contentPanel;
	private JPanel panel;
	private Integer idTra;
	public gMostrarCursosTrabajador() {
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
		JLabel lblNewLabel = new JLabel("Mostrar Cursos del Trabajador");
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
					idTra = Integer.parseInt(formattedTextField.getText());
					Controller.getInstance().action(new Contexto(Events.MOSTRAR_CURSOS_TRABAJADOR, idTra));
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
		this.setBounds(100, 100, 600, 600);

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
		JLabel lblNewLabel = new JLabel("Mostrar los cursos del trabajador "+idTra);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Consolas", Font.PLAIN, 32));
		contentPanel.add(lblNewLabel, BorderLayout.NORTH);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(32, 178, 170));
		contentPanel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(4, 1, 10, 30));	
	
		String[] cols = { "Nombre", "Activo", "ID", "Tipo", "Descripcion", "Horas", "Nivel", "IdEmpresa"};
		
		DefaultTableModel tabla = new DefaultTableModel(cols, 0);

		int id, horas, nivel, idEmpresa;
		String nombre, activo, tipo, descripcion;

		@SuppressWarnings("unchecked")
		List<TCurso> listaCursos = (List<TCurso>) contexto.getData();
		
		for (TCurso curso :listaCursos) {
			id = curso.getId();
			nombre =curso.getNombre();
			activo = curso.isActivo() ? "ACTIVO" : "NO ACTIVO";
			tipo = curso.getTipo();
			descripcion = curso.getDescripcion();
			horas = curso.getHoras();
			nivel = curso.getNivel();
			idEmpresa = curso.getIdEmpresa();
			
			Object[] objsCurso = {nombre, activo, id, tipo, descripcion, horas, nivel, idEmpresa};
			tabla.addRow(objsCurso);
		}
		
		JLabel lblTemp = new JLabel("Cursos");
		lblTemp.setHorizontalAlignment(SwingConstants.CENTER);
		lblTemp.setForeground(new Color(255, 255, 255));
		lblTemp.setFont(new Font("Consolas", Font.PLAIN, 32));
		panel_1.add(lblTemp, BorderLayout.NORTH);
		
		JTable TablaT = new JTable(tabla);
		TablaT.setEnabled(false);
		JScrollPane scroll = new JScrollPane(TablaT);
		panel_1.add(scroll, BorderLayout.LINE_START);
		
		this.pack();
	 	this.setBounds(100, 100, 900, 600);
	}

}
