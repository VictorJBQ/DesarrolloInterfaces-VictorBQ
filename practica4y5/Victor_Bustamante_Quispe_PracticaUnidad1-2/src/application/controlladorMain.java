package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import entradas.entradas;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class controlladorMain implements Initializable{
	   @FXML
	    private Label contrasenia;
	int contador=0;    
	@FXML
    private ImageView cineplan;
    @FXML
    private MenuItem hechas;
    @FXML
    private ComboBox<String> usu;
    @FXML
    private PasswordField contraseña;
    @FXML
    private CheckBox dragModeActiveProperty;
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
    	else if(arg0.toString().contains("menu.fxml")){
    		makeDraggable(cineplan);
    	}
	}
    
    @FXML
    void abriPelis(ActionEvent event) {
    	try {
			// Cargamos el archivo Controles Dinamicos
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(controlladorMain.class.getResource("/peliculas/verPelis.fxml"));
			BorderPane listadoControles = (BorderPane) loader.load();
			listadoControles.getStylesheets().add(this.getClass().getResource("/peliculas/estiloPelis.css").toExternalForm());
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
			listadoControles.getStylesheets().add(this.getClass().getResource("/cines/estiloCines.css").toExternalForm());
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

			listadoControles.getStylesheets().add(this.getClass().getResource("/tutorial/estilostutorial.css").toExternalForm());
			// Se sitúa en el centro del diseño principal
			rootLayout.setCenter(listadoControles);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void compraEntrada(ActionEvent event) {
    	try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(controlladorMain.class.getResource("/entradas/compEntrada.fxml"));
			BorderPane listadoControles = (BorderPane) loader.load();
			listadoControles.getStylesheets().add(this.getClass().getResource("/entradas/estiloCompraEntrada.css").toExternalForm());
			// Se sitúa en el centro del diseño principal
			rootLayout.setCenter(listadoControles);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    @FXML
    void abrirEstadistica(ActionEvent event) {
    	try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(controlladorMain.class.getResource("/entradas/GraficoEntradas.fxml"));
			TabPane listadoControles = (TabPane) loader.load();
			listadoControles.getStylesheets().add(this.getClass().getResource("/entradas/EstilosGraficos.css").toExternalForm());
			// Se sitúa en el centro del diseño principal
			rootLayout.setCenter(listadoControles);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    @FXML
    public void entradasHechas(ActionEvent event) {
    	try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(controlladorMain.class.getResource("/entradas/verEntradas.fxml"));
			BorderPane listadoControles = (BorderPane) loader.load();

			listadoControles.getStylesheets().add(this.getClass().getResource("/entradas/estiloEntradas.css").toExternalForm());
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
		
			scene.getStylesheets().add(this.getClass().getResource("/application/estilomenu.css").toExternalForm());
			
			stage.setScene(scene);
    	    stage.show();
    	    
    }
    private void makeDraggable(final Node node) {
        final DragContext dragContext = new DragContext();
            
        node.addEventFilter(MouseEvent.ANY, (mouseEvent) -> {
        	
        		// Se desactivan eventos para los hijos
                mouseEvent.consume();
            
        });
        
        node.addEventFilter(MouseEvent.MOUSE_PRESSED, (mouseEvent) -> {
        	
        		// Guardamos la posición del ratón
                dragContext.mouseAnchorX = mouseEvent.getX();
                dragContext.mouseAnchorY = mouseEvent.getY();
                dragContext.initialTranslateX = node.getTranslateX();
                dragContext.initialTranslateY = node.getTranslateY();
           
        });
          
        node.addEventFilter(MouseEvent.MOUSE_DRAGGED, (mouseEvent) -> {
			
			    // Se ajusta la posición final 
			    node.setTranslateX(dragContext.initialTranslateX + mouseEvent.getX() - dragContext.mouseAnchorX);
			    node.setTranslateY(dragContext.initialTranslateY + mouseEvent.getY() - dragContext.mouseAnchorY);
			
        });           
    }
    private static final class DragContext {
        public double mouseAnchorX;
        public double mouseAnchorY;
        public double initialTranslateX;
        public double initialTranslateY;
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
