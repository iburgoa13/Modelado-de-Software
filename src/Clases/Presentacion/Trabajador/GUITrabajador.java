package Clases.Presentación.Trabajador;

import javax.swing.JFrame;

import Clases.Presentación.Contexto;
import Clases.Presentación.Empresa.GUIEmpresa;
import Clases.Presentación.Empresa.GUIEmpresaIMP;

public abstract class GUITrabajador extends JFrame{
	private static final long serialVersionUID = 1L;
	private static GUITrabajador instance;

	public static synchronized GUITrabajador getInstance() {
		if (instance == null)
			instance = new GUITrabajadorIMP();
		return instance;
	}

	public abstract void initialize();

	public abstract void update(Contexto context);
}
