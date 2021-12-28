package TradeMe.services;

import TradeMe.domain.Id;
import TradeMe.domain.User;
import TradeMe.domain.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimpleUserService implements UserService {
    private final UserRepository userRepository;

    public SimpleUserService(UserRepository UserRepository) {
        this.userRepository = UserRepository;
    }

    @Override
    public void create(User user) {
        this.userRepository.save(user);
    }

    @Override
    public void changePassword(Id Id, String newPassword) {
        var user = this.userRepository.byId(Id);
        user.changePassword(newPassword);
        this.userRepository.save(user);
    }

    @Override
    public User getUserById(Id id){
        return this.userRepository.byId(id);
    }

    @Override
    public void addUser(User user){
        this.userRepository.addUser(user);
    }

    @Override
    public void removeUser(Id id)
    {
        this.userRepository.removeUser(id);
    }
    @Override
    public List<User> all() {
        return this.userRepository.findAll();
    }
}
