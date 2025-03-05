package lk.icbt.MegaCityCabSystem.entity;

public class Payment {

    private String paymentId;
    private String bookingId;
    private Double totAmount;

    public Payment() {
    }

    public Payment(String paymentId, String bookingId, Double totAmount) {
        this.paymentId = paymentId;
        this.bookingId = bookingId;
        this.totAmount = totAmount;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public Double getTotAmount() {
        return totAmount;
    }

    public void setTotAmount(Double totAmount) {
        this.totAmount = totAmount;
    }
}
