package entradas;


import java.io.IOException;
import java.util.ResourceBundle;

import javax.print.DocFlavor.URL;

import application.controlladorMain;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

public class ControllerEntradas implements Initializable{

	private BorderPane rootLayout;
	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
	
	  @FXML
	    private TextField dni;

	    @FXML
	    private Slider entradas;

	    @FXML
	    private TextField nombre;

	    @FXML
	    private TextField pelicula;
	
	@FXML
    private ChoiceBox<String> choice1;
	  @FXML
	    private TableColumn<entradas, String> dniTabla;

	 @FXML
	    private TableColumn<entradas, String> cineTabla;

	    @FXML
	    private TableColumn<entradas, String> nombreTabla;

	    @FXML
	    private TableColumn<entradas, String> peliculaTabla;

	    @FXML
	    private TableColumn<entradas, Double> precioTabla;
	    @FXML
	    private TableView<entradas> tablaEntradas;

    @FXML
    private ComboBox<String> combo1;
    

   private ObservableList<entradas> datos=FXCollections.observableArrayList(
		   new entradas("345678972D","Juan Garcia","Avatar 2",3.00,"Orcasitas"),
		   new entradas("312324892D","Manuel Serpa","Black Adam",2.00,"Orcasitas"),
		   new entradas("544867892D","Jorge Gonzales","Avengers",5.00,"Tres Cantos"),
		   new entradas("345231292D","Israel Andrade","La vida de Pi",7.00,"Vallecas")
		   
		   );
   @Override
	public void initialize(java.net.URL arg0, ResourceBundle arg1) {
		
   	if(arg0.toString().contains("verEntradas.fxml")) {
   	dniTabla.setCellValueFactory(new PropertyValueFactory<entradas, String>("dni"));
   	nombreTabla.setCellValueFactory(new PropertyValueFactory<entradas, String>("nombre"));
   	cineTabla.setCellValueFactory(new PropertyValueFactory<entradas, String>("cine"));
   	peliculaTabla.setCellValueFactory(new PropertyValueFactory<entradas, String>("pelicula"));
   	precioTabla.setCellValueFactory(new PropertyValueFactory<entradas, Double>("Total"));
   
   	
   	tablaEntradas.setItems(datos);}
   	else {
   		combo1.getItems().addAll("Orcasitas", "Tres Cantos", "Vallecas","Callao","Torrejón");
   	}
 
		
	}
   @FXML
   void generarEntrada(ActionEvent event) {
	  
   }
   
   
    	
    
	

}
