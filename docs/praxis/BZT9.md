### Aufgabenstellung

Wir wollen nun eine Methode kantineKonsum() programmieren (auf der Klasse Person).
- Alle sind verpflichtet in der BZT-Kantine zu einem bestimmten Preis etwas zu konsumieren.
- Entsprechend der Klassen gibt es Unterschiede
- Ebenso gibt es einen minimalen Preis, welche alle pro Tag zu bezahlen haben.
Erweitern Sie die Klasse Person um folgenden Code:

```java
// Hier haben wir eine Variable final gemacht, also eine Konstante
protected final double MINPREIS = 2.50;
// Abstrakte Methode, alle Subklassen müssen das implementieren
public abstract double kantineKonsum(int anzahl);
// So läuft es nicht, da nun die ganze Klasse
// wegen dieser Methode abstract ist.
```

Schlussendlich erhalten Sie mehrere Fehlermeldungen:

1. Die Klasse Person muss zwingend als gesamte Klasse abstrakt werden
2. Überall dort, wo von der Klasse Person geerbt wird, !muss! die Methode implementiert werden

Methode kantineKonsum():

```java
public double kantineKonsum(int anzahl)
{
    // Erhalten 10 % Rabatt
    return anzahl * MINPREIS * 0.9; 
}
```

Jetzt müssen Sie einen Mindestkonsum in der Kantine machen:

- Lehrperson müssen mindestens 8-fache des Mindestpreises konsumieren
- Angestellte müssen mindestens das 4-fache des Mindestpreises konsumieren
Setzen Sie das in Ihrem Programm um.

### Lösung

> Klasse Person

```java
public abstract class Person {
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

> Klasse Mitarbeiter

```java
public abstract class Mitarbeiter extends Person {
    protected int personalnummer;

    protected Mitarbeiter(String nachname) {
        this(nachname, 0);
    }

    protected Mitarbeiter(String nachname, int personalnummer) {
        super(nachname);
        this.personalnummer = personalnummer;
    }

    public int getPersonalnummer() {
        return personalnummer;
    }

    public void setPersonalnummer(int personalnummer) {
        this.personalnummer = personalnummer;
    }

    public String vorstellen() {
        return super.vorstellen() + " Meine Personalnummer ist " + getPersonalnummer();
    }


    @Override
    public String toString() {
        return super.toString() + " - Personalnummer: " + personalnummer + " (Attributquelle: Klasse " + this.getClass().getName() + ").";
    }

    @Override
    public int hashCode() {
        return Integer.valueOf(personalnummer).hashCode();
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
}
```

> Klasse App

```java
public class App
{
    public static void main(String[] args)
    {
        Angestellte eineAngestellte = new Angestellte("angestellte");
        Lehrer einLehrer = new Lehrer("Lehrer", 0, "Informatik");
        Lernende einLernender = new Lernende("Lernender");

        System.out.println("Bitte als Angestellte Fr.  " + 
                    eineAngestellte.kantineKonsum(3) + " bezahlen");
        System.out.println("Bitte als Lehrer Fr.  " + 
                    einLehrer.kantineKonsum(5) + " bezahlen");

        System.out.println("Bitte als Lernender Fr.  " + 
                    einLernender.kantineKonsum(7) + " bezahlen");   
    }
}
```