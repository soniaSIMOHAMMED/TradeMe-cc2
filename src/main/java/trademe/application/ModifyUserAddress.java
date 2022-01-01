package trademe.application;

import trademe.exposition.AddressDTO;
import trademe.kernel.Command;

public final class ModifyUserAddress implements Command {
    public final int userId;
    public final AddressDTO address;

    public ModifyUserAddress(int userId, AddressDTO address) {
        this.userId = userId;
        this.address = address;
    }
}
