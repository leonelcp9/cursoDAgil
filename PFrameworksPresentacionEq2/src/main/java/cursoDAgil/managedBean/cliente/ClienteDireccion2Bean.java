/******************************/
/* Equipo 2 */
/* William Mendez Gonzalez*/
/* 30/05/22 */
/*****************************/
package cursoDAgil.managedBean.cliente;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

//import org.primefaces.PrimeFaces;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import cursoDAgil.bd.domain.Cliente;
import cursoDAgil.service.cliente.ClienteService;

@Named
@ViewScoped
public class ClienteDireccion2Bean implements Serializable {

	private static final long serialVersionUID = 6472377493921731094L;
	@Inject
	ClienteService clienteService;
	private List<Cliente> listaCliente;
	private Cliente cliente;

	@PostConstruct
	public void init() {
		if (listaCliente == null)
			listaCliente = new ArrayList<Cliente>();
		if (cliente == null) {
			cliente = new Cliente();
			cliente.setDireccion(null);
		}
		setlistaCliente(clienteService.listarTodosClientes());
	}

	// metodo que registra nuevo cliente
	public void registrar() {
		clienteService.nuevoCliente(getCliente());
		setCliente(new Cliente());
		setlistaCliente(clienteService.listarTodosClientes());
		getlistaCliente();
		FacesContext.getCurrentInstance().addMessage("null", new FacesMessage("Registro exitoso!"));

	}

	public void eliminar(){
		//invocar servicio 
		Map<String, Integer>mapCliente = new HashMap<>();
		
	
		Cliente cli = getCliente();
		mapCliente.put("id",cli.getId());
		System.out.println("funcion eliminar "+cli.getId());
		
		clienteService.eliminarClientePorId(cli.getId());
		setlistaCliente(clienteService.listarTodosClientes());
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cliente eliminado ",cli.getId().toString()));
		//PrimeFaces.current().ajax().update("form:msgs", "form:tablaCliente");
		
		
		
	}
	
	public void onRowEdit(RowEditEvent event) {
		Cliente cli = ((Cliente) event.getObject());
		cli.setDireccion(cliente.getDireccion());
		clienteService.actualizarClientePorID(cli);
		FacesMessage msg = new FacesMessage("Cliente editado",cli.getId().toString());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Edicion cancelada",((Cliente) event.getObject()).getId().toString());

		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onCellEdit(CellEditEvent event) {
		Object oldValue = event.getOldValue();
		Object newValue = event.getNewValue();
		System.out.println("verifica: " + newValue);
		if (newValue != null && !newValue.equals(oldValue)) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente modificado", "Antes: " + oldValue + ", Ahora: " +newValue);

			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	// setters y getters
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getlistaCliente() {
		if(listaCliente == null)
			init();
		
		return listaCliente;
	}

	public void setlistaCliente(List<Cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}
	
	public void imprimirListaClientes() {
		System.out.println("Imprimiendo lista de clientes");
		for(Cliente cli : listaCliente ) {
			System.out.println("Nombre: "+cli.getNombre()+" "+cli.getApellido());
		}
	}
	
}