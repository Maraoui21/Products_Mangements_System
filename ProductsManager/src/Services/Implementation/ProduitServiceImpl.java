package Services.Implementation;

import Dao.entities.Categorie;
import Dao.entities.Product;
import Dao.implementation.ProduitImpl;
import Services.Interfaces.ProduitService;

import java.util.ArrayList;

public class ProduitServiceImpl implements ProduitService {
    ProduitImpl productDao;
    public ProduitServiceImpl(ProduitImpl Pdao){
        productDao = Pdao;
    }
    @Override
    public ArrayList<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public Boolean addProduct(Product toAdd) {
        return productDao.addOne(toAdd);
    }

    @Override
    public Boolean RemoveProduct(Product toRemove) {
        return productDao.Remove(toRemove);
    }

    @Override
    public ArrayList<Product> findByCategorie(Categorie c) {
        return productDao.findByCategorie(c);
    }
}
