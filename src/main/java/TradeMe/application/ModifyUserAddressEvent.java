package TradeMe.application;

import TradeMe.domain.Id;
import TradeMe.kernel.ApplicationEvent;

public class ModifyUserAddressEvent implements ApplicationEvent {
    private final Id userId;

    public ModifyUserAddressEvent(Id userId) {
        this.userId = userId;
    }
}
