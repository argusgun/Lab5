public class Movie {
    private String name, producer;
    private int releaseYear, price;

    public Movie(String name) {
        this.name = name;
    }

    public Movie(String name, String producer, int releaseYear, int price) {
        this.name = name;
        this.producer = producer;
        this.releaseYear = releaseYear;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
