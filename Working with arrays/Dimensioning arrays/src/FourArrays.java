public class FourArrays {

    private char[][] wide;
    private int[][] tall;
    private boolean[][] large;
    private String[][] small;

    /**
     * Initializes the four arrays, as described.
     * @param a a non-negative integer
     * @param b a non-negative integer
     */
    public FourArrays(int a, int b) {
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        wide = new char[min][max];
        tall = new int[max][min];
        large = new boolean[max][max];
        small = new String[min][min];
    }

    public char[][] getWide() {
        return wide;
    }

    public int[][] getTall() {
        return tall;
    }

    public boolean[][] getLarge() {
        return large;
    }

    public String[][] getSmall() {
        return small;
    }
}