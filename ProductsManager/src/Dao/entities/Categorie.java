package Dao.entities;

public class Categorie {
    private int id;
    private String nom;

    public int getId() {
        return id;
    }
    public Categorie(){

    }
    public Categorie(String nom) {
        this.nom = nom;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return this.nom;
    }
}
