Theorie
==========
## Vererbung
Bei einer Vererbung in Java wird zwischen einer Super- und einer Subklasse unterschieden. Die Superklasse, auch Eltern- oder Basisklasse genannt, ist in der Regel eine Zusammenfassung von allgemeinen Attributen und Methoden unterschiedlicher aber ähnlicher Objekte.
Die Subklasse, auch Kindsklasse bezeichnet, bekommt von ihrer Superklasse sämtliche Attribute und Methoden vererbt. Desweiteren wird die Subklasse um eigene Attribute und Methoden erweitert. Man spricht hier von einer Spezialisierung der Subklasse von der Superklasse.
Eine Vererbung in Java findet über das Schlüsselwort extends statt. Schauen wir uns dazu erst einmal die allgemeine Form an.

> Beispiel
```java
public class Kugelschreiber extends Stift {}
```

## Polymorphie
Methoden können der sogenannten Polymorphie unterliegen. Polymorphie ist griechisch und bedeutet Vielgestaltigkeit. Von Polymorphie spricht man in Java beispielsweise, wenn  zwei Klassen denselben Methodennamen verwenden, aber die Implementierung der Methoden sich unterscheidet. Häufig wird Polymorphie bei der Vererbung verwendet, d. h., dass einer Variablen nicht nur Objekte vom Typ der bei der Deklaration angegebenen Klasse zugewiesen werden können, sondern auch Objekte vom Typ der Kindsklassen. Dies funktioniert nur, weil jede Kindsklasse auch alle Methoden und Attribute ihrer Elternklassen implementieren muss.

Somit ist gewährleistet, dass alle Kindsklassen über dieselben Methoden verfügen wie die Elternklasse. Die Methoden können jedoch unterschiedlich implementiert werden, man spricht hier vom "Überschreiben" der Methode.

Man unterscheidet die Polymorphie in zwei unterschiedlichen Kategorien:

### Statische Polymorphie

Dort werden Methoden in einer Klasse mithilfe von verschiedenen Parameteren überschrieben:

> Beispiel

```java
public class Ueberladen {

    public static void main(String[] args) {
        Ueberladen u = new Ueberladen();
        u.print("Hallo");
        u.print("Moin", "Klaus");
    }

    private void print(String txt) {
        System.out.println(txt);
    }

    private void print(String txt, String name) {
        System.out.println(txt + " " + name);
    }
}
```

### Dynamische Polymorphie

Dort werden Methoden in Subklassen überschrieben und verhalten sich dort hin anders als in der Superklasse

> Beispiel
```java
public class Polymorphie {

    public Polymorphie() {
        Tier[] tiere = { new Vogel(), new Wurm() };
        for (int i = 0; i < tiere.length; i++) {
            tiere[i].bewegtSich();
            tiere[i].zwitscher();   // Fehler
            tiere[i].frisst();      // Fehler
        }
    }

    public static void main(String[] args) {
        new Polymorphie();
    }
}

class Tier {
    void bewegtSich() {
        System.out.println("Schwimmen, laufen, kriechen, hüpfen oder fliegen?");
    }
}

class Vogel extends Tier {
    @Override
    void bewegtSich() {
        System.out.println("Ich fliege");
    }

    void zwitscher() {
        System.out.println("tirilli");
    }

    void frisst() {
        System.out.println(getClass() + " frisst");
    }
}

class Wurm extends Tier {
    @Override
    void bewegtSich() {
        System.out.println("Ich krieche");
    }

    void frisst() {
        System.out.println(getClass() + " frisst");
    }
}
```

## Konstruktoren bei der Vererbung

Damit eine Subklasse das Recht hat, auf ihre Superklasse zuzugreifen, muss der Konstruktor auf protected gestellt werden. Wir deklarieren als erstes in der Superklasse Person einen Konstruktor für den Nachnamen.

```java
protected Person(String nachname)
{
    this.nachname = nachname;
}
```

> Info
> Es gibt einen Konstruktor und wenn Sie eine Instanz einer Subklasse machen mit dem Nachnamen drin, muss der Konstruktor des Nachnamens in der Superklasse aufgerufen werden. Das geschieht mittels des Wortes super. Die Klasse Lernende greift direkt auf den Nachnamen zu. Wird eine Instanz gemacht mit dem Lernenden (ein Lernende) muss der Konstruktor der Superklasse Person aufgerufen werden.

Das geschieht in der Klasse Lernende so:

```java
public Lernende(String nachname)
{
    super(nachname);
}
```
### protected Modifikator

1. Sind Methoden, Konstruktoren oder Felder in einer Klasse als protected gekennzeichnet, so sind diese Strukturen ähnlich einer package-default-Deklaration nur im Package der deklarierenden Klasse ansprechbar, zusätzlich jedoch auch noch in den von ihr abgeleiteten Klassen anderer Packages.
2. Konstruktoren, Methoden und Felder, die mit dem Modifikator protected gekennzeichnet sind, stehen auch in von der deklarierenden Klasse abgeleiteten Klassen anderer Packages zur Verfügung.

### Konstruktoren auf Subklassen erweitern
In der Klasse Mitarbeiter gibt es noch die Personalnummer - erstellen wir also einen Konstruktor für Mitarbeiter der diese Anforderung erfüllt:

```java
protected Mitarbeiter(String nachname, int personalNummer)
{
    super(nachname); // Muss zwingend an erster Stelle stehen!
    this.personalNummer = personalNummer;
}
```

## Object Superklasse
In Java ist die oberste Klasse das Object - alle Klassen erben von dieser Klasse. Wir könnten also problemlos folgendes programmieren:
```java
public class Person extends Object {
    //uswusf.
}
```
Jedoch macht es wenig Sinn das bei jeder Klasse zu schreiben, deswegen macht es Java implizit - sprich automatisch.

### Methode : getClass()
Die Methode ```getClass()``` gibt die Klasse, zur Laufzeit, aus. Folgendes Beispiel aus:

```java
import java.util.GregorianCalendar;

public class ObjectDemo {

   public static void main(String[] args) {

      // create a new ObjectDemo object
      GregorianCalendar cal = new GregorianCalendar();

      // print current time
      System.out.println("" + cal.getTime());

      // print the class of cal
      System.out.println("" + cal.getClass());

      // create a new Integer
      Integer i = new Integer(5);

      // print i
      System.out.println("" + i);

      // print the class of i
      System.out.println("" + i.getClass());
   }
}
```
Generiert folgende Ausgabe:

```
Sat Sep 22 00:31:24 EEST 2012
class java.util.GregorianCalendar
5
class java.lang.Integer
```

### Methode : toString()

Wenn Sie folgendes im main() ausprobieren:

```java
System.out.println(eineAngestellte.toString());
```

bekommen Sie ungefähr eine Ausgabe wie: ```java bzt7.Angestellte@659e0bfd```. Die Methode ist so definiert, dass ein String mit dem Namen der Klasse und nach dem @ einen Hashwert ausgibt.

Es würde aber faulenderweise einfacher gehen:

```java
System.out.println(eineAngestellte);
```

Grund:
- jede Klasse erbt von der Klasse Object die Methode toString()
- Wenn Sie einen println() ausführen, werden auf jeglichen Übergabeparameter die toString()-Methode ausgeführt

### Methode : hashCode()
Der Hashwert ist eine Art Schlüssel für das Objekt. Damit kann man sortieren und sogenannte HashMaps machen. Diese Container enthalten die Hashwerte. Wird diese Methode nicht überschrieben wird die Speicheradresse des Objektes als Hexwert zurückgegeben. Besser ist es aufgrund der Attribute einen Hashwert zu erzeugen.

Das könnte folgendermassen implementiert werden:
```java
@Override
public int hashCode()
{
    return nachname.hashCode();
}
```

### Methode : equals()
Wie Sie bereits wissen werden Objekte mittels ihrer Referenzen verglichen. Zeigen diese auf den gleichen Ort im Heap sind die Objekte gleich, also true. Das wollen wir ausprobieren.

Die Methode equals() ist in der Klasse Object folgendermassen definiert:
```java
public boolean equals(Object obj)
{
    return (this == obj);
}
```

## Abstrakte Klassen
Bei Klassen können Sie einfach abstract hin schreiben. Damit können Sie nie von dieser Klasse Instanzen bilden. Nur abgeleitete Klassen, welche von der abstrakten Klasse erben, können Instanzen bilden.

## Interface

Interfaces sind Klassenschnittstellen. Sie haben nichts zu tun mit dem klassischen Begriff des Interfaces, wie er in der Hardware als Verbindung zwischen Geräten zu tun hat.

Interfaces sind abstrakte Klassen, welche nur abstrakte Methoden enthalten. Wie im letzten Beispiel der abstrakten Methoden gibt ein Interface nur das Gerüst für den Aufbau der Methode vor. Die Klasse, welche das Interface implementiert, muss dann diese Methode entsprechend verwenden.