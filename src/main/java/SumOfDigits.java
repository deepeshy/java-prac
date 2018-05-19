public class SumOfDigits {
    public static void main(String[] args) {
        System.out.println(sumOfDigits(234567));
    }

    private static int sumOfDigits(int i) {
        int sum = 0;
        while(i > 0){
            sum += i % 10;
            i = i/10;
        }
        return sum;
    }
}
