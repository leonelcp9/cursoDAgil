package cursoDAgil.dao.marca;

import java.util.List;
import java.util.Map;

import cursoDAgil.bd.domain.Marca;

public interface MarcaDao {
	List<Marca> listarMarcas();
	public Integer nuevaMarca(Marca nombreMarca);
	public Integer eliminarMarca(Integer idMarca);
	public Integer actualizarMarca(Marca nombreMarca);
	Marca  obtenerMarcaporId(Map<String, Integer> mapMarca);
}
