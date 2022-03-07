package Aufgaben.BZT8;

public class App
{
    public static void main(String[] args)
    {
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
