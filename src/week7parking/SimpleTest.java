package week7parking;

import java.util.Arrays;

import org.junit.Test;
import org.junit.Assert;

public class SimpleTest {

    ParkingSimulator simulator = new QueueParkingSimulator();

    @Test
    public void testNoCars() {
        Assert.assertEquals(0, simulator.simulate(1, 1, Arrays.asList()));
    }

    @Test
    public void testOneCar() {
        Assert.assertEquals(10, simulator.simulate(1, 1, Arrays.asList(
            new Event(0, true, 10)
        )));
    }

    @Test
    public void testTwoConsecutiveCars() {
        Assert.assertEquals(20, simulator.simulate(1, 1, Arrays.asList(
            new Event(0, true, 10),
            new Event(10, true, 10)
        )));
    }

    @Test
    public void testCarInBetween() {
        Assert.assertEquals(10, simulator.simulate(2, 1, Arrays.asList(
                new Event(0, true, 10),
                new Event(2, true, 5)
        )));
    }

    @Test
    public void testTwoSeparateCars() {
        Assert.assertEquals(25, simulator.simulate(1, 1, Arrays.asList(
            new Event(0, true, 10),
            new Event(15, true, 10)
        )));
    }

    @Test
    public void testTwoSimultanousCarsOneSpotImmediateReturn() {
        Assert.assertEquals(20, simulator.simulate(1, 1, Arrays.asList(
            new Event(0, true, 10),
            new Event(0, true, 10)
        )));
    }

    @Test
    public void testTwoSimultanousCarsOneSpotLateReturn() {
        Assert.assertEquals(24, simulator.simulate(1, 7, Arrays.asList(
            new Event(0, true, 10),
            new Event(0, true, 10)
        )));
    }

    @Test
    public void testTwoSimultanousCarsTwoSpots() {
        Assert.assertEquals(10, simulator.simulate(2, 1, Arrays.asList(
            new Event(0, true, 10),
            new Event(0, true, 10)
        )));
    }

    @Test
    public void testTwoSimultanousCarsTwoSpotsOneLate() {
        Assert.assertEquals(15, simulator.simulate(2, 1, Arrays.asList(
            new Event(0, true, 10),
            new Event(5, true, 10)
        )));
    }

    @Test
    public void testAmbiguous() {
        Assert.assertEquals(20, simulator.simulate(2, 1, Arrays.asList(
            new Event(0, true, 10),
            new Event(5, true, 5),
            new Event(10, true, 10),
            new Event(10, true, 5)
        )));
    }

    @Test
    public void testRaceCondition1() {
        Assert.assertEquals(30, simulator.simulate(1, 20, Arrays.asList(
                new Event(0, true, 10),
                new Event(0, true, 5)
        )));
    }

    @Test
    public void testRaceCondition2() {
        Assert.assertEquals(30, simulator.simulate(1, 20, Arrays.asList(
                new Event(0, true, 5),
                new Event(0, true, 10)
        )));
    }

    @Test
    public void testRaceCondition3() {
        Assert.assertEquals(35, simulator.simulate(1, 10, Arrays.asList(
                new Event(0, true, 15),
                new Event(0, true, 10),
                new Event(10,true,7)
        )));
    }
    @Test
    public void testRaceCondition4() {
        Assert.assertEquals(58, simulator.simulate(4, 7, Arrays.asList(
                new Event(13, true, 8), new Event(34, true, 10), new Event(25, true, 5), new Event(18, true, 19), new Event(43, true, 2), new Event(2, true, 16), new Event(42, true, 16), new Event(32, true, 16), new Event(20, true, 3), new Event(9, true, 0)
        )));
    }
}
