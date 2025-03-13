package application.view.utils;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;

public class UserInterfaceHelper {
	
	private UserInterfaceHelper() {
	    throw new IllegalStateException("UserInterfaceHelper class");
  }

	public static void initializeLabelImage(Label label, ImageView image, String str1, String str2, String teamName) {
		// Imposta il testo della Label
		if (str2 != null) {
			label.setText(str1 + " " + str2);
        } else {
        	label.setText(str1);
		}
		label.setPrefWidth(Region.USE_COMPUTED_SIZE);
		label.setPrefHeight(Region.USE_COMPUTED_SIZE);

		setImage(image, teamName);
	}

	
	public static void setImage(ImageView teamLogoImage, String teamName) {
		// Imposta l'immagine del logo
		try {
			Image img = new Image(UserInterfaceHelper.class.getResource("/images/logos/" + teamName.toLowerCase() + ".png").toExternalForm());
			teamLogoImage.setImage(img);	
			// Mantiene il rapporto di aspetto (evita distorsioni)
			teamLogoImage.setPreserveRatio(true);
					
		} catch (NullPointerException e) {
			// Gestione immagine mancante
			teamLogoImage.setImage(getDefaultLogo());
		}		
	}
	
	
	private static Image getDefaultLogo() {
		return new Image(UserInterfaceHelper.class.getResource("/images/logos/default.png").toExternalForm());
	}
}
