package application;

import application.GestionOption.Langue;
import application.GestionOption.LongueurMots;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleGroup;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.util.StringConverter;
//import modedaltonien.Dalton;

public class ControllerOptions {
	private GestionOption opt;
	
	@FXML private Label libelleTitre;
	@FXML private Label libelleDifficulte;
	@FXML private Label libelleLongueurDuMot;
	@FXML private Slider glissiereLongueurMots;
	@FXML private Label libelleNombreDeTentatives;
	@FXML private Slider glissiereNombreTentatives;
	@FXML private Label libelleLangueDuDictionnaire;
	
	ToggleGroup groupeLangueDico = new ToggleGroup();
	
	@FXML RadioButton choixDicoEN;
	@FXML RadioButton choixDicoFR;
	
	@FXML private Label libelleParametres;
	@FXML private Label libelleLangueDuJeu;
	
	ToggleGroup groupeLangueJeu = new ToggleGroup();
	
	@FXML RadioButton choixLangueEN;
	@FXML RadioButton choixLangueFR;
	@FXML RadioButton choixLangueIT;
	
	@FXML private Label libelleChoixImagePendu;
	
	// un truc pour choisir l'image du pendu
	
	@FXML private Label libelleTailleDesCaracteres;
	
	@FXML private Slider glissiereTailleCaracteres;
	
	@FXML private Label previsualisationTailleCaracteres;
	@FXML private Label libelleModeDaltonien;
	
	@FXML private CheckBox caseACocherModeDaltonien;
	
	@FXML private Rectangle orange_dalt;
	@FXML private Rectangle orange_dalt1;
	@FXML private Rectangle orange_dalt2;
	@FXML private Rectangle orange_dalt3;
	@FXML private Rectangle orange_dalt4;
	
	public ControllerOptions(GestionOption opt) {
		this.opt = opt;
	}
	
	@FXML
	public void initialize() {
		initialiserGlissiereLongueurMots();
		initialiserGlissiereNombreTentatives();
		initialiserGlissiereTailleCaracteres();
		initialiserPrevisualisationTailleCaracteres();
		initialiserCaseACocherModeDaltonien();
		initialiserGroupeChoixDico();
		initialiserGroupeChoixLangue();
		
		opt.appliquerParametresOptions(libelleTitre, libelleDifficulte, libelleLongueurDuMot, libelleNombreDeTentatives, libelleLangueDuDictionnaire, libelleParametres, libelleLangueDuJeu, libelleChoixImagePendu, libelleTailleDesCaracteres, libelleModeDaltonien);
		opt.appliquerThemeOptions(orange_dalt, orange_dalt1, orange_dalt2, orange_dalt3, orange_dalt4);
	}
	
	public void initialiserGlissiereLongueurMots() {
		glissiereLongueurMots.setMin(0);
		glissiereLongueurMots.setMax(2);
		glissiereLongueurMots.setMinorTickCount(0);
        glissiereLongueurMots.setMajorTickUnit(1);
        glissiereLongueurMots.setSnapToTicks(true);
        glissiereLongueurMots.setShowTickMarks(true);
        glissiereLongueurMots.setShowTickLabels(true);
        glissiereLongueurMots.setLabelFormatter(new StringConverter<Double>() {
        	
            @Override
            public String toString(Double n) {
                if (n < 0.5)
                	return "Court";
                else if (n < 1.5)
                	return "Moyen";
                else
                	return "Long";
            }

            @Override
            public Double fromString(String s) {
                switch (s) {
                    case "Court":
                        return 0d;
                    case "Moyen":
                        return 1d;
                    default:
                        return 2d;
                }
            }
        });
        
        if (opt.getLongueurMots() == LongueurMots.COURT)
    		glissiereLongueurMots.setValue(0.0);
        else if (opt.getLongueurMots() == LongueurMots.MOYEN)
        	glissiereLongueurMots.setValue(1.0);
        else 
        	glissiereLongueurMots.setValue(2.0);
        	
	}
	
	public void initialiserGlissiereNombreTentatives() {
		glissiereNombreTentatives.setMin(1);
		glissiereNombreTentatives.setMax(5);
		glissiereNombreTentatives.setValue(opt.getNombreTentatives());
		glissiereNombreTentatives.setMinorTickCount(0);
		glissiereNombreTentatives.setMajorTickUnit(1);
        glissiereNombreTentatives.setSnapToTicks(true);
        glissiereNombreTentatives.setShowTickMarks(true);
        glissiereNombreTentatives.setShowTickLabels(true);
	}
	
	public void initialiserGroupeChoixDico() {
		choixDicoEN.setToggleGroup(groupeLangueDico);
		choixDicoFR.setToggleGroup(groupeLangueDico);
		
		if (opt.getLangueDictionnaire() == Langue.ANGLAIS)
			choixDicoEN.setSelected(true);
		else if (opt.getLangueDictionnaire() == Langue.FRANCAIS)
			choixDicoFR.setSelected(true);
	}
	
	public void initialiserGroupeChoixLangue() {
		choixLangueEN.setToggleGroup(groupeLangueJeu);
		choixLangueFR.setToggleGroup(groupeLangueJeu);
		choixLangueIT.setToggleGroup(groupeLangueJeu);
		
		if (opt.getLangueJeu() == Langue.ANGLAIS)
			choixLangueEN.setSelected(true);
		else if (opt.getLangueJeu() == Langue.FRANCAIS)
			choixLangueFR.setSelected(true);
		else if (opt.getLangueJeu() == Langue.ITALIEN)
			choixLangueIT.setSelected(true);
	}
	
	public void initialiserGlissiereTailleCaracteres() {
		glissiereTailleCaracteres.setMin(0.6);
		glissiereTailleCaracteres.setMax(1.2);
		glissiereTailleCaracteres.setValue(opt.getCoefficientTailleCaracteres());
		
		glissiereTailleCaracteres.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> args0, Number arg1, Number arg2) {
				previsualisationTailleCaracteres.setFont(new Font(30 * glissiereTailleCaracteres.getValue()));
			}
		});
	}
	
	public void initialiserPrevisualisationTailleCaracteres() {
		previsualisationTailleCaracteres.setFont(new Font(30 * glissiereTailleCaracteres.getValue()));
	}
	
	public void initialiserCaseACocherModeDaltonien() {
		if (opt.isModeDaltonien()) {
			caseACocherModeDaltonien.setSelected(true);
		}
		else {
			caseACocherModeDaltonien.setSelected(false);
		}
	}
	
	public void enregistrerNouvelleLongueurMots() {
		if (glissiereLongueurMots.getValue() < 0.5)
			opt.setLongueurMots(LongueurMots.COURT);
		else if (glissiereLongueurMots.getValue() < 1.5)
			opt.setLongueurMots(LongueurMots.MOYEN);
		else
			opt.setLongueurMots(LongueurMots.LONG);
	}
	
	public void enregistrerNouveauNombreTentatives() {
		opt.setNombreTentatives((int)glissiereNombreTentatives.getValue());
	}
	
	public void enregistrerChoixLangueDico() {
		if (choixDicoEN.isSelected())
			opt.setLangueDictionnaire(Langue.ANGLAIS);
		else if (choixDicoFR.isSelected())
			opt.setLangueDictionnaire(Langue.FRANCAIS);
	}

	public void enregistrerChoixLangueJeu() {
		if (choixLangueEN.isSelected())
			opt.setLangueJeu(Langue.ANGLAIS);
		else if (choixLangueFR.isSelected())
			opt.setLangueJeu(Langue.FRANCAIS);
		else if (choixLangueIT.isSelected())
			opt.setLangueJeu(Langue.ITALIEN);
	}
	
	public void enregistrerNouvelleTailleCaracteres() {
		opt.setCoefficientTailleCaracteres(glissiereTailleCaracteres.getValue());
	}
	
	public void enregistrerNouveauChoixModeDaltonien() {
		opt.setModeDaltonien(caseACocherModeDaltonien.isSelected());
	}
	
	public void appliquerOptionsPrecedentes() {
		opt.appliquerTaille(libelleTitre);
		opt.appliquerTaille(libelleDifficulte);
		opt.appliquerTaille(libelleLongueurDuMot);
		opt.appliquerTaille(libelleNombreDeTentatives);
		opt.appliquerTaille(libelleLangueDuDictionnaire);
		opt.appliquerTaille(libelleParametres);
		opt.appliquerTaille(libelleLangueDuJeu);
		opt.appliquerTaille(libelleChoixImagePendu);
		opt.appliquerTaille(libelleTailleDesCaracteres);
		opt.appliquerTaille(libelleModeDaltonien);
	}
	
	public GestionOption valeurOK() {
		enregistrerNouvelleLongueurMots();
		enregistrerNouveauNombreTentatives();
		enregistrerNouvelleTailleCaracteres();
		enregistrerNouveauChoixModeDaltonien();
		enregistrerChoixLangueDico();
		enregistrerChoixLangueJeu();
		return opt;
	}
	
	public GestionOption valeurAnnuler() {
		return opt;
	}
	
	public GestionOption valeurDefaut() {
		return new GestionOption();
	}
	
}
