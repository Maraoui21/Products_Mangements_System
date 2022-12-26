package Dao.implementation;

import Dao.SingleDbConnection;
import Dao.entities.Categorie;
import Dao.entities.Client;
import Dao.entities.Commande;
import Dao.interfaces.CommandeDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CommandeImpl implements CommandeDao {
    @Override
    public Boolean addOne(Commande o) {
        try{
            Connection con = SingleDbConnection.getConnection();
            PreparedStatement query = con.prepareStatement("INSERT INTO `commande`(`IdCommande`, `IDPRODUCT`, `QTE`, `client`) VALUES (null,?,?,?)");
            query.setInt(1,o.getProduitCommandee().getId());
            query.setInt(2,o.getQte());
            query.setInt(3,o.getClt().getIdClient());
            int queryResult = query.executeUpdate();
            return (queryResult!=0);
        }
        catch (SQLException e){
            e.getStackTrace();
        }
        return null;
    }

    @Override
    public Boolean Remove(Commande o) {
        try {
            Connection con = SingleDbConnection.getConnection();
            PreparedStatement query = con.prepareStatement("DELETE FROM `commande` WHERE idCommande = ?");
            query.setInt(1,o.getIdCommande());
            int queryResult = query.executeUpdate();
            return (queryResult!=0);
        } catch (SQLException e){
            e.getStackTrace();
        }
        return null;
    }

    @Override
    public Commande finOne(Commande o) {
//        try {
//            Connection con = SingleDbConnection.getConnection();
//            PreparedStatement query = con.prepareStatement("SELECT * FROM `commande` where ID = ?");
//            query.setInt(1,o.getIdCommande());
//            ResultSet queryResult = query.executeQuery();
//            Commande c = null;
//            while (queryResult.next()){
//                c = new Commande();
//                c.setIdCommande(queryResult.getInt("idCommande"));
//                c.setClt();
//            }
//            return c;
//        }
//        catch (SQLException e){
//            e.getStackTrace();
//        }
        return null;
    }

    @Override
    public ArrayList<Commande> findAll() {
        try {
            Connection con = SingleDbConnection.getConnection();
            ProduitImpl pdao = new ProduitImpl();
            ClientImpl CDao = new ClientImpl();
            PreparedStatement query = con.prepareStatement("SELECT * FROM `commande`");
            ResultSet queryResult = query.executeQuery();
            ArrayList<Commande> allCommandes = new ArrayList<>();
            while (queryResult.next()){
                Commande c = new Commande();
                c.setIdCommande(queryResult.getInt("idCommande"));
                c.setProduitCommandee(pdao.getById(queryResult.getInt("IDPRODUCT")));
                c.setClt(CDao.findById(queryResult.getInt("client")));
                c.setQte(queryResult.getInt("QTE"));
                allCommandes.add(c);
            }
            return allCommandes;
        }
        catch (SQLException e){
            e.getStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Commande> findByClient(Client client) {
        try {
            Connection con = SingleDbConnection.getConnection();
            ProduitImpl pdao = new ProduitImpl();
            ClientImpl CDao = new ClientImpl();
            PreparedStatement query = con.prepareStatement("SELECT * FROM `commande` where client = ?");
            query.setInt(1,client.getIdClient());
            ResultSet queryResult = query.executeQuery();
            ArrayList<Commande> allCommandes = new ArrayList<>();
            while (queryResult.next()){
                Commande c = new Commande();
                c.setIdCommande(queryResult.getInt("idCommande"));
                c.setProduitCommandee(pdao.getById(queryResult.getInt("IDPRODUCT")));
                c.setClt(CDao.findById(queryResult.getInt("client")));
                c.setQte(queryResult.getInt("QTE"));
                allCommandes.add(c);
            }
            return allCommandes;
        }
        catch (SQLException e){
            e.getStackTrace();
        }
        return null;
    }
}
