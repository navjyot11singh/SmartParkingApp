package www.navjyotsingh.smartparkingapp.fragment;

public class ParkingLot_Model {
    private int images;
    private String ParkingLotName;
    private String Address;
    private String Distance;

    public ParkingLot_Model(int images, String parkingLotName, String address, String distance) {
        this.images = images;
        ParkingLotName = parkingLotName;
        Address = address;
        Distance = distance;
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }

    public String getParkingLotName() {
        return ParkingLotName;
    }

    public void setParkingLotName(String parkingLotName) {
        ParkingLotName = parkingLotName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getDistance() {
        return Distance;
    }

    public void setDistance(String distance) {
        Distance = distance;
    }
}
