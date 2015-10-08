import java.util.Date;
import java.util.Vector;

/**
 * Created by awsm on 07/10/2015.
 */
public class Server {

    public Server() {
        MessageQ queue = new MessageQ();
        Pro producerThread = new Pro(queue, 1);
        Con consumerThread = new Con(queue, 1);


        consumerThread.start();
        producerThread.start();
    } // Server()

    static public void main(String[] args) {
        Server serverInst = new Server();
    } // main
} // Server


/**
 * MessageQ
 */
class MessageQ {
    private Vector<Object> queue;
    semaphore fillCount = 0; // items produced
    semaphore emptyCount = BUFFER_SIZE; // remaining space
    public MessageQ() {
        queue = new Vector<Object>();
    } // MessageQ()

    public synchronized void send(Object item) {
//        try {
//            wait();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        queue.addElement(item);
//        notifyAll();
    } // send()

    public synchronized Object receive() {
//        try {
//            wait();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        Object item;
        if (queue.size() == 0) return null;
        else {
            item = queue.firstElement();
            queue.removeElementAt(0);
//            notifyAll();
            return item;
        }
    } // receive()
} // MessageQ

/**
 * Producer
 */

class Pro extends Thread {
    private int ra = (int) (Math.random() * 100);
    private MessageQ mbox;
    private int count;
    // Public Pro
    public Pro(MessageQ m, int count) {
        this.count = count;
        mbox = m;
    } // Pro()

    public void run() {
        while (true) {
            // produce an item & enter it into the buffer
            Date message = new Date();
            mbox.send(message);
            System.out.println("Producer: " + this.count + " Sent:\t\t" + message);

            try {
                sleep(ra);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } // while
    } // run()
} // Pro


/**
 * Consumer
 */

class Con extends Thread {
    private MessageQ mbox;
    private int count;
    // Public Con
    public Con(MessageQ m, int count) {
        this.count = count;
        mbox = m;
    } // Con()

    public void run() {
        while (true) {
            Date message = (Date) mbox.receive();
            if (message != null) {
                System.out.println("Consumer: " + this.count +  " Received:\t" + message);
            }
        } // while
    } // run()
} // Con