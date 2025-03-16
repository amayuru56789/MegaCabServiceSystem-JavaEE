package lk.icbt.MegaCityCabSystem.dto;

public class CommonDTO {
    private String customerId;
    private String customerName;
    private String cabId;
    private String cabName;
    private String driverId;
    private String driverName;
    private String regNo;

    public CommonDTO() {
    }

    public CommonDTO(String customerId, String customerName, String cabId, String cabName, String driverId, String driverName, String regNo) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.cabId = cabId;
        this.cabName = cabName;
        this.driverId = driverId;
        this.driverName = driverName;
        this.regNo = regNo;
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

    public String getCabId() {
        return cabId;
    }

    public void setCabId(String cabId) {
        this.cabId = cabId;
    }

    public String getCabName() {
        return cabName;
    }

    public void setCabName(String cabName) {
        this.cabName = cabName;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    @Override
    public String toString() {
        return "CommonDTO{" +
                "customerId='" + customerId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", cabId='" + cabId + '\'' +
                ", cabName='" + cabName + '\'' +
                ", driverId='" + driverId + '\'' +
                ", driverName='" + driverName + '\'' +
                ", regNo='" + regNo + '\'' +
                '}';
    }
}
