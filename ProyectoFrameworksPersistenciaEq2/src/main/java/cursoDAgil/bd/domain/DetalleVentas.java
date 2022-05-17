//////////////////////////////////
/* Equipo 2							*/
/* Autores: Lòpez Guevara Jesùs Alejandro, Cruz Peralta Leonel */
/* Fecha: 25/04/2022				*/
///////////////////////////////////
package cursoDAgil.bd.domain;

public class DetalleVentas {
	private Integer venvtaId;
	private Integer productoId;
	private Integer cantidad;
	
	
	private Producto producto;
	
	public DetalleVentas(){
		 setProducto(new Producto());
		}
	
	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	public Integer getVenvtaId() {
		return venvtaId;
	}
	public void setVenvtaId(Integer venvtaId) {
		this.venvtaId = venvtaId;
	}
	public Integer getProductoId() {
		return productoId;
	}
	public void setProductoId(Integer productoId) {
		this.productoId = productoId;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
}
