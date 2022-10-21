package entradas;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.control.cell.TextFieldTreeCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ControllerEntradas {
	
	private final Node rootIcon = new ImageView(
		       new Image(getClass().getResourceAsStream("icon1.JPG")));
	
	@FXML
    private ChoiceBox<String> choice1;
    @FXML
    private ListView<String> listView1;


    @FXML
    private ComboBox<String> combo1;
    

    @FXML
    private TreeView<String> tree;
    @FXML
    private void initialize() {
    	
    
    	//ComboBox
     	 combo1.getItems().addAll("Orcasitas", "Vallecas", "Tres Cantos");
    	
    	
     	//ListView con ComboBox dentro
    	
    	
   
    }

}
