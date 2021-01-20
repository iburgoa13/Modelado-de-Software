package Clases.Presentaci�n.Curso;

import javax.swing.JFrame;

import Clases.Presentaci�n.Contexto;
import Clases.Presentaci�n.Marca.GUIMarca;
import Clases.Presentaci�n.Marca.GUIMarcaIMP;

public abstract class GUICurso extends JFrame {
	private static final long serialVersionUID = 1L;
	private static GUICurso instance;

	public static synchronized GUICurso getInstance() {
		if (instance == null)
			instance = new GUICursoIMP();
		return instance;
	}

	public abstract void initialize();

	public abstract void update(Contexto context);
}
