package lk.icbt.MegaCityCabSystem.dto;

import java.util.Date;

public class BookingCommonDTO {
    private String bookingNumber;
    private String customerId;
    private String customerName;
    private String customerPhone;
    private String destination;
    private String destinationDetails;
    private String activityStatus;
    private Date pickupDateTime;
    private String pickupAddress;
    private String estimatedDistance;

    public BookingCommonDTO() {
    }

    public BookingCommonDTO(String bookingNumber, String customerId, String customerName, String customerPhone, String destination, String destinationDetails, String activityStatus, Date pickupDateTime, String pickupAddress, String estimatedDistance) {
        this.bookingNumber = bookingNumber;
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.destination = destination;
        this.destinationDetails = destinationDetails;
        this.activityStatus = activityStatus;
        this.pickupDateTime = pickupDateTime;
        this.pickupAddress = pickupAddress;
        this.estimatedDistance = estimatedDistance;
    }

    public String getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(String bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDestinationDetails() {
        return destinationDetails;
    }

    public void setDestinationDetails(String destinationDetails) {
        this.destinationDetails = destinationDetails;
    }

    public String getActivityStatus() {
        return activityStatus;
    }

    public void setActivityStatus(String activityStatus) {
        this.activityStatus = activityStatus;
    }

    public Date getPickupDateTime() {
        return pickupDateTime;
    }

    public void setPickupDateTime(Date pickupDateTime) {
        this.pickupDateTime = pickupDateTime;
    }

    public String getPickupAddress() {
        return pickupAddress;
    }

    public void setPickupAddress(String pickupAddress) {
        this.pickupAddress = pickupAddress;
    }

    public String getEstimatedDistance() {
        return estimatedDistance;
    }

    public void setEstimatedDistance(String estimatedDistance) {
        this.estimatedDistance = estimatedDistance;
    }

    @Override
    public String toString() {
        return "BookingCommonDTO{" +
                "bookingNumber='" + bookingNumber + '\'' +
                ", customerId='" + customerId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerPhone='" + customerPhone + '\'' +
                ", destination='" + destination + '\'' +
                ", destinationDetails='" + destinationDetails + '\'' +
                ", activityStatus='" + activityStatus + '\'' +
                ", pickupDateTime=" + pickupDateTime +
                ", pickupAddress='" + pickupAddress + '\'' +
                ", estimatedDistance='" + estimatedDistance + '\'' +
                '}';
    }
}
