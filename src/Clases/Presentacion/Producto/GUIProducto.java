package Clases.Presentación.Producto;

import javax.swing.JFrame;

import Clases.Presentación.Contexto;

public abstract class GUIProducto extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static GUIProducto instance;

	public static GUIProducto getInstance() {
		if (instance == null)
			instance = new GUIProductoIMP();
		return instance;
	}

	public abstract void initialize();

	public abstract void update(Contexto context);
}
