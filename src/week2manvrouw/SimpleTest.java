package week2manvrouw;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SimpleTest {

    private DatingService service;

    @Before
    public void initialize() {
        service = new StableDatingService();
    }

    @Test
    public void test1() {
        int[][] men = {
                {1,0,2,3},
                {3,0,1,2},
                {0,2,1,3},
                {1,2,0,3}
        };
        int[][] women = {
                {0,2,1,3},
                {2,3,0,1},
                {3,1,2,0},
                {2,1,0,3}
        };
        Assert.assertArrayEquals(
                new int[]{0,3,2,1},
                service.match(men, women)
        );
    }

    @Test
    public void test2() {
        int[][] men = {
                {0,2,1},
                {1,0,2},
                {1,2,0}
        };
        int[][] women = {
                {2,1,0},
                {2,1,0},
                {1,2,0}
        };
        Assert.assertArrayEquals(
                new int[]{2,0,1},
                service.match(men, women)
        );
    }

    @Test
    public void test3() {
        int[][] men = {
                {0,2,1,3},
                {2,1,3,0},
                {0,3,1,2},
                {1,2,0,3}
        };
        int[][] women = {
                {1,0,2,3},
                {0,2,3,1},
                {3,0,1,2},
                {1,3,2,0}
        };
        Assert.assertArrayEquals(
                new int[]{0,2,3,1},
                service.match(men, women)
        );
    }
    
    @Test
    public void test4() {
        int[][] men = {
                {0,2,1,3},
                {2,1,3,0},
                {3,0,1,2},
                {1,2,0,3}
        };
        int[][] women = {
                {1,0,2,3},
                {0,2,3,1},
                {3,0,1,2},
                {2,3,1,0}
        };
        Assert.assertArrayEquals(
                new int[]{0,2,3,1},
                service.match(men, women)
        );
    }

}
