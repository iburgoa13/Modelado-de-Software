package Clases.Presentación.Producto;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Clases.Negocio.Producto.TProducto;
import Clases.Presentación.Contexto;
import Clases.Presentación.Command.Events;
import Clases.Presentación.Controller.Controller;
public class gMostrarProductos extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPanel;
	
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

		JButton btnSalir = new JButton("SALIR");
		btnSalir.setFont(new Font("Consolas", Font.PLAIN, 32));
		panel.add(btnSalir);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		JLabel lblNewLabel = new JLabel("Mostrar todos los productos");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Consolas", Font.PLAIN, 32));
		contentPanel.add(lblNewLabel, BorderLayout.NORTH);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(32, 178, 170));
		contentPanel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(6, 4, 10, 30));	
		
		Controller.getInstance().action(
				new Contexto(Events.MOSTRAR_PRODUCTOS, null));
	
			
			
	}
		
	public void update(Contexto context) {
		
		 String [] columnas = { "Identificador", "Nombre", "Descripcion", "Precio", "Talla", "Stock", "Marca", "Activo"}; 
		 DefaultTableModel tableModel = new DefaultTableModel(columnas, 0);
		 
		
		 int id, marca, stock;
		 float precio;
		 String nombre, descripcion, talla, activo;
		 
		 @SuppressWarnings("unchecked")
		List<TProducto> prod = (List<TProducto>)context.getData();
		 for(int i = 0; i<prod.size(); i++) {
			id = prod.get(i).getId();
			nombre = prod.get(i).getNombre();
			descripcion = prod.get(i).getDescripcion();
			precio = prod.get(i).getPrecio();
			talla = prod.get(i).getTalla();
			stock = prod.get(i).getStock();
			marca = prod.get(i).getMarca();
			activo = prod.get(i).getActivo() ? "ACTIVO" : "NO ACTIVO";
			Object[] objs = {id, nombre, descripcion, precio, talla, stock, marca, activo};  tableModel.addRow(objs);
		}
		 	
	 	
          	JTable Table = new JTable (tableModel);
          	Table.setEnabled(false);
          	JScrollPane scroll = new JScrollPane(Table);
		 	contentPanel.add(scroll);
	}
}
	
