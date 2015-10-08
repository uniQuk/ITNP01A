import java.util.Date;

/**
 * Created by awsm on 06/10/2015.
 */
public class Producer extends Thread {

    private int count;

    public Producer(MessageQueue m, int count) {
        mbox = m;
        this.count = count;
    }
    public void run() {
        while (true) {
            Date message = new Date();
            mbox.send(message);
            System.out.println("Producer:" + this.count);


            try {
                sleep((int)(Math.random() * 100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            try {
//                Thread.sleep(50);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }
    private MessageQueue mbox;
}
