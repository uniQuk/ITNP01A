import java.io.IOException;
import java.io.RandomAccessFile;

public class ggp {

    static public void main(String[] args) {
        RandomAccessFile admin;
        byte init[] = {0};
        int theGate = 0;

        if (args.length != 1) {
            System.err.println("usage: java {gate_bottom,gate_top}");
        } else {
            try {
                admin = new RandomAccessFile("admin.txt", "rw");
                if (args[0].compareToIgnoreCase("gate_bottom") == 0) {
                    admin.seek(0);
                    theGate = 0;
                } else if (args[0].compareToIgnoreCase("gate_top") == 0) {
                    admin.seek(1);
                    theGate = 1;
                }
                admin.write(init);
                admin.close();
            } catch (IOException e) {
                System.out.println("something wrong with file access" + e);
            }
            gate counter = new gate();
            counter.counting(theGate);
        }
    } // main
} // ggp
