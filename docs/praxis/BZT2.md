### Aufgabenstellung
Erstellen Sie eine Superklasse Person, die alle gemeinsamen Attribute und Methoden von Lehrer und Lernenden beinhaltet.

Das Programm soll folgende Ausgabe produzieren können:

```
Ich heisse Muster 
Ich heisse Moritz. Meine Nummer ist 4711
Ich heisse Lempel. Ich bin Lehrer für RitschRatschMühle
```

### Lösung

> Klasse Person

```java
public class Person {
    private String nachname = new String();

    public void setNachname(String nachname)
    {
        this.nachname = nachname;
    }

    public String getNachname()
    {
        return nachname;
    }

}
```

> Klasse Lehrer

```java
public class Lehrer extends Person{
    private String fachbereich = new String(); // ein String ist eine Klasse, 
                                            // das geht deshalb mit new!
    public void setFachbereich(String fachbereich)
    {
        this.fachbereich = fachbereich;
    }

    public String  getFachbereich()
    {
        return fachbereich;
    }
}
```

> Klasse Lernende

```java
public class Lernende extends Person {

    private int nummer;  // Schülernummer

    public void setNummer(int nummer)
    {
        this.nummer = nummer;
    }

    public int getNummer()
    {
        return nummer;
    }  
}
```

> Klasse Main

```java
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
```