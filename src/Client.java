public class Client {
    Tasse tasse;
    Cafe commandeCafe;
    private String nom;
    float valeurFacture;

    Client(String nom, Cafe commandeCafe, boolean avecTasse) {
        this.nom = nom;
        this.commandeCafe = commandeCafe;
        this.valeurFacture = 0;

        if (avecTasse) {
            this.tasse = new Tasse(100);
        } else {
            this.tasse = null;
        }
    }

    Client(String nom, Cafe commandeCafe, Tasse tasse) {
        this(nom, commandeCafe, true);
    }

    Client() {
        this("Jean", new Cafe(TypeCafe.MOKA, 100), true);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
