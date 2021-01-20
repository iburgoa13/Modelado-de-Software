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

import com.toedter.calendar.JDateChooser;

import Clases.Negocio.CursoTrabajador.TCursoTrabajador;
import Clases.Presentación.Contexto;
import Clases.Presentación.Command.Events;
import Clases.Presentación.Controller.Controller;

public class gDesvincularCurso extends JFrame{

	public gDesvincularCurso() {
	}
	
	private JPanel contentPanel;
	public void init() {
		this.setVisible(true);
		contentPanel = new JPanel();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 900, 600);

		contentPanel.setBackground(new Color(32, 178, 170));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(new BorderLayout(0, 20));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(32, 178, 170));
		contentPanel.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(1, 2, 50, 100));

		JButton btnAceptar = new JButton("ACEPTAR");
		btnAceptar.setForeground(new Color(0, 0, 0));
		btnAceptar.setFont(new Font("Consolas", Font.PLAIN, 32));
		panel.add(btnAceptar);

		JButton btnSalir = new JButton("SALIR");
		btnSalir.setFont(new Font("Consolas", Font.PLAIN, 32));
		panel.add(btnSalir);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		JLabel lblNewLabel = new JLabel("Desvincular Curso de Trabajador");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Consolas", Font.PLAIN, 32));
		contentPanel.add(lblNewLabel, BorderLayout.NORTH);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(32, 178, 170));
		contentPanel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(6, 4, 10, 30));
		
		JLabel lblNewLabel_3 = new JLabel("Id del curso:");
		lblNewLabel_3.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_3);

		JFormattedTextField idTrabajadorTF = new JFormattedTextField();
		idTrabajadorTF.setFont(new Font("Consolas", Font.PLAIN, 20));
		idTrabajadorTF.setHorizontalAlignment(SwingConstants.CENTER);
		idTrabajadorTF.setColumns(25);
		panel_1.add(idTrabajadorTF);
		
		JLabel lblNewLabel_4 = new JLabel("Id del trabajador:");
		lblNewLabel_4.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_4);

		JFormattedTextField idCursoTF = new JFormattedTextField();
		idCursoTF.setFont(new Font("Consolas", Font.PLAIN, 20));
		idCursoTF.setHorizontalAlignment(SwingConstants.CENTER);
		idCursoTF.setColumns(25);
		panel_1.add(idCursoTF);
		
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//aqui comprobar cosas aun
				
				try {
				Integer idTrabajador, idCurso;
				
				idTrabajador = Integer.parseInt(idTrabajadorTF.getText());
				if(idTrabajador<0) throw new NumberFormatException("El trabajador debe ser positivo");
				
				idCurso = Integer.parseInt(idCursoTF.getText());
				if(idCurso<0) throw new NumberFormatException("El curso debe ser positivo");
				
				Controller.getInstance().action(
						new Contexto(
								Events.DESVINCULAR_CURSO, new TCursoTrabajador(idTrabajador,idCurso)));
				}
				catch(Exception es) {
					JOptionPane.showMessageDialog(null, "Inserte un número y debe ser positivo, por favor","ERROR",JOptionPane.WARNING_MESSAGE);
				}
				
			}
			
		});
	}
}