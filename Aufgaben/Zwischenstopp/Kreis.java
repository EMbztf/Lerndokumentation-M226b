package Aufgaben.Zwischenstopp;

public class Kreis extends GeomObject {
    private double radius;

    public Kreis(double radius) {
        this.radius = radius;
        berechneFlaeche();
        berechneUmfang();
    }

    public void berechneUmfang() {
        this.setUmfang(2 * Math.PI * radius); 
    }

    public void berechneFlaeche() {
        this.setFleache(Math.PI * Math.pow(radius, 2));
    }

    public String vorstellen() {
        return super.vorstellen() + " und das Ganze als " + this.getClass();
    }

}
