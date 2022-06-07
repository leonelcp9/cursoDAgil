/*************************************/
/* Equipo 2 */
/* Guerrero Hernández Samuel Antonio */
/* 1/06/22 */
/*************************************/
package cursoDAgil.managedBean.producto;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

import cursoDAgil.bd.domain.Producto;
import cursoDAgil.service.producto.ProductoService;

@Named
@ViewScoped
public class productoTBean {
	@Inject
	ProductoService productoService;
	private List<Producto> listaProducto;
	private Producto producto;
	
	@PostConstruct
	public void init() {
		if (listaProducto == null)
			listaProducto = new ArrayList<Producto>();
		if (producto == null) {
			producto = new Producto();
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

	public void eliminar() {
		Integer prod;

		Producto producto = getProducto();
		prod = producto.getIdProducto();
		System.out.println("Funcion eliminar " + prod);
		String productoEliminado = prod.toString();

		productoService.eliminarProducto(prod);
		setListaProducto(productoService.listarProducto());


		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Producto eliminado ", productoEliminado));
	}

	public void onRowEdit(RowEditEvent event) {
		Producto producto = ((Producto) event.getObject());
		productoService.actualizarProducto(producto);
		FacesMessage msg = new FacesMessage("Producto editado", Integer.toString(producto.getIdProducto()));
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Edición cancelada",
				((Producto) event.getObject()).getIdProducto().toString());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onCellEdit(CellEditEvent event) {
		Object oldValue = event.getOldValue();
		Object newValue = event.getNewValue();
		System.out.println("verifica: " + newValue);
		if (newValue != null && !newValue.equals(oldValue)) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Pruducto modificado",
					"Antes: " + oldValue + "Ahora" + newValue);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	// setter´s y getter´s

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public List<Producto> getListaProducto() {
		return listaProducto;
	}

	public void setListaProducto(List<Producto> listaProducto) {
		this.listaProducto = listaProducto;
	}

}
