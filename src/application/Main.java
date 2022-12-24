package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class Main extends Application {
	private GestionJeu jeu;
	private GestionOption opt;
	
	@Override
	public void init() {
		try {
			jeu = new GestionJeu(getClass().getResource("Dico.txt").getFile());
			opt = new GestionOption();
		} catch (Exception e) {}
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("accueil.fxml"));
			loader.setController(new ControllerAccueil(primaryStage, jeu, opt));
			Scene scene = new Scene(loader.load(),800,580);
			//scene.getStylesheets().add(getClass().getResource("themeAnglaisAccueil.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

/*
public class Main extends Application {
@Override
public void start(Stage primaryStage) {
	try {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("accueil.fxml"));
		ControllerAccueil controllerAccueil = new ControllerAccueil(primaryStage);
		loader.setController(controllerAccueil);
		
		AnchorPane root = loader.load();
		Scene scene = new Scene(root,800,580);
	
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	} catch(Exception e) {
		e.printStackTrace();
	}
}

public static void main(String[] args) {
	launch(args);
}
*/