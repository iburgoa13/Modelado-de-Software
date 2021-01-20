package Clases.Presentación.Departamento;

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
import Clases.Presentación.Empresa.gBajaEmpresa;



public class GUIDepartamentoIMP extends GUIDepartamento{
	
	private static final long serialVersionUID = 1L;
	private gAltaDepartamento _altaDepartamento;
	private gBajaDepartamento _bajaDepartamento;
	private gUpdateDepartamento _updateDepartamento;
	private gMostrarDepartamento _mostrarDepartamento;
	private gMostrarDepartamentos _mostrarDepartamentos;
	private gMostrarTrabajadoresDepartamento _mostrarTrabajadores;
	private gCalcularNominaDepartamento _calcularNomina;
	private JPanel contentPane;
	
	public GUIDepartamentoIMP() {
		initialize();
		init();
	}
	private void init() {
		this._altaDepartamento = new gAltaDepartamento();
		this._bajaDepartamento = new gBajaDepartamento();
		this._updateDepartamento = new gUpdateDepartamento();
		this._mostrarDepartamento = new gMostrarDepartamento();
		this._mostrarDepartamentos = new gMostrarDepartamentos();
		this._mostrarTrabajadores = new gMostrarTrabajadoresDepartamento();
		this._calcularNomina = new gCalcularNominaDepartamento();
	}


	@Override
	public void update(Contexto context) {
		switch(context.getEvent()) {
		case Events.ALTA_DEPARTAMENTO_OK:
			JOptionPane.showMessageDialog(null, "Departamento con ID "+ context.getData()+" añadido correctamente","EXITO", JOptionPane.INFORMATION_MESSAGE);
			break;
		case Events.ALTA_DEPARTAMENTO_KO:
			if((int)context.getData() == -80)
				JOptionPane.showMessageDialog(null, "El nombre del departamento ya existe , no se ha podido insertar.", "ERROR", JOptionPane.ERROR_MESSAGE);
			else if((int)context.getData() == -83)
				JOptionPane.showMessageDialog(null, "Formato del correo incorrecto, no se ha podido insertar el departamento:  \nejemplo@ejemplo.es ", "ERROR", JOptionPane.ERROR_MESSAGE);
			else if((int)context.getData() == -84)
				JOptionPane.showMessageDialog(null, "Formato del telefono incorrecto, no se ha podido insertar el departamento.", "ERROR", JOptionPane.ERROR_MESSAGE);
			else if((int)context.getData() == -999)
				JOptionPane.showMessageDialog(null, "Error persistence", "ERROR", JOptionPane.ERROR_MESSAGE);
			break;
			
		case Events.BAJA_DEPARTAMENTO_OK:
			JOptionPane.showMessageDialog(null, "Departamento con ID "+ context.getData()+" eliminado correctamente","EXITO", JOptionPane.INFORMATION_MESSAGE);
			break;
		case Events.BAJA_DEPARTAMENTO_KO:
			if((int)context.getData() == -86)
				JOptionPane.showMessageDialog(null, "El departamento que se quería dar de baja tiene trabajadores asociados", "ERROR", JOptionPane.ERROR_MESSAGE);
			else if((int)context.getData() == -999)
				JOptionPane.showMessageDialog(null, "Error persistence", "ERROR", JOptionPane.ERROR_MESSAGE);
			else if((int)context.getData() == -81)
				JOptionPane.showMessageDialog(null, "El ID departamento no existe", "ERROR", JOptionPane.ERROR_MESSAGE);
			else if((int)context.getData() == -82)
				JOptionPane.showMessageDialog(null, "El departamento ya esta dado de baja.", "ERROR", JOptionPane.ERROR_MESSAGE);
			break;
		
		case Events.MOSTRAR_DEPARTAMENTO_OK:
			this._mostrarDepartamento.update(context);
			break;
		case Events.MOSTRAR_DEPARTAMENTO_KO:
			JOptionPane.showMessageDialog(null, "El departamento no existe.","ERROR", JOptionPane.ERROR_MESSAGE);		
			break;
		case Events.MOSTRAR_DEPARTAMENTOS_OK:
			this._mostrarDepartamentos.update(context);
			break;
		case Events.MOSTRAR_DEPARTAMENTOS_KO:
			JOptionPane.showMessageDialog(null, "No se han podido mostrar los departamentos.","ERROR", JOptionPane.ERROR_MESSAGE);		
			break;
		case Events.MOSTRAR_TRABAJADORES_DEPARTAMENTO_OK:
			this._mostrarTrabajadores.update(context);
			break;
		case Events.MOSTRAR_TRABAJADORES_DEPARTAMENTO_KO:
			JOptionPane.showMessageDialog(null, "No se ha podido mostrar los trabajadores del departamento.","ERROR", JOptionPane.ERROR_MESSAGE);		
			break;
			
		case Events.MOSTRAR_SUELDO_DEPARTAMENTO_OK:
			JOptionPane.showMessageDialog(null, "La nomina total del departamento es: " + context.getData(),"NOMINA", JOptionPane.INFORMATION_MESSAGE);
			break;
		case Events.MOSTRAR_SUELDO_DEPARTAMENTO_KO:
			if((float)context.getData() == (float) -81) 
				JOptionPane.showMessageDialog(null, "El departamento no existe.","ERROR", JOptionPane.ERROR_MESSAGE);
			else if((float)context.getData() == (float) -999) 
				JOptionPane.showMessageDialog(null, "Error desconocido","ERROR", JOptionPane.ERROR_MESSAGE);
			break;
		case Events.MODIFICA_DEPARTAMENTO_OK:
			JOptionPane.showMessageDialog(null, "Departamento con ID "+ context.getData()+" modificado correctamente","EXITO", JOptionPane.INFORMATION_MESSAGE);
		break;
		
		case Events.MODIFICA_DEPARTAMENTO_KO:
			if((int)context.getData()==-81) {
				JOptionPane.showMessageDialog(null, "El departamento que desea modificar no existe.","ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if((int)context.getData() == -86)
				JOptionPane.showMessageDialog(null, "El departamento que se quería dar de baja tiene trabajadores asociados", "ERROR", JOptionPane.ERROR_MESSAGE);
			
			else if((int)context.getData()==-80) {
				JOptionPane.showMessageDialog(null, "El nombre del departamento está repetido.", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if((int)context.getData()==-85) {
				JOptionPane.showMessageDialog(null, "TDepartamento es null.", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if((int)context.getData() == -83) 
				JOptionPane.showMessageDialog(null, "Formato del correo incorrecto, no se ha podido insertar el departamento:  \nejemplo@ejemplo.es ", "ERROR", JOptionPane.ERROR_MESSAGE);
			else if((int)context.getData() == -84)
				JOptionPane.showMessageDialog(null, "Formato del telefono incorrecto, no se ha podido insertar el departamento.", "ERROR", JOptionPane.ERROR_MESSAGE);
			else if((int)context.getData()==-999) {
				JOptionPane.showMessageDialog(null, "Error persistence.", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			break;
		case Events.MODIFICA_DEPARTAMENTO_READ_OK:
			this._updateDepartamento.update(context);
			break;
		case Events.MODIFICA_DEPARTAMENTO_READ_KO:
			JOptionPane.showMessageDialog(null, "El departamento que desea modificar no existe.","ERROR", JOptionPane.ERROR_MESSAGE);		
			break;
		}
		
	}
	@Override
	public void initialize() {
		this.setVisible(true);
		setTitle("Departamento");
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

		JLabel lblNewLabel = new JLabel("DEPARTAMENTO");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Consolas", Font.PLAIN, 32));
		panel.add(lblNewLabel);
		
		JPanel panel_botones = new JPanel();
		panel_botones.setBackground(new Color(32, 178, 170));
		contentPane.add(panel_botones, BorderLayout.CENTER);
		
		
		JButton _btnAltaDepartamento = new JButton("Alta de un departamento");
		_btnAltaDepartamento.setFont(new Font("Consolas", Font.PLAIN, 18));

		JButton _btnBajaDepartamento = new JButton("Baja de un departamento");
		_btnBajaDepartamento.setFont(new Font("Consolas", Font.PLAIN, 18));
		
		JButton _btnModificaDepartamento = new JButton("Actualizar departamento");
		_btnModificaDepartamento.setFont(new Font("Consolas", Font.PLAIN, 18));

		JButton _btnMostrarUnDepartamento = new JButton("Mostrar departamento");
		_btnMostrarUnDepartamento.setFont(new Font("Consolas", Font.PLAIN, 18));
		
		JButton _btnMostrarTodas = new JButton("Mostrar todos los departamentos");
		_btnMostrarTodas.setFont(new Font("Consolas", Font.PLAIN, 18));
		
		JButton _btnMostrarTrabajadores = new JButton("Mostrar todos los trabajadores");
		_btnMostrarTrabajadores.setFont(new Font("Consolas", Font.PLAIN, 18));
		
		JButton _btnCalcularNominaDepartamento = new JButton("Calcular nómina del departamento");
		_btnCalcularNominaDepartamento.setFont(new Font("Consolas", Font.PLAIN, 18));
		
		panel_botones.setLayout(new GridLayout(4, 2, 50, 25));
		panel_botones.add(_btnAltaDepartamento);
		panel_botones.add(_btnBajaDepartamento);
		panel_botones.add(_btnModificaDepartamento);
		panel_botones.add(_btnMostrarUnDepartamento);
		panel_botones.add(_btnMostrarTodas);
		panel_botones.add(_btnMostrarTrabajadores);
		panel_botones.add(_btnCalcularNominaDepartamento);
		
		JPanel _exitPanel = new JPanel();
		_exitPanel.setBackground(Color.white);
		contentPane.add(_exitPanel, BorderLayout.SOUTH);

		JButton _btnOut = new JButton("SALIR");
		_btnOut.setForeground(new Color(0, 0, 0));
		_btnOut.setFont(new Font("Consolas", Font.PLAIN, 32));
		_exitPanel.add(_btnOut);
		
		/* ActionListener */
		_btnAltaDepartamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_altaDepartamento.init();
				
			}
		});
		_btnBajaDepartamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_bajaDepartamento.init();
			}
		});
		_btnModificaDepartamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_updateDepartamento.init();
			}
		});
		_btnMostrarUnDepartamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_mostrarDepartamento.init();
			}
		});
		_btnMostrarTodas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_mostrarDepartamentos.init();
			}
		});
		_btnMostrarTrabajadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_mostrarTrabajadores.init();
			}
		});
		_btnCalcularNominaDepartamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_calcularNomina.init();
			}
		});
		_btnOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}



}
