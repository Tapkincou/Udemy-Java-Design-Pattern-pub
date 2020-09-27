package FACTORY.exercice;

public class Person
{
    public int id;
    public String name;

    public Person(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }



}

class PersonFactory
{
    private int incrementer = 0;

    public Person createPerson(String name)
    {
        return new Person(incrementer++, name);
    }
}
