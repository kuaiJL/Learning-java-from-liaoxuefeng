package a_javaClassicBook.InputOutput.Optional_;

import java.util.Optional;

public class optionalDemo2 {

    public static void main(String[] args) {
        Optional<Address> address1 = Optional.of(
                new Address(Optional.ofNullable(null),
                        Optional.of("New York")));
        Optional<Office> office1 = Optional.of(new Office("OF1", address1));
        Optional<Company> company1 = Optional.of(new Company("Door Never Closed", office1));

        // What is the street address of company1?
        // In which city company1 is located?
        Optional<Office> maybeOffice = company1.flatMap(Company::getOffice);
        Optional<Address> maybeAddress = maybeOffice.flatMap(Office::getAddress);
        Optional<String> maybeStreet = maybeAddress.flatMap(Address::getStreet);
        maybeStreet.ifPresent(System.out::println);//如果不为空输出至控制台，否则啥也不干
        if (maybeStreet.isPresent()) {
            System.out.println(maybeStreet.get());
        } else {
            System.out.println("Street not found");
        }

        // shorter way
        String city = company1.flatMap(Company::getOffice)
                .flatMap(Office::getAddress)
                .flatMap(Address::getCity)
                .orElse("City not found");
        System.out.println("City: " + city);

        // only print if city is not null，！！！if null 啥也不输出
        company1.flatMap(Company::getOffice)
                .flatMap(Office::getAddress)
                .flatMap(Address::getCity)
                .ifPresent(System.out::println);
    }
}

class Company {
    private String name;
    private Optional<Office> office;
    public Company(String name, Optional<Office> office) {
        this.name = name;
        this.office = office;
    }
    public String getName() {
        return name;
    }
    public Optional<Office> getOffice() {
        return office;
    }
}
class Office {
    private String id;
    private Optional<Address> address;
    public Office(String id, Optional<Address> address) {
        this.id = id;
        this.address = address;
    }
    public String getId() {
        return id;
    }
    public Optional<Address> getAddress() {
        return address;
    }
}
class Address {
    private Optional<String> street;
    private Optional<String> city;
    public Address(Optional<String> street, Optional<String> city) {
        this.street = street;
        this.city = city;
    }
    public Optional<String> getStreet() {
        return street;
    }
    public Optional<String> getCity() {
        return city;
    }
}
