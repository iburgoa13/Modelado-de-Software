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

public class gAltaDepartamento extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel contentPanel;
	
	public gAltaDepartamento() {
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
		
		JLabel lblNewLabel = new JLabel("Alta Departamento");
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
		
		JFormattedTextField sectorNombre = new JFormattedTextField();
		sectorNombre.setFont(new Font("Consolas", Font.PLAIN, 20));
		sectorNombre.setHorizontalAlignment(SwingConstants.CENTER);
		sectorNombre.setColumns(25);
		panel_1.add(sectorNombre);
		
		JLabel lblNewLabel_2 = new JLabel("Correo");
		lblNewLabel_2.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_2);

		JFormattedTextField sectorCorreo = new JFormattedTextField();
		sectorCorreo.setFont(new Font("Consolas", Font.PLAIN, 20));
		sectorCorreo.setHorizontalAlignment(SwingConstants.CENTER);
		sectorCorreo.setColumns(25);
		panel_1.add(sectorCorreo);
		
		JLabel lblNewLabel_3 = new JLabel("Tel\u00E9fono");
		lblNewLabel_3.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_3);

		JFormattedTextField sectorTelefono = new JFormattedTextField();
		sectorTelefono.setFont(new Font("Consolas", Font.PLAIN, 20));
		sectorTelefono.setHorizontalAlignment(SwingConstants.CENTER);
		sectorTelefono.setColumns(25);
		panel_1.add(sectorTelefono);
		
		JLabel lblNewLabel_4 = new JLabel("Ubicacion");
		lblNewLabel_4.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_4);

		JFormattedTextField sectorUbicacion = new JFormattedTextField();
		sectorUbicacion.setFont(new Font("Consolas", Font.PLAIN, 20));
		sectorUbicacion.setHorizontalAlignment(SwingConstants.CENTER);
		sectorUbicacion.setColumns(25);
		panel_1.add(sectorUbicacion);
		
		
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//aqui comprobar cosas aun
				//que todo lo que inserte sea correcto
				try {
					if("".equals(sectorNombre.getText())){
						throw new Exception("El nombre debe rellenarse");
					}
					if("".equals(sectorCorreo.getText())) {
						throw new Exception("El correo debe rellenarse");
					}
					if("".equals(sectorTelefono.getText())) {
						throw new Exception("El telefono debe rellenarse");
					}
					if(!validarNumero(sectorTelefono.getText())) {
						throw new Exception("El telefono debe ser un número");
					}
					if("".equals(sectorUbicacion.getText())) {
						throw new Exception("La ubicacion debe rellenarse");
					}
					
					
					String nombre = (String) sectorNombre.getText();
					String ubicacion = (String) sectorUbicacion.getText();
					Long telefono = Long.parseLong(sectorTelefono.getText());
					String correo = (String) sectorCorreo.getText();
					
					Controller.getInstance().action(
							new Contexto(                
								Events.ALTA_DEPARTAMENTO, new TDepartamento(nombre, true, correo, ubicacion,  telefono)));
					
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
