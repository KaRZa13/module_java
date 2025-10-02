public class Tasse {
    float quantiteCafeMax;
    Cafe cafe;

    public Tasse() {
        this.quantiteCafeMax = 100;
        this.cafe = new Cafe();
    }

    public Tasse(float quantiteCafeMax) {
        this.quantiteCafeMax = quantiteCafeMax;
        this.cafe = new Cafe();
    }

    public void boire(double quantite) {
        this.cafe.quantiteLiquideMl -= quantite;
    }

    public void boire() {
            this.cafe.quantiteLiquideMl = 0;
    }
}