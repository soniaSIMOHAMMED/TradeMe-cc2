package trademe.exposition;

import trademe.domain.Payment;

public final class PaymentMethodDTO {
    Payment paymentMethod;

    public PaymentMethodDTO(Payment paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Payment getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(Payment paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
