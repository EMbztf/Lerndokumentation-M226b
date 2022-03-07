package Aufgaben.Zwischenstopp;

public class GeomObject {
    protected double fleache;
    protected double umfang;

    public double getFleache() {
        return fleache;
    }

    public void setFleache(double fleache) {
        this.fleache = fleache;
    }

    public double getUmfang() {
        return umfang;
    }

    public void setUmfang(double umfang) {
        this.umfang = umfang;
    }

    public String vorstellen() {
        String vorstellung = "Ich bin ein Geom-Object - Meine Fleache ist " + getFleache() 
        + " und mein Umfang ist " + getUmfang();

        return vorstellung;
    }
    
}
