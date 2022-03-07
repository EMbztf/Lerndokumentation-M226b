### Aufgabenstellung
Betrachten Sie den folgenden Source-Code (und übernehmen Sie die Inhalte in Ihr Projekt BZT1) - Die Augabe lautet : Datenverwaltung von Lernenden und Lehrern.

### Lösung

> App.java

```java
public class App
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
    Lehrer mt = new Lehrer();
    mt.setNachname("Inauen");
    mt.setFachbereich("Informatik");

    Lernende mus = new Lernende();
    mus.setNachname("Muster");
    mus.setNummer(1001);

    System.out.println("Nachname des Lehrers: " + mt.getNachname());
    System.out.println("Fachbereich des Lehrers: " + mt.getFachbereich());

    System.out.println("Nachname des Lernenden: " + mus.getNachname());
    System.out.println("Nummer des Lernenden: " + mus.getNummer());
    }
}
```
> Lehrer.java

```java
public class Lehrer
{
    private String fachbereich = new String(); // ein String ist eine Klasse, 
                                            // das geht deshalb mit new!
    private String nachname;

    public void setNachname(String nachname)
    {
        this.nachname = nachname;
    }

    public String getNachname()
    {
        return nachname;
    }

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

> Lernende.java

```java
public class Lernende
{
    private String nachname = new String(); // new ist optional
    private int nummer;  // Schülernummer

    public void setNachname(String nachname)
    {
        this.nachname = nachname;
    }

    public String getNachname()
    {
        return nachname;
    }

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

### Analyse

Ist der Code eigentlich gut?

Nein, für folgende Gründe:

- Redundante Code stellen mit dem Nachnamen
- Wenn man jetzt die Addresse als Parameter hinzufügen will, muss man es bei beiden Klassen anpassen

Als Verbesserungsvorschlag könnte man Vererbungen verwenden. Klasse Lehrer und Lernende würden dann die Methoden der Klasse Person erben.


