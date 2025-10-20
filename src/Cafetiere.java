public class Cafetiere {

    public Cafetiere() {}

    public void remplirTasse(Tasse tasse) {
        tasse.cafe.quantiteLiquideMl = tasse.quantiteCafeMax;
    }

    public void remplirTasse(Tasse tasse, TypeCafe typeCafe, float quantite) {
        tasse.cafe.typeCafe = typeCafe;
        tasse.cafe.quantiteLiquideMl = quantite;
    }
}
