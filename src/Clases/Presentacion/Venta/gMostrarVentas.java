package Clases.Presentación.Venta;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
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

import Clases.Negocio.Venta.TVenta;
import Clases.Presentación.Contexto;
import Clases.Presentación.Command.Events;
import Clases.Presentación.Controller.Controller;

public class gMostrarVentas extends JFrame {
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
		JLabel lblNewLabel = new JLabel("Mostrar todas las ventas");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Consolas", Font.PLAIN, 32));
		contentPanel.add(lblNewLabel, BorderLayout.NORTH);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(32, 178, 170));
		contentPanel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(6, 4, 10, 30));	
		
		Controller.getInstance().action(
				new Contexto(Events.MOSTRAR_VENTAS, null));
	
			
			
	}
		
	public void update(Contexto context) {
		 String [] columnas = { "Identificador", "Identificador Cliente", "Fecha", "Precio", "Direccion", "Estado", "Activo"}; 
		 DefaultTableModel tableModel = new DefaultTableModel(columnas, 0);
		 
		
		 int id, idCliente;
		 float precio;
		 Date fecha;
		String direccion, estado, activo;
		 
		 List<TVenta> vent = (List<TVenta>)context.getData();
		 for(int i = 0; i<vent.size(); i++) {
			id = vent.get(i).getId();
			idCliente = vent.get(i).getIdCliente();
			fecha = vent.get(i).getFecha();
			direccion = vent.get(i).getDireccion();
			precio = vent.get(i).getImporte();
			activo = vent.get(i).getActivo() ? "ACTIVO" : "NO ACTIVO";
			estado = vent.get(i).getEstado() ? "ENTREGADO" : "NO ENTREGADO";
			Object[] objs = {id, idCliente, fecha, precio,direccion, estado, activo};  tableModel.addRow(objs);
		}
		 	
	 	
          	JTable Table = new JTable (tableModel);
          	Table.setEnabled(false);
          	JScrollPane scroll = new JScrollPane(Table);
		 	contentPanel.add(scroll);
	}
}
