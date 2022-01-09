package trademe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import trademe.application.DefaultUserService;
import trademe.application.LogIn;
import trademe.application.Subscription;
import trademe.application.UserService;
import trademe.domain.UserRepository;
import trademe.infrastructure.InMemoryUserRepository;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

        System.out.println("-------------- START APP --------------");


        UserRepository userRepository = new InMemoryUserRepository();
        UserService userService = new DefaultUserService(userRepository);

        // Subscription
        Subscription userSubscription = new Subscription(userService,userRepository);
        userSubscription.subscribe();



        System.out.println("-------------- END APP --------------");


    }
}
