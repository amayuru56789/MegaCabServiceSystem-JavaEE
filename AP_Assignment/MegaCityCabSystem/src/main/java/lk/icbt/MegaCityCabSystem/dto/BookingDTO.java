package lk.icbt.MegaCityCabSystem.dto;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

public class BookingDTO {

    private String bookingId;
    private String customerId;
    private String cabId;
    private String registrationNo;
    private Date bookingDate;
    private Time bookingTime;
    private Date lastUpdatedDate;
    private Time lastUpdatedTime;
    private String destination;
    private String destinationDetails;
    private String activityStatus;
    private Timestamp pickupDateTime;
    private String pickupAddress;
    private String distance;

    public BookingDTO() {
    }



    public BookingDTO(String bookingId, String customerId, String cabId, String registrationNo, Date bookingDate, Time bookingTime, Date lastUpdatedDate, Time lastUpdatedTime, String destination, String destinationDetails, String activityStatus, Timestamp pickupDateTime, String pickupAddress, String distance) {
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
        this.pickupDateTime = pickupDateTime;
        this.pickupAddress = pickupAddress;
        this.distance = distance;

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

    public Time getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(Time bookingTime) {
        this.bookingTime = bookingTime;
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public Time getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    public void setLastUpdatedTime(Time lastUpdatedTime) {
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

    public Timestamp getPickupDateTime() {
        return pickupDateTime;
    }

    public void setPickupDateTime(Timestamp pickupDateTime) {
        this.pickupDateTime = pickupDateTime;
    }

    public String getPickupAddress() {
        return pickupAddress;
    }

    public void setPickupAddress(String pickupAddress) {
        this.pickupAddress = pickupAddress;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }
}
