/******************************/
/* Equipo 2 */
/* Cruz Peralta Leonel*/
/* 1/06/22 */
/*****************************/
package cursoDAgil.managedBean.venta;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import cursoDAgil.bd.domain.Venta;
import cursoDAgil.service.venta.VentaService;

public class VentaCliente2Bean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5650117468508030129L;
	@Inject 
	VentaService ventaService;
	
	private List<Venta> listaVenta;
	private Venta venta;
	
	@PostConstruct
	public void init() {
		if(listaVenta == null)
			listaVenta = new ArrayList<Venta>();
		if(venta == null) {
			venta = new Venta();
			venta.setCliente(null);
		}
		//se invoca el metodo del servicio para obtener
		//las ventas con su cliente
		setListaVenta(ventaService.consultarVentaCliente(null));
		
	}

	public void registrar() {
		ventaService.altaVenta(getVenta());
		setVenta(new Venta());
		setListaVenta(ventaService.consultarVentaCliente(null));
		getListaVenta();
		FacesContext.getCurrentInstance().addMessage("null", new FacesMessage("Registro exitoso"));
	}
	
	public List<Venta> getListaVenta() {
		return listaVenta;
	}

	public void setListaVenta(List<Venta> listaVenta) {
		this.listaVenta = listaVenta;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}
	
	
	
}
