package trademe.application;

import trademe.domain.Id;
import trademe.kernel.ApplicationEvent;

public final class ModifyUserAddressEvent implements ApplicationEvent {
    private final Id userId;

    public ModifyUserAddressEvent(Id userId) {
        this.userId = userId;
    }
}
