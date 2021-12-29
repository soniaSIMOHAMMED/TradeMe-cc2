package TradeMe.application;

import TradeMe.domain.Id;
import TradeMe.domain.UserRepository;
import TradeMe.exposition.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultUserService implements UserService {

    private final UserRepository userRepository;

    public DefaultUserService(UserRepository UserRepository) {
        this.userRepository = UserRepository;
    }

    @Override
    public void createUser(UserDTO user) {

        user.setUserId(""+ userRepository.nextIdentity().getValue());
        this.userRepository.save(user);
    }

    @Override
    public void deleteUser(Id userId) {this.userRepository.deleteUser(userId);}

    @Override
    public UserDTO findUserById(Id userId){ return this.userRepository.findUserById(userId);}

    @Override
    public List<UserDTO> findAll() { return this.userRepository.findAll(); }

    @Override
    public List<UserDTO> findByCity(String city) {return this.userRepository.findByCity(city);}

   /* @Override
    public void changePassword(Id UserId, String newPassword) {
        UserDTO user = this.userRepository.findById(UserId);
        user.changePassword(newPassword);
        this.userRepository.save(user);
    }*/



    /*@Override
    public void addUser(UserDTO user){
        this.userRepository.addUser(user);
    }*/



}
