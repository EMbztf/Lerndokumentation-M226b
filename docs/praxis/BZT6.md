### Aufgabenstellung
- Programmieren Sie die Methode heiraten() in BZT6 aus. Testen Sie die Funktion sinnvoll aus!
- Programmieren Sie die Methode scheiden() in BZT6 aus. Testen Sie die Funktion sinnvoll aus!

> Funktion heiraten()

```java
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
```

> Funktion scheiden() 

```java
protected void scheiden() {
    if(ehepartner != null) {
        System.out.println(nachname + " und " + ehepartner.getNachname() + " sind jetzt geschieden.");
        ehepartner = null;
    } else {
        System.out.println(nachname + " kann sich nicht selber scheiden, weil er nicht verheiratet ist!");
    }

}
```

> Test in der App Klasse

```java
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
```

Ausgabe:

```
Hans Schläffrig kann sich nicht selber scheiden, weil er nicht verheiratet ist!
Hans Schläffrig und Anna Schaffig haben geheiratet.
Lempel Zip und Anna Schaffig können nicht heiraten, weil mindestens einer bereits verheiratet ist!
Anna Schaffig und Hans Schläffrig sind jetzt geschieden.
Anna Schaffig und Warner Brother können nicht heiraten, weil mindestens einer bereits verheiratet ist!
Heini Lern kann sich nicht selber heiraten!
```