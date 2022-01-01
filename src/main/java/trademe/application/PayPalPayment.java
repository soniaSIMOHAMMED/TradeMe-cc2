package trademe.application;

import trademe.domain.Payment;

public final class PayPalPayment implements Payment{
    private String emailId;
    private String password;
    public PayPalPayment(String emailId, String password) {
        this.emailId = emailId;
        this.password = password;
    }

    @Override
    public void payPerMonth(double amount) {
        System.out.println(amount + " euros paid using Paypal.");
    }
}
