package Aufgaben.BZT3;
public class Lernende extends Person {

    private int nummer;  // Schülernummer

    public void setNummer(int nummer)
    {
        this.nummer = nummer;
    }

    public int getNummer()
    {
        return nummer;
    }  

    public String vorstellen() {
        String vorstellung = "Ich heisse " + getNachname()
                            + ". Meine Nummer ist " + getNummer();
        return vorstellung; 
    }
}
