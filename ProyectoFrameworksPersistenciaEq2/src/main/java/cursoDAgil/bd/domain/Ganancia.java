package cursoDAgil.bd.domain;

public class Ganancia {
	private Integer idGanancia;
	private Integer ventaId;
	private Float totalGanancia;
	private String fecha;
	public Integer getIdGanancia() {
		return idGanancia;
	}
	public void setIdGanancia(Integer idGanancia) {
		this.idGanancia = idGanancia;
	}
	public Integer getVentaId() {
		return ventaId;
	}
	public void setVentaId(Integer ventaId) {
		this.ventaId = ventaId;
	}
	public Float getTotalGanancia() {
		return totalGanancia;
	}
	public void setTotalGanancia(Float totalGanancia) {
		this.totalGanancia = totalGanancia;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
}
