package Aufgaben.BZT8;
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
}
