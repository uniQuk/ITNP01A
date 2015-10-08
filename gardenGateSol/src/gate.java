import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class gate {

    RandomAccessFile admin;
    int internal_count;
    int ranumber;
    int count;
    Random ra;

    ReentrantLock lock = new ReentrantLock();


    public gate() {
        try {
            admin = new RandomAccessFile("admin.txt", "rw");

        } catch (IOException e) {
        }
        internal_count = 0;
        count = 0;
        ra = new Random();
    } // gate()

    public void counting(int gg) {
        int i;
        int a;
        byte t[] = {0};

        for (i = 0; i < 50; i++) {
//            lock.lock();
            try {
//                Thread.holdsLock(count);
//                Thread.currentThread().wait();
                bottomTop(gg);
                admin.read(t);
                count = t[0];
                count = count + 1;
                internal_count++;
                t[0] = (byte) count;
                bottomTop(gg);
                admin.write(t);
                ranumber = ra.nextInt(500);
                Thread.sleep(ranumber);
            } catch (Exception e) {
            } finally {
//                lock.unlock();
            }
            System.out.println("Shared Counter: " + count + " internal counter: " + internal_count + " Active Count: " + Thread.activeCount());
        } // for
    } // counting


    public void bottomTop(int bt) throws IOException {
        if (bt == 0) {
            admin.seek(0);
        } else {
            admin.seek(1);
        }
    } // bottomTop
}
