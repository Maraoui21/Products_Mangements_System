package Services.Implementation;

import Dao.entities.Categorie;
import Dao.implementation.CategorieImpl;
import Services.Interfaces.CategorieService;

import java.util.ArrayList;

public class CategorieServiceImpl implements CategorieService {
    CategorieImpl CategorieDao;
    public CategorieServiceImpl(CategorieImpl categorie){
        this.CategorieDao = categorie;
    }
    @Override
    public ArrayList<Categorie> findAll() {
        return CategorieDao.findAll();
    }

    @Override
    public Boolean addCategorie(Categorie toAdd) {
        return CategorieDao.addOne(toAdd);
    }

    @Override
    public Boolean RemoveCategorie(Categorie toDelete) {
        return CategorieDao.Remove(toDelete);
    }
}
