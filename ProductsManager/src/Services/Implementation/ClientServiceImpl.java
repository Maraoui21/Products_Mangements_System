package Services.Implementation;

import Dao.entities.Client;
import Dao.implementation.ClientImpl;
import Services.Interfaces.ClientService;

import java.util.ArrayList;

public class ClientServiceImpl implements ClientService {
    ClientImpl clientImpl;
    public ClientServiceImpl(ClientImpl clientImpl){
        this.clientImpl = clientImpl;
    }
    @Override
    public ArrayList<Client> findAll() {
        return clientImpl.findAll();
    }

    @Override
    public Boolean addClient(Client client) {
        return clientImpl.addOne(client);
    }

    @Override
    public Boolean remove(Client client) {
        return clientImpl.Remove(client);
    }
}
