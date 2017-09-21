package RestaurantPck.SynchronizedVersion;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Restaurant {
    Order order;
    Chef chef=new Chef(this);
    Waiter waiter=new Waiter(this);
    ExecutorService executorService= Executors.newCachedThreadPool();

    public Restaurant() {
        order =null;
        executorService.execute(chef);
        executorService.execute(waiter);
        try {
            TimeUnit.SECONDS.sleep(5);
        }catch (Exception e){
            e.printStackTrace();
        }
        executorService.shutdown();
    }
    public static void main(String[] args){
        new Restaurant();
    }
}
