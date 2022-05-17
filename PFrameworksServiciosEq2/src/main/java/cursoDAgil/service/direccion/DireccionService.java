//////////////////////////////////
/* Equipo 2							*/
/* Autor: Lòpez Guevara Jesus Alejandro	*/
/* Fecha: 16/05/2022				*/
package cursoDAgil.service.direccion;

import java.util.List;
import java.util.Map;

import cursoDAgil.bd.domain.Direccion;

public interface DireccionService {
	List<Direccion> obtenerDirecciones();
	Direccion obtenerDireccionPorId(Map<String, Integer> mapDireccion);

}
