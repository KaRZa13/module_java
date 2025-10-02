public class Moteur {
    float vitesseMax;

    public Moteur(float vitesseMax) {
        this.vitesseMax = vitesseMax;
    }

    public void demarrer() {
        System.out.println("Moteur démarré");
    }
}

public class Vehicule extends Moteur {
    String modele;
    int annee;

    public Vehicule() {
        super(180);
        this.modele = "Inconnu";
        this.annee = 2000;
    }

    @Override
    public String toString() {
        return ("Vitesse max : " + vitesseMax + " Modèle : " + modele + " Année : " + annee);
    }
}

public class Voiture extends Vehicule {
    int nombrePortes;
    boolean estElectrique;

    public Voiture() {
        super();
        this.nombrePortes = 4;
        this.estElectrique = false;
    }

    @Override
    public String toString() {
        return (super.toString() + " Nombre de portes : " + nombrePortes + " Est électrique : " + estElectrique);
    }
}

public class Moto extends Vehicule {
    boolean aSidecar;

    public Moto() {
        super();
        this.aSidecar = false;
    }

    @Override
    public String toString() {
        return (super.toString() + " A sidecar : " + aSidecar);
    }
}

void main() {
    List<Moteur> liste = new ArrayList<>();

    Moteur moteur = new Moteur(400);
    Vehicule vehicule = new Vehicule();
    Voiture voiture = new Voiture();
    Moto moto = new Moto();

    liste.add(moteur);
    liste.add(vehicule);
    liste.add(voiture);
    liste.add(moto);

    for (Moteur vroom : liste) {
        vroom.demarrer();
    }


}
