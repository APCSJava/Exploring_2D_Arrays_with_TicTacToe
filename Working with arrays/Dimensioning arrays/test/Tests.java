import org.junit.Assert;
import org.junit.Test;

public class Tests {
    @Test
    public void testWideArraySmallLarge() {
        FourArrays f = new FourArrays(3, 7);
        String feedback = "(3, 7) The wide array should have 3 rows and 7 columns";
        Assert.assertEquals(feedback, 3, f.getWide().length);
        Assert.assertEquals(feedback, 7, f.getWide()[0].length);
    }

    @Test
    public void testWideArrayLargeSmall() {
        FourArrays f = new FourArrays(5, 4);
        String feedback = "(5, 4) The wide array should have 4 rows and 5 columns";
        Assert.assertEquals(feedback, 4, f.getWide().length);
        Assert.assertEquals(feedback, 5, f.getWide()[0].length);
    }

    @Test
    public void testTallArraySmallLarge() {
        FourArrays f = new FourArrays(1, 6);
        String feedback = "(1, 6) The tall array should have 6 rows and 1 columns";
        Assert.assertEquals(feedback, 6, f.getTall().length);
        Assert.assertEquals(feedback, 1, f.getTall()[0].length);
    }

    @Test
    public void testTallArrayLargeSmall() {
        FourArrays f = new FourArrays(2, 1);
        String feedback = "(2, 1) The tall array should have 2 rows and 1 column";
        Assert.assertEquals(feedback, 2, f.getTall().length);
        Assert.assertEquals(feedback, 1, f.getTall()[0].length);
    }

    @Test
    public void testLargeArraySmallLarge() {
        FourArrays f = new FourArrays(4, 12);
        String feedback = "(4, 12) The large array should have 12 rows and 12 columns";
        Assert.assertEquals(feedback, 12, f.getLarge().length);
        Assert.assertEquals(feedback, 12, f.getLarge()[0].length);
    }

    @Test
    public void testLargeArrayLargeSmall() {
        FourArrays f = new FourArrays(9, 2);
        String feedback = "(9, 2) The large array should have 9 rows and 9 columns";
        Assert.assertEquals(feedback, 9, f.getLarge().length);
        Assert.assertEquals(feedback, 9, f.getLarge()[0].length);
    }

    @Test
    public void testSmallArraySmallLarge() {
        FourArrays f = new FourArrays(2, 7);
        String feedback = "(2, 7) The small array should have 2 rows and 2 columns";
        Assert.assertEquals(feedback, 2, f.getSmall().length);
        Assert.assertEquals(feedback, 2, f.getSmall()[0].length);
    }

    @Test
    public void testSmallArrayLargeSmall() {
        FourArrays f = new FourArrays(6, 3);
        String feedback = "(6, 3) The small array should have 3 rows and 3 columns";
        Assert.assertEquals(feedback, 3, f.getSmall().length);
        Assert.assertEquals(feedback, 3, f.getSmall()[0].length);
    }

    @Test
    public void testZeroesAllowed() {
        FourArrays f = new FourArrays(0, 0);
        String feedback = "Array dimensions can be initialized to 0";
        // test one, arbitrarily
        Assert.assertEquals(feedback, 0, f.getSmall().length);
    }
}