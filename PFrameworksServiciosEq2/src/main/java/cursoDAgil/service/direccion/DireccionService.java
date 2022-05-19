//////////////////////////////////
/* Equipo 2							*/
/* Autores: Lòpez Guevara Jesus Alejandro y Cruz Peralta Leonel	*/
/* Fecha: 16/05/2022				*/
package cursoDAgil.service.direccion;

import java.util.List;
import java.util.Map;

import cursoDAgil.bd.domain.Direccion;

public interface DireccionService {
	List<Direccion> obtenerDirecciones();
	Direccion obtenerDireccionPorId(Map<String, Integer> mapDireccion);
	Integer nuevaDireccionCliente(Direccion direccion);
	Integer eliminarDireccionPorId(Integer iddireccion);
	Integer actualizarDireccionPorID(Direccion direccion);
}
