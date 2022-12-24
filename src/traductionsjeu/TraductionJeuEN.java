package traductionsjeu;

import java.util.HashMap;

public class TraductionJeuEN {
	HashMap<String, String> dictionnaireAccueil = new HashMap<String, String>();
	HashMap<String, String> dictionnaireOptions = new HashMap<String, String>();
	HashMap<String, String> dictionnaireAides = new HashMap<String, String>();
	HashMap<String, String> dictionnaireJeu = new HashMap<String, String>();
	HashMap<String, String> dictionnaireFinVictoire = new HashMap<String, String>();
	HashMap<String, String> dictionnaireFinDefaite = new HashMap<String, String>();
	
	public TraductionJeuEN() {
		dictionnaireAccueil.put("libelleTitre", "Hangout game");
		dictionnaireAccueil.put("libelleSaisieNom", "Enter a name :");
		dictionnaireAccueil.put("boutonCommencer", "Start");
		dictionnaireAccueil.put("boutonAides", "Helps");
		dictionnaireAccueil.put("boutonOptions", "Settings");
		dictionnaireAccueil.put("boutonQuitter", "Quit");
		
		dictionnaireOptions.put("libelleTitre", "Settings");
		dictionnaireOptions.put("libelleDifficulte", "Difficulty");
		dictionnaireOptions.put("libelleLongueurDuMot", "Word length");
		dictionnaireOptions.put("libelleNombreDeTentatives", "number of attempts");
		dictionnaireOptions.put("libelleLangueDuDictionnaire", "dictionary language");
		dictionnaireOptions.put("libelleParametres", "Parameters");
		dictionnaireOptions.put("libelleLangueDuJeu", "Game language");
		dictionnaireOptions.put("libelleChoixImagePendu", "Hangman picture choice");
		dictionnaireOptions.put("libelleTailleDesCaracteres", "Font size");
		dictionnaireOptions.put("libelleModeDaltonien", "Colorbind mode :");
		
		dictionnaireAides.put("titreRegle", "Rules of the game :");
		dictionnaireAides.put("titreContacter", "Contact us :");
		dictionnaireAides.put("but1", "Goal of the game :");
		dictionnaireAides.put("but2", "- find a word by guessing which letters make it up");
		dictionnaireAides.put("but3", "- And avoid making more mistakes made for losing the game");
		dictionnaireAides.put("comment1", "How to do:");
		dictionnaireAides.put("comment2", "- To suggest a letter, press on one of the letters of the alphabet using the mouse by clicking on the left click.");
		dictionnaireAides.put("comment3", "- If the letter turns red, it means that the letter is not part of the word and it will cause a mistake.");
		dictionnaireAides.put("comment4", "- If the letter turns green, then the letter belongs to the requested word.");
		dictionnaireAides.put("comment5", "- In case of technical or understanding problems, please contact the people who created the game with the contact details which are displayed just below.");
		dictionnaireAides.put("contact1", "Address :");
		dictionnaireAides.put("contact2", "E-mail address :");
		dictionnaireAides.put("contact3", "Phone number:");
		
		dictionnaireJeu.put("libelleDifficulte", "Difficulty :");
		dictionnaireJeu.put("libelleErreursCommises", "Mistakes made :");
		dictionnaireJeu.put("libelleMotADeviner", "Word to guess :");
		
		dictionnaireFinVictoire.put("libelleMessagePrincipal", "You have won! Well done!");
		dictionnaireFinVictoire.put("libelleMotADeviner", "It is indeed the word :");
		
		dictionnaireFinDefaite.put("libelleMessagePrincipal", "You lost! Too bad for you !");
		dictionnaireFinDefaite.put("libelleMotADeviner", "You had to guess the word :");
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
