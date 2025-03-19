package lk.icbt.MegaCityCabSystem.dto;

public class PaymentDTO {

    private String paymentId;
    private String bookingId;
    private Double totAmount;
    private String distance;
    private double ratePerKm;
    private double waitingTime;
    private double waitingCharge;
    private double additionalCharges;
    private double discount;

    public PaymentDTO() {
    }

    public PaymentDTO(String paymentId, String bookingId, Double totAmount, String distance, double ratePerKm, double waitingTime, double waitingCharge, double additionalCharges, double discount) {
        this.paymentId = paymentId;
        this.bookingId = bookingId;
        this.totAmount = totAmount;
        this.distance = distance;
        this.ratePerKm = ratePerKm;
        this.waitingTime = waitingTime;
        this.waitingCharge = waitingCharge;
        this.additionalCharges = additionalCharges;
        this.discount = discount;
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

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }

    public void setRatePerKm(double ratePerKm) {
        this.ratePerKm = ratePerKm;
    }

    public double getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(double waitingTime) {
        this.waitingTime = waitingTime;
    }

    public double getWaitingCharge() {
        return waitingCharge;
    }

    public void setWaitingCharge(double waitingCharge) {
        this.waitingCharge = waitingCharge;
    }

    public double getAdditionalCharges() {
        return additionalCharges;
    }

    public void setAdditionalCharges(double additionalCharges) {
        this.additionalCharges = additionalCharges;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
