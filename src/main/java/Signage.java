import java.util.Arrays;
import java.util.stream.Collectors;

public class Signage {

  public static void main(String[] args) {
    System.out.println(new Signage(14645741).display());
  }

  private int num;

  public Signage(int num) {
    this.num = num;
  }

  private int[] extractDigits() {
    int number = this.num;
    int length = String.valueOf(num).length();
    int[] digs = new int[length];
    int i = length - 1;
    while (number > 0) {
      digs[i--] = number % 10;
      number = number / 10;
    }
    return digs;
  }

  public String display() {
    StringBuilder[] rows = new StringBuilder[3];
    int[] digs = extractDigits();
    for (int i = 0; i < digs.length; i++) {
      for (int j = 0; j < 3; j++) {
        if (rows[j] == null) {
          rows[j] = new StringBuilder();
        }
        rows[j].append(DigitPatterns.values()[digs[i]].getRows()[j]);
      }
    }
    return Arrays.stream(rows).map(x -> (x.append("\n")).toString()).collect(Collectors.joining());
  }

  private enum DigitPatterns {
    ZERO(new String[]{
        " _ ",
        "| |",
        "|_|"
    }),

    ONE(new String[]{
        "   ",
        " | ",
        " | "
    }),
    TWO(new String[]{
        " _ ",
        " _|",
        "|_ "
    }),
    THREE(new String[]{
        " _ ",
        " _|",
        " _|"
    }),

    FOUR(new String[]{
        "   ",
        "|_|",
        "  |"
    }),
    FIVE(new String[]{
        " _ ",
        "|_ ",
        " _|"
    }),
    SIZ(new String[]{
        " _ ",
        "|_ ",
        "|_|"
    }),
    SEVEN(new String[]{
        " _ ",
        "  |",
        "  |"
    }),
    EIGHT(new String[]{
        " _ ",
        "|_|",
        "|_|"
    }),
    NINE(new String[]{
        " _ ",
        "|_|",
        " _|"
    });

    private String[] rows;

    DigitPatterns(String[] rows) {
      this.rows = rows;
    }

    public String[] getRows() {
      return rows;
    }
  }
}
