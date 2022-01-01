package trademe.application;

import trademe.domain.Id;
import trademe.domain.Payment;
import trademe.domain.UserRepository;
import trademe.kernel.CommandHandler;
import trademe.kernel.Event;
import trademe.kernel.EventDispatcher;

public final class PayPerMonthCommandHandler implements CommandHandler<PayPerMonth, Void> {
    private final UserRepository userRepository;
    private final EventDispatcher<Event> eventEventDispatcher;
    private double amount;

    public PayPerMonthCommandHandler(UserRepository userRepository, EventDispatcher<Event> eventEventDispatcher) {
        this.userRepository = userRepository;
        this.eventEventDispatcher = eventEventDispatcher;
    }

    @Override
    public Void handle(PayPerMonth command) {
        var userId = new Id(command.userId);
        var user = userRepository.findUserById(userId);
        Payment payment = new ProcessPayment(command.paymentMethod);
        user.pay(payment,amount);
        userRepository.addUser(user);
        eventEventDispatcher.dispatch((Event) new PayPerMonthEvent(userId));
        return null;
    }
}
