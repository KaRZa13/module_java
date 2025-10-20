public class Tasse {
    float quantiteCafeMax;
    Cafe cafe;

    public Tasse() {
        this.cafe = new Cafe();
        this.quantiteCafeMax = 100;
    }

    public Tasse(float quantiteCafeMax) {
        this.quantiteCafeMax = quantiteCafeMax;
        this.cafe = new Cafe();
        this.cafe.quantiteLiquideMl = 0;
    }

    public double boire(double quantite) {
        cafe.quantiteLiquideMl -= quantite ;
        return cafe.quantiteLiquideMl;
    }

    public double boire() {
        cafe.quantiteLiquideMl = 0;
        return 0;
    }
}