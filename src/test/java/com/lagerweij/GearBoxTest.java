package com.lagerweij;

import org.junit.Assert;
import org.junit.Test;

public class GearBoxTest {

    @Test
    public void eStartsAtZero() {
        GearBox testBox = new GearBox();
        Assert.assertEquals(0, testBox.getE());
    }

    @Test
    public void currentGearStartsAtZero() {
        GearBox testBox = new GearBox();
        Assert.assertEquals(0, testBox.getCurrentGear());
    }

    @Test
    public void currentGearIsOneAfterDoit() {
        GearBox testBox = new GearBox();
        testBox.doit(0);
        Assert.assertEquals(1, testBox.getCurrentGear());
    }


}
