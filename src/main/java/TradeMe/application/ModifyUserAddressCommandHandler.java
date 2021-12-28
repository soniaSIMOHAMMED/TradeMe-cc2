package TradeMe.application;

import TradeMe.domain.Address;
import TradeMe.domain.Id;
import TradeMe.domain.UserRepository;
import TradeMe.kernel.CommandHandler;
import TradeMe.kernel.Event;
import TradeMe.kernel.EventDispatcher;

public class ModifyUserAddressCommandHandler implements CommandHandler<ModifyUserAddress, Void> {
    private final UserRepository userRepository;
    private final EventDispatcher<Event> eventEventDispatcher;

    public ModifyUserAddressCommandHandler(UserRepository userRepository, EventDispatcher<Event> eventEventDispatcher) {
        this.userRepository = userRepository;
        this.eventEventDispatcher = eventEventDispatcher;
    }

    @Override
    public Void handle(ModifyUserAddress command) {
        var userId = new Id(command.userId);
        var user = userRepository.byId(userId);
        var address = new Address(command.address.number,command.address.street,command.address.city);
        user.changeAddress(address);
        userRepository.addUser(user);
        eventEventDispatcher.dispatch((Event) new ModifyUserAddressEvent(userId));
        return null;
    }
}

