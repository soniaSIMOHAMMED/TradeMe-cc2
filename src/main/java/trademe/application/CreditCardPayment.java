package trademe.application;

import trademe.domain.Payment;
public final class CreditCardPayment implements Payment{
    private String name;
    private String cardNumber;
    private String cvv;
    private String expiryDate;

    public CreditCardPayment(String name, String cardNumber, String cvv, String expiryDate){
        this.name=name;
        this.cardNumber=cardNumber;
        this.cvv=cvv;
        this.expiryDate=expiryDate;
    }

    @Override
    public void payPerMonth(double amount) {
        System.out.println(amount +" euros paid with credit card");
    }

}
