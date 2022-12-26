package Dao.entities;

import java.util.ArrayList;

public class Client {
    private int IdClient;
    private String FullName;
    private ArrayList<Commande> ListCommandes;

    public Client(){

    }
    public Client(String fullName) {
        FullName = fullName;
    }

    public int getIdClient() {
        return IdClient;
    }

    public void setIdClient(int idClient) {
        IdClient = idClient;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public ArrayList<Commande> getListCommandes() {
        return ListCommandes;
    }

    public void setListCommandes(ArrayList<Commande> listCommandes) {
        ListCommandes = listCommandes;
    }

    @Override
    public String toString() {
        return this.FullName;
    }
}
