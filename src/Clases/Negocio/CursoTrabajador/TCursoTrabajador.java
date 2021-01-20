package Clases.Negocio.CursoTrabajador;

import java.util.Date;

public class TCursoTrabajador {
	private Integer idTrabajador, idCurso;
	private Date fechaIni, fechaFin;
	
	public TCursoTrabajador(Integer idTrabajador, Integer idCurso, Date fechaIni, Date fechaFin) {
		this.idTrabajador = idTrabajador;
		this.idCurso = idCurso;
		this.fechaIni = fechaIni;
		this.fechaFin = fechaFin;
	}
	
	public TCursoTrabajador(Integer idTrabajador, Integer idCurso) {
		// TODO Auto-generated constructor stub
		this.idTrabajador = idTrabajador;
		this.idCurso = idCurso;
	}
	public Integer getIdTrabajador() {
		return idTrabajador;
	}
	public void setIdTrabajador(Integer idTrabajador) {
		this.idTrabajador = idTrabajador;
	}
	public Integer getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}
	public Date getFechaIni() {
		return fechaIni;
	}
	public void setFechaIni(Date fechaIni) {
		this.fechaIni = fechaIni;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	

}
