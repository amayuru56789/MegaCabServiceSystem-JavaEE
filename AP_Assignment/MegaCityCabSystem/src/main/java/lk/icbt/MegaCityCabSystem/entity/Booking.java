package lk.icbt.MegaCityCabSystem.entity;

import java.util.Date;

public class Booking {
    private String bookingId;
    private String customerId;
    private String cabId;
    private String registrationNo;
    private Date bookingDate;
    private String bookingTime;
    private Date lastUpdatedDate;
    private String lastUpdatedTime;
    private String destination;
    private String destinationDetails;
    private String activityStatus;

    public Booking() {
    }

    public Booking(String bookingId, String customerId, String cabId, String registrationNo, Date bookingDate, String bookingTime, Date lastUpdatedDate, String lastUpdatedTime, String destination, String destinationDetails, String activityStatus) {
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.cabId = cabId;
        this.registrationNo = registrationNo;
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
        this.lastUpdatedDate = lastUpdatedDate;
        this.lastUpdatedTime = lastUpdatedTime;
        this.destination = destination;
        this.destinationDetails = destinationDetails;
        this.activityStatus = activityStatus;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCabId() {
        return cabId;
    }

    public void setCabId(String cabId) {
        this.cabId = cabId;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(String bookingTime) {
        this.bookingTime = bookingTime;
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public String getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    public void setLastUpdatedTime(String lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
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
}
