package Dao.interfaces;

import Dao.Dao;
import Dao.entities.Client;
import Dao.entities.Commande;

import java.util.ArrayList;

public interface CommandeDao extends Dao<Commande> {
    ArrayList<Commande> findByClient(Client client);
}
