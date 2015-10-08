import java.util.Random;

public class Buffer {

    public Buffer(){
        MessageQueue queue = new MessageQueue();
        Producer producerThread = new Producer(queue, 1);
        Consumer consumerThread = new Consumer(queue, 1);


        consumerThread.start();
        producerThread.start();
    }

    static public void main(String[] args) {
        Buffer bufferInst = new Buffer();
    }
}

