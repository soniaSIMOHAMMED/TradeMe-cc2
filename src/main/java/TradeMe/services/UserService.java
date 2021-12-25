package TradeMe.services;

import TradeMe.domain.Id;
import TradeMe.domain.User;

import java.util.List;

public interface UserService {

     void create(User user);
     void changePassword(Id UserId, String newPassword);
     User getUserById(Id userId);
     void addUser(User user);
     void removeUser(Id userId);
     List<User> all();

}
