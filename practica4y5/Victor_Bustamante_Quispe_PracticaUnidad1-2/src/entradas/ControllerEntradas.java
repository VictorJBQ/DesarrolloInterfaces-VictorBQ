package entradas;


import java.util.Arrays;
import java.util.ResourceBundle;

import javax.print.DocFlavor.URL;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
/**
 * Clase ControllerEntradas que se encarga de cargar los datos en la tabla y graficos
 * @author victor Bustamante
 *@version 1.0
 *
 */
public class ControllerEntradas implements Initializable{
	@FXML
	private StackedBarChart<String, Double> StackedBarchart;
	@FXML
	private CategoryAxis abajoAxisStacked;
    @FXML
    private NumberAxis izquierdaAxisStacked;
	@FXML
	private PieChart piePeliculas;
	@FXML
    private CategoryAxis abajoAxis;
    @FXML
    private NumberAxis izquierdaAxis;
    @FXML
    private BarChart<String,Integer> BarChart;
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
/**
 * 
 * @param type
 * @param title recogemos el titulo para ponerlo en la alerta auxiliar
 * @param header El cabezero de la alerta
 * @param contextText y el texto de la alerta
 * @return
 */
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
   	else if(arg0.toString().contains("compEntrada.fxml")){
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
   	else if(arg0.toString().contains("GraficoEntradas.fxml")) {
   		//BarChart
   	 	String[] cat = {"Orcasitas", "Tres Cantos", "Vallecas","Callao","Torrejón"};
    	ObservableList<String> catNames=FXCollections.observableArrayList();
    	catNames.addAll(Arrays.asList(Arrays.copyOfRange(cat, 0, cat.length)));
    	abajoAxis.setCategories(catNames);
    	abajoAxisStacked.setCategories(catNames);
    	StackedBarchart.getData().add(initDatos2());
    	StackedBarchart.getData().add(initDatos3());
		BarChart.getData().add(initDatosBar());
		
		piePeliculas.setData(pie());
		
		
   	}
 
		
	}
   /**
    * Crea un PieChart recogiendo los datos del observableList
    * @return un observableList actualizado con los contenidos
    */
   
   private ObservableList<PieChart.Data> pie(){
	   ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
		int contadorBlack=0,contadorAva=0,contadorAven=0,contadorPi=0;
		for(entradas en:getDatos()) {
			if(en.getPelicula().equals("Black Adam")){
				contadorBlack++;
				System.out.println(contadorBlack);
			}else if(en.getPelicula().equals("Avatar 2")){
				contadorAva++;
				System.out.println(contadorAva);
			}else if(en.getPelicula().equals("Avengers")){
				contadorAven++;
				System.out.println(contadorAven);
			}else if(en.getPelicula().equals("La vida de Pi")){
				contadorPi++;
				System.out.println(contadorPi);
			}
		}
		pieChartData.addAll(new PieChart.Data("Black Adam: "+contadorBlack, contadorBlack),
				new PieChart.Data("Avatar 2: "+contadorAva, contadorAva),
				new PieChart.Data("Avengers: "+contadorAven, contadorAven),
				new PieChart.Data("La vida de Pi: "+contadorPi, contadorPi)
				);
		return pieChartData;
   }
   
   
   
   private XYChart.Series<String, Integer> initDatosBar() {
	   XYChart.Series<String, Integer> series1 = new XYChart.Series<String, Integer>();
		int contadorO=0,contadorT=0,contadorV=0,contadorC=0,contadorTor=0;
		for(entradas a:getDatos()) {
			if(a.getCine().contains("Orcasitas")){
				contadorO++;
				series1.getData().add(new XYChart.Data<String, Integer>("Orcasitas", contadorO));
			}else if(a.getCine().contains("Tres Cantos")){
				contadorT++;
				series1.getData().add(new XYChart.Data<String, Integer>("Tres Cantos", contadorT));
			}else if(a.getCine().contains("Vallecas")){
				contadorV++;
				series1.getData().add(new XYChart.Data<String, Integer>("Vallecas", contadorV));
			}else if(a.getCine().contains("Callao")){
				contadorC++;
				series1.getData().add(new XYChart.Data<String, Integer>("Callao", contadorC));
			}else if(a.getCine().contains("Torrejón")){
				contadorTor++;
				series1.getData().add(new XYChart.Data<String, Integer>("Torrejón", contadorTor));
			}
		}
		return series1;
	}
   /**
    * Metodo para inicializar datos del Chart
    * @return devuelve un objeto Chart.Series
    */
   private XYChart.Series<String, Double> initDatos2() {
		XYChart.Series<String, Double> series2 = new XYChart.Series<String, Double>();
		
		series2.setName("Generado en 2021");
		series2.getData().add(new XYChart.Data<String, Double>("Orcasitas", 57401.85));
		series2.getData().add(new XYChart.Data<String, Double>("Tres Cantos", 41941.19));
		series2.getData().add(new XYChart.Data<String, Double>("Vallecas", 45263.37));
		series2.getData().add(new XYChart.Data<String, Double>("Callao", 117320.16));
		series2.getData().add(new XYChart.Data<String, Double>("Torrejón", 14845.27));  
		
		return series2;
	}
		
	private XYChart.Series<String, Double> initDatos3() {
		XYChart.Series<String, Double> series3 = new XYChart.Series<String, Double>();
		
		series3.setName("Generado en 2022");
		series3.getData().add(new XYChart.Data<String, Double>("Orcasitas", 45000.65));
		series3.getData().add(new XYChart.Data<String, Double>("Tres Cantos", 44835.76));
		series3.getData().add(new XYChart.Data<String, Double>("Vallecas", 18722.18));
		series3.getData().add(new XYChart.Data<String, Double>("Callao", 17557.31));
		series3.getData().add(new XYChart.Data<String, Double>("Torrejón", 92633.68));  
		
		return series3;
	}
	/**
	 * Metodos que nos da la funcionalidad de buscar cliente
	 * @param event
	 */
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
