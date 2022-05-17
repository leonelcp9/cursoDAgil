package cursoDAgil.dao.marca;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import cursoDAgil.bd.domain.Marca;
import cursoDAgil.bd.mappers.MarcaMapper;


@Named
public class MarcaDaoImpl implements MarcaDao, Serializable {
	private static final long serialVersionUID = -6456965766968902300L;
	SqlSession sqlSession;
	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	public List<Marca> listarMarcas() {
		// TODO Auto-generated method stub
		List<Marca> list = null;
		try {
			MarcaMapper marcaMapper = sqlSession.getMapper(MarcaMapper.class);
			list = marcaMapper.listarMarcas();
			for(Marca m:list) {
				System.out.println("☃  Id: "+ m.getIdMarca()+"                            ☃");
				System.out.println("☃  Nombre: "+ m.getNombreMarca());
				System.out.println("✺✺✺✺✺✺✺✺✺✺✺✺✺✺✺✺✺✺✺✺✺✺✺✺✺✺✺");
				
			}
			return list;
		}catch(Exception e){
			System.out.println("Error: "+ e);
		}
		return null;
	}
	
	public Integer nuevaMarca(Marca nombreMarca) {
		try{
		MarcaMapper marcaMapper = sqlSession.getMapper(MarcaMapper.class);
		return marcaMapper.nuevaMarca(nombreMarca);
	}catch (Exception e) {
		System.out.println("Error: " + e);
	}
		return null;
	}
	
	public Integer eliminarMarca(Integer idMarca) {
		try{
			MarcaMapper marcaMapper = sqlSession.getMapper(MarcaMapper.class);
			return marcaMapper.eliminarMarca(idMarca);
		}catch (Exception e) {
			System.out.println("Error: " + e);
		}
		
		return null;
	}
	
	
	public Integer actualizarMarca(Marca nombreMarca) {
		try {
			MarcaMapper marcaMapper = sqlSession.getMapper(MarcaMapper.class);
			return marcaMapper.actualizarMarca(nombreMarca);
		}catch (Exception e) {
			System.out.println("Error: " + e);
		}
		
		return null;
	}

	public Marca obtenerMarcaporId(Map<String, Integer> mapMarca) {
		try{
			MarcaMapper marcaMapper = sqlSession.getMapper(MarcaMapper.class);
	
			return marcaMapper.obtenerMarcaporId(mapMarca);
		}catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return null;
	}
}