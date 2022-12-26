package Services.Implementation;

import Dao.entities.Categorie;
import Dao.entities.Client;
import Dao.entities.Commande;
import Dao.implementation.CommandeImpl;
import Services.Interfaces.CategorieService;
import Services.Interfaces.CommandeService;

import java.util.ArrayList;

public class CommandeServiceImpl implements CommandeService {
    CommandeImpl CDao;
    public CommandeServiceImpl(CommandeImpl CDao){
        this.CDao = CDao;
    }
    @Override
    public ArrayList<Commande> findAll() {
        return CDao.findAll();
    }

    @Override
    public Boolean addCommande(Commande commande) {
        return CDao.addOne(commande);
    }

    @Override
    public Boolean remove(Commande commande) {
        return CDao.Remove(commande);
    }

    @Override
    public ArrayList<Commande> findByClient(Client client) {
        return CDao.findByClient(client);
    }
}
