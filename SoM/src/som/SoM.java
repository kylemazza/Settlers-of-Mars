/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package som;

import devCards.Knight;
import devCards.VictoryPoint;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;
import progressCards.Monopoly;
import progressCards.RoadBuilding;
import progressCards.YearOfPlenty;

/**
 *
 * @author makogenq
 */
public class SoM extends Application {

	// static MediaPlayer mediaPlayer;
	// MediaView mediaView;
	// Connect to Online
	static ObjectClient client;

	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("TitleScreen.fxml"));

		ResourceBank resourceBank = new ResourceBank();
		resourceBank.printResourceList();
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("som.css").toExternalForm());

		stage.setTitle("Settlers of Mars");
		stage.setScene(scene);

		Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
		stage.setX((primaryScreenBounds.getWidth() - stage.getWidth()) / 2);
		stage.setY((primaryScreenBounds.getHeight() - stage.getHeight()) / 2);

		stage.getIcons().add(new Image(getClass().getResourceAsStream("graphics/som-icon.png")));

		stage.setResizable(false);
		stage.show();

		// MediaClass mediaClass = new MediaClass();

	}

	/**
	 * @param args
	 *            the command line arguments
	 */

	public static void main(String[] args) {
		launch(args);

	}

	// Test comment

	// public static void playMusic1() {
	// // aMusic1.setCycleCount(AudioClip.INDEFINITE);
	// // aMusic1.play();
	//
	// mediaPlayer.setCycleCount(AudioClip.INDEFINITE);
	// mediaPlayer.play();
	// }
	//
	// public static void playMusic2() {
	// // aMusic2.setCycleCount(AudioClip.INDEFINITE);
	// // aMusic2.play();
	//
	// mediaPlayer.setCycleCount(AudioClip.INDEFINITE);
	// mediaPlayer.play();
	// }

	/*
	 * public AudioClip getaMusic1() { return aMusic1; }
	 * 
	 * public AudioClip getaMusic2() { return aMusic2; }
	 */

	public void TestDeck() {
		Knight k = new Knight();
		VictoryPoint vp = new VictoryPoint();
		YearOfPlenty yop = new YearOfPlenty();
		Monopoly mp = new Monopoly();
		RoadBuilding rb = new RoadBuilding();
		DevelopmentDeck d = new DevelopmentDeck();

		d.addCard(k);
		d.addCard(vp);
		// d.addCard(yop);
		// d.addCard(mp);
		d.addCard(rb);
		while (!d.isEmpty()) {
			DevelopmentCard card = d.drawCard();
			System.out.println(card);
			if (card instanceof RoadBuilding)
				card.playCard();
		}
	}

}