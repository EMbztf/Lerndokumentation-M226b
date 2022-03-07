package Aufgaben.BZT6;

public class App
{
    public static void main(String[] args)
    {
        Person p1 = new Person("Hans Schläffrig");
        Person p2 = new Person("Lempel Zip");
        Person p3 = new Person("Anna Schaffig");
        Person p4 = new Person("Warner Brother");
        Person p5 = new Person("Heini Lern");

        p1.scheiden();
        p1.heiraten(p3);
        p2.heiraten(p3);
        p3.scheiden();
        p3.heiraten(p4);
        p5.heiraten(p5);
    }
}
