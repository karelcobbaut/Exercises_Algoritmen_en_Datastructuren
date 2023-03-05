package oefeningenweek10subset;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SimpleTest {

    public static SubsetSum sss;

    @BeforeClass
    public static void init() {
        sss = new RecursiveSubsetSum();
    }

    @Test
    public void test1() {
        Assert.assertEquals(
            Arrays.asList(false, false, false, true, true),
            sss.subsetSum(Arrays.asList(12, 10, 2, 7, 4), 11)
        );
    }

    @Test
    public void test2() {
        Assert.assertNull(sss.subsetSum(Arrays.asList(15, 12, 3, 8, 7), 9));
    }

    @Test
    public void test3() {
        Assert.assertEquals(
            Arrays.asList(false, true, false, false, false),
            sss.subsetSum(Arrays.asList(15, 12, 3, 7, 7), 12)
        );
    }

    @Test
    public void test4() {
        List<Boolean> result = sss.subsetSum(Arrays.asList(4, 7, 1, 8, 17, 1, 8), 10);

        Assert.assertTrue(result.equals(Arrays.asList(false, false, true, true, false, true, false)) ||
                result.equals(Arrays.asList(false, false, true, false, false, true, true)));
    }
    
}
