package Aufgaben.BZT4;
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
        String vorstellung = "Guten Tag, ich heisse " + getNachname() + "! von der class " + this.getClass() 
                            + ". Ich lehre " + getFachbereich() + " und meine Personalnummer ist " + getPersonalnummer();
        return vorstellung; 
    }
}
