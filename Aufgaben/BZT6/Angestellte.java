package Aufgaben.BZT6;

public class Angestellte extends Mitarbeiter {
    private boolean schulleitung;

    public Angestellte(String nachname) {
        super(nachname);
    }

    public Angestellte(String nachname, int personalnummer, boolean schulleitung) {
        super(nachname, personalnummer);
        this.schulleitung = schulleitung;
    }

    public boolean isSchulleitung() {
        return schulleitung;
    }

    public void setSchulleitung(boolean schulleitung) {
        this.schulleitung = schulleitung;
    }

    public String vorstellen() {
        String vorstellung = super.vorstellen() + ". Mein Personalnummer ist " + getPersonalnummer();
        if(isSchulleitung()) {
            vorstellung += " und ich bin Schulleitungsmitglied.";
        } else {
            vorstellung += " und ich bin einfacher Angestellter";
        }
        
        return vorstellung; 
    }
}
