package traductionsjeu;

import java.util.HashMap;

public class TraductionJeuIT {
	
	HashMap<String, String> dictionnaireAccueil = new HashMap<String, String>();
	HashMap<String, String> dictionnaireOptions = new HashMap<String, String>();
	HashMap<String, String> dictionnaireAides = new HashMap<String, String>();
	HashMap<String, String> dictionnaireJeu = new HashMap<String, String>();
	HashMap<String, String> dictionnaireFinVictoire = new HashMap<String, String>();
	HashMap<String, String> dictionnaireFinDefaite = new HashMap<String, String>();
	
	public TraductionJeuIT() {
		dictionnaireAccueil.put("libelleTitre", "Gioco dell'impiccato");
		dictionnaireAccueil.put("libelleSaisieNom", "Inserisci un nome :");
		dictionnaireAccueil.put("boutonCommencer", "Inizia un gioco");
		dictionnaireAccueil.put("boutonAides", "Aiuto");
		dictionnaireAccueil.put("boutonOptions", "Opzioni");
		dictionnaireAccueil.put("boutonQuitter", "Uscire");
		
		dictionnaireOptions.put("libelleTitre", "Uscire");
		dictionnaireOptions.put("libelleDifficulte", "difficoltà");
		dictionnaireOptions.put("libelleLongueurDuMot", "Lunghezza della parola");
		dictionnaireOptions.put("libelleNombreDeTentatives", "Numero di tentativi");
		dictionnaireOptions.put("libelleLangueDuDictionnaire", "Lingua del dizionario");
		dictionnaireOptions.put("libelleParametres", "Impostazioni");
		dictionnaireOptions.put("libelleLangueDuJeu", "Linguaggio di gioco");
		dictionnaireOptions.put("libelleChoixImagePendu", "Immagini scelte appese");
		dictionnaireOptions.put("libelleTailleDesCaracteres", "Dimensione del carattere");
		dictionnaireOptions.put("libelleModeDaltonien", "Modalità daltonici :");
		
		dictionnaireAides.put("titreRegle", "Le regole del gioco :");
		dictionnaireAides.put("titreContacter", "Contattaci :");
		dictionnaireAides.put("but1", "Obiettivo del gioco :");
		dictionnaireAides.put("but2", "- trova una parola indovinando quali lettere la compongono");
		dictionnaireAides.put("but3", "- Ed evita di commettere più errori per aver perso la partita");
		dictionnaireAides.put("comment1", "Come fare:");
		dictionnaireAides.put("comment2", "- Per suggerire una lettera, premere su una delle lettere dell'alfabeto utilizzando il mouse facendo clic con il tasto sinistro.");
		dictionnaireAides.put("comment3", "- Se la lettera diventa rossa, significa che la lettera non fa parte della parola e questo causerà un errore.");
		dictionnaireAides.put("comment4", "- Se la lettera diventa verde, allora la lettera appartiene alla parola richiesta.");
		dictionnaireAides.put("comment5", "- In caso di problemi tecnici o di comprensione, contatta le persone che hanno creato il gioco con i dettagli di contatto che vengono visualizzati appena sotto.");
		dictionnaireAides.put("contact1", "Indirizzo :");
		dictionnaireAides.put("contact2", "Indirizzo e-mail :");
		dictionnaireAides.put("contact3", "Numero di telefono:");
		
		dictionnaireJeu.put("libelleDifficulte", "Difficoltà :");
		dictionnaireJeu.put("libelleErreursCommises", "Errori commessi :");
		dictionnaireJeu.put("libelleMotADeviner", "Parola da indovinare :");
		
		dictionnaireFinVictoire.put("libelleMessagePrincipal", "Hai vinto! Saluti a te!");
		dictionnaireFinVictoire.put("libelleMotADeviner", "È davvero la parola :");
		
		dictionnaireFinDefaite.put("libelleMessagePrincipal", "Hai perso! Peggio per te!");
		dictionnaireFinDefaite.put("libelleMotADeviner", "Doveva indovinare la parola :");
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
