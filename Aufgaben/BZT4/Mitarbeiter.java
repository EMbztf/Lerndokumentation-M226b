package Aufgaben.BZT4;

public class Mitarbeiter extends Person {
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
        String vorstellung = "Guten Tag ichm heisse " + getNachname() + "! Von der class " + this.getClass();
        return vorstellung;
    }
}
