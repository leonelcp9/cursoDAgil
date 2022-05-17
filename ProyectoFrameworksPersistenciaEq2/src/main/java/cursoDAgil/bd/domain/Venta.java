//////////////////////////////////
/* Equipo 2							*/
/* Autor: Mendez Gonzalez William	*/
/* Fecha: 25/04/2022				*/
///////////////////////////////////

package cursoDAgil.bd.domain;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Venta {
	private Integer idVenta;
	private Integer clienteId;
	private double totalVenta;
	private Date fecha; 
	
	private Cliente cliente;
	private List<Producto> productos;

	public Venta(){
		 setCliente(new Cliente());
		 setProductos(new ArrayList<Producto>());
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Integer getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(Integer idVenta) {
		this.idVenta = idVenta;
	}

	public Integer getClienteId() {
		return clienteId;
	}

	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}

	public double getTotalVenta() {
		return totalVenta;
	}

	public void setTotalVenta(double totalVenta) {
		this.totalVenta = totalVenta;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
}
