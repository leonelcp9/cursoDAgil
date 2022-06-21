package cursoDAgil.managedBean.producto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.primefaces.event.RowEditEvent;

import cursoDAgil.service.producto.ProductoService;

import cursoDAgil.bd.domain.Producto;

public class ClienteProducto2Bean implements Serializable {
	private static final long serialVersionUID = 6472377493921731094L;
	
	
	@Inject 
	ProductoService productoService;
	
	private List<Producto> listaProducto;
	private Producto producto;
	
	@PostConstruct 
	public void init() {
		if(listaProducto == null)
			listaProducto = new ArrayList<Producto>();
		if(producto == null) {
			producto= new Producto();
		}
		
		setListaProducto(productoService.listarProducto());
	}
	
	public void registrar() {
		productoService.altaProducto(getProducto());
		
		setProducto(new Producto());
		
		setListaProducto(productoService.listarProducto());
		
		getListaProducto();
		
		FacesContext.getCurrentInstance().addMessage("null", new FacesMessage("Registro exitoso!"));
	}
	

	
	
	
	
	public Producto getProducto() {
		return producto;
	}
	
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	public List<Producto> getListaProducto(){
		return listaProducto;
	}
	
	public void setListaProducto(List<Producto> listaProducto) {
		this.listaProducto = listaProducto;
	}
	
}
