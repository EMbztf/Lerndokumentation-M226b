package Aufgaben.BZT5;

public class App
{
    public static void main(String[] args)
    {
        Person p1 = new Person("Warner Brother");
        Lehrer lehrer1 = new Lehrer("Lempel Zip", 0, "Informatik");
        Lernende lernende1 = new Lernende("Heinri Lern");
        lernende1.setNummer(7890);
        Angestellte a1 = new Angestellte("Hans Schläffrig", 345, false);
        Angestellte a2 = new Angestellte("Anna Schaffig", 0, true);

        System.out.println(p1.vorstellen());
        System.out.println(lehrer1.vorstellen());
        System.out.println(lernende1.vorstellen());
        System.out.println(a1.vorstellen());
        System.out.println(a2.vorstellen());
    }
}
