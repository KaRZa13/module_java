import java.util.ArrayList;

public class Classlist {
    int monInt;
    String monString;
    double monDouble;

    Classlist(int monInt, String monString, double monDouble) {
        this.monInt = monInt;
        this.monString = monString;
        this.monDouble = monDouble;
    }

    @Override
    public String toString() {
        return "Classlist{" +
                "monInt=" + monInt +
                ", monString='" + monString + '\'' +
                ", monDouble=" + monDouble +
                '}';
    }
}



void main() {
    Classlist obj1 = new Classlist(5, "Bonjour", 3.14);
    Classlist obj2 = new Classlist(6, "Salut", 2.71);
    Classlist obj3 = new Classlist(3, "Coucou", 1.61);
    Classlist obj4 = new Classlist(2, "Hello", 0.57);
    Object[] monTableau = {obj1, obj2, obj3, obj4};

    System.out.println(Arrays.toString(monTableau));

    ArrayList<Classlist> maListe = new ArrayList<>();
    maListe.add(obj1);
    maListe.add(obj2);
    maListe.add(obj3);
    maListe.add(obj4);

    System.out.println(maListe);


    Map<Classlist, Integer> maMape = new HashMap<>();
    maMape.put(obj1, 1);
    maMape.put(obj2, 2);
    maMape.put(obj3, 3);
    maMape.put(obj4, 4);

    System.out.println(maMape);

    double produit = maListe.stream()
            .mapToDouble(c -> c.monDouble)
            .reduce(1.0, (a, b) -> a * b);
    System.out.println("Produit des doubles: " + produit);

    maListe.forEach(c -> c.monString = c.monString + "e");
    List<String> strings = maListe.stream()
            .map(c -> c.monString)
            .toList();
    System.out.println("Après ajout de 'e': " + strings);

    maListe.stream()
            .min((c1, c2) -> Integer.compare(c1.monInt, c2.monInt))
            .ifPresent(c -> System.out.println("Plus petit int: " + c.monInt));

    maListe.stream()
            .max((c1, c2) -> Integer.compare(c1.monString.length(), c2.monString.length()))
            .ifPresent(c -> System.out.println("Plus long String: " + c.monString));
}
