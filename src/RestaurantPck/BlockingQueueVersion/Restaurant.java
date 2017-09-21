package RestaurantPck.BlockingQueueVersion;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Restaurant {
    private MealQueue waitQueue;
    private MealQueue finishedQueue;
    private Chef chef;
    private Waiter waiter;

    public Restaurant() {
        waitQueue = new MealQueue();
        finishedQueue = new MealQueue();
        chef = new Chef(waitQueue, finishedQueue);
        waiter = new Waiter(waitQueue, finishedQueue);
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(chef);
        executorService.execute(waiter);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }

    public static void main(String[] args){
        new Restaurant();
    }
}
