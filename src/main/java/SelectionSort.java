import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        selectionSort(new int[]{34, 434, 78, 443, 3, 890, 7, 65, 45});
    }

    private static void selectionSort(int[] inp) {
        for (int i = 0; i < inp.length; i++) {
            int minPos = i;
            for (int j = i + 1; j < inp.length; j++) {
                if (inp[minPos] > inp[j]) {
                    minPos = j;
                }
            }
            int temp = inp[i];
            inp[i] = inp[minPos];
            inp[minPos] = temp;
        }
        Arrays.stream(inp).forEach(System.out::println);
    }
}
