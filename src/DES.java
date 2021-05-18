
public class DES {


    byte[][] SBox1;

    public DES() {
    }

    public boolean verify() {
        return true;
    }

    public byte getXORPartnerSum(byte input, byte output) {
        byte count = 0;
        if (input == 0 && output == 0)
            return 64;
        for (byte i = 0; i < 64; i++) {
            if ((input ^ i) == output)
                count++;
        }
        /*for (byte i = 0; i < 64; i++) {
            if ((output ^ i) == input)
                count++;
        }*/
        return count;
    }

    public void checkLineAverage(byte[] b){
        float avg=0;
        for (byte a : b) {
            avg += a;
        }
        avg = avg/(float)b.length+1;
        if (avg != 64)
            throw new IllegalArgumentException("ZEILENSUMME != 64");
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

    public byte[] calcIndex(byte input) {
        return new byte[]{outerBits(input), innerBits(input)};
    }

    public static void check6BitInput(byte b) {
        if (b >= 64)
            throw new IllegalArgumentException();
    }

    public byte innerBits(byte b) {
        check6BitInput(b);
        byte ret = (byte) (b >> 2); // 001111
        return ret;
    }

    public byte outerBits(byte b) {
        check6BitInput(b);
        byte ret = (byte) (b & 1);
        ret += (byte) ((b >> 5) & 1) << 1;
        return ret;
    }
}
