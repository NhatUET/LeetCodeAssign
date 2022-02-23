import java.util.*;

public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;

        int maxWater = 0;
        while (i < j) {
            maxWater = Math.max(maxWater, Math.min(height[i], height[j]) * (j - i));
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxWater;
    }

    public static void main(String[] args) {
        int[] a = {1,8,6,2,5,4,8,3,7};
        System.out.print(maxArea(a));
    }
}
