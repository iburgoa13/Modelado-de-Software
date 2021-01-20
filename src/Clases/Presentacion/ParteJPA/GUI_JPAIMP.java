package Clases.Presentación.ParteJPA;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Clases.Presentación.Contexto;
import Clases.Presentación.Command.Events;
import Clases.Presentación.Controller.Controller;

public class GUI_JPAIMP extends GUI_JPA {
	private static final long serialVersionUID = 1L;

	public GUI_JPAIMP() {
		initialize();
	}

	private JPanel contentPane;

	@Override
	public void initialize() {
		this.setVisible(true);
		this.setTitle("Parte JPA - VIEW");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(32, 178, 170));
		contentPane.setForeground(new Color(32, 178, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 100));

		JLabel lblTITULOVENTAS = new JLabel("JPA");
		lblTITULOVENTAS.setForeground(new Color(255, 255, 255));
		lblTITULOVENTAS.setFont(new Font("Consolas", Font.PLAIN, 32));
		lblTITULOVENTAS.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTITULOVENTAS, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(32, 178, 170));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(1, 4, 15, 50));

		JButton btnDepartamento = new JButton("Departamento");
		btnDepartamento.setFont(new Font("Consolas", Font.PLAIN, 22));
		panel.add(btnDepartamento);
		
		JButton btnTrabajadores = new JButton("Trabajadores");
		btnTrabajadores.setFont(new Font("Consolas", Font.PLAIN, 22));
		panel.add(btnTrabajadores);
		
		JButton btnCursos = new JButton("Cursos");
		btnCursos.setFont(new Font("Consolas", Font.PLAIN, 22));
		panel.add(btnCursos);
		
		JButton btnEmpresa = new JButton("Empresa");
		btnEmpresa.setFont(new Font("Consolas", Font.PLAIN, 22));
		panel.add(btnEmpresa);

		JPanel panelSalida = new JPanel();
		contentPane.add(panelSalida, BorderLayout.SOUTH);
		panelSalida.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 40));

		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Consolas", Font.PLAIN, 24));
		panelSalida.add(btnSalir);

		btnEmpresa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Controller.getInstance().action(new Contexto(Events.GUI_Empresa, null));
			}
		});
		btnTrabajadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Controller.getInstance().action(new Contexto(Events.GUI_Trabajador, null));
			}
		});
		btnDepartamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Controller.getInstance().action(new Contexto(Events.GUI_Departamento, null));
			}
		});
		btnCursos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Controller.getInstance().action(new Contexto(Events.GUI_Curso, null));
			}
		});

		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});

	}
}
