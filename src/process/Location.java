package process;

public class Location {
    public String id;
    public double latitude;
    public double longitude;
    
    public Location() {
    }

    public Location(String id, double latitude, double longitude) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}