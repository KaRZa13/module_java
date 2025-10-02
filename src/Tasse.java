public class Tasse {
    float quantiteCafeMax;
    Cafe cafe;

    public Tasse() {
        this.quantiteCafeMax = 100;
        this.cafe = null;
    }

    public Tasse(float quantiteCafeMax) {
        this.quantiteCafeMax = quantiteCafeMax;
        this.cafe = null;
    }

    public void boire(double quantite) {
        this.cafe.quantiteLiquideMl -= quantite;
    }

    public void boire() {
            this.cafe.quantiteLiquideMl = 0;
    }
}