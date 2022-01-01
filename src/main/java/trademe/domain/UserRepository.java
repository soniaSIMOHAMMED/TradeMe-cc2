package trademe.domain;

import trademe.exposition.PaymentMethodDTO;
import trademe.exposition.UserDTO;

import java.util.List;

public interface UserRepository {

    void save(UserDTO user);
    void deleteUser(Id userId);
    UserDTO findUserById(Id userId);
    List<UserDTO> findAll();
    List<UserDTO> findByCity(String city);
    Id nextIdentity();
    void addUser(UserDTO user);
    void changePaymentMethod(PaymentMethodDTO payment);
    void pay(PaymentMethodDTO payment, double amount);
}
