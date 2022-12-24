package traductionsjeu;

import java.util.HashMap;

public class TraductionJeuFR {
	HashMap<String, String> dictionnaireAccueil = new HashMap<String, String>();
	HashMap<String, String> dictionnaireOptions = new HashMap<String, String>();
	HashMap<String, String> dictionnaireAides = new HashMap<String, String>();
	HashMap<String, String> dictionnaireJeu = new HashMap<String, String>();
	HashMap<String, String> dictionnaireFinVictoire = new HashMap<String, String>();
	HashMap<String, String> dictionnaireFinDefaite = new HashMap<String, String>();
	
	public TraductionJeuFR() {
		dictionnaireAccueil.put("libelleTitre", "Jeu du pendu");
		dictionnaireAccueil.put("libelleSaisieNom", "Saisir un nom :");
		dictionnaireAccueil.put("boutonCommencer", "Commencer une partie");
		dictionnaireAccueil.put("boutonAides", "Aides");
		dictionnaireAccueil.put("boutonOptions", "Options");
		dictionnaireAccueil.put("boutonQuitter", "Quitter");
		
		dictionnaireOptions.put("libelleTitre", "Options");
		dictionnaireOptions.put("libelleDifficulte", "Difficulté");
		dictionnaireOptions.put("libelleLongueurDuMot", "Longueur du mot");
		dictionnaireOptions.put("libelleNombreDeTentatives", "Nombre de tentative");
		dictionnaireOptions.put("libelleLangueDuDictionnaire", "Langue du dictionnaire");
		dictionnaireOptions.put("libelleParametres", "Parametres");
		dictionnaireOptions.put("libelleLangueDuJeu", "Langue du jeu");
		dictionnaireOptions.put("libelleChoixImagePendu", "Choix image pendu");
		dictionnaireOptions.put("libelleTailleDesCaracteres", "Taille des caracteres");
		dictionnaireOptions.put("libelleModeDaltonien", "Mode daltonien :");
		
		dictionnaireAides.put("titreRegle", "Règles du Jeu :");
		dictionnaireAides.put("titreContacter", "Nous contacter :");
		dictionnaireAides.put("but1", "But du jeu :");
		dictionnaireAides.put("but2", "- trouver un mot en devinant quelles sont les lettres qui le composent");
		dictionnaireAides.put("but3", "- Et eviter de faire plus d’erreur commises pour avoir perdu la partie");
		dictionnaireAides.put("comment1", "Comment faire:");
		dictionnaireAides.put("comment2", "- Pour proposer une lettre, appuyer sur une des lettres de l’alphabet à l’aide de la souris en cliquant sur le clic gauche.");
		dictionnaireAides.put("comment3", "- Si la lettre devient rouge, cela veux dire que la lettre ne fait pas partie du mot et cela provoquera une faute.");
		dictionnaireAides.put("comment4", "- Si la lettre devient verte, alors le lettre appartient bien au mot demandé.");
		dictionnaireAides.put("comment5", "- En cas de problèmes techniques ou de compréhension, merci de constacter les personnes qui ont crée le jeu avec les coordonnées qui sont affiché juste en dessous.");
		dictionnaireAides.put("contact1", "Adresse :");
		dictionnaireAides.put("contact2", "Adresse Email :");
		dictionnaireAides.put("contact3", "Numero de Téléphone:");
		
		dictionnaireJeu.put("libelleDifficulte", "Difficulte :");
		dictionnaireJeu.put("libelleErreursCommises", "Erreurs commises :");
		dictionnaireJeu.put("libelleMotADeviner", "Mot a deviner :");
		
		dictionnaireFinVictoire.put("libelleMessagePrincipal", "Vous avez gagner! Bravo à toi!");
		dictionnaireFinVictoire.put("libelleMotADeviner", "Il s'agit bien du mot :");
		
		dictionnaireFinDefaite.put("libelleMessagePrincipal", "Vous avez perdu! Dommage pour toi !");
		dictionnaireFinDefaite.put("libelleMotADeviner", "Il fallait deviner le mot :");
	}
	
	public String getTraductionAccueil(String id) {
		return dictionnaireAccueil.get(id);
	}
	
	public String getTraductionOptions(String id) {
		return dictionnaireOptions.get(id);
	}
	
	public String getTraductionAides(String id) {
		return dictionnaireAides.get(id);
	}
	
	public String getTraductionJeu(String id) {
		return dictionnaireJeu.get(id);
	}
	
	public String getTraductionFinVictoire(String id) {
		return dictionnaireFinVictoire.get(id);
	}
	
	public String getTraductionFinDefaite(String id) {
		return dictionnaireFinDefaite.get(id);
	}

}
