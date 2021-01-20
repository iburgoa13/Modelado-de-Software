/**
 * 
 */
package Clases.Presentación.Cliente;

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

import Clases.Negocio.Cliente.TCliente;
import Clases.Negocio.Cliente.TClienteEmpresa;
import Clases.Negocio.Cliente.TClienteParticulares;
import Clases.Presentación.Contexto;
import Clases.Presentación.Command.Events;
import Clases.Presentación.Controller.Controller;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author Mario, Javier, Yule, David, Alberto, Iker, Fernando, Francisco
 * @generated "UML a Java
 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class gUpdateCliente extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public gUpdateCliente() {
	}
	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private JPanel contentPane;
	private JPanel overlayPane;
	///////////////////////////////////
	private JCheckBox chckActivo; 
	private JTextField tfNombre;
	private JTextField tfDNI;
	private JTextField tfapellidos;
	private JTextField tfcuenta;
	private JTextField tfdir;
	private JTextField tftelf;
	private JTextField tfcorreo;
	private JPanel panelParticular;
	//////////////////////////////////
	private JTextField tfNombre_E;
	private JCheckBox chckActivo_E; 
	private JTextField tfCIF;
	private JTextField tfcuenta_E;
	private JTextField tfdir_E;
	private JTextField tftelf_E;
	private JTextField tfcorreo_E;
	private JPanel panelEmpresarial; 
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
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(32, 178, 170));
		panel.setForeground(new Color(32, 178, 170));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lbltitulo = new JLabel("Actualizar un cliente");
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
		
		JTextField text_id = new JTextField();
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
		panelParticular.setLayout(new GridLayout(8, 4, 25, 25));
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
		
		JLabel lblncuenta = new JLabel("N\u00BA de cuenta");
		lblncuenta.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblncuenta.setHorizontalAlignment(SwingConstants.CENTER);
		panelParticular.add(lblncuenta);
		
		tfcuenta = new JTextField();
		panelParticular.add(tfcuenta);
		tfcuenta.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblApellidos.setHorizontalAlignment(SwingConstants.CENTER);
		panelParticular.add(lblApellidos);
		
		tfapellidos = new JTextField();
		panelParticular.add(tfapellidos);
		tfapellidos.setColumns(10);
		
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
		
		JLabel lblactivo = new JLabel("Activo");
		lblactivo.setHorizontalAlignment(SwingConstants.CENTER);
		lblactivo.setFont(new Font("Consolas", Font.PLAIN, 20));
		panelParticular.add(lblactivo);
		
		chckActivo = new JCheckBox("");
		chckActivo.setBackground(new Color(32, 178, 170));
		chckActivo.setHorizontalAlignment(SwingConstants.CENTER);
		panelParticular.add(chckActivo);
		//////////////////////////////////////////////////////////////////////////////////////
		panelEmpresarial= new JPanel();
		panelEmpresarial.setVisible(false);
		panelEmpresarial.setBackground(new Color(32, 178, 170));
		overlayPane.add(panelEmpresarial);
		panelEmpresarial.setLayout(new GridLayout(8, 4, 25, 25));
		
		JLabel lblNombre_E = new JLabel("Nombre");
		lblNombre_E.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre_E.setFont(new Font("Consolas", Font.PLAIN, 20));
		panelEmpresarial.add(lblNombre_E);
		
		tfNombre_E = new JTextField();
		panelEmpresarial.add(tfNombre_E);
		tfNombre_E.setColumns(10);
		
		JLabel lblCIF = new JLabel("CIF");
		lblCIF.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblCIF.setHorizontalAlignment(SwingConstants.CENTER);
		panelEmpresarial.add(lblCIF);
		
		tfCIF = new JTextField();
		panelEmpresarial.add(tfCIF);
		tfCIF.setColumns(10);
		
		JLabel lblncuenta_E = new JLabel("N\u00BA de cuenta");
		lblncuenta_E.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblncuenta_E.setHorizontalAlignment(SwingConstants.CENTER);
		panelEmpresarial.add(lblncuenta_E);
		
		tfcuenta_E = new JTextField();
		panelEmpresarial.add(tfcuenta_E);
		tfcuenta_E.setColumns(10);
		
		
		JLabel lbldir_E = new JLabel("Direccion");
		lbldir_E.setHorizontalAlignment(SwingConstants.CENTER);
		lbldir_E.setFont(new Font("Consolas", Font.PLAIN, 20));
		panelEmpresarial.add(lbldir_E);
		
		tfdir_E = new JTextField();
		panelEmpresarial.add(tfdir_E);
		tfdir_E.setColumns(10);
		
		JLabel lbltelf_E = new JLabel("Telefono");
		lbltelf_E.setHorizontalAlignment(SwingConstants.CENTER);
		lbltelf_E.setFont(new Font("Consolas", Font.PLAIN, 20));
		panelEmpresarial.add(lbltelf_E);
		
		tftelf_E = new JTextField();
		panelEmpresarial.add(tftelf_E);
		tftelf_E.setColumns(10);
		
		JLabel lblcorreo_E = new JLabel("Correo");
		lblcorreo_E.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblcorreo_E.setHorizontalAlignment(SwingConstants.CENTER);
		panelEmpresarial.add(lblcorreo_E);
		
		tfcorreo_E = new JTextField();
		panelEmpresarial.add(tfcorreo_E);
		tfcorreo_E.setColumns(10);
		
		JLabel lblactivo_E = new JLabel("Activo");
		lblactivo_E.setHorizontalAlignment(SwingConstants.CENTER);
		lblactivo_E.setFont(new Font("Consolas", Font.PLAIN, 20));
		panelEmpresarial.add(lblactivo_E);
		
		chckActivo_E = new JCheckBox("");
		chckActivo_E.setBackground(new Color(32, 178, 170));
		chckActivo_E.setHorizontalAlignment(SwingConstants.CENTER);
		panelEmpresarial.add(chckActivo_E);
		//////////////////////////////////////////////////////////////////////////////////////
		btnBuscarID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Controller.getInstance().action(new Contexto(
							
							Events.MOD_CLIENTE,Integer.parseInt(text_id.getText())));
					
				}catch(Exception es) {
					JOptionPane.showMessageDialog(null, es.getMessage(),"ERROR",JOptionPane.WARNING_MESSAGE);
				}
				
				
			}	
		});
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nombre,correo,direccion,cif,nombre_P,correo_P, dir_P, apellidos_P, dni_P;
					 Long ncuenta,telf,ncuenta_P,telf_P;
					 Boolean activo_e, activo_P;
					 Integer ide,idp;
					if(panelEmpresarial.isVisible()) {
						 if(!StringUtils.isEmptyOrWhitespaceOnly(tfNombre_E.getText()) && tfNombre_E.getText().length()<101 ) { nombre= (String) tfNombre_E.getText();}
						 else throw new Exception("Error de formato");
						 if(!StringUtils.isEmptyOrWhitespaceOnly(tfCIF.getText()) && tfCIF.getText().length()==9 ) { cif = (String) tfCIF.getText();}
						 else throw new Exception("Error de formato");
						 if(!StringUtils.isEmptyOrWhitespaceOnly(tfdir_E.getText()) && tfdir_E.getText().length()<101 ) {  direccion = (String) (tfdir_E.getText());}
						 else throw new Exception("Error de formato");
						 if(!StringUtils.isEmptyOrWhitespaceOnly(tfcorreo_E.getText()) && tfcorreo_E.getText().length()<101 ) { correo = (String) (tfcorreo_E.getText());}
						 else throw new Exception("Error de formato");
						 if(tfcuenta_E.getText().length()!=15) throw new NumberFormatException("El número de cuenta tiene que tener 15 números");
						 else ncuenta = Long.parseLong(tfcuenta_E.getText());
						 if(tftelf_E.getText().length()!=9) throw new NumberFormatException("El teléfono tiene que tener 9 números");
						 else telf = Long.parseLong(tftelf_E.getText());
						 if(chckActivo_E.isSelected()) activo_e=true;
						 else activo_e=false;
						 ide=Integer.parseInt(text_id.getText());
						 Controller.getInstance().action(
									new Contexto(
										Events.MOD_CLIENTE_E, new TClienteEmpresa(ide,telf, activo_e, correo, direccion, ncuenta, nombre, cif)));
						 
					}
					else if(panelParticular.isVisible()){
						 if(!StringUtils.isEmptyOrWhitespaceOnly(tfNombre.getText()) && tfNombre.getText().length()<101 ) { nombre_P= (String) tfNombre.getText();}
						 else throw new Exception("Error de formato");
						 if(!StringUtils.isEmptyOrWhitespaceOnly(tfapellidos.getText()) && tfapellidos.getText().length()<101 ) { apellidos_P = (String) tfapellidos.getText();}
						 else throw new Exception("Error de formato");
						 if(!StringUtils.isEmptyOrWhitespaceOnly(tfdir.getText()) && tfdir.getText().length()<101 ) {  dir_P = (String) (tfdir.getText());}
						 else throw new Exception("Error de formato");
						 if(!StringUtils.isEmptyOrWhitespaceOnly(tfcorreo.getText()) && tfcorreo.getText().length()<101 ) { correo_P = (String) (tfcorreo.getText());}
						 else throw new Exception("Error de formato");
						 if(!StringUtils.isEmptyOrWhitespaceOnly(tfDNI.getText()) && tfDNI.getText().length()<10 ) { dni_P = (String) (tfDNI.getText());}
						 else throw new Exception("Error de formato");
						 if(tfcuenta.getText().length()!=15) throw new NumberFormatException("El número de cuenta tiene que tener 15 números");
						 else ncuenta_P = Long.parseLong(tfcuenta.getText());
						 if(tftelf.getText().length()!=9) throw new NumberFormatException("El teléfono tiene que tener 9 números");
						 else telf_P = Long.parseLong(tftelf.getText());
						 if(chckActivo.isSelected()) activo_P=true;
						 else activo_P=false;
						 idp=Integer.parseInt(text_id.getText());
						 Controller.getInstance().action(
									new Contexto(
										Events.MOD_CLIENTE_P, new TClienteParticulares(idp,telf_P,activo_P,correo_P,dir_P,ncuenta_P,dni_P,nombre_P,apellidos_P)));
						 
					}else throw new Exception("Debes seleccionar un cliente que modificar.");
					
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
	public void update(TCliente tc) {
		panelParticular.setVisible(false);
		panelEmpresarial.setVisible(false);
		if(tc.getClass().equals(TClienteEmpresa.class))
		{
			TClienteEmpresa tce= (TClienteEmpresa) tc;
			panelEmpresarial.setVisible(true);
			tfCIF.setText(tce.getCif());
			tfdir_E.setText(tce.getDireccion());
			tftelf_E.setText(Long.toString(tce.getTelefono()));
			tfcuenta_E.setText(Long.toString(tce.getNcuenta()));
			tfNombre_E.setText(tce.getNombre());
			tfcorreo_E.setText(tce.getCorreo());
			chckActivo_E.setSelected(tce.getActivo());
				
		}
		else{ 
			TClienteParticulares tcp= (TClienteParticulares) tc;
			panelParticular.setVisible(true);
			tfDNI.setText(tcp.getDNI());
			tfdir.setText(tcp.getDireccion());
			tfapellidos.setText(tcp.getApellido());
			tftelf.setText(Long.toString(tcp.getTelefono()));
			tfcuenta.setText(Long.toString(tcp.getNcuenta()));
			tfNombre.setText(tcp.getNombre());
			tfcorreo.setText(tcp.getCorreo());
			chckActivo.setSelected(tcp.getActivo());
		}
	}
			// TODO Auto-generated method stub
		
	
	
}