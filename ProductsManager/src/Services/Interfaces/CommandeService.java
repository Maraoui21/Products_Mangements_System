package Services.Interfaces;

import Dao.entities.Client;
import Dao.entities.Commande;

import java.util.ArrayList;

public interface CommandeService {
    ArrayList<Commande> findAll();
    Boolean addCommande(Commande commande);
    Boolean remove(Commande commande);
    ArrayList<Commande> findByClient(Client client);
}
