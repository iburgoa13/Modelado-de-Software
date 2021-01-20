package Clases.Presentación.Producto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Clases.Negocio.Producto.TProducto;
import Clases.Presentación.Contexto;
import Clases.Presentación.Command.Events;
import Clases.Presentación.Controller.Controller;

public class gUpdateProducto extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel panelProducto;
	private JTextField nombre, descripcion,precio,stock,marca,id;
	private JComboBox<String> talla;
	private JCheckBox activo;
	private JButton btnBuscarID,btnAceptar,btnSalir;
	private JPanel contentPanel;
	public gUpdateProducto() {
		
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
		panel.setForeground(new Color(32, 178, 170));
		contentPanel.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		
		JPanel btnera = new JPanel();
		contentPanel.add(btnera, BorderLayout.SOUTH);
		btnera.setLayout(new GridLayout(1, 2, 0, 0)); 
		
		btnAceptar = new JButton("Modificar");
		btnAceptar.setForeground(new Color(0, 0, 0));
		btnAceptar.setFont(new Font("Consolas", Font.PLAIN, 32));
		btnera.add(btnAceptar);

		
		
		
		btnSalir = new JButton("SALIR");
		btnSalir.setFont(new Font("Consolas", Font.PLAIN, 32));
		btnera.add(btnSalir);
		btnAceptar.setEnabled(false);
		JLabel lblNewLabel = new JLabel("Modificar Producto");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Consolas", Font.PLAIN, 32));
		panel.add(lblNewLabel, BorderLayout.NORTH);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(32, 178, 170));
		panel_1.setForeground(new Color(32, 178, 170));
		panel.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		
		JLabel lblNewLabel_1_ID = new JLabel("Insert un ID, por favor: ");
		lblNewLabel_1_ID.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNewLabel_1_ID.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_1_ID);

		id = new JFormattedTextField();
		id.setFont(new Font("Consolas", Font.PLAIN, 20));
		id.setHorizontalAlignment(SwingConstants.CENTER);
		id.setColumns(5);
		panel_1.add(id); 
		
		btnBuscarID = new JButton("Buscar");
		panel_1.add(btnBuscarID); 
		
		panelProducto = new JPanel();
		panelProducto.setVisible(false);
		panelProducto.setBackground(new Color(32, 178, 170));
		panelProducto.setLayout(new GridLayout(8, 4, 25, 25));
		contentPanel.add(panelProducto, BorderLayout.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panelProducto.add(lblNewLabel_1);
		
		nombre = new JTextField();
		nombre.setColumns(10);
		panelProducto.add(nombre);
		
		JLabel lblNewLabel_2 = new JLabel("Descripci\u00F3n");
		lblNewLabel_2.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panelProducto.add(lblNewLabel_2);
		
		descripcion = new JTextField();
		descripcion.setColumns(10);
		panelProducto.add(descripcion);
		
		JLabel lblNewLabel_3 = new JLabel("Precio");
		lblNewLabel_3.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panelProducto.add(lblNewLabel_3);
		
		precio = new JTextField();
		precio.setColumns(10);
		panelProducto.add(precio);
		
		JLabel lblNewLabel_4 = new JLabel("Stock");
		lblNewLabel_4.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panelProducto.add(lblNewLabel_4);
		
		stock = new JTextField();
		stock.setColumns(10);
		panelProducto.add(stock);
		
		JLabel lblNewLabel_5 = new JLabel("Talla");
		lblNewLabel_5.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panelProducto.add(lblNewLabel_5);
		talla = new JComboBox<String>();
		talla.addItem("Niño");
		talla.addItem("Adulto");
		panelProducto.add(talla);
		
		
		JLabel lblNewLabel_6 = new JLabel("Marca");
		lblNewLabel_6.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		panelProducto.add(lblNewLabel_6);
		
		marca = new JTextField();
		marca.setColumns(10);
		panelProducto.add(marca);
		
		JLabel lblNewLabel_7 = new JLabel("Activo");
		lblNewLabel_7.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		panelProducto.add(lblNewLabel_7);
		
		activo = new JCheckBox();
		activo.setBackground(new Color(32, 178, 170));
		panelProducto.add(activo);
		
	
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		
		btnBuscarID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if("".equals(id.getText())) {
						throw new Exception("El ID debe rellenarse");
					}
					if (!id.getText().matches("\\-?\\d+")) {
						throw new NumberFormatException("El ID debe ser un número");
					}
					int _id = Integer.parseInt(id.getText());
					if(_id<0) {
						throw new NumberFormatException("El ID debe ser positivo");
					}
					Controller.getInstance().action(new Contexto(
							Events.MODIFICA_PRODUCTO,_id));
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.WARNING_MESSAGE);

				}
			}
		});
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					if("".equals(nombre.getText())) {
						throw new Exception("El nombre debe rellenarse");
					}
					if(nombre.getText().length()>100) {
						throw new Exception("El nombre supera el maximo de 100 caracteres");
					}
					if("".equals(descripcion.getText())) {
						throw new Exception("La descripción debe rellenarse");
					}
					if(descripcion.getText().length()>140) {
						throw new Exception("La descripcion supera el maximo de 140 caracteres");
					}
					if("".equals(precio.getText())) {
						throw new Exception("El precio debe rellenarse");
					}
					if(!validarPrecio()) {
						throw new Exception("El precio debe ser un numero");
					}
					if("".equals(stock.getText())) {
						throw new Exception("El stock debe rellenarse");
					}
					if (!stock.getText().matches("\\-?\\d+")) {
						throw new NumberFormatException("El stock debe ser un número");
					}
					if("".equals(marca.getText())) {
						throw new Exception("La marca debe rellenarse");
					}
					if (!marca.getText().matches("\\-?\\d*")) {
						throw new NumberFormatException("La marca debe ser un número");
					}
					String _nombre = (String) nombre.getText();
					String _descripcion = (String) descripcion.getText();
					float _precio = Float.parseFloat(precio.getText());
					if(_precio < 0) {
						throw new NumberFormatException("El precio debe ser positivo");
					}
					int _stock = Integer.parseInt(stock.getText());
					if(_stock < 0) {
						throw new NumberFormatException("El stock debe ser positivo");
					}
					String _talla = (String)talla.getSelectedItem();
					int _marca = (int) Integer.parseInt(marca.getText());
					if(_marca < 0) {
						throw new NumberFormatException("La marca debe ser positivo");
					}
					
					boolean act = activo.isSelected();
					
					Controller.getInstance().action(
							new Contexto(
								Events.MODIFICA_PRODUCTO, new TProducto(Integer.parseInt(id.getText()),_nombre,_descripcion,_precio,_talla,_stock,_marca,act)));
					dispose();
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
	private boolean validarPrecio() {
		boolean valido = true;
		try {
			Float.parseFloat(precio.getText());
		}
		catch(Exception ex) {
			valido = false;
		}
		return valido;
	}
	public void update(Contexto ctx) {
		TProducto producto = (TProducto)ctx.getData();
		panelProducto.setVisible(true);
		btnAceptar.setEnabled(true);
		nombre.setText(producto.getNombre());
		descripcion.setText(producto.getDescripcion());
		precio.setText((String)producto.getPrecio().toString());
		stock.setText(producto.getStock().toString());
		marca.setText(producto.getMarca().toString());
		activo.setSelected(producto.getActivo());
		talla.setSelectedItem(producto.getTalla());
		
	}
}
