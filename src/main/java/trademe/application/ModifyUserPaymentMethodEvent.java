package trademe.application;

import trademe.domain.Id;
import trademe.kernel.ApplicationEvent;

public final class ModifyUserPaymentMethodEvent implements ApplicationEvent {
    private final Id userId;

    public ModifyUserPaymentMethodEvent(Id userId) {
        this.userId = userId;
    }
}
