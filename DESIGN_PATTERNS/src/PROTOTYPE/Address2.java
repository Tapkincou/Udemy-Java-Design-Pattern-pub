package PROTOTYPE;

public class Address2 {

    public String streetAddress, city, country;

    public Address2(String streetAddress, String city, String country) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.country = country;
    }


    // A copy constructor (deep copy)
    public Address2(Address2 other){
        this(other.streetAddress, other.city,other.country);
    }




    @Override
    public String toString() {
        return "Address2{" +
                "streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}

class Employee {

    String name;

    Address2 address;

    public Employee(String name, Address2 address) {
        this.name = name;
        this.address = address;
    }

    // deep constructor (deep copy)
    public Employee(Employee other) {
        name = other.name;
        address = new Address2(other.address);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }


}

class CopyConstructorDemo {

    public static void main(String[] args) {

        Employee john = new Employee("John", new Address2("123 London Road", "Brighton", "UK"));

        //Employee chris = john : USING THE COPY CONSTRUCTOR :)
        Employee chris = new Employee(john);
        chris.name = "Chris";


        System.out.println(john);
        System.out.println(chris);

    }

}