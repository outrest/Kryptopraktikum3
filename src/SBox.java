
public class SBox {
    byte[][] box;

    public SBox(byte[][] b) {
        box = b;
    }

    public static void check6BitInput(byte b) {
        if (b >= 64)
            throw new IllegalArgumentException();
    }

    public byte trigger(byte b) {
        return box[outerBits(b)][innerBits(b)];
    }

    public byte innerBits(byte b) {
        check6BitInput(b);
        byte ret = (byte) ((b & 0b011110) >> 1); // Setze äußere Bits auf 0, dann shifte 1. Erhalte so die inneren Bits
        return ret;
    }

    public byte outerBits(byte b) {
        check6BitInput(b);
        byte ret = (byte) (b & 1);
        ret += (byte) ((b >> 5) & 1) << 1;
        return ret;
    }
}
