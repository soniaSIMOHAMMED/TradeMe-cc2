package TradeMe.application;

import TradeMe.domain.Id;
import TradeMe.exposition.UserDTO;

import java.util.List;

public interface UserService {

     void createUser(UserDTO user);
     void deleteUser(Id userId);
     UserDTO findUserById(Id userId);
     List<UserDTO> findAll();
     List<UserDTO> findByCity(String city);

     //void changePassword(Id UserId, String newPassword);

}
