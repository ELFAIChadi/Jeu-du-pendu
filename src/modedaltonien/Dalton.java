package modedaltonien;

import java.util.HashMap;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Dalton {
	HashMap<String, String> daltoAccueil= new HashMap<String , String>();
	HashMap<String, Color> daltoOptions= new HashMap<String, Color>();
	HashMap<String, String> daltoAides= new HashMap<String , String>();
	HashMap<String, String> daltoJeu= new HashMap<String , String>();
	HashMap<String, String> daltoFinVictoire= new HashMap<String , String>();
	HashMap<String, String> daltoFinDefaite= new HashMap<String , String>();
	
	
	public Dalton() {
		daltoAccueil.put("libelleTitre", "-fx-background-color: #FF7F50");                //   new Font.Color("#FF7F50"));
		daltoAccueil.put("boutonCommencer", "-fx-background-color:#DC143C"); 
		daltoAccueil.put("boutonAides", "-fx-background-color:#DC143C");
		daltoAccueil.put("boutonOptions","-fx-background-color:#DC143C");
		daltoAccueil.put("boutonQuitter","-fx-background-color:#A52A2A");
		
		daltoOptions.put("orange_dalt", Color.DARKMAGENTA);
		daltoOptions.put("orange_dalt1", Color.YELLOWGREEN);
		daltoOptions.put("orange_dalt2", Color.YELLOWGREEN);
		daltoOptions.put("orange_dalt3", Color.AQUA);
		daltoOptions.put("orange_dalt4", Color.AQUA);
		
		
		daltoAides.put("dalt_regle1", "-fx-background-color:#9932CC");
		daltoAides.put("dalt_regle2", "-fx-background-color:#9932CC");
		daltoAides.put("dalt_regle3", "-fx-background-color:#FF1493");
		
		daltoJeu.put("jeu1", "-fx-background-color: #FF7F50");
		daltoJeu.put("jeu2", "-fx-background-color: #FF7F50");
		daltoJeu.put("jeu3", "-fx-background-color: #FF7F50");
		daltoJeu.put("jeul_label", "-fx-background-color: #483D8B");
		
		daltoFinVictoire.put("boutonRecommencer", "-fx-background-color: #483D8B");
		daltoFinDefaite.put("boutonRetourAccueil", "-fx-background-color: #483D8B");
		daltoFinDefaite.put("quitter_win", "-fx-background-color: #483D8B");
		
		daltoFinDefaite.put("boutonRecommencer", "-fx-background-color: #483D8B");
		daltoFinDefaite.put("boutonRetourAccueil", "-fx-background-color: #483D8B");
		daltoFinDefaite.put("quitter_win", "-fx-background-color: #483D8B");
	}
	
	public String getCouleurAccueil(String id) {
		return daltoAccueil.get(id);
	}
	
	public Color getCouleurOptions(String id) {
		return daltoOptions.get(id);
	}
	
	public String getCouleurAides(String id) {
		return daltoAides.get(id);
	}
	
	public String getCouleurFinVictoire(String id) {
		return daltoFinVictoire.get(id);
	}
	
	public String getCouleurFinDefaite(String id) {
		return daltoFinDefaite.get(id);
	}
	
}