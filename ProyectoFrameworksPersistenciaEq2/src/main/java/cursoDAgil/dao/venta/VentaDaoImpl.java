//////////////////////////////////
/* Equipo 2							*/
/* Autores: Lòpez Guevara Jesùs Alejandro, Cruz Peralta Leonel */
/* Fecha: 25/04/2022				*/
///////////////////////////////////
package cursoDAgil.dao.venta;

import java.io.Serializable;
import java.util.List;

import javax.inject.Named;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import cursoDAgil.bd.domain.Direccion;
import cursoDAgil.bd.domain.Venta;
import cursoDAgil.bd.mappers.DireccionMapper;
import cursoDAgil.bd.mappers.VentaMapper;

@Named
public class VentaDaoImpl implements VentaDao, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	SqlSession sqlSession;
	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<Venta> listarTodasVentas() {
		List<Venta> list = null;
		try {
			VentaMapper ventaMapper = sqlSession.getMapper(VentaMapper.class);
			list = ventaMapper.listarTodasVentas();
			for(Venta ven:list) {
				System.out.println("idVenta: "+ ven.getIdVenta());
				System.out.println("clienteId: "+ ven.getClienteId());
				System.out.println("totalVenta: "+ ven.getTotalVenta());
				System.out.println("fecha: "+ ven.getFecha());
				System.out.println("Cliente(id): "+ ven.getCliente().getId());
				System.out.println("Cliente(nombre): "+ ven.getCliente().getNombre());
				System.out.println("Cliente(apellido): "+ ven.getCliente().getApellido());
				System.out.println("Cliente(email): "+ ven.getCliente().getEmail());
				System.out.println("Cliente(sexo): "+ ven.getCliente().getSexo());
				System.out.println("Cliente(idDireccion): "+ ven.getCliente().getIddireccion());
				System.out.println();
			}
			return list;
		}catch (Exception e) {
			System.out.println("Error: "+ e);
		}
		return null;
	}
	
	public List<Venta> consultarVentaCliente(Integer clienteId) {
		List<Venta> list = null;
		try {
			VentaMapper ventaMapper = sqlSession.getMapper(VentaMapper.class);
			list = ventaMapper.consultarVentaCliente(clienteId);
			for(Venta ven:list) {
				System.out.println("idVenta: "+ ven.getIdVenta());
				System.out.println("clienteId: "+ ven.getClienteId());
				System.out.println("totalVenta: "+ ven.getTotalVenta());
				System.out.println("fecha: "+ ven.getFecha());
				System.out.println("Cliente(id): "+ ven.getCliente().getId());
				System.out.println("Cliente(nombre): "+ ven.getCliente().getNombre());
				System.out.println("Cliente(apellido): "+ ven.getCliente().getApellido());
				System.out.println("Cliente(email): "+ ven.getCliente().getEmail());
				System.out.println("Cliente(sexo): "+ ven.getCliente().getSexo());
				System.out.println("Cliente(idDireccion): "+ ven.getCliente().getIddireccion());
				System.out.println();
			}
			return list;
		}catch (Exception e) {
			System.out.println("Error: "+ e);
		}
		return null;
	}
	
	public Integer altaVenta(Venta venta) {
		try {
			VentaMapper ventaMapper = sqlSession.getMapper(VentaMapper.class);
			System.out.println("Venta creada con exito");
			return ventaMapper.altaVenta(venta);
		}catch(Exception e) {
			System.out.println("Error"+e);
		}
		return null;
	}
	public List<Venta> consultarVentaId(Integer idVenta) {
		List<Venta> list = null;
		try {
			VentaMapper ventaMapper = sqlSession.getMapper(VentaMapper.class);
			list = ventaMapper.consultarVentaId(idVenta);
			for(Venta ven:list) {
				System.out.println("idVenta: "+ ven.getIdVenta());
				System.out.println("clienteId: "+ ven.getClienteId());
				System.out.println("totalVenta: "+ ven.getTotalVenta());
				System.out.println("fecha: "+ ven.getFecha());
				System.out.println();
			}
			return list;
		}catch (Exception e) {
			System.out.println("Error: "+ e);
		}
		return null;
		
	}

	public Integer eliminarVenta(Integer idVenta) {
		try {
			VentaMapper ventaMapper = sqlSession.getMapper(VentaMapper.class);
			return ventaMapper.eliminarVenta(idVenta);
		}catch(Exception e) {
			System.out.println("Error: "+e);
		}
		return null;
	}

	public Integer actualizarVenta(Venta venta) {
		try {
			VentaMapper ventaMapper = sqlSession.getMapper(VentaMapper.class);
			return ventaMapper.actualizarVenta(venta);
			
		}catch(Exception e) {
			System.out.println("Error: "+e);
		}
		return null;
	}
}
