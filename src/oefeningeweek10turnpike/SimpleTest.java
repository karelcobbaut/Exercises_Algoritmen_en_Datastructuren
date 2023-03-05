package oefeningeweek10turnpike;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Collections;


public class SimpleTest {

    private static Turnpike turnpike;

    @BeforeClass
    public static void init() {
        turnpike = new RecursiveTurnpike();
    }

    @Test
    public void testTwoPoints() {
        Set<Integer> points = new HashSet<>(Arrays.asList(0, 3));

        Map<Integer, Long> distances = turnpike.pointsToDistances(
                Collections.unmodifiableSet(points));
        Assert.assertNotNull(distances);
        Assert.assertEquals(1, distances.size());
        Assert.assertEquals(1L, distances.get(3).longValue());

        Set<Integer> npoints = turnpike.distancesToPoints(
                Collections.unmodifiableMap(distances));
        Assert.assertEquals(points, npoints);
    }

    @Test
    public void testEmpty() {
        Set<Integer> points = Collections.singleton(0);

        Map<Integer, Long> distances = turnpike.pointsToDistances(points);
        Assert.assertNotNull(distances);
        Assert.assertTrue(distances.isEmpty());

        Set<Integer> npoints = turnpike.distancesToPoints(distances);
        Assert.assertEquals(points, npoints);
    }


    @Test
    public void testThreePoints() {
        Set<Integer> points = new HashSet<>(Arrays.asList(0, 2, 4));

        Map<Integer, Long> distances = turnpike.pointsToDistances(points);
        Assert.assertNotNull(distances);
        Assert.assertEquals(2, distances.size());
        Assert.assertEquals(2L, distances.get(2).longValue());
        Assert.assertEquals(1L, distances.get(4).longValue());

        Set<Integer> npoints = turnpike.distancesToPoints(distances);
        Assert.assertEquals(points, npoints);
    }

    @Test
    public void testFourPoints() {
        Set<Integer> points = new HashSet<>(Arrays.asList(0, 3, 6, 8));
        //Set<Integer> points = new HashSet<>(Arrays.asList(0, 2, 5, 8));

        Map<Integer, Long> distances = turnpike.pointsToDistances(points);
        Assert.assertNotNull(distances);
        Assert.assertEquals(5, distances.size());
        Assert.assertEquals(1L, distances.get(2).longValue());
        Assert.assertEquals(2L, distances.get(3).longValue());
        Assert.assertEquals(1L, distances.get(5).longValue());
        Assert.assertEquals(1L, distances.get(6).longValue());
        Assert.assertEquals(1L, distances.get(8).longValue());

        Map<Integer, Long> distancesCopy = new HashMap<>(distances);

        Set<Integer> npoints = turnpike.distancesToPoints(distancesCopy);

        Map<Integer, Long> ndistances = turnpike.pointsToDistances(npoints);

        Assert.assertEquals(distances, ndistances);
    }

    @Test
    public void testNoSolution() {
        Map<Integer, Long> distances = new HashMap<>();
        distances.put(5, 2L);
        distances.put(10, 2L);

        Assert.assertNull(turnpike.distancesToPoints(distances));
    }
    @Test
    public void testNoSolution2() {
        Set<Integer> points = new HashSet<>(Arrays.asList(0, 70, 71, 11, 12, 18, 85, 87, 88, 91, 27, 28, 94, 96, 35, 37, 101, 107, 45, 111, 50, 52, 54, 120, 126, 63));
        //System.out.println(points.size());
        Map<Integer, Long> distances = turnpike.pointsToDistances(points);
        //System.out.println(distances.size());
        Assert.assertEquals(points,turnpike.distancesToPoints(distances));
    }
    @Test
    public void testNoSolution3() {
        Set<Integer> points = new HashSet<>(Arrays.asList(0, 49, 51, 19, 3, 4, 7, 40, 46, 14, 31));
        Map<Integer, Long> distances = turnpike.pointsToDistances(points);
        //System.out.println(distances);
        Assert.assertEquals(points,turnpike.distancesToPoints(distances));
    }
    @Test
    public void testNoSolution4() {
        Set<Integer> points = new HashSet<>(Arrays.asList(0, 32, 3, 36, 5, 37, 40, 42, 43, 12, 45, 18, 50, 27));
        Map<Integer, Long> distances = turnpike.pointsToDistances(points);
        //System.out.println(distances);
        Assert.assertEquals(points,turnpike.distancesToPoints(distances));
    }

}
//         {1=4, 2=5, 3=3, 4=3, 5=3, 6=5, 7=6, 8=4, 9=7, 10=5, 11=4, 12=1, 13=5, 14=2, 15=6, 16=6, 17=9, 18=5, 19=6, 20=4, 21=2, 22=3, 23=4, 24=6, 25=6, 26=7, 27=3, 28=3, 29=1, 30=2, 31=3, 32=3, 33=6, 34=4, 35=7, 36=5, 37=4, 38=4, 39=3, 40=4, 41=4, 42=5, 43=4, 44=4, 45=2, 46=2, 47=1, 48=2, 49=3, 50=4, 51=4, 52=4, 53=3, 54=2, 55=2, 56=3, 57=5, 58=2, 59=6, 60=3, 61=3, 62=1, 63=3, 64=2, 66=4, 67=2, 68=2, 69=2, 70=4, 71=1, 72=2, 73=3, 74=4, 75=2, 76=5, 77=1, 78=1, 79=2, 80=2, 81=1, 82=1, 83=4, 84=2, 85=3, 87=1, 88=1, 89=3, 90=1, 91=2, 92=1, 93=2, 94=1, 95=1, 96=2, 98=1, 99=2, 100=1, 101=1, 102=1, 107=1, 108=2, 109=1, 111=1, 114=1, 115=1, 120=1, 126=1}
//         {1=4, 2=5, 3=3, 4=3, 5=3, 6=5, 7=6, 8=4, 9=7, 10=5, 11=4, 12=1, 13=5, 14=2, 15=6, 16=6, 17=9, 18=5, 19=6, 20=4, 21=2, 22=3, 23=4, 24=6, 25=6, 26=7, 27=3, 28=3, 29=1, 30=2, 31=3, 32=3, 33=6, 34=4, 35=7, 36=5, 37=4, 38=4, 39=3, 40=4, 41=4, 42=5, 43=4, 44=4, 45=2, 46=2, 47=1, 48=2, 49=3, 50=4, 51=4, 52=4, 53=3, 54=2, 55=2, 56=3, 57=5, 58=2, 59=6, 60=3, 61=3, 62=1, 63=3, 64=2, 66=4, 67=2, 68=2, 69=2, 70=4, 71=1, 72=2, 73=3, 74=4, 75=2, 76=5, 77=1, 78=1, 79=2, 80=2, 81=1, 82=1, 83=4, 84=2, 85=3, 87=1, 88=1, 89=3, 90=1, 91=2, 92=1, 93=2, 94=1, 95=1, 96=2, 98=1, 99=2, 100=1, 101=1, 102=1, 107=1, 108=2, 109=1, 111=1, 114=1, 115=1, 120=1, 126=1}