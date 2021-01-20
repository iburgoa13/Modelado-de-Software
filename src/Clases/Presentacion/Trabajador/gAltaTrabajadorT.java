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

import com.toedter.calendar.JDateChooser;

import Clases.Negocio.Trabajador.TIndefinido;
import Clases.Negocio.Trabajador.TTemporal;
import Clases.Presentación.Contexto;
import Clases.Presentación.Command.Events;
import Clases.Presentación.Controller.Controller;

public class gAltaTrabajadorT extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public gAltaTrabajadorT() {
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

	JLabel lblNewLabel = new JLabel("Alta de trabajador temporal");
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
	
	JLabel lblNewLabel_8 = new JLabel("Sueldo p/h");
	lblNewLabel_8.setFont(new Font("Consolas", Font.PLAIN, 20));
	lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
	panel_1.add(lblNewLabel_8);

	JFormattedTextField sueldoPHFT = new JFormattedTextField();
	sueldoPHFT.setFont(new Font("Consolas", Font.PLAIN, 20));
	sueldoPHFT.setHorizontalAlignment(SwingConstants.CENTER);
	sueldoPHFT.setColumns(25);
	panel_1.add(sueldoPHFT);
	
	JLabel lblNewLabel_9 = new JLabel("Horas mensuales");
	lblNewLabel_9.setFont(new Font("Consolas", Font.PLAIN, 20));
	lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
	panel_1.add(lblNewLabel_9);

	JFormattedTextField horasTF = new JFormattedTextField();
	horasTF.setFont(new Font("Consolas", Font.PLAIN, 20));
	horasTF.setHorizontalAlignment(SwingConstants.CENTER);
	horasTF.setColumns(25);
	panel_1.add(horasTF);
	
	JLabel lblNewLabel_10 = new JLabel("Id Departamento");
	lblNewLabel_10.setFont(new Font("Consolas", Font.PLAIN, 20));
	lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
	panel_1.add(lblNewLabel_10);

	JFormattedTextField idDepTF = new JFormattedTextField();
	idDepTF.setFont(new Font("Consolas", Font.PLAIN, 20));
	idDepTF.setHorizontalAlignment(SwingConstants.CENTER);
	idDepTF.setColumns(25);
	panel_1.add(idDepTF);

	JLabel lblNewLabel_6 = new JLabel("Fecha inicio");
	lblNewLabel_6.setFont(new Font("Consolas", Font.PLAIN, 20));
	lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
	panel_1.add(lblNewLabel_6);

	JDateChooser calendarIni = new JDateChooser();
	calendarIni.setMinSelectableDate(new Date(Calendar.getInstance().getTimeInMillis()));
	calendarIni.setDate(new Date(Calendar.getInstance().getTimeInMillis()));
	calendarIni.setFont(new Font("Consolas", Font.PLAIN, 20));
	panel_1.add(calendarIni);
	
	JLabel lblNewLabel_11 = new JLabel("Fecha fin");
	lblNewLabel_11.setFont(new Font("Consolas", Font.PLAIN, 20));
	lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
	panel_1.add(lblNewLabel_11);

	JDateChooser calendarFin = new JDateChooser();
	calendarFin.setFont(new Font("Consolas", Font.PLAIN, 20));
	calendarFin.setMinSelectableDate(new Date(Calendar.getInstance().getTimeInMillis()));
	calendarFin.setDate(new Date(Calendar.getInstance().getTimeInMillis()));
	panel_1.add(calendarFin);
	
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
				Float sueldoPH;
				Integer idDepartamento, horasMensuales;
				Date fechaIni,fechaFin;
				
				
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
				
				if("".equals(sueldoPHFT.getText())) { 
					throw new Exception("El sueldo debe rellenarse");
				}
				
				sueldoPH = Float.parseFloat(sueldoPHFT.getText());
				
				if(sueldoPH<0) throw new NumberFormatException("El sueldo debe ser positivo");
				
				if("".equals(horasTF.getText())) { 
					throw new Exception("Las horas mensuales deben rellenarse");
				}
				
				horasMensuales = Integer.parseInt(horasTF.getText());
				
				if(horasMensuales<0) throw new NumberFormatException("Las horas mensuales deben ser positivo");
				
				if("".equals(idDepTF.getText())) { 
					throw new Exception("El departamento debe rellenarse");
				}
				
				idDepartamento = Integer.parseInt(idDepTF.getText());
				
				if(idDepartamento<0) throw new NumberFormatException("El departamento debe ser positivo");
				
				fechaIni = calendarIni.getDate();
				if(fechaIni ==null) throw new Exception("Elija una fecha de inicio");
				
				
				fechaFin = calendarFin.getDate();
				if(fechaFin ==null) throw new Exception("Elija una fecha de fin");
				/*
				 String dNI,  String nombre, Long teléfono, String direccion, Date fechainicio,
			String correo, Boolean activo, Integer idDepartamento, Date fechaFin, Float sueldoPH,
			Integer horasMensuales
				 * */
				 
				Controller.getInstance().action(
					new Contexto(
							Events.ALTA_TRABAJADOR, new TTemporal(dni, nombre, telf, direccion, fechaIni,
									correo, true,idDepartamento,fechaFin,sueldoPH,horasMensuales)));
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
