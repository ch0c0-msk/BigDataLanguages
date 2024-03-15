package shop;

public class SalesRecord {
    private Order order;
    private boolean paymentStatus;

    public SalesRecord(Order order, boolean paymentStatus) {
        this.order = order;
        this.paymentStatus = paymentStatus;
    }

    public Order getOrder() {
        return order;
    }

    public boolean isPaymentStatus() {
        return paymentStatus;
    }
}
