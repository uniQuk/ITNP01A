/**
 * Created by awsm on 07/10/2015.
 */
public class ProductConsumerTest {
    public static void main(String[] args) {
        CubbyHole c = new CubbyHole();
        Prod p1 = new Prod(c, 1);
        Cons c1 = new Cons(c,1);
        p1.start();
        c1.start();
    }
}

class CubbyHole {
    private int contents;
    private boolean available = false;
    public synchronized int get() {
        while (available == false) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } // while
        available = false;
        notifyAll();
        return contents;
    }
    public synchronized void put(int value) {
        while (available == true) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } // while
        contents = value;
        available = true;
        notifyAll();
    }
}

class Cons extends Thread {
    private CubbyHole cubbyHole;
    private int number;
    public Cons(CubbyHole c, int number) {
        cubbyHole = c;
        this.number = number;
    }
    public void run() {
        int value = 0;
        for (int i = 0; i < 10; ++i) {
            value = cubbyHole.get();
            System.out.println("Consumer #" + this.number + " got: " + value);
        }
    }
}


class Prod extends Thread {
    private CubbyHole cubbyHole;
    private int number;

    public Prod(CubbyHole c, int number) {
        cubbyHole = c;
        this.number = number;
    }
    public void run() {
        for (int i = 0; i < 10; ++i) {
            cubbyHole.put(i);
            System.out.println("Producer #" + this.number + " put: " + i);

            try {
                sleep((int)(Math.random() * 100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}