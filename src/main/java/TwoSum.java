import java.util.*;

public class TwoSum {
    public static void main(String[] args) {
//        Set<int[]> ints = twoSum(new int[]{12, 34, 56, 57, 11, 66, 2}, 68);
        Set<int[]> ints = twoSumUsingSorting(new int[]{9, 12, 34, 56, 57, 11, 66, 59, 2}, 68);
        for (int[] p : ints) {
            System.out.println(p[0] + "+" + p[1]);
        }
    }

    // Brute Force
    private static Set<int[]> twoSum(int[] ints, int sum) {
        Set<int[]> pairs = new HashSet<int[]>();
        for (int i = 0; i < ints.length; i++) {
            for (int j = i + 1; j < ints.length; j++) {
                if (ints[i] + ints[j] == sum) pairs.add(new int[]{ints[i], ints[j]});
            }
        }
        return pairs;
    }

    private static Set<int[]> twoSumUsingSorting(int[] ints, int sum) {
        Arrays.sort(ints); // Sort it in ascending order
        Set<int[]> pairs = new HashSet<int[]>();
        for (int i = 0, j = ints.length - 1; i < j;) {
            if (ints[i] > sum) {
                break;
            }
            else {
                int currentSum = ints[i] + ints[j];
                if(currentSum == sum) {
                    pairs.add(new int[]{ints[i], ints[j]});
                    i++;
                    j--;
                } else {
                    if(currentSum < sum) {
                        i++;
                    } else {
                        j--;
                    }
                }
            }
        }
        return pairs;
    }


}
