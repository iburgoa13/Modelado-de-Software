package Clases.Presentación.Trabajador;

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

import Clases.Negocio.Trabajador.TTrabajador;
import Clases.Presentación.Contexto;
import Clases.Presentación.Command.Events;
import Clases.Presentación.Empresa.gAltaEmpresa;
import Clases.Presentación.Empresa.gBajaEmpresa;
import Clases.Presentación.Empresa.gMostrarCursosEmpresa;
import Clases.Presentación.Empresa.gMostrarEmpresa;
import Clases.Presentación.Empresa.gMostrarEmpresas;
import Clases.Presentación.Empresa.gUpdateEmpresa;

public class GUITrabajadorIMP extends GUITrabajador{

	private static final long serialVersionUID = 1L;
	private gAltaTrabajadorT _altaTrabajadorT;
	private gAltaTrabajadorI _altaTrabajadorI;
	private gBajaTrabajador _bajaTrabajador;
	private gUpdateTrabajador _updateTrabajador;
	private gMostrarTrabajador _mostrarTrabajador;
	private gMostrarTrabajadores _mostrarTrabajadores;
	private gAsignarCurso _asignarCurso;
	private gDesvincularCurso _desvincularCurso;
	private gMostrarCursosTrabajador _mostrarCursosTrabajador;
	
	private JPanel contentPane;
	
	public GUITrabajadorIMP() {
		initialize();
		init();
	}
	
	private void init() {
		this._altaTrabajadorT = new gAltaTrabajadorT();
		this._altaTrabajadorI = new gAltaTrabajadorI();
		this._bajaTrabajador = new gBajaTrabajador();
		this._updateTrabajador = new gUpdateTrabajador();
		this._mostrarTrabajador = new gMostrarTrabajador();
		this._mostrarTrabajadores = new gMostrarTrabajadores();
		this._asignarCurso = new gAsignarCurso();
		this._desvincularCurso = new gDesvincularCurso();
		this._mostrarCursosTrabajador = new gMostrarCursosTrabajador();
	}

	@Override
	public void update(Contexto context) {
		switch(context.getEvent()) {
		case Events.ALTA_TRABAJADOR_OK:
			JOptionPane.showMessageDialog(null, "Trabajador con ID "+ context.getData()+" ha sido dado de alta correctamente","EXITO", JOptionPane.INFORMATION_MESSAGE);
			break;
		case Events.ALTA_TRABAJADOR_KO:
			if((int)context.getData()== -90) {
				JOptionPane.showMessageDialog(null, "El dni esta repetido", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if((int)context.getData()== -81) {
				JOptionPane.showMessageDialog(null, "El departamento no existe o no esta activo", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if((int)context.getData() == -999)
				JOptionPane.showMessageDialog(null, "Error persistence", "ERROR", JOptionPane.ERROR_MESSAGE);
			else if((int)context.getData() == -97)
				JOptionPane.showMessageDialog(null, "Error dni invalido", "ERROR", JOptionPane.ERROR_MESSAGE);
			else if((int)context.getData() == -98)
				JOptionPane.showMessageDialog(null, "Error correo invalido", "ERROR", JOptionPane.ERROR_MESSAGE);
			
			else JOptionPane.showMessageDialog(null, "Error no encontrado", "ERROR", JOptionPane.ERROR_MESSAGE);
	
			break;
		case Events.BAJA_TRABAJADOR_OK:
			JOptionPane.showMessageDialog(null, "Trabajador con ID "+ context.getData()+" ha sido dado de baja correctamente","EXITO", JOptionPane.INFORMATION_MESSAGE);
			break;
		case Events.BAJA_TRABAJADOR_KO:
			if((int)context.getData()== -91)
				JOptionPane.showMessageDialog(null, "El ID del trabajador no existe.", "ERROR", JOptionPane.ERROR_MESSAGE);
			else if((int)context.getData()== -92)
				JOptionPane.showMessageDialog(null, "El trabajador ya esta dada de baja.", "ERROR", JOptionPane.ERROR_MESSAGE);
			else if((int)context.getData() == -999)
				JOptionPane.showMessageDialog(null, "Error persistence", "ERROR", JOptionPane.ERROR_MESSAGE);
			break;
		case Events.MOSTRAR_TRABAJADOR_OK:
			this._mostrarTrabajador.update(context);
			break;
		case Events.MOSTRAR_TRABAJADOR_KO:
			JOptionPane.showMessageDialog(null, "El trabajador que desea mostrar no existe.","ERROR", JOptionPane.ERROR_MESSAGE);		
			break;
		case Events.MODIFICA_TRABAJADOR_READ_OK:
			this._updateTrabajador.update((TTrabajador)context.getData());
			break;
		case Events.MODIFICA_TRABAJADOR_READ_KO:
			JOptionPane.showMessageDialog(null, "El trabajador que desea modificar no existe.","ERROR", JOptionPane.ERROR_MESSAGE);		
			break;
		case Events.ASIGNAR_CURSO_OK:
            JOptionPane.showMessageDialog(null, "Trabajador con ID "+ context.getData()+" fue vinculado a un curso","EXITO", JOptionPane.INFORMATION_MESSAGE);
            break;
        case Events.ASIGNAR_CURSO_KO:
        	if((int)context.getData()== -93)
        		JOptionPane.showMessageDialog(null, "El trabajador y el curso ya están vinculados", "ERROR", JOptionPane.ERROR_MESSAGE);
        	else if((int)context.getData()== -94)
        		JOptionPane.showMessageDialog(null, "El trabajador o el curso no está activo", "ERROR", JOptionPane.ERROR_MESSAGE);
        	else if((int)context.getData()== -95)
        		JOptionPane.showMessageDialog(null, "El trabajador o el curso es null", "ERROR", JOptionPane.ERROR_MESSAGE);
        	else if((int)context.getData()== -999)
        		JOptionPane.showMessageDialog(null, "Error persistence", "ERROR", JOptionPane.ERROR_MESSAGE);
            break;
        case Events.DESVINCULAR_CURSO_OK:
            JOptionPane.showMessageDialog(null, "Trabajador con ID "+ context.getData()+" fue desvinculado de un curso","EXITO", JOptionPane.INFORMATION_MESSAGE);
            break;
        case Events.DESVINCULAR_CURSO_KO:
        	if((int)context.getData()== -96)
        		JOptionPane.showMessageDialog(null, "El trabajador y el curso no están vinculados", "ERROR", JOptionPane.ERROR_MESSAGE);
        	else if((int)context.getData()== -94)
        		JOptionPane.showMessageDialog(null, "El trabajador o el curso no está activo", "ERROR", JOptionPane.ERROR_MESSAGE);
        	else if((int)context.getData()== -95)
        		JOptionPane.showMessageDialog(null, "El trabajador o el curso es null", "ERROR", JOptionPane.ERROR_MESSAGE);
        	else if((int)context.getData()== -999)
        		JOptionPane.showMessageDialog(null, "Error persistence", "ERROR", JOptionPane.ERROR_MESSAGE);
            break;
        case Events.MOSTRAR_CURSOS_TRABAJADOR_OK:
			this._mostrarCursosTrabajador.update(context);
			break;
		case Events.MOSTRAR_CURSOS_TRABAJADOR_KO:
			JOptionPane.showMessageDialog(null, "El trabajador que desea mostrar sus cursos no existe.","ERROR", JOptionPane.ERROR_MESSAGE);		
			break;
			
		case Events.MOSTRAR_TRABAJADORES_OK:
			_mostrarTrabajadores.update(context);
			break;
		case Events.MOSTRAR_TRABAJADORES_KO:
			JOptionPane.showMessageDialog(null, "No se han podido mostrar todos los trabajadores","ERROR", JOptionPane.ERROR_MESSAGE);		
			break;
			
		case Events.MODIFICA_TRABAJADOR_OK:
			JOptionPane.showMessageDialog(null, "Trabajador con ID "+ context.getData()+" modificado correctamente","EXITO", JOptionPane.INFORMATION_MESSAGE);
		break;
		
		case Events.MODIFICA_TRABAJADOR_KO:
			if((int)context.getData()== -90) {
				JOptionPane.showMessageDialog(null, "El dni esta repetido", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if((int)context.getData()== -81) {
				JOptionPane.showMessageDialog(null, "El departamento no existe o no esta activo", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if((int)context.getData() == -999)
				JOptionPane.showMessageDialog(null, "Error persistence", "ERROR", JOptionPane.ERROR_MESSAGE);
			else if((int)context.getData() == -97)
				JOptionPane.showMessageDialog(null, "Error dni invalido", "ERROR", JOptionPane.ERROR_MESSAGE);
			else if((int)context.getData() == -98)
				JOptionPane.showMessageDialog(null, "Error correo invalido", "ERROR", JOptionPane.ERROR_MESSAGE);
			
			else JOptionPane.showMessageDialog(null, "Error no encontrado", "ERROR", JOptionPane.ERROR_MESSAGE);
		break;
		}
	}
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		
		this.setVisible(true);
		setTitle("Trabajadores");
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

		JLabel lblNewLabel = new JLabel("TRABAJADOR");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Consolas", Font.PLAIN, 32));
		panel.add(lblNewLabel);

		JPanel panel_botones = new JPanel();
		panel_botones.setBackground(new Color(32, 178, 170));
		contentPane.add(panel_botones, BorderLayout.CENTER);

		JButton _btnAltaTrabajadorT = new JButton("Alta de un trabajador temporal");
		_btnAltaTrabajadorT.setFont(new Font("Consolas", Font.PLAIN, 18));
		
		JButton _btnAltaTrabajadorI = new JButton("Alta de un trabajador indefinido");
		_btnAltaTrabajadorI.setFont(new Font("Consolas", Font.PLAIN, 18));

		JButton _btnBajaTrabajador = new JButton("Baja de un trabajador");
		_btnBajaTrabajador.setFont(new Font("Consolas", Font.PLAIN, 18));

		JButton _btnModificaTrabajador = new JButton("Actualizar trabajador");
		_btnModificaTrabajador.setFont(new Font("Consolas", Font.PLAIN, 18));

		JButton _btnMostrarTrabajador = new JButton("Mostrar trabajador");
		_btnMostrarTrabajador.setFont(new Font("Consolas", Font.PLAIN, 18));

		JButton _btnMostrarTodos = new JButton("Mostrar todos los trabajadores");
		_btnMostrarTodos.setFont(new Font("Consolas", Font.PLAIN, 18));
		
		JButton _vincularACurso = new JButton("Añadir curso a un trabajador");
		_vincularACurso.setFont(new Font("Consolas", Font.PLAIN, 18));
		
		JButton _desvincularDeCurso = new JButton("Eliminar curso de un trabajador");
		_desvincularDeCurso.setFont(new Font("Consolas", Font.PLAIN, 18));

		JButton _mostrarCursos = new JButton("Mostrar cursos de un trabajador");
		_mostrarCursos.setFont(new Font("Consolas", Font.PLAIN, 18));
		
		panel_botones.setLayout(new GridLayout(5, 2, 50, 25));
		panel_botones.add(_btnAltaTrabajadorT);
		panel_botones.add(_btnAltaTrabajadorI);
		panel_botones.add(_btnBajaTrabajador);
		panel_botones.add(_btnModificaTrabajador);
		panel_botones.add(_btnMostrarTrabajador);
		panel_botones.add(_btnMostrarTodos);
		panel_botones.add(_vincularACurso);
		panel_botones.add(_desvincularDeCurso);
		panel_botones.add(_mostrarCursos);

		JPanel _exitPanel = new JPanel();
		_exitPanel.setBackground(Color.white);
		contentPane.add(_exitPanel, BorderLayout.SOUTH);

		JButton _btnOut = new JButton("SALIR");
		_btnOut.setForeground(new Color(0, 0, 0));
		_btnOut.setFont(new Font("Consolas", Font.PLAIN, 32));
		_exitPanel.add(_btnOut);

		/* ActionListener */
		_btnAltaTrabajadorT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_altaTrabajadorT.init();		
			}
		});
		_btnAltaTrabajadorI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_altaTrabajadorI.init();		
			}
		});
		_btnBajaTrabajador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_bajaTrabajador.init();
			}
		});
		_btnModificaTrabajador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_updateTrabajador.init();
			}
		});
		_btnMostrarTrabajador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_mostrarTrabajador.init();
			}
		});
		_btnMostrarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_mostrarTrabajadores.init();
			}
		});
		_vincularACurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_asignarCurso.init();
			}
		});
		_desvincularDeCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_desvincularCurso.init();
			}
		});
		_mostrarCursos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_mostrarCursosTrabajador.init();
			}
		});
		
		_btnOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
	}

}
