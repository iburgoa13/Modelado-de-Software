package Clases.Presentación.Venta;

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

import Clases.Negocio.Venta.TOAVenta;
import Clases.Negocio.Venta.TVenta;

public class gInsertarProductoVenta extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel contentPanel;
	private TVenta ventaActual;
	
	public gInsertarProductoVenta() {
		//init(ventaActual);
	}
	public void init(TVenta ventaActual) {
		if(ventaActual==null) {
			JOptionPane.showMessageDialog(null, "Debe abrir una venta antes","ERROR",JOptionPane.WARNING_MESSAGE);
			return;
		}
		this.ventaActual=ventaActual;
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
		JLabel lblNewLabel = new JLabel("Insertar producto en la venta actual");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Consolas", Font.PLAIN, 32));
		contentPanel.add(lblNewLabel, BorderLayout.NORTH);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(32, 178, 170));
		contentPanel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 2, 10, 100));

		JLabel lblNewLabel_1 = new JLabel("ID del producto");
		lblNewLabel_1.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_1);

		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setFont(new Font("Consolas", Font.PLAIN, 20));
		formattedTextField.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField.setColumns(25);
		panel_1.add(formattedTextField);

		JLabel lblNewLabel_2 = new JLabel("Unidades del producto");
		lblNewLabel_2.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_2);

		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setFont(new Font("Consolas", Font.PLAIN, 20));
		formattedTextField_1.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField_1.setColumns(25);
		panel_1.add(formattedTextField_1);

		
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//
				try {
					
					int idProducto = (Integer.parseInt(formattedTextField.getText()));
					if(idProducto < 0) {
						throw new NumberFormatException("El id del producto debe ser positivo");
					}
					int cantidad = (Integer.parseInt(formattedTextField_1.getText()));
					if(cantidad < 0) {
						throw new NumberFormatException("La cantidad debe ser positiva");
					}
					float precio = 0;
					
					//ventaActual.setImporte(ventaActual.getImporte()+ (cantidad*precio));
					TOAVenta linea = ventaActual.getCarrito().get(idProducto);
					if(linea==null)
						ventaActual.getCarrito().put(idProducto, new TOAVenta(cantidad,idProducto,precio));
					else
						linea.setCantidad(linea.getCantidad()+cantidad);
					
					JOptionPane.showMessageDialog(null, "Insertado, las comprobaciones se haran mas adelante","EXITO",JOptionPane.WARNING_MESSAGE);
					dispose();
				}
				catch(Exception es) {
					JOptionPane.showMessageDialog(null, es.getMessage(),"ERROR",JOptionPane.WARNING_MESSAGE);
				}
				
				
			}
			
		});
		
	}
}
