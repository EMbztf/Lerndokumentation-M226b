package Aufgaben.BZT6;

public class Person {
    protected String nachname = new String();
    private Person ehepartner = null;

    protected Person(String nachname) {
        this.nachname = nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getNachname() {
        return nachname;
    }

    public String vorstellen() {        
        return "Guten Tag, ich heisse " + getNachname() + "! Von der Klasse " + this.getClass().getSimpleName();
    }

    protected void heiraten(Person ehepartner) {
        if (this != ehepartner) {
            if(this.ehepartner == null && ehepartner.ehepartner == null) {
                this.ehepartner = ehepartner; 
                ehepartner.ehepartner = this; 

                System.out.println(nachname + " und " + ehepartner.getNachname() + " haben geheiratet.");
            } else {
                System.out.println(nachname + " und " + ehepartner.getNachname() + " können nicht heiraten, " + "weil mindestens einer bereits verheiratet ist!");
            }
        } else {
            System.out.println(nachname + " kann sich nicht selber heiraten!");
        }
    }

    protected void scheiden() {
        if(ehepartner != null) {
            System.out.println(nachname + " und " + ehepartner.getNachname() + " sind jetzt geschieden.");
            ehepartner.ehepartner = null;
            ehepartner = null;
        } else {
            System.out.println(nachname + " kann sich nicht selber scheiden, weil er nicht verheiratet ist!");
        }

    }

}
