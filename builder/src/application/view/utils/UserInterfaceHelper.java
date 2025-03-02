package application.view.utils;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;

public class UserInterfaceHelper {

	public static void initializeUserInfo(Label nameLabel, ImageView teamLogoImage, String name, String surname, String teamName) {
		// Imposta il testo della Label
		nameLabel.setText(name + " " + surname);
		nameLabel.setPrefWidth(Region.USE_COMPUTED_SIZE);
		nameLabel.setPrefHeight(Region.USE_COMPUTED_SIZE);

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
