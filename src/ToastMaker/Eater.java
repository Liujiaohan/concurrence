package ToastMaker;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Eater implements Runnable {
    private ToastQueue finishedQueue;
    private int counter;

    public Eater(ToastQueue finishedQueue) {
        this.finishedQueue = finishedQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                Toast toast=finishedQueue.take();
                if ((toast.getId()!=counter++)||(toast.getStatus()!= Toast.Status.JAMMED)){
                    System.exit(1);
                }
                else System.out.print("eat"+toast);
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.print("eater is off");
        }
    }

    public static void main(String[] args){
        ExecutorService executorService= Executors.newCachedThreadPool();
        ToastQueue dryQueue=new ToastQueue();
        ToastQueue butteredQueue=new ToastQueue();
        ToastQueue finishedQueue=new ToastQueue();
        Toaster toaster=new Toaster(dryQueue);
        Butter butter=new Butter(dryQueue,butteredQueue);
        Jammer jammer=new Jammer(butteredQueue,finishedQueue);
        Eater eater=new Eater(finishedQueue);
        executorService.execute(toaster);
        executorService.execute(butter);
        executorService.execute(jammer);
        executorService.execute(eater);
        try {
            TimeUnit.SECONDS.sleep(6);
        }catch (Exception e){
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}
