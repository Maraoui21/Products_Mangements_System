package Dao.implementation;

import Dao.SingleDbConnection;
import Dao.entities.Categorie;
import Dao.interfaces.CategorieDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategorieImpl implements CategorieDao {
    @Override
    public Boolean addOne(Categorie o){
        try{
            Connection con = SingleDbConnection.getConnection();
            PreparedStatement query = con.prepareStatement("INSERT INTO `categorie`(`ID`, `NOM`) VALUES (null,?)");
            query.setString(1,o.getNom());
            int queryResult = query.executeUpdate();
            return (queryResult!=0);
        }
        catch (SQLException e){
            e.getStackTrace();
        }
        return null;
    }

    @Override
    public Boolean Remove(Categorie o)  {
        try {
            Connection con = SingleDbConnection.getConnection();
            PreparedStatement query = con.prepareStatement("DELETE FROM `categorie` WHERE ID = ?");
            query.setInt(1,o.getId());
            int queryResult = query.executeUpdate();
            return (queryResult!=0);
        } catch (SQLException e){
            e.getStackTrace();
        }
        return null;
    }

    @Override
    public Categorie finOne(Categorie o){
        try {
            Connection con = SingleDbConnection.getConnection();
            PreparedStatement query = con.prepareStatement("SELECT * FROM `categorie` where ID = ?");
            query.setInt(1,o.getId());
            ResultSet queryResult = query.executeQuery();
            Categorie c = null;
            while (queryResult.next()){
                c = new Categorie();
                c.setId(queryResult.getInt("ID"));
                c.setNom(queryResult.getString("NOM"));
            }
            return c;
        }
        catch (SQLException e){
            e.getStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Categorie> findAll(){
        try {
            Connection con = SingleDbConnection.getConnection();
            PreparedStatement query = con.prepareStatement("SELECT * FROM `categorie`");
            ResultSet queryResult = query.executeQuery();
            ArrayList<Categorie> allCategories = new ArrayList<>();
            while (queryResult.next()){
                Categorie c = new Categorie();
                c.setId(queryResult.getInt("ID"));
                c.setNom(queryResult.getString("NOM"));
                allCategories.add(c);
            }
            return allCategories;
        }
        catch (SQLException e){
            e.getStackTrace();
        }
        return null;
    }


}
