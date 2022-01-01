package trademe.application;

import trademe.domain.Id;
import trademe.domain.UserRepository;
import trademe.exposition.PaymentMethodDTO;
import trademe.kernel.CommandHandler;
import trademe.kernel.Event;
import trademe.kernel.EventDispatcher;

public final class ModifyUserPaymentMethodCommandHandler implements CommandHandler<ModifyUserPaymentMethod, Void> {
    private final UserRepository userRepository;
    private final EventDispatcher<Event> eventEventDispatcher;

    public ModifyUserPaymentMethodCommandHandler(UserRepository userRepository, EventDispatcher<Event> eventEventDispatcher) {
        this.userRepository = userRepository;
        this.eventEventDispatcher = eventEventDispatcher;
    }

    @Override
    public Void handle(ModifyUserPaymentMethod command) {
        var userId = new Id(command.userId);
        var user = userRepository.findUserById(userId);
        PaymentMethodDTO payment = new PaymentMethodDTO(command.paymentMethod);
        user.changePaymentMethod(payment);
        userRepository.addUser(user);
        eventEventDispatcher.dispatch((Event) new ModifyUserPaymentMethodEvent(userId));
        return null;
    }

}
