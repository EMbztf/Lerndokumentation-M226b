### 1. toString()

Überschreiben Sie auf allen Klassen im Projekt die Methode toString() - Die Ausgabe soll ein bisschen sinnvoller sein. Geben Sie dabei jeweils alle Attribute aus ähnlich wie bei vorstellen()).

Es sollte folgendes ausgegeben werden:

```
Vorstellung:
Anna Schaffig (Attributquelle: Klasse Person) - class BZT7.Angestellte.  - Personalnummer: 0 (Attributquelle: Klasse Mitarbeiter).  - Personalnummer: 0 (Attributquelle: Klasse Angestellte).  - In Schulleitung?: true

Anna Schaffig (Attributquelle: Klasse Person) - class BZT7.Angestellte.  - Personalnummer: 0 (Attributquelle: Klasse Mitarbeiter).  - Personalnummer: 0 (Attributquelle: Klasse Angestellte).  - In Schulleitung?: true

Hans Schläffrig (Attributquelle: Klasse Person) - class BZT7.Angestellte.  - Personalnummer: 345 (Attributquelle: Klasse Mitarbeiter).  - Personalnummer: 345 (Attributquelle: Klasse Angestellte).  - In Schulleitung?: false

Lempel Zip (Attributquelle: Klasse Person) - class BZT7.Lehrer.  - Personalnummer: 0 (Attributquelle: Klasse Mitarbeiter).  - Fachbereich: Informatik (Attributquelle: Klasse Lehrer). 

Heini Lern (Attributquelle: Klasse Person) - class BZT7.Lernende.  - Nummer: 7890 (Attributquelle: Klasse Lernende). 

Warner Brother (Attributquelle: Klasse Person) - class BZT7.Person. 
```

#### Lösung

> In Klasse Person

```java
@Override
public String toString() {
    return nachname + "(Attributquelle: Klasse " + this.getClass().getName() + ") - " + getClass() + ".";    
}
```

> In Klasse Mitarbeiter

```java
@Override
public String toString() {
    return super.toString() + " - Personalnummer: " + personalnummer + " (Attributquelle: Klasse " + this.getClass().getName() + ").";
}
```

> In Klasse Angestellte

```java
@Override
public String toString() {
    return super.toString() + " - Personalnummer: " + personalnummer + " (Attributquelle: Klasse " + this.getClass().getName() + ")." 
                            + " - In Schulleitung?: " + isSchulleitung();
}
```

> In Klasse Lehrer

```java
@Override
public String toString() {
    return super.toString() + " - Fachbereich: " + getFachbereich() + " (Attributquelle: Klasse " + this.getClass().getName() + ").";
}
```

> In Klasse Lernende

```java
@Override
public String toString() {
    return super.toString() + " - Nummer: " + getNummer() + " (Attributquelle: Klasse " + getClass().getName() + ").";
}
```

> Klasse App

```java
public class App
{
    public static void main(String[] args)
    {
        Angestellte eineAngestellte = new Angestellte("Anna Schaffig", 0, true);
        Angestellte einAngestellter = new Angestellte("Hans Schläffrig", 345, false);
        Lehrer einLehrer = new Lehrer("Lempel Zip", 0, "Informatik");
        Lernende einLernender = new Lernende("Heini Lern");
        einLernender.setNummer(7890);
        Person einePerson = new Person("Warner Brother");

        System.out.println("\nVorstellung:");
        System.out.println(eineAngestellte.toString() + "\n");               
        System.out.println(eineAngestellte + "\n");
        System.out.println(einAngestellter + "\n");
        System.out.println(einLehrer + "\n");
        System.out.println(einLernender + "\n");
        System.out.println(einePerson + "\n");
    }
}
```

### equals()
Überschreiben Sie in der Klasse Person die Methode equals().
Implementieren Sie dabei die folgenden drei Vergleiche und testen Sie sie im main() aus:

1. Wenn die Referenz gleich ist: return true
2. Wenn null übergeben wird : return false
3. Klasse gleich und Hashcode gleich : return true

#### Lösung

```java
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
```

### hashCode() 
1. Nachdem Sie auf der Superklasse Person die equals()-Methode implementiert haben, implementieren Sie hashCode()-Methoden auf Ihren Klassen (das macht aber auch wirklich nur dort Sinn, wo ein Attribut "identifizierend" wirkt).

> Klasse Person

```java
@Override
public int hashCode() {
    return nachname.hashCode();
}
```

> Klasse Mitarbeiter

```java
@Override
public int hashCode() {
    return Integer.valueOf(personalnummer).hashCode();
}
```

> Klasse Angestellte

```java
@Override
public int hashCode() {
    return nachname.hashCode();
}
```

> Klasse Lehrer

```java
@Override
public int hashCode() {
    return fachbereich.hashCode();
}
```

> Klasse Lernende

```java
@Override
public int hashCode() {
    return Integer.valueOf(nummer).hashCode();
}
```

> Test In der App Klasse

```java
Angestellte eineAngestellte = new Angestellte("Ann Schaffig");
Angestellte einAngestellter = new Angestellte("Hans");

System.out.println(eineAngestellte.equals(eineAngestellte));
System.out.println(eineAngestellte.equals(einAngestellter));

Angestellte zweiteAngestellte = new Angestellte("Anna Schaffig");
System.out.println(eineAngestellte.equals(zweiteAngestellte));

Angestellte dritteAngestellte = new Angestellte("Hanna Schaffig");
System.out.println(eineAngestellte.equals(dritteAngestellte));
```

Mit folgender Ausgabe:

```
true
false
false
false
```

2. Testen Sie die den Programmfluss der equals()-Methode mit dem Debugger aus! Wo wird wann welcher HashCode verwendet?
   
Es wird der HashCode der Klasse verwendet.