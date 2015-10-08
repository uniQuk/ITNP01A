import java.util.Date;

/**
 * Created by awsm on 06/10/2015.
 */
public class Consumer extends Thread {
    private int count;
    private MessageQueue mbox;

    public Consumer(MessageQueue m, int count) {
        mbox = m;
        this.count = count;
    }

    public void run() {
        while (true) {

            Date message = (Date) mbox.receive();

//            if (message == null) {
//                System.err.printf("%s \n", String.valueOf(message));
//            } else if (message != null) {
                System.out.println("Consumer: " + this.count);
//                System.out.printf("Message: %s\tCount: %d\n", message, count);
//            }
        } // while
    } // run
} // Consumer


