package lk.icbt.MegaCityCabSystem.dto;

import java.time.LocalTime;
import java.util.Date;

public class CustomerDTO {
    private String customerId;
    private String customerName;
    private String address;
    private String nic;
    private String email;
    private String telephoneNo;
    private String userName;
    private String password;
    private String registrationNo;
    private Date registrationDate;
    private LocalTime registrationTime;
    private Date updatedDate;
    private LocalTime updatedTime;

    public CustomerDTO() {
    }

    public CustomerDTO(String customerId, String customerName, String address, String nic, String email, String telephoneNo, String userName, String password, String registrationNo, Date registrationDate, LocalTime registrationTime, Date updatedDate, LocalTime updatedTime) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.address = address;
        this.nic = nic;
        this.email = email;
        this.telephoneNo = telephoneNo;
        this.userName = userName;
        this.password = password;
        this.registrationNo = registrationNo;
        this.registrationDate = registrationDate;
        this.registrationTime = registrationTime;
        this.updatedDate = updatedDate;
        this.updatedTime = updatedTime;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephoneNo() {
        return telephoneNo;
    }

    public void setTelephoneNo(String telephoneNo) {
        this.telephoneNo = telephoneNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public LocalTime getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(LocalTime registrationTime) {
        this.registrationTime = registrationTime;
    }

    public Date getUpdatedDate() {
        return registrationDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public LocalTime getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(LocalTime updatedTime) {
        this.updatedTime = updatedTime;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "customerId='" + customerId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", address='" + address + '\'' +
                ", nic='" + nic + '\'' +
                ", email='" + email + '\'' +
                ", telephoneNo='" + telephoneNo + '\'' +
                ", registrationNo='" + registrationNo + '\'' +
                ", registrationDate=" + registrationDate +
                '}';
    }
}
