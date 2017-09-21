package ToastMaker;

import ToastMaker.Toast;

import java.util.Random;

public class Toaster implements Runnable {
    private ToastQueue toasts;
    private int count=0;
    public Toaster(ToastQueue toasts) {
        this.toasts = toasts;
    }

    @Override
    public void run() {
        try {
            Random random=new Random();
            while (!Thread.interrupted()){
                Thread.sleep(500+random.nextInt(500));
                Toast toast=new Toast(count++);
                toasts.put(toast);
                System.out.print(toast);
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.print("toaster is interrupted");
        }
        System.out.print("ToastMaker.Toaster off");
    }
}
