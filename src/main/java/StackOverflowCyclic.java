public class StackOverflowCyclic {

  public static void main(String[] args) {
    new C1();
  }

  private static class C1 {

    private int i;
    private C2 c2;

    public C1() {
      this.i = 0;
      c2 = new C2();
    }
  }

  private static class C2 {

    private int i;
    private C1 c1;

    public C2() {
      this.i = 0;
      this.c1 = new C1();
    }
  }
}
