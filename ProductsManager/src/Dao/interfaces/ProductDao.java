package Dao.interfaces;

import Dao.Dao;
import Dao.entities.Categorie;
import Dao.entities.Product;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ProductDao extends Dao<Product> {
    ArrayList<Product> findByCategorie(Categorie c) throws SQLException;
    Product getById(int idProduct);
}
