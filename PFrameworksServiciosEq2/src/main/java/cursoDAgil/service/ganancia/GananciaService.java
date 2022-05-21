//////////////////////////////////////////////
/* Equipo 2									*/
/* Autor: Guerrero Hernández Samuel Antonio	*/
/* Fecha: 20/05/2022						*/
////////////////////////////////////////////// 
package cursoDAgil.service.ganancia;

import java.util.List;
import java.util.Map;

import cursoDAgil.bd.domain.Ganancia;

public interface GananciaService {
	List<Ganancia> listarGanancia();
	List<Ganancia> listarPorFecha(Map <String, String> mapGanancia);
	Integer altaGanancia(Ganancia ganancia);
}