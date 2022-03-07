### Aufgabenstellung
Erstellen Sie ein Programm, dass Geometrische Objekte objektorientiert abbildet. Subklassen sind
Kreis, Viereck und rechtwinkliges Dreieck. Von allen Objekten soll der Umfang und Flaeche
berechnet werden. Auf allen Klassen soll eine vorstellen()-Methode einbaut werden (wie in
BZT4). Stellen Sie das Klassendiagramm mit PlantUML dar.

Mit folgender Beispiel Ausgabe:

```
Ich bin ein Geom-Object - Meine Flaeche ist 38.48451000647496 und mein Umfang ist 21.991148575128552...und das Ganze als Kreis
Ich bin ein Geom-Object - Meine Flaeche ist 8.75 und mein Umfang ist 12.0...und das Ganze als Viereck.
Ich bin ein Geom-Object - Meine Flaeche ist 9.0 und mein Umfang ist 6.708203932499369...und das Ganze als RechtWinkligesDreieck
```

### Lösung

> Klasse Geom-Object

```java
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
```

> Klasse Kreis

```java
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
```

> Klasse Viereck

```java
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
```

> Klasse RechtwinkligesDreieck

```java
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
```

> Klasse App

```java
public class App {
    public static void main(String[] args)
    {
        Kreis k1 = new Kreis(3);
        Viereck v1 = new Viereck(3.5, 4);
        RechtwinkligesDreieck r1 = new RechtwinkligesDreieck(3, 4);

        System.out.println(k1.vorstellen());
        System.out.println(v1.vorstellen());
        System.out.println(r1.vorstellen());        
    }
}
```
