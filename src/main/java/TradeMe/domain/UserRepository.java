package TradeMe.domain;

import java.util.List;

public interface UserRepository {

    void save(User user);

    User byId(Id id);

    void addUser(User user);

    void removeUser(Id id);

    Id nextIdentity();

    List<User> findAll();

}
