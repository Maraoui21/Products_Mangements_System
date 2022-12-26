package Dao.implementation;

import Dao.SingleDbConnection;
import Dao.entities.Categorie;
import Dao.entities.Product;
import Dao.interfaces.ProductDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProduitImpl implements ProductDao {
    @Override
    public Boolean addOne(Product o){
        try{
            Connection con = SingleDbConnection.getConnection();
            PreparedStatement query = con.prepareStatement("INSERT INTO `produits`(`ID`, `NOM`, `PRIX`, `QTE`, `IDCATEGORIE`) VALUES (null,?,?,?,?)");
            query.setString(1,o.getNom());
            query.setDouble(2,o.getPrix());
            query.setInt(3,o.getQte());
            query.setInt(4,o.getIdCategorie());
            int queryResult = query.executeUpdate();
            return (queryResult!=0);
        }catch (SQLException e){
            e.getStackTrace();
        }
        return null;
    }

    @Override
    public Boolean Remove(Product o){
        try {
            Connection con = SingleDbConnection.getConnection();
            PreparedStatement query = con.prepareStatement("DELETE FROM `produits` WHERE ID = ?");
            query.setInt(1,o.getId());
            int queryResult = query.executeUpdate();
            return (queryResult!=0);
        }
        catch (SQLException e){
            e.getStackTrace();
        }
        return null;
    }

    @Override
    public Product finOne(Product o){
        try {
            Connection con = SingleDbConnection.getConnection();
            PreparedStatement query = con.prepareStatement("SELECT * FROM `produits` WHERE ID = ?");
            query.setInt(1,o.getId());
            ResultSet queryResult = query.executeQuery();
            Product p = null;
            while (queryResult.next()){
                p = new Product();
                p.setId(queryResult.getInt("ID"));
                p.setNom(queryResult.getString("NOM"));
                p.setPrix(queryResult.getDouble("PRIX"));
                p.setQte(queryResult.getInt("QTE"));
                p.setIdCategorie(queryResult.getInt("IDCATEGORIE"));
            }
            return p;
        }
        catch (SQLException e){
            e.getStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Product> findAll(){
        try {
            Connection con = SingleDbConnection.getConnection();
            PreparedStatement query = con.prepareStatement("SELECT * FROM `produits`");
            ResultSet queryResult = query.executeQuery();
            ArrayList<Product> ListProducts = new ArrayList<>();
            while (queryResult.next()){
                Product p = new Product();
                p.setId(queryResult.getInt("ID"));
                p.setNom(queryResult.getString("NOM"));
                p.setPrix(queryResult.getDouble("PRIX"));
                p.setQte(queryResult.getInt("QTE"));
                p.setIdCategorie(queryResult.getInt("IDCATEGORIE"));
                ListProducts.add(p);
            }
            return ListProducts;
        }
        catch (SQLException e){
            e.getStackTrace();
        }
        return null;
    }
    @Override
    public ArrayList<Product> findByCategorie(Categorie c){
        try {
            Connection con = SingleDbConnection.getConnection();
            PreparedStatement query = con.prepareStatement("SELECT * FROM `produits` where IDCATEGORIE = ?");
            query.setInt(1, c.getId());
            ResultSet queryResult = query.executeQuery();
            ArrayList<Product> ListProducts = new ArrayList<>();
            while (queryResult.next()) {
                Product p = new Product();
                p.setId(queryResult.getInt("ID"));
                p.setNom(queryResult.getString("NOM"));
                p.setPrix(queryResult.getDouble("PRIX"));
                p.setQte(queryResult.getInt("QTE"));
                p.setIdCategorie(queryResult.getInt("IDCATEGORIE"));
                ListProducts.add(p);
            }
            return ListProducts;
        }catch (SQLException e){
            e.getStackTrace();
        }
        return null;
    }

    @Override
    public Product getById(int idProduct) {
        try {
            Connection con = SingleDbConnection.getConnection();
            PreparedStatement query = con.prepareStatement("SELECT * FROM `produits` WHERE ID = ?");
            query.setInt(1,idProduct);
            ResultSet queryResult = query.executeQuery();
            Product p = null;
            while (queryResult.next()){
                p = new Product();
                p.setId(queryResult.getInt("ID"));
                p.setNom(queryResult.getString("NOM"));
                p.setPrix(queryResult.getDouble("PRIX"));
                p.setQte(queryResult.getInt("QTE"));
                p.setIdCategorie(queryResult.getInt("IDCATEGORIE"));
            }
            return p;
        }
        catch (SQLException e){
            e.getStackTrace();
        }
        return null;
    }
}
