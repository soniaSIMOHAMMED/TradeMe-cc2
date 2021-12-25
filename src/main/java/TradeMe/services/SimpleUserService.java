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
    public void changePassword(Id UserId, String newPassword) {
        var user = this.userRepository.byId(UserId);
        user.changePassword(newPassword);
        this.userRepository.save(user);
    }

    @Override
    public User getUserById(Id userId){
        return this.userRepository.byId(userId);
    }

    @Override
    public void addUser(User user){
        this.userRepository.addUser(user);
    }

    @Override
    public void removeUser(Id userId)
    {
        this.userRepository.removeUser(userId);
    }
    @Override
    public List<User> all() {
        return this.userRepository.findAll();
    }
}
