package Clases.Presentación.Producto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Clases.Negocio.Producto.TProducto;
import Clases.Presentación.Contexto;
import Clases.Presentación.Command.Events;
import Clases.Presentación.Controller.Controller;

public class gAltaProducto extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel contentPanel;
	
	public gAltaProducto() {
		
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
		JLabel lblNewLabel = new JLabel("Alta Producto");
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

		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setFont(new Font("Consolas", Font.PLAIN, 20));
		formattedTextField.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField.setColumns(25);
		panel_1.add(formattedTextField);

		JLabel lblNewLabel_2 = new JLabel("Descripci\u00F3n");
		lblNewLabel_2.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_2);

		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setFont(new Font("Consolas", Font.PLAIN, 20));
		formattedTextField_1.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField_1.setColumns(25);
		panel_1.add(formattedTextField_1);

		JLabel lblNewLabel_3 = new JLabel("Precio");
		lblNewLabel_3.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_3);

		JFormattedTextField formattedTextField_2 = new JFormattedTextField();
		formattedTextField_2.setFont(new Font("Consolas", Font.PLAIN, 20));
		formattedTextField_2.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField_2.setColumns(25);
		panel_1.add(formattedTextField_2);

		JLabel lblNewLabel_4 = new JLabel("Stock");
		lblNewLabel_4.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_4);

		JFormattedTextField formattedTextField_3 = new JFormattedTextField();
		formattedTextField_3.setFont(new Font("Consolas", Font.PLAIN, 20));
		formattedTextField_3.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField_3.setColumns(25);
		panel_1.add(formattedTextField_3);

		JLabel lblNewLabel_5 = new JLabel("Talla");
		lblNewLabel_5.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_5);
		JComboBox<String> comboTalla = new JComboBox<String>();
		comboTalla.addItem("Niño");
		comboTalla.addItem("Adulto");
		panel_1.add(comboTalla);
		
		JLabel lblNewLabel_6 = new JLabel("Marca");
		lblNewLabel_6.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_6);

		JFormattedTextField formattedTextField_4 = new JFormattedTextField();
		formattedTextField_4.setFont(new Font("Consolas", Font.PLAIN, 20));
		formattedTextField_4.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField_4.setColumns(25);
		panel_1.add(formattedTextField_4);

		
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//aqui comprobar cosas aun
				//que todo lo que inserte sea correcto
				//
				try {
					if("".equals(formattedTextField.getText())) {
						throw new Exception("El nombre debe rellenarse");
					}
					if(formattedTextField.getText().length()>100) {
						throw new Exception("El nombre supera el maximo de 100 caracteres");
					}
					if("".equals(formattedTextField_1.getText())) {
						throw new Exception("La descripción debe rellenarse");
					}
					if(formattedTextField_1.getText().length()>140) {
						throw new Exception("La descripcion supera el maximo de 140 caracteres");
					}
					if("".equals(formattedTextField_2.getText())) {
						throw new Exception("El precio debe rellenarse");
					}
					if("".equals(formattedTextField_3.getText())) {
						throw new Exception("El stock debe rellenarse");
					}
					if("".equals(formattedTextField_4.getText())) {
						throw new Exception("La marca debe rellenarse");
					}
					if(!validarPrecio(formattedTextField_2.getText())) {
						throw new Exception("El precio debe ser un numero");
					}
					if (!formattedTextField_3.getText().matches("\\-?\\d+")) {
						throw new NumberFormatException("El stock debe ser un número");
					}
					if (!formattedTextField_4.getText().matches("\\-?\\d*")) {
						throw new NumberFormatException("La marca debe ser un número");
					}
				
					String nombre = (String) formattedTextField.getText();
					String descripcion = (String) formattedTextField_1.getText();
					float precio = Float.parseFloat(formattedTextField_2.getText());
					if(precio <= 0) {
						throw new NumberFormatException("El precio debe ser positivo");
					}
					int stock = Integer.parseInt(formattedTextField_3.getText());
					if(stock < 0) {
						throw new NumberFormatException("El stock debe ser positivo");
					}
					String talla = (String)comboTalla.getSelectedItem();
					int marca = (int) Integer.parseInt(formattedTextField_4.getText());
					if(marca < 0) {
						throw new NumberFormatException("La marca debe ser positivo");
					}
					Controller.getInstance().action(
							new Contexto(
								Events.ALTA_PRODUCTO, new TProducto(nombre,descripcion,precio,talla,stock,marca,true)));
				}
				catch(Exception es) {
					if(es.getClass().equals(NumberFormatException.class)) {
						JOptionPane.showMessageDialog(null, es.getMessage(),"ERROR",JOptionPane.WARNING_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(null, es.getMessage(),"ERROR",JOptionPane.WARNING_MESSAGE);
					}
				}
				
			}
			
		});
		
	}
	private boolean validarPrecio(String precio) {
		boolean valido = true;
		try {
			Float.parseFloat(precio);
		}
		catch(Exception ex) {
			valido = false;
		}
		return valido;
	}
}
