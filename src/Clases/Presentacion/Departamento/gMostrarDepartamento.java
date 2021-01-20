package Clases.Presentación.Departamento;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Clases.Negocio.Departamento.TDepartamento;
import Clases.Negocio.Empresa.TEmpresa;
import Clases.Presentación.Contexto;
import Clases.Presentación.Command.Events;
import Clases.Presentación.Controller.Controller;

public class gMostrarDepartamento  extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel contentPanel;
	
	public gMostrarDepartamento() {
			
	}
	
	public void update(Contexto contexto) {
		TDepartamento d = (TDepartamento)contexto.getData();

		JFrame prueba = new JFrame();
		prueba.setVisible(true);
		contentPanel = new JPanel();
		prueba.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		prueba.setBounds(100, 100, 900, 600);

		contentPanel.setBackground(new Color(32, 178, 170));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		prueba.setContentPane(contentPanel);
		contentPanel.setLayout(new BorderLayout(0, 20));

		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(32, 178, 170));
		contentPanel.add(panel1, BorderLayout.SOUTH);
		panel1.setLayout(new GridLayout(1, 2, 50, 100));

		
		JButton btnSalir1 = new JButton("SALIR");
		btnSalir1.setFont(new Font("Consolas", Font.PLAIN, 32));
		panel1.add(btnSalir1);
		btnSalir1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				prueba.setVisible(false);
			}
		});
		
		//String nombre, Boolean activo, Integer id, String correo, String ubicacion, Long telefono
		JLabel lblNewLabel = new JLabel("Mostrar Departamento");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Consolas", Font.PLAIN, 32));
		contentPanel.add(lblNewLabel, BorderLayout.NORTH);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(32, 178, 170));
		contentPanel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(8, 4, 10, 30));

		JLabel lblNewLabel__ID = new JLabel("Identificador");
		lblNewLabel__ID.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNewLabel__ID.setHorizontalAlignment(SwingConstants.CENTER);
		
		panel_1.add(lblNewLabel__ID);

		JFormattedTextField formattedTextField_ID = new JFormattedTextField();
		formattedTextField_ID.setFont(new Font("Consolas", Font.PLAIN, 20));
		formattedTextField_ID.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField_ID.setColumns(25);
		formattedTextField_ID.setValue(d.getId());
		formattedTextField_ID.setEditable(false);
		panel_1.add(formattedTextField_ID);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		panel_1.add(lblNewLabel_1);

		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setFont(new Font("Consolas", Font.PLAIN, 20));
		formattedTextField.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField.setColumns(25);
		formattedTextField.setValue(d.getNombre());
		formattedTextField.setEditable(false);
		panel_1.add(formattedTextField);

		JLabel lblNewLabel_2 = new JLabel("Correo");
		lblNewLabel_2.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_2);

		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setFont(new Font("Consolas", Font.PLAIN, 20));
		formattedTextField_1.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField_1.setColumns(25);
		formattedTextField_1.setEditable(false);
		formattedTextField_1.setValue(d.getCorreo());
		formattedTextField_1.setEditable(false);
		panel_1.add(formattedTextField_1);

		JLabel lblNewLabel_3 = new JLabel("Ubicacion");
		lblNewLabel_3.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_3);

		JFormattedTextField formattedTextField_2 = new JFormattedTextField();
		formattedTextField_2.setFont(new Font("Consolas", Font.PLAIN, 20));
		formattedTextField_2.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField_2.setColumns(25);
		formattedTextField_2.setEditable(false);
		formattedTextField_2.setValue(d.getUbicacion());
		panel_1.add(formattedTextField_2);

		JLabel lblNewLabel_4 = new JLabel("Telefono");
		lblNewLabel_4.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_4);

		JFormattedTextField formattedTextField_3 = new JFormattedTextField();
		formattedTextField_3.setFont(new Font("Consolas", Font.PLAIN, 20));
		formattedTextField_3.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField_3.setColumns(25);
		formattedTextField_3.setEditable(false);
		formattedTextField_3.setValue(d.getTelefono().toString());
		panel_1.add(formattedTextField_3);		
		
		JLabel lblNewLabel_7 = new JLabel("Activo");
		lblNewLabel_7.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_7);

		JFormattedTextField formattedTextField_AC = new JFormattedTextField();
		formattedTextField_AC.setFont(new Font("Consolas", Font.PLAIN, 20));
		formattedTextField_AC.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField_AC.setColumns(25);
		formattedTextField_AC.setEditable(false);
		formattedTextField_AC.setValue(d.isActivo()? "ACTIVO":"NO ACTIVO");
		panel_1.add(formattedTextField_AC);

		
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
		JLabel lblNewLabel = new JLabel("Mostrar Departamento");
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
					
					Controller.getInstance().action(new Contexto(Events.MOSTRAR_DEPARTAMENTO,id));
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Inserte un número por favor","ERROR",JOptionPane.WARNING_MESSAGE);

				}
				}
		});
	}

}
