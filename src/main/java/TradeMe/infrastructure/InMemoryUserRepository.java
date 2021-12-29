package TradeMe.infrastructure;

import TradeMe.domain.Id;
import TradeMe.domain.User;
import TradeMe.domain.UserRepository;
import TradeMe.exposition.UserDTO;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class InMemoryUserRepository implements UserRepository {

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




}