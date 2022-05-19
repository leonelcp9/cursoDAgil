//////////////////////////////////
/* Equipo 2			
/* Autor: Narváez Morales Jorge Lisandro
/* Fecha: 17/05/2022				
/////////////////////////////////// 


package cursoDAgil.service.marca;

import java.util.List;
import java.util.Map;

import cursoDAgil.bd.domain.Marca;

public interface MarcaService {
	List<Marca> listarMarcas();
	public Integer nuevaMarca(Marca nombreMarca);
	public Integer eliminarMarca(Integer idMarca);
	public Integer actualizarMarca(Marca nombreMarca);
	Marca  obtenerMarcaporId(Map<String, Integer> mapMarca);
}
