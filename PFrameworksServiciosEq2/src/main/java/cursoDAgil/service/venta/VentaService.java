//////////////////////////////////
/* Equipo 2							*/
/* Autor: Lòpez Guevara Jesus Alejandro	*/
/* Fecha: 16/05/2022				*/
/////////////////////////////////// 
package cursoDAgil.service.venta;

import java.util.List;

import cursoDAgil.bd.domain.Venta;



public interface VentaService {
	List<Venta> listarTodasVentas();
	List<Venta> consultarVentaCliente(Integer clienteId);
	Integer altaVenta(Venta venta);
	List<Venta> consultarVentaId(Integer idVenta);
	Integer eliminarVenta(Integer idVenta);

}
