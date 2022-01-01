package trademe.application;

import trademe.domain.Id;
import trademe.exposition.UserDTO;

import java.util.List;

public interface UserService {

     void createUser(UserDTO user);
     void deleteUser(Id userId);
     UserDTO findUserById(Id userId);
     List<UserDTO> findAll();
     List<UserDTO> findByCity(String city);

    void addUser(UserDTO user);

    //void changePassword(Id UserId, String newPassword);

}
