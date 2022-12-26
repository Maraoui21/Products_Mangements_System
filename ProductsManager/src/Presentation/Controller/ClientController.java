package Presentation.Controller;

import Dao.entities.Client;
import Dao.implementation.ClientImpl;
import Services.Implementation.ClientServiceImpl;
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

public class ClientController implements Initializable {
    @FXML
    public TableView<Client> clientTable;
    @FXML
    public TableColumn<Client,Integer> IdClient;
    @FXML
    public TableColumn<Client,String> NomClient;
    public TextField clientName;
    @FXML
    ObservableList<Client> clientsList;

    public ClientServiceImpl ClientService(){
        ClientImpl clientImpl = new ClientImpl();
        return new ClientServiceImpl(clientImpl);
    }


    public void addClient(ActionEvent actionEvent) {

        String TypedName = clientName.getText();
        if(TypedName.length()>0){
            Client client = new Client(TypedName);
            if(ClientService().addClient(client)){
                clientsList.setAll(ClientService().findAll());
            }
        }
    }

    public void removeClient(ActionEvent actionEvent) {
        Client c = clientTable.getSelectionModel().getSelectedItem();
        if(c!=null){
            if(ClientService().remove(c)){
                clientsList.setAll(ClientService().findAll());
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        clientsList = FXCollections.observableArrayList(ClientService().findAll());
        IdClient.setCellValueFactory(new PropertyValueFactory<Client,Integer>("IdClient"));
        NomClient.setCellValueFactory(new PropertyValueFactory<Client,String>("FullName"));
        clientTable.setItems(clientsList);
    }
}
