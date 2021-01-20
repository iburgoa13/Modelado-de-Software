package Clases.Presentación.Venta;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Clases.Negocio.Venta.TVenta;
import Clases.Presentación.Contexto;
import Clases.Presentación.Command.Events;

public class GUIVentaIMP extends GUIVenta {
	
	private TVenta ventaActual;
	private gAbrirVenta _abrirVenta;
	private gBajaVenta _bajaVenta;
	private gInsertarProductoVenta _insertarProductoVenta;
	private gBorrarProductoVenta _borrarProductoVenta;
	private gRealizarVenta _realizarVenta;
	private gMostrarVenta _mostrarVenta;
	private gMostrarVentas _mostrarVentas;
	private gDevolucionVenta _devolucionVenta;
	private gModificarVenta _modificarVenta;

	private JPanel contentPane;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton _btnBajaVenta;

	public GUIVentaIMP() {
		initialize();
		init();
	}

	private void init() {
		_abrirVenta = new gAbrirVenta();
		_bajaVenta = new gBajaVenta();
		_insertarProductoVenta =new gInsertarProductoVenta();
		_borrarProductoVenta = new gBorrarProductoVenta();
		_realizarVenta = new gRealizarVenta();
		_mostrarVenta = new gMostrarVenta();
		_mostrarVentas = new gMostrarVentas();
		_devolucionVenta = new gDevolucionVenta();
		_modificarVenta = new gModificarVenta();
	}

	@Override
	public void update(Contexto context) {
		
		switch(context.getEvent()) {
			case Events.ABRIR_VENTA_OK:
				JOptionPane.showMessageDialog(null, "Se abrira una venta para el cliente con id "+ context.getData(),"EXITO", JOptionPane.INFORMATION_MESSAGE);
				ventaActual = new TVenta();
				ventaActual.setIdCliente((int)context.getData());
				break;
			case Events.ABRIR_VENTA_KO:
				if((int) context.getData()==-3)
					JOptionPane.showMessageDialog(null, "No existe ese cliente","ERROR", JOptionPane.INFORMATION_MESSAGE);
				else
					JOptionPane.showMessageDialog(null, "Error "+context.getData(),"ERROR", JOptionPane.INFORMATION_MESSAGE);
				break;
			case Events.REALIZAR_VENTA_OK:
				JOptionPane.showMessageDialog(null, "Se ha realizado la venta con exito, con id: "+ context.getData(),"EXITO", JOptionPane.INFORMATION_MESSAGE);
				ventaActual = new TVenta();
				break;
			case Events.REALIZAR_VENTA_KO:
				if((int) context.getData()==-3)
					JOptionPane.showMessageDialog(null, "No existe ese cliente","ERROR", JOptionPane.INFORMATION_MESSAGE);
				else if((int) context.getData()==-5)
					JOptionPane.showMessageDialog(null, "No existe un producto, no se puede realizar la venta","ERROR", JOptionPane.INFORMATION_MESSAGE);
				else if((int) context.getData()==-11)
					JOptionPane.showMessageDialog(null, "El carrito esta vacio (se creo vacio o no hay stock de ningun producto)","ERROR", JOptionPane.INFORMATION_MESSAGE);
				else
					JOptionPane.showMessageDialog(null, "Error "+context.getData(),"ERROR", JOptionPane.INFORMATION_MESSAGE);
				break;
			case Events.BAJA_VENTA_OK:
				JOptionPane.showMessageDialog(null, "Venta con ID "+ context.getData()+" se ha dado de baja correctamente","EXITO", JOptionPane.INFORMATION_MESSAGE);
				break;	
			case Events.BAJA_VENTA_KO:
				if((int) context.getData()==-1)
					JOptionPane.showMessageDialog(null, "No existe la venta que desee","ERROR", JOptionPane.INFORMATION_MESSAGE);
				else if((int) context.getData()==-12)
					JOptionPane.showMessageDialog(null, "La venta no está activa, no se puede dar de baja la venta","ERROR", JOptionPane.INFORMATION_MESSAGE);
				else
					JOptionPane.showMessageDialog(null, "Error "+context.getData(),"ERROR", JOptionPane.INFORMATION_MESSAGE);
				break;
			case Events.MODIFICA_VENTA_OK:
				
				JOptionPane.showMessageDialog(null, "Venta con ID "+ context.getData()+" modificado correctamente","EXITO", JOptionPane.INFORMATION_MESSAGE);
				break;
			case Events.MODIFICA_VENTA_KO:
				if((int)context.getData()==-1) {
					JOptionPane.showMessageDialog(null, "La venta que desea modificar no existe.","ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else
					JOptionPane.showMessageDialog(null, "Error "+context.getData(),"ERROR", JOptionPane.INFORMATION_MESSAGE);
				break;
			case Events.MODIFICA_VENTA_READ_OK:
				this._modificarVenta.update(context);
				break;
			case Events.MODIFICA_VENTA_READ_KO:
				JOptionPane.showMessageDialog(null, "La venta que desea modificar no existe.","ERROR", JOptionPane.ERROR_MESSAGE);		
				break;
			case Events.MOSTRAR_VENTA_ACTUAL:
				this._mostrarVenta.update(new Contexto( Events.MOSTRAR_VENTA_ACTUAL,ventaActual));
				break;
			case Events.MOSTRAR_VENTA_OK:
				this._mostrarVenta.update(context);
				break;
			case Events.MOSTRAR_VENTA_KO:
				JOptionPane.showMessageDialog(null, "La venta que desea mostrar no existe.", "ERROR", JOptionPane.ERROR_MESSAGE);
				break;
			case Events.MOSTRAR_VENTAS_OK:
				this._mostrarVentas.update(context);
				break;
			case Events.MOSTRAR_VENTAS_KO:
				JOptionPane.showMessageDialog(null, "No hay ventas", "ERROR", JOptionPane.ERROR_MESSAGE);
				break;
			case Events.DEVOLUCION_VENTA_OK:
				this._devolucionVenta.update(context);
				break;
			case Events.DEVOLUCION_VENTA_KO:
				JOptionPane.showMessageDialog(null, "No se ha podido hacer la devolución", "ERROR", JOptionPane.ERROR_MESSAGE);
				break;
				
		}
	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		this.setVisible(true);
		setTitle("Ventas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(32, 178, 170));
		contentPane.setBackground(new Color(32, 178, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(32, 178, 170));
		contentPane.add(panel, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("VENTAS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Consolas", Font.PLAIN, 32));
		panel.add(lblNewLabel);

		JPanel panel_botones = new JPanel();
		panel_botones.setBackground(new Color(32, 178, 170));
		contentPane.add(panel_botones, BorderLayout.CENTER);

		JButton _btnAbrirVenta = new JButton("Abrir una venta");
		_btnAbrirVenta.setFont(new Font("Consolas", Font.PLAIN, 18));

		_btnBajaVenta = new JButton("Baja de una venta");
		_btnBajaVenta.setFont(new Font("Consolas", Font.PLAIN, 18));

		JButton _btnAnadirProducto = new JButton("Insertar producto en la venta actual");
		_btnAnadirProducto.setFont(new Font("Consolas", Font.PLAIN, 18));

		JButton _btnQuitarProducto = new JButton("Quitar producto en la venta actual");
		_btnQuitarProducto.setFont(new Font("Consolas", Font.PLAIN, 18));

		JButton _btnRealizarVenta = new JButton("Realizar la venta actual");
		_btnRealizarVenta.setFont(new Font("Consolas", Font.PLAIN, 18));

		panel_botones.setLayout(new GridLayout(0, 2, 50, 25));
		panel_botones.add(_btnAbrirVenta);
		panel_botones.add(_btnBajaVenta);
		panel_botones.add(_btnAnadirProducto);
		panel_botones.add(_btnQuitarProducto);
		panel_botones.add(_btnRealizarVenta);
		
		JButton _btnDevolverProducto = new JButton("Devolver producto de una venta existente");
		_btnDevolverProducto.setFont(new Font("Consolas", Font.PLAIN, 16));
		panel_botones.add(_btnDevolverProducto);
		
		JButton _btnActualizarVenta = new JButton("Actualizar una venta");
		_btnActualizarVenta.setFont(new Font("Consolas", Font.PLAIN, 18));
		panel_botones.add(_btnActualizarVenta);
		
		JButton _btnMostrarVenta = new JButton("Mostrar una venta");
		_btnMostrarVenta.setFont(new Font("Consolas", Font.PLAIN, 18));
		panel_botones.add(_btnMostrarVenta);
		
		JButton _btnMostrarTodas = new JButton("Mostrar todas las ventas");
		_btnMostrarTodas.setFont(new Font("Consolas", Font.PLAIN, 18));
		panel_botones.add(_btnMostrarTodas);

		JPanel _exitPanel = new JPanel();
		_exitPanel.setBackground(Color.white);
		contentPane.add(_exitPanel, BorderLayout.SOUTH);

		JButton _btnOut = new JButton("SALIR");
		_btnOut.setForeground(new Color(0, 0, 0));
		_btnOut.setFont(new Font("Consolas", Font.PLAIN, 32));
		_exitPanel.add(_btnOut);

		/* ActionListener */
		_btnAbrirVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_abrirVenta.init();
				
			}
		});
		_btnBajaVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_bajaVenta.init();
			}
		});
		_btnAnadirProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_insertarProductoVenta.init(ventaActual);
			}
		});
		_btnQuitarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_borrarProductoVenta.init(ventaActual);
			}
		});
		_btnRealizarVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_realizarVenta.init(ventaActual);
			}
		});
		_btnMostrarVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_mostrarVenta.init(ventaActual);
			}
		});
		_btnMostrarTodas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_mostrarVentas.init();
			}
		});
		_btnDevolverProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_devolucionVenta.init();
			}
		});
		_btnActualizarVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_modificarVenta.init();
			}
		});
		//faltan action listeners
		_btnOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}

}
