package cursoDAgil.service.detalleVentas;

import java.util.List;

import cursoDAgil.bd.domain.DetalleVentas;

public interface DetalleVentasService {
	List<DetalleVentas> listarTodosDetalleVentas(Integer id);
	Integer altaDetalleVenta(DetalleVentas detalle);
	List<DetalleVentas> consultaDetalleVenta();
}
