package Dao.interfaces;

import Dao.Dao;
import Dao.entities.Client;

public interface ClientDao extends Dao<Client>{
    Client findById(int IdClient);
}
