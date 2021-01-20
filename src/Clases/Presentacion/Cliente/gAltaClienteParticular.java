/**
 * 
 */
package Clases.Presentación.Cliente;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
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
public class gAltaClienteParticular extends JFrame {
	private static final long serialVersionUID = 1L;
	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	JPanel contentPane;
	
	
	
	public void init() {
		contentPane= new JPanel();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 900, 600);

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
		panel.add(btnAceptar );

		JButton btnSalir = new JButton("SALIR");
		btnSalir.setFont(new Font("Consolas", Font.PLAIN, 32));
		panel.add(btnSalir);

		JLabel lblNewLabel = new JLabel("Alta de un cliente particular");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Consolas", Font.PLAIN, 32));
		contentPane.add(lblNewLabel, BorderLayout.NORTH);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(32, 178, 170));
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(8, 4, 10, 30));

		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_1);

		JTextField formattedTextField = new JTextField();
		formattedTextField.setFont(new Font("Consolas", Font.PLAIN, 20));
		formattedTextField.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField.setColumns(25);
		panel_1.add(formattedTextField);

		JLabel lblNewLabel_2 = new JLabel("Apellidos");
		lblNewLabel_2.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_2);

		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setFont(new Font("Consolas", Font.PLAIN, 20));
		formattedTextField_1.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField_1.setColumns(25);
		panel_1.add(formattedTextField_1);

		JLabel lblNewLabel_3 = new JLabel("Direcci\u00F3n");
		lblNewLabel_3.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_3);

		JFormattedTextField formattedTextField_2 = new JFormattedTextField();
		formattedTextField_2.setFont(new Font("Consolas", Font.PLAIN, 20));
		formattedTextField_2.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField_2.setColumns(25);
		panel_1.add(formattedTextField_2);

		JLabel lblNewLabel_4 = new JLabel("Tel\u00E9fono");
		lblNewLabel_4.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_4);

		JFormattedTextField formattedTextField_3 = new JFormattedTextField();
		formattedTextField_3.setFont(new Font("Consolas", Font.PLAIN, 20));
		formattedTextField_3.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField_3.setColumns(25);
		panel_1.add(formattedTextField_3);

		JLabel lblNewLabel_5 = new JLabel("DNI");
		lblNewLabel_5.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_5);

		JFormattedTextField formattedTextField_4 = new JFormattedTextField();
		formattedTextField_4.setFont(new Font("Consolas", Font.PLAIN, 20));
		formattedTextField_4.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField_4.setColumns(25);
		panel_1.add(formattedTextField_4);

		JLabel lblNewLabel_7 = new JLabel("Correo");
		lblNewLabel_7.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_7);

		JFormattedTextField formattedTextField_5 = new JFormattedTextField();
		formattedTextField_5.setFont(new Font("Consolas", Font.PLAIN, 20));
		formattedTextField_5.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField_5.setColumns(25);
		panel_1.add(formattedTextField_5);

		JLabel lblNewLabel_6 = new JLabel("Nº Cuenta");
		lblNewLabel_6.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_6);

		JFormattedTextField formattedTextField_6 = new JFormattedTextField();
		formattedTextField_6.setFont(new Font("Consolas", Font.PLAIN, 20));
		formattedTextField_6.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField_6.setColumns(25);
		panel_1.add(formattedTextField_6);

		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		btnAceptar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
					String nombre,apellidos,correo,direccion,dni;
					Long ncuenta,telf;
					if("".equals(formattedTextField.getText())) { 
						throw new NumberFormatException("El nombre debe rellenarse");
					}
					if(formattedTextField.getText().length() >= 51 ) { 
						throw new Exception("El nombre supera el maximo de 50 caracteres");
					}
					nombre= (String)formattedTextField.getText();
					
					if("".equals(formattedTextField_1.getText())) { 
						throw new NumberFormatException("El apellido debe rellenarse");
					}
					if(formattedTextField_1.getText().length() >= 51) { 
						throw new Exception("El apellido supera el maximo de 50 caracteres");
					}
					apellidos = (String) formattedTextField_1.getText();
					
					if("".equals(formattedTextField_2.getText())) {  
						throw new NumberFormatException("La dirección debe rellenarse");
					}
					if(formattedTextField_2.getText().length() >= 101 ) {  
						throw new Exception("La dirección supera el maximo de 100 caracteres");
					}
					direccion = (String) (formattedTextField_2.getText());
					
					if("".equals(formattedTextField_5.getText())) { 
						throw new NumberFormatException("El correo debe rellenarse");
					}
					if(formattedTextField_5.getText().length() >= 101 ) { 
						throw new Exception("El correo supera el maximo de 100 caracteres");
					}
					correo = (String) (formattedTextField_5.getText());
					
					if("".equals(formattedTextField_4.getText())) { 
						throw new NumberFormatException("El DNI debe rellenarse");
					}
					if(formattedTextField_4.getText().length() != 9) { 
						throw new NumberFormatException("La longitud de DNI debe ser 9");
					}
					dni = (String) (formattedTextField_4.getText());
					
					
					if(formattedTextField_6.getText().length() != 15) 
						throw new NumberFormatException("El número de cuenta debe ser 15 dígitos");
					ncuenta = Long.parseLong(formattedTextField_6.getText());
					
					if(formattedTextField_3.getText().length() != 9) 
						throw new NumberFormatException("El teléfono debe ser 9 dígitos");
					telf = Long.parseLong(formattedTextField_3.getText());
					
					Controller.getInstance().action(
							new Contexto(
								Events.ALTA_CLIENTEP, new TClienteParticulares(telf,true,correo,direccion,ncuenta,dni,nombre,apellidos)));
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

