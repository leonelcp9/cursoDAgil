//////////////////////////////////////////////
/* Equipo 2									*/
/* Autor: Guerrero Hernández Samuel Antonio	*/
/* Fecha: 20/05/2022						*/
////////////////////////////////////////////// 
package cursoDAgil.service.ganancia;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import cursoDAgil.bd.domain.Ganancia;
import cursoDAgil.dao.ganancia.GananciaDao;

@Named
public class GananciaServiceImpl implements GananciaService, Serializable{
	private static final long serialVersionUID = -3636050252009531409L;
	@Inject
	GananciaDao gananciaDao;
	
	@Override
	public List<Ganancia> listarGanancia(){
		return gananciaDao.listarGanancia();
	}
	
	public List<Ganancia> listarPorFecha(Map <String, String> mapGanancia) {
		return gananciaDao.listarPorFecha(mapGanancia);
	}

	@Override
	public Integer altaGanancia(Ganancia ganancia) {
		return gananciaDao.altaGanancia(ganancia);
	}
	
	
}