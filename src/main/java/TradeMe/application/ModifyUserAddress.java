package TradeMe.application;

import TradeMe.exposition.AddressResponse;
import TradeMe.kernel.Command;

public class ModifyUserAddress implements Command {
    public final int userId;
    public final AddressResponse address;

    public ModifyUserAddress(int userId, AddressResponse address) {
        this.userId = userId;
        this.address = address;
    }
}
