package Aufgaben.BZT9;

public class App
{
    public static void main(String[] args)
    {
        Angestellte eineAngestellte = new Angestellte("angestellte");
        Lehrer einLehrer = new Lehrer("Lehrer", 0, "Informatik");
        Lernende einLernender = new Lernende("Lernender");

        System.out.println("Bitte als Angestellte Fr.  " + 
                    eineAngestellte.kantineKonsum(3) + " bezahlen");
        System.out.println("Bitte als Lehrer Fr.  " + 
                    einLehrer.kantineKonsum(5) + " bezahlen");

        System.out.println("Bitte als Lernender Fr.  " + 
                    einLernender.kantineKonsum(7) + " bezahlen");   
    }
}
