import java.util.Arrays;
import java.util.OptionalInt;

public class LFSR {
    private boolean[] states;
    private int[] polynom;
    private boolean d_zustaende[];

    public LFSR(int[] polynom) {
        OptionalInt toppolynom = Arrays.stream(polynom).max();
        int maxwert = 0;
        if (toppolynom.isPresent()) {
            maxwert = toppolynom.getAsInt();
        }
        states = new boolean[maxwert];
    }

    public int translate_states(int a) { // Wandle 'S' in 'D' Zustände um
        return states.length - a;
    }

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
        Integer conv = i;
        byte[] feld = new byte[1];
        feld[0] = conv.byteValue();
        Byteconverter helper = new Byteconverter();
        int j = states.length - 1;
        for (byte etwas : helper.toBit_Byte(feld)) {
            if (etwas == 1)
                states[j--] = true;
            else {
                states[j--] = false;
            }
        }
    }
    //AKTUELLE ZUSTÄNDE AUSGEBEN
    public String toString(){
        return null;
    }

    //Soll i-mal das LFSR laufen lassen und dann einen String mit den erzeugten Outputs angeben
    public String shift_(int i){
        return null;
    }
}
