package RestaurantPck.BlockingQueueVersion;

public class Chef implements Runnable{
    private MealQueue waitQueue;
    private MealQueue finishedQueue;

    public Chef(MealQueue waitQueue, MealQueue finishedQueue) {
        this.waitQueue = waitQueue;
        this.finishedQueue = finishedQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                Order order =waitQueue.take();
                Thread.sleep(500);
                System.out.print("chef:order done   "+ order.toString()+"\n");
                finishedQueue.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
