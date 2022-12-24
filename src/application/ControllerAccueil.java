package application;

import java.io.IOException;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Callback;

public class ControllerAccueil {
	private Stage fen;
	private GestionJeu jeu;
	private GestionOption opt;
	
	@FXML private Label libelleTitre;
	@FXML private Label libelleSaisieNom;
	@FXML private TextField zoneSaisieNomJoueur;
	@FXML private Button boutonCommencer;
	@FXML private Button boutonAides;
	@FXML private Button boutonOptions;
	@FXML private Button boutonQuitter;
	@FXML private ImageView VueImageFond;
	
	@FXML private Rectangle recaccueil1;
	
	public ControllerAccueil(Stage primaryStage, GestionJeu jeu, GestionOption opt) {
		this.fen = primaryStage;
		this.jeu = jeu;
		this.opt = opt;
	}
	
	@FXML
	public void initialize() {
		opt.appliquerParametresAccueil(libelleTitre, libelleSaisieNom, boutonCommencer, boutonAides, boutonOptions, boutonQuitter);
		initialiserZoneSaisieNomJoueur();
	}
	
	public void initialiserZoneSaisieNomJoueur() {
		if (jeu.getNomJoueur() == "" || jeu.getNomJoueur().equals("Inconnu")) {
			jeu.setNomJoueur("Inconnu");
		}		
		else {
			zoneSaisieNomJoueur.setText(jeu.getNomJoueur());
		}
	}
	
	@FXML
	public void clicCommencer() throws IOException {
		if (!zoneSaisieNomJoueur.getText().trim().equals("")) {
			jeu.setNomJoueur(zoneSaisieNomJoueur.getText());
		}
		
		jeu.InitialiserPartie();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("jeu.fxml"));	
		loader.setController(new ControllerJeu(fen, jeu, opt));
		AnchorPane scene = loader.load();
		fen.setScene(new Scene(scene, 800, 580));
	}
	
	@FXML
	public void clicAides(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("regles.fxml"));
		ControllerAides controllerAides = new ControllerAides(opt);
		loader.setController(controllerAides);
		AnchorPane regles = loader.load();
		Dialog<ButtonType> dialog = new Dialog<>();
		dialog.getDialogPane().setContent(regles);
		ButtonType boutonFermer = new ButtonType("X");
		dialog.getDialogPane().getButtonTypes().addAll(boutonFermer);
		
		dialog.setResultConverter(new Callback<ButtonType, ButtonType>() {
		    @Override
		    public ButtonType call(ButtonType b) {
		    	return b;
		    }
		});
		dialog.showAndWait();
	}
	
	@FXML
	public void clicOptions() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("options.fxml"));
		ControllerOptions controllerOptions = new ControllerOptions(opt);
		loader.setController(controllerOptions);

		Dialog<GestionOption> dialog = new Dialog<>();
		dialog.getDialogPane().setContent(loader.load());
		
		ButtonType boutonOK = new ButtonType("OK");
		ButtonType boutonAnnuler = new ButtonType("Annuler");
		ButtonType boutonReinitialiser = new ButtonType("Reinitialiser");
		dialog.getDialogPane().getButtonTypes().addAll(boutonOK, boutonAnnuler, boutonReinitialiser);
		
		dialog.setResultConverter(new Callback<ButtonType, GestionOption>() {
		    @Override
		    public GestionOption call(ButtonType b) {
		    	if (b == boutonOK)
		    		return controllerOptions.valeurOK();
		    	else if (b == boutonAnnuler)
		    		return controllerOptions.valeurAnnuler();
		    	else
		    		return controllerOptions.valeurDefaut();
		    }
		});
		Optional<GestionOption> result = dialog.showAndWait();
		opt = result.get();	
		loader = new FXMLLoader(getClass().getResource("accueil.fxml"));
		loader.setController(new ControllerAccueil(fen, jeu, opt));
		fen.setScene(new Scene(loader.load(), 800, 580));
	}
	
	@FXML
	public void clicQuitter() {
		fen.close();
	}
	
}


