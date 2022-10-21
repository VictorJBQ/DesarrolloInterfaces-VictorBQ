package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	private Stage primaryStage;
	private BorderPane rootLayout;
	Image imagen= new Image(getClass().getResourceAsStream("cineplanet.jpg"));
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		 try {
	           FXMLLoader loader = new FXMLLoader(Main.class.getResource("menu.fxml"));
	            rootLayout = (BorderPane) loader.load();
				primaryStage.setTitle("CINEPLANET");
				controlladorMain menuController = loader.getController();
				menuController.setRootLayout(rootLayout);
				// Mostramos la escena del BorderPane de la variable rootLayot
				Scene scene = new Scene(rootLayout);
				primaryStage.setResizable(false);
				primaryStage.getIcons().add(imagen);
			        // maximizar la ventana
				primaryStage.setScene(scene);
				primaryStage.show();
	        } catch (IOException e) {
	            //tratar la excepción.
	        }
			
	}
	
	public void mostrarVentanaPrincipal() {
       
   }
	
   
	
	public Stage getPrimaryStage() {
		return primaryStage;
	}
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	public BorderPane getRootLayout() {
		return rootLayout;
	}
	public void setRootLayout(BorderPane rootLayout) {
		this.rootLayout = rootLayout;
	}
	public static void main(String[] args) {
		launch(args);
	}
}
