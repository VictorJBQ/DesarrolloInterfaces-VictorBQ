package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;


public class Main extends Application {
	private Stage primaryStage;
	private GridPane rootLayout;
	Image imagen= new Image(getClass().getResourceAsStream("cineplanet.jpg"));
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		 try {
	           FXMLLoader loader = new FXMLLoader(Main.class.getResource("Inicio.fxml"));
	            rootLayout = (GridPane) loader.load();
				primaryStage.setTitle("CINEPLANET");
				controlladorMain menuController = loader.getController();
				menuController.setGridPane(rootLayout);
				// Mostramos la escena del BorderPane de la variable rootLayot
				Scene scene = new Scene(rootLayout);
				scene.getStylesheets().add(this.getClass().getResource("/application/estilologin.css").toExternalForm());
				primaryStage.setResizable(false);
				primaryStage.getIcons().add(imagen);
				scene.setOnMouseClicked(
				        new EventHandler<MouseEvent>() {

				            @Override
				            public void handle(MouseEvent event) {
				           System.out.println(event.getPickResult());
				            }
				          });
			        // maximizar la ventana
				primaryStage.setScene(scene);
				primaryStage.show();
	        } catch (IOException e) {
	            //tratar la excepción.
	        	e.printStackTrace();
	        }
			
	}
	
   
	
	public Stage getPrimaryStage() {
		return primaryStage;
	}
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
