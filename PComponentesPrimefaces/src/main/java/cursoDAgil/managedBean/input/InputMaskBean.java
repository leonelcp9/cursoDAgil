package cursoDAgil.managedBean.input;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class InputMaskBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5450589886530247797L;

	private String date;
	private String phone;
	private String key;
	//	método que muestra las mascaras en un growl personalizado
	public void showMask(){
		FacesContext.getCurrentInstance().addMessage("growlMensaje", new FacesMessage( FacesMessage.SEVERITY_INFO, "Mascara Primefaces!!", "Date: " + getDate() + " Phone: " + getPhone()+ " key: " + getKey()));}
	//setters y getters
	public String getDate() {
		return date;
	}
	public String getPhone() {
		return phone;
	}
	public String getKey() {
		return key;
	}
}