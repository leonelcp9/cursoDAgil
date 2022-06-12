//////////////////////////////////
/* Equipo 2							*/
/* Autores: Lòpez Guevara Jesùs Alejandro, Cruz Peralta Leonel */
/* Fecha: 25/04/2022				*/
///////////////////////////////////
package cursoDAgil.bd.mappers;

import java.util.List;

import cursoDAgil.bd.domain.Venta;

public interface VentaMapper {
	List<Venta> listarTodasVentas();
	List<Venta> consultarVentaCliente(Integer clienteId);
	Integer altaVenta(Venta venta);
	List<Venta> consultarVentaId(Integer idVenta);
	Integer eliminarVenta(Integer idVenta);
	Integer actualizarVenta(Venta venta);
}
