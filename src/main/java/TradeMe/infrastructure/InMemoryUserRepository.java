package TradeMe.infrastructure;

import TradeMe.domain.Id;
import TradeMe.domain.User;
import TradeMe.domain.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class InMemoryUserRepository implements UserRepository {
    private final AtomicInteger counter = new AtomicInteger(0);
    private final Map<Id, User> data = new ConcurrentHashMap<>();

    @Override
    public void save(User user) {
        data.put(user.getUserId(), user);
    }

    @Override
    public User byId(Id userId) {
        final User user = data.get(userId);
        if (user == null) {
            throw new RuntimeException("No member for " + userId.getValue());
        }
        return user;
    }

    @Override
    public void addUser(User user){
        this.data.put(user.getUserId(),user);
    }

    @Override
    public void removeUser(Id userId){
        this.data.remove(userId);
    }

    @Override
    public Id nextIdentity() {
        return Id.of(counter.incrementAndGet());
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(data.values());
    }
}