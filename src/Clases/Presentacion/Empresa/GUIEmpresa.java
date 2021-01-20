package Clases.Presentación.Empresa;

import javax.swing.JFrame;

import Clases.Presentación.Contexto;

public abstract class GUIEmpresa extends JFrame {
	private static final long serialVersionUID = 1L;
	private static GUIEmpresa instance;

	public static synchronized GUIEmpresa getInstance() {
		if (instance == null)
			instance = new GUIEmpresaIMP();
		return instance;
	}

	public abstract void initialize();

	public abstract void update(Contexto context);
}
