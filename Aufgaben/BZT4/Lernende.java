package Aufgaben.BZT4;
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
        String vorstellung = "Guten Tag, ich heisse " + getNachname() + "! Von der class " + this.getClass() + ". Meine LernendeNr ist " + getNummer();
        return vorstellung; 
    }
}
