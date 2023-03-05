package week4inversie;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import week4inversie.InversionCounter;


public class SimpleTest {

    private static InversionCounter m = new MyInversionCounter();
    @BeforeClass
    public static void init() {
        m = new MyInversionCounter();
    }

    @Test
    public void test1() {
                //            1+2
         //                          1
                //             0   0     0           2+1+1
                          //  2,4   3   1,5
                          //  2,4   3,1,5
        int[] rij = new int[] {2,4,3,1,5};       //3+1        //1+ 2+1
        Assert.assertEquals(4, m.countInversions(rij));
    }

    @Test
    public void test2() {
        int[] rij = new int[] {0,1,2,3,4,5,6,7,8,9,10};
        Assert.assertEquals(0, m.countInversions(rij));        //30             ->1+9+15+30=55
                                                        //     6                9
    }                                                   // 1       3         3      3
    @Test                                               //10,9   8,7,6     5,4,3  2,1,0
    public void test3() {                                 //10,9   8,7,6     5,4,3  2,1,0
        int[] rij = new int[] {10,9,8,7,6,5,4,3,2,1,0};   //10,9,8,7,6     5,4,3,2,1,0
        Assert.assertEquals(55, m.countInversions(rij));
    }
    //[16, 19, 36, 7, 74, 91, 12, 77, 62, 46]) == 16]
    @Test                                               //10,9   8,7,6     5,4,3  2,1,0
    public void test4() {                                 //10,9   8,7,6     5,4,3  2,1,0
        int[] rij = new int[] {16, 19, 36, 7, 74, 91, 12, 77, 62, 46};   //10,9,8,7,6     5,4,3,2,1,0
        Assert.assertEquals(16, m.countInversions(rij));
    }

}
