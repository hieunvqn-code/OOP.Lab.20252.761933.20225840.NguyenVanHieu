public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int lenght;
    private float cost;

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getDirector() {
        return director;
    }

    public int getLenght() {
        return lenght;
    }

    public float getCost() {
        return cost;
    }

    public DigitalVideoDisc(String title, String category, String director, int lenght, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.lenght = lenght;
        this.cost = cost;
    }

}
