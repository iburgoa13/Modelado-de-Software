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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Clases.Negocio.Cliente.TCliente;
import Clases.Presentación.Contexto;
import Clases.Presentación.Command.Events;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author Mario, Javier, Yule, David, Alberto, Iker, Fernando, Francisco
 * @generated "UML a Java
 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class GUIClienteIMP extends GUICliente {

	/**
	 * 
	 */
	private gAltaClienteEmpresa gAltaEmpresa;
	private gAltaClienteParticular gAltaParticular;
	private gBajaCliente gBajaCl;
	private gEntreXY gEntreXY;
	private gReadAllCliente gReadAllCl;
	private gReadCliente gReadCl;
	private gUpdateCliente gUpdateCl;
	private gReadAllOneCliente gAllOneCliente;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane = new JPanel();

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @param context
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public GUIClienteIMP() {
		initialize();
		this.gAltaEmpresa = new gAltaClienteEmpresa();
		this.gAltaParticular = new gAltaClienteParticular();
		this.gBajaCl = new gBajaCliente();
		this.gEntreXY = new gEntreXY();
		this.gReadAllCl = new gReadAllCliente();
		this.gReadCl = new gReadCliente();
		this.gUpdateCl = new gUpdateCliente();
		this.gAllOneCliente = new gReadAllOneCliente();
	}

	public void update(Contexto context) {
		switch(context.getEvent()) {
		case Events.ALTA_CLIENTEE_OK:
			JOptionPane.showMessageDialog(null, "Cliente con ID "+ context.getData()+" añadido correctamente","EXITO", JOptionPane.INFORMATION_MESSAGE);
			break;
		case Events.ALTA_CLIENTEP_OK:
			JOptionPane.showMessageDialog(null, "Cliente con ID "+ context.getData()+" añadido correctamente","EXITO", JOptionPane.INFORMATION_MESSAGE);
			break;
		case Events.ALTA_CLIENTEP_KO:
			if((int)context.getData()==-32) 
				JOptionPane.showMessageDialog(null, "DNI Repetido", "ERROR", JOptionPane.ERROR_MESSAGE);
			else if((int)context.getData()==-34) 
				JOptionPane.showMessageDialog(null, "Formato de e-mail incorrecto \nejemplo@ejemplo.es", "ERROR", JOptionPane.ERROR_MESSAGE);
			else if((int)context.getData()==-35) 
				JOptionPane.showMessageDialog(null, "Formato de número de cuenta incorrecto, tienen que ser 15 dígitos)", "ERROR", JOptionPane.ERROR_MESSAGE);
			else if((int)context.getData()==-36) 
				JOptionPane.showMessageDialog(null, "DNI inválido)", "ERROR", JOptionPane.ERROR_MESSAGE);
			else
			JOptionPane.showMessageDialog(null, "No se ha podido insertar el cliente, error:"+ context.getData(), "ERROR", JOptionPane.ERROR_MESSAGE);
			break;
		case Events.ALTA_CLIENTEE_KO:
			if((int)context.getData()==-31) 
				JOptionPane.showMessageDialog(null, "CIF Repetido.", "ERROR", JOptionPane.ERROR_MESSAGE);
			else if((int)context.getData()==-34) 
				JOptionPane.showMessageDialog(null, "Formato de e-mail incorrecto \nejemplo@ejemplo.es", "ERROR", JOptionPane.ERROR_MESSAGE);
			else if((int)context.getData()==-35) 
				JOptionPane.showMessageDialog(null, "Formato de número de cuenta incorrecto, tienen que ser 15 dígitos)", "ERROR", JOptionPane.ERROR_MESSAGE);
			else if((int)context.getData()==-38) 
				JOptionPane.showMessageDialog(null, "CIF inválido)", "ERROR", JOptionPane.ERROR_MESSAGE);
			else
			JOptionPane.showMessageDialog(null, "No se ha podido insertar el producto, error:"+ context.getData(), "ERROR", JOptionPane.ERROR_MESSAGE);
			break;
		case Events.MOD_CLIENTE_OKBusqueda:
			this.gUpdateCl.update((TCliente) context.getData());
			break;
		case Events.MOD_CLIENTE_KOBusqueda:
			JOptionPane.showMessageDialog(null, "No se ha podido encontrar un cliente con esa ID", "ERROR", JOptionPane.ERROR_MESSAGE);
			break;
		case Events.MOD_CLIENTE_OKUpdate:
			JOptionPane.showMessageDialog(null, "Cliente con ID "+ context.getData()+" modificado correctamente","EXITO", JOptionPane.INFORMATION_MESSAGE);
			break;
		case Events.MOD_CLIENTE_KOUpdate:
			if((int)context.getData()==-31) 
				JOptionPane.showMessageDialog(null, "CIF Repetido.", "ERROR", JOptionPane.ERROR_MESSAGE);
			else if((int)context.getData()==-32) 
				JOptionPane.showMessageDialog(null, "DNI Repetido.", "ERROR", JOptionPane.ERROR_MESSAGE);
			else if((int)context.getData()==-34) 
				JOptionPane.showMessageDialog(null, "Formato de e-mail incorrecto \nejemplo@ejemplo.es", "ERROR", JOptionPane.ERROR_MESSAGE);
			else if((int)context.getData()==-35) 
				JOptionPane.showMessageDialog(null, "Formato de número de cuenta incorrecto, tienen que ser 15 dígitos)", "ERROR", JOptionPane.ERROR_MESSAGE);
			else if((int)context.getData()==-36) 
				JOptionPane.showMessageDialog(null, "DNI inválido", "ERROR", JOptionPane.ERROR_MESSAGE);
			else if((int)context.getData()==-38) 
				JOptionPane.showMessageDialog(null, "CIF inválido", "ERROR", JOptionPane.ERROR_MESSAGE);
			else
				JOptionPane.showMessageDialog(null, "No se ha podido modificar al cliente con esa ID.", "ERROR", JOptionPane.ERROR_MESSAGE);
			break;
		case Events.MOSTRAR_CLIENTE_OK:
			gReadCl.update((TCliente) context.getData());
			break;
		case Events.MOSTRAR_CLIENTE_KO:
			JOptionPane.showMessageDialog(null, "No se ha podido encontrar un cliente con esa ID", "ERROR", JOptionPane.ERROR_MESSAGE);
			break;
		case Events.BAJA_CLIENTE_OK:
			JOptionPane.showMessageDialog(null, "Cliente con ID "+ context.getData()+" eliminado correctamente","EXITO", JOptionPane.INFORMATION_MESSAGE);
			break;
		case Events.BAJA_CLIENTE_KO:
			if((int)context.getData()==-50) 
				JOptionPane.showMessageDialog(null, "Error de BBDD", "ERROR", JOptionPane.ERROR_MESSAGE);
			else if((int)context.getData()==-41) 
				JOptionPane.showMessageDialog(null, "El cliente ya no está activo", "ERROR", JOptionPane.ERROR_MESSAGE);
			else if((int)context.getData()==-42) 
				JOptionPane.showMessageDialog(null, "El cliente que se quería dar de baja tiene ventas asociadas", "ERROR", JOptionPane.ERROR_MESSAGE);
			else if((int)context.getData()==-3) 
				JOptionPane.showMessageDialog(null, "Cliente no existe)", "ERROR", JOptionPane.ERROR_MESSAGE);
			else if((int)context.getData()==-60) 
				JOptionPane.showMessageDialog(null, "Error en transacción", "ERROR", JOptionPane.ERROR_MESSAGE);
			else
				JOptionPane.showMessageDialog(null, "No se ha podido modificar al cliente con esa ID.", "ERROR", JOptionPane.ERROR_MESSAGE);
			break;
		case Events.LISTAR_TODOSCLIENTES_OK:
			gReadAllCl.update(context);
			break;
		case Events.LISTAR_TODOSCLIENTES_KO:
			JOptionPane.showMessageDialog(null, "No se han podido mostrar los clientes", "ERROR", JOptionPane.ERROR_MESSAGE);
			break;
		case Events.ENTRXYCliente_OK:
			gEntreXY.update(context);
			break;
		case Events.ENTRXYCliente_KO:
			JOptionPane.showMessageDialog(null, "No se han podido mostrar los clientes", "ERROR", JOptionPane.ERROR_MESSAGE);
			break;
		case Events.MOSTRAR_VENTAS_CLIENTE_OK:
			this.gAllOneCliente.update(context);		
			break;
		case Events.MOSTRAR_VENTAS_CLIENTE_KO:
			JOptionPane.showMessageDialog(null, "El cliente que desee no existe","ERROR", JOptionPane.ERROR_MESSAGE);		
			break;
			
		}
	}
	public void initialize() {
		// TODO Auto-generated method stub
		this.setVisible(true);
		setTitle("Clientes");
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

		JLabel lblNewLabel = new JLabel("CLIENTES");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Consolas", Font.PLAIN, 32));
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(32, 178, 170));
		contentPane.add(panel_1, BorderLayout.CENTER);

		JButton btnAP = new JButton("Alta cliente particular");
		btnAP.setFont(new Font("Consolas", Font.PLAIN, 18));

		JButton btnAE = new JButton("Alta cliente empresarial");
		btnAE.setFont(new Font("Consolas", Font.PLAIN, 18));

		JButton btnBaja = new JButton("Baja de un cliente");
		btnBaja.setFont(new Font("Consolas", Font.PLAIN, 18));

		JButton btnMostrarUno = new JButton("Mostrar datos de un cliente");
		btnMostrarUno.setFont(new Font("Consolas", Font.PLAIN, 18));

		JButton btnMostrarClientes = new JButton("Mostrar todos los clientes");
		btnMostrarClientes.setFont(new Font("Consolas", Font.PLAIN, 18));

		JButton btnUpdate = new JButton("Actualizar un cliente");
		btnUpdate.setFont(new Font("Consolas", Font.PLAIN, 18));
		
		JButton btnMostrarClientesXY = new JButton("Lista clientes entre X e Y");
		btnMostrarClientesXY.setFont(new Font("Consolas", Font.PLAIN, 18));
		
		JButton btnMostrarVentasCliente = new JButton("Mostrar ventas de un cliente");
		btnMostrarVentasCliente.setFont(new Font("Consolas", Font.PLAIN, 18));

		
		panel_1.setLayout(new GridLayout(4, 2, 50, 25));
		panel_1.add(btnAP);
		panel_1.add(btnAE);
		panel_1.add(btnBaja);
		panel_1.add(btnMostrarUno);
		panel_1.add(btnMostrarClientes);
		panel_1.add(btnUpdate);
		panel_1.add(btnMostrarClientesXY);
		panel_1.add(btnMostrarVentasCliente);

		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(32, 178, 170));
		contentPane.add(panel_2, BorderLayout.SOUTH);

		JButton btnSalir = new JButton("SALIR");
		btnSalir.setForeground(new Color(0, 0, 0));
		btnSalir.setFont(new Font("Consolas", Font.PLAIN, 32));
		panel_2.add(btnSalir);

		btnAP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gAltaParticular.init();
			}
		});
		
		btnAE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gAltaEmpresa.init();
			}
		});
		
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gUpdateCl.init();
			}
		});
		btnMostrarUno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gReadCl.init();
			}
		});
		btnBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gBajaCl.init();
			}
		});
		btnMostrarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gReadAllCl.init();
			}
		});
		
		btnMostrarClientesXY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gEntreXY.init();
			}
		});
		
		btnMostrarVentasCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gAllOneCliente.init();
			}
		});
		

	}

}