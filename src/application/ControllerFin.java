package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ControllerFin {
	private Stage fen;
	private GestionJeu jeu;
	private GestionOption opt;
	private boolean aGagne;
	
	@FXML private Label libelleMessagePrincipal;
	@FXML private Label libelleMotADeviner;
	@FXML private Label afficheurNomJoueur;
	@FXML private Label afficheurMotMystere;
	
	@FXML private Button clicRecommencer;
	@FXML private Button clicRetourAccueil;
	@FXML private Button clicQuitter;
	
	public ControllerFin(Stage fen, GestionJeu jeu, GestionOption opt, boolean aGagne) {
		this.fen = fen;
		this.jeu = jeu;
		this.opt = opt;
		this.aGagne = aGagne;
	}
	
	@FXML
	public void initialize() {
		afficheurNomJoueur.setText(jeu.getNomJoueur());
		afficheurMotMystere.setText(jeu.getMotMystere().toString());
		
		if (aGagne) 
			opt.appliquerParametresFinVictoire(libelleMessagePrincipal, libelleMotADeviner);
		else
			opt.appliquerParametresFinDefaite(libelleMessagePrincipal, libelleMotADeviner);
	}
	
	@FXML public void clicRecommencer() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("jeu.fxml"));
		loader.setController(new ControllerJeu(fen, jeu, opt));
		fen.setScene(new Scene(loader.load(), 800, 580));
		jeu.InitialiserPartie();
	}
	
	@FXML public void clicRetourAccueil() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("accueil.fxml"));
		loader.setController(new ControllerAccueil(fen, jeu, opt));
		
		AnchorPane jeu = loader.load();
		fen.setScene(new Scene(jeu, 800, 580));
	}
	
	@FXML public void clicQuitter() {
		fen.close();
	}
}
