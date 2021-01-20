package Clases.Presentación.Empresa;

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

import Clases.Negocio.Empresa.TEmpresa;
import Clases.Negocio.Marca.TMarca;
import Clases.Negocio.Producto.TProducto;
import Clases.Presentación.Contexto;
import Clases.Presentación.Command.Events;
import Clases.Presentación.Controller.Controller;

public class gUpdateEmpresa extends JFrame{

	private static final long serialVersionUID = 1L;

	private JButton btnBuscarID;
	//////////////////////////////////
	private JPanel contentPane;
	private JPanel overlayPane;
	///////////////////////////////////
	private JCheckBox chckActivo;
	private JTextField tfCIF;
	private JTextField tfId;
	private JTextField tfNombre;
	private JTextField tfSector;
	private JTextField tfdir;
	private JTextField tftelf;
	private JTextField tfcorreo;
	private JPanel panelEmpresa;
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
		
		JLabel lbltitulo = new JLabel("Actualizar una empresa");
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
		
		tfId = new JTextField();
		tfId.setFont(new Font("Consolas", Font.PLAIN, 15));
		panel_1.add(tfId);
		tfId.setColumns(6);
		
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
		
		panelEmpresa = new JPanel();
		panelEmpresa.setVisible(false);
		panelEmpresa.setBackground(new Color(32, 178, 170));
		panelEmpresa.setLayout(new GridLayout(8, 4, 25, 25));
		overlayPane.add(panelEmpresa);
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setFont(new Font("Consolas", Font.PLAIN, 20));
		panelEmpresa.add(lblNombre);
		
		tfNombre = new JTextField();
		panelEmpresa.add(tfNombre);
		tfNombre.setColumns(10);
		
		JLabel lblCIF = new JLabel("CIF");
		lblCIF.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblCIF.setHorizontalAlignment(SwingConstants.CENTER);
		panelEmpresa.add(lblCIF);
		tfCIF = new JTextField();
		panelEmpresa.add(tfCIF);
		tfCIF.setColumns(10);
		
		JLabel lblSector = new JLabel("Sector");
		lblSector.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblSector.setHorizontalAlignment(SwingConstants.CENTER);
		panelEmpresa.add(lblSector);
		tfSector = new JTextField();
		panelEmpresa.add(tfSector);
		tfSector.setColumns(10);
		
		JLabel lbldir = new JLabel("Direccion");
		lbldir.setHorizontalAlignment(SwingConstants.CENTER);
		lbldir.setFont(new Font("Consolas", Font.PLAIN, 20));
		panelEmpresa.add(lbldir);

		tfdir = new JTextField();
		panelEmpresa.add(tfdir);
		tfdir.setColumns(10);
		
		JLabel lbltelf = new JLabel("Telefono");
		lbltelf.setHorizontalAlignment(SwingConstants.CENTER);
		lbltelf.setFont(new Font("Consolas", Font.PLAIN, 20));
		panelEmpresa.add(lbltelf);

		tftelf = new JTextField();
		panelEmpresa.add(tftelf);
		tftelf.setColumns(10);
		
		JLabel lblcorreo = new JLabel("Correo");
		lblcorreo.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblcorreo.setHorizontalAlignment(SwingConstants.CENTER);
		panelEmpresa.add(lblcorreo);

		tfcorreo = new JTextField();
		panelEmpresa.add(tfcorreo);
		tfcorreo.setColumns(10);
		
		JLabel lblactivo = new JLabel("Activo");
		lblactivo.setHorizontalAlignment(SwingConstants.CENTER);
		lblactivo.setFont(new Font("Consolas", Font.PLAIN, 20));
		panelEmpresa.add(lblactivo);

		chckActivo = new JCheckBox("");
		chckActivo.setBackground(new Color(32, 178, 170));
		chckActivo.setHorizontalAlignment(SwingConstants.CENTER);
		panelEmpresa.add(chckActivo);
		
		
		btnBuscarID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if("".equals(tfId.getText())) {
						throw new Exception("El ID debe rellenarse");
					}
					if (!tfId.getText().matches("\\-?\\d+")) {
						throw new NumberFormatException("El ID debe ser un número");
					}
					int _id = Integer.parseInt(tfId.getText());
					if(_id<0) {
						throw new NumberFormatException("El ID debe ser positivo");
					}
					Controller.getInstance().action(new Contexto(
							Events.MODIFICA_EMPRESA,_id));
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.WARNING_MESSAGE);

				}
			}
		});
		
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nombre, correo, direccion, sector, CIF;
					Long telf;
					Boolean activo;
					Integer id;
					if (!StringUtils.isEmptyOrWhitespaceOnly(tfCIF.getText()) && tfCIF.getText().length() == 9)
						CIF = (String) tfCIF.getText();
					else
						throw new Exception("Error de formato CIF");
					
					if (!StringUtils.isEmptyOrWhitespaceOnly(tfNombre.getText()) && tfNombre.getText().length() < 101)
						nombre = (String) tfNombre.getText();
					else
						throw new Exception("Error de formato nombre");
					
					if (!StringUtils.isEmptyOrWhitespaceOnly(tfSector.getText()) && tfSector.getText().length() < 101)
						sector = (String) tfSector.getText();
					else
						throw new Exception("Error de formato sector");
					if (!StringUtils.isEmptyOrWhitespaceOnly(tfdir.getText()) && tfdir.getText().length() < 101)
						direccion = (String) (tfdir.getText());
					else
						throw new Exception("Error de formato direccion");
					if (!StringUtils.isEmptyOrWhitespaceOnly(tfcorreo.getText()) && tfcorreo.getText().length() < 101)
						correo = (String) (tfcorreo.getText());
					else
						throw new Exception("Error de formato correo");
					if (tftelf.getText().length() != 9)
						throw new NumberFormatException("El teléfono tiene que tener 9 números");
					else
						telf = Long.parseLong(tftelf.getText());
					activo = chckActivo.isSelected();

					id = Integer.parseInt(tfId.getText());

					Controller.getInstance().action(new Contexto(Events.MODIFICA_EMPRESA,
							new TEmpresa(sector, activo, id, CIF, nombre, direccion, telf, correo)));
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
		TEmpresa emp = (TEmpresa) tm.getData();
		btnModificar.setEnabled(true);
		btnBuscarID.setVisible(false);
		tfId.setEditable(false);
		
		panelEmpresa.setVisible(true);
		tfCIF.setText(emp.getCif());
		tfNombre.setText(emp.getNombre());
		tfSector.setText(emp.getSector());
		tfdir.setText(emp.getDireccion());
		tftelf.setText(Long.toString(emp.getTelefono()));
		tfcorreo.setText(emp.getCorreo());
		chckActivo.setSelected(emp.isActivo());
	}

}
