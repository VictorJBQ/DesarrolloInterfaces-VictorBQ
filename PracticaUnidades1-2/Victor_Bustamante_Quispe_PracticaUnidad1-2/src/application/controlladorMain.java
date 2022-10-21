package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class controlladorMain {
	
	private BorderPane rootLayout;
	private Main main;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void abrirCines(ActionEvent event) {

    }

    @FXML
    void abrirTuto(ActionEvent event) {

    }

    @FXML
    void compraEntrada(ActionEvent event) {
    	try {
			// Cargamos el archivo Controles Dinamicos
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(controlladorMain.class.getResource("/entradas/compEntrada.fxml"));
			BorderPane listadoControles = (BorderPane) loader.load();
			// Se sitúa en el centro del diseño principal
			rootLayout.setCenter(listadoControles);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void entradasHechas(ActionEvent event) {

    }

    @FXML
    void volverInicio(ActionEvent event) throws IOException {
    	 Node source = (Node) event.getSource();
    	    Stage stage = (Stage) source.getScene().getWindow();
    	    FXMLLoader loader = new FXMLLoader(Main.class.getResource("menu.fxml"));
            rootLayout = (BorderPane) loader.load();
			stage.setTitle("CINEPLANET");
			controlladorMain menuController = loader.getController();
			menuController.setRootLayout(rootLayout);
			Scene scene = new Scene(rootLayout);
			stage.setScene(scene);
    	    stage.show();
    }

    @FXML
    void initialize() {

    }

	public BorderPane getRootLayout() {
		return rootLayout;
	}

	public void setRootLayout(BorderPane rootLayout) {
		this.rootLayout = rootLayout;
	}

	

	
    

}
