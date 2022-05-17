package cursoDAgil.dao.ganancia;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import cursoDAgil.bd.domain.DetalleVentas;
import cursoDAgil.bd.domain.Ganancia;
import cursoDAgil.bd.domain.Producto;
import cursoDAgil.bd.domain.Venta;
import cursoDAgil.bd.mappers.GananciaMapper;
import cursoDAgil.bd.mappers.VentaMapper;



@Named
public class GananciaDaoImpl implements GananciaDao, Serializable{
	private static final long serialVersionUID = -6456965766968902300L;
	SqlSession sqlSession;
	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<Ganancia> listarGanancia() {
		// TODO Auto-generated method stub
		List<Ganancia> list = null;
		try {
			GananciaMapper gananciaMapper = sqlSession.getMapper(GananciaMapper.class);
			list = gananciaMapper.listarGanancia();
			for(Ganancia c:list) {
				System.out.println("ID ganancia : "+ c.getIdGanancia());
				System.out.println("ID venta: "+c.getVentaId());
				System.out.println("Total ganancia: "+c.getTotalGanancia());
				System.out.println("Fecha: "+c.getFecha());
				System.out.println();
			}
			return list;
		}catch(Exception e){
			System.out.println("Error: "+ e);
		}
		return null;
	}
	
	public List<Ganancia> listarPorFecha(Map <String, String> mapGanancia) {
		try {
			GananciaMapper gananciaMapper = sqlSession.getMapper(GananciaMapper.class);
			List<Ganancia> list = null;
			list = gananciaMapper.listarPorFecha(mapGanancia);
			
			for(Ganancia g:list) {
				System.out.println("ID Ganancia: " + g.getIdGanancia());
				System.out.println("Venta id: " + g.getVentaId());
				System.out.println("Total ganancias: " + g.getTotalGanancia());
				System.out.println("Fecha: " + g.getFecha());
				System.out.println();
			}
			
		}catch(Exception e) {
			System.out.println("Error here: "+e);
		}
		return null;
	}
	
	public Integer crearGananciaDeVenta(Ganancia ganancia) {
		try {
			
			GananciaMapper gananciaMapper = sqlSession.getMapper(GananciaMapper.class);
			System.out.println("Ganancia creada con exito");
			return gananciaMapper.crearGananciaDeVenta(ganancia);
			
		}catch(Exception e) {
			System.out.println("Error"+e);
		}
		return null;
	}
	
	public Float calcularGanancia(List<Producto> productos) {
		Float ganancia=0f;
		for(Producto aux : productos) {
			ganancia+=aux.getPrecioVta()-aux.getPrecio();
		}
		return ganancia;
	}
}
