package TradeMe;

import TradeMe.domain.UserRepository;
import TradeMe.infrastructure.InMemoryUserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfiguration {
    /*@Bean
    public UserRepository userRepository() {
        return new InMemoryUserRepository();
    }*/
}