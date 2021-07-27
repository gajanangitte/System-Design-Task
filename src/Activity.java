public class Activity {
    protected int name;
    protected Destination destination;
    protected int price;
    protected int capacity;
    protected int description;

    Activity(int name, Destination destination, int price) {
        this.name = name;
        this.destination = destination;
        this.price = price;
    }
}
