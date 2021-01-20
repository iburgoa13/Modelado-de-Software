/**
 * 
 */
package Clases.Presentación;

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
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import Clases.Presentación.Command.Events;
import Clases.Presentación.Controller.Controller;


/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author Mario, Javier, Yule, David, Alberto, Iker, Fernando, Francisco
 * @generated "UML a Java
 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */

public class GUIMainIMP extends GUIMain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GUIMainIMP() {
		initialize();
		
	}

	public void initialize() {
		this.setTitle("MSCARILLAS");
		this.setBounds(100, 100, 1200, 900);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(false);
		this.setVisible(true);
		this.setResizable(false);
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(new Color(32, 178, 170));
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		panel.setForeground(new Color(64, 224, 208));
		this.getContentPane().add(panel, BorderLayout.NORTH);

		JLabel lbTitulo = new JLabel("MSCARILLAS");
		lbTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitulo.setForeground(new Color(230, 230, 250));
		lbTitulo.setBackground(new Color(135, 206, 250));
		lbTitulo.setFont(new Font("Consolas", Font.BOLD, 26));
		panel.add(lbTitulo);

		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(32, 178, 170));
		panel_1.setBackground(new Color(32, 178, 170));
		this.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));

		JButton btnDAO = new JButton("DAO");
		btnDAO.setFont(new Font("Consolas", Font.PLAIN, 22));

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(null);
		panel_2.setForeground(new Color(32, 178, 170));
		FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
		panel_2.setBackground(new Color(32, 178, 170));
		panel_1.add(panel_2);

		JTextPane txtpnAutores = new JTextPane();
		txtpnAutores.setForeground(new Color(255, 255, 255));
		txtpnAutores.setBackground(new Color(32, 178, 170));
		txtpnAutores.setFont(new Font("Consolas", Font.PLAIN, 16));
		txtpnAutores.setText(
				"\r\nAUTORES:\r\n\r\nMario \r\nFrancisco \r\nYule \r\nDavid\r\nFernando\r\nIker\r\nAlberto\r\nJavier");
		panel_2.add(txtpnAutores);

		JButton btnJPA = new JButton("JPA");
		btnJPA.setFont(new Font("Consolas", Font.PLAIN, 22));

		JButton btnSalir = new JButton("SALIR");
		// btnNewButton.setBackground(new Color(0, 0, 0));
		btnSalir.setForeground(new Color(0, 0, 0));
		btnSalir.setFont(new Font("Consolas", Font.PLAIN, 22));

		btnJPA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Controller.getInstance().action(new Contexto(Events.GUI_JPA,null));
			}
		});
		btnDAO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Controller.getInstance().action(new Contexto(Events.GUI_DAO, null));
			}
		});
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		panel_1.add(btnDAO);
		panel_1.add(btnJPA);
		panel_1.add(btnSalir);

		this.setVisible(true);
	}

}