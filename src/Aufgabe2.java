
public class Aufgabe2 {
    public static void main(String[] args) {
        int[][] s1 = {{14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7},
                {0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8},
                {4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0},
                {15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13}};
        DES sbox1 = new DES();

        System.out.println(sbox1.innerBits((byte) 63));
        System.out.println(sbox1.outerBits((byte) 63));


       System.out.println( sbox1.getXORPartnerSum((byte)(9),(byte)(4)));


    }
}
// Zeilenweise Summe = 64