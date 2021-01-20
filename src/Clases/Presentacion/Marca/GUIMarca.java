package Clases.Presentación.Marca;

import javax.swing.JFrame;

import Clases.Presentación.Contexto;

public abstract class GUIMarca extends JFrame {

	private static final long serialVersionUID = 1L;
	private static GUIMarca instance;

	public static GUIMarca getInstance() {
		if (instance == null)
			instance = new GUIMarcaIMP();
		return instance;
	}

	public abstract void initialize();

	public abstract void update(Contexto context);
}
