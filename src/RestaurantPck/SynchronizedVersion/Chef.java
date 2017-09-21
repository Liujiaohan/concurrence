package RestaurantPck.SynchronizedVersion;

public class Chef implements Runnable {
    private Restaurant restaurant;
    private int counter=0;
    public Chef(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try{
            while (!Thread.interrupted()){
                synchronized (this){
                    while (restaurant.order !=null){
                        wait();//等服务员上菜，通知他做菜
                    }
                }
                synchronized (restaurant.waiter){
                    //获得服务员的锁，让他等我做菜
                    restaurant.order =new Order(counter++);
                    System.out.print("chef: a order is done\n");
                    Thread.sleep(500);
                    restaurant.waiter.notifyAll();
                    //告诉服务员可以上菜了
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
