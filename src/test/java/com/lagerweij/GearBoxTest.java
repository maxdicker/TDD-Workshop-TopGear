package com.lagerweij;

import org.junit.Assert;
import org.junit.Test;

public class GearBoxTest {

    @Test
    public void lastReceivedRPMStartsAtZero() {
        GearBox testBox = new GearBox();
        Assert.assertEquals(0, testBox.getLastReceivedRPM());
    }
    //refactor to include new constant NEUTRAL
    //

    @Test
    public void currentGearStartsAtZero() {
        GearBox testBox = new GearBox();
        Assert.assertEquals(0, testBox.getCurrentGear());
    }

    @Test
    public void shiftsToFirstGear() {
        GearBox testBox = new GearBox();
        testBox.determineCurrentGearFrom(0);
        Assert.assertEquals(1, testBox.getCurrentGear());
    }

    @Test
    public void lastReceivedRPMIsLastInputRPM() {
        GearBox testBox = new GearBox();
        testBox.determineCurrentGearFrom(1);
        testBox.determineCurrentGearFrom(2001);
        Assert.assertEquals(2001, testBox.getLastReceivedRPM());
    }

    @Test
    public void shiftsUpFromFirstGearOverUpperThreshold() {
        GearBox testBox = createGearboxInFirstGear();
        testBox.determineCurrentGearFrom(2001);

        Assert.assertEquals(2, testBox.getCurrentGear());
    }

    @Test
    public void doesntShiftUpAtUpperThreshold() {
        GearBox testBox = createGearboxInFirstGear();
        testBox.determineCurrentGearFrom(2000);

        Assert.assertEquals(1, testBox.getCurrentGear());
    }

    @Test
    public void doesntShiftDownAtLowerThreshold() {
        GearBox testBox = createGearboxInFirstGear();
        testBox.determineCurrentGearFrom(2001);
        testBox.determineCurrentGearFrom(500);

        Assert.assertEquals(2, testBox.getCurrentGear());
    }

    @Test
    public void cantShiftToNeutralFromFirst() {
        GearBox testBox = createGearboxInFirstGear();
        testBox.determineCurrentGearFrom(499);

        Assert.assertEquals(1, testBox.getCurrentGear());
    }

    @Test
    public void shiftToFirstFromSecond() {
        GearBox testBox = createGearboxInFirstGear();
        testBox.determineCurrentGearFrom(2001);
        testBox.determineCurrentGearFrom(499);

        Assert.assertEquals(1, testBox.getCurrentGear());
    }

    @Test
    public void cantShiftAboveMaxGear() {
        GearBox testBox = createGearboxInFirstGear();
        for (int i = 0; i < testBox.getMaxGear(); i++) {
            testBox.determineCurrentGearFrom(2001);
        }

        Assert.assertEquals(testBox.getMaxGear(), testBox.getCurrentGear());

    }

    private GearBox createGearboxInFirstGear() {
        GearBox testBox = new GearBox();
        testBox.determineCurrentGearFrom(0);
        return testBox;
    }
}
