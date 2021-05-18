
public class DES {


    byte[][] SBox1;

    public DES() {
    }

    public boolean verify() {
        return true;
    }// for 0- 63 do
    public boolean checkMyShit(byte input, SBox box){
return true;
    }

    public byte count(byte input, byte output) { //
        byte count = 0;
        if (input == 0 && output == 0)
            return 64;

        for (int k = 0; k < 16; k++) {
            if ((input ^ k) == output) {
                count++;
                System.out.println(k);
            }
        }
        return count;
    }

    public void checkLineAverage(byte[] b) {
        float avg = 0;
        for (byte a : b) {
            avg += a;
        }
        avg = avg / (float) b.length + 1;
        System.out.println("AVG = " + avg);
        if (!(3 < avg && avg < 5))
            throw new IllegalArgumentException("ZEILENDURCHSCHNITT != Definitionsbereich, nich?");
        //return (avg/(float)b.length+1);

    }

    public void checkLineSum(byte[] b) {
        byte sum = 0;
        for (byte a : b) {
            sum += a;
        }
        if (sum != 64)
            throw new IllegalArgumentException("ZEILENSUMME != 64");
    }

}
