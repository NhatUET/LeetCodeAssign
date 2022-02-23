import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CourseSchedule {
    static int WHITE = 1;
    static int GREY = 2;
    static int BLACK = 3;

    Map<Integer, ArrayList<Integer>> adjV;
    Map<Integer, Integer> color;
    ArrayList<Integer> topoLists;
    boolean isCycle = false;

    private void init(int numCourses) {
        adjV = new HashMap<>();
        color = new HashMap<>();
        topoLists = new ArrayList<>();
        isCycle = false;

        for (int i = 0; i < numCourses; i++) {
            color.put(i,WHITE);
        }
    }

    private void dfs(int ver) {
        if (isCycle) return;
        color.put(ver, GREY);
        for (int nei : adjV.getOrDefault(ver, new ArrayList<>())) {
            if (color.get(nei) == GREY) {
                isCycle = true;
            } else if (color.get(nei) == WHITE) {
                dfs(nei);
            }
        }

        color.put(ver,BLACK);
        topoLists.add(ver);
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        init(numCourses);
        for (int[] prerequisite : prerequisites) {
            int dest = prerequisite[0];
            int src = prerequisite[1];

            ArrayList<Integer> list = adjV.getOrDefault(src, new ArrayList<>());
            list.add(dest);
            adjV.put(src, list);
        }

        for (int i = 0; i < numCourses; i++) {
            if (color.get(i) == WHITE) dfs(i);
        }

        int[] res = new int[numCourses];
        if (isCycle) {
            return new int[0];
        } else {
            for (int i = 0; i < numCourses; i++) {
                res[i] = topoLists.get(numCourses-i-1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int numCourses = 4;
        int[][] adjV = new int[][] {{1,0},{2,0},{3,1},{3,2}};

        CourseSchedule s1 = new CourseSchedule();
        System.out.print(Arrays.toString(s1.findOrder(numCourses, adjV)));
    }
}
