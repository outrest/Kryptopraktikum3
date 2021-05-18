import java.util.Arrays;

public class Aufgabe2 {
    public static void main(String[] args) {
        byte[][] s1 = {{14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7}, // 0 0000 1 - 101        0 0011 0   0 0011 1
                {0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8},//101 110 100
                {4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0},// X:111111 -> Y:1111
                {15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13}};
        //DES sbox1 = new DES();
        SBox sBox1 = new SBox(s1);
        byte[] ergebnisse = new byte[64];
        byte[][] testTabelle = new byte[64][16];

        for (byte i = 0; i < 64; i++) {
                byte trigger = sBox1.trigger(i);
                ergebnisse[i] = trigger;


                testTabelle[i][trigger]+=1;


        }
        System.out.println(Arrays.toString(ergebnisse));
       // System.out.println(Arrays.deepToString(testTabelle));





        byte[] gesamtVorkommen = new byte[16];
        for (byte c : ergebnisse) {
            gesamtVorkommen[c] += 1;
        }
        System.out.println(Arrays.toString(gesamtVorkommen));

    }
}
// Zeilenweise Summe = 64