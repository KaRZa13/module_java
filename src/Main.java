import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Instanciation des 3 restaurants
        Restaurant resto1 = new Restaurant("Latte sur les rochers");
        Restaurant resto2 = new Restaurant("Une tasse de joie");
        Restaurant resto3 = new Restaurant("Le Restaurant");

        System.out.println("Restaurant 1: " + resto1.nom);
        System.out.println("Restaurant 2: " + resto2.nom);
        System.out.println("Restaurant 3: " + resto3.nom);

        // Banques de données pour la génération aléatoire
        String[] listeNoms = {
                "Alice", "Bob", "Charlie", "David", "Emma",
                "Frank", "Grace", "Henry", "Iris", "Jack",
                "Kate", "Liam", "Maria", "Noah", "Olivia",
                "Paul", "Quinn", "Rose", "Sam", "Tina"
        };

        Cafe[] listeCommandes = {
                new Cafe(TypeCafe.JAVA, 100),
                new Cafe(TypeCafe.MOKA, 150),
                new Cafe(TypeCafe.TYPICA, 200),
                new Cafe(TypeCafe.BOURBON, 250),
                new Cafe(TypeCafe.BATARD, 100),
                null  // Commande nulle (client sans commande)
        };

        Tasse[] listeTasses = {
                new Tasse(100),
                new Tasse(200),
                new Tasse(500),
                null  // Pas de tasse
        };

        Random random = new Random();

        // Génération de 20 clients pour listeClient1
        ArrayList<Client> listeClient1 = new ArrayList<Client>();
        for (int i = 0; i < 20; i++) {
            String nom = listeNoms[random.nextInt(listeNoms.length)];
            Cafe commande = listeCommandes[random.nextInt(listeCommandes.length)];
            Tasse tasse = listeTasses[random.nextInt(listeTasses.length)];
            listeClient1.add(new Client(nom, commande, tasse));
        }

        // Génération de 20 clients pour listeClient2
        ArrayList<Client> listeClient2 = new ArrayList<Client>();
        for (int i = 0; i < 20; i++) {
            String nom = listeNoms[random.nextInt(listeNoms.length)];
            Cafe commande = listeCommandes[random.nextInt(listeCommandes.length)];
            Tasse tasse = listeTasses[random.nextInt(listeTasses.length)];
            listeClient2.add(new Client(nom, commande, tasse));
        }

        // Génération de 20 clients pour listeClient3
        ArrayList<Client> listeClient3 = new ArrayList<Client>();
        for (int i = 0; i < 20; i++) {
            String nom = listeNoms[random.nextInt(listeNoms.length)];
            Cafe commande = listeCommandes[random.nextInt(listeCommandes.length)];
            Tasse tasse = listeTasses[random.nextInt(listeTasses.length)];
            listeClient3.add(new Client(nom, commande, tasse));
        }

        // Liste des clients expulsés
        ArrayList<Client> listeClientsExpulse = new ArrayList<Client>();

        System.out.println("\n=== Clients générés ===");
        System.out.println("Liste 1: " + listeClient1.size() + " clients");
        System.out.println("Liste 2: " + listeClient2.size() + " clients");
        System.out.println("Liste 3: " + listeClient3.size() + " clients");

        // Étape 4 : Servir tous les clients
        System.out.println("\n=== Service des clients ===\n");

        // Tableau des restaurants pour sélection aléatoire
        Restaurant[] restaurants = {resto1, resto2, resto3};

        // Servir les clients de listeClient1
        for (Client client : listeClient1) {
            Restaurant restoChoisi = restaurants[random.nextInt(restaurants.length)];
            float montant = restoChoisi.servir(client);

            if (montant == 0) {
                // Client expulsé
                listeClientsExpulse.add(client);
            } else {
                // Client servi avec succès
                restoChoisi.listeClientServi.add(client);
            }
            System.out.println();
        }

        // Servir les clients de listeClient2
        for (Client client : listeClient2) {
            Restaurant restoChoisi = restaurants[random.nextInt(restaurants.length)];
            float montant = restoChoisi.servir(client);

            if (montant == 0) {
                // Client expulsé
                listeClientsExpulse.add(client);
            } else {
                // Client servi avec succès
                restoChoisi.listeClientServi.add(client);
            }
            System.out.println();
        }

        // Servir les clients de listeClient3
        for (Client client : listeClient3) {
            Restaurant restoChoisi = restaurants[random.nextInt(restaurants.length)];
            float montant = restoChoisi.servir(client);

            if (montant == 0) {
                // Client expulsé
                listeClientsExpulse.add(client);
            } else {
                // Client servi avec succès
                restoChoisi.listeClientServi.add(client);
            }
            System.out.println();
        }

        // Étape 5 : Exposition des résultats
        System.out.println("\n╔════════════════════════════════════════════════════════════╗");
        System.out.println("║           RÉSULTATS FINAUX DES RESTAURANTS                 ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝\n");

        // Afficher les résultats de chaque restaurant
        System.out.println("Restaurant: " + resto1.nom);
        System.out.println("  • Profit total: " + resto1.profit + " €");
        System.out.println("  • Nombre de clients servis: " + resto1.listeClientServi.size());
        System.out.println();

        System.out.println("Restaurant: " + resto2.nom);
        System.out.println("  • Profit total: " + resto2.profit + " €");
        System.out.println("  • Nombre de clients servis: " + resto2.listeClientServi.size());
        System.out.println();

        System.out.println("Restaurant: " + resto3.nom);
        System.out.println("  • Profit total: " + resto3.profit + " €");
        System.out.println("  • Nombre de clients servis: " + resto3.listeClientServi.size());
        System.out.println();

        // Afficher les clients expulsés
        System.out.println("─────────────────────────────────────────────────────────────");
        System.out.println("CLIENTS EXPULSÉS");
        System.out.println("─────────────────────────────────────────────────────────────");
        System.out.println("Nombre total de clients expulsés: " + listeClientsExpulse.size());

        if (listeClientsExpulse.size() > 0) {
            System.out.println("\nListe des clients expulsés:");
            for (Client client : listeClientsExpulse) {
                System.out.println("  • " + client.nom);
            }
        } else {
            System.out.println("Aucun client expulsé!");
        }

        System.out.println("\n═════════════════════════════════════════════════════════════");
    }
}