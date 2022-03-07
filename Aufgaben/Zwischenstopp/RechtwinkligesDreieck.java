package Aufgaben.Zwischenstopp;

public class RechtwinkligesDreieck extends GeomObject {
    private double seiteA;
    private double seiteB;

    public RechtwinkligesDreieck(double seiteA, double seiteB) {
        this.seiteA = seiteA;
        this.seiteB = seiteB;
        berechneFlaeche();
        berechneUmfang();
    }

    public void berechneUmfang() {
        double seiteC = Math.sqrt(Math.pow(seiteA, 2) + Math.pow(seiteB, 2));
        setUmfang(seiteA + seiteB + seiteC);
    }

    public void berechneFlaeche() {
        setFleache(this.seiteA * seiteB / 2);
    }

    public String vorstellen() {
        return super.vorstellen() + " und das Ganze als " + this.getClass();
    }
}
