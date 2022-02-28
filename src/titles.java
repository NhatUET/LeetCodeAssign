import java.util.HashSet;
import java.util.Set;

public class titles {
    public static void gen(String strings, int k, Set<String> sd, String s) {
        if (k == strings.length()) {
            sd.add(s);
        } else {
            for (int i = 0; i < k; i++) {
                s += strings.charAt(i);
            }
            gen(strings, k + 1, sd, s);
        }
    }

    public static int numTilePossibilities(String tiles) {
        Set<String> sd = new HashSet<>();
        boolean[] visited = new boolean[tiles.length()+1];
        String s = "";
        for (int i = 0; i < tiles.length(); i++) visited[i] = false;
        gen(tiles, 0, sd, s);
        return sd.size();
    }

    public static void main(String[] args) {
        String tiles = "AAB";
        System.out.print(numTilePossibilities(tiles));
    }
}
