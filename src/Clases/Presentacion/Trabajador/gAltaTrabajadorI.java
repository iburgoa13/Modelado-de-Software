package Clases.Presentación.Trabajador;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.eclipse.persistence.jpa.jpql.parser.DateTime;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import Clases.Negocio.Trabajador.TIndefinido;
import Clases.Presentación.Contexto;
import Clases.Presentación.Command.Events;
import Clases.Presentación.Controller.Controller;
import java.awt.Component;

public class gAltaTrabajadorI extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public gAltaTrabajadorI() {
		//init();
	}
	
	public void init() {
	contentPane= new JPanel();
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	this.setBounds(100, 100, 900, 600);
	setVisible(true);
	contentPane.setBackground(new Color(32, 178, 170));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(new BorderLayout(0, 20));

	JPanel panel = new JPanel();
	panel.setBackground(new Color(32, 178, 170));
	contentPane.add(panel, BorderLayout.SOUTH);
	panel.setLayout(new GridLayout(1, 2, 50, 100));

	JButton btnAceptar = new JButton("ACEPTAR");
	btnAceptar.setForeground(new Color(0, 0, 0));
	btnAceptar.setFont(new Font("Consolas", Font.PLAIN, 32));
	panel.add(btnAceptar);

	JButton btnSalir = new JButton("SALIR");
	btnSalir.setFont(new Font("Consolas", Font.PLAIN, 32));
	panel.add(btnSalir);

	JLabel lblNewLabel = new JLabel("Alta de trabajador indefinido");
	lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel.setForeground(new Color(255, 255, 255));
	lblNewLabel.setFont(new Font("Consolas", Font.PLAIN, 32));
	contentPane.add(lblNewLabel, BorderLayout.NORTH);

	JPanel panel_1 = new JPanel();
	panel_1.setBackground(new Color(32, 178, 170));
	contentPane.add(panel_1, BorderLayout.CENTER);
	panel_1.setLayout(new GridLayout(0, 4, 5, 30));

	JLabel lblNewLabel_1 = new JLabel("Nombre del trabajador:");
	lblNewLabel_1.setFont(new Font("Consolas", Font.PLAIN, 20));
	lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
	panel_1.add(lblNewLabel_1);

	JFormattedTextField nombreTF = new JFormattedTextField();
	nombreTF.setFont(new Font("Consolas", Font.PLAIN, 20));
	nombreTF.setHorizontalAlignment(SwingConstants.CENTER);
	nombreTF.setColumns(25);
	panel_1.add(nombreTF);

	JLabel lblNewLabel_2 = new JLabel("DNI");
	lblNewLabel_2.setFont(new Font("Consolas", Font.PLAIN, 20));
	lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
	panel_1.add(lblNewLabel_2);

	JFormattedTextField dniTF = new JFormattedTextField();
	dniTF.setFont(new Font("Consolas", Font.PLAIN, 20));
	dniTF.setHorizontalAlignment(SwingConstants.CENTER);
	dniTF.setColumns(25);
	panel_1.add(dniTF);

	JLabel lblNewLabel_3 = new JLabel("Direcci\u00F3n");
	lblNewLabel_3.setFont(new Font("Consolas", Font.PLAIN, 20));
	lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
	panel_1.add(lblNewLabel_3);

	JFormattedTextField dirTF = new JFormattedTextField();
	dirTF.setFont(new Font("Consolas", Font.PLAIN, 20));
	dirTF.setHorizontalAlignment(SwingConstants.CENTER);
	dirTF.setColumns(25);
	panel_1.add(dirTF);

	JLabel lblNewLabel_4 = new JLabel("Tel\u00E9fono");
	lblNewLabel_4.setFont(new Font("Consolas", Font.PLAIN, 20));
	lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
	panel_1.add(lblNewLabel_4);

	JFormattedTextField tlfTF = new JFormattedTextField();
	tlfTF.setFont(new Font("Consolas", Font.PLAIN, 20));
	tlfTF.setHorizontalAlignment(SwingConstants.CENTER);
	tlfTF.setColumns(25);
	panel_1.add(tlfTF);


	JLabel lblNewLabel_7 = new JLabel("Correo");
	lblNewLabel_7.setFont(new Font("Consolas", Font.PLAIN, 20));
	lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
	panel_1.add(lblNewLabel_7);

	JFormattedTextField correoTF = new JFormattedTextField();
	correoTF.setFont(new Font("Consolas", Font.PLAIN, 20));
	correoTF.setHorizontalAlignment(SwingConstants.CENTER);
	correoTF.setColumns(25);
	panel_1.add(correoTF);
	
	JLabel lblNewLabel_8 = new JLabel("Complemento");
	lblNewLabel_8.setFont(new Font("Consolas", Font.PLAIN, 20));
	lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
	panel_1.add(lblNewLabel_8);

	JFormattedTextField compTF = new JFormattedTextField();
	compTF.setFont(new Font("Consolas", Font.PLAIN, 20));
	compTF.setHorizontalAlignment(SwingConstants.CENTER);
	compTF.setColumns(25);
	panel_1.add(compTF);
	
	JLabel lblNewLabel_9 = new JLabel("Nomina");
	lblNewLabel_9.setFont(new Font("Consolas", Font.PLAIN, 20));
	lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
	panel_1.add(lblNewLabel_9);

	JFormattedTextField nominaTF = new JFormattedTextField();
	nominaTF.setFont(new Font("Consolas", Font.PLAIN, 20));
	nominaTF.setHorizontalAlignment(SwingConstants.CENTER);
	nominaTF.setColumns(25);
	panel_1.add(nominaTF);
	
	JLabel lblNewLabel_10 = new JLabel("Id Departamento");
	lblNewLabel_10.setFont(new Font("Consolas", Font.PLAIN, 20));
	lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
	panel_1.add(lblNewLabel_10);

	JFormattedTextField idDepTF = new JFormattedTextField();
	idDepTF.setFont(new Font("Consolas", Font.PLAIN, 20));
	idDepTF.setHorizontalAlignment(SwingConstants.CENTER);
	idDepTF.setColumns(25);
	panel_1.add(idDepTF);
	
	JLabel lblNewLabel_10_1 = new JLabel("Fecha inicio");
	lblNewLabel_10_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_10_1.setFont(new Font("Consolas", Font.PLAIN, 20));
	panel_1.add(lblNewLabel_10_1);
	
	
	JDateChooser calendar = new JDateChooser();
	calendar.setMinSelectableDate(new Date(Calendar.getInstance().getTimeInMillis()));
	calendar.setDate(new Date(Calendar.getInstance().getTimeInMillis()));
	calendar.setFont(new Font("Consolas", Font.PLAIN, 20));
	panel_1.add(calendar);

	btnSalir.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			dispose();
		}
	});
	
	btnAceptar.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			try {
				String nombre,correo,direccion,dni;
				Long telf;
				Float complemento, nomina;
				Integer idDepartamento;
				Date fechaIni;
				
				
				if("".equals(nombreTF.getText())) { 
					throw new Exception("El nombre debe rellenarse");
				}
				if(nombreTF.getText().length() >= 101) {
					throw new Exception("El nombre supera el maximo de 100 caracteres");
				}
				nombre= (String) nombreTF.getText();
				 
				if("".equals(dniTF.getText())) { 
					throw new Exception("El DNI debe rellenarse");
				}
				if(dniTF.getText().length() != 9) { 
					throw new Exception("El DNI debe ser 9 dígitos");
				}
				dni = (String) dniTF.getText();
				
				if("".equals(dirTF.getText())) {
					throw new Exception("La direccion debe rellenarse");
				}
				if(dirTF.getText().length() >= 101 ) {
					throw new Exception("La dirección supera el maximo de 100 caracteres");
				}
				direccion = (String) (dirTF.getText());
				
				if("".equals(correoTF.getText())) { 
					throw new Exception("El correo debe rellenarse");
				}
				if(correoTF.getText().length() >= 51 ) { 
					throw new Exception("El correo supera el maximo de 50 caracteres");
				}
				
				correo = (String) (correoTF.getText());
				
				if(tlfTF.getText().length()!= 9) 
					throw new NumberFormatException("El teléfono debe ser 9 dígitos");
				
				telf = Long.parseLong(tlfTF.getText());
				
				if("".equals(compTF.getText())) { 
					throw new Exception("El complemento debe rellenarse");
				}
				
				complemento = Float.parseFloat(compTF.getText());
				
				if(complemento<0) throw new NumberFormatException("El complemento debe ser positivo");
				
				if("".equals(nominaTF.getText())) { 
					throw new Exception("La nomina debe rellenarse");
				}
				
				nomina = Float.parseFloat(nominaTF.getText());
				
				if(nomina<0) throw new NumberFormatException("La nomina debe ser positivo");
				
				if("".equals(idDepTF.getText())) { 
					throw new Exception("El id departamento debe rellenarse");
				}
				
				idDepartamento = Integer.parseInt(idDepTF.getText());
				
				if(idDepartamento<0) throw new NumberFormatException("El departamento debe ser positivo");
				
				fechaIni = calendar.getDate();
				
				if(fechaIni ==null) throw new Exception("Elija una fecha de inicio");
				
				/*
				 * String dNI, String nombre, Long teléfono, String direccion, Date fechainicio,
			String correo, Boolean activo, Integer idDepartamento, Float nomina, Float complemento
				 * */
				 
				Controller.getInstance().action(
					new Contexto(
							Events.ALTA_TRABAJADOR, new TIndefinido(dni, nombre, telf, direccion,fechaIni ,
									correo, true,idDepartamento,nomina,complemento)));
			}
			catch(Exception es) {
				if(es.getClass().equals(NumberFormatException.class)) {
					JOptionPane.showMessageDialog(null, es.getMessage(),"ERROR",JOptionPane.WARNING_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, es.getMessage() ,"ERROR",JOptionPane.WARNING_MESSAGE);
				}
			}
			
		}
	});
	}
}

