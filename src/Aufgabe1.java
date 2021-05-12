
public class Aufgabe1 {
    public static void main(String[] args) {
        int[] polynom = {21, 2};
        LFSR aufgabeA = new LFSR(polynom);

        aufgabeA.initialize(0x1FFFFF);

        System.out.println(aufgabeA.shift(1)); //2097151 oder 111111111111111111111

    }
}
