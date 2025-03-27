package process;

public class Metadata {
    public String id;
    public String type;
    public double rating;
    public int reviews;
    
    public Metadata() {
    }

    public Metadata(String id, String type, Double rating, Integer reviews) {
        this.id = id;
        this.type = type;
        this.rating = rating;
        this.reviews = reviews;
    }
}

