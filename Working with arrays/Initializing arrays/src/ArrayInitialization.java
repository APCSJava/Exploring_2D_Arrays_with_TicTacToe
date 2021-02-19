public class ArrayInitialization {

    private int[][] nums;

    /* initializes a two dimensional array of default values */
    public ArrayInitialization(int numRows, int numColumns) {
        nums = new int[numRows][numColumns];
    }

    /* uses an array initializer to set the contents of a 3x4 array */
    public ArrayInitialization() {
        nums = new int[][]{{1, 2, 3, 4}, {4, 5, 6, 7}, {7, 8, 9, 10}};
    }

    /* illustrates important expressions regarding arrays and their notation */
    public void expressions() {
        int[][] copy = nums; // an alias is created to the array nums and assigned to copy
        int[] firstRow = nums[0]; // referring to the outer dimension (a row -- row 0)
        int value = nums[0][1]; // referring to the element in first row, second column

        int numRows = nums.length; // the outer dimension is the number of rows
        int numCols = nums[0].length; // the length of 'a row' is the number of columns
    }

    public static int[][] createJaggedArray() {
        int[][] arr;
        int[] firstRow = {1, 2, 3, 4}; // four columns
        int[] secondRow = {5, 6, 7}; // three columns
        int[] thirdRow = {8, 9, 10, 11, 12}; // five columns
        arr = new int[][]{firstRow, secondRow, thirdRow}; // all happily co-existing

        /* insert a breakpoint here and examine the jagged array */
        int[] first = arr[0]; // a row referencing the array [1, 2, 3, 4]
        int[] middle = arr[1]; // a row referencing the array [5, 6, 7]

        int numRows = arr.length; // 3, because there are three rows
        int numColumns = arr[2].length; // 5, because arr[2] points to an array with 5 values
        return arr;
    }

    public static void main(String[] args) {
        /* yse the debugger to step through and examine the results */
        ArrayInitialization a1 = new ArrayInitialization(); // examine nums
        ArrayInitialization a2 = new ArrayInitialization(2, 3); // examine nums
        int[][] jagged = createJaggedArray();
        System.out.println("Check - did you use debug mode or just click 'Run'?");
    }
}