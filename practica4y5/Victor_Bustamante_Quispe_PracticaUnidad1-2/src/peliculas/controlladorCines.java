package peliculas;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.TextFieldTreeCell;

public class controlladorCines {
	  @FXML
	    private Label adam;

	    @FXML
	    private Label avatar;

	    @FXML
	    private Label pray;
	    @FXML
	    private Label wakanda;

	    @FXML
	    private TreeView<String> TreeAvatar;

	    @FXML
	    private TreeView<String> treeAdam;

	    @FXML
	    private TreeView<String> treePray;

	    @FXML
	    private TreeView<String> treeWak;
	    
	    @FXML
	    void initialize() {
	    	
	    	//AVATAR
	    	TreeItem<String> rootItemAva = new TreeItem<String>("Información");
	    	 TreeItem<String> tituloAva = new TreeItem<String>("Titulo: Avatar 2-El Sentido del Agua");
	    	 TreeItem<String> Fecha_EstrenoAva = new TreeItem<String>("Fecha Estreno: Diciembre 2022");
	    	 TreeItem<String> sinopsisAva = new TreeItem<String>("sinopsis");
	    	 sinopsisAva.getChildren().add(new TreeItem<String>("Ambientada más de una década \n después de los acontecimientos \n de la primera película, \n 'Avatar: The Way of Water' \n empieza contando la historia \n de la familia Sully (Jake, \n Neytiri y sus hijos), los \n problemas que los persiguen, \n lo que tienen que hacer \n para mantenerse a salvo, las \n batallas que libran para \n seguir con vida y las \n tragedias que sufren.."));
	    	 rootItemAva.getChildren().add(tituloAva);
	    	 rootItemAva.getChildren().add(Fecha_EstrenoAva);
	    	 rootItemAva.getChildren().add(sinopsisAva);
	    	 TreeAvatar.setCellFactory(TextFieldTreeCell.forTreeView());
	         rootItemAva.setExpanded(true); 
	         TreeAvatar.setRoot(rootItemAva); 
	         
	         //PRAY OF DEVIL
	         TreeItem<String> rootItemPray= new TreeItem<String>("Información");
	    	 TreeItem<String> tituloPray = new TreeItem<String>("Titulo: Prey for the Devil");
	    	 TreeItem<String> Fecha_EstrenoPray = new TreeItem<String>("Fecha Estreno: 30 Octubre 2022");
	    	 TreeItem<String> sinopsisPray = new TreeItem<String>("sinopsis");
	    	 sinopsisPray.getChildren().add(new TreeItem<String>("Una joven monja, la \n hermana Ann (Jacqueline Byers), \n se prepara para un exorcismo \n y se enfrenta a una fuerza \n demoniaca que está misteriosamente \n relacionada con su pasado."));
	    	 rootItemPray.getChildren().add(tituloPray);
	    	 rootItemPray.getChildren().add(Fecha_EstrenoPray);
	    	 rootItemPray.getChildren().add(sinopsisPray);
	    	 treePray.setCellFactory(TextFieldTreeCell.forTreeView());
	    	 rootItemPray.setExpanded(true); 
	         treePray.setRoot(rootItemPray); 
	         
	         //WAKANDA
	         TreeItem<String> rootItemWak= new TreeItem<String>("Información");
	    	 TreeItem<String> tituloWak = new TreeItem<String>("Titulo: Black Panther: Wakanda Forever");
	    	 TreeItem<String> Fecha_EstrenoWak = new TreeItem<String>("Fecha Estreno: 11/11/2022 ");
	    	 TreeItem<String> sinopsisWak = new TreeItem<String>("sinopsis");
	    	 sinopsisWak.getChildren().add(new TreeItem<String>("Una secuela que seguirá \n explorando el incomparable \n mundo de Wakanda y todos \n los ricos y variados personajes \n presentados en la película de 2018."));
	    	 rootItemWak.getChildren().add(tituloWak);
	    	 rootItemWak.getChildren().add(Fecha_EstrenoWak);
	    	 rootItemWak.getChildren().add(sinopsisWak);
	    	 treeWak.setCellFactory(TextFieldTreeCell.forTreeView());
	    	 rootItemWak.setExpanded(true); 
	    	 treeWak.setRoot(rootItemWak); 
	         
	         //BLACK ADAM
	    	 TreeItem<String> rootItemAdam = new TreeItem<String>("Información");
	    	 TreeItem<String> titulo = new TreeItem<String>("Titulo: Black Adam");
	    	 TreeItem<String> Fecha_Estreno = new TreeItem<String>("Fecha Estreno: 21/10/2022");
	    	 TreeItem<String> sinopsis = new TreeItem<String>("sinopsis");
	    	 sinopsis.getChildren().add(new TreeItem<String>("Casi 5.000 años después \n de haber  sido dotado de los \n poderes omnipotentes \n de los antiguos dioses \n -y encarcelado con la misma rapidez-, \n Black Adam (Johnson) es liberado \n de su tumba terrenal, listo \n para desatar su forma única \n de justicia en el mundo moderno."));
	    	 rootItemAdam.getChildren().add(titulo);
	    	 rootItemAdam.getChildren().add(Fecha_Estreno);
	    	 rootItemAdam.getChildren().add(sinopsis);
	         treeAdam.setCellFactory(TextFieldTreeCell.forTreeView());
	         rootItemAdam.setExpanded(true); 
	         treeAdam.setRoot(rootItemAdam); 
	         
	         
	         
	    }

		public Label getAdam() {
			return adam;
		}

		public void setAdam(Label adam) {
			this.adam = adam;
		}

		public Label getAvatar() {
			return avatar;
		}

		public void setAvatar(Label avatar) {
			this.avatar = avatar;
		}

		public Label getPray() {
			return pray;
		}

		public void setPray(Label pray) {
			this.pray = pray;
		}

		public Label getWakanda() {
			return wakanda;
		}

		public void setWakanda(Label wakanda) {
			this.wakanda = wakanda;
		}
	    
	    
}
