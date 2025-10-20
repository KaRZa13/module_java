public class Client {
    Tasse tasse;
    Cafe commandeCafe;
    String nom;
    float valeurFacture;

    Client(String nom, Cafe commandeCafe, boolean avecTasse) {
        this.nom = nom;
        this.commandeCafe = commandeCafe;

        if (avecTasse) {
            this.tasse = new Tasse(100);
        } else {
            this.tasse = null;
        }
    }

    Client(String nom, Cafe commandeCafe, Tasse tasse) {
        this.nom = nom;
        this.commandeCafe = commandeCafe;
        this.tasse = tasse;
    }

    Client() {
        this.nom = "Jean";
        this.tasse = new Tasse(100);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
