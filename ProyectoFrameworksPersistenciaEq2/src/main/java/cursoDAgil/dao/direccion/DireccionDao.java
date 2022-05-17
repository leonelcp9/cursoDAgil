//////////////////////////////////
/* Equipo 2							*/
/* Autor: Mendez Gonzalez William	*/
/* Fecha: 27/04/2022				*/
/////////////////////////////////// 
package cursoDAgil.dao.direccion;

import java.util.List;
import java.util.Map;

import cursoDAgil.bd.domain.Direccion;

public interface DireccionDao {
	List<Direccion> obtenerDirecciones();
	Integer nuevaDireccionCliente(Direccion direccion);
	Direccion obtenerDireccionPorId(Map<String, Integer> mapDireccion);
	Integer eliminarDireccionPorId(Integer iddireccion);
	Integer actualizarDireccionPorID(Direccion direccion);
}