import java.util.ArrayList;

class Restaurant{
    Cafetiere cafetiere;
    float profit;
    ArrayList<Client> listeClientServi;
    String nom;

    Restaurant(){
        this.nom = "Le Restaurant";
        this.cafetiere = new Cafetiere();
        this.listeClientServi = new ArrayList<Client>();
    }

    Restaurant(String nom){
        this.nom = nom;
        this.cafetiere = new Cafetiere();
        this.listeClientServi = new ArrayList<Client>();
    }

    public float servir(Client client) {
        System.out.println("=== Servir client: " + client.nom + " ===");

        if (client.commandeCafe == null) {
            System.out.println("Le client " + client.nom + " a été jeté hors du restaurant!");
            client.valeurFacture = 0;
            return 0;
        }

        if (client.commandeCafe.typeCafe == TypeCafe.BATARD) {
            System.out.println("Le client " + client.nom + " a été jeté hors du restaurant!");
            client.valeurFacture = 0;
            return 0;
        }

        if (client.tasse == null) {
            System.out.println("Client sans tasse");
            if (client.commandeCafe.quantiteLiquideMl > 100) {
                client.valeurFacture += 3;
                profit += 3;
                client.tasse = new Tasse(500);
            } else {
                client.valeurFacture += 2;
                profit += 2;
                client.tasse = new Tasse(100);
            }
        }
        //DEBUG
        if (client.tasse.cafe != null) {
            System.out.println("Tasse a du café: type=" + client.tasse.cafe.typeCafe + ", quantité=" + client.tasse.cafe.quantiteLiquideMl + "ml");
        }
        System.out.println("Commande: type=" + client.commandeCafe.typeCafe + ", quantité=" + client.commandeCafe.quantiteLiquideMl + "ml");

        if (client.tasse.cafe != null && client.tasse.cafe.quantiteLiquideMl > 0 && client.tasse.cafe.typeCafe != client.commandeCafe.typeCafe) {
            System.out.println("Mélange de café détecté! Devient BATARD");
            client.commandeCafe.typeCafe = TypeCafe.BATARD;
        }

        float quantiteAServir = client.commandeCafe.quantiteLiquideMl;
        if (quantiteAServir > client.tasse.quantiteCafeMax) {
            System.out.println("La tasse de " + client.nom + " déborde! La quantité a été ajustée à " + client.tasse.quantiteCafeMax + "ml");
            cafetiere.remplirTasse(client.tasse, client.commandeCafe.typeCafe, client.tasse.quantiteCafeMax);
        } else {
            cafetiere.remplirTasse(client.tasse, client.commandeCafe.typeCafe, quantiteAServir);
        }

        float montantFacture = (float) (client.commandeCafe.quantiteLiquideMl * client.commandeCafe.typeCafe.getCoutParMl());
        System.out.println("Montant facturé: " + montantFacture);
        System.out.println("Profit total du resto: " + profit + " -> " + (profit + montantFacture));
        client.valeurFacture += montantFacture;
        profit += montantFacture;

        return montantFacture;
    }
}