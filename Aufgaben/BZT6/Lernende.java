package Aufgaben.BZT6;
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
        
        return super.vorstellen() + ". Meine LernendeNr ist " + getNummer();
    }
}
