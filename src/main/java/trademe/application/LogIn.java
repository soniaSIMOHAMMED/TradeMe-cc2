package trademe.application;

import trademe.domain.Id;
import trademe.domain.UserRepository;
import trademe.infrastructure.InMemoryUserRepository;
import trademe.kernel.InvalidInputException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LogIn{

    UserRepository userRepository;
    UserService userService;

    public LogIn(UserService userService,UserRepository userRepository){
        this.userRepository = userRepository;
        this.userService = new DefaultUserService(this.userRepository);
    }

    public void logIn(){

        Scanner scan = new Scanner(System.in);
        List invalidInput = new ArrayList();

        System.out.println("Enter a user id => ");
        int userId = scan.nextInt();
        Id id = Id.of(userId);


        System.out.println("Enter your email => ");
        String email = scan.next();
        if(!VerifyApplication.checkEmail(email)){
            invalidInput.add(new InvalidInputException("Please insert a valid Email !"));
        }

        System.out.println("Enter a password => ");
        String password = scan.next();
        if(password.isEmpty()){
            invalidInput.add(new InvalidInputException("Password should not be empty !"));
        }


        if(invalidInput.isEmpty()){

            if(this.userService.checkIdentity(id,email,password)){
                System.out.println("You have been connected successfully !");
            }else{
                System.out.println("Your connection have been rejected, you don't exist in the database !");
            }


        }else{

            for(Object e : invalidInput){
                System.out.println(e);
                continue;
            }

            System.out.println("Please redo your re-log :");

        }



    }

    public static void main(String[] args) {

        UserRepository userRepository = new InMemoryUserRepository();
        UserService userService = new DefaultUserService(userRepository);

        LogIn userLogIn = new LogIn(userService,userRepository);
        userLogIn.logIn();


    }


}
