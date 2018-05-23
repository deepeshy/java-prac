import java.util.*;

public class LongestSubstringNonRepeatingChars {
    public static void main(String[] args) {
//        System.out.println(longestSubstringNonRepeatingChars("abccdefghij"));
//        System.out.println(longestSubstringNonRepeatingCharsFixedArray("abccdefghij"));
        printAscii();
    }

    private static void printAscii() {
        for (int i = 0; i < 256; i++) {
            System.out.print(i + ":" + (char) i);
            System.out.print(" ");
            if (i % 30 == 0) System.out.println();
        }
    }

    // Using a fixed sized character array to keep track of positions
    private static int longestSubstringNonRepeatingCharsFixedArray(String str) {
        int[] pos = new int[256];
        int len = Integer.MIN_VALUE;
        int currLen = 0;

        for (int i = 0; i < str.length(); i++) {
            int positionOfCurrentChar = pos[str.charAt(i)];
            if (positionOfCurrentChar != 0) {
                i = positionOfCurrentChar + 1;
                if (currLen > len) {
                    len = currLen;
                    pos = new int[256];
                    currLen = 0;
                }

            } else {
                pos[str.charAt(i)] = i;
                currLen++;
            }
        }
        if (currLen > len) {
            len = currLen;
        }
        return len;
    }

    // Using a set to keep track of the current substring until a character repeats
    private static int longestSubstringNonRepeatingChars(String str) {
        int len = Integer.MIN_VALUE;
        int currLen = 0;
        Map<Character, Integer> subStringChars = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            Integer pos = subStringChars.get(str.charAt(i));
            if (pos != null) { // Character repeats
                i = pos + 1;
                if (currLen > len) {
                    len = currLen;
                    subStringChars.clear();
                    currLen = 0;
                }
            } else { // New Character
                currLen++;
                subStringChars.put(str.charAt(i), i);
            }
        }

        if (currLen > len) {
            len = currLen;
        }
        return len;
    }
}
