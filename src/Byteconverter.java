import java.util.ArrayList;

public class Byteconverter {

    //nimmt Bytefeld an und gibt String[] mit den Bits zurück
    public String[] toBit_String(byte[] bytes) {
        int[] byteconvert = new int[bytes.length];
        int j = 0;
        String[] result = new String[bytes.length];
        Integer[] integerfeld = new Integer[byteconvert.length];
        for (byte etwas : bytes) {
            for (int i = 0; i < 8; i++) {
                byteconvert[j] = (byteconvert[j] * 10) + ((etwas >> (7 - i)) & 0x1);
            }
            integerfeld[j] = byteconvert[j];
            j++;
        }

        for (int i = 0; i < byteconvert.length; i++) {
            result[i] = "";
            int count = integerfeld[i].toString().length();
            while (count < 8) {
                result[i] = "0" + result[i];
                count++;//lol
            }
            result[i] += integerfeld[i].toString();
        }
        return result;
    }

    public byte[] toBit_Byte(byte[] bytes) {
        byte[] byteconvert = new byte[8*bytes.length];
        int j = 0;
        //int[] integerfeld = new int[8 * byteconvert.length+1];
        for (byte etwas : bytes) {
            for (int i = 0; i < 8; i++) {
                byteconvert[(j*8)+i] = /*(byteconvert[j] * 10) +*/ (byte) ((etwas >> (7 - i)) & 0x1);
            }
            // integerfeld[j] = byteconvert[j];
            j++;
        }
        return byteconvert;
        //return integerfeld;
    }

    public int[] toBit_Integer(byte[] bytes) {
        int[] byteconvert = new int[8*bytes.length];
        int j = 0;
        //int[] integerfeld = new int[8 * byteconvert.length+1];
        for (byte etwas : bytes) {
            for (int i = 0; i < 8; i++) {
                byteconvert[(j*8)+i] = /*(byteconvert[j] * 10) +*/ ((etwas >> (7 - i)) & 0x1);
            }
           // integerfeld[j] = byteconvert[j];
            j++;
        }
        return byteconvert;
        //return integerfeld;
    }

     //Schreibt einen einzigen String für ein gegebenes Stringarray
    public String completeString(String[] myByteArray) {
        String result = "";
        for (String etwas : myByteArray) {
            result += etwas;
        }
        return result;
    }



}
