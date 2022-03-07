### Aufgabenstellung
Machen Sie die Superklasse Person und Mitarbeiter abstract und bringen Sie es anschliessend wieder zum Funktionieren!

### Lösung

> Klasse Person

```java
public abstract class Person {
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

    @Override
    public String toString() {
        return nachname + "(Attributquelle: Klasse " + this.getClass().getName() + ") - " + getClass() + ".";    
    }

    @Override 
    public boolean equals(Object einAnderesObject) {
        if(this == einAnderesObject) {
            return true;
        } 

        if(einAnderesObject.getClass() == getClass() 
                && this.hashCode() == ((Person) einAnderesObject).hashCode()) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return nachname.hashCode();
    }

}
```

> Klasse Mitarbeiter

```java
public abstract class Mitarbeiter extends Person {
    protected int personalnummer;

    protected Mitarbeiter(String nachname) {
        this(nachname, 0);
    }

    protected Mitarbeiter(String nachname, int personalnummer) {
        super(nachname);
        this.personalnummer = personalnummer;
    }

    public int getPersonalnummer() {
        return personalnummer;
    }

    public void setPersonalnummer(int personalnummer) {
        this.personalnummer = personalnummer;
    }

    public String vorstellen() {
        return super.vorstellen() + " Meine Personalnummer ist " + getPersonalnummer();
    }


    @Override
    public String toString() {
        return super.toString() + " - Personalnummer: " + personalnummer + " (Attributquelle: Klasse " + this.getClass().getName() + ").";
    }

    @Override
    public int hashCode() {
        return Integer.valueOf(personalnummer).hashCode();
    }
}
```