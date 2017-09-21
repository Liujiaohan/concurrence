package RestaurantPck.BlockingQueueVersion;

public class Order {
    private int id;
    public Order(int id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "meal id:"+id;
    }
}
