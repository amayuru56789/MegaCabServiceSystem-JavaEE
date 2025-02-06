package lk.icbt.MegaCityCabSystem.dto;

import java.util.Date;

public class CustomerDTO {
    private String customerId;
    private String customerName;
    private String address;
    private String nic;
    private String email;
    private String telephoneNo;
    private String registrationNo;
    private Date registrationDate;

    public CustomerDTO() {
    }

    public CustomerDTO(String customerId, String customerName, String address, String nic, String email, String telephoneNo, String registrationNo, Date registrationDate) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.address = address;
        this.nic = nic;
        this.email = email;
        this.telephoneNo = telephoneNo;
        this.registrationNo = registrationNo;
        this.registrationDate = registrationDate;
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
