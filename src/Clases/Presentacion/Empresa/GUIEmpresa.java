package Clases.Presentaci�n.Empresa;

import javax.swing.JFrame;

import Clases.Presentaci�n.Contexto;

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
