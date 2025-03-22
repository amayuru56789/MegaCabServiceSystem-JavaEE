package lk.icbt.MegaCityCabSystem.entity;

public class Cab {
    private String cabID;
    private String model;
    private String mileage;
    private String availableStatus;
    private Double price;
    private String capacity;
    private String imgPath;
    private byte[] imgByte;
    private String driverId;

    public Cab() {
    }

    public Cab(String cabID, String model, String mileage, String availableStatus, Double price, String capacity, String imgPath,  byte[] imgByte, String driverId) {
        this.cabID = cabID;
        this.model = model;
        this.mileage = mileage;
        this.availableStatus = availableStatus;
        this.price = price;
        this.capacity = capacity;
        this.imgPath = imgPath;
        this.imgByte = imgByte;
        this.driverId = driverId;
    }

    public String getCabID() {
        return cabID;
    }

    public void setCabID(String cabID) {
        this.cabID = cabID;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public String getAvailableStatus() {
        return availableStatus;
    }

    public void setAvailableStatus(String availableStatus) {
        this.availableStatus = availableStatus;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public byte[] getImgByte() {
        return imgByte;
    }

    public void setImgByte(byte[] imgByte) {
        this.imgByte = imgByte;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    @Override
    public String toString() {
        return "Cab{" +
                "cabID='" + cabID + '\'' +
                ", model='" + model + '\'' +
                ", mileage='" + mileage + '\'' +
                ", availableStatus='" + availableStatus + '\'' +
                ", price=" + price +
                ", capacity='" + capacity + '\'' +
                ", imgPath='" + imgPath + '\'' +
                '}';
    }
}
