package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;


public class ControllerAides {
	private GestionOption opt;
	
	@FXML private Label titreRegle;
	@FXML private Label titreContacter;
	@FXML private Label but1;
	@FXML private Label but2;
	@FXML private Label but3;
	@FXML private Label comment1;
	@FXML private Label comment2;
	@FXML private Label comment3;
	@FXML private Label comment4;
	@FXML private Label comment5;
	@FXML private Label contact1;
	@FXML private Label contact2;
	@FXML private Label contact3;
	
	@FXML private Rectangle dait_regle1;
	@FXML private Rectangle dait_grosbloc;
	@FXML private Rectangle dait_petitbloc;
	@FXML private Rectangle dait_regles2;
	@FXML private Rectangle dait_contact;
	
	
	public ControllerAides(GestionOption opt) {
		this.opt = opt;
	}
	
	@FXML
	public void initialize() {
		opt.appliquerParametresAides(titreRegle, titreContacter, but1, but2, but3, comment1, comment2, comment3, comment4, comment5, contact1, contact2, contact3);
	}
}
