package Aufgaben.BZT2;

public class Lehrer extends Person{
    private String fachbereich = new String(); // ein String ist eine Klasse, 
                                            // das geht deshalb mit new!
    public void setFachbereich(String fachbereich)
    {
        this.fachbereich = fachbereich;
    }

    public String  getFachbereich()
    {
        return fachbereich;
    }
}
