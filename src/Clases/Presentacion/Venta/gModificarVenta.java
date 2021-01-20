package Clases.Presentación.Venta;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import Clases.Negocio.Venta.TVenta;
import Clases.Presentación.Contexto;
import Clases.Presentación.Command.Events;
import Clases.Presentación.Controller.Controller;

public class gModificarVenta extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel panelVenta;
	private JTextField direccion, id;
	private JCheckBox activo;
	private JCheckBox estado;
	private JButton btnBuscarID,btnAceptar,btnSalir;
	private JPanel contentPanel;
	public gModificarVenta() {
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
		JLabel lblNewLabel = new JLabel("Modificar Venta");
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
		
		panelVenta = new JPanel();
		panelVenta.setVisible(false);
		panelVenta.setBackground(new Color(32, 178, 170));
		contentPanel.add(panelVenta, BorderLayout.CENTER);
		
		JLabel lblNewLabel_2 = new JLabel("Direcci\u00F3n");
		lblNewLabel_2.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		
		direccion = new JTextField();
		direccion.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Estado");
		lblNewLabel_3.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		
		estado = new JCheckBox();
		estado.setHorizontalAlignment(SwingConstants.CENTER);
		estado.setBackground(new Color(32, 178, 170));
		
		JLabel lblNewLabel_4 = new JLabel("Activo");
		lblNewLabel_4.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		
		activo = new JCheckBox();
		activo.setHorizontalAlignment(SwingConstants.CENTER);
		activo.setBackground(new Color(32, 178, 170));
		GroupLayout gl_panelVenta = new GroupLayout(panelVenta);
		gl_panelVenta.setHorizontalGroup(
			gl_panelVenta.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelVenta.createSequentialGroup()
					.addGap(42)
					.addGroup(gl_panelVenta.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelVenta.createSequentialGroup()
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(estado, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
							.addGap(78)
							.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(activo, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelVenta.createSequentialGroup()
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
							.addGap(32)
							.addComponent(direccion, GroupLayout.PREFERRED_SIZE, 379, GroupLayout.PREFERRED_SIZE)))
					.addGap(328))
		);
		gl_panelVenta.setVerticalGroup(
			gl_panelVenta.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelVenta.createSequentialGroup()
					.addGap(45)
					.addGroup(gl_panelVenta.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
						.addComponent(direccion, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panelVenta.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelVenta.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panelVenta.createSequentialGroup()
								.addGap(52)
								.addComponent(estado)
								.addContainerGap())
							.addGroup(gl_panelVenta.createSequentialGroup()
								.addGap(32)
								.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
								.addContainerGap(195, Short.MAX_VALUE)))
						.addGroup(gl_panelVenta.createSequentialGroup()
							.addGap(40)
							.addGroup(gl_panelVenta.createParallelGroup(Alignment.TRAILING)
								.addComponent(activo, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
							.addGap(203))))
		);
		panelVenta.setLayout(gl_panelVenta);
		
	
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
							Events.MODIFICA_VENTA,_id));
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.WARNING_MESSAGE);

				}
			}
		});
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					if("".equals(direccion.getText())) {
						throw new Exception("La direccion debe rellenarse");
					}
					if(direccion.getText().length()>100) {
						throw new Exception("La direccion supera el maximo de 100 caracteres");
					}
					
					String _direccion = (String) direccion.getText();
					boolean _estado = estado.isSelected();
					boolean act = activo.isSelected();
					Date date = null;
					Controller.getInstance().action(
							new Contexto(
								Events.MODIFICA_VENTA, new TVenta(Integer.parseInt(id.getText()),1,date,999999,_direccion,_estado,act)));
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
	
	public void update(Contexto ctx) {
		TVenta venta = (TVenta)ctx.getData();
		panelVenta.setVisible(true);
		btnAceptar.setEnabled(true);
		direccion.setText(venta.getDireccion());
		estado.setSelected(venta.getEstado());
		activo.setSelected(venta.getActivo());
	}
}

