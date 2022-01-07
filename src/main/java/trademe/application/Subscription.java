package trademe.application;

import trademe.domain.*;
import trademe.exposition.AddressDTO;
import trademe.exposition.UserDTO;
import trademe.infrastructure.InMemoryUserRepository;
import trademe.kernel.InvalidInputException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public final class Subscription {

    UserRepository userRepository;
    UserService userService;

    public Subscription(UserService userService,UserRepository userRepository){
        this.userRepository = userRepository;
        this.userService = new DefaultUserService(this.userRepository);
    }


    public void subscribe(){

        List invalidInput = new ArrayList();
        List skills = new ArrayList<String>();
        AddressDTO addressDTO = new AddressDTO();
        List<Project> projects = new ArrayList<>();
        Id userId = userRepository.nextIdentity();

        Trade trade = null;
        int dailyRate = 0;

        // on ne rempli les disponibilitées pour le moment
        HashMap<String, List<String>> disponibility = new HashMap<>();


        Scanner scan = new Scanner(System.in);
        UserDTO user = new UserDTO();


        System.out.println("Enter your fist name => ");
        String firstname = scan.next();

        System.out.println("Enter your last name => ");
        String lastname = scan.next();


        System.out.println("Enter your age => ");
        int age = scan.nextInt();
        if(!VerifyApplication.checkAge(age)){
            invalidInput.add(new InvalidInputException("Sorry! your age doesn't allow you to apply !"));
        }



        System.out.println("Enter street number => ");
        String number = scan.next();
        addressDTO.setNumber(number);

        System.out.println("Enter street name => ");
        String street = scan.next();
        addressDTO.setStreet(street);

        System.out.println("Enter city name => ");
        String city = scan.next();
        addressDTO.setCity(city);

        Address address = Address.of(number,street,city);
        if(VerifyApplication.checkAddress(address)){
            invalidInput.add(new InvalidInputException("Please insert a valid address !"));
        }

        System.out.println("Enter your phone number => ");
        String phone = scan.next();
        if(!VerifyApplication.checkPhone(phone)){
            invalidInput.add(new InvalidInputException("Please insert a valid Phone number !"));
        }



        System.out.println("Enter your email => ");
        String email = scan.next();
        if(!VerifyApplication.checkEmail(email)){
            invalidInput.add(new InvalidInputException("Please insert a valid Email !"));
        }

        System.out.println("Enter a password =>");
        String password = scan.next();
        if(password.isEmpty()){
            invalidInput.add(new InvalidInputException("Password should not be empty !"));
        }

        System.out.println("Type C for Contractor or T for Tradesman => ");
        String userType = scan.next();

        if(userType == "T"){

            System.out.println("Enter your trade => ");
            String job = scan.next();
            trade = Trade.valueOf(job);
            if(!VerifyApplication.checkTrade(trade)){
                invalidInput.add(new InvalidInputException("Please insert a valid Trade !"));
            }

            System.out.println("Enter your skills, when you finish type OK => ");
            while (scan.next() != "OK"){
                String skill = scan.next();
                skills.add(skill);
            }

            System.out.println("Enter your dailyRate => ");
             dailyRate = scan.nextInt();


        }


        scan.close();

        if(invalidInput.isEmpty()){

            user.setFirstname(firstname);
            user.setLastname(lastname);
            user.setAge(age);
            user.setAddress(addressDTO);
            user.setEmail(email);
            user.setPhoneNumber(phone);
            user.setPassword(password);

            userService.createUser(user);
            System.out.println("User"+user.toString()+" ! Congratulation you've been successfully subscribed ! ");


            if(userType == "C"){
                User contractor = Contractor.of(userId,lastname,firstname,age,address,phone,email,password,projects);
            }

            if(userType == "T"){
                User tradesmane = Tradesman.of(userId,lastname,firstname,age,address,phone,email,password,trade,skills,disponibility,dailyRate);
            }




        }else{

            for(Object e : invalidInput){
                System.out.println(e);
                continue;
            }

            System.out.println("Please redo your registration :");
            //subscribe();

        }






    }

    public static void main(String[] args) {

        UserRepository userRepository = new InMemoryUserRepository();
        UserService userService = new DefaultUserService(userRepository);

        Subscription subscription = new Subscription(userService,userRepository);

        subscription.subscribe();


    }



}
