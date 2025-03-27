package process;

public class MergedData {
	public String id;
	public double latitude;
	public double longitude;
	public String type;
	public Double rating;
	public Integer reviews;

	public MergedData(Location location, Metadata metadata) {
		this.id = location.id;
		this.latitude = location.latitude;
		this.longitude = location.longitude;
		if (metadata != null) {
			this.type = metadata.type;
			this.rating = metadata.rating;
			this.reviews = metadata.reviews;
		} else {
			this.type = null;
			this.rating = null;
			this.reviews = null;
		}
	}
}
