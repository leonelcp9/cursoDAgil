//////////////////////////////////
/* Equipo 2							*/
/* Autores: Guerrero Hernández Samuel Antonio */
/* Fecha: 25/04/2022				*/
///////////////////////////////////
package cursoDAgil.bd.domain;

public class Producto {

	private Integer idProducto;
	private String nombre;
	private float precio;
	private float precioVta;
	private int cantidad;
	private int marcaId;
	private Marca marca;
	public Producto() {
		setMarca(new Marca());
	}
	public Integer getIdProducto() {
		return idProducto;
	}
	public void setMarca(Marca marca) {
		this.marca=marca;
	}
	public Marca getMarca() {
		return marca;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public float getPrecioVta() {
		return precioVta;
	}
	public void setPrecioVta(float precioVta) {
		this.precioVta = precioVta;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getMarcaId() {
		return marcaId;
	}
	public void setMarcaId(int marcaId) {
		this.marcaId = marcaId;
	}
	
}
