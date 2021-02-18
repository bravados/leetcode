public class ArithmeticSlices {

    private int count(int total, int number){
        if(number < 3) return 0;

        return 1 + (total - number) + count(total, number - 1);
    }

    public int numberOfArithmeticSlices(int[] A) {
        if(A.length < 3) return 0;
        int sliceSize = 0;
        int total = 0;

        for(int i = 2; i < A.length; i++){

            if(A[i - 1] - A[i - 2] == A[i] - A[i - 1])
                sliceSize = sliceSize == 0 ? 3 : sliceSize + 1;
            else {
                total += count(sliceSize, sliceSize);
                sliceSize = 0;
            }
        }
        return total + count(sliceSize, sliceSize);
    }

    public static void main(String args[]){
        ArithmeticSlices arithmeticSlices = new ArithmeticSlices();
        System.out.println(arithmeticSlices.numberOfArithmeticSlices(new int[]{1, 1, 2, 5, 7}));
    }
}
