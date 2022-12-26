package Dao.entities;

public class Commande {
    private int IdCommande;
    private Product ProduitCommandee;
    private Client clt;
    private int qte;
    public Commande(){

    }

    public Commande(Product produitCommandee, Client clt, int qte) {
        ProduitCommandee = produitCommandee;
        this.clt = clt;
        this.qte = qte;
    }

    public int getIdCommande() {
        return IdCommande;
    }

    public void setIdCommande(int idCommande) {
        IdCommande = idCommande;
    }



    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }



    public Product getProduitCommandee() {
        return ProduitCommandee;
    }

    public void setProduitCommandee(Product produitCommandee) {
        ProduitCommandee = produitCommandee;
    }

    public Client getClt() {
        return clt;
    }

    public void setClt(Client clt) {
        this.clt = clt;
    }
}
