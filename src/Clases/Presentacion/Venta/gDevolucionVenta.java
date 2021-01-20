package Clases.Presentación.Venta;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

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

import Clases.Negocio.Venta.TDevolucion;
import Clases.Negocio.Venta.TOAVenta;
import Clases.Negocio.Venta.TVenta;
import Clases.Presentación.Contexto;
import Clases.Presentación.Command.Events;
import Clases.Presentación.Controller.Controller;

public class gDevolucionVenta extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPanel;
	private TDevolucion devolucion = null;
	
	public gDevolucionVenta() {
		//init();
	}
	
	public void update(Contexto contexto) {
		TVenta venta = (TVenta)contexto.getData();

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
		
		JLabel lblNewLabel = new JLabel("Mostrar Venta");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Consolas", Font.PLAIN, 32));
		contentPanel.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel_central = new JPanel();
		contentPanel.add(panel_central, BorderLayout.CENTER);
		panel_central.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(32, 178, 170));
		panel_central.add(panel_1);
		panel_1.setLayout(new GridLayout(4, 4, 10, 30));
		
		JLabel lblNewLabel__ID = new JLabel("Identificador");
		lblNewLabel__ID.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel__ID.setFont(new Font("Consolas", Font.PLAIN, 20));
		panel_1.add(lblNewLabel__ID);
		
		JFormattedTextField formattedTextField_ID = new JFormattedTextField();
		formattedTextField_ID.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField_ID.setFont(new Font("Consolas", Font.PLAIN, 20));
		formattedTextField_ID.setEditable(false);
		formattedTextField_ID.setColumns(25);
		if(venta.getId()!=null) formattedTextField_ID.setValue(venta.getId());
		else formattedTextField_ID.setValue("No se ha dado de alta");
		formattedTextField_ID.setEditable(false);
		panel_1.add(formattedTextField_ID);
		
		JLabel lblNewLabel_1 = new JLabel("Importe");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Consolas", Font.PLAIN, 20));
		panel_1.add(lblNewLabel_1);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField.setFont(new Font("Consolas", Font.PLAIN, 20));
		formattedTextField.setEditable(false);
		formattedTextField.setColumns(25);
		formattedTextField.setValue(venta.getImporte());
		formattedTextField.setEditable(false);
		panel_1.add(formattedTextField);
		
		JLabel lblNewLabel_2 = new JLabel("Fecha");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Consolas", Font.PLAIN, 20));
		panel_1.add(lblNewLabel_2);
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField_1.setFont(new Font("Consolas", Font.PLAIN, 20));
		formattedTextField_1.setEditable(false);
		formattedTextField_1.setColumns(25);
		formattedTextField_1.setValue(venta.getFecha());
		formattedTextField_1.setEditable(false);
		panel_1.add(formattedTextField_1);
		
		JLabel lblNewLabel_3 = new JLabel("idCliente");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Consolas", Font.PLAIN, 20));
		panel_1.add(lblNewLabel_3);
		
		JFormattedTextField formattedTextField_2 = new JFormattedTextField();
		formattedTextField_2.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField_2.setFont(new Font("Consolas", Font.PLAIN, 20));
		formattedTextField_2.setEditable(false);
		formattedTextField_2.setColumns(25);
		formattedTextField_2.setEditable(false);
		formattedTextField_2.setValue(venta.getIdCliente());
		panel_1.add(formattedTextField_2);
		
		JLabel lblNewLabel_4 = new JLabel("Direccion");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Consolas", Font.PLAIN, 20));
		panel_1.add(lblNewLabel_4);
		
		JFormattedTextField formattedTextField_3 = new JFormattedTextField();
		formattedTextField_3.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField_3.setFont(new Font("Consolas", Font.PLAIN, 20));
		formattedTextField_3.setEditable(false);
		formattedTextField_3.setColumns(25);
		formattedTextField_3.setEditable(false);
		if(venta.getDireccion()!=null) formattedTextField_3.setValue(venta.getDireccion());
		else formattedTextField_3.setValue("No se ha dado de alta");
		panel_1.add(formattedTextField_3);
		
		JLabel lblNewLabel_5 = new JLabel("Estado");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Consolas", Font.PLAIN, 20));
		panel_1.add(lblNewLabel_5);
		
		JFormattedTextField formattedTextField_Tele = new JFormattedTextField();
		formattedTextField_Tele.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField_Tele.setFont(new Font("Consolas", Font.PLAIN, 20));
		formattedTextField_Tele.setEditable(false);
		formattedTextField_Tele.setColumns(25);
		formattedTextField_Tele.setEditable(false);
		formattedTextField_Tele.setValue(venta.getEstado()? "ENTREGADO":"NO ENTREGADO");
		panel_1.add(formattedTextField_Tele);
		
		JLabel lblNewLabel_7 = new JLabel("Activo");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Consolas", Font.PLAIN, 20));
		panel_1.add(lblNewLabel_7);
		
		JFormattedTextField formattedTextField_AC = new JFormattedTextField();
		formattedTextField_AC.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField_AC.setFont(new Font("Consolas", Font.PLAIN, 20));
		formattedTextField_AC.setEditable(false);
		formattedTextField_AC.setColumns(25);
		formattedTextField_AC.setEditable(false);
		if(venta.getActivo()!=null)formattedTextField_AC.setValue(venta.getActivo()? "ACTIVO":"NO ACTIVO");
		else formattedTextField_AC.setValue("No se ha dado de alta");
		panel_1.add(formattedTextField_AC);
		
		String [] columnas = { "ID producto", "Cantidad", "Precio unitario", "Precio total"}; 
		 DefaultTableModel tableModel = new DefaultTableModel(columnas, 0);
		 
		
		 int id, cantidad;
		 float precio;
		 
		HashMap<Integer, TOAVenta> carrito = venta.getCarrito();
		Collection<TOAVenta> collectionLineasDeVenta = carrito.values();
		Iterator<TOAVenta> it = collectionLineasDeVenta.iterator();
		TOAVenta linea;
		 while(it.hasNext()) {
			linea = it.next();
			id = linea.getIdProducto();
			cantidad=linea.getCantidad();
			precio=linea.getPrecio();
			
			Object[] objs = {id, cantidad, precio, precio*cantidad};  tableModel.addRow(objs);
		}
		 	
        	JTable Table = new JTable (tableModel);
        	Table.setEnabled(false);
        	JScrollPane scroll = new JScrollPane(Table);
        
		 	panel_central.add(scroll);
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
		JLabel lblNewLabel = new JLabel("Hacer devolución de una venta");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Consolas", Font.PLAIN, 32));
		contentPanel.add(lblNewLabel, BorderLayout.NORTH);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(32, 178, 170));
		contentPanel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(6, 4, 10, 30));

		JLabel lblNewLabel_1 = new JLabel("Identificador de la venta");
		lblNewLabel_1.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_1);

		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		
		formattedTextField_1.setFont(new Font("Consolas", Font.PLAIN, 20));
		formattedTextField_1.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField_1.setColumns(25);
		panel_1.add(formattedTextField_1);
		
		JLabel lblNewLabel_2 = new JLabel("Identificador del producto");
		lblNewLabel_2.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_2);

		JFormattedTextField formattedTextField_2 = new JFormattedTextField();
		
		formattedTextField_2.setFont(new Font("Consolas", Font.PLAIN, 20));
		formattedTextField_2.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField_2.setColumns(25);
		panel_1.add(formattedTextField_2);
		
		JLabel lblNewLabel_3 = new JLabel("Cantidad del producto para devolver");
		lblNewLabel_3.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_3);

		JFormattedTextField formattedTextField_3 = new JFormattedTextField();
		
		formattedTextField_3.setFont(new Font("Consolas", Font.PLAIN, 20));
		formattedTextField_3.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField_3.setColumns(25);
		panel_1.add(formattedTextField_3);
		
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int idVenta = Integer.parseInt(formattedTextField_1.getText());
					
					int idProd = Integer.parseInt(formattedTextField_2.getText());
					if(idProd < 0) {
						throw new NumberFormatException("El id del producto debe ser positivo");
					}
					
					int cantProd = Integer.parseInt(formattedTextField_3.getText());
					if(cantProd < 0) {
						throw new NumberFormatException("La cantidad debe ser positiva");
					}
					
					devolucion = new TDevolucion(idVenta, idProd, cantProd);
					
					
					Controller.getInstance().action(new Contexto(Events.DEVOLUCION_VENTA, devolucion));
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Inserte un número por favor","ERROR",JOptionPane.WARNING_MESSAGE);
				}
				}
		});
	}
}
