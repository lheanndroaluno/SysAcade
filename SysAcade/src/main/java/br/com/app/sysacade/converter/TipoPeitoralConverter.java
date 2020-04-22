package br.com.app.sysacade.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "tipoPeitoralConverter")
public class TipoPeitoralConverter implements Converter {

	private static final String ATTRIBUTE_ENUM_TYPE = "GenericEnumConverter.enumType";

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Class<Enum> enumType = (Class<Enum>) component.getAttributes().get(ATTRIBUTE_ENUM_TYPE);
		try {
			return Enum.valueOf(enumType, value);
		} catch (Exception erro) {
			throw new ConverterException(new FacesMessage(
					"Exception:" + erro.getMessage() + "\n" + "Value is not an enum of type: " + enumType));
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value instanceof Enum) {
			component.getAttributes().put(ATTRIBUTE_ENUM_TYPE, value.getClass());
			return ((Enum<?>) value).name();
		} else {
			throw new ConverterException(new FacesMessage("Value is not an enum: " + value.getClass()));
		}
	}

}
