package BUILDER;


public class Person {

    private String name;
    private String position;
    public Person(String name) {
        this.name = name;
    }


    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}


// in order to make your builder extendable you must use generics and introduce a method "self()"
// returning "(SELF) this" to override in child implementation
// without this, your child class is unusable because the children methods will not return the parent self type


class PersonBuilder<SELF extends PersonBuilder<SELF>>{

    protected Person person = new Person();


    public PersonBuilder() {

    }

    public SELF withName(String name){

        person.setName(name);
        return self();
    }

    public Person build () {
        return this.person;
    }

    protected SELF self() {
        return (SELF) this;
    }

}

class Demo2 {
    public static void main (String [] args) {

        EmployeeBuilder pb = new EmployeeBuilder();
        Person jacques = pb
                .withName("jacques")
                .worksAt("president")
                .build();
        System.out.println(jacques);
    }
}

class EmployeeBuilder extends PersonBuilder<EmployeeBuilder> {
    public EmployeeBuilder worksAt(String position) {
        person.setPosition(position);
        return self();
    }

    @Override
    protected EmployeeBuilder self() {
        return this;
    }
}