package application;

import javafx.scene.Node;
import javafx.scene.control.Labeled;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import modedaltonien.Dalton;
import traductionsjeu.TraductionJeuEN;
import traductionsjeu.TraductionJeuFR;
import traductionsjeu.TraductionJeuIT;

public class GestionOption {
	public enum LongueurMots { COURT, MOYEN, LONG };
	public enum Langue { FRANCAIS, ANGLAIS, ITALIEN };
	
	private LongueurMots longueurMots = LongueurMots.MOYEN;
	private int nombreTentatives = 5;
	private Langue langueDictionnaire = Langue.FRANCAIS;
	private Langue langueJeu = Langue.FRANCAIS;
	private double coefficientTailleCaracteres = 1.0;
	private boolean modeDaltonien = false;
	
	private TraductionJeuFR traductionJeuFR = new TraductionJeuFR();
	private TraductionJeuEN traductionJeuEN = new TraductionJeuEN();
	private TraductionJeuIT traductionJeuIT = new TraductionJeuIT();
	private Dalton dalton = new Dalton();
	
	public GestionOption() {}
	
	public GestionOption(GestionOption opt) {
		this.longueurMots = opt.longueurMots;
		this.nombreTentatives = opt.nombreTentatives;
		this.langueDictionnaire = opt.langueDictionnaire;
		this.langueJeu = opt.langueJeu;
		this.coefficientTailleCaracteres = opt.coefficientTailleCaracteres;
	}
	
	public LongueurMots getLongueurMots() {
		return longueurMots;
	}
	
	public int getNombreTentatives() {
		return nombreTentatives;
	}
	
	public Langue getLangueJeu() {
		return langueJeu;
	}
	
	public double getCoefficientTailleCaracteres() {
		return coefficientTailleCaracteres;
	}

	public Langue getLangueDictionnaire() {
		return langueDictionnaire;
	}

	public void setLangueDictionnaire(Langue langueDictionnaire) {
		this.langueDictionnaire = langueDictionnaire;
	}

	public boolean isModeDaltonien() {
		return modeDaltonien;
	}

	public void setModeDaltonien(boolean modeDaltonien) {
		this.modeDaltonien = modeDaltonien;
	}

	public void setLongueurMots(LongueurMots longueurMots) {
		this.longueurMots = longueurMots;
	}

	public void setNombreTentatives(int nombreTentatives) {
		this.nombreTentatives = nombreTentatives;
	}

	public void setLangueJeu(Langue langueJeu) {
		this.langueJeu = langueJeu;
	}

	public void setCoefficientTailleCaracteres(double coefficientTailleCaracteres) {
		this.coefficientTailleCaracteres = coefficientTailleCaracteres;
	}
	
	public Image getImagePendu0Erreur() {
		return null;
	}
	
	public String getThemeSceneAccueil() {
		
		return null;
	}
	
	public void appliquerParametresAccueil(Labeled element) {	
		appliquerTaille(element);
		appliquerThemeAccueil(element);
		switch (langueJeu) {
			case FRANCAIS:
				element.setText(traductionJeuFR.getTraductionAccueil(element.getId()));
				break;
			case ANGLAIS:
				element.setText(traductionJeuEN.getTraductionAccueil(element.getId()));
				break;
			case ITALIEN:
				element.setText(traductionJeuIT.getTraductionAccueil(element.getId()));
				break;
		}
	}
	
	public void appliquerParametresAccueil(Labeled... elements) {
		for (Labeled i : elements) {
			appliquerParametresAccueil(i);
		}
	}
	
	public void appliquerParametresOptions(Labeled element) {	
		appliquerTaille(element);
		switch (langueJeu) {
			case FRANCAIS:
				element.setText(traductionJeuFR.getTraductionOptions(element.getId()));
				break;
			case ANGLAIS:
				element.setText(traductionJeuEN.getTraductionOptions(element.getId()));
				break;
			case ITALIEN:
				element.setText(traductionJeuIT.getTraductionOptions(element.getId()));
				break;
		}
	}
		
	public void appliquerParametresOptions(Labeled... elements) {
		for (Labeled i : elements) {
			appliquerParametresOptions(i);
		}
	}
	
	public void appliquerParametresAides(Labeled element) {	
		appliquerTaille(element);
		switch (langueJeu) {
			case FRANCAIS:
				element.setText(traductionJeuFR.getTraductionAides(element.getId()));
				break;
			case ANGLAIS:
				element.setText(traductionJeuEN.getTraductionAides(element.getId()));
				break;
			case ITALIEN:
				element.setText(traductionJeuIT.getTraductionAides(element.getId()));
				break;
		}
	}
		
	public void appliquerParametresAides(Labeled... elements) {
		for (Labeled i : elements) {
			appliquerParametresAides(i);
		}
	}
	
	public void appliquerParametresJeu(Labeled element) {	
		appliquerTaille(element);
		switch (langueJeu) {
			case FRANCAIS:
				element.setText(traductionJeuFR.getTraductionJeu(element.getId()));
				break;
			case ANGLAIS:
				element.setText(traductionJeuEN.getTraductionJeu(element.getId()));
				break;
			case ITALIEN:
				element.setText(traductionJeuIT.getTraductionJeu(element.getId()));
				break;
		}
	}
		
	public void appliquerParametresJeu(Labeled... elements) {
		for (Labeled i : elements) {
			appliquerParametresJeu(i);
		}
	}
	
	public void appliquerParametresFinVictoire(Labeled element) {	
		appliquerTaille(element);
		switch (langueJeu) {
			case FRANCAIS:
				element.setText(traductionJeuFR.getTraductionFinVictoire(element.getId()));
				break;
			case ANGLAIS:
				element.setText(traductionJeuEN.getTraductionFinVictoire(element.getId()));
				break;
			case ITALIEN:
				element.setText(traductionJeuIT.getTraductionFinVictoire(element.getId()));
				break;
		}
	}
	
	
	public void appliquerParametresFinVictoire(Labeled... elements) {
		for (Labeled i : elements) {
			appliquerParametresFinVictoire(i);
		}
	}
	
	public void appliquerParametresFinDefaite(Labeled element) {	
		appliquerTaille(element);
		switch (langueJeu) {
			case FRANCAIS:
				element.setText(traductionJeuFR.getTraductionFinDefaite(element.getId()));
				break;
			case ANGLAIS:
				element.setText(traductionJeuEN.getTraductionFinDefaite(element.getId()));
				break;
			case ITALIEN:
				element.setText(traductionJeuIT.getTraductionFinDefaite(element.getId()));
				break;
		}
	}
	
	public void appliquerParametresFinDefaite(Labeled... elements) {
		for (Labeled i : elements) {
			appliquerParametresFinDefaite(i);
		}
	}
	
	public void appliquerTaille(Labeled l) {
		l.setFont(new Font(l.getFont().getSize() * getCoefficientTailleCaracteres()));
	}
	
	public void appliquerTaille(Labeled... l) {
		for (Labeled i : l) {
			appliquerTaille(i);
		}
	}
	
	public void appliquerThemeAccueil(Node noeud) {
		if (modeDaltonien)
			noeud.setStyle(dalton.getCouleurAccueil(noeud.getId()));
	}
	
	public void appliquerThemeAccueil(Node...nodes) {
		for (Node i : nodes)
			appliquerThemeAccueil(i);
	}
	
	public void appliquerThemeOptions(Rectangle noeud) {
		if (modeDaltonien)
			noeud.setFill(dalton.getCouleurOptions(noeud.getId()));
	}
	
	public void appliquerThemeOptions(Rectangle... nodes) {
		for (Rectangle i : nodes)
			appliquerThemeOptions(i);
	}
	
	public void appliquerThemeJeu(Rectangle noeud) {
		if (modeDaltonien)
			noeud.setFill(dalton.getCouleurOptions(noeud.getId()));
	}
	
	public void appliquerThemeJeu(Rectangle... nodes) {
		for (Rectangle i : nodes)
			appliquerThemeJeu(i);
	}
}
