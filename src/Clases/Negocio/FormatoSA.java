package Clases.Negocio;

import Clases.Negocio.Cliente.TCliente;
import Clases.Negocio.Cliente.TClienteEmpresa;
import Clases.Negocio.Cliente.TClienteParticulares;
import Clases.Negocio.Curso.TCurso;
import Clases.Negocio.Departamento.TDepartamento;
import Clases.Negocio.Empresa.TEmpresa;
import Clases.Negocio.Marca.TMarca;
import Clases.Negocio.Trabajador.TTrabajador;

public class FormatoSA {

	public int formatoTClienteCorrecto(TCliente cliente) {
		int id = 1;

		if (correoCorrecto(cliente.getCorreo())) {
			if (numCuentaCorrecto(cliente.getNcuenta())) {
				if (cliente.getClass().equals(TClienteParticulares.class)) {
					if (!indentificacionCorrecta(((TClienteParticulares) cliente).getDNI()))
						id = -36;
				} else if (!indentificacionCorrecta(((TClienteEmpresa) cliente).getCif()))
					id = -38;
			} else {
				id = -35;
			}
		} else {
			id = -34;
		}

		return id;
	}
	
	public int formatoTTrabajadorCorrecto(TTrabajador t) {
		int id = 1;

		if (correoCorrecto(t.getCorreo())) {
			if (!indentificacionCorrecta(t.getDNI())) {
				id = -97;
			}
		} 
		else {
			id = -98;
		}

		return id;
	}
	
	public int formatoTCursoCorrecto(TCurso curso) {
		int id = 1;
					if (NivelCorrecto(curso.getNivel())) {
						if (HorasCorrecto(curso.getHoras())) {
						}else {
							id = -104;
						}
					}else {
						id = -105;
					}
		return id;
	}
	private boolean HorasCorrecto(int horas) {
		if(horas<0) return false;
		return true;
	}
	private boolean NivelCorrecto(int nivel) {
		if(nivel<0) return false;
		return true;
	}
	public int formatoTMarcaCorrecto(TMarca marca) {
		int id = 1;
		if (!telefonoCorrecto(marca.getTelefono()))
			id = -22;
		else if(!correoCorrecto(marca.getCorreo()))
			id = -23;
		return id;
	}

	private boolean numCuentaCorrecto(Long nCuenta) {
		return String.valueOf(nCuenta).length() == 15;
	}
	public int formatoTEmpresaCorrecto(TEmpresa empresa) {
		int id = 1;
		if(!correoCorrecto(empresa.getCorreo())){
			id =  -71;
		}
		else if(!indentificacionCorrecta(empresa.getCif())) {
			id = -72;
		}
		else if(!telefonoCorrecto(empresa.getTelefono())) {
			id = -73;
		}
		return id;
	}
	
	public int formatoTDepartamentoCorrecto(TDepartamento departamento) {
		int id = 1;
		if(!correoCorrecto(departamento.getCorreo())){
			id =  -83;
		}
		else if(!telefonoCorrecto(departamento.getTelefono())) {
			id = -84;
		}
		return id;
	}
	/*
	 * private boolean nombreCorrecto(String nombre) { char[] charArray =
	 * nombre.toLowerCase().toCharArray();
	 * 
	 * for (int i = 0; i < charArray.length; i++) { char ch = charArray[i]; if (!(ch
	 * >= 'a' && ch <= 'z')) return false; }
	 * 
	 * return !StringUtils.isEmptyOrWhitespaceOnly(nombre); }
	 */

	private boolean correoCorrecto(String correo) {
		boolean correcto = false;

		try {
			String dominio = correo.substring(correo.indexOf('@') + 1);
			if (dominio.indexOf('.') != -1) {
				String parteDom = dominio.substring(dominio.indexOf('.') + 1);
				if (parteDom.length() > 0)
					correcto = parteDom.indexOf('.') == -1; // Comprueba que solo haya un punto en el dominio

			}
		} catch (Exception e) {

		}

		return correcto;

	}

	private boolean indentificacionCorrecta(String dni) {
		boolean correcto = false;

		try {
			if (dni.length() == 9) {
				Long numsDni = Long.parseLong(dni.substring(0, 8));
				char letra = dni.substring(8).charAt(0);
				correcto = comprobarDigitoControl(numsDni, letra);
			}
		} catch (Exception e) {

		}
		return correcto;
	}

	private boolean comprobarDigitoControl(Long numsDni, char letra) {
		// https://gyazo.com/49a113920ed66a92a1622909cbc90e66
		char[] vectorLetras = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q',
				'V', 'H', 'L', 'C', 'K', 'E' };

		return vectorLetras[(int) (numsDni % 23)] == letra;
	}

	private boolean telefonoCorrecto(Long tlf) {
		boolean correcto = false;
		try {
			correcto = String.valueOf(tlf).length() == 9;

		} catch (Exception e) {
		}

		return correcto;
	}
}
