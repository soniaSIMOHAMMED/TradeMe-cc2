package TradeMe.application;

import TradeMe.kernel.Command;

public class ModifyUserPaymentMethod implements Command {
    public final int userId;


    public ModifyUserPaymentMethod(int userId) {
        this.userId = userId;
    }
}
