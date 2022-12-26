package Presentation.Controller;

import Dao.entities.Categorie;
import Dao.entities.Product;
import Dao.implementation.CategorieImpl;
import Dao.implementation.ProduitImpl;
import Services.Implementation.CategorieServiceImpl;
import Services.Implementation.ProduitServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ProductController implements Initializable {
    @FXML
    public ComboBox<Categorie> categorieMenu;
    public TextField Nom;
    public TextField Prix;
    public TextField Qte;
    @FXML
    ObservableList<Product> ListProducts;
    @FXML
    TableView<Product> ProductsTable;
    @FXML
    TableColumn<Product,Integer> id;
    @FXML
    TableColumn<Product,String> nom;
    @FXML
    TableColumn<Product,Double> prix;
    @FXML
    TableColumn<Product,Integer> qte;

    public ProduitServiceImpl ProductService(){
        ProduitImpl proImpl = new ProduitImpl();
        return new ProduitServiceImpl(proImpl);
    }
    public void filterBycategorie(ActionEvent actionEvent) {
        Categorie selectedCategorie = categorieMenu.getSelectionModel().getSelectedItem();
        ListProducts.setAll(ProductService().findByCategorie(selectedCategorie));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // LoadAll categories
        CategorieImpl ImplCategorie = new CategorieImpl();
        CategorieServiceImpl CategorieService = new CategorieServiceImpl(ImplCategorie);
        ArrayList<Categorie> categoriesList = CategorieService.findAll();
        for (Categorie val:categoriesList) {
            categorieMenu.getItems().add(val);
        }


        // Load all products
        ListProducts = FXCollections.observableArrayList(ProductService().findAll());
        id.setCellValueFactory(new PropertyValueFactory<Product,Integer>("id"));
        nom.setCellValueFactory(new PropertyValueFactory<Product,String>("nom"));
        prix.setCellValueFactory(new PropertyValueFactory<Product,Double>("prix"));
        qte.setCellValueFactory(new PropertyValueFactory<Product,Integer>("Qte"));
        ProductsTable.setItems(ListProducts);

    }

    public void addProduct(ActionEvent actionEvent) {
        Categorie selectedCategorie = categorieMenu.getSelectionModel().getSelectedItem();
        Product P = new Product(Nom.getText(),Double.parseDouble(Prix.getText()),
                                Integer.parseInt(Qte.getText()),selectedCategorie.getId());

        if(ProductService().addProduct(P)){
            ListProducts.setAll(ProductService().findAll());
        }
    }

    public void remove(ActionEvent actionEvent) {
        Product toDelete = ProductsTable.getSelectionModel().getSelectedItem();
        if(ProductService().RemoveProduct(toDelete)){
            ListProducts.remove(toDelete);
        }
    }
}
