package cursoDAgil.managedBean.validacion;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class ValidacionPersonalizada implements Validator{

	@Override
	public void validate(FacesContext contexto, UIComponent component, Object object) throws ValidatorException {
		// TODO Auto-generated method stub
		//Se obtiene el valor y se realiza un cast dependiento del tipo que
		//se va obtener
		String valor = (String) object;
		//Se realiza la validacion personalizada
		if(valor.length() < 5 || valor.length() > 10 ){
			throw new ValidatorException(
			new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ingresa los datos correctamente", null));

		}
	}

}
