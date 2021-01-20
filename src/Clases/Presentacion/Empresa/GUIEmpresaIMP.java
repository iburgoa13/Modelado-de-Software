package Clases.Presentación.Empresa;

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


public class GUIEmpresaIMP extends GUIEmpresa{

	private static final long serialVersionUID = 1L;
	private gAltaEmpresa _altaEmpresa;
	private gBajaEmpresa _bajaEmpresa;
	private gUpdateEmpresa _updateEmpresa;
	private gMostrarEmpresa _mostrarEmpresa;
	private gMostrarEmpresas _mostrarEmpresas;
	private gMostrarCursosEmpresa _mostrarCursos;
	private JPanel contentPane;
	
	
	public GUIEmpresaIMP() {
		initialize();
		init();
	}
	
	private void init() {
		this._altaEmpresa = new gAltaEmpresa();
		this._bajaEmpresa = new gBajaEmpresa();
		this._updateEmpresa = new gUpdateEmpresa();
		this._mostrarEmpresa = new gMostrarEmpresa();
		this._mostrarEmpresas = new gMostrarEmpresas();
		this._mostrarCursos = new gMostrarCursosEmpresa();
	}

	@Override
	public void update(Contexto context) {
		switch(context.getEvent()) {
		
		
			case Events.MODIFICA_EMPRESA_OK:
				JOptionPane.showMessageDialog(null, "Empresa con ID "+ context.getData()+" modificado correctamente","EXITO", JOptionPane.INFORMATION_MESSAGE);
			break;
			
			case Events.MODIFICA_EMPRESA_KO:
				if((int)context.getData()==-70) {
					JOptionPane.showMessageDialog(null, "La empresa que desea modificar no existe.","ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else if((int)context.getData() == -77)
					JOptionPane.showMessageDialog(null, "La empresa que se quería dar de baja tiene cursos asociado", "ERROR", JOptionPane.ERROR_MESSAGE);
				
				else if((int)context.getData()==-71) {
					JOptionPane.showMessageDialog(null, "El correo de la empresa no es válido.", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else if((int)context.getData()==-72) {
					JOptionPane.showMessageDialog(null, "El CIF de la empresa no es válido.", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else if((int)context.getData()==-73) {
					JOptionPane.showMessageDialog(null, "El telefono de la empresa no es válido.", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else if((int)context.getData()==-74) {
					JOptionPane.showMessageDialog(null, "La empresa no existe.", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else if((int)context.getData()==-75) {
					JOptionPane.showMessageDialog(null, "El cif introducido ya existe.", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else if((int)context.getData()==-999) {
					JOptionPane.showMessageDialog(null, "Error persistence.", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				break;
			case Events.MODIFICA_EMPRESA_READ_OK:
				this._updateEmpresa.update(context);
				break;
			case Events.MODIFICA_EMPRESA_READ_KO:
				JOptionPane.showMessageDialog(null, "La empresa que desea modificar no existe.","ERROR", JOptionPane.ERROR_MESSAGE);		
				break;
			case Events.ALTA_EMPRESA_OK:
				JOptionPane.showMessageDialog(null, "Empresa con ID "+ context.getData()+" añadido correctamente","EXITO", JOptionPane.INFORMATION_MESSAGE);
				break;
			case Events.ALTA_EMPRESA_KO:
				if((int)context.getData() == -73)
					JOptionPane.showMessageDialog(null, "Formato de teléfono incorrecto, no se ha podido insertar la empresa:", "ERROR", JOptionPane.ERROR_MESSAGE);
				else if((int)context.getData() == -71)
					JOptionPane.showMessageDialog(null, "Formato del correo incorrecto, no se ha podido insertar la empresa:  \nejemplo@ejemplo.es ", "ERROR", JOptionPane.ERROR_MESSAGE);
				else if((int)context.getData() == -72)
					JOptionPane.showMessageDialog(null, "CIF invalido.", "ERROR", JOptionPane.ERROR_MESSAGE);
				else if((int)context.getData() == -75)
					JOptionPane.showMessageDialog(null, "CIF repetido.", "ERROR", JOptionPane.ERROR_MESSAGE);
				else JOptionPane.showMessageDialog(null, "No se ha podido insertar la marca, error:"+ context.getData(), "ERROR", JOptionPane.ERROR_MESSAGE);
				break;
			case Events.BAJA_EMPRESA_KO:
				if((int)context.getData() == -77)
					JOptionPane.showMessageDialog(null, "La empresa que se quería dar de baja tiene cursos asociado", "ERROR", JOptionPane.ERROR_MESSAGE);
				else if((int)context.getData() == -74)
					JOptionPane.showMessageDialog(null, "El ID empresa no existe", "ERROR", JOptionPane.ERROR_MESSAGE);
				else if((int)context.getData() == -999)
					JOptionPane.showMessageDialog(null, "Error persistence", "ERROR", JOptionPane.ERROR_MESSAGE);
				else if((int)context.getData() == -76)
					JOptionPane.showMessageDialog(null, "La empresa ya esta dada de baja.", "ERROR", JOptionPane.ERROR_MESSAGE);
				break;
			case Events.BAJA_EMPRESA_OK:
				JOptionPane.showMessageDialog(null, "Empresa con ID "+ context.getData()+" eliminada correctamente","EXITO", JOptionPane.INFORMATION_MESSAGE);
				break;
			case Events.MOSTRAR_EMPRESA_OK:
				this._mostrarEmpresa.update(context);
				break;
			case Events.MOSTRAR_EMPRESA_KO:
				JOptionPane.showMessageDialog(null, "La empresa que desea mostrar no existe.","ERROR", JOptionPane.ERROR_MESSAGE);		
				break;
			case Events.MOSTRAR_EMPRESAS_OK:
				this._mostrarEmpresas.update(context);
				break;
			case Events.MOSTRAR_EMPRESAS_KO:
				JOptionPane.showMessageDialog(null, "No se han podido mostrar las empresas.","ERROR", JOptionPane.ERROR_MESSAGE);		
				break;
			case Events.MOSTRAR_CURSOS_EMPRESA_OK:
				this._mostrarCursos.update(context);	
				break;	
			case Events.MOSTRAR_CURSOS_EMPRESA_KO:
				JOptionPane.showMessageDialog(null, "No se han podido mostrar los cursos de la empresa.","ERROR", JOptionPane.ERROR_MESSAGE);		
				break;	
		
		}
	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		this.setVisible(true);
		setTitle("Empresas");
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

		JLabel lblNewLabel = new JLabel("EMPRESA");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Consolas", Font.PLAIN, 32));
		panel.add(lblNewLabel);

		JPanel panel_botones = new JPanel();
		panel_botones.setBackground(new Color(32, 178, 170));
		contentPane.add(panel_botones, BorderLayout.CENTER);

		JButton _btnAltaEmpresa = new JButton("Alta de una empresa");
		_btnAltaEmpresa.setFont(new Font("Consolas", Font.PLAIN, 18));

		JButton _btnBajaEmpresa = new JButton("Baja de una empresa");
		_btnBajaEmpresa.setFont(new Font("Consolas", Font.PLAIN, 18));

		JButton _btnModificaEmpresa = new JButton("Actualizar empresa");
		_btnModificaEmpresa.setFont(new Font("Consolas", Font.PLAIN, 18));

		JButton _btnMostrarUnaEmpresa = new JButton("Mostrar empresa");
		_btnMostrarUnaEmpresa.setFont(new Font("Consolas", Font.PLAIN, 18));

		JButton _btnMostrarTodas = new JButton("Mostrar todas las empresas");
		_btnMostrarTodas.setFont(new Font("Consolas", Font.PLAIN, 18));
		
		JButton _btnMostrarCursos = new JButton("Mostrar todos los cursos");
		_btnMostrarCursos.setFont(new Font("Consolas", Font.PLAIN, 18));

		panel_botones.setLayout(new GridLayout(4, 2, 50, 25));
		panel_botones.add(_btnAltaEmpresa);
		panel_botones.add(_btnBajaEmpresa);
		panel_botones.add(_btnModificaEmpresa);
		panel_botones.add(_btnMostrarUnaEmpresa);
		panel_botones.add(_btnMostrarTodas);
		panel_botones.add(_btnMostrarCursos);

		JPanel _exitPanel = new JPanel();
		_exitPanel.setBackground(Color.white);
		contentPane.add(_exitPanel, BorderLayout.SOUTH);

		JButton _btnOut = new JButton("SALIR");
		_btnOut.setForeground(new Color(0, 0, 0));
		_btnOut.setFont(new Font("Consolas", Font.PLAIN, 32));
		_exitPanel.add(_btnOut);

		/* ActionListener */
		_btnAltaEmpresa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_altaEmpresa.init();
				
			}
		});
		_btnBajaEmpresa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_bajaEmpresa.init();
			}
		});
		_btnModificaEmpresa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_updateEmpresa.init();
			}
		});
		_btnMostrarUnaEmpresa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_mostrarEmpresa.init();
			}
		});
		_btnMostrarTodas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_mostrarEmpresas.init();
			}
		});
		_btnMostrarCursos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_mostrarCursos.init();
			}
		});
		_btnOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}


}
