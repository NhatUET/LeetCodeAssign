public class thayAn {
    public static int hIndex(int n, int[] a) {
        int i = 0;
        int j = n - 1;
        for (int k = j; k >= 0; k--) {
            if (i < a[k]) {
                i++;
                i = Math.min(i, a[k]);
            }
        }
        return i;
    }
    public static void main(String[] args) {
        int[] a = {3,3,5,8,10};
        System.out.println(hIndex(5,a));
    }
}
