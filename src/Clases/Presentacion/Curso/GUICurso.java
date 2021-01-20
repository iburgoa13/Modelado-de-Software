package Clases.Presentación.Curso;

import javax.swing.JFrame;

import Clases.Presentación.Contexto;
import Clases.Presentación.Marca.GUIMarca;
import Clases.Presentación.Marca.GUIMarcaIMP;

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
