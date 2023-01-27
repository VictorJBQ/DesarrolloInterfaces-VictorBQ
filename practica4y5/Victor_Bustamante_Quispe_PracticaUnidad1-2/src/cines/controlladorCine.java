package cines;

import java.net.URI;
import java.net.URISyntaxException;
import java.awt.*;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;

public class controlladorCine {


	    @FXML
	    private Hyperlink linkOdeon;

	    @FXML
	    void abrirLink(ActionEvent event) throws IOException, URISyntaxException {
	    	Desktop.getDesktop().browse(new URI("https://odeonmulticines.com/"));
	    	}

	    @FXML
	    void initialize() {

	    }
}
