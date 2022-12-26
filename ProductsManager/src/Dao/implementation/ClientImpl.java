package Dao.implementation;

import Dao.SingleDbConnection;
import Dao.entities.Client;
import Dao.entities.Product;
import Dao.interfaces.ClientDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClientImpl implements ClientDao {
    @Override
    public Boolean addOne(Client o) {
        try{
            Connection con = SingleDbConnection.getConnection();
            PreparedStatement query = con.prepareStatement("INSERT INTO `client`(`id`, `FullName`) VALUES (null,?)");
            query.setString(1,o.getFullName());
            int queryResult = query.executeUpdate();
            return (queryResult!=0);
        }
        catch (SQLException e){
            e.getStackTrace();
        }
        return null;
    }

    @Override
    public Boolean Remove(Client o) {
        try{
            Connection con = SingleDbConnection.getConnection();
            PreparedStatement query = con.prepareStatement("DELETE FROM `client` WHERE id = ?");
            query.setInt(1,o.getIdClient());
            int queryResult = query.executeUpdate();
            return (queryResult!=0);
        }
        catch (SQLException e){
            e.getStackTrace();
        }
        return null;
    }

    @Override
    public Client finOne(Client o) {
        return null;
    }

    @Override
    public ArrayList<Client> findAll() {
        try {
            Connection con = SingleDbConnection.getConnection();
            PreparedStatement query = con.prepareStatement("SELECT * FROM `client`");
            ResultSet queryResult = query.executeQuery();
            ArrayList<Client> clients = new ArrayList<>();
            while (queryResult.next()){
                Client client = new Client();
                client.setIdClient(queryResult.getInt("id"));
                client.setFullName(queryResult.getString("FullName"));
                clients.add(client);
            }
            return clients;
        }
        catch (SQLException e){
            e.getStackTrace();
        }
        return null;
    }

    @Override
    public Client findById(int IdClient) {
        try {
            Connection con = SingleDbConnection.getConnection();
            PreparedStatement query = con.prepareStatement("SELECT * FROM `client` WHERE ID = ?");
            query.setInt(1,IdClient);
            ResultSet queryResult = query.executeQuery();
            Client client = null;
            while (queryResult.next()){
                client = new Client();
                client.setIdClient(queryResult.getInt("id"));
                client.setFullName(queryResult.getString("FullName"));
            }
            return client;
        }
        catch (SQLException e){
            e.getStackTrace();
        }
        return null;
    }
}
