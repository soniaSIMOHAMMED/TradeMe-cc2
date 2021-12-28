package TradeMe.application;

import TradeMe.infrastructure.Payment;

public class ProcessPayment implements Payment {

    @Override
    public Boolean PaymentAllowed() {
        return null;
    }

    @Override
    public void payPerMonth(int amount) {

    }
}
