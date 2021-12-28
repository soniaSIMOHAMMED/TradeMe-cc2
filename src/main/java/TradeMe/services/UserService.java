package TradeMe.services;

import TradeMe.domain.Id;
import TradeMe.domain.User;

import java.util.List;

public interface UserService {

     void create(User user);
     void changePassword(Id Id, String newPassword);
     User getUserById(Id id);
     void addUser(User user);
     void removeUser(Id id);
     List<User> all();

}
