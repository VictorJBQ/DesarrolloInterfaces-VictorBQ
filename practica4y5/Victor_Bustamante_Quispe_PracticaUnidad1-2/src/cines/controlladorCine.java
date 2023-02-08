package cines;

import java.net.URI;
import java.net.URISyntaxException;
import java.awt.*;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
/**
 * Clase controlladorCine se encarga de abrir el link de esa pagina
 * @author 34672
 *@version 1.0
 */
public class controlladorCine {

	    @FXML
	    private Hyperlink linkOdeon;
/**
 * Metodo para abrir link 
 * @param event
 * @throws IOException
 * @throws URISyntaxException
 */
	    @FXML
	    void abrirLink(ActionEvent event) throws IOException, URISyntaxException {
	    	Desktop.getDesktop().browse(new URI("https://odeonmulticines.com/"));
	    	}

	    @FXML
	    void initialize() {

	    }
}
