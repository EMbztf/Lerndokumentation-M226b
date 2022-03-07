package Aufgaben.BZT5;
public class Person {
    protected String nachname = new String();

    protected Person(String nachname)
    {
        this.nachname = nachname;
    }

    public void setNachname(String nachname)
    {
        this.nachname = nachname;
    }

    public String getNachname()
    {
        return nachname;
    }

    public String vorstellen() {        
        return "Guten Tag, ich heisse " + getNachname() + "! Von der Klasse " + this.getClass().getSimpleName();
    }

}
