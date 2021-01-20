package Clases.Presentación.Venta;

import javax.swing.JFrame;

import Clases.Presentación.Contexto;

public abstract class GUIVenta extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static GUIVenta instance;

	public static GUIVenta getInstance() {
		if (instance == null)
			instance = new GUIVentaIMP();
		return instance;
	}

	public abstract void initialize();

	public abstract void update(Contexto context);
}
