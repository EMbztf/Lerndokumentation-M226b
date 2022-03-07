### Aufgabenstellung
Erstellen eines Interfaces (wie eine normale Javaklasse). Nennen Sie das Interface Eatable:

```java
public interface Eatable
{
    int inKantine();
    String Bewertung();
}
```

Schreiben Sie folgenden Code in der Klasse Lernende (und auf den anderen Klassen sinngemäss):

```java
@Override
public int inKantine()
{
    int zufallszahl;
    zufallszahl = (int)(Math.random() * 10);
    // System.out.println(zufallszahl);
    return zufallszahl;
}

@Override
public String Bewertung()
{
    if (inKantine() > 5)
    {
        int zufallszahl;
        zufallszahl = (int)(Math.random() * 10);
        // System.out.println(zufallszahl);
        if (zufallszahl >= 5)
        {
            return "War akzeptabel";
        }
        else
        {   
            return "Hat Verbesserungspotential!";
        }
    }
    else
    {
        return "War nicht in Mensa!";
    }
}
```

### Lösung

> Klasse Person

```java
public abstract class Person implements Eatable {
    protected final double MINPREIS = 2.50;
    public abstract double kantineKonsum(int anzahl);
    protected String nachname = new String();
    private Person ehepartner = null;

    protected Person(String nachname) {
        this.nachname = nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getNachname() {
        return nachname;
    }

    public String vorstellen() {        
        return "Guten Tag, ich heisse " + getNachname() + "! Von der Klasse " + this.getClass().getSimpleName();
    }

    protected void heiraten(Person ehepartner) {
        if (this != ehepartner) {
            if(this.ehepartner == null && ehepartner.ehepartner == null) {
                this.ehepartner = ehepartner; 
                ehepartner.ehepartner = this; 

                System.out.println(nachname + " und " + ehepartner.getNachname() + " haben geheiratet.");
            } else {
                System.out.println(nachname + " und " + ehepartner.getNachname() + " können nicht heiraten, " + "weil mindestens einer bereits verheiratet ist!");
            }
        } else {
            System.out.println(nachname + " kann sich nicht selber heiraten!");
        }
    }

    protected void scheiden() {
        if(ehepartner != null) {
            System.out.println(nachname + " und " + ehepartner.getNachname() + " sind jetzt geschieden.");
            ehepartner.ehepartner = null;
            ehepartner = null;
        } else {
            System.out.println(nachname + " kann sich nicht selber scheiden, weil er nicht verheiratet ist!");
        }

    }

    @Override
    public String toString() {
        return nachname + "(Attributquelle: Klasse " + this.getClass().getName() + ") - " + getClass() + ".";    
    }

    @Override 
    public boolean equals(Object einAnderesObject) {
        if(this == einAnderesObject) {
            return true;
        } 

        if(einAnderesObject.getClass() == getClass() 
                && this.hashCode() == ((Person) einAnderesObject).hashCode()) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return nachname.hashCode();
    }

}
```

> Klasse Angestellte

```java
public class Angestellte extends Mitarbeiter {
    private boolean schulleitung;

    public Angestellte(String nachname) {
        super(nachname);
    }

    public Angestellte(String nachname, int personalnummer, boolean schulleitung) {
        super(nachname, personalnummer);
        this.schulleitung = schulleitung;
    }

    public boolean isSchulleitung() {
        return schulleitung;
    }

    public void setSchulleitung(boolean schulleitung) {
        this.schulleitung = schulleitung;
    }

    public String vorstellen() {
        String vorstellung = super.vorstellen() + ". Mein Personalnummer ist " + getPersonalnummer();
        if(isSchulleitung()) {
            vorstellung += " und ich bin Schulleitungsmitglied.";
        } else {
            vorstellung += " und ich bin einfacher Angestellter";
        }
        
        return vorstellung; 
    }

    @Override
    public String toString() {
        return super.toString() + " - Personalnummer: " + personalnummer + " (Attributquelle: Klasse " + this.getClass().getName() + ")." 
                                + " - In Schulleitung?: " + isSchulleitung();
    }

    @Override
    public int hashCode() {
        return nachname.hashCode();
    }

    public double kantineKonsum(int anzahl)
    {
        double zuBezahlen = anzahl * MINPREIS * 0.9;
        double mindestPreis = MINPREIS * 4;
        if(zuBezahlen > mindestPreis) {
            return zuBezahlen; 
        } else {
            return mindestPreis;
        }
    }

    @Override
    public int inKantine()
    {
        int zufallszahl;
        zufallszahl = (int)(Math.random() * 10);
        return zufallszahl;
    }

    @Override
    public String Bewertung()
    {
        if (inKantine() > 5)
        {
            int zufallszahl;
            zufallszahl = (int)(Math.random() * 10);
            if (zufallszahl >= 5)
            {
                return "War akzeptabel";
            }
            else
            {   
                return "Hat Verbesserungspotential!";
            }
        }
        else
        {
            return "War nicht in die Mensa!";
        }
    }
}
```

> Klasse Lehrer

```java
public class Lehrer extends Mitarbeiter {
    private String fachbereich = new String(); 

    public Lehrer(String nachname, int personalnummer, String fachbereich) {
        super(nachname, personalnummer);
        this.fachbereich = fachbereich;
    }
                           
    public void setFachbereich(String fachbereich)
    {
        this.fachbereich = fachbereich;
    }

    public String getFachbereich()
    {
        return fachbereich;
    }

    public String vorstellen() {
        return super.vorstellen()  + ". Ich lehre " + getFachbereich() + " und meine Personalnummer ist " + getPersonalnummer();
    }

    @Override
    public String toString() {
        return super.toString() + " - Fachbereich: " + getFachbereich() + " (Attributquelle: Klasse " + this.getClass().getName() + ").";
    }

    @Override
    public int hashCode() {
        return fachbereich.hashCode();
    }

    public double kantineKonsum(int anzahl)
    {
        double zuBezahlen = anzahl * MINPREIS * 0.9;
        double mindestPreis = MINPREIS * 8;
        if(zuBezahlen > mindestPreis) {
            return zuBezahlen; 
        } else {
            return mindestPreis;
        }
    }

    @Override
    public int inKantine()
    {
        int zufallszahl;
        zufallszahl = (int)(Math.random() * 10);
        return zufallszahl;
    }

    @Override
    public String Bewertung()
    {
        if (inKantine() > 5)
        {
            int zufallszahl;
            zufallszahl = (int)(Math.random() * 10);
            if (zufallszahl >= 5)
            {
                return "War in Ordnung";
            }
            else
            {   
                return "Hat Verbesserungspotential!";
            }
        }
        else
        {
            return "War nicht in die Mensa!";
        }
    }
}
```

> Klasse Lernender

```java
public class Lernende extends Person {

    private int nummer;  

    public Lernende(String nachname) {
        super(nachname);
    }

    public void setNummer(int nummer)
    {
        this.nummer = nummer;
    }

    public int getNummer()
    {
        return nummer;
    }  

    public String vorstellen() {
        
        return super.vorstellen() + ". Meine LernendeNr ist " + getNummer();
    }

    @Override
    public String toString() {
        return super.toString() + " - Nummer: " + getNummer() + " (Attributquelle: Klasse " + getClass().getName() + ").";
    }

    @Override
    public int hashCode() {
        return Integer.valueOf(nummer).hashCode();
    }

    public double kantineKonsum(int anzahl)
    {
        return anzahl * MINPREIS * 0.9; 
    }

    @Override
    public int inKantine()
    {
        int zufallszahl;
        zufallszahl = (int)(Math.random() * 10);
        return zufallszahl;
    }

    @Override
    public String Bewertung()
    {
        if (inKantine() > 5)
        {
            int zufallszahl;
            zufallszahl = (int)(Math.random() * 10);
            if (zufallszahl >= 5)
            {
                return "War akzeptabel";
            }
            else
            {   
                return "Hat Verbesserungspotential!";
            }
        }
        else
        {
            return "War nicht in Mensa!";
        }
    }
}
```

> Klasse App

```java
public class App
{
    public static void main(String[] args)
    {

        Lernende einLernender = new Lernende("Lernender");
        Angestellte eineAngestellte = new Angestellte("Angestellte");

        System.out.println(einLernender.Bewertung());
        System.out.println(einLernender.Bewertung());
        System.out.println(eineAngestellte.Bewertung());
    }
}
```