package SINGLETON;

public class Monostate {

  public static void main(String[] args) {
  ChiefExecutiveOfficer ceo = new ChiefExecutiveOfficer();
  ceo.setAge(20);ceo.setName("prout1");
  ChiefExecutiveOfficer ceo2 = new ChiefExecutiveOfficer();
  ceo2.setAge(40);
  ceo2.setName("bite");

  System.out.println(ceo.toString());
    System.out.println(ceo2.toString());
  }
}

class ChiefExecutiveOfficer{

  // make attributes static so each instances share the same storage
  private static String name;
  private static int age;

  @Override
  public String toString() {
    return "ChiefExecutiveOfficer{" +
      "name='" + name + '\'' +
      ", age=" + age +
      '}';
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }
}
