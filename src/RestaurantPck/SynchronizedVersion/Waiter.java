package RestaurantPck.SynchronizedVersion;

public class Waiter implements Runnable {
    private Restaurant restaurant;

    public Waiter(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                synchronized (this){
                    while (restaurant.order ==null){
                        wait();//等待厨师做完菜后被chef的notifyAll()唤醒，注意wait()会释放当前获得的锁
                    }
                }
                synchronized (restaurant.chef){
                    System.out.print("waiter: order up\n");
                    restaurant.order =null;
                    restaurant.chef.notifyAll();//告诉厨师可以做菜了
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
