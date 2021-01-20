package Clases.Negocio.Venta;


public class TDevolucion {
	
	public TDevolucion(int idVenta, int idProd, int cantidad) {
		this.idVenta = idVenta;
		this.idProd = idProd;
		this.cantidad = cantidad;
	}
	
	private Integer idVenta;
	private Integer idProd;
	private Integer cantidad;
	
	public Integer getIdVenta() {
		return this.idVenta;
	}
	
	public Integer getIdProd() {
		return this.idProd;
	}
	
	public Integer getCantProd() {
		return this.cantidad;
	}
}
