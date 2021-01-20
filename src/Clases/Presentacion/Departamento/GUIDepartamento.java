package Clases.Presentación.Departamento;

import javax.swing.JFrame;

import Clases.Presentación.Contexto;


public abstract class GUIDepartamento extends JFrame {

	private static final long serialVersionUID = 1L;
	private static GUIDepartamentoIMP instance;

	public static synchronized GUIDepartamento getInstance() {
		if (instance == null)
			instance = new GUIDepartamentoIMP();
		return instance;
	}

	public abstract void initialize();

	public abstract void update(Contexto context);
}
