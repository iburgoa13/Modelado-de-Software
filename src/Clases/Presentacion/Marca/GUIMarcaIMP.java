package Clases.Presentación.Marca;

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

import Clases.Negocio.Marca.TMarca;
import Clases.Presentación.Contexto;
import Clases.Presentación.Command.Events;

public class GUIMarcaIMP extends GUIMarca {

	private gAltaMarca _altaMarca;
	private gBajaMarca _bajaMarca;
	private gUpdateMarca _updateMarca;
	private gMostrarMarca _mostrarMarca;
	private gMostrarMarcas _mostrarMarcas;
	private gMostrarProductosDeMarca _mostrarProductos;
	private JPanel contentPane;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GUIMarcaIMP() {
		initialize();
		init();
	}

	private void init() {
		this._altaMarca = new gAltaMarca();
		this._bajaMarca = new gBajaMarca();
		this._updateMarca = new gUpdateMarca();
		this._mostrarMarca = new gMostrarMarca();
		this._mostrarMarcas = new gMostrarMarcas();
		this._mostrarProductos = new gMostrarProductosDeMarca();
	}

	@Override
	public void update(Contexto context) {
		
		switch(context.getEvent()) {
		case Events.ALTA_MARCA_OK:
			JOptionPane.showMessageDialog(null, "Marca con ID "+ context.getData()+" añadido correctamente","EXITO", JOptionPane.INFORMATION_MESSAGE);
			break;
		case Events.ALTA_MARCA_KO:
			if((int)context.getData() == -22)
				JOptionPane.showMessageDialog(null, "Formato de teléfono incorrecto, no se ha podido insertar la marca:", "ERROR", JOptionPane.ERROR_MESSAGE);
			else if((int)context.getData() == -23)
				JOptionPane.showMessageDialog(null, "Formato del correo incorrecto, no se ha podido insertar la marca:  \nejemplo@ejemplo.es ", "ERROR", JOptionPane.ERROR_MESSAGE);
			else if((int)context.getData() == -60)
				JOptionPane.showMessageDialog(null, "Error en transaction", "ERROR", JOptionPane.ERROR_MESSAGE);
			else
			if((int)context.getData() == -37)
				JOptionPane.showMessageDialog(null, "La marca ya existe en la base de datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
			else JOptionPane.showMessageDialog(null, "No se ha podido insertar la marca, error:"+ context.getData(), "ERROR", JOptionPane.ERROR_MESSAGE);
			break;
		case Events.BAJA_MARCA_KO:
			if((int)context.getData() == -21)
				JOptionPane.showMessageDialog(null, "La marca que se quería dar de baja tiene productos asociados", "ERROR", JOptionPane.ERROR_MESSAGE);
			else if((int)context.getData() == -50)
				JOptionPane.showMessageDialog(null, "Error base de datos", "ERROR", JOptionPane.ERROR_MESSAGE);
			else if((int)context.getData() == -7)
				JOptionPane.showMessageDialog(null, "El ID marca no existe", "ERROR", JOptionPane.ERROR_MESSAGE);
			else if((int)context.getData() == -60)
				JOptionPane.showMessageDialog(null, "Error en transaction", "ERROR", JOptionPane.ERROR_MESSAGE);
			else if((int)context.getData() == -13)
				JOptionPane.showMessageDialog(null, "La marca ya esta dada de baja.", "ERROR", JOptionPane.ERROR_MESSAGE);
			break;
		case Events.BAJA_MARCA_OK:
			JOptionPane.showMessageDialog(null, "Marca con ID "+ context.getData()+" eliminado correctamente","EXITO", JOptionPane.INFORMATION_MESSAGE);
			break;
		case Events.MOSTRAR_UNA_MARCA_OK:
			this._mostrarMarca.update(context);
			break;
		case Events.MOSTRAR_UNA_MARCA_KO:
			JOptionPane.showMessageDialog(null, "La marca que desea mostrar no existe.","ERROR", JOptionPane.ERROR_MESSAGE);		
			break;
		case Events.MOSTRAR_MARCAS_OK:
			this._mostrarMarcas.update(context);
			break;
		case Events.MOSTRAR_MARCAS_KO:
			JOptionPane.showMessageDialog(null, "No se han podido mostrar las marcas.","ERROR", JOptionPane.ERROR_MESSAGE);		
			break;
		case Events.MOSTRAR_MARCA_MODIFICA_OK:
			_updateMarca.update((TMarca)context.getData());		
			break;
		case Events.MOSTRAR_MARCA_MODIFICA_KO:
			JOptionPane.showMessageDialog(null, "No se ha podido mostrar las marca a modificar","ERROR", JOptionPane.ERROR_MESSAGE);		
			break;
		case Events.MODIFICA_MARCA_OK:
			JOptionPane.showMessageDialog(null, "Marca actualizada correctamente","EXITO", JOptionPane.INFORMATION_MESSAGE);		
			break;
		case Events.MODIFICA_MARCA_KO:
			if((int)context.getData() == -37)
				JOptionPane.showMessageDialog(null, "La marca ya existe en la base de datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
			else if((int)context.getData() == -21)
				JOptionPane.showMessageDialog(null, "La marca que se quería modificar tiene productos asociados", "ERROR", JOptionPane.ERROR_MESSAGE);
			else if((int)context.getData() == -22)
				JOptionPane.showMessageDialog(null, "Formato de teléfono incorrecto, no se ha podido modificar la marca:"+ context.getData(), "ERROR", JOptionPane.ERROR_MESSAGE);
			else if((int)context.getData() == -23)
				JOptionPane.showMessageDialog(null, "Formato del correo incorrecto, no se ha podido actualizar la marca: " + context.getData() + "\nejemplo@ejemplo.es ", "ERROR", JOptionPane.ERROR_MESSAGE);
			else if((int)context.getData() == -60)
				JOptionPane.showMessageDialog(null, "Error en transaction", "ERROR", JOptionPane.ERROR_MESSAGE);
			else JOptionPane.showMessageDialog(null, "No se ha podido actualizar la marca.","ERROR", JOptionPane.ERROR_MESSAGE);		
			break;
		case Events.MOSTRAR_PRODUCTOSDEMARCA_OK:
			this._mostrarProductos.update(context);		
			break;
		case Events.MOSTRAR_PRODUCTOSDEMARCA_KO:
			JOptionPane.showMessageDialog(null, "La marca que desee no existe","ERROR", JOptionPane.ERROR_MESSAGE);		
			break;
			
		}
	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		this.setVisible(true);
		setTitle("Marcas");
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

		JLabel lblNewLabel = new JLabel("MARCAS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Consolas", Font.PLAIN, 32));
		panel.add(lblNewLabel);

		JPanel panel_botones = new JPanel();
		panel_botones.setBackground(new Color(32, 178, 170));
		contentPane.add(panel_botones, BorderLayout.CENTER);

		JButton _btnAltaMarca = new JButton("Alta de una marca");
		_btnAltaMarca.setFont(new Font("Consolas", Font.PLAIN, 18));

		JButton _btnBajaMarca = new JButton("Baja de una marca");
		_btnBajaMarca.setFont(new Font("Consolas", Font.PLAIN, 18));

		JButton _btnModificaMarca = new JButton("Actualizar marca");
		_btnModificaMarca.setFont(new Font("Consolas", Font.PLAIN, 18));

		JButton _btnMostrarUnaMarca = new JButton("Mostrar marca");
		_btnMostrarUnaMarca.setFont(new Font("Consolas", Font.PLAIN, 18));

		JButton _btnMostrarTodas = new JButton("Mostrar todas las marcas");
		_btnMostrarTodas.setFont(new Font("Consolas", Font.PLAIN, 18));
		
		JButton _btnMostrarTodos = new JButton("Mostrar todos los productos");
		_btnMostrarTodos.setFont(new Font("Consolas", Font.PLAIN, 18));

		panel_botones.setLayout(new GridLayout(4, 2, 50, 25));
		panel_botones.add(_btnAltaMarca);
		panel_botones.add(_btnBajaMarca);
		panel_botones.add(_btnModificaMarca);
		panel_botones.add(_btnMostrarUnaMarca);
		panel_botones.add(_btnMostrarTodas);
		panel_botones.add(_btnMostrarTodos);

		JPanel _exitPanel = new JPanel();
		_exitPanel.setBackground(Color.white);
		contentPane.add(_exitPanel, BorderLayout.SOUTH);

		JButton _btnOut = new JButton("SALIR");
		_btnOut.setForeground(new Color(0, 0, 0));
		_btnOut.setFont(new Font("Consolas", Font.PLAIN, 32));
		_exitPanel.add(_btnOut);

		/* ActionListener */
		_btnAltaMarca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_altaMarca.init();
				
			}
		});
		_btnBajaMarca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_bajaMarca.init();
			}
		});
		_btnModificaMarca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_updateMarca.init();
			}
		});
		_btnMostrarUnaMarca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_mostrarMarca.init();
			}
		});
		_btnMostrarTodas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_mostrarMarcas.init();
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
