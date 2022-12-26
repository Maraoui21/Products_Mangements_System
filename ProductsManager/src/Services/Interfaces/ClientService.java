package Services.Interfaces;

import Dao.entities.Client;

import java.util.ArrayList;

public interface ClientService {
    ArrayList<Client> findAll();
    Boolean addClient(Client client);
    Boolean remove(Client client);
}
