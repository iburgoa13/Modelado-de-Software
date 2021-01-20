package Clases.Presentación.Producto;

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

import Clases.Presentación.Contexto;
import Clases.Presentación.Command.Events;

public class GUIProductoIMP extends GUIProducto {

	private gAltaProducto _altaProducto;
	private gBajaProducto _bajaProducto;
	private gUpdateProducto _updateProducto;
	private gMostrarProducto _mostrarProducto;
	private gMostrarProductos _mostrarProductos;
	private JPanel contentPane;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GUIProductoIMP() {
		initialize();
		init();
	}

	private void init() {
		this._altaProducto = new gAltaProducto();
		this._bajaProducto = new gBajaProducto();
		this._updateProducto = new gUpdateProducto();
		this._mostrarProducto = new gMostrarProducto();
		this._mostrarProductos = new gMostrarProductos();
	}

	@Override
	public void update(Contexto context) {
		
		switch(context.getEvent()) {
		case Events.ALTA_PRODUCTO_OK:
			JOptionPane.showMessageDialog(null, "Producto con ID "+ context.getData()+" añadido correctamente","EXITO", JOptionPane.INFORMATION_MESSAGE);
			break;
		case Events.ALTA_PRODUCTO_KO:
			if((int)context.getData()==-7) {
				JOptionPane.showMessageDialog(null, "La marca no existe.", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if((int)context.getData()==-39) {
				JOptionPane.showMessageDialog(null, "El producto ya existe en base de datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if((int)context.getData()==-13) {
				JOptionPane.showMessageDialog(null, "La marca no esta activo.", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if((int)context.getData()==-50) {
				JOptionPane.showMessageDialog(null, "Error en base de datos", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if((int)context.getData()==-60) {
				JOptionPane.showMessageDialog(null, "Transaccion nula.", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else
			JOptionPane.showMessageDialog(null, "No se ha podido insertar el producto, error:"+ context.getData(), "ERROR", JOptionPane.ERROR_MESSAGE);
			break;
		case Events.BAJA_PRODUCTO_KO:
			if((int)context.getData()==-5) {
				JOptionPane.showMessageDialog(null, "El producto no existe.","ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if((int)context.getData()==-20) {
				JOptionPane.showMessageDialog(null, "El producto ya no está activo.","ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if((int)context.getData()==-50) {
				JOptionPane.showMessageDialog(null, "Error en base de datos", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if((int)context.getData()==-60) {
				JOptionPane.showMessageDialog(null, "Transaccion nula.", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else
				JOptionPane.showMessageDialog(null, "No se ha podido eliminar el producto, error:"+ context.getData(), "ERROR", JOptionPane.ERROR_MESSAGE);
			break;
		case Events.BAJA_PRODUCTO_OK:
			JOptionPane.showMessageDialog(null, "Producto con ID "+ context.getData()+" eliminado correctamente","EXITO", JOptionPane.INFORMATION_MESSAGE);
			break;
		case Events.MODIFICAR_PRODUCTO_OK:
			
			JOptionPane.showMessageDialog(null, "Producto con ID "+ context.getData()+" modificado correctamente","EXITO", JOptionPane.INFORMATION_MESSAGE);
			break;
		case Events.MODIFICAR_PRODUCTO_KO:
			if((int)context.getData()==-5) {
				JOptionPane.showMessageDialog(null, "El producto que desea modificar no existe.","ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if((int)context.getData()==-39) {
				JOptionPane.showMessageDialog(null, "El producto ya existe en base de datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if((int)context.getData()==-7) {
				JOptionPane.showMessageDialog(null, "La marca no existe.", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if((int)context.getData()==-13) {
				JOptionPane.showMessageDialog(null, "La marca no esta activo.", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if((int)context.getData()==-50) {
				JOptionPane.showMessageDialog(null, "Error en base de datos", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if((int)context.getData()==-60) {
				JOptionPane.showMessageDialog(null, "Transaccion nula.", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			break;
		case Events.MOSTRAR_UN_PRODUCTO_OK:
			this._mostrarProducto.update(context);
			break;
		case Events.MOSTRAR_UN_PRODUCTO_KO:
			JOptionPane.showMessageDialog(null, "El producto que desea mostrar no existe.","ERROR", JOptionPane.ERROR_MESSAGE);		
			break;
		case Events.MODIFICA_PRODUCTO_READ_OK:
			this._updateProducto.update(context);
			break;
		case Events.MODIFICA_PRODUCTO_READ_KO:
			JOptionPane.showMessageDialog(null, "El producto que desea modificar no existe.","ERROR", JOptionPane.ERROR_MESSAGE);		
			break;
		case Events.MOSTRAR_PRODUCTOS_OK:
			this._mostrarProductos.update(context);
			break;
		case Events.MOSTRAR_PRODUCTOS_KO:
			JOptionPane.showMessageDialog(null, "No se han podido mostrar los productos.","ERROR", JOptionPane.ERROR_MESSAGE);		
			break;
			
		}
	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		this.setVisible(true);
		setTitle("Productos");
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

		JLabel lblNewLabel = new JLabel("PRODUCTOS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Consolas", Font.PLAIN, 32));
		panel.add(lblNewLabel);

		JPanel panel_botones = new JPanel();
		panel_botones.setBackground(new Color(32, 178, 170));
		contentPane.add(panel_botones, BorderLayout.CENTER);

		JButton _btnAltaProducto = new JButton("Alta de un producto");
		_btnAltaProducto.setFont(new Font("Consolas", Font.PLAIN, 18));

		JButton _btnBajaProducto = new JButton("Baja de un producto");
		_btnBajaProducto.setFont(new Font("Consolas", Font.PLAIN, 18));

		JButton _btnModificaProducto = new JButton("Actualizar producto");
		_btnModificaProducto.setFont(new Font("Consolas", Font.PLAIN, 18));

		JButton _btnMostrarUnProducto = new JButton("Mostrar producto");
		_btnMostrarUnProducto.setFont(new Font("Consolas", Font.PLAIN, 18));

		JButton _btnMostrarTodos = new JButton("Mostrar todos los productos");
		_btnMostrarTodos.setFont(new Font("Consolas", Font.PLAIN, 18));

		panel_botones.setLayout(new GridLayout(4, 2, 50, 25));
		panel_botones.add(_btnAltaProducto);
		panel_botones.add(_btnBajaProducto);
		panel_botones.add(_btnModificaProducto);
		panel_botones.add(_btnMostrarUnProducto);
		panel_botones.add(_btnMostrarTodos);

		JPanel _exitPanel = new JPanel();
		_exitPanel.setBackground(Color.white);
		contentPane.add(_exitPanel, BorderLayout.SOUTH);

		JButton _btnOut = new JButton("SALIR");
		_btnOut.setForeground(new Color(0, 0, 0));
		_btnOut.setFont(new Font("Consolas", Font.PLAIN, 32));
		_exitPanel.add(_btnOut);

		/* ActionListener */
		_btnAltaProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_altaProducto.init();
				
			}
		});
		_btnBajaProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_bajaProducto.init();
			}
		});
		_btnModificaProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_updateProducto.init();
			}
		});
		_btnMostrarUnProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_mostrarProducto.init();
			}
		});
		_btnMostrarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_mostrarProductos.init();
			}
		});
		_btnOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}

}
