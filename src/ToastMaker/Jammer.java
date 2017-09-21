package ToastMaker;

import ToastMaker.Toast;

import java.util.Random;

public class Jammer implements Runnable {
    private ToastQueue butteredQueue;
    private ToastQueue jammerQueue;

    public Jammer(ToastQueue butteredQueue, ToastQueue jammerQueue) {
        this.butteredQueue = butteredQueue;
        this.jammerQueue = jammerQueue;
    }

    @Override
    public void run() {
        try {
            Random random=new Random();
            while (!Thread.interrupted()){
                Thread.sleep(500+random.nextInt(500));
                Toast toast=butteredQueue.take();
                toast.jam();
                System.out.print(toast);
                jammerQueue.put(toast);
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.print("ToastMaker.Jammer is off");
        }
    }
}
