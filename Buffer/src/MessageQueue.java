import java.io.ObjectInput;
        import java.util.Vector;

public class MessageQueue {
    public MessageQueue() {
        queue = new Vector<>();
//        queue.ensureCapacity(10);


    }
    public void send(Object item) {
        queue.addElement(item);
//        System.out.printf("Capacity %d\tSize: %d\tItem: %s\n", queue.capacity(), queue.size(), item);

    }

    public Object receive() {
        Object item;
        if (queue.size() == 0) {
            return null;
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            item = queue.firstElement();
            queue.removeElementAt(0);
//            System.out.printf("Capacity %d\tSize: %d\tItem: %s\n", queue.capacity(), queue.size(), item);
            return item;
        }
    }
    private Vector<Object> queue;
}
