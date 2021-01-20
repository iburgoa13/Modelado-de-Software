package Clases.Presentación.Empresa;

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

import Clases.Negocio.Empresa.TEmpresa;
import Clases.Negocio.Marca.TMarca;
import Clases.Presentación.Contexto;
import Clases.Presentación.Command.Events;
import Clases.Presentación.Controller.Controller;

public class gAltaEmpresa extends JFrame{

	private static final long serialVersionUID = 1L;

	private JPanel contentPanel;
	public gAltaEmpresa() {
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
		JLabel lblNewLabel = new JLabel("Alta Empresa");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Consolas", Font.PLAIN, 32));
		contentPanel.add(lblNewLabel, BorderLayout.NORTH);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(32, 178, 170));
		contentPanel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(6, 4, 10, 30));

		JLabel lblNewLabel_1 = new JLabel("Sector");
		lblNewLabel_1.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_1);

		JFormattedTextField sectorTF = new JFormattedTextField();
		sectorTF.setFont(new Font("Consolas", Font.PLAIN, 20));
		sectorTF.setHorizontalAlignment(SwingConstants.CENTER);
		sectorTF.setColumns(25);
		panel_1.add(sectorTF);

		JLabel lblNewLabel_2 = new JLabel("CIF");
		lblNewLabel_2.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_2);

		JFormattedTextField cifTF = new JFormattedTextField();
		cifTF.setFont(new Font("Consolas", Font.PLAIN, 20));
		cifTF.setHorizontalAlignment(SwingConstants.CENTER);
		cifTF.setColumns(25);
		panel_1.add(cifTF);
		
		
		
		JLabel lblNewLabel_3 = new JLabel("Tel\u00E9fono");
		lblNewLabel_3.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_3);

		JFormattedTextField telefonoTF = new JFormattedTextField();
		telefonoTF.setFont(new Font("Consolas", Font.PLAIN, 20));
		telefonoTF.setHorizontalAlignment(SwingConstants.CENTER);
		telefonoTF.setColumns(25);
		panel_1.add(telefonoTF);

		JLabel lblNewLabel_4 = new JLabel("Nombre");
		lblNewLabel_4.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_4);

		JFormattedTextField nombreTF = new JFormattedTextField();
		nombreTF.setFont(new Font("Consolas", Font.PLAIN, 20));
		nombreTF.setHorizontalAlignment(SwingConstants.CENTER);
		nombreTF.setColumns(25);
		panel_1.add(nombreTF);

		JLabel lblNewLabel_5 = new JLabel("Correo");
		lblNewLabel_5.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_5);
		
		JFormattedTextField correoTF = new JFormattedTextField();
		correoTF.setHorizontalAlignment(SwingConstants.CENTER);
		correoTF.setFont(new Font("Consolas", Font.PLAIN, 20));
		correoTF.setColumns(25);
		panel_1.add(correoTF);
		
		JLabel lblNewLabel_6 = new JLabel("Direccion");
		lblNewLabel_6.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_6);
		
		JFormattedTextField direccionTF = new JFormattedTextField();
		direccionTF.setHorizontalAlignment(SwingConstants.CENTER);
		direccionTF.setFont(new Font("Consolas", Font.PLAIN, 20));
		direccionTF.setColumns(25);
		panel_1.add(direccionTF);

		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//aqui comprobar cosas aun
				//que todo lo que inserte sea correcto
				try {
					if("".equals(sectorTF.getText())){
						throw new Exception("El sector debe rellenarse");
					}
					if("".equals(cifTF.getText())) {
						throw new Exception("El CIF debe rellenarse");
					}
					if(!validarNumero(telefonoTF.getText())) {
						throw new Exception("El telefono deben ser 9 digitos");
					}
					if("".equals(nombreTF.getText())) {
						throw new Exception("El nombre debe rellenarse");
					}
					if("".equals(correoTF.getText())) {
						throw new Exception("El correo debe rellenarse");
					}
					if("".equals(direccionTF.getText())) {
						throw new Exception("La direccion debe rellenarse");
					}
					
					String nombre = (String) nombreTF.getText();
					String direccion = (String) direccionTF.getText();
					Long telefono = Long.parseLong(telefonoTF.getText());
					String sector = (String) sectorTF.getText();
					String correo = (String) correoTF.getText();
					String cif = (String) cifTF.getText();
					Controller.getInstance().action(
							new Contexto(
								Events.ALTA_EMPRESA, new TEmpresa(sector, true, cif, nombre, direccion, telefono, correo)));
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
			Long tlf = Long.parseLong(n);
			if (tlf<0) return false;
		}
		catch(Exception ex) {
			valido = false;
		}
		return valido;
	}

}
