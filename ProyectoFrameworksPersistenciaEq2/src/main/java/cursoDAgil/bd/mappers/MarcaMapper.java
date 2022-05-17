/* Equipo 2
 * Autor: Narvaez Morales Jorge Lisandro
 * Fecha: 25/04/2022
 */

package cursoDAgil.bd.mappers;

import java.util.List;
import java.util.Map;

import cursoDAgil.bd.domain.Marca;

public interface MarcaMapper {
	List<Marca> listarMarcas();
	public	Integer nuevaMarca(Marca nombreMarca);
	public	Integer eliminarMarca(Integer idMarca);
	public   Integer actualizarMarca(Marca nombreMarca);
	Marca  obtenerMarcaporId(Map<String, Integer> mapMarca);
}