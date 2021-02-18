public class NumberOf1Bits {

    public int hammingWeight(int n) {
        if(n == 0) return 0;
        if(n == Integer.MIN_VALUE) return 1;

        int count = 0;
        double number = Math.abs(n);

        if(n < 0) number--;

        while(number != 0){
            double closestPow = (int)(Math.log(number) / Math.log(2));
            double twoBasedPow = Math.pow(2, closestPow);
            number -= twoBasedPow;
            count++;
        }
        return n < 0 ? 32 - count : count;
    }

    public static void main(String args[]){
        NumberOf1Bits numberOf1Bits = new NumberOf1Bits();
        System.out.println(numberOf1Bits.hammingWeight(-1));
    }

/*
playground

-16711936
11111111000000001111111100000000

11111111000000001111111011111111

00000000111111110000000100000000 (el positivo)



11111111000000001111111011111111
00000000111111110000000100000000

00000000111111110000000011111111

-8
1111111111111000
1111111111110111
0000000000001000

0000000000000111

7
111

-7
1111111111111001
1111111111111000
0000000000000111

0000000000000110
1111111111111001

*/
}
