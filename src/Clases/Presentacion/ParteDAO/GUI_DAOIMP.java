package Clases.Presentación.ParteDAO;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Clases.Presentación.Contexto;
import Clases.Presentación.Command.Events;
import Clases.Presentación.Controller.Controller;

public class GUI_DAOIMP extends GUI_DAO {

	private static final long serialVersionUID = 1L;

	public GUI_DAOIMP() {
		initialize();
	}

	private JPanel contentPane;

	@Override
	public void initialize() {
		this.setVisible(true);
		this.setTitle("Parte DAO - VIEW");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(32, 178, 170));
		contentPane.setForeground(new Color(32, 178, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 100));

		JLabel lblTITULOVENTAS = new JLabel("DAO");
		lblTITULOVENTAS.setForeground(new Color(255, 255, 255));
		lblTITULOVENTAS.setFont(new Font("Consolas", Font.PLAIN, 32));
		lblTITULOVENTAS.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTITULOVENTAS, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(32, 178, 170));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(1, 4, 15, 50));

		JButton btnMarca = new JButton("MARCA");
		btnMarca.setFont(new Font("Consolas", Font.PLAIN, 22));
		panel.add(btnMarca);

		JButton btnProducto = new JButton("PRODUCTO");
		btnProducto.setFont(new Font("Consolas", Font.PLAIN, 22));
		panel.add(btnProducto);

		JButton btnVenta = new JButton("VENTA");
		btnVenta.setFont(new Font("Consolas", Font.PLAIN, 22));
		panel.add(btnVenta);

		JButton btnCliente = new JButton("CLIENTE");
		btnCliente.setFont(new Font("Consolas", Font.PLAIN, 22));
		panel.add(btnCliente);

		JPanel panelSalida = new JPanel();
		contentPane.add(panelSalida, BorderLayout.SOUTH);
		panelSalida.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 40));

		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Consolas", Font.PLAIN, 24));
		panelSalida.add(btnSalir);

		btnMarca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Controller.getInstance().action(new Contexto(Events.GUI_Marca, null));
			}
		});
		btnProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Controller.getInstance().action(new Contexto(Events.GUI_Producto, null));
			}
		});
		btnVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Controller.getInstance().action(new Contexto(Events.GUI_Ventas, null));
			}
		});
		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Controller.getInstance().action(new Contexto(Events.GUI_Cliente, null));
			}
		});

		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});

	}

}
