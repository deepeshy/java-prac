public class SecondLargest {
    public static void main(String[] args) {
        int[] input = {12, 34, 56, 6, 89, 11};
        System.out.println(secondLargest(input));
    }

    private static int secondLargest(int[] input) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i < input.length; i++) {
            if (input[i] > largest) {
                secondLargest = largest;
                largest = input[i];
            } else {
                if (input[i] > secondLargest) {
                    secondLargest = input[i];
                }
            }
        }
        return secondLargest;
    }
}
