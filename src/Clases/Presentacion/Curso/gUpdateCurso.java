package Clases.Presentación.Curso;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.OverlayLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.StringUtils;

import Clases.Negocio.Curso.TCurso;
import Clases.Negocio.Departamento.TDepartamento;
import Clases.Presentación.Contexto;
import Clases.Presentación.Command.Events;
import Clases.Presentación.Controller.Controller;

public class gUpdateCurso extends JFrame{

	private static final long serialVersionUID = 1L;

	private JButton btnBuscarID;
	//////////////////////////////////
	private JPanel contentPane;
	private JPanel overlayPane;
	///////////////////////////////////
	private JCheckBox chckActivo;
	private JTextField cuId;
	private JTextField cuNombre;
	private JTextField cuTipo;
	private JTextField cuHoras;
	private JTextField cuDesc;
	private JTextField cuNivel;
	private JTextField cuIdEmp;
	private JPanel panelCurso;
	private JButton btnModificar;
	
	public void init() {
		this.setVisible(true);
		setForeground(new Color(32, 178, 170));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(32, 178, 170));
		contentPane.setForeground(new Color(32, 178, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		// TODO Auto-generated method stub
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(32, 178, 170));
		panel.setForeground(new Color(32, 178, 170));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lbltitulo = new JLabel("Actualizar un curso");
		lbltitulo.setForeground(new Color(0, 0, 0));
		lbltitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbltitulo.setFont(new Font("Consolas", Font.PLAIN, 26));
		panel.add(lbltitulo, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(32, 178, 170));
		panel_1.setForeground(new Color(32, 178, 170));
		panel.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lbl_id = new JLabel("Inserte una ID, por favor :");
		lbl_id.setFont(new Font("Consolas", Font.PLAIN, 20));
		panel_1.add(lbl_id);
		
		cuId = new JTextField();
		cuId.setFont(new Font("Consolas", Font.PLAIN, 15));
		panel_1.add(cuId);
		cuId.setColumns(6);
		
		btnBuscarID = new JButton("Buscar");
		panel_1.add(btnBuscarID);
		
		JPanel btnera = new JPanel();
		contentPane.add(btnera, BorderLayout.SOUTH);
		btnera.setLayout(new GridLayout(1, 2, 0, 0));
		
		btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Consolas", Font.PLAIN, 20));
		btnera.add(btnModificar);
		btnModificar.setEnabled(false);
		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Consolas", Font.PLAIN, 20));
		btnera.add(btnSalir);
		
		overlayPane = new JPanel();
		overlayPane.setLayout(new OverlayLayout(overlayPane));
		contentPane.add(overlayPane, BorderLayout.CENTER);
		overlayPane.setBackground(new Color(32, 178, 170));
		
		panelCurso = new JPanel();
		panelCurso.setVisible(false);
		panelCurso.setBackground(new Color(32, 178, 170));
		panelCurso.setLayout(new GridLayout(8, 4, 25, 25));
		overlayPane.add(panelCurso);
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setFont(new Font("Consolas", Font.PLAIN, 20));
		panelCurso.add(lblNombre);
		
		cuNombre = new JTextField();
		panelCurso.add(cuNombre);
		cuNombre.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblTipo.setHorizontalAlignment(SwingConstants.CENTER);
		panelCurso.add(lblTipo);
		cuTipo = new JTextField();
		panelCurso.add(cuTipo);
		cuTipo.setColumns(10);
		
		JLabel lblHoras = new JLabel("Horas");
		lblHoras.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblHoras.setHorizontalAlignment(SwingConstants.CENTER);
		panelCurso.add(lblHoras);
		cuHoras = new JTextField();
		panelCurso.add(cuHoras);
		cuHoras.setColumns(10);
		
		JLabel lblNivel = new JLabel("Nivel");
		lblNivel.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNivel.setHorizontalAlignment(SwingConstants.CENTER);
		panelCurso.add(lblNivel);
		cuNivel = new JTextField();
		panelCurso.add(cuNivel);
		cuNivel.setColumns(10);
	
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblDescripcion.setHorizontalAlignment(SwingConstants.CENTER);
		panelCurso.add(lblDescripcion);
		cuDesc = new JTextField();
		panelCurso.add(cuDesc);
		cuDesc.setColumns(30);
		
		JLabel lblidEmp = new JLabel("IDEmpresa");
		lblidEmp.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblidEmp.setHorizontalAlignment(SwingConstants.CENTER);
		panelCurso.add(lblidEmp);
		cuIdEmp = new JTextField();
		panelCurso.add(cuIdEmp);
		cuIdEmp.setColumns(10);
		
		JLabel lblactivo = new JLabel("Activo");
		lblactivo.setHorizontalAlignment(SwingConstants.CENTER);
		lblactivo.setFont(new Font("Consolas", Font.PLAIN, 20));
		panelCurso.add(lblactivo);
		chckActivo = new JCheckBox("");
		chckActivo.setBackground(new Color(32, 178, 170));
		chckActivo.setHorizontalAlignment(SwingConstants.CENTER);
		panelCurso.add(chckActivo);
		
		
		btnBuscarID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if("".equals(cuId.getText())) {
						throw new Exception("El ID debe rellenarse");
					}
					if (!cuId.getText().matches("\\-?\\d+")) {
						throw new NumberFormatException("El ID debe ser un número");
					}
					int _id = Integer.parseInt(cuId.getText());
					if(_id<0) {
						throw new NumberFormatException("El ID debe ser positivo");
					}
					Controller.getInstance().action(new Contexto(
							Events.MODIFICA_CURSO,_id));
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.WARNING_MESSAGE);

				}
			}
		});
		
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nombre, tipo, descripcion;
					Integer horas, nivel;
					Boolean activo;
					Integer id, idEmp;
					
					if (!StringUtils.isEmptyOrWhitespaceOnly(cuNombre.getText()) && cuNombre.getText().length() < 101)
						nombre = (String) cuNombre.getText();
					else
						throw new Exception("Error de formato nombre");
					
					if (!StringUtils.isEmptyOrWhitespaceOnly(cuTipo.getText()) && cuTipo.getText().length() < 101)
						tipo = (String) (cuTipo.getText());
					else
						throw new Exception("Error de formato tipo");
					if (!StringUtils.isEmptyOrWhitespaceOnly(cuDesc.getText()) && cuDesc.getText().length() < 101)
						descripcion = (String) (cuDesc.getText());
					else
						throw new Exception("Error de formato descripcion");
					if (!StringUtils.isEmptyOrWhitespaceOnly(cuNivel.getText()) && cuNivel.getText().length() < 101)
						nivel = Integer.parseInt(cuNivel.getText());
					else
						throw new Exception("Error de formato nivel");
					if (!StringUtils.isEmptyOrWhitespaceOnly(cuIdEmp.getText()) && cuIdEmp.getText().length() < 101)
						idEmp = Integer.parseInt(cuIdEmp.getText());
					else
						throw new Exception("Error de formato Id empresa");
					if (cuHoras.getText().length() > 999)
						throw new NumberFormatException("El curso supera el maximo de 999 horas");
					else
						horas = Integer.parseInt(cuHoras.getText());
					
					activo = chckActivo.isSelected();

					id = Integer.parseInt(cuId.getText());
					Controller.getInstance().action(new Contexto(Events.MODIFICA_CURSO,
							new TCurso(nombre, activo, id ,tipo, descripcion, horas,nivel, idEmp)));
				} catch (Exception es) {
					JOptionPane.showMessageDialog(null, es.getMessage(), "ERROR", JOptionPane.WARNING_MESSAGE);
				}

			}
		});
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
	}
	
	public void update(Contexto tm) {
		TCurso cu = (TCurso) tm.getData();
		btnModificar.setEnabled(true);
		btnBuscarID.setVisible(false);
		cuId.setEditable(false);
		cuIdEmp.setEditable(true);
		panelCurso.setVisible(true);
		cuNombre.setText(cu.getNombre());
		cuTipo.setText(cu.getTipo());
		cuDesc.setText(cu.getDescripcion());
		cuNivel.setText(Integer.toString(cu.getNivel()));
		cuHoras.setText(Integer.toString(cu.getHoras()));
		chckActivo.setSelected(cu.isActivo());
		cuIdEmp.setText(String.valueOf(cu.getIdEmpresa()));
	}

}