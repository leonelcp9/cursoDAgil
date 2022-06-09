/*************************************/
/* Equipo 2 */
/* Lopez Guevara Jesus Alejandro y Cruz Peralta Leonel*/
/* 6/06/22 */
/*************************************/
package cursoDAgil.managedBean.venta;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import cursoDAgil.bd.domain.Cliente;
import cursoDAgil.bd.domain.DetalleVentas;
import cursoDAgil.bd.domain.Venta;
import cursoDAgil.service.cliente.ClienteService;
import cursoDAgil.service.detalleVentas.DetalleVentasService;
import cursoDAgil.service.venta.VentaService;

@Named
@ViewScoped
public class VentaBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6973148713401851467L;

	@Inject
	VentaService ventaService;
	
	@Inject
	ClienteService clienteService;
	
	@Inject
	DetalleVentasService detalleService;
	
	private List<Venta> listaVentas;
	private List<String> listaIdCliente;
	private List<String> listaIdVenta;
	private List<Cliente> listaIdCLienteN;
	private List<String> listaIdCLienteNs;
	
	private List<DetalleVentas> listaDetalle;
	
	private String ID_venta;
	private String ID_Cliente;
	private Venta NewVenta;
	private java.sql.Date fecha1;
	private String NewTotalVenta;
	
	
	@PostConstruct
	public void init() {
		if(listaVentas == null)
			listaVentas = new ArrayList<Venta>();
		if(listaIdCliente == null)
			listaIdCliente = new ArrayList<String>();
		if(listaIdVenta == null)
			listaIdVenta = new ArrayList<String>();
		if(listaDetalle == null)
			listaDetalle = new ArrayList<DetalleVentas>();
		
		fecha1 = new java.sql.Date(System.currentTimeMillis());
		setListaVentas(ventaService.listarTodasVentas());
		listaIdVenta.clear();
		listaIdCliente.clear();
		for(Venta i:listaVentas) {
			listaIdVenta.add(i.getIdVenta().toString());
			if(!listaIdCliente.contains(i.getClienteId().toString()))
				listaIdCliente.add(i.getClienteId().toString());
		}
	}

	public void listarVentasID() {
		setListaVentas(ventaService.consultarVentaId(Integer.parseInt(getID_venta())));
	}
	
	public void listarVentasCliente() {
		setListaVentas(ventaService.consultarVentaCliente(Integer.parseInt(getID_Cliente())));
	}
	
	public void eliminarVenta() {
		System.out.println(getID_venta());
		ventaService.eliminarVenta(Integer.parseInt(getID_venta()));
		init();
	}
	
	public void listarDetalleVenta() {
		int id=Integer.parseInt(getID_venta());
		System.out.println("id venta= "+id);
		setListaDetalle(detalleService.listarTodosDetalleVentas(id));
	}
	
	public void insertarVenta() {
		NewVenta = new Venta();
		NewVenta.setFecha(fecha1);
		NewVenta.setTotalVenta(Double.parseDouble(getID_venta()));
		NewVenta.setClienteId(Integer.parseInt(getID_Cliente()));
		
		System.out.println(getFecha1());
		System.out.println(getID_Cliente());
		System.out.println(getID_venta());//TOTAL GANANCIA
		
		ventaService.altaVenta(NewVenta);
		init();
	}
	
	public List<String> consultaIdTodosCliente(){
		listaIdCLienteN = new ArrayList<Cliente>();
		listaIdCLienteNs = new ArrayList<String>();
		setListaIdCLienteN(clienteService.listarTodosClientes());
		for(Cliente i:listaIdCLienteN)
			listaIdCLienteNs.add(i.getId().toString());
		return listaIdCLienteNs;
	}
	
	public List<Venta> getListaVentas() {
		return listaVentas;
	}
	public void setListaVentas(List<Venta> listaVentas) {
		this.listaVentas = listaVentas;
	}
	public List<String> getListaIdCliente() {
		return listaIdCliente;
	}
	public void setListaIdCliente(List<String> listaIdCliente) {
		this.listaIdCliente = listaIdCliente;
	}
	public String getID_venta() {
		return ID_venta;
	}
	public void setID_venta(String iD_venta) {
		ID_venta = iD_venta;
	}
	public List<String> getListaIdVenta() {
		return listaIdVenta;
	}
	public void setListaIdVenta(List<String> listaIdVenta) {
		this.listaIdVenta = listaIdVenta;
	}
	public String getID_Cliente() {
		return ID_Cliente;
	}
	public void setID_Cliente(String iD_Cliente) {
		ID_Cliente = iD_Cliente;
	}
	public List<Cliente> getListaIdCLienteN() {
		return listaIdCLienteN;
	}
	public void setListaIdCLienteN(List<Cliente> listaIdCLienteN) {
		this.listaIdCLienteN = listaIdCLienteN;
	}
	public List<String> getListaIdCLienteNs() {
		return listaIdCLienteNs;
	}
	public void setListaIdCLienteNs(List<String> listaIdCLienteNs) {
		this.listaIdCLienteNs = listaIdCLienteNs;
	}
	public java.sql.Date getFecha1() {
		return fecha1;
	}
	public void setFecha1(java.sql.Date fecha1) {
		this.fecha1 = fecha1;
	}
	public String getNewTotalVenta() {
		return NewTotalVenta;
	}
	public void setNewTotalVenta(String newTotalVenta) {
		NewTotalVenta = newTotalVenta;
	}

	public List<DetalleVentas> getListaDetalle() {
		return listaDetalle;
	}

	public void setListaDetalle(List<DetalleVentas> listaDetalle) {
		this.listaDetalle = listaDetalle;
	}
	
}
