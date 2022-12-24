package application;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Vector;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ControllerJeu {
	private Stage fen;
	private GestionJeu jeu;
	private GestionOption opt;
	private StringBuilder messageAfficheurMotMystere = new  StringBuilder("");
	
	@FXML private Label libelleDifficulte;
	@FXML private Label libelleErreursCommises;
	@FXML private Label libelleMotADeviner;
	@FXML private Label afficheurMotMystere;
	@FXML private Label afficheurDifficulte;
	@FXML private Label afficheurNombreErreursCommises;
	@FXML private GridPane grilleBoutonsLettres;
	
	@FXML private Button boutonRecommencer;
	@FXML private Button boutonRetourAccueil;
	@FXML private Button boutonQuitter;
	
	@FXML private Rectangle orange_dalt;
	
	@FXML private Rectangle jeu_label;
	@FXML private Rectangle jeu1;
	@FXML private Rectangle jeu2;
	@FXML private Rectangle devin;
	@FXML private Rectangle jeu3;
	@FXML private Rectangle affichependu;

	
	@FXML private ImageView vueImagePendu;
	
	public ControllerJeu(Stage primaryStage, GestionJeu jeu, GestionOption opt) {
		this.fen = primaryStage;
		this.jeu = jeu;
		this.opt = opt;
	}
	
	@FXML
	public void initialize() {
		opt.appliquerParametresJeu(libelleDifficulte, libelleErreursCommises, libelleMotADeviner);
		afficheurDifficulte.setText("NORMALE");
		
		

		afficheurNombreErreursCommises.setText("0/" + (jeu.getNbMaxErreurs()+1));
		initialiserAffichageMotMystere();
		afficheurMotMystere.setText(messageAfficheurMotMystere.toString());
		initialiserPendu();
		appliquerNombreTentatives();
		appliquerTailleCaracteres();
	}
	
	public void appliquerNombreTentatives() {
		for (int i = 0 ; i <  5 - opt.getNombreTentatives() ; i++) 
			jeu.MAJNbErreurs();
		
		actualiserAfficheurNombreErreursCommises();
	}
	
	public void appliquerTailleCaracteres() {
/*

				opt.appliquerTailleCaractere(boutonLettreA, boutonLettreB, boutonLettreC, boutonLettreD, boutonLettreE, boutonLettreF, boutonLettreG, boutonLettreH, boutonLettreI, boutonLettreJ, boutonLettreK, boutonLettreL, boutonLettreM, boutonLettreN, boutonLettreO, boutonLettreP, boutonLettreQ, boutonLettreR, boutonLettreS, boutonLettreT, boutonLettreU, boutonLettreV, boutonLettreW, boutonLettreX, boutonLettreY, boutonLettreZ);*/
		
		opt.appliquerTaille(libelleDifficulte, libelleErreursCommises, libelleMotADeviner, afficheurMotMystere, afficheurDifficulte, afficheurNombreErreursCommises);
		
		for (int i = 0; i < 26 ; i++)
			opt.appliquerTaille((Button)grilleBoutonsLettres.getChildrenUnmodifiable().get(i));
	}
	
	@FXML
	public void clicRecommencer() throws IOException {
		jeu.InitialiserPartie();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("jeu.fxml"));	
		loader.setController(new ControllerJeu(fen, jeu, opt));
		AnchorPane scene = loader.load();
		fen.setScene(new Scene(scene, 800, 580));
	}
	
	@FXML
	public void clicRetourAccueil() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("accueil.fxml"));
		loader.setController(new ControllerAccueil(fen, jeu, opt));
		fen.setScene(new Scene(loader.load(), 800, 580));
	}
	
	@FXML
	public void clicQuitter() {
		fen.close();
	}
	
	@FXML
	public void clicLettre(ActionEvent a) throws IOException {
		Button boutonLettreChoisie = (Button)a.getSource();		
		char lettreChoisie = boutonLettreChoisie.getText().charAt(0);
		jeu.MemoriserLettreChoisie(lettreChoisie);
		Vector<Integer> pos = new Vector<Integer>();
		
		if (jeu.ChercherLettreDansMot(lettreChoisie, pos) == 0) {
			jeu.MAJNbErreurs();
			actualiserAfficheurNombreErreursCommises();
			boutonLettreChoisie.setDisable(true);
			boutonLettreChoisie.setStyle("-fx-background-color: #ff0000; ");
			
            if (jeu.MaxErreursDepasse()) {
            	changerSurSceneDefaite();
            }    
		}
		else {
			actualiserMessageMotMystere(pos, lettreChoisie);
			boutonLettreChoisie.setDisable(true);
			boutonLettreChoisie.setStyle("-fx-background-color: #00ff00; ");
			
			if (jeu.ToutTrouve()) {
				changerSurSceneVictoire();
			}
		}
	}
	
	public void initialiserAffichageMotMystere() {
		for (int i = 0 ; i < jeu.getMotMystere().length() ; i++) {
			messageAfficheurMotMystere.append('*');
		}
		
	}
	
	public void initialiserPendu() {
		vueImagePendu.setImage(new Image(Paths.get("@../../images/pendu1_erreur0.jpg").toUri().toString()));
	}
	
	public void actualiserMessageMotMystere(Vector<Integer> pos, char caractereTrouve) {
		for (int i : pos) {
			messageAfficheurMotMystere.setCharAt(i, caractereTrouve);
		}
		afficheurMotMystere.setText(messageAfficheurMotMystere.toString());
	}
	
	public void actualiserAfficheurNombreErreursCommises() {
		afficheurNombreErreursCommises.setText(jeu.getNbErreurs() + "/" + (jeu.getNbMaxErreurs()+1));
	}
	
	public void changerSurSceneVictoire() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("JeuWin.fxml"));
		loader.setController(new ControllerFin(fen, jeu, opt, true));	
		fen.setScene(new Scene(loader.load(), 800, 580));
	}
	
	public void changerSurSceneDefaite() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("JeuLose.fxml"));
		loader.setController(new ControllerFin(fen, jeu, opt, false));
		fen.setScene(new Scene(loader.load(), 800, 580));
	}
}

/*		
 * 	@FXML private Button boutonLettreA;
	@FXML private Button boutonLettreB;
	@FXML private Button boutonLettreC;
	@FXML private Button boutonLettreD;
	@FXML private Button boutonLettreE;
	@FXML private Button boutonLettreF;
	@FXML private Button boutonLettreG;
	@FXML private Button boutonLettreH;
	@FXML private Button boutonLettreI;
	@FXML private Button boutonLettreJ;
	@FXML private Button boutonLettreK;
	@FXML private Button boutonLettreL;
	@FXML private Button boutonLettreM;
	@FXML private Button boutonLettreN;
	@FXML private Button boutonLettreO;
	@FXML private Button boutonLettreP;
	@FXML private Button boutonLettreQ;
	@FXML private Button boutonLettreR;
	@FXML private Button boutonLettreS;
	@FXML private Button boutonLettreT;
	@FXML private Button boutonLettreU;
	@FXML private Button boutonLettreV;
	@FXML private Button boutonLettreW;
	@FXML private Button boutonLettreX;
	@FXML private Button boutonLettreY;
	@FXML private Button boutonLettreZ;
	*/
