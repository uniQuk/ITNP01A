import java.util.ArrayList;
import java.util.List;

/**
 * Created by awsm on 29/09/2015.
 */
public class p02 {
    public static void main(String[] args) {
        int a = 1, b = 2;
        List myList = new ArrayList();
        List evenList = new ArrayList();
        evenList.add(2);
        myList.add(a);
        myList.add(b);
        for (int i = 0; i < 100; i++) {
            int addLast = (int) myList.get(myList.size() - 1) + (int) myList.get(myList.size() - 2);
            myList.add(addLast);
            if ((addLast % 2 == 0) && (addLast >= 0 && addLast <= 4000000)) {
                evenList.add(addLast);
                System.out.println("size: "+evenList.size());
            }

            System.out.println(myList.get(i));
            System.out.println("Even: " + evenList);

            int total = 0;
            for (int j = 0; j < evenList.size(); j++) {
                total += (int) evenList.get(j);
            }
            System.out.println("Final: "+(total));
        }





    }
}
