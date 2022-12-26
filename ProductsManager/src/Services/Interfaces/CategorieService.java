package Services.Interfaces;
import Dao.entities.Categorie;
import java.util.ArrayList;

public interface CategorieService {
    ArrayList<Categorie> findAll();
    Boolean addCategorie(Categorie toAdd);
    Boolean RemoveCategorie(Categorie toDelete);
}
