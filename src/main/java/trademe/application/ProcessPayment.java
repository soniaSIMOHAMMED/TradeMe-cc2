package trademe.application;

import trademe.domain.Payment;

public final class ProcessPayment implements Payment {
    Double amount;
    Payment paymentS;

    public ProcessPayment(Payment paymentS) {
        this.paymentS = paymentS;
    }

    @Override
    public void payPerMonth(double amount) {

    }

}
