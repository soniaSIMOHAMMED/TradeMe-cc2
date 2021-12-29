package TradeMe.application;

import TradeMe.domain.UserRepository;
import TradeMe.exposition.AddressDTO;
import TradeMe.exposition.UserDTO;
import TradeMe.infrastructure.InMemoryUserRepository;

import java.util.Scanner;

public class Subscription {

    UserRepository userRepository;
    UserService userService;

    public Subscription(UserService userService,UserRepository userRepository){
        this.userRepository = userRepository;
        this.userService = new DefaultUserService(this.userRepository);
    }


    public void subscribe(){


        Scanner scan = new Scanner(System.in);
        UserDTO user = new UserDTO();


        System.out.println("Enter your fist name => ");
        String firstname = scan.nextLine();
        user.setFirstname(firstname);

        System.out.println("Enter your last name => ");
        String lastname = scan.nextLine();
        user.setLastname(lastname);


        System.out.println("Enter your age => ");
        int age = scan.nextInt();
        user.setAge(age);


        AddressDTO address = new AddressDTO();
        System.out.println("Enter your location : ");
        System.out.println(" * Enter street number => ");
        String number = scan.nextLine();
        address.setNumber(number);

        System.out.println(" * Enter street name => ");
        String street = scan.nextLine();
        address.setStreet(street);

        System.out.println(" * Enter city name => ");
        String city = scan.nextLine();
        address.setCity(city);


        user.setAddress(address);


        System.out.println("Enter your email => ");
        String email = scan.nextLine();
        user.setEmail(email);

        System.out.println("Enter a password =>");
        String password = scan.nextLine();
        user.setPassword(password);


        scan.close();

        userService.createUser(user);
        System.out.println("User"+user.toString()+" ! Congratulation you've been successfully subscribed ! ");

    }

    public static void main(String[] args) {

        UserRepository userRepository = new InMemoryUserRepository();
        UserService userService = new DefaultUserService(userRepository);

        Subscription subscription = new Subscription(userService,userRepository);

        subscription.subscribe();

    }



}
