public class Immutability {


  public static void main(String[] args) {
    DummyClass s = new DummyClass("orig desc");
    paramImmutable(s);
    System.out.println(s.getDesc());

    DummyClass s2 = new DummyClass("orig desc");
    paramNotImmutable(s2);
    System.out.println(s2.getDesc());


    DummyClass s3 = new DummyClass("orig desc");
    mutate(s3);
    System.out.println(s3.getDesc());
  }

  private static void paramNotImmutable(DummyClass a) {
    a.setDesc("not immutable");
  }

  private static void paramImmutable(final DummyClass a) {
    a.setDesc("not immutable");
  }

  // adding a final will make the method throw a compile error
  public static void mutate(DummyClass x){
    x = new DummyClass("born in mutate");
  }

  private static class DummyClass {

    String desc;

    public DummyClass(String desc) {
      this.desc = desc;
    }

    public void setDesc(String desc) {
      this.desc = desc + desc;
    }

    public String getDesc() {
      return desc;
    }
  }

}
