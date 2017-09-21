package ToastMaker;

import ToastMaker.Toast;

import java.util.Random;

public class Butter implements Runnable{
    private ToastQueue butterQueue;
    private ToastQueue dryQueue;

    public Butter(ToastQueue dryQueue, ToastQueue butterQueue) {
        this.butterQueue = butterQueue;
        this.dryQueue=dryQueue;
    }


    @Override
    public void run() {
        try {
            Random random=new Random();
            while (!Thread.interrupted()){
                Thread.sleep(500+random.nextInt(500));
                Toast toast=dryQueue.take();
                toast.butter();
                System.out.print(toast);
                butterQueue.put(toast);
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.print("butter is interrupted");
        }
    }
}