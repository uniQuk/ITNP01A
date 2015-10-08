import java.util.ArrayList;
import java.util.List;

/**
 * Created by awsm on 29/09/2015.
 */
public class p02v2 {
    public static void main(String[] args) {
        List myList = new ArrayList();
        int a = 1, b = 1, c = 0;
        while (a < 4000000) {

            b = a + b;
            a = b;
            if (a % 2 == 0) {
                c =+ a;
                System.out.println(c);
            }

        }
        System.out.println(c);
    }
}
