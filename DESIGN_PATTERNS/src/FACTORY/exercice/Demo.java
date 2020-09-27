package FACTORY.exercice;

public class Demo {

    public static void main(String[] args){
        PersonFactory factory = new PersonFactory();
        System.out.println(factory.createPerson("michel"));
        System.out.println(factory.createPerson("guy"));
        System.out.println(factory.createPerson("jean"));

    }

}
