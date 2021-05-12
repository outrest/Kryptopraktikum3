
public class Aufgabe1 {
    public static void main(String[] args) {
        int[] polynom = {21, 2};
        LFSR aufgabeA = new LFSR(polynom);

        aufgabeA.initialize(initialWert); //2097151 oder 111111111111111111111
        System.out.println("\nInitialisierung des LFSR mit den Werten: " + initialWert);
        String ausgabe = aufgabeA.shift(64);
        if (ausgabe.equals(vergleichsWert))
            System.out.println("Das LFSR arbeitet korrekt, der Wert ist in der Tat:\n" + ausgabe);
        else
            System.out.println("Das LFSR arbeitet nicht korrekt, die Werte unterscheiden sich: \n" + vergleichsWert +"\n" + ausgabe);

    }
}
