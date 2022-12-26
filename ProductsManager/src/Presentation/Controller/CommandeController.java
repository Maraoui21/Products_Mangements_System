package Presentation.Controller;

import Dao.entities.Client;
import Dao.entities.Commande;
import Dao.entities.Product;
import Dao.implementation.ClientImpl;
import Dao.implementation.CommandeImpl;
import Dao.implementation.ProduitImpl;
import Services.Implementation.ClientServiceImpl;
import Services.Implementation.CommandeServiceImpl;
import Services.Implementation.ProduitServiceImpl;
import Services.Interfaces.CommandeService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CommandeController implements Initializable{
    @FXML
    public TableColumn<Commande,Integer> idCommande;
    @FXML
    public TableColumn<Commande,Product> ProduitName;
    @FXML
    public TableColumn<Commande,Integer> QTE;
    @FXML
    public TableColumn<Commande,Client> Client;
    @FXML
    public TableView<Commande> TableCommande;
    @FXML
    public ObservableList<Commande> ListCommandes;
    @FXML
    public ComboBox<Client> ClientsBox;
    @FXML
    public ComboBox<Product> ProductsBox;
    public TextField QteField;

    public CommandeServiceImpl CommandeService(){
        CommandeImpl cmpl = new CommandeImpl();
        return new CommandeServiceImpl(cmpl);
    }

    public void addCommande(ActionEvent actionEvent) {
        Client client = ClientsBox.getSelectionModel().getSelectedItem();
        Product product = ProductsBox.getSelectionModel().getSelectedItem();
        int qte = Integer.parseInt(QteField.getText());
        Commande commandeToAdd = new Commande(product,client,qte);
        if(CommandeService().addCommande(commandeToAdd)){
            LoadAllCommandes();
        }
    }

    public void deleteCommande(ActionEvent actionEvent) {
        Commande selectedCommande = TableCommande.getSelectionModel().getSelectedItem();
        if(CommandeService().remove(selectedCommande)){
            LoadAllCommandes();
        }
    }

    public void filterCLientCommandes(ActionEvent actionEvent) {
        Client client = ClientsBox.getSelectionModel().getSelectedItem();
        ArrayList<Commande> commadesOfClient = CommandeService().findByClient(client);
        if(commadesOfClient.size()!=0){
            ListCommandes.setAll(commadesOfClient);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // comboBox of products
        ObservableList<Product> productsListBox = FXCollections.observableArrayList(ProductService().findAll());
        ProductsBox.setItems(productsListBox);

        // comboBox of clients
        ObservableList<Client> ClientListBox = FXCollections.observableArrayList(ClientService().findAll());
        ClientsBox.setItems(ClientListBox);

        // load all
        LoadAllCommandes();

    }

    // load all commandes
    public void LoadAllCommandes(){
        // affichage to des commandes
        ListCommandes = FXCollections.observableArrayList(CommandeService().findAll());
        idCommande.setCellValueFactory(new PropertyValueFactory<Commande,Integer>("IdCommande"));
        ProduitName.setCellValueFactory(new PropertyValueFactory<Commande, Product>("ProduitCommandee"));
        Client.setCellValueFactory(new PropertyValueFactory<Commande,Client>("clt"));
        QTE.setCellValueFactory(new PropertyValueFactory<Commande,Integer>("qte"));
        TableCommande.setItems(ListCommandes);
    }


    // service methodes
    public ProduitServiceImpl ProductService(){
        ProduitImpl proImpl = new ProduitImpl();
        return new ProduitServiceImpl(proImpl);
    }

    public ClientServiceImpl ClientService(){
        ClientImpl clientImpl = new ClientImpl();
        return new ClientServiceImpl(clientImpl);
    }

}
