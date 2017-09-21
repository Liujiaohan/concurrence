package RestaurantPck.BlockingQueueVersion;

public class Waiter implements Runnable{
    private MealQueue waitQueue;
    private MealQueue finishedQueue;
    private int count;

    public Waiter(MealQueue waitQueue, MealQueue finishedQueue) {
        this.waitQueue = waitQueue;
        this.finishedQueue = finishedQueue;
        count=0;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                Order newOrder=new Order(count++);
                waitQueue.add(newOrder);
                System.out.print("waiter:a new order\n");
                Order order =finishedQueue.take();
                System.out.print("waiter:order complete  "+ order.toString()+"\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
