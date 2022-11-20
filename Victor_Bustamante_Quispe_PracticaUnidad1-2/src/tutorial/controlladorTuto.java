package tutorial;


import java.security.Identity;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.control.cell.TextFieldTreeCell;

public class controlladorTuto {
	
	
	@FXML
	private Button botonValorar;
    @FXML
    private ListView<String> listView1;
    @FXML
    private TreeView<String> TreeBarraTareas;
    @FXML
    void initialize() {
    	TreeItem<String> rootItemBarra = new TreeItem<String>("Funcionalidad Botones");
   	 TreeItem<String> ini = new TreeItem<String>("INICIO");
   	 TreeItem<String> cine = new TreeItem<String>("CINE");
   	 TreeItem<String> peli = new TreeItem<String>("PELICULAS");
   	 TreeItem<String> entrada = new TreeItem<String>("ENTRADAS");
   	 TreeItem<String> tuto = new TreeItem<String>("TUTORIAL");
   	 ini.getChildren().add(new TreeItem<String>("El Boton INICIO nos vuelve a carga el stage \n mandandonos desde cualquier escena \n a la escena principal"));
   	 cine.getChildren().add(new TreeItem<String>("El Boton CINES nos carga la escena cine "));
 	 peli.getChildren().add(new TreeItem<String>("El Boton PELICULAS nos carga la escena \n de las peliculas "));
 	 entrada.getChildren().add(new TreeItem<String>("El MenuButton ENTRADAS nos despliega \n dos opciones Comprar Entradas o Ver entradas "));
 	 tuto.getChildren().add(new TreeItem<String>("El Boton TUTORIAL nos carga la escena \n tutorial donde aparece el uso de la \n aplicacion y un apartador valoracion \n donde pueden dejar su valoracion "));
   	 rootItemBarra.getChildren().add(ini);
   	rootItemBarra.getChildren().add(cine);
   	rootItemBarra.getChildren().add(peli);
   	rootItemBarra.getChildren().add(entrada);
   	rootItemBarra.getChildren().add(tuto);
   	TreeBarraTareas.setCellFactory(TextFieldTreeCell.forTreeView());
   	rootItemBarra.setExpanded(true); 
        TreeBarraTareas.setRoot(rootItemBarra); 
        
        
        ObservableList<String> list = FXCollections.observableArrayList();
    	listView1.setEditable(true);
    	
    	list.addAll("Muy Satisfecho","Satisfecho","Insatisfecho","Muy Insatisfecho");
    	
    		listView1.getItems().addAll("Inicio");
    		listView1.getItems().addAll("Cines");
    		listView1.getItems().addAll("Pelicula");
    		listView1.getItems().addAll("Entradas");
    		listView1.getItems().addAll("Tutorial");
    	

    	//creamos comboBox por cada celda de listView
    	listView1.setCellFactory(ComboBoxListCell.forListView(list));
    }
    
    @FXML
    void valorar(ActionEvent event) {
    	
    	 Alert alert = crearAlert(AlertType.CONFIRMATION, "EXITO", "Valoraci�n Enviada con Exito","Gracias por enviar su valoraci�n" );
      	  alert.showAndWait();

    		
    	
    	
    }
    private Alert crearAlert(AlertType type, String title, String header, String contextText) {
       	Alert auxAlert = new Alert(type);
       	auxAlert.setTitle(title);
       	auxAlert.setHeaderText(header);
       	auxAlert.setContentText(contextText);
       	return auxAlert;
       }

}
