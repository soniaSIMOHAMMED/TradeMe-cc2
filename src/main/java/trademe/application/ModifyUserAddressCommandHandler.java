package trademe.application;

import trademe.domain.Id;
import trademe.domain.UserRepository;
import trademe.exposition.AddressDTO;
import trademe.kernel.CommandHandler;
import trademe.kernel.Event;
import trademe.kernel.EventDispatcher;

public final class ModifyUserAddressCommandHandler implements CommandHandler<ModifyUserAddress, Void> {
    private final UserRepository userRepository;
    private final EventDispatcher<Event> eventEventDispatcher;

    public ModifyUserAddressCommandHandler(UserRepository userRepository, EventDispatcher<Event> eventEventDispatcher) {
        this.userRepository = userRepository;
        this.eventEventDispatcher = eventEventDispatcher;
    }

    @Override
    public Void handle(ModifyUserAddress command) {
        var userId = new Id(command.userId);
        var user = userRepository.findUserById(userId);
        AddressDTO address = new AddressDTO(command.address.number,command.address.street,command.address.city);
        user.changeAddress(address);
        userRepository.addUser(user);
        eventEventDispatcher.dispatch((Event) new ModifyUserAddressEvent(userId));
        return null;
    }
}

