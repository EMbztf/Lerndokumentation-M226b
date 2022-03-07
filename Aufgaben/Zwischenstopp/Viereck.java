package Aufgaben.Zwischenstopp;

public class Viereck extends GeomObject{
    private double seiteA;
    private double seiteB;

    public Viereck(double seiteA, double seiteB) {
        this.seiteA = seiteA;
        this.seiteB = seiteB;
        berechneFlaeche();
        berechneUmfang();
    }

    public void berechneUmfang() {
        setUmfang(2 * seiteA + 2 * seiteB);
    }

    public void berechneFlaeche() {
        setFleache(seiteA * seiteB);
    }

    public String vorstellen() {
        return super.vorstellen() + " und das Ganze als " + this.getClass();
    }   

}
