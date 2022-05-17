//////////////////////////////////
/* Equipo 2							*/
/* Autores: Lòpez Guevara Jesùs Alejandro, Cruz Peralta Leonel */
/* Fecha: 25/04/2022				*/
///////////////////////////////////
package cursoDAgil.bd.mappers;

import java.util.List;

import cursoDAgil.bd.domain.DetalleVentas;

public interface DetalleVentasMapper {
	List<DetalleVentas> listarTodosDetalleVentas(Integer id);
	Integer altaDetalleVenta(DetalleVentas detalle);
	List<DetalleVentas> consultaDetalleVenta();

}
