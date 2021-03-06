import java.util.Arrays;
import java.util.OptionalInt;

public class LFSR {
    private boolean[] states;
    private int[] polynom;

    public LFSR(int[] polynom) {
        OptionalInt toppolynom = Arrays.stream(polynom).max();
        int maxwert = 0;
        if (toppolynom.isPresent()) {
            maxwert = toppolynom.getAsInt();
        }
        states = new boolean[maxwert];
        this.polynom = polynom;

    }

    public int translate_states(int a) { // Wandle 'S' in 'D' Zustände um
        return states.length - a;
    }

    //Der Output des LFSR kommt zurück
    public boolean shift() { // Aufruf in jeder Iteration, um die Zustände um eine Postition zu verschieben
        boolean save = states[0];
        boolean neuer_Zustand = xorstate();
        System.arraycopy(states, 1, states, 0, states.length - 1);
        states[states.length - 1] = neuer_Zustand;
        return save;
    }

    private boolean xorstate() { // Realisierung des XOR,
        boolean zwischenergebnis = states[translate_states(polynom[0])];
        for (int i = 1; i < polynom.length; i++) {
            int stelle = translate_states(polynom[i]);
            zwischenergebnis = zwischenergebnis ^ states[stelle];
        }
        return zwischenergebnis;
    }

    public void initialize(int i) {
        String binString = Integer.toBinaryString(i);
        int j = states.length - 1;
        for (int k = 0; k < binString.length(); k++) {
            states[j--] = binString.charAt(k)=='1'; // vergleiche mit dem char 1, nich?
        }
    }

    public boolean[] getStates() {
        return states;
    }

    //AKTUELLE ZUSTÄNDE AUSGEBEN
    public String toString() {
        return Arrays.toString(states);
    }

    //Soll i-mal das LFSR laufen lassen und dann einen String mit den erzeugten Outputs angeben
    public String shift(int i) {
        if (i <= 0)
            throw new IllegalArgumentException("0 und kleiner geht nicht");
        StringBuilder result = new StringBuilder();
        while (i > 0) {
            //Shift==True? dann 1, sonst  0
            result.append(shift() ? 1 : 0);
            i--;
        }
        return result.toString();
    }
}
