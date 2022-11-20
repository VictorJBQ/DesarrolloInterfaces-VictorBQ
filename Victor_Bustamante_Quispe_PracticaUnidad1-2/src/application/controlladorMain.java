package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import entradas.entradas;
import javafx.scene.control.Alert;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class controlladorMain implements Initializable{

	int contador=0;
    @FXML
    private MenuItem hechas;
    @FXML
    private ComboBox<String> usu;
    @FXML
    private PasswordField contraseña;
    @FXML
    private TextField usuario;
	private entradas ent;
	public entradas getEnt() {
		return ent;
	}

	public void setEnt(entradas ent) {
		this.ent = ent;
	}

	private BorderPane rootLayout;
	private GridPane gridPane;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @Override
	public void initialize(java.net.URL arg0, ResourceBundle arg1) {
    	if(arg0.toString().contains("Inicio.fxml")) {
    		usu.getItems().addAll("Usuario","Admin");
    		usuario.addEventFilter(KeyEvent.KEY_PRESSED, (e) -> {
					if(e.getCode().toString().equals("BACK_SPACE")&& contador>0) {
						contador--;
						System.out.println(contador+" restaa");
					}else{
						contador++;
					
						System.out.println(contador);
		    			System.out.println("Code: " + e.getCode().getChar() + "-> " );
						
					}
				
		});

    		contraseña.addEventFilter(KeyEvent.KEY_PRESSED, (e) -> {
				if(e.getCode().toString().equals("BACK_SPACE")&& contador>0) {
					contador--;
					System.out.println(contador+" restaa");
				}else{
					contador++;
				
					System.out.println(contador);
	    			System.out.println("Code: " + e.getCode().getChar() + "-> " );
					
				}
			
	});
    		
    	}
	}
    
    @FXML
    void abriPelis(ActionEvent event) {
    	try {
			// Cargamos el archivo Controles Dinamicos
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(controlladorMain.class.getResource("/peliculas/verPelis.fxml"));
			BorderPane listadoControles = (BorderPane) loader.load();
			// Se sitúa en el centro del diseño principal
			rootLayout.setCenter(listadoControles);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    @FXML
    void abrirCines(ActionEvent event) {
    	try {
			// Cargamos el archivo Controles Dinamicos
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(controlladorMain.class.getResource("/cines/verCine.fxml"));
			BorderPane listadoControles = (BorderPane) loader.load();
			// Se sitúa en el centro del diseño principal
			rootLayout.setCenter(listadoControles);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void abrirTuto(ActionEvent event) {
    	try {
			// Cargamos el archivo Controles Dinamicos
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(controlladorMain.class.getResource("/tutorial/vertutorial.fxml"));
			BorderPane listadoControles = (BorderPane) loader.load();
			// Se sitúa en el centro del diseño principal
			rootLayout.setCenter(listadoControles);
		} catch (IOException e) {
			e.printStackTrace();
		}
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
    public void entradasHechas(ActionEvent event) {
    	try {
			// Cargamos el archivo Controles Dinamicos
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(controlladorMain.class.getResource("/entradas/verEntradas.fxml"));
			BorderPane listadoControles = (BorderPane) loader.load();
			// Se sitúa en el centro del diseño principal
			rootLayout.setCenter(listadoControles);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    @FXML 
    void inicioSesion(ActionEvent event)throws IOException{
    	if(usuario.getText().toString().equals("practica") && contraseña.getText().toString().equals("1234")&&usu.getValue()!=null) {
    		volverInicio(event);    		
    	}
    	else {
    		
    		 Alert alert = crearAlert(AlertType.ERROR, "ERROR", "Datos Faltantes o Incorrectos","Usuario o Contraseña Invalidos, no olvide elegir Rol" );
       	  alert.showAndWait();
    	}
    }
    private Alert crearAlert(AlertType type, String title, String header, String contextText) {
       	Alert auxAlert = new Alert(type);
       	auxAlert.setTitle(title);
       	auxAlert.setHeaderText(header);
       	auxAlert.setContentText(contextText);
       	return auxAlert;
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

   

	public GridPane getGridPane() {
		return gridPane;
	}

	public void setGridPane(GridPane gridPane) {
		this.gridPane = gridPane;
	}

	public BorderPane getRootLayout() {
		return rootLayout;
	}

	public void setRootLayout(BorderPane rootLayout) {
		this.rootLayout = rootLayout;
	}

	
	

	
    

}
