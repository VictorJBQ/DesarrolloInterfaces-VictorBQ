package entradas;


import java.io.IOException;
import java.util.EventObject;
import java.util.ResourceBundle;

import javax.print.DocFlavor.URL;

import application.controlladorMain;
import javafx.stage.Stage;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;

public class ControllerEntradas implements Initializable{

	private BorderPane rootLayout;
	  @FXML
	    private Button botonCompra;
	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;    
    @FXML
    private TextField filtroCliente;
	
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
    private int contador=0;
    
private static ObservableList<entradas> filtropersonas=FXCollections.observableArrayList();
   private static ObservableList<entradas> datos=FXCollections.observableArrayList(
		   new entradas("345678972D","Juan Garcia","Avatar 2",3.00,"Orcasitas"),
		   new entradas("312324892D","Manuel Serpa","Black Adam",2.00,"Orcasitas"),
		   new entradas("544867892D","Jorge Gonzales","Avengers",5.00,"Tres Cantos"),
		   new entradas("345231292D","Israel Andrade","La vida de Pi",7.00,"Vallecas")
		   
		   );
   
  

public ObservableList<entradas> getDatos() {
	return datos;
}

public void setDatos(ObservableList<entradas> datos) {
	this.datos = datos;
}

private Alert crearAlert(AlertType type, String title, String header, String contextText) {
   	Alert auxAlert = new Alert(type);
   	
   	auxAlert.setTitle(title);
   	auxAlert.setHeaderText(header);
   	auxAlert.setContentText(contextText);
   	
   	return auxAlert;
   }
   
   @Override
	public void initialize(java.net.URL arg0, ResourceBundle arg1) {
		
   	if(arg0.toString().contains("verEntradas.fxml")) {
   	dniTabla.setCellValueFactory(new PropertyValueFactory<entradas, String>("dni"));
   	nombreTabla.setCellValueFactory(new PropertyValueFactory<entradas, String>("nombre"));
   	cineTabla.setCellValueFactory(new PropertyValueFactory<entradas, String>("cine"));
   	peliculaTabla.setCellValueFactory(new PropertyValueFactory<entradas, String>("pelicula"));
   	precioTabla.setCellValueFactory(new PropertyValueFactory<entradas, Double>("Total"));
   
   	tablaEntradas.setItems(getDatos());
   	filtroCliente.addEventFilter(KeyEvent.KEY_PRESSED, (e) -> {
		if(e.getCode().toString().equals("BACK_SPACE")&& contador>0) {
			contador--;
			System.out.println(contador+" restaa");
		}else{
			
			contador++;
		
			System.out.println(contador);
			System.out.println("Code: " + e.getCode().getChar() + "-> " );
			
		}
	
});
tablaEntradas.getSelectionModel().getSelectedItems().addListener((Observable obs)->{
	System.out.println(obs);
	
});
   	
   	
   	}
   	else {
   	 Alert info = crearAlert(AlertType.INFORMATION, "CINEPLANET",
    			"Compra Realizada", "Compra ha sido Realizada para la pelicula "+pelicula.getText().trim());
   		botonCompra.setOnAction(e -> {
   		 	String dnie= dni.getText();
   	  		String nom =  nombre.getText();
   	  		String peli =  pelicula.getText();
   	  		Double entra =  entradas.getValue();
   	  		String cin =  combo1.getValue().toString();
   	  		entradas entrad = new entradas(dnie,nom,peli,entra,cin);
   	  		datos.add(entrad);
   	  		setDatos(datos);
   	  		//blaEntradas.refresh();
    		info.showAndWait();
    		
        });
   	 dni.addEventHandler(KeyEvent.KEY_TYPED, (event) -> {
 		int numberCode = (int) event.getCharacter().charAt(0);
 		
 		if (((numberCode < 65) || (numberCode > 90)) && Character.isLowerCase(event.getCharacter().charAt(0))) {
 			event.consume();
 			Alert alert= crearAlert(AlertType.ERROR, "Error", "Solo números y letras mayusculas", "Asegurate de que sean solo numeros y letras");
 			alert.showAndWait();
 		}
 		});
 	 
   		
   		combo1.getItems().addAll("Orcasitas", "Tres Cantos", "Vallecas","Callao","Torrejón");
   		
   		dni.addEventFilter(KeyEvent.KEY_TYPED, (e) -> {								
			System.out.print("Code: " + e.getCode().getChar() + "-> " +  e.getCode().getCode());
			System.out.println(" Text: " + e.getText());
			
			
		});
   	}
 
		
	}

   @FXML
   void buscarCliente(ActionEvent event) {
	   String filtroNom =  filtroCliente.getText();
	   if(filtroNom.isEmpty()) {
		  this.tablaEntradas.setItems(getDatos());
	   }
	   else {
		   filtropersonas.clear();
		   for(entradas p : getDatos()) {
			   if(p.getDni().toLowerCase().equals(filtroNom.toLowerCase())) {
				   filtropersonas.add(p);
			   }
		   }
		   if(filtropersonas.isEmpty()) {

				  Alert alert = crearAlert(AlertType.ERROR, "ERROR", "Cliente no encontrado", "No se encuentra :"+filtroCliente.getText());
		  		alert.showAndWait();
		   }
		   tablaEntradas.setItems(filtropersonas);
	   }
   }
   
   
    	
    
	

}
