package cursoDAgil.managedBean.input;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class InputBean implements Serializable{

		private String inputText,email;
		private Integer inputInteger;
		private Double inputDouble;
		
		public void validado() {
			FacesContext.getCurrentInstance().addMessage( null,new FacesMessage(FacesMessage.SEVERITY_INFO,"campos validos",null));
			System.out.println("Campos validados: "+getInputText());

		}
		public String getInputText() {
			return inputText;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public Integer getInputInteger() {
			return inputInteger;
		}
		public void setInputInteger(Integer inputInteger) {
			this.inputInteger = inputInteger;
		}
		public Double getInputDouble() {
			return inputDouble;
		}
		public void setInputDouble(Double inputDouble) {
			this.inputDouble = inputDouble;
		}
		public void setInputText(String inputText) {
			this.inputText = inputText;
		}
		
}
