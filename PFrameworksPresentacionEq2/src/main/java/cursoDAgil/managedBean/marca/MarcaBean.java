/*************************************/
/* Equipo 2 */
/* Narvaez Morales Jorge Lisandro*/
/* 6/06/22 */
/*************************************/
package cursoDAgil.managedBean.marca;

import java.io.Serializable;
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

import cursoDAgil.bd.domain.Marca;
import cursoDAgil.managedBean.producto.productoTBean;
import cursoDAgil.service.Marca.MarcaService;
import cursoDAgil.service.producto.ProductoService;

@Named
@ViewScoped
public class MarcaBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3129353826466091512L;

	/**
	 * 
	 */
	
	@Inject
	MarcaService marcaService;
	
	@Inject
	productoTBean productoBean;
	
	@Inject
	ProductoService productoService;
	
	private List<Marca> marcaList;
	private Marca marca;
	
	private List<Marca> marcasFiltradas;
	
	@PostConstruct
	public void init() {
		if (marcaList == null)
			marcaList = new ArrayList<Marca>();
		if (marca == null) {
			marca = new Marca();
		}
		// se invoca el metodo del servicio para obtener los marcas
		setmarcaList(marcaService.listarMarcas());
		
	}
	
	 
	public List<Marca> getMarcasFiltradas() {
		return marcasFiltradas;
	}

	public void setMarcasFiltradas(List<Marca> marcasFiltradas) {
		this.marcasFiltradas = marcasFiltradas;
	}

	
	public List<Marca> getmarcaList() {
		if (marcaList == null)

			setmarcaList(marcaService.listarMarcas());
		return marcaList;
	}

	public void setmarcaList(List<Marca> marcaList) {
		this.marcaList = marcaList;
	}

	public void onRowEdit(RowEditEvent event) {
		Marca cli = ((Marca) event.getObject());
		int longi=cli.getNombreMarca().length();
		System.out.println(longi);
		if(longi>8 && longi<50) {
			marcaService.actualizarMarca(cli);		
			FacesMessage msg = new FacesMessage("Marca editada");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			//Actualiza los productos
			productoBean.setListaProducto(productoService.listarProducto());
		
		}else {
			FacesContext.getCurrentInstance().addMessage("null", new FacesMessage("Longitud no permitida"));
		}
		setmarcaList(marcaService.listarMarcas());
	}

	

	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Edicion cancelada", ((Marca) event.getObject()).getIdMarca().toString());
		FacesContext.getCurrentInstance().addMessage(null, msg);
		
	
	}

	public void onCellEdit(CellEditEvent event) {

		Object oldValue = event.getOldValue();
		Object newValue = event.getNewValue();
		System.out.println("verifica: " + newValue);
		if (newValue != null && !newValue.equals(oldValue)) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "marca modificada", "Antes: " + oldValue + ", Ahora: " + newValue);

			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		
		
	}
	
	// metodo que registra nuevo marca
		public void registrar() {
			// invocar al servicio
			marcaService.nuevaMarca(marca);
			// limpia los valores del objeto
			setmarca(new Marca());
			// se actualiza los valores de la tabla
			setmarcaList(marcaService.listarMarcas());
			// setlistamarca(marcaService.findAllmarcas());
			getmarcaList();
			FacesContext.getCurrentInstance().addMessage("null", new FacesMessage("Registro exitoso!"));

			
		}
		

		public void deleteMarca() {
			System.out.println("Eliminar" + marca.getIdMarca());
			Integer id = marca.getIdMarca();
			int ban = 0;
			try {
				ban = marcaService.eliminarMarca(id);
				setmarcaList(marcaService.listarMarcas());
				
				if (marcaService.eliminarMarca(id)==1) {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Marca eliminada"));
					
				}else {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error, No se eliminó"));
					
				}
				setmarca(new Marca());
				
			}catch(Exception e){
				System.out.println(e);
				
			}
		}
	
	
	public Marca getmarca() {
		return marca;
	}

	public void setmarca(Marca marca) {
		this.marca = marca;
	}
}
