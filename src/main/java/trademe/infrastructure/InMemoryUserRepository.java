package trademe.infrastructure;

import trademe.domain.Id;
import trademe.domain.UserRepository;
import trademe.exposition.PaymentMethodDTO;
import trademe.exposition.UserDTO;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public final class InMemoryUserRepository implements UserRepository {

    private final AtomicInteger counter = new AtomicInteger(0);
    private final Map<Id, UserDTO> data = new ConcurrentHashMap<>();


    @Override
    public void save(UserDTO user) {data.put(user.getId(), user);}

    @Override
    public void deleteUser(Id userId){
        this.data.remove(userId);
    }

    @Override
    public UserDTO findUserById(Id userId) {
        final UserDTO user = data.get(userId);
        if (user == null) {
            throw new RuntimeException("No member for " + userId.getValue());
        }
        return user;
    }

    @Override
    public List<UserDTO> findAll() {return new ArrayList<UserDTO>(data.values());}

    @Override
    public List<UserDTO> findByCity(String city) {
        return List.copyOf(data.values().stream().filter(
                user -> user.getAddress().getCity().equals(city)).collect(Collectors.toList()));
    }


    @Override
    public Id nextIdentity() {
        return Id.of(counter.incrementAndGet());
    }

    @Override
    public void addUser(UserDTO user) {

    }

    @Override
    public void changePaymentMethod(PaymentMethodDTO payment) {
    }

    @Override
    public void pay(PaymentMethodDTO payment, double amount) {

    }

    @Override
    public boolean checkIdentity(Id userId, String email, String password){

        return data.containsKey(userId) && data.get(userId).getEmail().equals(email) && data.get(userId).getPassword().equals(password);

    }


}