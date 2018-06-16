import java.util.*;
import java.util.stream.Collectors;

public class MaxProductSubArray {

    public static void main(String[] args) {
//        int[] input = {1, 2, -1, 34, 5, 7, -1, 9, 56, 8, -1, 98};
//        int[] input = {6, -3, -10, 0, 2};
//        int[] input = {-1, -3, -10, 0, 60};
        int[] input = {-2, -3, 0, -2, -40};

        ProductGroup x = new MaxProductSubArray().longestRunningProduct(input);
        System.out.println(x.getProd());
        System.out.println(x);
    }

    private List<Integer> input;

    private ProductGroup longestRunningProduct(int[] input) {
        List<ProductGroup> pgs = new ArrayList<>();
        // if there are 0s, split at 0s
        List<ProductGroup> subGroupsAroundZeros = this.getSubGroupsAroundZeros(input);
        for (ProductGroup pg : subGroupsAroundZeros) {
            pgs.add(getSubGroupsAroundNegatives(pg.getSubArr()));
        }
        // if there are odd number of negatives
        // create 4 possible subgroups that can have the max product
        // get the max of all of them
        return Collections.max(pgs);
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

        productGroups.add(new ProductGroup(runningList));
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
            int posOfFirstNegative = -1;
            int posOfLastNegative = -1;
            for (int i = 0; i < listOfIntegers.size(); i++) {
                if (listOfIntegers.get(i) < 0 && posOfFirstNegative == -1) {
                    posOfFirstNegative = i;
                }

                if (listOfIntegers.get(listOfIntegers.size() - i - 1) < 0 && posOfLastNegative == -1) {
                    posOfLastNegative = listOfIntegers.size() - i - 1;
                }

                if (posOfFirstNegative != -1 && posOfLastNegative != -1) break;


            }

            // Split on first negative to get two groups
            ProductGroup pg1 = new ProductGroup(listOfIntegers.subList(0, Math.max(0, posOfFirstNegative - 1)));
            ProductGroup pg2 = new ProductGroup(listOfIntegers.subList(Math.min(posOfFirstNegative + 1, listOfIntegers.size() - 1), listOfIntegers.size() - 1));
            productGroups.add(pg1);
            productGroups.add(pg2);


            // Split on last negative to get two groups
            if (posOfFirstNegative != posOfLastNegative) { // if there is only one negative number, there will be only two subgroups
                ProductGroup pg3 = new ProductGroup(listOfIntegers.subList(0, Math.max(0, posOfLastNegative - 1)));
                ProductGroup pg4 = new ProductGroup(listOfIntegers.subList(Math.min(listOfIntegers.size() - 1, posOfLastNegative + 1), listOfIntegers.size() - 1));
                productGroups.add(pg3);
                productGroups.add(pg4);
            }
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

        @Override
        public String toString() {
            return subArr.stream().map(x -> x + " ").collect(Collectors.joining());
        }
    }
}
