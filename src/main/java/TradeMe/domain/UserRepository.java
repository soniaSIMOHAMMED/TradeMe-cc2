package TradeMe.domain;

import java.util.List;

public interface UserRepository {

    void save(User user);

    User byId(Id userId);

    void addUser(User user);

    void removeUser(Id userId);

    Id nextIdentity();

    List<User> findAll();
}
