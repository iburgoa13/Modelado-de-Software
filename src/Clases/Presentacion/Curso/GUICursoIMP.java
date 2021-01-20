package Clases.Presentación.Curso;

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


public class GUICursoIMP extends GUICurso{

	private static final long serialVersionUID = 1L;
	private gAltaCurso _altaCurso;
	private gBajaCurso _bajaCurso;
	private gUpdateCurso _updateCurso;
	private gMostrarCurso _mostrarCurso;
	private gMostrarCursos _mostrarCursos;
	private gMostrarTrabajadoresCurso _mostrarTrabajadoresCurso;
	private JPanel contentPane;
	
	
	public GUICursoIMP() {
		initialize();
		init();
	}
	
	private void init() {
		this._altaCurso = new gAltaCurso();
		this._bajaCurso = new gBajaCurso();
		this._updateCurso = new gUpdateCurso();
		this._mostrarCurso = new gMostrarCurso();
		this._mostrarCursos = new gMostrarCursos();
		this._mostrarTrabajadoresCurso = new gMostrarTrabajadoresCurso();
	}

	
	// hacer fallos
	@Override
	public void update(Contexto context) {
		switch(context.getEvent()) {
		
		
			case Events.MODIFICA_CURSO_OK:
				JOptionPane.showMessageDialog(null, "Curso con ID "+ context.getData()+" modificado correctamente","EXITO", JOptionPane.INFORMATION_MESSAGE);
			break;
			
			case Events.MODIFICA_CURSO_KO:
				if((int)context.getData()==-100) {
					JOptionPane.showMessageDialog(null, "El curso que desea modificar no existe.","ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else if((int)context.getData()==-105) {
					JOptionPane.showMessageDialog(null, "El nivel del curso no es valido.", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else if((int)context.getData()==-103) {
					JOptionPane.showMessageDialog(null, "El tipo del curso no es válido.", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else if((int)context.getData()==-104) {
					JOptionPane.showMessageDialog(null, "Las horas del curso no son validas.", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else if((int)context.getData()==-74) {
					JOptionPane.showMessageDialog(null, "La empresa no existe.", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else if((int)context.getData()==-101) {
					JOptionPane.showMessageDialog(null, "El nombre introducido ya existe.", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else if((int)context.getData()==-999) {
					JOptionPane.showMessageDialog(null, "Error persistence.", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else 
					JOptionPane.showMessageDialog(null, "El id de el curso no existe", "ERROR", JOptionPane.ERROR_MESSAGE);
				break;
			case Events.MODIFICA_CURSO_READ_OK:
				this._updateCurso.update(context);
				break;
			case Events.MODIFICA_CURSO_READ_KO:
				JOptionPane.showMessageDialog(null, "El curso que desea modificar no existe.","ERROR", JOptionPane.ERROR_MESSAGE);		
				break;
			case Events.ALTA_CURSO_OK:
				JOptionPane.showMessageDialog(null, "Curso con ID "+ context.getData()+" añadido correctamente","EXITO", JOptionPane.INFORMATION_MESSAGE);
				break;
			case Events.ALTA_CURSO_KO:
				if((int)context.getData()==-105) {
				JOptionPane.showMessageDialog(null, "El nivel del curso no es valido.", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if((int)context.getData()==-103) {
				JOptionPane.showMessageDialog(null, "El tipo del curso no es válido.", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if((int)context.getData()==-74) {
				JOptionPane.showMessageDialog(null, "La empresa no existe.", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if((int)context.getData()==-104) {
				JOptionPane.showMessageDialog(null, "Las horas del curso no son validas.", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if((int)context.getData() == -101)
					JOptionPane.showMessageDialog(null, "Nombre repetido.", "ERROR", JOptionPane.ERROR_MESSAGE);
				else 
					JOptionPane.showMessageDialog(null, "El ID de la empresa no existe.", "ERROR", JOptionPane.ERROR_MESSAGE);
				break;
			case Events.BAJA_CURSO_KO:
				if((int)context.getData() == -100)
					JOptionPane.showMessageDialog(null, "El ID curso no existe", "ERROR", JOptionPane.ERROR_MESSAGE);
				else if((int)context.getData() == -999)
					JOptionPane.showMessageDialog(null, "Error persistence", "ERROR", JOptionPane.ERROR_MESSAGE);
				else if((int)context.getData() == -102)
					JOptionPane.showMessageDialog(null, "El curso ya esta dada de baja.", "ERROR", JOptionPane.ERROR_MESSAGE);
				break;
			case Events.BAJA_CURSO_OK:
				JOptionPane.showMessageDialog(null, "Curso con ID "+ context.getData()+" eliminada correctamente","EXITO", JOptionPane.INFORMATION_MESSAGE);
				break;
			case Events.MOSTRAR_CURSO_OK:
				this._mostrarCurso.update(context);
				break;
			case Events.MOSTRAR_CURSO_KO:
				JOptionPane.showMessageDialog(null, "El curso que desea mostrar no existe.","ERROR", JOptionPane.ERROR_MESSAGE);		
				break;
			case Events.MOSTRAR_CURSOS_OK:
				this._mostrarCursos.update(context);
				break;
			case Events.MOSTRAR_CURSOS_KO:
				JOptionPane.showMessageDialog(null, "No se han podido mostrar los cursos.","ERROR", JOptionPane.ERROR_MESSAGE);		
				break;
			case Events.MOSTRAR_TRABAJADORES_CURSO_OK:
				this._mostrarTrabajadoresCurso.update(context);
				break;
			case Events.MOSTRAR_TRABAJADORES_CURSO_KO:
				JOptionPane.showMessageDialog(null, "No se ha podido mostrar los trabajadores del curso.","ERROR", JOptionPane.ERROR_MESSAGE);		
				break;
		}
	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		this.setVisible(true);
		setTitle("Cursos");
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

		JLabel lblNewLabel = new JLabel("CURSOS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Consolas", Font.PLAIN, 32));
		panel.add(lblNewLabel);

		JPanel panel_botones = new JPanel();
		panel_botones.setBackground(new Color(32, 178, 170));
		contentPane.add(panel_botones, BorderLayout.CENTER);

		JButton _btnAltaCurso = new JButton("Alta de un curso");
		_btnAltaCurso.setFont(new Font("Consolas", Font.PLAIN, 18));

		JButton _btnBajaCurso = new JButton("Baja de un curso");
		_btnBajaCurso.setFont(new Font("Consolas", Font.PLAIN, 18));

		JButton _btnModificaCurso = new JButton("Actualizar curso");
		_btnModificaCurso.setFont(new Font("Consolas", Font.PLAIN, 18));

		JButton _btnMostrarUnaCurso = new JButton("Mostrar curso");
		_btnMostrarUnaCurso.setFont(new Font("Consolas", Font.PLAIN, 18));

		JButton _btnMostrarTodos = new JButton("Mostrar todos los cursos");
		_btnMostrarTodos.setFont(new Font("Consolas", Font.PLAIN, 18));
		
		JButton _btnMostrarTrabajadoresCurso = new JButton("Mostrar trabajadores de un curso");
		_btnMostrarTrabajadoresCurso.setFont(new Font("Consolas", Font.PLAIN, 18));
		

		panel_botones.setLayout(new GridLayout(4, 2, 50, 25));
		panel_botones.add(_btnAltaCurso);
		panel_botones.add(_btnBajaCurso);
		panel_botones.add(_btnModificaCurso);
		panel_botones.add(_btnMostrarUnaCurso);
		panel_botones.add(_btnMostrarTodos);
		panel_botones.add(_btnMostrarTrabajadoresCurso);

		JPanel _exitPanel = new JPanel();
		_exitPanel.setBackground(Color.white);
		contentPane.add(_exitPanel, BorderLayout.SOUTH);

		JButton _btnOut = new JButton("SALIR");
		_btnOut.setForeground(new Color(0, 0, 0));
		_btnOut.setFont(new Font("Consolas", Font.PLAIN, 32));
		_exitPanel.add(_btnOut);

		/* ActionListener */
		_btnAltaCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_altaCurso.init();
				
			}
		});
		_btnBajaCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_bajaCurso.init();
			}
		});
		_btnModificaCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_updateCurso.init();
			}
		});
		_btnMostrarUnaCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_mostrarCurso.init();
			}
		});
		_btnMostrarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_mostrarCursos.init();
			}
		});
		_btnMostrarTrabajadoresCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_mostrarTrabajadoresCurso.init();
				
			}
		});
		_btnOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}


}
