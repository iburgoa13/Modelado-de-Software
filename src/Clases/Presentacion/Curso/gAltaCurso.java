package Clases.Presentación.Curso;

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

import Clases.Negocio.Curso.TCurso;
import Clases.Presentación.Contexto;
import Clases.Presentación.Command.Events;
import Clases.Presentación.Controller.Controller;

public class gAltaCurso extends JFrame{

	private static final long serialVersionUID = 1L;

	private JPanel contentPanel;
	public gAltaCurso() {
		//init();
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
		JLabel lblNewLabel = new JLabel("Alta Curso");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Consolas", Font.PLAIN, 32));
		contentPanel.add(lblNewLabel, BorderLayout.NORTH);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(32, 178, 170));
		contentPanel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(6, 4, 10, 30));

		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_1);

		JFormattedTextField nombreTF = new JFormattedTextField();
		nombreTF.setFont(new Font("Consolas", Font.PLAIN, 20));
		nombreTF.setHorizontalAlignment(SwingConstants.CENTER);
		nombreTF.setColumns(25);
		panel_1.add(nombreTF);

		JLabel lblNewLabel_2 = new JLabel("Descripcion");
		lblNewLabel_2.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_2);

		JFormattedTextField descripcionTF = new JFormattedTextField();
		descripcionTF.setFont(new Font("Consolas", Font.PLAIN, 20));
		descripcionTF.setHorizontalAlignment(SwingConstants.CENTER);
		descripcionTF.setColumns(25);
		panel_1.add(descripcionTF);
		
		
		
		JLabel lblNewLabel_3 = new JLabel("Nivel");
		lblNewLabel_3.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_3);

		JFormattedTextField nivelTF = new JFormattedTextField();
		nivelTF.setFont(new Font("Consolas", Font.PLAIN, 20));
		nivelTF.setHorizontalAlignment(SwingConstants.CENTER);
		nivelTF.setColumns(25);
		panel_1.add(nivelTF);

		JLabel lblNewLabel_4 = new JLabel("Horas");
		lblNewLabel_4.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_4);

		JFormattedTextField horasTF = new JFormattedTextField();
		horasTF.setFont(new Font("Consolas", Font.PLAIN, 20));
		horasTF.setHorizontalAlignment(SwingConstants.CENTER);
		horasTF.setColumns(25);
		panel_1.add(horasTF);

		JLabel lblNewLabel_5 = new JLabel("Tipo");
		lblNewLabel_5.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_5);
		
		JFormattedTextField tipoTF = new JFormattedTextField();
		tipoTF.setHorizontalAlignment(SwingConstants.CENTER);
		tipoTF.setFont(new Font("Consolas", Font.PLAIN, 20));
		tipoTF.setColumns(25);
		panel_1.add(tipoTF);
		
		JLabel lblNewLabel_6 = new JLabel("IDEmpresa");
		lblNewLabel_6.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_6);

		JFormattedTextField empTF = new JFormattedTextField();
		empTF.setFont(new Font("Consolas", Font.PLAIN, 20));
		empTF.setHorizontalAlignment(SwingConstants.CENTER);
		empTF.setColumns(3);
		panel_1.add(empTF);
		
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//aqui comprobar cosas aun
				//que todo lo que inserte sea correcto
				try {
					if("".equals(descripcionTF.getText())) {
						throw new Exception("La descripcion debe rellenarse");
					}
					if(!validarNumero(horasTF.getText())) {
						throw new Exception("Las horas deben ser positivo");
					}
					if(!validarNumero(nivelTF.getText())) {
						throw new Exception("El nivel debe ser un número positivo");
					}
					if("".equals(nombreTF.getText())) {
						throw new Exception("El nombre debe rellenarse");
					}
					if("".equals(tipoTF.getText())) {
						throw new Exception("El tipo debe rellenarse");
					}
					String nombre = (String) nombreTF.getText();
					Integer horas = Integer.parseInt(horasTF.getText());
					Integer nivel = Integer.parseInt(nivelTF.getText());
					String descripcion = (String) descripcionTF.getText();
					String tipo = (String) tipoTF.getText();
					Integer idEm= Integer.parseInt(empTF.getText());
					Controller.getInstance().action(
							new Contexto(
								Events.ALTA_CURSO, new TCurso(nombre, true, tipo, descripcion, horas, nivel,idEm)));
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.WARNING_MESSAGE);

				}
				
			}
			
		});
		
	}
	private boolean validarNumero(String n) {
		boolean valido = true;
		try {
			Integer x = Integer.parseInt(n);
			if (x<0) return false;
		}
		catch(Exception ex) {
			valido = false;
		}
		return valido;
	}

}
