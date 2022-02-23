import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KClosetElement {
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int j : arr) {
            queue.add(Math.abs(j - x));
        }
        List<Integer> res = new ArrayList<>();
        while (k-- > 0) {
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        List<Integer> s = new ArrayList<>();
        s = findClosestElements(a, 4, 3);
        System.out.print(s);
    }
}
