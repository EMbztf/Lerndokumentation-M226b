package Aufgaben.BZT3;

public class App
{
    public static void main(String[] args)
    {
        Person p1 = new Person();
        p1.setNachname("Muster");

        Lernende lernende1 = new Lernende();
        lernende1.setNachname("Moritz");
        lernende1.setNummer(4711);
        
        Lehrer lehrer1 = new Lehrer();
        lehrer1.setNachname("Lempel");
        lehrer1.setFachbereich("RitschRatschMühle");
        lehrer1.setPersonalnummer(12345);

        Angestellte a1 = new Angestellte();
        a1.setNachname("Verwalti");
        a1.setPersonalnummer(54321);
        a1.setSchulleitung(true);

        System.out.println("Ich heisse " + p1.getNachname());
        System.out.println(lernende1.vorstellen());
        System.out.println(lehrer1.vorstellen());
        System.out.println(a1.vorstellen());
    }
}
