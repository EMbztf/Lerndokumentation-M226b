package Aufgaben.BZT9;

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
