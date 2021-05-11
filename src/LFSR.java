import java.util.Arrays;
import java.util.OptionalInt;

public class LFSR {
    private boolean[] states;
    private int[] polynom;

    public LFSR(int[] polynom){
        OptionalInt toppolynom = Arrays.stream(polynom).max();
        int maxwert = 0;
        if (toppolynom.isPresent()){
            maxwert = toppolynom.getAsInt();
        }
        states = new boolean[maxwert+1];

    }
}
