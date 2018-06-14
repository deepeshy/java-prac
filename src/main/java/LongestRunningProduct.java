import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LongestRunningProduct {

    private List<Integer> input;

//    public LongestRunningProduct(List<Integer> input) {
//        this.input = input;
//    }

//    public static void main(String[] args) {
//        int[] input = {};
//        longestRunningProduct(input);
//    }


    private static ProductGroup longestRunningProduct(int[] input) {
        // if there are 0s, split at 0s


        // if there are odd number of negatives
        // create 4 possible subgroups that can have the max product
        // get the max of all of them
        return null;
    }


    private List<ProductGroup> getSubGroupsAroundZeros(int[] input) {
        List<ProductGroup> productGroups = new ArrayList<>();
        List<Integer> runningList = new ArrayList<>();
        for (int num : input) {
            if (num == 0) {
                if (runningList.size() > 0) productGroups.add(new ProductGroup(runningList));
                runningList = new ArrayList<>();
            } else {
                runningList.add(num);
            }
        }
        return productGroups;
    }

    private ProductGroup getSubGroupsAroundNegatives(List<Integer> listOfIntegers) {
        List<ProductGroup> productGroups = new ArrayList<>();
        Long countOfNegatives = listOfIntegers.stream().filter(x -> x < 0).collect(Collectors.counting());
        if (countOfNegatives % 2 == 0) {
            ProductGroup pg = new ProductGroup(listOfIntegers);
            return pg;
        } else {
            // 4 possibilities
            int posOfFirstNegative = IntStream.range(0, listOfIntegers.size())
                    .filter(x -> x < 0)
                    .findFirst().getAsInt();

            int posOfLastNegative = IntStream.range(listOfIntegers.size(), 0)
                    .filter(x -> x < 0)
                    .findFirst().getAsInt();

            // Split on first negative to get two groups
            ProductGroup pg1 = new ProductGroup(listOfIntegers.subList(0, posOfFirstNegative));
            ProductGroup pg2 = new ProductGroup(listOfIntegers.subList(posOfFirstNegative, listOfIntegers.size()));

            // Split on last negative to get two groups
            ProductGroup pg3 = new ProductGroup(listOfIntegers.subList(0, posOfLastNegative));
            ProductGroup pg4 = new ProductGroup(listOfIntegers.subList(posOfLastNegative, listOfIntegers.size()));
        }
        return Collections.max(productGroups);
    }


    private static class ProductGroup implements Comparable<ProductGroup> {
        List<Integer> subArr;
        int prod = 1;

        public ProductGroup(List<Integer> subArr) {
            this.subArr = subArr;
            for (int i : subArr) {
                prod *= i;
            }
        }

        public List<Integer> getSubArr() {
            return subArr;
        }

        public int getProd() {
            return prod;
        }

        @Override
        public int compareTo(ProductGroup o) {
            return Integer.compare(this.prod, o.prod);
        }
    }
}
