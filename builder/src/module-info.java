module builder {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires java.desktop;
	requires org.apache.commons.lang3;
	requires java.sql;
	requires javafx.base;
	requires java.prefs;
	
	opens application to javafx.graphics, javafx.fxml;
	opens application.controller.graphic to javafx.fxml;
}
