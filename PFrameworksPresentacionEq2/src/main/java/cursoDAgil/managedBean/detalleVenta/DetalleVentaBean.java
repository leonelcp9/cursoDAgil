package cursoDAgil.managedBean.detalleVenta;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import cursoDAgil.bd.domain.DetalleVentas;
import cursoDAgil.service.detalleVentas.DetalleVentasService;

@Named("detalleVentaBean")
@ViewScoped
public class DetalleVentaBean {
	@Inject
	DetalleVentasService detalleVentaService;
	private List<DetalleVentas> detalleList;
	private String idVenta="2";
	
	@PostConstruct
	public void init() {
		if(detalleList == null)
			listarDetalleVentas();
	}

	public void listarDetalleVentas() {
		setDetalleList(detalleVentaService.listarTodosDetalleVentas(Integer.parseInt(getIdVenta())));
		System.out.println("id venta = "+this.idVenta);
	}

	public void setDetalleList(List<DetalleVentas> detalleList) {
		this.detalleList = detalleList;
	}

	public String getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(String idVenta) {
		this.idVenta = idVenta;
	}
	
	
}
