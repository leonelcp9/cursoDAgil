//////////////////////////////////
/* Equipo 2							*/
/* Autores: Lòpez Guevara Jesùs Alejandro, Cruz Peralta Leonel */
/* Fecha: 25/04/2022				*/
///////////////////////////////////
package cursoDAgil.dao.venta;

import java.util.List;

import cursoDAgil.bd.domain.Venta;

public interface VentaDao {
	List<Venta> listarTodasVentas();
	List<Venta> consultarVentaCliente(Integer clienteId);
	Integer altaVenta(Venta venta);
	List<Venta> consultarVentaId(Integer idVenta);
	Integer eliminarVenta(Integer idVenta);
	Integer actualizarVenta(Venta venta);
}