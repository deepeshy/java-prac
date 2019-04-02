import com.sun.istack.internal.NotNull;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class BracketMatcher {

  public static void main(String[] args) {
    BracketMatcher bracketMatcher = new BracketMatcher();
    System.out.println(bracketMatcher.isExprBalanced("{{6{}}}"));
    System.out.println(bracketMatcher.isExprBalanced("[{{}}]"));
    System.out.println(bracketMatcher.isExprBalanced("([{}]]}"));
    System.out.println(bracketMatcher.isExprBalanced("{{2{3}55}6}6"));
  }

  private Map<Character, Character> bracketPairs = new HashMap<>();

  {
    bracketPairs.put('{', '}');
    bracketPairs.put('(', ')');
    bracketPairs.put('[', ']');
  }


  private boolean isExprBalanced(@NotNull String expr) {
    // Always go for ArrayDeque by default, more complete DS and faster than Stack
    // or LinkedList
    Deque<Character> b = new ArrayDeque<>();

    for (int i = 0; i < expr.length(); i++) {
      if (isOpeningBracket(expr.charAt(i))) {
        b.push(expr.charAt(i));
      }

      if (isClosingBracket(expr.charAt(i))) {
        if (b.isEmpty() || expr.charAt(i) != bracketPairs.get(b.pop())) {
          return false;
        }
      }
    }
    return true;
  }

  // O(1) for checking, faster than traversing keys
  private boolean isOpeningBracket(char b) {
    return bracketPairs.get(b) != null;
  }

  // O(n)
  private boolean isClosingBracket(char b) {
    return bracketPairs.values().contains(b);
  }

}
