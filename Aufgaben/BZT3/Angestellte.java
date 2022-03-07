package Aufgaben.BZT3;

public class Angestellte extends Mitarbeiter {
    boolean schulleitung;

    public boolean isSchulleitung() {
        return schulleitung;
    }

    public void setSchulleitung(boolean schulleitung) {
        this.schulleitung = schulleitung;
    }

    public String vorstellen() {
        String vorstellung = "Guten Tag, ich heisse " + getNachname()
                            + ". Mein Personalnummer ist " + getPersonalnummer();
        if(isSchulleitung()) {
            vorstellung += " und ich bin Schulleitungsmitglied.";
        }
        
        return vorstellung; 
    }
}
