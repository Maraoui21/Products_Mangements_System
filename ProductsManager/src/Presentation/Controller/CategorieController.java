package Presentation.Controller;
import Dao.entities.Categorie;
import Dao.implementation.CategorieImpl;
import Services.Implementation.CategorieServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class CategorieController implements Initializable {
    @FXML
    ObservableList<Categorie> ListCategories;
    @FXML
    public TextField categoriesName;
    public TableView<Categorie> table;
    @FXML
    public TableColumn<Categorie, Integer> id;
    @FXML
    public TableColumn<Categorie,String> nom;
    public CategorieServiceImpl categorieService(){
        CategorieImpl ImplCategorie = new CategorieImpl();
        return new CategorieServiceImpl(ImplCategorie);
    }
    @FXML
    public void addCategorie(ActionEvent actionEvent) {

        String TypedCatygorie = categoriesName.getText();
        Categorie c = new Categorie(TypedCatygorie);
        if(categorieService().addCategorie(c)){
            ListCategories.setAll(categorieService().findAll());
        }
    }

    public void removeCategorie(ActionEvent actionEvent) {
        Categorie SelectedCat = table.getSelectionModel().getSelectedItem();
        if(categorieService().RemoveCategorie(SelectedCat)){
            ListCategories.remove(SelectedCat);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ListCategories = FXCollections.observableArrayList(categorieService().findAll());
        id.setCellValueFactory(new PropertyValueFactory<Categorie,Integer>("id"));
        nom.setCellValueFactory(new PropertyValueFactory<Categorie,String>("nom"));
        table.setItems(ListCategories);
    }
}
