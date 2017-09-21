package ToastMaker;

import jdk.net.SocketFlow;

public class Toast {
    public enum Status{DRY,BUTTERED,JAMMED}
    private final int id;
    private Status status;
    public Toast(int id) {
        this.id = id;
        status=Status.DRY;
    }
    public void butter(){
        status=Status.BUTTERED;
    }
    public void jam(){
        status=Status.JAMMED;
    }
    public Status getStatus(){
        return status;
    }
    public int getId(){
        return id;
    }

    @Override
    public String toString() {
        return "ToastMaker.Toast"+id+"status"+status+"\n";
    }
}
