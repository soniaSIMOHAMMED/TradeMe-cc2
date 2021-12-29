package TradeMe.domain;

import TradeMe.exposition.UserDTO;

import java.util.List;

public interface UserRepository {

    void save(UserDTO user);
    void deleteUser(Id userId);
    UserDTO findUserById(Id userId);
    List<UserDTO> findAll();
    List<UserDTO> findByCity(String city);
    Id nextIdentity();



}
