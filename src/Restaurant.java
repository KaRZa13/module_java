public class Restaurant {
    Cafetiere cafetiere;
    float profit;

    Restaurant() {
        this.cafetiere = new Cafetiere();
    }
    public float servir(Client client) {
        if (client.commandeCafe == null || client.commandeCafe.typeCafe == TypeCafe.BATARD) {
            client.valeurFacture = 0;
            System.out.println("Dégage de mon restaurant !");
            return 0;
        }

        // Initialisation de la facture
        client.valeurFacture = 0;

        // Attribution d'une tasse si nécessaire
        if (client.tasse == null) {
            if (client.commandeCafe.quantiteLiquideMl > 100) {
                client.tasse = new Tasse(500);
                client.valeurFacture += 3;
            } else {
                client.tasse = new Tasse(100);
                client.valeurFacture += 2;
            }
        }

        // Sauvegarde du type de café existant avant ajout
        TypeCafe typeCafeExistant = (client.tasse.cafe != null) ? client.tasse.cafe.typeCafe : null;

        // Ajout du café dans la tasse
        cafetiere.remplirTasse(client.tasse, client.commandeCafe.typeCafe, client.commandeCafe.quantiteLiquideMl);

        // Vérification du conflit de type après ajout
        if (typeCafeExistant != null && typeCafeExistant != client.commandeCafe.typeCafe) {
            client.tasse.cafe.typeCafe = TypeCafe.BATARD;
            client.valeurFacture = 0;
            System.out.println("Dégage de mon restaurant !");
            return 0;
        }

        // Vérification de la quantité de café
        if (client.commandeCafe.quantiteLiquideMl > client.tasse.quantiteCafeMax) {
            System.out.println("Trop de café le frère, je te remplis ta tasse à ras bord");
        }

        this.profit += client.valeurFacture;
        return client.valeurFacture;
    }
}
