package BUILDER.FACATEDBUILDER;

public class Person {

    public String postcode;

    public String city;

    public String companyName, position, streetAddress;

    public int annualIncome;

    @Override
    public String toString() {
        return "Person{" +
                "postcode='" + postcode + '\'' +
                ", city='" + city + '\'' +
                ", companyName='" + companyName + '\'' +
                ", position='" + position + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", annualIncome=" + annualIncome +
                '}';
    }

}

// builder facade
class PersonBuilder {
    protected Person person = new Person();

    public PersonAddressBuilder lives(){
        return new PersonAddressBuilder(person);
    }

    public PersonJobBuilder works() {
        return new PersonJobBuilder(person);
    }

    public Person build() {
        return person;
    }
}

class PersonAddressBuilder extends PersonBuilder {
    public PersonAddressBuilder(Person person) {
        this.person = person;
    }


    // with this kind of implementation we can
    //  separate  attributes by categories using sub-builders
    //  USEFULL with complicated objects!!
    public PersonAddressBuilder at(String streetAddress){
        person.streetAddress = streetAddress;
        return this;
    }

    public PersonAddressBuilder withPostCode(String postCode){
        person.postcode = postCode;
        return this;
    }

    public PersonAddressBuilder in(String city){
        person.city = city;
        return this;
    }

}

class PersonJobBuilder extends PersonBuilder {

    public PersonJobBuilder(Person person) {
        this.person = person;
    }

    public PersonJobBuilder atCompany(String companyName){
        person.companyName = companyName;
        return this;
    }

    public PersonJobBuilder asA(String position){
        person.position = position;
        return this;
    }

    public PersonJobBuilder earning(int annualIncome) {
        person.annualIncome = annualIncome;
        return this;
    }


}

class Demo {
    public static void main(String[] args) {
        PersonBuilder pb = new PersonBuilder();

        Person person = pb
                .lives()
                        .at("3 rue de chez lui")
                        .in("London")
                        .withPostCode("76000")
                .works()
                        .asA("champion")
                        .atCompany("mamène")
                        .earning(500)
                .build();

        System.out.println(person);

    }
}
