package trademe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import trademe.application.*;
import trademe.domain.Id;
import trademe.domain.User;
import trademe.domain.UserRepository;
import trademe.exposition.AddressDTO;
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
        //create AddressDTO
        AddressDTO address = new AddressDTO();
        address.setStreet("34");
        address.setStreet("Lyderic");
        address.setCity("Lille");
        
        //create UserDTO
        UserDTO user = new UserDTO();
        user.setUserId("123");
        user.setPhoneNumber("0650837433");
        user.setFirstname("Ines");
        user.setLastname("Bekkouche");
        user.setPassword("testok");
        user.setEmail("b@live.com");
        user.setAge(22);
        user.setAddress(address);
        userRepository.save(user);

        //payment
        CreditCardPayment card2 = new CreditCardPayment("KECHIOUCH","123","1256789871","20/01/2025" );

        PayPerMonthCommandHandler payPerMonthCommandHandler = new PayPerMonthCommandHandler(userRepository, eventEventDispatcher);
        payPerMonthCommandHandler.handle(new PayPerMonth(Integer.valueOf(user.getUserId()),card2,100.0));



        System.out.println("-------------- END APP --------------");


    }
}
