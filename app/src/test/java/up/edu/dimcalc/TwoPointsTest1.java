package up.edu.dimcalc;

import android.graphics.Point;

import junit.framework.TestCase;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by massad18 on 11/9/2016.
 */
public class TwoPointsTest1 extends TestCase {

    @Test
    /** when created, getPoint() should show both points at the origin */
    public void testGetPoint() throws Exception {
        TwoPoints testPoints = new TwoPoints();
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);
        assertEquals(p1.x, 0);
        assertEquals(p1.y, 0);
        assertEquals(p2.x, 0);
        assertEquals(p2.y, 0);
    }

    @Test
    /** verify that arbitrary values are properly stored via setPoint() */
    public void testSetPoint() throws Exception {
        TwoPoints testPoints = new TwoPoints();
        testPoints.setPoint(0, 5, -3);
        testPoints.setPoint(1, -3, 5);
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);
        assertEquals(p1.x, 5);
        assertEquals(p1.y, -3);
        assertEquals(p2.x, -3);
        assertEquals(p2.y, 5);
    }

    @Test
    public void testRandomValue() throws Exception {
        TwoPoints testPoints = new TwoPoints();
        testPoints.setPoint(1, 0, 4);
        testPoints.randomValue(1);
        Point p1 = testPoints.getPoint(1);
        assertTrue("testRandomValue", p1.x < 10 && p1.x >= -10 && p1.y < 10 && p1.y >= -10);
    }

    @Test
    public void testSetOrigin() throws Exception {
        TwoPoints testPoints = new TwoPoints();
        testPoints.setPoint(0, 3, 0);
        testPoints.setOrigin(0);
        Point p1 = testPoints.getPoint(0);
        assertTrue("testSetOrigin", p1.x == 0 && p1.y == 0);
    }

    @Test
    public void testCopy() throws Exception {
        TwoPoints testPoints = new TwoPoints();
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);
        testPoints.setPoint(0, 3, 0);
        testPoints.setPoint(1, 0, 4);
        testPoints.copy(0,1);
        assertEquals(p1.x, p2.x);
        assertEquals(p1.y, p2.y);
    }

    @Test
    public void testDistance() throws Exception {
        TwoPoints testPoints = new TwoPoints();
        testPoints.setPoint(0, 3, 0);
        testPoints.setPoint(1, 0, 4);
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);
        assertTrue("testDistance", testPoints.distance() == 5);
    }

    @Test
    public void testSlope() throws Exception {
        TwoPoints testPoints = new TwoPoints();
        testPoints.setPoint(0, 3, 0);
        testPoints.setPoint(1, 0, 4);
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);
        assertTrue("testSlope", testPoints.slope() == -4/3);
    }
}