package Aufgaben.BZT7;

public class App
{
    public static void main(String[] args)
    {
        // Angestellte eineAngestellte = new Angestellte("Anna Schaffig", 0, true);
        // Angestellte einAngestellter = new Angestellte("Hans Schläffrig", 345, false);
        // Lehrer einLehrer = new Lehrer("Lempel Zip", 0, "Informatik");
        // Lernende einLernender = new Lernende("Heini Lern");
        // einLernender.setNummer(7890);
        // Person einePerson = new Person("Warner Brother");

        // System.out.println("\nVorstellung:");
        // System.out.println(eineAngestellte.toString() + "\n");               
        // System.out.println(eineAngestellte + "\n");
        // System.out.println(einAngestellter + "\n");
        // System.out.println(einLehrer + "\n");
        // System.out.println(einLernender + "\n");
        // System.out.println(einePerson + "\n");

        // Person p1 = new Person("Hans");
        // Person p2 = new Person("Hans");

        // System.out.println(p1.equals(p2));

        Angestellte eineAngestellte = new Angestellte("Ann Schaffig");
        Angestellte einAngestellter = new Angestellte("Hans");
        
        System.out.println(eineAngestellte.equals(eineAngestellte));
        // Und das sollte was geben?
        System.out.println(eineAngestellte.equals(einAngestellter));
        // eine neue Instanz von Angestellte mit gleichem Namen machen, 
        // Das sollte was ergeben?
        Angestellte zweiteAngestellte = new Angestellte("Anna Schaffig");
        System.out.println(eineAngestellte.equals(zweiteAngestellte));
        // eine neue Instanz von Angestellte machen mit neuem Namen machen,
        // Das sollte was geben?
        Angestellte dritteAngestellte = new Angestellte("Hanna Schaffig");
        System.out.println(eineAngestellte.equals(dritteAngestellte));
    }
}
