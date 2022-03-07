package Aufgaben.BZT4;
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
        String vorstellung = "Guten Tag, ich heisse " + getNachname() + "Von der class" + this.getClass();
        return vorstellung;
    }

}
