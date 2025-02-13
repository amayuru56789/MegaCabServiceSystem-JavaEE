package lk.icbt.MegaCityCabSystem.dto;

public class DriverDTO {
    private String driverID;
    private String driverName;
    private String mobileNo;
    private String license;
    private String experienceOfYear;

    public DriverDTO() {
    }

    public DriverDTO(String driverID, String driverName, String mobileNo, String license, String experienceOfYear) {
        this.driverID = driverID;
        this.driverName = driverName;
        this.mobileNo = mobileNo;
        this.license = license;
        this.experienceOfYear = experienceOfYear;
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

    @Override
    public String toString() {
        return "DriverDTO{" +
                "driverID='" + driverID + '\'' +
                ", driverName='" + driverName + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", license='" + license + '\'' +
                ", experienceOfYear='" + experienceOfYear + '\'' +
                '}';
    }
}
