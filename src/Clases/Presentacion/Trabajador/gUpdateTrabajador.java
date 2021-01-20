package Clases.Presentación.Trabajador;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

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
import com.toedter.calendar.JDateChooser;

import Clases.Negocio.Cliente.TCliente;
import Clases.Negocio.Cliente.TClienteEmpresa;
import Clases.Negocio.Cliente.TClienteParticulares;
import Clases.Negocio.Trabajador.TIndefinido;
import Clases.Negocio.Trabajador.TTemporal;
import Clases.Negocio.Trabajador.TTrabajador;
import Clases.Presentación.Contexto;
import Clases.Presentación.Command.Events;
import Clases.Presentación.Controller.Controller;

public class gUpdateTrabajador extends JFrame{

	/**
	 * 
	 */
	public gUpdateTrabajador() {
	}
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel overlayPane;
	private JTextField text_id;
	///////////////////////////////////
	private JCheckBox chckActivo; 
	private JTextField tfNombre;
	private JTextField tfDNI;
	private JTextField tfhm;
	private JTextField tfsph;
	private JTextField tfdir;
	private JTextField tftelf;
	private JTextField tfcorreo;
	private JTextField tfdep;
	private JPanel panelParticular;
	private JDateChooser calendar;
	private JDateChooser calendar2;
	// temporal
	//////////////////////////////////
	private JCheckBox chckActivo_I; 
	private JTextField tfNombre_I;
	private JTextField tfDNI_I;
	private JTextField tfdir_I;
	private JTextField tftelf_I;
	private JTextField tfcorreo_I;
	private JTextField tfdep_I;
	private JTextField tfnomina;
	private JTextField tfcomplemento;
	private JDateChooser calendar_I;
	private JPanel panelEmpresarial; 
	
	private Integer idTrabajador;
	
	///////////////////////
	public void init() {
		this.setVisible(true);
		setForeground(new Color(32, 178, 170));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 900);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(32, 178, 170));
		contentPane.setForeground(new Color(32, 178, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(32, 178, 170));
		panel.setForeground(new Color(32, 178, 170));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lbltitulo = new JLabel("Actualizar un trabajador");
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
		
		text_id = new JTextField();
		text_id.setFont(new Font("Consolas", Font.PLAIN, 15));
		panel_1.add(text_id);
		text_id.setColumns(5);
		
		JButton btnBuscarID = new JButton("Buscar");
		panel_1.add(btnBuscarID);
		
		
		JPanel btnera = new JPanel();
		contentPane.add(btnera, BorderLayout.SOUTH);
		btnera.setLayout(new GridLayout(1, 2, 0, 0));
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Consolas", Font.PLAIN, 20));
		btnera.add(btnModificar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Consolas", Font.PLAIN, 20));
		btnera.add(btnSalir);
		
		overlayPane = new JPanel();
		overlayPane.setLayout(new OverlayLayout(overlayPane));
		contentPane.add(overlayPane, BorderLayout.CENTER);
		overlayPane.setBackground(new Color(32, 178, 170));
		//////////////////////////////////////////////////////////////////////////////////////
		
		panelParticular= new JPanel();
		panelParticular.setVisible(false);
		panelParticular.setBackground(new Color(32, 178, 170));
		panelParticular.setLayout(new GridLayout(12, 4, 25, 25));
		overlayPane.add(panelParticular);
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setFont(new Font("Consolas", Font.PLAIN, 20));
		panelParticular.add(lblNombre);
		
		tfNombre = new JTextField();
		panelParticular.add(tfNombre);
		tfNombre.setColumns(10);
		
		JLabel lblDNI = new JLabel("DNI");
		lblDNI.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblDNI.setHorizontalAlignment(SwingConstants.CENTER);
		panelParticular.add(lblDNI);
		
		tfDNI = new JTextField();
		panelParticular.add(tfDNI);
		tfDNI.setColumns(10);
		
		
		JLabel lbldir = new JLabel("Direccion");
		lbldir.setHorizontalAlignment(SwingConstants.CENTER);
		lbldir.setFont(new Font("Consolas", Font.PLAIN, 20));
		panelParticular.add(lbldir);
		
		tfdir = new JTextField();
		panelParticular.add(tfdir);
		tfdir.setColumns(10);
		
		JLabel lbltelf = new JLabel("Telefono");
		lbltelf.setHorizontalAlignment(SwingConstants.CENTER);
		lbltelf.setFont(new Font("Consolas", Font.PLAIN, 20));
		panelParticular.add(lbltelf);
		
		tftelf = new JTextField();
		panelParticular.add(tftelf);
		tftelf.setColumns(10);
		
		JLabel lblcorreo = new JLabel("Correo");
		lblcorreo.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblcorreo.setHorizontalAlignment(SwingConstants.CENTER);
		panelParticular.add(lblcorreo);
		
		tfcorreo = new JTextField();
		panelParticular.add(tfcorreo);
		tfcorreo.setColumns(10);
		
		JLabel lblNewLabel_10_1 = new JLabel("Fecha inicio");
		lblNewLabel_10_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10_1.setFont(new Font("Consolas", Font.PLAIN, 20));
		panelParticular.add(lblNewLabel_10_1);
		
		calendar = new JDateChooser();
		//calendar.setMinSelectableDate(new Date(Calendar.getInstance().getTimeInMillis()));
		calendar.setDate(new Date(Calendar.getInstance().getTimeInMillis()));
		calendar.setFont(new Font("Consolas", Font.PLAIN, 20));
		panelParticular.add(calendar);
		
		JLabel lblNewLabel_10_2 = new JLabel("Fecha fin");
		lblNewLabel_10_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10_2.setFont(new Font("Consolas", Font.PLAIN, 20));
		panelParticular.add(lblNewLabel_10_2);
		
		calendar2 = new JDateChooser();
		//calendar2.setMinSelectableDate(new Date(Calendar.getInstance().getTimeInMillis()));
		calendar2.setDate(new Date(Calendar.getInstance().getTimeInMillis()));
		calendar2.setFont(new Font("Consolas", Font.PLAIN, 20));
		panelParticular.add(calendar2);
		
		JLabel lblactivo = new JLabel("Activo");
		lblactivo.setHorizontalAlignment(SwingConstants.CENTER);
		lblactivo.setFont(new Font("Consolas", Font.PLAIN, 20));
		panelParticular.add(lblactivo);
		
		chckActivo = new JCheckBox("");
		chckActivo.setBackground(new Color(32, 178, 170));
		chckActivo.setHorizontalAlignment(SwingConstants.CENTER);
		panelParticular.add(chckActivo);
		
		JLabel lbldep = new JLabel("Departamento ID");
		lbldep.setHorizontalAlignment(SwingConstants.CENTER);
		lbldep.setFont(new Font("Consolas", Font.PLAIN, 20));
		panelParticular.add(lbldep);
		
		tfdep = new JTextField();
		panelParticular.add(tfdep);
		tfdep.setColumns(10);
		
		JLabel lblhorasmensuales = new JLabel("Horas mensuales");
		lblhorasmensuales.setHorizontalAlignment(SwingConstants.CENTER);
		lblhorasmensuales.setFont(new Font("Consolas", Font.PLAIN, 20));
		panelParticular.add(lblhorasmensuales);
		
		tfhm = new JTextField();
		panelParticular.add(tfhm);
		tfhm.setColumns(10);
		
		JLabel lblsueldoph = new JLabel("Sueldo por horas:");
		lblsueldoph.setHorizontalAlignment(SwingConstants.CENTER);
		lblsueldoph.setFont(new Font("Consolas", Font.PLAIN, 20));
		panelParticular.add(lblsueldoph);
		
		tfsph = new JTextField();
		panelParticular.add(tfsph);
		tfsph.setColumns(10);
		
		//////////////////////////////////////////////////////////////////////////////////////
		panelEmpresarial= new JPanel();
		panelEmpresarial.setVisible(false);
		panelEmpresarial.setBackground(new Color(32, 178, 170));
		overlayPane.add(panelEmpresarial);
		panelEmpresarial.setLayout(new GridLayout(12, 4, 25, 25));
		
		JLabel lblNombre_I = new JLabel("Nombre");
		lblNombre_I.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre_I.setFont(new Font("Consolas", Font.PLAIN, 20));
		panelEmpresarial.add(lblNombre_I);
		
		tfNombre_I = new JTextField();
		panelEmpresarial.add(tfNombre_I);
		tfNombre_I.setColumns(10);
		
		JLabel lblDNI_I = new JLabel("DNI");
		lblDNI_I.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblDNI_I.setHorizontalAlignment(SwingConstants.CENTER);
		panelEmpresarial.add(lblDNI_I);
		
		tfDNI_I = new JTextField();
		panelEmpresarial.add(tfDNI_I);
		tfDNI_I.setColumns(10);
		
		
		JLabel lbldir_I = new JLabel("Direccion");
		lbldir_I.setHorizontalAlignment(SwingConstants.CENTER);
		lbldir_I.setFont(new Font("Consolas", Font.PLAIN, 20));
		panelEmpresarial.add(lbldir_I);
		
		tfdir_I = new JTextField();
		panelEmpresarial.add(tfdir_I);
		tfdir_I.setColumns(10);
		
		JLabel lbltelf_I = new JLabel("Telefono");
		lbltelf_I.setHorizontalAlignment(SwingConstants.CENTER);
		lbltelf_I.setFont(new Font("Consolas", Font.PLAIN, 20));
		panelEmpresarial.add(lbltelf_I);
		
		tftelf_I = new JTextField();
		panelEmpresarial.add(tftelf_I);
		tftelf_I.setColumns(10);
		
		JLabel lblcorreo_I = new JLabel("Correo");
		lblcorreo_I.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblcorreo_I.setHorizontalAlignment(SwingConstants.CENTER);
		panelEmpresarial.add(lblcorreo_I);
		
		tfcorreo_I = new JTextField();
		panelEmpresarial.add(tfcorreo_I);
		tfcorreo_I.setColumns(10);
		
		JLabel lbldep_I = new JLabel("Departamento ID");
		lbldep_I.setHorizontalAlignment(SwingConstants.CENTER);
		lbldep_I.setFont(new Font("Consolas", Font.PLAIN, 20));
		panelEmpresarial.add(lbldep_I);
		
		tfdep_I = new JTextField();
		panelEmpresarial.add(tfdep_I);
		tfdep_I.setColumns(10);
		
		JLabel lblnomina = new JLabel("Nomina");
		lblnomina.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblnomina.setHorizontalAlignment(SwingConstants.CENTER);
		panelEmpresarial.add(lblnomina);
		
		tfnomina = new JTextField();
		panelEmpresarial.add(tfnomina);
		tfnomina.setColumns(10);
		
		JLabel lblcomplemento = new JLabel("Complemento");
		lblcomplemento.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblcomplemento.setHorizontalAlignment(SwingConstants.CENTER);
		panelEmpresarial.add(lblcomplemento);
		
		tfcomplemento = new JTextField();
		panelEmpresarial.add(tfcomplemento);
		tfcomplemento.setColumns(10);
		
		JLabel lblfecha_I = new JLabel("Fecha ini");
		lblfecha_I.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblfecha_I.setHorizontalAlignment(SwingConstants.CENTER);
		panelEmpresarial.add(lblfecha_I);

		calendar_I = new JDateChooser();
		calendar_I.setFont(new Font("Consolas", Font.PLAIN, 20));
		calendar_I.setMinSelectableDate(new Date(Calendar.getInstance().getTimeInMillis()));
		calendar_I.setDate(new Date(Calendar.getInstance().getTimeInMillis()));
		panelEmpresarial.add(calendar_I);
		
		JLabel lblactivo_I = new JLabel("Activo");
		lblactivo_I.setHorizontalAlignment(SwingConstants.CENTER);
		lblactivo_I.setFont(new Font("Consolas", Font.PLAIN, 20));
		panelEmpresarial.add(lblactivo_I);
		
		chckActivo_I = new JCheckBox("");
		chckActivo_I.setBackground(new Color(32, 178, 170));
		chckActivo_I.setHorizontalAlignment(SwingConstants.CENTER);
		panelEmpresarial.add(chckActivo_I);
		//////////////////////////////////////////////////////////////////////////////////////
		btnBuscarID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					idTrabajador = Integer.parseInt(text_id.getText());
					Controller.getInstance().action(new Contexto(							
							Events.MODIFICA_TRABAJADOR, idTrabajador));
					
				}catch(Exception es) {
					JOptionPane.showMessageDialog(null, es.getMessage(),"ERROR",JOptionPane.WARNING_MESSAGE);
				}
				
				
			}	
		});
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nombre,correo,direccion,dni,nombre_I,correo_I, dir_I, dni_I;
					 Long telf,telf_I;
					 Boolean activo, activo_I;
					Integer idDep,horasmensuales;
					 Date fecha,fecha_fin, fecha_I;
					 Float nomina,complemento, sueldoPH;
					if(panelParticular.isVisible()) {
						 if(!StringUtils.isEmptyOrWhitespaceOnly(tfNombre.getText()) && tfNombre.getText().length()<101 ) { nombre= (String) tfNombre.getText();}
						 else throw new Exception("Error de formato");
						 if(!StringUtils.isEmptyOrWhitespaceOnly(tfdir.getText()) && tfdir.getText().length()<101 ) {  direccion = (String) (tfdir.getText());}
						 else throw new Exception("Error de formato");
						 if(!StringUtils.isEmptyOrWhitespaceOnly(tfhm.getText()) && tfhm.getText().length()<730 && tfhm.getText().length()>0 ) {  horasmensuales = Integer.parseInt(tfhm.getText());}
						 else throw new Exception("Error de formato");
						 if(!StringUtils.isEmptyOrWhitespaceOnly(tfsph.getText()) && tfsph.getText().length()<6 ) {  sueldoPH = Float.parseFloat(tfsph.getText());}
						 else throw new Exception("Error de formato");
						 if(!StringUtils.isEmptyOrWhitespaceOnly(tfdir.getText()) && tfdir.getText().length()<101 ) {  direccion = (String) (tfdir.getText());}
						 else throw new Exception("Error de formato");
						 if(!StringUtils.isEmptyOrWhitespaceOnly(tfcorreo.getText()) && tfcorreo.getText().length()<101 ) { correo = (String) (tfcorreo.getText());}
						 else throw new Exception("Error de formato");
						 if(!StringUtils.isEmptyOrWhitespaceOnly(tfDNI.getText()) && tfDNI.getText().length()<10 ) { dni = (String) (tfDNI.getText());}
						 else throw new Exception("Error de formato");
						 if(tftelf.getText().length()!=9) throw new NumberFormatException("El telefono tiene que tener 9 numeros");
						 else telf = Long.parseLong(tftelf.getText());
						 if(chckActivo.isSelected()) activo=true;
						 else activo=false;
						 idDep=Integer.parseInt(tfdep.getText());
						 fecha = calendar.getDate();
						 if(fecha ==null) throw new Exception("Elija una fecha de inicio");
						 fecha_fin = calendar2.getDate();
						 if(fecha_fin ==null) throw new Exception("Elija una fecha de final");
						 Controller.getInstance().action(
									new Contexto(
										Events.MODIFICA_TRABAJADOR_T, new TTemporal(dni,idTrabajador,nombre, telf, direccion, fecha, correo, activo, idDep, fecha_fin, sueldoPH, horasmensuales)));
						 
					}
					else if(panelEmpresarial.isVisible()){
						 if(!StringUtils.isEmptyOrWhitespaceOnly(tfNombre_I.getText()) && tfNombre_I.getText().length()<101 ) { nombre_I= (String) tfNombre_I.getText();}
						 else throw new Exception("Error de formato");
						 if(!StringUtils.isEmptyOrWhitespaceOnly(tfdir_I.getText()) && tfdir_I.getText().length()<101 ) {  dir_I = (String) (tfdir_I.getText());}
						 else throw new Exception("Error de formato");
						 if(!StringUtils.isEmptyOrWhitespaceOnly(tfcorreo_I.getText()) && tfcorreo_I.getText().length()<101 ) { correo_I = (String) (tfcorreo_I.getText());}
						 else throw new Exception("Error de formato");
						 if(!StringUtils.isEmptyOrWhitespaceOnly(tfDNI_I.getText()) && tfDNI_I.getText().length()<10 ) { dni_I = (String) (tfDNI_I.getText());}
						 else throw new Exception("Error de formato");
						 if(tftelf_I.getText().length()!=9) throw new NumberFormatException("El teléfono tiene que tener 9 números");
						 else telf_I = Long.parseLong(tftelf.getText());
						 if(chckActivo.isSelected()) activo_I=true;
						 else activo_I=false;
						 idDep=Integer.parseInt(tfdep_I.getText());
						 complemento=Float.parseFloat(tfcomplemento.getText());
						 nomina=Float.parseFloat(tfnomina.getText());
						 fecha_I = calendar_I.getDate();
						 if(fecha_I ==null) throw new Exception("Elija una fecha de inicio");
						 Controller.getInstance().action(
									new Contexto(
										Events.MODIFICA_TRABAJADOR_I, new TIndefinido(dni_I,idTrabajador, nombre_I, telf_I, dir_I, fecha_I, correo_I, activo_I, idDep, nomina, complemento)));
						 
					}else throw new Exception("Debes seleccionar un trabajador que modificar.");
					
				}catch(Exception es) {
					JOptionPane.showMessageDialog(null, es.getMessage(),"ERROR",JOptionPane.WARNING_MESSAGE);
				}
				
				
			}		
		});
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}		
		});
		
	}
	public void update(TTrabajador tc) {
		panelParticular.setVisible(false);
		panelEmpresarial.setVisible(false);
		if(tc.getClass().equals(TIndefinido.class))
		{
			TIndefinido tce= (TIndefinido) tc;
			panelEmpresarial.setVisible(true);
			tfnomina.setText(Float.toString(tce.getNomina()));
			tfcomplemento.setText(Float.toString(tce.getComplemento()));
			tfdir_I.setText(tce.getDireccion());
			tftelf_I.setText(Long.toString(tce.getTelefono()));
			tfNombre_I.setText(tce.getNombre());
			tfcorreo_I.setText(tce.getCorreo());
			chckActivo.setSelected(tce.isActivo());
			calendar_I.setDate(tce.getFechainicio());
			tfdep_I.setText(Integer.toString(tce.getIdDepartamento()));
			chckActivo_I.setSelected(tce.isActivo());
			tfDNI_I.setText(tce.getDNI());
		}
		else{ 
			TTemporal tcp= (TTemporal) tc;
			panelParticular.setVisible(true);
			calendar.setDate(tcp.getFechainicio());
			calendar2.setDate(tcp.getFechaFin());
			tfDNI.setText(tcp.getDNI());
			tfdir.setText(tcp.getDireccion());
			tftelf.setText(Long.toString(tcp.getTelefono()));
			tfNombre.setText(tcp.getNombre());
			tfcorreo.setText(tcp.getCorreo());
			chckActivo.setSelected(tcp.isActivo());
			tfhm.setText(Integer.toString(tcp.getHorasMensuales()));
			tfsph.setText(Float.toString(tcp.getSueldoPH()));
			tfdep.setText(Integer.toString(tcp.getIdDepartamento()));
		}
	}
	
}
