package trademe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import trademe.application.*;
import trademe.domain.Id;
import trademe.domain.User;
import trademe.domain.UserRepository;
import trademe.exposition.UserDTO;
import trademe.infrastructure.InMemoryUserRepository;
import trademe.kernel.Event;
import trademe.kernel.EventDispatcher;

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

        // Payment
        EventDispatcher<Event> eventEventDispatcher = event -> System.out.println("Dispatching Event " + event.getClass().getName());

        User user = new User(Id.of(123),"LOLA","Ines");
        CreditCardPayment card2 = new CreditCardPayment("KECHIOUCH","123","1256789871","20/01/2025" );

        PayPerMonthCommandHandler payPerMonthCommandHandler = new PayPerMonthCommandHandler(userRepository, eventEventDispatcher);
        payPerMonthCommandHandler.handle(new PayPerMonth(user.getUserId().getValue(),card2,100.0));



        System.out.println("-------------- END APP --------------");


    }
}
