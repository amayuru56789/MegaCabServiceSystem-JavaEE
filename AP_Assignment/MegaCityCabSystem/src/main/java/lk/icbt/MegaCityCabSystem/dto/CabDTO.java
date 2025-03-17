package lk.icbt.MegaCityCabSystem.dto;

public class CabDTO {
    private String cabID;
    private String model;
    private String mileage;
    private String availableStatus;
    private Double price;
    private String capacity;
    private String imgPath;
    private byte[] imgByte;
    private String base64Image; // Base64-encoded image string


    public CabDTO() {
    }



    public CabDTO(String cabID, String model, String mileage, String availableStatus, Double price, String capacity, String imgPath, byte[] imgByte) {
        this.cabID = cabID;
        this.model = model;
        this.mileage = mileage;
        this.availableStatus = availableStatus;
        this.price = price;
        this.capacity = capacity;
        this.imgPath = imgPath;
        this.imgByte = imgByte;

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

    public String getBase64Image() {
        return base64Image;
    }

    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }

    @Override
    public String toString() {
        return "CabDTO{" +
                "cabID='" + cabID + '\'' +
                ", model='" + model + '\'' +
                ", mileage='" + mileage + '\'' +
                ", availableStatus='" + availableStatus + '\'' +
                ", price=" + price +
                ", capacity='" + capacity + '\'' +
                '}';
    }
}
