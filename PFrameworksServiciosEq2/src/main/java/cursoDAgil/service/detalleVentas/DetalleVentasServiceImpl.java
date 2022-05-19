//////////////////////////////////////
/* Equipo 2							*/
/* Autor: Cruz Peralta Leonel   	*/
/* Fecha: 18/05/2022				*/
//////////////////////////////////////
package cursoDAgil.service.detalleVentas;

import java.io.Serializable;
import java.util.List;

import cursoDAgil.bd.domain.DetalleVentas;
import cursoDAgil.dao.detalleVentas.DetalleVentasDao;

public class DetalleVentasServiceImpl implements DetalleVentasService, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 229175845631765742L;
	DetalleVentasDao detalleVentasDao;
	
	@Override
	public List<DetalleVentas> listarTodosDetalleVentas(Integer id) {
		// TODO Auto-generated method stub
		return detalleVentasDao.listarTodosDetalleVentas(id);
	}

	@Override
	public Integer altaDetalleVenta(DetalleVentas detalle) {
		// TODO Auto-generated method stub
		return detalleVentasDao.altaDetalleVenta(detalle);
	}

	@Override
	public List<DetalleVentas> consultaDetalleVenta() {
		// TODO Auto-generated method stub
		return detalleVentasDao.consultaDetalleVenta();
	}

}
