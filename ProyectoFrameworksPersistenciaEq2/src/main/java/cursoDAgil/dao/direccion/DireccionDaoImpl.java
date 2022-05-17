//////////////////////////////////
/* Equipo 2							*/
/* Autor: Mendez Gonzalez William	*/
/* Fecha: 27/04/2022				*/
/////////////////////////////////// 
package cursoDAgil.dao.direccion;

import java.util.List;
import java.util.Map;

import javax.inject.Named;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import cursoDAgil.bd.domain.Direccion;
import cursoDAgil.bd.mappers.DireccionMapper;

@Named
public class DireccionDaoImpl implements DireccionDao{
	SqlSession sqlSession;
	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	@Override
	public Integer nuevaDireccionCliente(Direccion direccion) {
		try{
			DireccionMapper direccionMapper =sqlSession.getMapper(DireccionMapper.class);
			System.out.println("direccion creada con �xito");
			return direccionMapper.nuevaDireccionCliente(direccion);
		}catch (Exception e) {
		System.out.println("Error: " + e);
		}
		return null;
	}
	@Override
	public Direccion obtenerDireccionPorId(Map<String, Integer> mapDireccion)
	{
		try{
			DireccionMapper direccionMapper =
			sqlSession.getMapper(DireccionMapper.class);
		
			return direccionMapper.obtenerDireccionPorId(mapDireccion);
		}catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return null;
	}
	@Override
	public List<Direccion> obtenerDirecciones() {
		List<Direccion> list =null;
		try{
			DireccionMapper direccionMapper =
			sqlSession.getMapper(DireccionMapper.class);
			list=direccionMapper.obtenerDirecciones();
			for(Direccion c:list) {
				System.out.println("Id: "+ c.getIddireccion());
				System.out.println("Nombre: " + c.getCalle());
				System.out.println("Direccion"+c.getPais()+" "+c.getEstado()+" "+ c.getCiudad()+" "+c.getCalle());
			}
			return direccionMapper.obtenerDirecciones();
		}catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return null;
	}
	@Override
	public Integer eliminarDireccionPorId(Integer iddireccion) {
		try {
			DireccionMapper direccionmapper=sqlSession.getMapper(DireccionMapper.class);
			System.out.println("Direccion Eliminado");
			return direccionmapper.eliminarDireccionPorId(iddireccion);
		}catch(Exception e) {
			System.out.println("Error"+ e);
		}
		return null;
	}
	@Override
	public Integer actualizarDireccionPorID(Direccion direccion) {
		try{
			DireccionMapper direccionmapper=sqlSession.getMapper(DireccionMapper.class);
			System.out.println("Direccion Actualizado con Exito");
			return direccionmapper.actualizarDireccionPorID(direccion);
		}catch(Exception e) {
			System.out.println("Error "+e);
		}
		return null;
	}
	
	
}
