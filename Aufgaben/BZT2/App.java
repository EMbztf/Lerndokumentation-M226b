package Aufgaben.BZT2;

public class App
{
    public static void main(String[] args)
    {
        Person person = new Person();
        person.setNachname("Muster");

        Lernende lernende = new Lernende();
        lernende.setNachname("Moritz");
        lernende.setNummer(4711);

        Lehrer lehrer = new Lehrer();
        lehrer.setNachname("Lempel");
        lehrer.setFachbereich("RitschRatschMühle");     

        System.out.println("Ich heisse " + person.getNachname());
        System.out.println("Ich heisse " + lernende.getNachname() + ". Meine Nummer ist " + lernende.getNummer());
        System.out.println("Ich heisse " + lehrer.getNachname() + ". Ich bin Lehrer für " + lehrer.getFachbereich());
    }
}
