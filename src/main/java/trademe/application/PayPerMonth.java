package trademe.application;

import trademe.domain.Payment;
import trademe.kernel.Command;

public final class PayPerMonth implements Command{
    public final int userId;
    public final Payment paymentMethod;
    public final double fixedAmount;

    public PayPerMonth(int userId, Payment paymentMethod, double fixedAmount) {
        this.userId = userId;
        this.paymentMethod = paymentMethod;
        this.fixedAmount = fixedAmount;
    }

}
