package trademe.application;

import trademe.domain.Id;
import trademe.kernel.ApplicationEvent;

public final class PayPerMonthEvent implements ApplicationEvent {
    private final Id userId;

    public PayPerMonthEvent(Id userId) {
        this.userId = userId;
    }

}
