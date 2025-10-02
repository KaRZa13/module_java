public class Cafe {
    TypeCafe typeCafe;
    float quantiteLiquideMl;

    Cafe() {
        this.typeCafe = TypeCafe.MOKA;
        this.quantiteLiquideMl = 100;
    }

    Cafe(TypeCafe typeCafe, float quantiteLiquideMl) {
        this.typeCafe = typeCafe;
        this.quantiteLiquideMl = quantiteLiquideMl;
    }
}