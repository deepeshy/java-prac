import java.util.Arrays;

public class DeepToString {
    public static void main(String[] args) {
        String[][] twoDArr = {
                {"11","12","13"},
                {"21","22","23"},
                {"31","32","33"},
                {"41","42","43"},
        };

        System.out.println(Arrays.deepToString(twoDArr));
    }
}
