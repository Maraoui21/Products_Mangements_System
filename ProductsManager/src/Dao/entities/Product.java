package Dao.entities;

public class Product {
    // attributes
    private int id;
    private String nom;
    private double prix;
    private int Qte;
    public Product(){};
    public Product(String nom, double prix, int qte, int idCategorie) {
        this.nom = nom;
        this.prix = prix;
        Qte = qte;
        IdCategorie = idCategorie;
    }

    private int IdCategorie;


    // setters and getters

    public int getId() {
        return id;
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

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getQte() {
        return Qte;
    }

    public void setQte(int qte) {
        Qte = qte;
    }

    public int getIdCategorie() {
        return IdCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        IdCategorie = idCategorie;
    }

    @Override
    public String toString() {
        return this.nom;
    }
}
