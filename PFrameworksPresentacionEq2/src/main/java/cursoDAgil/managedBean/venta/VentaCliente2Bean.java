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

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

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
	
	public void onRowEdit(RowEditEvent event) {
		Venta ven = ((Venta) event.getObject());
		ven.setCliente(venta.getCliente());
		ventaService.actualizarVenta(ven);
		
		FacesMessage msg = new FacesMessage("Venta editada",ven.getIdVenta().toString());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Edicion cancelada",((Venta) event.getObject()).getIdVenta().toString());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public void onCellEdit(CellEditEvent event) {
		Object oldValue = event.getOldValue();
		Object newValue = event.getNewValue();
		
		System.out.println("verifica: "+newValue);
		if(newValue != null && !newValue.equals(oldValue)) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Venta modificada","Antes: "+oldValue+", Ahora: "+newValue);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
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
