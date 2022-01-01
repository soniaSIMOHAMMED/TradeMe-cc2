package trademe.application;

import trademe.domain.Payment;
import trademe.kernel.Command;

public final class ModifyUserPaymentMethod implements Command {
    public final int userId;
    public final Payment paymentMethod;


    public ModifyUserPaymentMethod(int userId, Payment paymentMethod) {
        this.userId = userId;
        this.paymentMethod = paymentMethod;
    }

}
