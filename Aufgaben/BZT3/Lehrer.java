package Aufgaben.BZT3;
public class Lehrer extends Mitarbeiter {
    private String fachbereich = new String(); 
                           
    public void setFachbereich(String fachbereich)
    {
        this.fachbereich = fachbereich;
    }

    public String getFachbereich()
    {
        return fachbereich;
    }

    public String vorstellen() {
        String vorstellung = "Guten Tag, ich heisse " + getNachname()
                            + ". Ich lehre " + getFachbereich() 
                            + " und meine Personalnummer ist " + getPersonalnummer();
        return vorstellung; 
    }
}
