/******************************/
/* Equipo 2 */
/* William Mendez Gonzalez*/
/* Jesus A Lopez Guevara*/
/* 30/05/22 */
/*****************************/
package cursoDAgil.managedBean.cliente;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

import cursoDAgil.service.cliente.ClienteService;
import cursoDAgil.bd.domain.Cliente;

@Named
@ViewScoped
public class ClienteBean {
	@Inject
	ClienteService clienteService;
	private List<Cliente> clienteList;
	private Cliente cliente;
	
	

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClienteList() {
		if (clienteList == null)
			setClienteList(clienteService.listarTodosClientes());
		return clienteList;
	}

	public void setClienteList(List<Cliente> clienteList) {
		this.clienteList = clienteList;
	}

	public void onRowEdit(RowEditEvent event) {
		Cliente cliente = ((Cliente) event.getObject());
		System.out.println("datos cliente: " + cliente.getId());
		clienteService.actualizarClientePorID(cliente);
		FacesMessage msg = new FacesMessage("Cliente editado",

				cliente.getId().toString());

		FacesContext.getCurrentInstance().addMessage(null, msg);

	}

	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Edicion cancelada", ((Cliente) event.getObject()).getId().toString());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onCellEdit(CellEditEvent event) {
		Object oldValue = event.getOldValue();
		Object newValue = event.getNewValue();
		System.out.println("verifica: " + newValue);
		if (newValue != null && !newValue.equals(oldValue)) {
			FacesMessage msg = new

			FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente modificado", "Antes: " + oldValue + ", Ahora: " +

					newValue);

			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}
}
