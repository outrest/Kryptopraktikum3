import java.util.Arrays;
import java.util.OptionalInt;

public class LFSR {
    private boolean[] states;

    public LFSR(int[] polynom){
        OptionalInt toppolynom = Arrays.stream(polynom).max();
        if (toppolynom.isPresent()){
            toppolynom=toppolynom.getAsInt();
        }
        states = new boolean[];

    }
}
