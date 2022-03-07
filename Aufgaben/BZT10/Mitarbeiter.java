package Aufgaben.BZT10;

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
