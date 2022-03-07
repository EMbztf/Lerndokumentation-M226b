package Aufgaben.BZT10;

public class App
{
    public static void main(String[] args)
    {

        Lernende einLernender = new Lernende("Lernender");
        Angestellte eineAngestellte = new Angestellte("Angestellte");

        System.out.println(einLernender.Bewertung());
        System.out.println(einLernender.Bewertung());
        System.out.println(eineAngestellte.Bewertung());
    }
}
