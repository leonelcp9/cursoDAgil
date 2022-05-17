//////////////////////////////////
/* Equipo 2							*/
/* Autor: Lòpez Guevara Jesus Alejandro	*/
/* Fecha: 16/05/2022				*/
/////////////////////////////////// 
package cursoDAgil.service.venta;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import cursoDAgil.bd.domain.Venta;
import cursoDAgil.dao.venta.VentaDao;

@Named
public class VentaServiceImpl implements VentaService,Serializable{

	private static final long serialVersionUID = 7962397593863792875L;
	
	@Inject
	VentaDao ventaDao;
	
	public List<Venta> listarTodasVentas() {
		// TODO Auto-generated method stub
		return ventaDao.listarTodasVentas();
	}


	public List<Venta> consultarVentaCliente(Integer clienteId) {
		// TODO Auto-generated method stub
		return ventaDao.consultarVentaCliente(clienteId);
	}


	public Integer altaVenta(Venta venta) {
		// TODO Auto-generated method stub
		return ventaDao.altaVenta(venta);
	}


	public List<Venta> consultarVentaId(Integer idVenta) {
		// TODO Auto-generated method stub
		return ventaDao.consultarVentaId(idVenta);
	}

	
	public Integer eliminarVenta(Integer idVenta) {
		// TODO Auto-generated method stub
		return ventaDao.eliminarVenta(idVenta);
	}

}
