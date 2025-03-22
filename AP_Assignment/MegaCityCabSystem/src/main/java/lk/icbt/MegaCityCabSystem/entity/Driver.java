package lk.icbt.MegaCityCabSystem.entity;

public class Driver {

    private String driverID;
    private String driverName;
    private String mobileNo;
    private String license;
    private String experienceOfYear;
    private String email;
    private String address;
    private String status;
    private String userName;
    private String password;

    public Driver() {
    }


    public Driver(String driverID, String driverName, String mobileNo, String license, String experienceOfYear, String email, String address, String status, String userName, String password) {
        this.driverID = driverID;
        this.driverName = driverName;
        this.mobileNo = mobileNo;
        this.license = license;
        this.experienceOfYear = experienceOfYear;
        this.email = email;
        this.address = address;
        this.status = status;
        this.userName = userName;
        this.password = password;

    }

    public String getDriverID() {
        return driverID;
    }

    public void setDriverID(String driverID) {
        this.driverID = driverID;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getExperienceOfYear() {
        return experienceOfYear;
    }

    public void setExperienceOfYear(String experienceOfYear) {
        this.experienceOfYear = experienceOfYear;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    @Override
    public String toString() {
        return "Driver{" +
                "driverID='" + driverID + '\'' +
                ", driverName='" + driverName + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", license='" + license + '\'' +
                ", experienceOfYear='" + experienceOfYear + '\'' +
                '}';
    }
}
