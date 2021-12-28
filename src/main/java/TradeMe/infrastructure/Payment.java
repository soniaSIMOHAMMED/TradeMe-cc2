package TradeMe.infrastructure;

public interface Payment {
    Boolean PaymentAllowed();
    void payPerMonth(int amount);
}
