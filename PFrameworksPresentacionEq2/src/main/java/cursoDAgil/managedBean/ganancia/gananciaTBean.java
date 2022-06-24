package cursoDAgil.managedBean.ganancia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;


import cursoDAgil.bd.domain.Ganancia;
import cursoDAgil.service.ganancia.GananciaService;

@Named
@ViewScoped
public class gananciaTBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5180087505132294899L;

	@Inject
	GananciaService gananciaService;
	
	private List<Ganancia> listaGanancia;
	private Ganancia ganancia;
	
	@PostConstruct
	public void init() {
		if (listaGanancia == null)
			listaGanancia = new ArrayList<Ganancia>();
		if (ganancia == null) {
			ganancia = new Ganancia();
		}
		
		setListaGanancia(gananciaService.listarGanancia());
	}

	public void registrar() {
		gananciaService.altaGanancia(getGanancia());
		setGanancia(new Ganancia());
		setListaGanancia(gananciaService.listarGanancia());
		getListaGanancia();

		FacesContext.getCurrentInstance().addMessage("null", new FacesMessage("Registro exitoso!"));
	}

	public void refrescar() {
		
		listaGanancia=null;
		ganancia=null;
		init();
		//System.out.println("Hola jejejejeejejejejejejejejejejejejejeejejejejejejejejejejejejejejejejejejejejejejejej");
	}
	// setter´s y getter´s

	public Ganancia getGanancia() {
		return ganancia;
	}

	public void setGanancia(Ganancia ganancia) {
		this.ganancia = ganancia;
	}

	public List<Ganancia> getListaGanancia() {
		return listaGanancia;
	}

	public void setListaGanancia(List<Ganancia> listaGanancia) {
		this.listaGanancia = listaGanancia;
	}
}
