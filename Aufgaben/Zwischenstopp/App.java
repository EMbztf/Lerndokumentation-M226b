package Aufgaben.Zwischenstopp;

public class App {
    public static void main(String[] args)
    {
        Kreis k1 = new Kreis(3);
        Viereck v1 = new Viereck(3.5, 4);
        RechtwinkligesDreieck r1 = new RechtwinkligesDreieck(3, 4);

        System.out.println(k1.vorstellen());
        System.out.println(v1.vorstellen());
        System.out.println(r1.vorstellen());        
    }
}
