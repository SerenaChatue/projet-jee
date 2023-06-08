package projet.converter;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

import projet.jsf.data.Utilisateur;

@Named
@RequestScoped
public class ConverterUtilisateur implements Converter<Utilisateur> {

	// Actions

	@SuppressWarnings("unchecked")
	@Override
	public Utilisateur getAsObject(FacesContext context, UIComponent uic, String value) {

		if (value == null || value.isEmpty()) {
			return null;
		}

		List<Utilisateur> items = null;
		for (UIComponent c : uic.getChildren()) {
			if (c instanceof UISelectItems) {
				items = (List<Utilisateur>) ((UISelectItems) c).getValue();
				break;
			}
		}

		var id = Integer.valueOf(value);
		for (Utilisateur item : items) {
			if (item.getId()==(id)) {
				return item;
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Utilisateur item) {

		if (item == null) {
			return "";
		}
		return String.valueOf(item.getId());
	}
}
