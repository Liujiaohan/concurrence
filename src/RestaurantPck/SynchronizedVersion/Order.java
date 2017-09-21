package RestaurantPck.SynchronizedVersion;

public class Order {
    private int num=0;

    public Order(int num) {
        this.num=num;
    }

    @Override
    public String toString() {
        return "order num:"+num;
    }
}
