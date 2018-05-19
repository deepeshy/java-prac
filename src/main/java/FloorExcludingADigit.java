public class FloorExcludingADigit {
    public static void main(String[] args) {
        System.out.println(floorWithoutADigit(123, 3));

    }

    private static int floorWithoutADigit(int num, int digit) {
        int answer = num;
        if(digit <0 || digit > 9) throw new IllegalArgumentException("Bad param");
        while(true){
            answer--;
            if(!contains(answer, digit)) break;
        }
        return answer;
    }

    private static boolean contains(int num, int digit) {
        return Integer.toString(num).contains(Integer.toString(digit));
    }
}
