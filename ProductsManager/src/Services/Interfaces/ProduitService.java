package Services.Interfaces;

import Dao.entities.Categorie;
import Dao.entities.Product;

import java.util.ArrayList;

public interface ProduitService {
    ArrayList<Product> findAll();
    Boolean addProduct(Product toAdd);
    Boolean RemoveProduct(Product toRemove);
    ArrayList<Product> findByCategorie(Categorie c);
}
