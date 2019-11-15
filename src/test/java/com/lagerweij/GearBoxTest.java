package com.lagerweij;

import org.junit.Assert;
import org.junit.Test;

public class GearBoxTest {

    @Test
    public void lastReceivedRPMStartsAtZero() {
        GearBox testBox = new GearBox();
        Assert.assertEquals(0, testBox.getLastReceivedRPM());
    }

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
    public void lastReceivedRPMEqualsInputOnLastDetermineCurrentGearFromRpm() {
        GearBox testBox = new GearBox();
        testBox.determineCurrentGearFrom(8057);
        testBox.determineCurrentGearFrom(2001);
        Assert.assertEquals(2001, testBox.getLastReceivedRPM());
    }

    @Test
    public void shiftsUpFromFirstGear() {
        GearBox testBox = new GearBox();
        testBox.determineCurrentGearFrom(0);
        testBox.determineCurrentGearFrom(2001);

        Assert.assertEquals(2, testBox.getCurrentGear());
    }

}
