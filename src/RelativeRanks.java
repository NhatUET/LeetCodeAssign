import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class RelativeRanks {
    public static String[] findRelativeRanks(int[] score) {
        int count = 1, i = 0;
        Map<Integer, String> map = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((a, b) -> b - a);
        for (int x : score) queue.add(x);
        String[] res = new String[score.length];
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            if (count == 1) {
                map.put(temp,"Gold Medal");
            } else if (count == 2) {
                map.put(temp,"Silver Medal");
            } else if (count == 3) {
                map.put(temp,"Bronze Medal");
            } else {
                map.put(temp, String.valueOf(count));
            }
            count++;
        }
        for (int j = 0; j < score.length; j++) {
            res[j] = map.get(score[j]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {10,3,8,9,4};
        String[] res = findRelativeRanks(a);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + ", ");
        }
    }
}
