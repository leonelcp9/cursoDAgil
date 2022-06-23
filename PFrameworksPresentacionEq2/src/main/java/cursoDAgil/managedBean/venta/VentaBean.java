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
import cursoDAgil.bd.domain.Producto;
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
	private List<String> listaNombreClientes;
	private List<DetalleVentas> listaDetalle;
	private List<Producto> carrito;
	
	private String ID_venta;
	private String ID_Cliente;
	private java.sql.Date fecha1;
	private String NewTotalVenta;
	private Venta venta;
	private Cliente cliente;
	private Producto producto;
	private Integer cantidad;
	private DetalleVentas detalle;
	
	@PostConstruct
	public void init() {
		cantidad = 1;
		if(listaVentas == null)
			listaVentas = new ArrayList<Venta>();
		if(listaIdCliente == null)
			listaIdCliente = new ArrayList<String>();
		if(listaIdVenta == null)
			listaIdVenta = new ArrayList<String>();
		if(listaDetalle == null) {
			listaDetalle = new ArrayList<DetalleVentas>();
			
			
		}
		if(detalle == null)
			detalle = new DetalleVentas();
		detalle.setProducto(null);
		producto = new Producto();
		if(carrito == null)
			carrito = new ArrayList<Producto>();
		
		if (producto == null) {
			producto = new Producto();
		}
		
		if(venta == null)
			venta = new Venta();
			venta.setCliente(null);
			cliente = new Cliente();
		fecha1 = new java.sql.Date(System.currentTimeMillis());
		setListaVentas(ventaService.listarTodasVentas());
		listaIdVenta.clear();
		listaIdCliente.clear();
		carrito.clear();
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
	
	public void agregarAcarrito() {
		System.out.println(venta.getCliente().getNombre());
		System.out.println(producto.getNombre());
	}
	public void insertarVenta() {
		Cliente cli = venta.getCliente();
		venta = new Venta();
		venta.setCliente(cli);
		venta.setFecha(fecha1);
		venta.setTotalVenta(Double.parseDouble(getID_venta()));
		venta.setClienteId(cli.getId());
		
		System.out.println(venta.getClienteId());
		System.out.println(venta.getTotalVenta());
		System.out.println(venta.getFecha());//TOTAL GANANCIA
		
		ventaService.altaVenta(venta);
		init();
	}
	
	public List<String> consultaIdTodosCliente(){
		listaIdCLienteN = new ArrayList<Cliente>();
		listaNombreClientes = new ArrayList<String>();
		setListaIdCLienteN(clienteService.listarTodosClientes());
		for(Cliente i:listaIdCLienteN)
			listaNombreClientes.add(i.getNombre()+" "+i.getApellido());
		return listaNombreClientes;
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

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Producto> getCarrito() {
		return carrito;
	}

	public void setCarrito(List<Producto> carrito) {
		this.carrito = carrito;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public DetalleVentas getDetalle() {
		return detalle;
	}

	public void setDetalle(DetalleVentas detalle) {
		this.detalle = detalle;
	}
	
}
